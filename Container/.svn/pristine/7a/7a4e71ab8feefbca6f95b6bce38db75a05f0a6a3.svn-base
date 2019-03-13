package com.bm.container.module.market;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;

import com.bm.container.R;
import com.bm.container.Tools.DataUtils;
import com.bm.container.Tools.NetHelper;
import com.bm.container.Tools.Verify;
import com.bm.container.databinding.ActivitySendBuyInfoBinding;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.base.Entity.CityEntity;
import com.bm.container.module.login.CityActivity;
import com.bm.container.module.login.bean.GetCityListBean;
import com.bm.container.module.login.bean.GetCountryListBean;
import com.bm.container.module.market.adapter.StatusBean;
import com.bm.container.module.market.adapter.TypeBean;
import com.bm.container.view.PickerDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * P5_1发布信息(求购)
 */
public class SendBuyInfoActivity extends BaseActivity {
    private ActivitySendBuyInfoBinding binding;
    private Context context;
    private String countryId = "1";
    private String cityId = "";
    private String typeId = "";
    private String statusId = "";
    private String timeId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //收起键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_send_buy_info);
        context = this;
        setTopbar();
        setLoading();
        setCountry();
        setCity();
        setType();
        setStatus();
        setTime();
        setSubmit();
    }

    /**
     * 点击发布
     */
    private void setSubmit() {
        binding.sure.setOnClickListener(v -> {

            if (!NetHelper.IsHaveInternet(this)) {
                toast("未连接到网络.");
                return;
            }

            if (DataUtils.isFastClick()) {
                toast("您的操作过于频繁，请稍后！");
                return;
            }

            String titleName = binding.editTitleName.getText().toString().trim();
            String age = binding.etAge.getText().toString().trim();

            if (Verify.sendBuyInfo(countryId, cityId, typeId, statusId, binding.number.getText().toString(), timeId,
                    titleName, binding.special.getText().toString(), age)) {
                Collection.sendBuyInfo(this, countryId, cityId, typeId, statusId, binding.number.getText().toString(),
                        timeId, binding.special.getText().toString(), titleName, age, baseBean -> {
                            dialogFinish("买箱信息发布成功，\n卖家将对您的发布信息进行出价，\n请及时点击该信息进行查看。");
                        });
            }
        });
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

            if (!NetHelper.IsHaveInternet(this)) {
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

            if (!NetHelper.IsHaveInternet(this)) {
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

            if (!NetHelper.IsHaveInternet(this)) {
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == 10) {

            ArrayList<CityEntity> selectedCitys = (ArrayList<CityEntity>) data.getExtras().getSerializable("selectedCitys");

            if (null != selectedCitys && selectedCitys.size() > 0) {
                cityId = selectedCitys.get(0).getId();
                binding.cityText.setText(selectedCitys.get(0).getCityName());
            }

        }

    }

    /**
     * 国家
     */
    private void setCountry() {
        binding.country.setOnClickListener(view -> {

            if (!NetHelper.IsHaveInternet(this)) {
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

    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(false);
        binding.refresh.setColorSchemeColors(loadingColors);
    }

    private void setTopbar() {
        binding.topbar.toolbar.setTitle("");
        binding.topbar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        binding.topbar.title.setText(R.string.sendbuyinfo_title);
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
}
