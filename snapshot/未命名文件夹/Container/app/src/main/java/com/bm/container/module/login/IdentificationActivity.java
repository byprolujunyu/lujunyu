package com.bm.container.module.login;

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
import com.bm.container.databinding.ActivityIdentificationBinding;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.base.Entity.CityEntity;
import com.bm.container.module.login.adapter.CityGridViewAdapter;
import com.bm.container.module.login.bean.GetCityListBean;
import com.bm.container.module.login.bean.GetCountryListBean;
import com.bm.container.view.AlertDialog;
import com.bm.container.view.PickerDialog;
import com.bumptech.glide.Glide;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * P3_3身份认证
 */
public class IdentificationActivity extends BaseActivity {
    private ActivityIdentificationBinding binding;
    private Context context;
    private Boolean[] canDelete = {false};
    private CityGridViewAdapter adapter;
    private List<String> col = new ArrayList<>();
    private String phone;
    private String pwd;
    private String countryId = "1";
    private String cityId = "";
    private ArrayList<String> citys = new ArrayList<>();
    private ArrayList<String> ids = new ArrayList<>();
    private int type = 2;
    private HashMap<Integer, File> files = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_identification);
        context = this;
        getInfo();
        setTopbar();
        setLoading();
        uploadPictures();
        setCountry();
        setRegister();
        setCity();
        setAddCity();
        setChoosen();
        setOptions(2);
    }


    private void uploadPictures() {

        //选择开户支行
        binding.bank.setOnClickListener(v -> {
            ArrayList<String> banks = new ArrayList<>();
            Collections.addAll(banks, ConstantsTag.bankName);
            PickerDialog picker = new PickerDialog.Builder(IdentificationActivity.this)//
                    .setData(banks)
                    .setCancel((mdialog, which) -> mdialog.dismiss())
                    .setSure((mdialog, which) -> {
                        mdialog.dismiss();
                        binding.bankText.setText(banks.get(which));
                    })
                    .create();
            picker.show();
        });

        //营业执照
        binding.ivAddBusinessLicense.setOnClickListener(v -> Block.getPic(IdentificationActivity.this, 1, 211));

        //省份证正面
        binding.ivAddPositive.setOnClickListener(v -> Block.getPic(IdentificationActivity.this, 1, 212));

        //省份证反面
        binding.ivAddTheOtherSide.setOnClickListener(v -> Block.getPic(IdentificationActivity.this, 1, 213));

    }

    /**
     * 手机、密码上一页传过来
     */
    private void getInfo() {
//		phone = "15962099597";
//		pwd = "123445";
        phone = getIntent().getExtras().getString("phone");
        pwd = getIntent().getExtras().getString("pwd");
    }

    /**
     * 设定国家
     */
    private void setCountry() {
        binding.country.setOnClickListener(view -> {
            Collection.getCountryList(this, bean -> {
                ArrayList<String> countrys = new ArrayList<>();
                for (GetCountryListBean.DataBean country : bean.getData()) {
                    countrys.add(country.getCountryName());
                }
                PickerDialog picker = new PickerDialog.Builder(this)//
                        .setData(countrys)//TODO 数据集合
                        .setCancel((mdialog, which) -> mdialog.dismiss())
                        .setSure((mdialog, which) -> {
                            mdialog.dismiss();
                            String id = "";
                            for (GetCountryListBean.DataBean country : bean.getData()) {
                                if (country.getCountryName().equals(countrys.get(which))) {
                                    id = country.getId();
                                    break;
                                }
                            }
                            binding.countryText.setText(countrys.get(which));
                            countryId = id;
                            binding.cityText.setText(getString(R.string.identification_city_choose));
                        })
                        .create();
                picker.show();
            });
        });
    }

    /**
     * 城市
     */
    private void setCity() {

        binding.city.setOnClickListener(view -> {
            if (countryId.isEmpty()) {
                toast("请先选择国家！");
            } else {
//                Collection.getCityList(this, countryId, bean -> {
//                    citys.clear();
//                    for (GetCityListBean.DataBean city : bean.getData()) {
//                        citys.add(city.getCityName());
//                    }
//                    PickerDialog picker = new PickerDialog.Builder(this)//
//                            .setData(citys)//TODO 数据集合
//                            .setCancel((mdialog, which) -> mdialog.dismiss())
//                            .setSure((mdialog, which) -> {
//                                String id = "";
//                                for (GetCityListBean.DataBean city : bean.getData()) {
//                                    if (city.getCityName().equals(citys.get(which))) {
//                                        id = city.getId();
//                                        break;
//                                    }
//                                }
//                                String finalId = id;
//                                Collection.createId(this, id, baseBean -> {
//                                    cityId = finalId;
//                                    binding.cityText.setText(citys.get(which));
//                                    binding.id.setText(baseBean.getData().toString());
//                                    mdialog.dismiss();
//                                });
//                            })
//                            .create();
//                    picker.show();
//                });


                Intent i = new Intent(context, CityActivity.class);
                i.putExtra("type", true);
                startAcForResult(i, 101);


            }

        });


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


    /**
     * 选择身份
     */
    private void setChoosen() {

        binding.buyer.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                AlertDialog alert = new AlertDialog.Builder(this)// builder
                        .setContent("买家身份将无法发布卖箱信息，\n您是否确认选择。")
                        .setPositiveButton("确定", (mdialog, which) -> {
                            mdialog.dismiss();
                        })
                        .setNegativeButton("取消", (mdialog, which) -> {
                            mdialog.dismiss();
                            binding.seller.setChecked(true);
                        })
                        .create();
                alert.show();
                binding.seller.setChecked(false);
                binding.personal.setChecked(true);
            }
            if (b && binding.personal.isChecked()) {
                setOptions(0);
            } else if (b && binding.company.isChecked()) {
                setOptions(1);
            }
        });
        binding.seller.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                binding.buyer.setChecked(false);
                binding.personal.setChecked(true);
            }
            if (b && binding.personal.isChecked()) {
                setOptions(2);
            } else if (b && binding.company.isChecked()) {
                setOptions(3);
            }
        });
        binding.personal.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                binding.company.setChecked(false);
            }
            if (b && binding.buyer.isChecked()) {
                setOptions(0);
            } else if (b && binding.seller.isChecked()) {
                setOptions(2);
            }
        });

        binding.company.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                binding.personal.setChecked(false);
            }
            if (b && binding.buyer.isChecked()) {
                setOptions(1);
            } else if (b && binding.seller.isChecked()) {
                setOptions(3);
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
     * 开启注册
     */
    private void setRegister() {

        binding.bankIdText.setPattern(new int[]{4, 4, 4, 4, 3});
        binding.bankIdText.setSeparator(" ");
        binding.bankIdText.setCustomizeMarkerEnable(false);

        binding.register.setOnClickListener(view -> {

            if (type == 0) {// 买家 个人

                String telPhone = binding.qqText.getText().toString();
                if (!TextUtils.isEmpty(telPhone)) {
                    if (!Verify.phone(telPhone)) {
                        toast("推荐人手机号不正确！");
                        return;
                    }
                }

                if (Verify.buyPerson(binding.countryText,
                        binding.cityText,
                        binding.nameText,
                        binding.phoneText)) {
                    Collection.buyPerson(this, phone, pwd, countryId, cityId,
                            binding.id.getText().toString(),
                            binding.nameText.getText().toString(),
                            binding.phoneText.getText().toString(),
                            binding.weixinText.getText().toString(),
                            binding.qqText.getText().toString(), files,
                            baseBean -> {
                                if (RegisterActivity.instance != null) {
                                    RegisterActivity.instance.finish();
                                }
                                dialogFinish("您的资料将在24小时内完成审核\n如未通过,请关注微信公众号:\n搜箱findcontainer");
                            });
//                    requestRegister("0","0");
                }
            } else if (type == 1) {// 买家 公司
                if (Verify.buyCompany(binding.countryText,
                        binding.cityText,
                        binding.companyNameText,
                        binding.companyPhoneText,
                        binding.companyAddressText,
                        binding.companyPersonInChargeText)) {
                    Collection.buyCompany(this, phone, pwd, countryId, cityId,
                            binding.id.getText().toString(),
                            binding.companyNameText.getText().toString(),
                            binding.companyPhoneText.getText().toString(),
                            binding.companyAddressText.getText().toString(),
                            binding.companyPersonInChargeText.getText().toString(), files,
                            baseBean -> {
                                if (RegisterActivity.instance != null) {
                                    RegisterActivity.instance.finish();
                                }
                                dialogFinish("您的资料将在24小时内完成审核\n如未通过,请关注微信公众号:\n搜箱findcontainer");

                            });
//                    requestRegister("0","1");
                }
            } else if (type == 2) {// 卖家 个人
                if (Verify.salePerson(binding.countryText,
                        binding.cityText,
                        binding.nameText,
                        binding.phoneText,
                        binding.bankNameText,
                        binding.bankText,
                        binding.bankIdText,
                        col, files)) {
                    String idString = "";
                    for (String id : ids) {
                        idString += (id + ",");
                    }
                    idString.substring(0, idString.length() - 1);
                    Collection.salePerson(this, phone, pwd, countryId, cityId,
                            binding.id.getText().toString(),
                            binding.nameText.getText().toString(),
                            binding.phoneText.getText().toString(),
                            binding.bankNameText.getText().toString(),
                            binding.bankText.getText().toString(),
                            binding.bankIdText.getText().toString(),
                            idString, files,
                            baseBean -> {
                                if (RegisterActivity.instance != null) {
                                    RegisterActivity.instance.finish();
                                }
                                dialogFinish("您的资料将在24小时内完成审核\n如未通过,请关注微信公众号:\n搜箱findcontainer");

                            });
//                    requestRegister("1","0");
                }
            } else if (type == 3) {// 卖家 公司
                if (Verify.saleCompany(binding.countryText,
                        binding.cityText,
                        binding.companyNameText,
                        binding.companyPhoneText,
                        binding.companyAddressText,
                        binding.companyPersonInChargeText,
                        binding.bankNameText,
                        binding.bankText,
                        binding.bankIdText,
                        col, files)) {
                    String idString = "";
                    for (String id : ids) {
                        idString += (id + ",");
                    }
                    idString.substring(0, idString.length() - 1);
                    Collection.saleCompany(this, phone, pwd, countryId, cityId,
                            binding.id.getText().toString(),
                            binding.companyNameText.getText().toString(),
                            binding.companyPhoneText.getText().toString(),
                            binding.companyAddressText.getText().toString(),
                            binding.companyPersonInChargeText.getText().toString(),
                            binding.bankNameText.getText().toString(),
                            binding.bankText.getText().toString(),
                            binding.bankIdText.getText().toString(),
                            idString, files,
                            baseBean -> {
                                if (RegisterActivity.instance != null) {
                                    RegisterActivity.instance.finish();
                                }
                                dialogFinish("您的资料将在24小时内完成审核\n如未通过,请关注微信公众号:\n搜箱findcontainer");
                            });
//                    requestRegister("1","1");
                }
            }
        });
    }


//    /**
//     * 请求注册
//     * @param userFlag 用户类型
//     * @param appUserType 身份类型
//     */
//    private void requestRegister(String userFlag, String appUserType){
//
//        Collection.buyPerson(this,userFlag, appUserType, phone, pwd, countryId, cityId,
//                binding.id.getText().toString(),
//                binding.nameText.getText().toString(),
//                binding.phoneText.getText().toString(),
//                binding.weixinText.getText().toString(),
//                binding.qqText.getText().toString(),files,
//                baseBean -> {
//                    if (RegisterActivity.instance != null) {
//                        RegisterActivity.instance.finish();
//                    }
//                    dialogFinish("您的资料将在24小时内完成审核\n如未通过,请关注微信公众号:搜箱findcontainer");
//                });
//
//    }

    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(false);
        binding.refresh.setColorSchemeColors(loadingColors);
    }

    private void setTopbar() {
        binding.topbar.toolbar.setTitle("");
        binding.topbar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        binding.topbar.title.setText(R.string.identification_title);
        setSupportActionBar(binding.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }

    /**
     * 设定焦点
     */
    private void setFocus() {
        //取消焦点
        binding.focus.setFocusable(true);
        binding.focus.setFocusableInTouchMode(true);
        binding.focus.requestFocus();
    }


    /**
     * 更新选项
     */
    private void setOptions(int option) {

        type = option;
        if (option == 0) {//买家个人
            binding.tvInfo.setText("用户信息");
            binding.tvUserId.setText("用户ID");
            binding.name.setVisibility(View.VISIBLE);
            binding.phone.setVisibility(View.VISIBLE);
            binding.address.setVisibility(View.GONE);
            binding.weixin.setVisibility(View.VISIBLE);
            binding.qq.setVisibility(View.VISIBLE);
            binding.companyName.setVisibility(View.GONE);
            binding.companyLegalEntity.setVisibility(View.GONE);
            binding.companyPhone.setVisibility(View.GONE);
            binding.companyAddress.setVisibility(View.GONE);
            binding.companyPersonInCharge.setVisibility(View.GONE);
            binding.bankId.setVisibility(View.GONE);
            binding.bank.setVisibility(View.GONE);
            binding.bankIdName.setVisibility(View.GONE);
            binding.choooseCity.setVisibility(View.GONE);
            binding.chooseCityTip.setVisibility(View.GONE);
            binding.llBusinessLicense.setVisibility(View.GONE);
            binding.llIdentity.setVisibility(View.GONE);
            binding.viewllBusinessLicense.setVisibility(View.GONE);
        } else if (option == 1) {//买家公司
            binding.tvInfo.setText("公司信息");
            binding.tvUserId.setText("公司ID");
            binding.name.setVisibility(View.GONE);
            binding.phone.setVisibility(View.GONE);
            binding.address.setVisibility(View.GONE);
            binding.weixin.setVisibility(View.GONE);
            binding.qq.setVisibility(View.GONE);
            binding.companyName.setVisibility(View.VISIBLE);
            binding.companyLegalEntity.setVisibility(View.GONE);
            binding.companyPhone.setVisibility(View.VISIBLE);
            binding.companyAddress.setVisibility(View.VISIBLE);
            binding.companyPersonInCharge.setVisibility(View.VISIBLE);
            binding.bankId.setVisibility(View.GONE);
            binding.bank.setVisibility(View.GONE);
            binding.bankIdName.setVisibility(View.GONE);
            binding.choooseCity.setVisibility(View.GONE);
            binding.chooseCityTip.setVisibility(View.GONE);
            binding.llBusinessLicense.setVisibility(View.GONE);
            binding.llIdentity.setVisibility(View.GONE);
            binding.viewllBusinessLicense.setVisibility(View.GONE);
        } else if (option == 2) {//卖家个人
            binding.tvInfo.setText("用户信息");
            binding.tvUserId.setText("用户ID");
            binding.name.setVisibility(View.VISIBLE);
            binding.phone.setVisibility(View.VISIBLE);
            binding.address.setVisibility(View.GONE);
            binding.weixin.setVisibility(View.GONE);
            binding.qq.setVisibility(View.GONE);
            binding.companyName.setVisibility(View.GONE);
            binding.companyLegalEntity.setVisibility(View.GONE);
            binding.companyPhone.setVisibility(View.GONE);
            binding.companyAddress.setVisibility(View.GONE);
            binding.companyPersonInCharge.setVisibility(View.GONE);
            binding.bankId.setVisibility(View.VISIBLE);
            binding.bank.setVisibility(View.VISIBLE);
            binding.bankIdName.setVisibility(View.VISIBLE);
            binding.choooseCity.setVisibility(View.VISIBLE);
            binding.chooseCityTip.setVisibility(View.VISIBLE);
            binding.llBusinessLicense.setVisibility(View.GONE);
            binding.llIdentity.setVisibility(View.VISIBLE);
            binding.viewllBusinessLicense.setVisibility(View.VISIBLE);
        } else if (option == 3) {//卖家公司
            binding.tvInfo.setText("公司信息");
            binding.tvUserId.setText("公司ID");
            binding.name.setVisibility(View.GONE);
            binding.phone.setVisibility(View.GONE);
            binding.address.setVisibility(View.GONE);
            binding.weixin.setVisibility(View.GONE);
            binding.qq.setVisibility(View.GONE);
            binding.companyName.setVisibility(View.VISIBLE);
            binding.companyLegalEntity.setVisibility(View.GONE);
            binding.companyPhone.setVisibility(View.VISIBLE);
            binding.companyAddress.setVisibility(View.VISIBLE);
            binding.companyPersonInCharge.setVisibility(View.VISIBLE);
            binding.bankId.setVisibility(View.VISIBLE);
            binding.bank.setVisibility(View.VISIBLE);
            binding.bankIdName.setVisibility(View.VISIBLE);
            binding.choooseCity.setVisibility(View.VISIBLE);
            binding.chooseCityTip.setVisibility(View.VISIBLE);
            binding.llBusinessLicense.setVisibility(View.VISIBLE);
            binding.llIdentity.setVisibility(View.GONE);
            binding.viewllBusinessLicense.setVisibility(View.VISIBLE);
        }
        setFocus();
        canDelete[0] = false;
        adapter.notifyDataSetChanged();
    }

    /**
     * 选择城市的返回信息
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 211) {

            showLoading();
            List<File> pics = Block.resolvePic(this, data, files -> {
                Log.e("压缩", "成功了！");
                Glide.with(context).load(files.get(0)).placeholder(R.drawable.type0).dontAnimate().into(binding.ivAddBusinessLicense);
                this.files.put(0, files.get(0));
                hideLoading();
            }, throwable -> {
                Log.e("压缩失败", "压缩失败");
                hideLoading();
            });

        } else if (requestCode == 212) {

            showLoading();
            List<File> pics = Block.resolvePic(this, data, files -> {
                Log.e("压缩", "成功了！");
                Glide.with(context).load(files.get(0)).placeholder(R.drawable.type1).dontAnimate().into(binding.ivAddPositive);
                this.files.put(1, files.get(0));
                hideLoading();
            }, throwable -> {
                Log.e("压缩失败", "压缩失败");
                hideLoading();
            });

        } else if (requestCode == 213) {

            showLoading();
            List<File> pics = Block.resolvePic(this, data, files -> {
                Log.e("压缩", "成功了！");
                Glide.with(context).load(files.get(0)).placeholder(R.drawable.type2).dontAnimate().into(binding.ivAddTheOtherSide);
                this.files.put(2, files.get(0));
                hideLoading();
            }, throwable -> {
                Log.e("压缩失败", "压缩失败");
                hideLoading();
            });

        } else if (requestCode == 100 && resultCode == 10) {
            canDelete[0] = false;
            ArrayList<CityEntity> selectedCitys = (ArrayList<CityEntity>) data.getExtras().getSerializable("selectedCitys");
            if (null != selectedCitys && selectedCitys.size() > 0) {
                for (int i = 0; i < selectedCitys.size(); i++) {
                    col.add(selectedCitys.get(i).getCityName());
                    ids.add(selectedCitys.get(i).getId());
                }
            }
            adapter.notifyDataSetChanged();

        } else if (requestCode == 101 && resultCode == 10) {

            ArrayList<CityEntity> selectedCitys = (ArrayList<CityEntity>) data.getExtras().getSerializable("selectedCitys");

            if (null != selectedCitys && selectedCitys.size() > 0) {
                cityId = selectedCitys.get(0).getId();
//                binding.cityText.setText(selectedCitys.get(0).getCityName());
            }

            Collection.createId(this, cityId, baseBean -> {

                binding.cityText.setText(selectedCitys.get(0).getCityName());
                binding.id.setText(baseBean.getData().toString());

            });

        } else {
            canDelete[0] = false;
            adapter.notifyDataSetChanged();
        }
    }


}
