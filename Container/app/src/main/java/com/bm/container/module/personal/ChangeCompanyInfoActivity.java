package com.bm.container.module.personal;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.Tools.Verify;
import com.bm.container.constants.ConstantsTag;
import com.bm.container.databinding.ActivityChangeCompanyInfoBinding;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.base.Entity.CityEntity;
import com.bm.container.module.login.CityActivity;
import com.bm.container.module.login.adapter.CityGridViewAdapter;
import com.bm.container.view.PickerDialog;
import com.bumptech.glide.Glide;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * P7_1 修改公司信息(公司)
 */
public class ChangeCompanyInfoActivity extends BaseActivity {
    private ActivityChangeCompanyInfoBinding binding;
    private Context context;
    private Boolean[] canDelete = {false};
    private CityGridViewAdapter adapter;
    private List<String> col = new ArrayList<>();
    private ArrayList<String> ids = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //收起键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_change_company_info);
        context = this;
        setTopbar();
        setLoading();
        selecetBank();
        setCity();
        setAddCity();
        setSend();
        getFace();
        getInfo();
    }


    /**
     * 选择开户支行
     */
    private void selecetBank() {

        binding.bank.setOnClickListener(v -> {
            ArrayList<String> banks = new ArrayList<>();
            Collections.addAll(banks, ConstantsTag.bankName);
            PickerDialog picker = new PickerDialog.Builder(ChangeCompanyInfoActivity.this)//
                    .setData(banks)
                    .setCancel((mdialog, which) -> mdialog.dismiss())
                    .setSure((mdialog, which) -> {
                        mdialog.dismiss();
                        binding.bank.setText(banks.get(which));
                    })
                    .create();
            picker.show();
        });

    }

    /**
     * 信息获取
     */
    private void getInfo() {
        Collection.userInfo(this, baseBean -> {
            Glide.with(context).load(Block.resolvePic(baseBean.getData().getImageUrl())).placeholder(R.drawable.face).dontAnimate().into(binding.face);
            Block.setEditText(binding.name, baseBean.getData().getCompanyName());
            Block.setEditText(binding.phone, baseBean.getData().getCompanyTelephone());
            Block.setEditText(binding.address, baseBean.getData().getCompanyAddress());
            Block.setEditText(binding.person, baseBean.getData().getCompanyPerson());
            Block.setEditText(binding.bankName, baseBean.getData().getAccountName());
            Block.setText(binding.bank, baseBean.getData().getAccountSource(), getString(R.string.change_personal_info_bank_hint_two));
            Block.setEditText(binding.bankId, baseBean.getData().getBankAccount());
            if (baseBean.getData().getAccountName().isEmpty()
//                    && baseBean.getData().getAccountSource().isEmpty()
                    && baseBean.getData().getBankAccount().isEmpty()) {
                binding.modelBank.setVisibility(View.GONE);
            } else {
                binding.modelBank.setVisibility(View.VISIBLE);
            }

            String cityString = baseBean.getData().getCitiesName();
            if (!cityString.isEmpty()) {
                String[] block = cityString.split("\\\"cityName\\\":\\\"");
                for (int i = 1; i < block.length; i++) {
                    col.add(block[i].split("\\\",\\\"id\\\":")[0]);
                    ids.add(block[i].split("\\\",\\\"id\\\":")[1].split(",\\\"provinceName\\\":\\\"")[0]);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * 头像获取
     */
    private void getFace() {
        binding.face.setOnClickListener(v -> {
            Block.getPic((ChangeCompanyInfoActivity) context, 1);
        });
    }

    /**
     * 发送
     */
    private void setSend() {

        binding.bankId.setPattern(new int[]{4, 4, 4, 4, 3});
        binding.bankId.setSeparator(" ");
        binding.bankId.setCustomizeMarkerEnable(false);

        binding.register.setOnClickListener(v -> {
            if (Verify.changeCompanyInfo(binding.name, binding.phone, binding.address, binding.person, binding.bankName, binding.bank, binding.bankId, col)) {
                String idString = "";
                for (String id : ids) {
                    idString += (id + ",");
                }

                if (!TextUtils.isEmpty(idString)) {
                    idString.substring(0, idString.length() - 1);
                }

                Collection.changeCompanyInfo(ChangeCompanyInfoActivity.this, binding.name.getText().toString(),
                        binding.phone.getText().toString(),
                        binding.address.getText().toString(),
                        binding.person.getText().toString(),
                        binding.bankName.getText().toString(),
                        binding.bank.getText().toString(),
                        binding.bankId.getText().toString(),
                        idString, baseBean -> {
                            dialogFinish("修改成功");
                        });
            }
        });
    }

    /**
     * 添加城市
     */
    private void setAddCity() {
        binding.add.setOnClickListener(view -> {
            Intent i = new Intent(context, CityActivity.class);
            if (null != col && col.size() > 0) {
                i.putExtra("cityNameList", (Serializable) col);
            }
            startAcForResult(i, 100);
        });
    }

    /**
     * 设定城市
     */
    private void setCity() {
        adapter = new CityGridViewAdapter(this, col, canDelete);
        adapter.setDeleteCity(position -> {
            col.remove(position);
            ids.remove(position);
            adapter.notifyDataSetChanged();
        });
        binding.gridview.setAdapter(adapter);
        binding.delete.setOnClickListener(view -> {
            if (col.size() != 0) {
                canDelete[0] = !canDelete[0];
                adapter.notifyDataSetChanged();
            } else {
                toast("您还没添加城市,不可删除");
            }
        });
    }

    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(false);
        binding.refresh.setColorSchemeColors(loadingColors);
    }

    private void setTopbar() {
        binding.topbar.toolbar.setTitle("");
        binding.topbar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        binding.topbar.title.setText(R.string.change_company_info_title);
        setSupportActionBar(binding.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }

    /**
     * 图片压缩和城市选择
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200) {
            showLoading();
            List<File> pics = Block.resolvePic(this, requestCode, resultCode, data, files -> {
                Log.e("压缩", "成功了！");
                Collection.uploadFace(ChangeCompanyInfoActivity.this, files, baseBean -> {
                    Glide.with(ChangeCompanyInfoActivity.this).load(files.get(0)).placeholder(R.drawable.face).dontAnimate().into(binding.face);
                    toast("头像已更新");
                });
            }, throwable -> {
                Log.e("压缩失败", "压缩失败");
                hideLoading();
            });
        } else {
            if (requestCode == 100 && resultCode == 10) {
                canDelete[0] = false;
//			col.add(data.getExtras().getString("city"));
//			ids.add(data.getExtras().getString("id"));
                ArrayList<CityEntity> selectedCitys = (ArrayList<CityEntity>) data.getExtras().getSerializable("selectedCitys");
                if (null != selectedCitys && selectedCitys.size() > 0) {
                    for (int i = 0; i < selectedCitys.size(); i++) {
                        col.add(selectedCitys.get(i).getCityName());
                        ids.add(selectedCitys.get(i).getId());
                    }
                }
                adapter.notifyDataSetChanged();
            } else {
                canDelete[0] = false;
                adapter.notifyDataSetChanged();
            }
        }
    }
}
