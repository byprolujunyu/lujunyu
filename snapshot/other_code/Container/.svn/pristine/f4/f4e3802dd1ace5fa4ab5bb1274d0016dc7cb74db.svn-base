package com.bm.container.module.market;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;

import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.Tools.DataUtils;
import com.bm.container.Tools.NetHelper;
import com.bm.container.Tools.NoDoubleClickListener;
import com.bm.container.Tools.SpUtil;
import com.bm.container.Tools.Verify;
import com.bm.container.databinding.ActivitySendSaleInfoBinding;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.base.Entity.CityEntity;
import com.bm.container.module.login.CityActivity;
import com.bm.container.module.login.bean.GetCityListBean;
import com.bm.container.module.login.bean.GetCountryListBean;
import com.bm.container.module.market.adapter.StatusBean;
import com.bm.container.module.market.adapter.TypeBean;
import com.bm.container.module.personal.ChangeCompanyInfoActivity;
import com.bm.container.view.AlertDialog;
import com.bm.container.view.PickerDialog;
import com.bumptech.glide.Glide;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * P5_1 发布信息(出售)
 */
public class SendSaleInfoActivity extends BaseActivity {
    private ActivitySendSaleInfoBinding binding;
    private Context context;
    private String countryId = "1";
    private String cityId = "";
    private String typeId = "";
    private String statusId = "";
    private String timeId = "";
    private String tradeId = "0";
    private String isSpecial = "0";
    private String hasInvoice = "0";
    private HashMap<Integer, File> files = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //收起键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_send_sale_info);
        context = this;
        setTopbar();
        setLoading();
        setCountry();
        setCity();
        setType();
        setStatus();
        setSubmit();
        setSpecialFee();
        setInvoice();
        setPic();
        setSaleOrBid();
        setMoney();
    }

    /**
     * 金额
     */
    private void setMoney() {
        binding.moneyInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String a = binding.moneyInput.getText().toString().trim();
                String b = binding.inputMoney.getText().toString().trim();

                if (a.isEmpty()) {
                    a = "0";
                }
                if (b.isEmpty()) {
                    b = "0";
                }

                binding.allMoney.setText((Integer.valueOf(a) + Integer.valueOf(b)) + "元");
            }
        });

        binding.inputMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String a = binding.moneyInput.getText().toString().trim();
                String b = binding.inputMoney.getText().toString().trim();

                if (a.isEmpty()) {
                    a = "0";
                }
                if (b.isEmpty()) {
                    b = "0";
                }

//				binding.allMoney.setText((Integer.parseInt(a) + Integer.parseInt(b)) + "元");
                binding.allMoney.setText((Integer.valueOf(a) + Integer.valueOf(b)) + "元");
            }
        });
    }

    /**
     * 照片，箱子的照片
     */
    private void setPic() {


        binding.ivDelete0.setVisibility(View.GONE);
        binding.ivDelete1.setVisibility(View.GONE);
        binding.ivDelete2.setVisibility(View.GONE);
        binding.ivDelete3.setVisibility(View.GONE);
        binding.ivDelete4.setVisibility(View.GONE);
        binding.ivDelete5.setVisibility(View.GONE);

        binding.file0.setOnClickListener(v -> {
            Block.getPic(this, 1, 200);
        });
        binding.file1.setOnClickListener(v -> {
            Block.getPic(this, 1, 201);
        });
        binding.file2.setOnClickListener(v -> {
            Block.getPic(this, 1, 202);
        });
        binding.file3.setOnClickListener(v -> {
            Block.getPic(this, 1, 203);
        });
        binding.file4.setOnClickListener(v -> {
            Block.getPic(this, 1, 204);
        });
        binding.file5.setOnClickListener(v -> {
            Block.getPic(this, 1, 205);
        });

        binding.ivDelete0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (files.size() > 0) {
                    files.remove(0);
                    binding.file0.setImageResource(R.drawable.type0);
                    binding.ivDelete0.setVisibility(View.GONE);
                }
            }
        });

        binding.ivDelete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (files.size() >= 1) {
                    files.remove(1);
                    binding.file1.setImageResource(R.drawable.type0);
                    binding.ivDelete1.setVisibility(View.GONE);
                }
            }
        });

        binding.ivDelete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (files.size() >= 2) {
                    files.remove(2);
                    binding.file2.setImageResource(R.drawable.type0);
                    binding.ivDelete2.setVisibility(View.GONE);
                }
            }
        });

        binding.ivDelete3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (files.size() >= 3) {
                    files.remove(3);
                    binding.file3.setImageResource(R.drawable.type0);
                    binding.ivDelete3.setVisibility(View.GONE);
                }
            }
        });

        binding.ivDelete4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (files.size() >= 4) {
                    files.remove(4);
                    binding.file4.setImageResource(R.drawable.type0);
                    binding.ivDelete4.setVisibility(View.GONE);
                }
            }
        });

        binding.ivDelete5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (files.size() >= 5) {
                    files.remove(5);
                    binding.file5.setImageResource(R.drawable.type0);
                    binding.ivDelete5.setVisibility(View.GONE);
                }
            }
        });

    }

    /**
     * 选择发票
     */
    private void setInvoice() {
        binding.invoice.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == binding.noInvoice.getId()) {
                hasInvoice = "0";
            } else {
                hasInvoice = "1";
            }
        });
    }

    /**
     * 特殊费用
     */
    private void setSpecialFee() {
        binding.specialCheck.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == binding.specialCheckLeft.getId()) {
                binding.inputMoney.setEnabled(false);
                binding.inputMoney.setText("");
                isSpecial = "0";
            } else {
                binding.inputMoney.setEnabled(true);
                isSpecial = "1";
                binding.inputMoney.setText("");
            }
        });
    }

    /**
     * 提交
     */
    private void setSubmit() {

        binding.sure.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {

                if (!NetHelper.IsHaveInternet(SendSaleInfoActivity.this)) {
                    toast("未连接到网络.");
                    return;
                }

                String titleName = binding.editTitleName.getText().toString().trim();
                String editRemarksVaule = binding.editRemarks.getText().toString().trim();
                String editLowPriceVaule = binding.editLowPrice.getText().toString().trim();
                String age = binding.etAge.getText().toString().trim();

                if (Verify.sendSaleInfo(countryId, cityId, typeId, statusId, binding.number.getText().toString(),
                        tradeId, binding.moneyInput.getText().toString(), timeId, isSpecial,
                        binding.inputMoney.getText().toString(), hasInvoice, titleName, editLowPriceVaule, age, files)) {
                    //这边有个判断，如果没有选图片，弹框提示并让用户选择是否继续
                    if (files.size() == 0) {
                        AlertDialog alert = new AlertDialog.Builder(SendSaleInfoActivity.this)// builder
                                .setCancelable(false)
                                .setContent("您没有上传图片，是否还要发布") //TODO 内容
                                .setPositiveButton("确定", (mdialog, which) -> {
                                    mdialog.dismiss();
                                    Collection.sendSaleInfo(SendSaleInfoActivity.this, countryId, cityId, typeId, statusId, binding.number.getText().toString(),
                                            tradeId, timeId, isSpecial, binding.inputMoney.getText().toString(), hasInvoice,
                                            binding.moneyInput.getText().toString(), titleName, editRemarksVaule, editLowPriceVaule, age, files, baseBean -> {
                                                SendSaleInfoActivity.this.dialogFinish("卖箱信息发布成功，\n如您的信息为投标类型的话，买家将对您的发布信息进行出价，\n请及时点击信息进行查看");
                                                SpUtil.setBoolean(SpUtil.SELL_BOX_SUCCESSFULLY_RELEASED, true);
                                            });
                                })
                                .setNegativeButton("取消", (mdialog, which) -> mdialog.dismiss())
                                .create();
                        alert.show();
                    } else {
                        Collection.sendSaleInfo(SendSaleInfoActivity.this, countryId, cityId, typeId, statusId, binding.number.getText().toString(),
                                tradeId, timeId, isSpecial, binding.inputMoney.getText().toString(), hasInvoice,
                                binding.moneyInput.getText().toString(), titleName, editRemarksVaule, editLowPriceVaule, age, files, baseBean -> {
                                    SendSaleInfoActivity.this.dialogFinish("卖箱信息发布成功，\n如您的信息为投标类型的话，买家将对您的发布信息进行出价，\n请及时点击信息进行查看");
                                    SpUtil.setBoolean(SpUtil.SELL_BOX_SUCCESSFULLY_RELEASED, true);
                                });
                    }
                }

            }
        });

//        binding.sure.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (Verify.sendSaleInfo(countryId, cityId, typeId, statusId, binding.number.getText().toString(), tradeId, binding.moneyInput.getText().toString(), timeId, isSpecial, binding.inputMoney.getText().toString(), hasInvoice, files)) {
//                    //这边有个判断，如果没有选图片，弹框提示并让用户选择是否继续
//                    if (files.size() == 0) {
//                        AlertDialog alert = new AlertDialog.Builder(SendSaleInfoActivity.this)// builder
//                                .setContent("您没有上传图片，是否还要发布") //TODO 内容
//                                .setPositiveButton("确定", (mdialog, which) -> {
//                                    mdialog.dismiss();
//                                    Collection.sendSaleInfo(SendSaleInfoActivity.this, countryId, cityId, typeId, statusId, binding.number.getText().toString(), tradeId, timeId, isSpecial, binding.inputMoney.getText().toString(), hasInvoice, binding.moneyInput.getText().toString(), files, baseBean -> {
//                                        SendSaleInfoActivity.this.dialogFinish("卖箱信息发布成功，\n如您的记录为投标类型的话，买家将对您的发布信息进行出价，\n请及时点击信息进行查看");
//                                        SpUtil.setBoolean(SpUtil.SELL_BOX_SUCCESSFULLY_RELEASED, true);
//                                    });
//                                })
//                                .setNegativeButton("取消", (mdialog, which) -> mdialog.dismiss())
//                                .create();
//                        alert.show();
//                    } else {
//                        Collection.sendSaleInfo(SendSaleInfoActivity.this, countryId, cityId, typeId, statusId, binding.number.getText().toString(), tradeId, timeId, isSpecial, binding.inputMoney.getText().toString(), hasInvoice, binding.moneyInput.getText().toString(), files, baseBean -> {
//                            SendSaleInfoActivity.this.dialogFinish("卖箱信息发布成功，\n如您的记录为投标类型的话，买家将对您的发布信息进行出价，\n请及时点击信息进行查看");
//                            SpUtil.setBoolean(SpUtil.SELL_BOX_SUCCESSFULLY_RELEASED, true);
//                        });
//                    }
//
//                }
//            }
//        });
    }

    /**
     * 时间
     */
    private void setTime() {
        ArrayList<String> chooses = new ArrayList<>();
        chooses.add("30分钟");
        chooses.add("1小时");
        chooses.add("2小时");
        chooses.add("4小时");
        chooses.add("8小时");
        chooses.add("12小时");
        chooses.add("24小时");
        chooses.add("2天");
        chooses.add("3天");
        chooses.add("一周");

        Map<String, String> times = new HashMap<>();
        times.put("30分钟", "0");
        times.put("1小时", "1");
        times.put("2小时", "2");
        times.put("4小时", "3");
        times.put("8小时", "4");
        times.put("12小时", "5");
        times.put("24小时", "6");
        times.put("2天", "7");
        times.put("3天", "8");
        times.put("一周", "9");
        binding.time.setOnClickListener(v -> {
            PickerDialog picker = new PickerDialog.Builder(this)//
                    .setData(chooses)//TODO 数据集合
                    .setCancel((mdialog, which) -> mdialog.dismiss())
                    .setSure((mdialog, which) -> {
                        binding.timeText.setText(chooses.get(which));
                        timeId = times.get(chooses.get(which));
                        mdialog.dismiss();
                    })
                    .create();
            picker.show();
        });
    }

    /**
     * 状态
     */
    private void setStatus() {
        binding.status.setOnClickListener(v -> {

            if (!NetHelper.IsHaveInternet(SendSaleInfoActivity.this)) {
                toast("未连接到网络.");
                return;
            }

            Collection.containerStatus(this, bean -> {
                ArrayList<String> statuses = new ArrayList<>();
                for (StatusBean.DataBean status : bean.getData()) {
                    statuses.add(status.getValue());
                }
                PickerDialog picker = new PickerDialog.Builder(this)//
                        .setData(statuses)//TODO 数据集合
                        .setCancel((mdialog, which) -> mdialog.dismiss())
                        .setSure((mdialog, which) -> {
                            String id = "";
                            for (StatusBean.DataBean status : bean.getData()) {
                                if (status.getValue().equals(statuses.get(which))) {
                                    id = status.getKey();
                                    break;
                                }
                            }
                            statusId = id;
                            binding.statusText.setText(statuses.get(which));
                            mdialog.dismiss();
                        })
                        .create();
                picker.show();
            });
        });
    }

    /**
     * 类型
     */
    private void setType() {
        binding.type.setOnClickListener(v -> {

            if (!NetHelper.IsHaveInternet(SendSaleInfoActivity.this)) {
                toast("未连接到网络.");
                return;
            }

            Collection.containerType(this, bean -> {
                ArrayList<String> types = new ArrayList<>();
                for (TypeBean.DataBean type : bean.getData()) {
                    types.add(type.getValue());
                }
                PickerDialog picker = new PickerDialog.Builder(this)//
                        .setData(types)//TODO 数据集合
                        .setCancel((mdialog, which) -> mdialog.dismiss())
                        .setSure((mdialog, which) -> {
                            String id = "";
                            for (TypeBean.DataBean type : bean.getData()) {
                                if (type.getValue().equals(types.get(which))) {
                                    id = type.getKey();
                                    break;
                                }
                            }
                            typeId = id;
                            binding.typeText.setText(types.get(which));
                            mdialog.dismiss();
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

            if (!NetHelper.IsHaveInternet(SendSaleInfoActivity.this)) {
                toast("未连接到网络.");
                return;
            }

            if (countryId.isEmpty()) {
                toast("请先选择国家！");
            } else {

//                Collection.getCityList(this, countryId, bean -> {
//                    ArrayList<String> citys = new ArrayList<>();
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
//                                cityId = id;
//                                binding.cityText.setText(citys.get(which));
//                                mdialog.dismiss();
//                            })
//                            .create();
//                    picker.show();
//                });

                Intent i = new Intent(context, CityActivity.class);
                i.putExtra("type", true);
                startAcForResult(i, 100);

            }
        });
    }


    /**
     * 国家
     */
    private void setCountry() {
        binding.country.setOnClickListener(view -> {

            if (!NetHelper.IsHaveInternet(SendSaleInfoActivity.this)) {
                toast("未连接到网络.");
                return;
            }

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
     * 销售还是购买
     */
    private void setSaleOrBid() {

        binding.time.setVisibility(View.GONE);
        binding.llLowPrice.setVisibility(View.GONE);

        binding.saleOrBid.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == binding.sale.getId()) {
                tradeId = "0";
                binding.moneyInput.setEnabled(true);
                binding.moneyInput.setClickable(false);
                binding.money.setVisibility(View.VISIBLE);
                binding.time.setVisibility(View.GONE);
                binding.llLowPrice.setVisibility(View.GONE);
//                binding.money.setOnClickListener(v -> {
//
//                });
                binding.time.setClickable(false);
                binding.time.setOnClickListener(v -> {
                    dialog("出售无需选择时间，\n填写金额即可");
                });

                binding.allMoneyModel.setVisibility(View.VISIBLE);
            } else {
                tradeId = "1";
                binding.moneyInput.setEnabled(false);
                binding.moneyInput.setClickable(true);
                binding.money.setOnClickListener(v -> {
                    dialog("投标无需填写金额，\n选择时间即可");
                });
                binding.time.setClickable(true);
                setTime();
                binding.money.setVisibility(View.GONE);
                binding.time.setVisibility(View.VISIBLE);
                binding.llLowPrice.setVisibility(View.VISIBLE);
                binding.allMoneyModel.setVisibility(View.INVISIBLE);
            }
        });
        tradeId = "0";
        binding.moneyInput.setEnabled(true);
        binding.moneyInput.setClickable(false);
        binding.moneyInput.setOnClickListener(v -> {

        });
        binding.time.setClickable(false);
        binding.time.setOnClickListener(v -> {
            dialog("出售无需选择时间，\n填写金额即可");
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
        binding.topbar.title.setText(R.string.sendsaleinfo_title);
        setSupportActionBar(binding.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.topbar.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogClareFinish("是否确认退出？");
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        dialogClareFinish("是否确认退出？");
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 选择图片后压缩加载
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200) {
            showLoading();
            List<File> pics;
            pics = Block.resolvePic(this, data, files -> {
                Log.e("压缩", "成功了！");
                Glide.with(context).load(files.get(0)).placeholder(R.drawable.type0).dontAnimate().into(binding.file0);
                this.files.put(0, files.get(0));
                binding.ivDelete0.setVisibility(View.VISIBLE);
                hideLoading();
            }, throwable -> {
                Log.e("压缩失败", "压缩失败");
                hideLoading();
            });
        } else if (requestCode == 201) {
            showLoading();
            List<File> pics = Block.resolvePic(this, data, files -> {
                Log.e("压缩", "成功了！");
                Glide.with(context).load(files.get(0)).placeholder(R.drawable.type1).dontAnimate().into(binding.file1);
                this.files.put(1, files.get(0));
                binding.ivDelete1.setVisibility(View.VISIBLE);
                hideLoading();
            }, throwable -> {
                Log.e("压缩失败", "压缩失败");
                hideLoading();
            });
        } else if (requestCode == 202) {
            showLoading();
            List<File> pics = Block.resolvePic(this, data, files -> {
                Log.e("压缩", "成功了！");
                Glide.with(context).load(files.get(0)).placeholder(R.drawable.type2).dontAnimate().into(binding.file2);
                this.files.put(2, files.get(0));
                binding.ivDelete2.setVisibility(View.VISIBLE);
                hideLoading();
            }, throwable -> {
                Log.e("压缩失败", "压缩失败");
                hideLoading();
            });
        } else if (requestCode == 203) {
            showLoading();
            List<File> pics = Block.resolvePic(this, data, files -> {
                Log.e("压缩", "成功了！");
                Glide.with(context).load(files.get(0)).placeholder(R.drawable.type3).dontAnimate().into(binding.file3);
                this.files.put(3, files.get(0));
                binding.ivDelete3.setVisibility(View.VISIBLE);
                hideLoading();
            }, throwable -> {
                Log.e("压缩失败", "压缩失败");
                hideLoading();
            });
        } else if (requestCode == 204) {
            showLoading();
            List<File> pics = Block.resolvePic(this, data, files -> {
                Log.e("压缩", "成功了！");
                Glide.with(context).load(files.get(0)).placeholder(R.drawable.type4).dontAnimate().into(binding.file4);
                this.files.put(4, files.get(0));
                binding.ivDelete4.setVisibility(View.VISIBLE);
                hideLoading();
            }, throwable -> {
                Log.e("压缩失败", "压缩失败");
                hideLoading();
            });
        } else if (requestCode == 205) {
            showLoading();
            List<File> pics = Block.resolvePic(this, data, files -> {
                Log.e("压缩", "成功了！");
                Glide.with(context).load(files.get(0)).placeholder(R.drawable.type5).dontAnimate().into(binding.file5);
                this.files.put(5, files.get(0));
                binding.ivDelete5.setVisibility(View.VISIBLE);
                hideLoading();
            }, throwable -> {
                Log.e("压缩失败", "压缩失败");
                hideLoading();
            });
        } else if (requestCode == 100 && resultCode == 10) {

            ArrayList<CityEntity> selectedCitys = (ArrayList<CityEntity>) data.getExtras().getSerializable("selectedCitys");

            if (null != selectedCitys && selectedCitys.size() > 0) {
                cityId = selectedCitys.get(0).getId();
                binding.cityText.setText(selectedCitys.get(0).getCityName());
            }

        }
    }
}
