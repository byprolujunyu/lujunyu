package com.bm.container.module.discuss;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.Tools.SpUtil;
import com.bm.container.databinding.FragmentDiscussBinding;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseFragment;
import com.bm.container.module.base.MainActivity;
import com.bm.container.module.base.WebActivity;
import com.bm.container.module.discuss.adapter.DiscussAdapter;
import com.bm.container.module.discuss.adapter.DiscussRecyclerAdapter;
import com.bm.container.module.discuss.bean.BannerBean;
import com.bm.container.module.discuss.bean.DiscussListBean;
import com.bm.container.view.OptionButtonDialog;
import com.bumptech.glide.Glide;
import com.flyco.tablayout.CommonTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 碎片页 P4首页
 */

public class DiscussFragment extends BaseFragment {
    private FragmentDiscussBinding binding;
    private Context context;
    private DiscussRecyclerAdapter adapter;
    private ArrayList<DiscussListBean.DataBean> col = new ArrayList<>();
    private List<BannerBean.DataBean> bannerCol = new ArrayList<>();
    private int page = 1;
    private String id = "";
    private String targetId = "";
    private String targetName = "";
    private Boolean isEnd = false;

    private CommonTabLayout layout;

    public static DiscussFragment getInstance(CommonTabLayout layout) {
        DiscussFragment fragment = new DiscussFragment();
        fragment.layout = layout;
        return fragment;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            if (col.size() == 0) {
                page = 1;
                getBanner();
                getList(page);

            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!isHidden() && !SpUtil.getBoolean(SpUtil.DONTNEEDREFRESH, false)) {
            page = 1;
            getBanner();
            getList(page);
        }
        SpUtil.setBoolean(SpUtil.DONTNEEDREFRESH, false);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_discuss, container, false);
        context = getActivity();

        setTopbar();
        setLoading();
        setList();
        setReply();
        setRefresh();

        View view = binding.getRoot();
        view.setClickable(true);
        return binding.getRoot();
    }

    private void getBanner() {
        Collection.banner(this, bannerBean -> {
            bannerCol.clear();
            bannerCol.addAll(bannerBean.getData());
            adapter.notifyDataSetChanged();
        });
    }

    private void setRefresh() {
        binding.refresh.setOnRefreshListener(() -> {
            isEnd = false;
            page = 1;
            getBanner();
            getList(page);
            binding.refresh.setRefreshing(false);
        });
        binding.list.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (!binding.list.canScrollVertically(1) && !isEnd) {// 手指不能向上滑动了
                    // TODO 这里有个注意的地方，如果你刚进来时没有数据，但是设置了适配器，这个时候就会触发加载更多，需要开发者判断下是否有数据，如果有数据才去加载更多。
//					binding.refresh.setRefreshing(true);
//					binding.refresh.postDelayed(() -> binding.refresh.setRefreshing(false), 2000);
                    page++;
                    getList(page);
                }
            }
        });
    }

    private void setReply() {
        binding.replyEmpty.setOnClickListener(v -> {
            binding.reply.setText("");
            binding.reply.setHint("");
            binding.modelReply.setVisibility(View.GONE);
        });
        binding.send.setOnClickListener(v -> {
            if (binding.reply.getText().toString().isEmpty()) {
                toast("请输入内容");
            } else {
                Collection.reply((MainActivity) context, id, targetId, targetName, binding.reply.getText().toString(), baseBean -> {
                    binding.reply.setText("");
                    binding.reply.setHint("");
                    binding.modelReply.setVisibility(View.GONE);
                    page = 1;
                    getList(page);
                    dialog("评论成功");
                });
            }
        });
    }

    private void setList() {
        binding.list.setLayoutManager(new LinearLayoutManager(context));
        adapter = new DiscussRecyclerAdapter(context, col, bannerCol, true);
        adapter.setReplyCallback(new DiscussAdapter.ReplyCallback() {
            @Override
            public void reply(String id1, String targetId1, String targetName1, String careteUser) {

                String userId = SpUtil.getString(SpUtil.USERID);
                if (!TextUtils.isEmpty(userId) && userId.equals(careteUser)) {
                    Toast.makeText(context, "自己不能回复自己!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (Block.checkLogin((MainActivity) context)) {
                    id = id1;
                    targetId = targetId1;
                    targetName = targetName1;
                    binding.reply.setText("");
                    if (!targetId.isEmpty()) {
                        binding.reply.setHint("回复: " + targetName1);
                    } else {
                        binding.reply.setHint("");
                    }
                    binding.modelReply.setVisibility(View.VISIBLE);
                    //让输入框获取焦点
                    binding.reply.setFocusable(true);
                    binding.reply.setFocusableInTouchMode(true);
                    binding.reply.requestFocus();
                    //弹出软键盘
                    InputMethodManager imm = (InputMethodManager) DiscussFragment.this.getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
        });
        adapter.setZanCallback((id12, position, wantToZan) -> {
            if (Block.checkLogin((MainActivity) context)) {
                if (wantToZan) {
                    Collection.zan((MainActivity) context, id12, baseBean -> {
                        col.get(position).setIsZan("1");
                        col.get(position).setZanCount(Block.zanAdd(col.get(position).getZanCount()));
                        adapter.notifyDataSetChanged();
                    });
                } else {
                    Collection.zanCancel((MainActivity) context, id12, baseBean -> {
                        col.get(position).setIsZan("0");
                        col.get(position).setZanCount(Block.zanDelete(col.get(position).getZanCount()));
                        adapter.notifyDataSetChanged();
                    });
                }
            }
        });
        binding.list.setAdapter(adapter);
    }


    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(true);
        binding.refresh.setColorSchemeColors(loadingColors);
    }

    private void setTopbar() {
        binding.topbar.rightModel.setVisibility(View.VISIBLE);
        binding.topbar.rightIcon.setImageResource(R.drawable.write);
        binding.topbar.rightPoint.setVisibility(View.INVISIBLE);
        binding.topbar.rightText.setVisibility(View.GONE);
        binding.topbar.title.setText(R.string.discuss_title);
        binding.topbar.rightModel.setOnClickListener(view -> {
            if (Block.checkLogin((MainActivity) context)) {
                OptionButtonDialog alert = new OptionButtonDialog.Builder(context)// builder
                        .setLevel1("图文", (dialogInterface, i) -> {
                            dialogInterface.dismiss();
                            Intent intent = new Intent(context, SendImageActivity.class);
                            startAc(intent);
                        })
                        .setLevel2("纯文字", (dialogInterface, i) -> {
                            dialogInterface.dismiss();
                            Intent intent = new Intent(context, SendTextActivity.class);
                            startAc(intent);
                        })
                        .setLevel3("取消", (dialogInterface, i) -> {
                            dialogInterface.dismiss();
                        })
                        .create();
                alert.show();
            }
        });
    }

    public class BannerHolder implements Holder<BannerBean.DataBean> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, BannerBean.DataBean data) {
            Glide.with(context).load(Block.resolvePic(data.getImageUrl())).placeholder(R.drawable.banner0).dontAnimate().into(imageView);
            imageView.setOnClickListener(v -> {
                Intent i = new Intent(context, WebActivity.class);
                i.putExtra("url", data.getLinkedUrl());
                startAc(i);
            });
        }
    }

    private void getList(int page) {
        Collection.discussList(this, page, bean -> {
            if (page == 1) {
                col.clear();
            }
            if (bean.getData().size() == 0) {
                isEnd = true;
            } else {
                col.addAll(bean.getData());
                adapter.notifyDataSetChanged();
            }
        });
    }

}
