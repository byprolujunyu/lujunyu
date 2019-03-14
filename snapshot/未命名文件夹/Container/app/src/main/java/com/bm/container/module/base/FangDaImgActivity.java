package com.bm.container.module.base;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.module.BaseActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nfmomo
 * <p>
 * 图片放大
 */
public class FangDaImgActivity extends BaseActivity implements OnPageChangeListener {
    private List<View> imageViewList;
    private ViewPager vp_fangda;
    private TextView tv_fangda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fangdaimg);
        vp_fangda = (ViewPager) findViewById(R.id.vp_fangda);
        tv_fangda = (TextView) findViewById(R.id.tv_fangda);
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        // TODO Auto-generated method stub

        Bundle extras = getIntent().getExtras();
        int position = extras.getInt("pic_position");
        String[] img_urls = extras.getStringArray("img");
        imageViewList = new ArrayList<View>();
        if (img_urls[0].equals("")) {
            return;
        } else {
            for (int i = 0; i < img_urls.length; i++) {

                LinearLayout ll = new LinearLayout(FangDaImgActivity.this);

                ll.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

                ScrollView sv = new ScrollView(FangDaImgActivity.this);

                LinearLayout.LayoutParams lllp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

                lllp.gravity = Gravity.CENTER;

                sv.setLayoutParams(lllp);

                ImageView imageView = new ImageView(FangDaImgActivity.this);

                ScrollView.LayoutParams lp = new ScrollView.LayoutParams(LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT);

//				lp.gravity = Gravity.CENTER_VERTICAL;

                imageView.setLayoutParams(lp);

                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

                imageView.setAdjustViewBounds(true);

                sv.addView(imageView);

                ll.addView(sv);

                Glide.with(this).load(Block.resolvePic(img_urls[i])).placeholder(R.drawable.ic_default_image).dontAnimate().into(imageView);
                imageView.setOnClickListener(new MyOnClickListener());
                imageViewList.add(ll);
            }
        }
        tv_fangda.setText(1 + "/" + imageViewList.size());
        MyPagerAdapter mAdapter = new MyPagerAdapter();
        vp_fangda.setAdapter(mAdapter);
        vp_fangda.setOnPageChangeListener(this);
        // int picPosition = getIntent().getExtras().getInt("pic_position");
        vp_fangda.setCurrentItem(position);

    }

    class MyOnClickListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            finish();
        }

    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageViewList != null ? imageViewList.size() : 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView(imageViewList.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            LinearLayout sv = (LinearLayout) imageViewList.get(position);
            container.addView(sv);
            return sv;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        tv_fangda.setText((position + 1) + "/" + imageViewList.size());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
