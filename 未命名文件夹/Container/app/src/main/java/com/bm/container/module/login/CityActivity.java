package com.bm.container.module.login;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.bm.container.R;
import com.bm.container.databinding.ActivityCityBinding;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.base.Entity.CityEntity;
import com.bm.container.module.base.bean.AllCityBean;
import com.bm.container.module.login.adapter.MyCityAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 城市选择
 */
public class CityActivity extends BaseActivity {
    private ActivityCityBinding binding;
    private Context context;
    //    private CityAdapter adapter;
    private MyCityAdapter adapter;
    private ArrayList<CityEntity> citys = new ArrayList<>();
    private ArrayList<CityEntity> selectedCitys = new ArrayList<>();
    private HashMap<String, Integer> abcMap = new HashMap<>();
    private ArrayList<String> abc = new ArrayList<>();
    //    private Realm realm;
    private ArrayList<String> cityList;
    private boolean type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_city);
        context = this;
        getIntentData();
        showLoading();
        setTopbar();
        setLoading();
//        initList();
        requestHotCityList();
    }


    private void getIntentData() {
        if (null != getIntent()) {
            cityList = (ArrayList<String>) getIntent().getSerializableExtra("cityNameList");
            type = getIntent().getBooleanExtra("type", false);
        }
    }


    private void requestHotCityList() {
        showLoading();
        Collection.hotCityList(this, hotCityBean -> {
            if (null != hotCityBean && null != hotCityBean.getData() && hotCityBean.getData().size() > 0) {

                for (int i = 0; i < hotCityBean.getData().size(); i++) {
                    CityEntity cityEntity = new CityEntity();
                    cityEntity.setCityName(hotCityBean.getData().get(i).getCityName());
                    cityEntity.setFirstWord("#");
                    cityEntity.setId(hotCityBean.getData().get(i).getId());
                    cityEntity.setProvince(hotCityBean.getData().get(i).getProvinceName());
                    citys.add(cityEntity);
                }
                initList();
            }
        });
    }

    /**
     * 分别按照abc导入
     * 后台特别结构，没办法，他不是按数组给到的
     */
    private void initList() {


        Collection.allCityList(this, bean -> {

            for (AllCityBean.DataBean.CityBean city : bean.getData().getA()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("A");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getB()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("B");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getC()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("C");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getD()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("D");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getE()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("E");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getF()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("F");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getG()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("G");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getH()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("H");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getJ()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("J");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getK()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("K");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getL()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("L");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getM()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("M");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getN()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("N");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getP()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("P");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getQ()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("Q");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getR()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("R");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getS()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("S");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getT()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("T");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getW()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("W");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getX()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("X");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getY()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("Y");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            for (AllCityBean.DataBean.CityBean city : bean.getData().getZ()) {
                CityEntity tempCity = new CityEntity();
                tempCity.setFirstWord("Z");
                tempCity.setId("" + city.getId());
                tempCity.setCityName(city.getCityName());
                tempCity.setProvince(city.getProvinceName());
                citys.add(tempCity);
            }

            CityActivity.this.doSomething();

        });
    }

    /**
     * 显示列表
     */
    private void doSomething() {


        Collections.sort(citys, (lhs, rhs) -> {
            String a = lhs.getFirstWord();
            String b = rhs.getFirstWord();
            int flag = a.compareTo(b);
            if (flag == 0) {
                return a.compareTo(b);
            } else {
                return flag;
            }
        });


        //勾选上已选择的城市
        if (null != cityList && cityList.size() > 0 && null != citys && citys.size() > 0) {

            for (int z = 0; z < citys.size(); z++) {

                for (int i = 0; i < cityList.size(); i++) {

                    if (citys.get(z).getCityName().equals(cityList.get(i))) {
                        citys.get(z).setClick(true);
                    }

                }

            }

        }


        adapter = new MyCityAdapter(citys);
        adapter.setChooseCity(chooseCity);

        binding.list.setAdapter(adapter);

        for (int i = 0; i < citys.size(); i++) {
            if (i == 0 || citys.get(i).getFirstWord().charAt(0) != citys.get(i - 1).getFirstWord().charAt(0)) {
                abcMap.put("" + citys.get(i).getFirstWord().charAt(0), i);
                abc.add("" + citys.get(i).getFirstWord().charAt(0));
            }
        }
        String[] temp = new String[abc.size()];
        for (int i = 0; i < abc.size(); i++) {
            temp[i] = abc.get(i);
        }
        binding.sideBar.setIndexItems(temp);
        binding.sideBar.setOnSelectIndexItemListener(index -> {
            binding.list.setSelection(abcMap.get(index));
        });
        hideLoading();
    }


    private MyCityAdapter.ChooseCity chooseCity = new MyCityAdapter.ChooseCity() {

        @Override
        public void chooose(CityEntity cityEntity) {


            if (null != citys && citys.size() > 0) {
                for (int i = 0; i < citys.size(); i++) {

                    if (type) {

                        if (cityEntity.getId().equals(citys.get(i).getId())) {
                            if (!citys.get(i).getClick()) {
                                citys.get(i).setClick(true);
                                if (null != selectedCitys) {
                                    selectedCitys.add(citys.get(i));
                                }
                            } else {
                                citys.get(i).setClick(false);
                                if (null != selectedCitys && selectedCitys.size() > 0) {
                                    selectedCitys.remove(citys.get(i));
                                }
                            }
                        } else {
                            citys.get(i).setClick(false);
                            if (null != selectedCitys && selectedCitys.size() > 0) {
                                selectedCitys.remove(citys.get(i));
                            }
                        }

                    } else {

                        if (cityEntity.getId().equals(citys.get(i).getId())) {
                            if (!citys.get(i).getClick()) {
                                citys.get(i).setClick(true);
                                if (null != selectedCitys) {
                                    selectedCitys.add(citys.get(i));
                                }
                            } else {
                                citys.get(i).setClick(false);
                                if (null != selectedCitys && selectedCitys.size() > 0) {
                                    selectedCitys.remove(citys.get(i));
                                }
                            }
                        }

                    }

                }
                adapter.notifyDataSetChanged();
            }


//
////去掉老版本的延迟操作
////            toast(city);
////            binding.refresh.setRefreshing(true);
////            Observable
////                    .timer(2, TimeUnit.SECONDS)
////                    .subscribeOn(Schedulers.io())
////                    .observeOn(AndroidSchedulers.mainThread())
////                    .subscribe(aLong -> {
////                        Intent i = getIntent();
////                        i.putExtra("city", city);
////                        i.putExtra("id", id);
////                        setResult(10, i);
////                        finishAc();
////                        binding.refresh.setRefreshing(false);
////                    });

        }
    };


    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(false);
        binding.refresh.setColorSchemeColors(loadingColors);
    }


    private void setTopbar() {
        binding.topbar.toolbar.setTitle("");
        binding.topbar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        binding.topbar.title.setText(R.string.city_title);
        binding.topbar.rightTextModel.setVisibility(View.VISIBLE);
        binding.topbar.rightTextname.setText("完成");
        setSupportActionBar(binding.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());

        binding.topbar.rightTextname.setOnClickListener(v -> {

            if (null != selectedCitys && selectedCitys.size() > 0) {

                for (int i = 0; i < selectedCitys.size() - 1; i++) {
                    for (int j = selectedCitys.size() - 1; j > i; j--) {
                        if (selectedCitys.get(j).getCityName().equals(selectedCitys.get(i).getCityName())) {
                            selectedCitys.remove(j);
                        }
                    }
                }

                Intent intent = CityActivity.this.getIntent();
                intent.putExtra("selectedCitys", selectedCitys);
                CityActivity.this.setResult(10, intent);
                CityActivity.this.finishAc();

            } else {

                if (null == cityList || cityList.size() <= 0) {
                    toast("请选择城市");
                } else {
                    CityActivity.this.finishAc();
                }

            }

        });

    }


}
