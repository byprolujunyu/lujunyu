package com.bm.container.module.personal;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.bm.container.R;
import com.bm.container.Tools.CheckParamsUtils;
import com.bm.container.Tools.DataUtils;
import com.bm.container.Tools.DateUtils;
import com.bm.container.Tools.ScreenShot;
import com.bm.container.Tools.SpUtil;
import com.bm.container.Tools.Verify;
import com.bm.container.databinding.ActivityBillOfLadingBinding;
import com.bm.container.entity.BillOfLadingEntity;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.personal.adapter.ChestAdapter;
import com.bm.container.module.personal.bean.SeeDeliveryOrderBean;
import com.bm.container.view.OrderNoDialog;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * 提货单这边，选项卡有接口了修改为新的形式
 * <p>
 * P7_3_3_1 填写提货单 0  买家填写提货单
 * P7_4_2_1 查看提货单 1
 * P7_4_1_1 填写提货单 2  卖家填写提货单
 */
public class BillOfLadingActivity extends BaseActivity {
    private ActivityBillOfLadingBinding binding;
    private Context context;
    private ChestAdapter adapterChest;
    private ArrayList<BillOfLadingEntity> datas = new ArrayList<>();
    private ArrayList<String> colChest = new ArrayList<>();
    private String type = "";
    private String ordeNo;
    private String containerTypeName;
    private String count;
    private String containerType;
    private String deliveryNoteId;
    private String deliveryOrderNo;
    private String qRCodeUrl;
    private int numVaule;//提箱数
    private boolean typeStatus;//显示发送提货单至买家

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //收起键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bill_of_lading);
        context = this;

        setType();

        setCheck();
        setLoading();
        setTopbar();
        deleteChest();
        addChest();

        requestData();

        //提交填写提货单
        binding.button.setOnClickListener(v -> {

            if (DataUtils.isFastClick()) {
                toast("您的操作过于频繁，请稍后！");
                return;
            }

            if (type.equals("0")) {
                requestSubmitMai();
            } else if (type.equals("2")) {
                requestSubmit();
            }
        });

    }


    private void requestData() {
        if (type.equals("0")) {//买家填写提货单
            requestSeeDeliveryOrder();
        } else if (type.equals("1")) {//查看提货单
            requestSeeDeliveryOrder();
        } else if (type.equals("2")) {//卖家填写提货单
            binding.itemItemCar.lllayout.setVisibility(View.VISIBLE);
            setList();
            requestDeliveryOrderInfo();
        }
    }

    /**
     * 查看提货单
     */
    private void requestSeeDeliveryOrder() {

        Collection.requestSeeDeliveryOrder(this, ordeNo, deliveryOrderBean -> {
            if (null == deliveryOrderBean) {
                return;
            }

            deliveryNoteId = deliveryOrderBean.getData().getId();
            deliveryOrderNo = deliveryOrderBean.getData().getOrderNo();
            qRCodeUrl = deliveryOrderBean.getData().getQRCodeUrl();

            if (null != deliveryOrderBean.getData().getDeliveryDetailList() && deliveryOrderBean.getData().getDeliveryDetailList().size() > 0) {

                binding.itemItemCar.lllayout.setVisibility(View.GONE);

                for (int i = 0; i < deliveryOrderBean.getData().getDeliveryDetailList().size(); i++) {

                    SeeDeliveryOrderBean.DataBean.DeliveryDetailListBean item = deliveryOrderBean.getData().getDeliveryDetailList().get(i);
                    BillOfLadingEntity billOfLadingEntity = new BillOfLadingEntity();
                    billOfLadingEntity.id = item.getId();
                    billOfLadingEntity.motorcadeName = item.getMotorcadeName();
                    billOfLadingEntity.plateNo = item.getPlateNo();
                    billOfLadingEntity.companyEMail = item.getCompanyEMail();
                    billOfLadingEntity.deliveryNoteId = item.getDeliveryNoteId();
                    billOfLadingEntity.contactTelephone = item.getContactTelephone();
                    billOfLadingEntity.count = item.getCount();
                    billOfLadingEntity.companyName = item.getCompanyName();
                    billOfLadingEntity.deliveryDate = item.getDeliveryDate();
                    billOfLadingEntity.orderNo = item.getOrderNo();
                    datas.add(billOfLadingEntity);

                    binding.llList.addView(BillOfLadingActivity.this.getItemView(billOfLadingEntity));
                }

            } else {
                binding.itemItemCar.lllayout.setVisibility(View.VISIBLE);
                BillOfLadingActivity.this.setList();
            }


            binding.tvOrderNo.setText(deliveryOrderBean.getData().getOrderNo());
            binding.inputNo.setText(deliveryOrderBean.getData().getContainerHeapNo());
            binding.title.setText(deliveryOrderBean.getData().getContainerTypeName());
            if (!TextUtils.isEmpty(deliveryOrderBean.getData().getCount()) && Integer.valueOf(deliveryOrderBean.getData().getCount()) > 0) {
                numVaule = Integer.valueOf(deliveryOrderBean.getData().getCount());
            }
            binding.num.setText(deliveryOrderBean.getData().getCount());

            String containerNo = deliveryOrderBean.getData().getContainerNo();
            colChest.addAll(Arrays.asList(containerNo.split(",")));
            adapterChest.notifyDataSetChanged();

            binding.inputName.setText(deliveryOrderBean.getData().getHeapName());
            binding.inputPhone.setText(deliveryOrderBean.getData().getHeapTelephone());
            binding.inputUser.setText(deliveryOrderBean.getData().getHeapContact());
            binding.inputAddress.setText(deliveryOrderBean.getData().getHeapAddress());
//            binding.deliveryTime.setText(deliveryOrderBean.getData().getHeapName());

            if (!TextUtils.isEmpty(deliveryOrderBean.getData().getIsSpecialPrice()) && deliveryOrderBean.getData().getIsSpecialPrice().equals("1")) {
                binding.money.setChecked(true);
                binding.noMoney.setChecked(false);
//                binding.inputMoney.setText(NumberUtils.formatDouble(deliveryOrderBean.getData().getSpecialPrice()));
            } else if (!TextUtils.isEmpty(deliveryOrderBean.getData().getIsSpecialPrice()) && deliveryOrderBean.getData().getIsSpecialPrice().equals("0")) {
                binding.money.setChecked(false);
                binding.noMoney.setChecked(true);
            }

            binding.inputEmail.setText(deliveryOrderBean.getData().getHeapEMail());
        }, throwable -> {
            hideLoading();
            toast(throwable.getMessage());
        });

    }


    /**
     * 请求卖家提货单信息
     */
    private void requestDeliveryOrderInfo() {

        Collection.getDeliveryNoteByOrderNo(this, ordeNo, deliveryOrderBean -> {
            if (null == deliveryOrderBean) {
                return;
            }

            containerType = deliveryOrderBean.getData().getContainer().getContainerType();
            containerTypeName = deliveryOrderBean.getData().getContainer().getContainerTypeName();
            count = deliveryOrderBean.getData().getContainer().getCount();

            binding.tvOrderNo.setText(deliveryOrderBean.getData().getOrderNo());
            binding.title.setText(deliveryOrderBean.getData().getContainer().getContainerTypeName());
            binding.num.setText(deliveryOrderBean.getData().getCount());
        }, throwable -> {
            hideLoading();
            toast(throwable.getMessage());
        });

    }


    private void setCheck() {
        if (type.equals("0")) {
            binding.money.setOnCheckedChangeListener((compoundButton, b) -> {
            });
            binding.noMoney.setOnCheckedChangeListener((compoundButton, b) -> {
            });
            binding.money.setClickable(false);
            binding.noMoney.setClickable(false);
        } else if (type.equals("1")) {
            binding.money.setOnCheckedChangeListener((compoundButton, b) -> {
            });
            binding.noMoney.setOnCheckedChangeListener((compoundButton, b) -> {
            });
            binding.money.setClickable(false);
            binding.noMoney.setClickable(false);
        } else if (type.equals("2")) {
            binding.money.setOnCheckedChangeListener((compoundButton, b) -> {
                if (b) {
                    binding.noMoney.setChecked(false);
//                    binding.inputMoney.setEnabled(true);
                }
            });
            binding.noMoney.setOnCheckedChangeListener((compoundButton, b) -> {
                if (b) {
                    binding.money.setChecked(false);
//                    binding.inputMoney.setEnabled(false);
                }
            });
        }


    }

    /**
     * 提交提货单 买家提交
     */
    private void requestSubmitMai() {

        if (null != datas && datas.size() > 0) {

            int num = 0;

            for (int i = 0; i < datas.size(); i++) {

                datas.get(i).companyName = binding.inputCompanyName.getText().toString().trim();
                datas.get(i).companyEMail = binding.inputCompanyEmail.getText().toString().trim();

                if (TextUtils.isEmpty(datas.get(i).companyName)) {
//                    toast("请输入公司名称");
                    toast("请输入买家(个人/公司)名称");
                    return;
                }
                if (TextUtils.isEmpty(datas.get(i).companyEMail)) {
//                    toast("请输入邮箱");
                    toast("请输入买家(个人/公司)邮箱地址");
                    return;
                }

                if (!CheckParamsUtils.checkEmail(datas.get(i).companyEMail)) {
                    toast("请填写正确格式邮箱地址");
                    return;
                }

                if (TextUtils.isEmpty(datas.get(i).motorcadeName)) {
                    toast("请输入车队名");
                    return;
                }
                if (TextUtils.isEmpty(datas.get(i).contactTelephone)) {
                    toast("请输入联系人");
                    return;
                }
                if (TextUtils.isEmpty(datas.get(i).count) || Integer.valueOf(datas.get(i).count) <= 0) {
                    toast("请输入提箱数量");
                    return;
                }

                num = Integer.valueOf(datas.get(i).count) + num;

                if (TextUtils.isEmpty(datas.get(i).deliveryDate)) {
                    toast("请输入预计提货日期");
                    return;
                }
                if (TextUtils.isEmpty(datas.get(i).plateNo)) {
                    toast("请输入车牌号");
                    return;
                }


                if (TextUtils.isEmpty(datas.get(i).deliveryNoteId)) {
                    toast("getDeliveryNoteId");
                    return;
                }
                if (TextUtils.isEmpty(datas.get(i).orderNo)) {
                    toast("getOrderNo");
                    return;
                }
            }

            if (!(num == numVaule)) {
                toast("您填写的提箱数量总和需等于购买数量!");
                return;
            }

//            System.out.println("base----toJson(col)--->" + new Gson().toJson(datas).toString());

            Collection.saveDeliveryNoteMai(this, deliveryNoteId, new Gson().toJson(datas).toString(), baseBean -> {
                toast(baseBean.getMsg());
                finishAc();
            });

        } else {
            toast("请添加车队信息");
        }


    }

    /**
     * 提交提货单 卖家提交
     */
    private void requestSubmit() {

        String containerHeapNo = binding.inputNo.getText().toString().trim();
        String heapName = binding.inputName.getText().toString().trim();
        String heapTelephone = binding.inputPhone.getText().toString().trim();
        String heapContact = binding.inputUser.getText().toString().trim();
        String heapAddress = binding.inputAddress.getText().toString().trim();
//        String deliveryDate = binding.deliveryTime.getText().toString().trim();
        String heapEMail = binding.inputEmail.getText().toString().trim();
        String containerNo = "";
        if (null != colChest && colChest.size() > 0) {
            for (int i = 0; i < colChest.size(); i++) {
                containerNo = containerNo + colChest.get(i) + ",";
            }
        }


        if (Verify.billOfLading(
                ordeNo,
                containerHeapNo,
                containerType,
                count,
                containerNo,
                heapName,
                heapTelephone,
                heapContact,
                heapAddress,
                heapEMail)) {


//            String isSpecialPrice = "";//1 有特殊费用   0 没有
//            String specialPrice = "";//特殊费用
//            if (binding.money.isChecked() && !binding.noMoney.isChecked()) {
//                isSpecialPrice = "1";
////                specialPrice = binding.inputMoney.getText().toString().trim();
//            } else if (binding.noMoney.isChecked() && !binding.money.isChecked()) {
//                isSpecialPrice = "0";
//            }
//
//            if (isSpecialPrice.equals("1")) {
//                if (TextUtils.isEmpty(specialPrice)) {
//                    toast("请输入特殊费用");
//                    return;
//                }
//            }

            Collection.saveDeliveryNote(this, ordeNo, containerHeapNo, containerType, containerTypeName, count,
                    containerNo, heapName, heapTelephone, heapAddress, heapContact,
                    "", "0", "", heapEMail, null, baseBean -> {
                        toast(baseBean.getMsg());
                        finishAc();
                    });

        }


    }


    private void setType() {

        type = getIntent().getStringExtra("type");
        ordeNo = getIntent().getStringExtra("orderNo");
        typeStatus = getIntent().getBooleanExtra("typeStatus", false);

//        System.out.println("base------type-------->" + type);
//        System.out.println("base-----ordeNo--------->" + ordeNo);

        if (type.equals("0")) {//买家填写提货单
            binding.inputNo.setEnabled(false);
            binding.inputChest.setEnabled(false);
            binding.inputEmail.setEnabled(false);
//            binding.inputMoney.setEnabled(false);
            binding.inputName.setEnabled(false);
            binding.inputAddress.setEnabled(false);
//            binding.deliveryTime.setEnabled(false);
            binding.addChest.setVisibility(View.GONE);
            binding.inputPhone.setEnabled(false);
            binding.inputUser.setEnabled(false);
            binding.button.setText("提交");
            binding.button.setVisibility(View.VISIBLE);
            binding.topbar.title.setText(R.string.billoflading_title);
            binding.modelButton.setVisibility(View.GONE);

        } else if (type.equals("1")) { //查看提货单

            binding.inputNo.setEnabled(false);
            binding.inputChest.setEnabled(false);
            binding.inputEmail.setEnabled(false);
//            binding.inputMoney.setEnabled(false);
            binding.inputName.setEnabled(false);
            binding.inputAddress.setEnabled(false);
//            binding.deliveryTime.setEnabled(false);
            binding.addChest.setVisibility(View.GONE);
            binding.inputPhone.setEnabled(false);
            binding.inputUser.setEnabled(false);
            binding.topbar.title.setText("查看提货单");
            binding.topbar.rightTextname.setText("提货单二维码");
            binding.topbar.rightTextModel.setVisibility(View.GONE);//TODO 暂时先隐藏
            binding.button.setText("下载提货单");
            binding.button.setVisibility(View.GONE);
            binding.modelButton.setVisibility(View.VISIBLE);

            String userflag = SpUtil.getString(SpUtil.USERFLAG);

            if (userflag.equals("0")) {//买家
                binding.rightButton.setVisibility(View.GONE);
//                binding.leftButton.setBackgroundResource(R.color.colorPrimary);
                binding.leftButton.setBackgroundResource(R.color.white);
            } else if (userflag.equals("1")) {//卖家
                binding.rightButton.setVisibility(View.VISIBLE);
            }

            if (typeStatus) {
                binding.rightButton.setText("发送提货单至买家");
            } else {
                binding.rightButton.setText("发送提货单至堆场");
            }

            //提货单二维码
            binding.topbar.rightTextModel.setOnClickListener(view -> {
                Intent i = new Intent(context, QRActivity.class);
                i.putExtra("qRCodeUrl", qRCodeUrl);
                startAc(i);
            });

            //保存提货单至本地
            binding.leftButton.setOnClickListener(v -> {

//                ScreenShot.saveImageToGallery(context, ScreenShot.getBitmapByView(binding.scrollView));
                Intent intent = new Intent(BillOfLadingActivity.this, DownloadBillActivity.class);
                intent.putExtra("orderNo", ordeNo);
                startAc(intent);

            });

            //发送提货单至堆场
            binding.rightButton.setOnClickListener(v ->
                    showOrderNoDialog()
            );

        } else if (type.equals("2")) {//卖家填写提货单
            binding.inputNo.setEnabled(true);
            binding.inputChest.setEnabled(true);
            binding.inputEmail.setEnabled(true);
//            binding.inputMoney.setEnabled(true);
            binding.inputName.setEnabled(true);
            binding.inputAddress.setEnabled(true);
            binding.deliveryTime.setEnabled(true);
            binding.addChest.setVisibility(View.VISIBLE);
            binding.inputPhone.setEnabled(true);
            binding.inputUser.setEnabled(true);
            binding.button.setText("提交");
            binding.button.setVisibility(View.VISIBLE);
            binding.topbar.title.setText(R.string.billoflading_title);
            binding.modelButton.setVisibility(View.GONE);

            //买家输入框置灰
            binding.llName.setBackgroundResource(R.drawable.round_corner_grey_border_two);
            binding.llAdd.setBackgroundResource(R.drawable.round_corner_grey_border_two);
            binding.itemItemCar.name.setBackgroundResource(R.drawable.round_corner_grey_border_two);
            binding.itemItemCar.phone.setBackgroundResource(R.drawable.round_corner_grey_border_two);
            binding.itemItemCar.number.setBackgroundResource(R.drawable.round_corner_grey_border_two);
            binding.itemItemCar.time.setBackgroundResource(R.drawable.round_corner_grey_border_two);
            binding.itemItemCar.carno.setBackgroundResource(R.drawable.round_corner_grey_border_two);

        }

    }


    private void addChest() {
        binding.addChest.setOnClickListener(view -> {
            if (binding.inputChest.getText().toString().isEmpty()) {
                toast("请填入箱号");
            } else {
                colChest.add(binding.inputChest.getText().toString());
                adapterChest.notifyDataSetChanged();
                binding.inputChest.setText("");
            }

        });
    }

    private void deleteChest() {
        binding.listChest.setFocusable(false);
        adapterChest = new ChestAdapter(context, colChest, type);
        adapterChest.setDeleteInterface(position -> {
            colChest.remove(position);
            adapterChest.notifyDataSetChanged();
        });
        binding.listChest.setAdapter(adapterChest);
    }

    private void setList() {

        BillOfLadingEntity itemData = new BillOfLadingEntity();
        itemData.deliveryNoteId = deliveryNoteId;
        itemData.orderNo = deliveryOrderNo;
        datas.add(itemData);

        initEditText(itemData, binding.inputCompanyName, binding.itemItemCar.name,
                binding.itemItemCar.phone, binding.itemItemCar.number, binding.itemItemCar.time,
                binding.itemItemCar.carno, binding.inputCompanyEmail, binding.itemItemCar.delete);

        //添加车队
        binding.itemItemCar.delete.setOnClickListener(v -> {

            BillOfLadingEntity itemData1 = new BillOfLadingEntity();
            itemData1.deliveryNoteId = deliveryNoteId;
            itemData1.orderNo = deliveryOrderNo;
            datas.add(itemData1);
            binding.llList.addView(getItemView(itemData1));

        });


    }


    private View getItemView(BillOfLadingEntity itemData) {

        View itemView = LayoutInflater.from(this).inflate(R.layout.item_car, null);
        TextView car = (TextView) itemView.findViewById(R.id.car);
        TextView delete = (TextView) itemView.findViewById(R.id.delete);
//        EditText input_company_name = (EditText) itemView.findViewById(R.id.input_company_name);
        EditText name = (EditText) itemView.findViewById(R.id.name);
        EditText phone = (EditText) itemView.findViewById(R.id.phone);
        EditText number = (EditText) itemView.findViewById(R.id.number);
        TextView time = (TextView) itemView.findViewById(R.id.time);
        EditText carno = (EditText) itemView.findViewById(R.id.carno);
//        EditText input_company_email = (EditText) itemView.findViewById(R.id.input_company_email);

        if (!TextUtils.isEmpty(itemData.motorcadeName)) {
            car.setText(itemData.motorcadeName);
        }
        if (!TextUtils.isEmpty(itemData.companyName)) {
//            input_company_name.setText(itemData.companyName);
            binding.inputCompanyName.setText(itemData.companyName);
        }
        if (!TextUtils.isEmpty(itemData.motorcadeName)) {
            name.setText(itemData.motorcadeName);
        }
        if (!TextUtils.isEmpty(itemData.contactTelephone)) {
            phone.setText(itemData.contactTelephone);
        }
        if (!TextUtils.isEmpty(itemData.count)) {
            number.setText(itemData.count);
        }
        if (!TextUtils.isEmpty(itemData.deliveryDate)) {
            time.setText(itemData.deliveryDate);
        }
        if (!TextUtils.isEmpty(itemData.plateNo)) {
            carno.setText(itemData.plateNo);
        }
        if (!TextUtils.isEmpty(itemData.companyEMail)) {
//            input_company_email.setText(itemData.companyEMail);
            binding.inputCompanyEmail.setText(itemData.companyEMail);
        }


        car.setText("车队");
        delete.setText("删除");

        delete.setOnClickListener(view -> {
            binding.llList.removeView(itemView);
            datas.remove(itemData);
        });

        initEditText(itemData, binding.inputCompanyName, name, phone, number, time, carno, binding.inputCompanyEmail, delete);

        return itemView;
    }


    /**
     * 发送提货单至堆场
     * 显示订单框
     */
    private void showOrderNoDialog() {
        OrderNoDialog alert = new OrderNoDialog.Builder(this)// builder
                .setIsShow(false)
                .setTitle("填写邮箱地址")
                .setPositiveButton((content, dialog) -> {
                    if (content.isEmpty()) {
                        toast("请填写邮箱地址");
                        return;
                    }

                    if (!CheckParamsUtils.checkEmail(content)) {
                        toast("请填写正确格式邮箱地址");
                        return;
                    }

                    Collection.requestSendDeliveryNote(this, ordeNo, content, baseBean -> {
                        dialog.dismiss();
                        toast(baseBean.getMsg());
                    });
                })
                .setNegativeButton((content, dialog) -> {
                    dialog.dismiss();
                })
                .create();
        alert.show();
    }


    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(false);
        binding.refresh.setColorSchemeColors(loadingColors);
    }

    private void setTopbar() {
        binding.topbar.toolbar.setTitle("");
        binding.topbar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        setSupportActionBar(binding.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }


    private void initEditText(BillOfLadingEntity itemData, EditText inputCompanyName, EditText name,
                              EditText phone, EditText number,
                              TextView time, EditText carno,
                              EditText inputCompanyEmail, TextView delete) {

//        inputCompanyName.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                itemData.companyName = s.toString();
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//            }
//        });

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                itemData.motorcadeName = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                itemData.contactTelephone = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                itemData.count = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


//        time.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//
//                itemData.deliveryDate = s.toString();
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//            }
//        });

        carno.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                itemData.plateNo = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


//        inputCompanyEmail.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                itemData.companyEMail = s.toString();
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//            }
//        });


        if (type.equals("0")) {
            delete.setVisibility(View.VISIBLE);
            name.setEnabled(true);
            phone.setEnabled(true);
            number.setEnabled(true);
//            time.setEnabled(true);
            carno.setEnabled(true);
            inputCompanyEmail.setEnabled(true);
            inputCompanyName.setEnabled(true);

            time.setOnClickListener(v -> {

                Calendar selectedDate = Calendar.getInstance();
                Calendar startDate = Calendar.getInstance();
                //startDate.set(2013,1,1);
                Calendar endDate = Calendar.getInstance();
                //endDate.set(2020,1,1);
                //正确设置方式 原因：注意事项有说明
                selectedDate.setTimeInMillis(System.currentTimeMillis());
                startDate.setTimeInMillis(System.currentTimeMillis());
                endDate.set(2099, 11, 31);

                //时间选择器
                TimePickerView.Builder pvTime = new TimePickerView.Builder(BillOfLadingActivity.this, (date, v1) -> {
                    time.setText(DateUtils.getStringFromDate(date, DateUtils.FORMAT_DATE_TWO));
                    itemData.deliveryDate = time.getText().toString().trim();
                });
                pvTime.setTitleBgColor(getResources().getColor(R.color.colorPrimary));
                pvTime.setSubmitColor(Color.WHITE);
                pvTime.setCancelColor(Color.WHITE);
                pvTime.setDate(selectedDate);// 如果不设置的话，默认是系统时间*/  //注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
                pvTime.setRangDate(startDate, endDate);//起始终止年月日设定
                pvTime.setType(new boolean[]{true, true, true, false, false, false});

                TimePickerView timePicker = pvTime.build();
                if (!timePicker.isShowing()) {
                    timePicker.show();
                }

            });

        } else if (type.equals("1")) {
            delete.setVisibility(View.GONE);
            name.setEnabled(false);
            phone.setEnabled(false);
            number.setEnabled(false);
//            time.setEnabled(false);
            carno.setEnabled(false);
            inputCompanyEmail.setEnabled(false);
            inputCompanyName.setEnabled(false);
            time.setOnClickListener(null);
        } else if (type.equals("2")) {
            delete.setVisibility(View.GONE);
            name.setEnabled(false);
            phone.setEnabled(false);
            number.setEnabled(false);
//            time.setEnabled(false);
            carno.setEnabled(false);
            inputCompanyEmail.setEnabled(false);
            inputCompanyName.setEnabled(false);
            time.setOnClickListener(null);
        } else if (type.equals("3")) {
            delete.setVisibility(View.GONE);
            name.setEnabled(false);
            phone.setEnabled(false);
            number.setEnabled(false);
//            time.setEnabled(false);
            carno.setEnabled(false);
            inputCompanyEmail.setEnabled(false);
            inputCompanyName.setEnabled(false);
            time.setOnClickListener(null);
        }

    }


}
