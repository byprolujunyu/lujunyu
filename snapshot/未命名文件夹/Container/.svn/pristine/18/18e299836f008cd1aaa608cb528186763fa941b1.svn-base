package com.bm.container.Tools;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bm.container.R;
import com.bm.container.module.BaseApplication;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;


/**
 * 校验类
 * <p>
 * 专业从事各种edittext输入内容校验
 */

public class Verify {

    public static Context context = BaseApplication.context;

    public static void toast(String message) {
        Toast.makeText(BaseApplication.context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 是否手机号
     */
    public static boolean phone(String phoneNumber) {
        return phoneNumber.length() == 11 && Pattern.compile("[0-9]{1,}").matcher(phoneNumber).matches();
    }

    /**
     * 是否e-mail
     */
    public static boolean email(String emailNumber) {
        return !TextUtils.isEmpty(emailNumber) && Patterns.EMAIL_ADDRESS.matcher(emailNumber).matches();
    }

    /**
     * 是否6-12位字符
     */
    public static boolean pwd(String pwd) {
        return pwd.length() >= 6 && pwd.length() <= 12;
    }

    /**
     * P3登录
     * <p>
     * 登录前的输入验证
     */
    public static boolean login(EditText phone, EditText pwd) {
        String tempPhone = phone.getText().toString();
        String tempPwd = pwd.getText().toString();

        // 手机号不为空
        if (TextUtils.isEmpty(tempPhone)) {
            toast(context.getString(R.string.verify_phone_empty));
            return false;
        }

        // 手机号格式
        if (!phone(tempPhone)) {
            toast(context.getString(R.string.verify_phone_right));
            return false;
        }

        // 密码不为空
        if (TextUtils.isEmpty(tempPwd)) {
            toast(context.getString(R.string.verify_pwd_empty));
            return false;
        }

        // 密码6-12位
        if (!pwd(tempPwd)) {
            toast(context.getString(R.string.verify_pwd_right));
            return false;
        }

        return true;
    }


    /**
     * 发送验证码(按钮textview)
     */

    public static boolean sendCode(EditText phone, TextView button) {
        String tempPhone = phone.getText().toString();
        String tempButton = button.getText().toString();
        // 手机号不为空
        if (TextUtils.isEmpty(tempPhone)) {
            toast(context.getString(R.string.verify_phone_empty));
            return false;
        }

        // 手机号格式
        if (!phone(tempPhone)) {
            toast(context.getString(R.string.verify_phone_right));
            return false;
        }

        // 验证码已发送
        if (!tempButton.equals(context.getString(R.string.verify_code_text))) {
            toast(context.getString(R.string.verify_code_sended));
            return false;
        }

        return true;
    }

    /**
     * 发送验证码(按钮button)
     */

    public static boolean sendCode(EditText phone, Button button) {
        String tempPhone = phone.getText().toString();
        String tempButton = button.getText().toString();
        // 手机号不为空
        if (TextUtils.isEmpty(tempPhone)) {
            toast(context.getString(R.string.verify_phone_empty));
            return false;
        }

        // 手机号格式
        if (!phone(tempPhone)) {
            toast(context.getString(R.string.verify_phone_right));
            return false;
        }

        // 验证码已发送
        if (!tempButton.equals(context.getString(R.string.verify_code_text))) {
            toast(context.getString(R.string.verify_code_sended));
            return false;
        }

        return true;
    }

    /**
     * 修改密码页面专用
     * 不需要输入手机号的页面
     * 手机号使用登录人手机号即可
     * 发送验证码(按钮TextView)
     */

    public static boolean sendCode(TextView button) {
        String tempPhone = SpUtil.getString(SpUtil.PHONE);
        String tempButton = button.getText().toString();
        // 手机号不为空
        if (TextUtils.isEmpty(tempPhone)) {
            toast(context.getString(R.string.verify_not_register));
            return false;
        }

        // 手机号格式
        if (!phone(tempPhone)) {
            toast(context.getString(R.string.verify_phone_right));
            return false;
        }

        // 验证码已发送
        if (!tempButton.equals(context.getString(R.string.verify_code_text))) {
            toast(context.getString(R.string.verify_code_sended));
            return false;
        }

        return true;
    }

    /**
     * 修改密码页面专用
     * 不需要输入手机号的页面
     * 手机号使用登录人手机号即可
     * 发送验证码(按钮Button)
     */

    public static boolean sendCode(Button button) {
        String tempPhone = SpUtil.getString(SpUtil.PHONE);
        String tempButton = button.getText().toString();
        // 手机号不为空
        if (TextUtils.isEmpty(tempPhone)) {
            toast(context.getString(R.string.verify_not_register));
            return false;
        }

        // 手机号格式
        if (!phone(tempPhone)) {
            toast(context.getString(R.string.verify_phone_right));
            return false;
        }

        // 验证码已发送
        if (!tempButton.equals(context.getString(R.string.verify_code_text))) {
            toast(context.getString(R.string.verify_code_sended));
            return false;
        }

        return true;
    }


    /**
     * P3_1注册
     * <p>
     * （要勾选注册协议）
     */

    public static boolean register(EditText phone, EditText code, EditText pwd1, EditText pwd2, CheckBox box) {

        String tempPhone = phone.getText().toString();
        String tempCode = code.getText().toString();
        String tempPwd1 = pwd1.getText().toString();
        String tempPwd2 = pwd2.getText().toString();
        String savePhone = SpUtil.getString(SpUtil.CODEPHONE);
        String saveCode = SpUtil.getString(SpUtil.CODECODE);
        Boolean isChecked = box.isChecked();

        // 手机号不为空
        if (TextUtils.isEmpty(tempPhone)) {
            toast(context.getString(R.string.verify_phone_empty));
            return false;
        }

        // 手机号格式
        if (!phone(tempPhone)) {
            toast(context.getString(R.string.verify_phone_right));
            return false;
        }

        // 验证码不为空
        if (TextUtils.isEmpty(tempCode)) {
            toast(context.getString(R.string.verify_code_empty));
            return false;
        }

        // 验证码和手机号不匹配
        if (!savePhone.equals(tempPhone) || !saveCode.equals(tempCode)) {
            toast(context.getString(R.string.verify_code_right));
            return false;
        }

        // 密码不为空
        if (TextUtils.isEmpty(tempPwd1)) {
            toast(context.getString(R.string.verify_pwd_empty));
            return false;
        }

        // 密码6-12位
        if (!pwd(tempPwd1)) {
            toast(context.getString(R.string.verify_pwd_right));
            return false;
        }

        // 再次输入密码不为空
        if (TextUtils.isEmpty(tempPwd2)) {
            toast(context.getString(R.string.verify_pwd2_empty));
            return false;
        }

        // 两次输入密码需一致
        if (!tempPwd1.equals(tempPwd2)) {
            toast(context.getString(R.string.verify_pwd2_right));
            return false;
        }

        // 勾选协议
        if (!isChecked) {
            toast(context.getString(R.string.verify_agreement_checked));
            return false;
        }

        return true;
    }

    /**
     * P3_4忘记密码
     * <p>
     * （不要勾选注册协议）
     */

    public static boolean forget(EditText phone, EditText code, EditText pwd1, EditText pwd2) {

        String tempPhone = phone.getText().toString();
        String tempCode = code.getText().toString();
        String tempPwd1 = pwd1.getText().toString();
        String tempPwd2 = pwd2.getText().toString();
        String savePhone = SpUtil.getString(SpUtil.CODEPHONE);
        String saveCode = SpUtil.getString(SpUtil.CODECODE);

        // 手机号不为空
        if (TextUtils.isEmpty(tempPhone)) {
            toast(context.getString(R.string.verify_phone_empty));
            return false;
        }

        // 手机号格式
        if (!phone(tempPhone)) {
            toast(context.getString(R.string.verify_phone_right));
            return false;
        }

        // 验证码不为空
        if (TextUtils.isEmpty(tempCode)) {
            toast(context.getString(R.string.verify_code_empty));
            return false;
        }

        // 验证码和手机号不匹配
        if (!savePhone.equals(tempPhone) || !saveCode.equals(tempCode)) {
            toast(context.getString(R.string.verify_code_right));
            return false;
        }

        // 密码不为空
        if (TextUtils.isEmpty(tempPwd1)) {
            toast(context.getString(R.string.verify_pwd_empty));
            return false;
        }

        // 密码6-12位
        if (!pwd(tempPwd1)) {
            toast(context.getString(R.string.verify_phone_right));
            return false;
        }

        // 再次输入密码不为空
        if (TextUtils.isEmpty(tempPwd2)) {
            toast(context.getString(R.string.verify_pwd2_empty));
            return false;
        }

        // 两次输入密码需一致
        if (!tempPwd1.equals(tempPwd2)) {
            toast(context.getString(R.string.verify_pwd2_right));
            return false;
        }

        return true;
    }

    /**
     * P8_1 修改密码
     */
    public static boolean change(EditText pwd, EditText pwd1, EditText pwd2) {
        String tempPwd = pwd.getText().toString();
        String tempPwd1 = pwd1.getText().toString();
        String tempPwd2 = pwd2.getText().toString();

        // 密码不为空
        if (TextUtils.isEmpty(tempPwd)) {
            toast("请输入原密码");
            return false;
        }

        // 密码6-12位
        if (!tempPwd.equals(SpUtil.getString(SpUtil.PWD))) {
            toast("原密码不正确");
            return false;
        }

        // 密码不为空
        if (TextUtils.isEmpty(tempPwd1)) {
            toast("请输入新密码");
            return false;
        }

        // 密码6-12位
        if (!pwd(tempPwd1)) {
            toast("新密码不正确");
            return false;
        }

        // 再次输入密码不为空
        if (TextUtils.isEmpty(tempPwd2)) {
            toast(context.getString(R.string.verify_pwd2_empty));
            return false;
        }

        // 两次输入密码需一致
        if (!tempPwd1.equals(tempPwd2)) {
            toast(context.getString(R.string.verify_pwd2_right));
            return false;
        }

        if (tempPwd.equals(tempPwd1) || tempPwd.equals(tempPwd2)) {
            toast("新密码不可与原密码相同");
            return false;
        }

        return true;
    }

    /**
     * P8_1 修改密码
     */
    public static boolean change(EditText pwd, EditText pwd1, EditText pwd2, EditText code) {
        String tempPwd = pwd.getText().toString();
        String tempPwd1 = pwd1.getText().toString();
        String tempPwd2 = pwd2.getText().toString();
        String tempCode = code.getText().toString();
        String tempPhone = SpUtil.getString(SpUtil.PHONE);
        String savePhone = SpUtil.getString(SpUtil.CODEPHONE);
        String saveCode = SpUtil.getString(SpUtil.CODECODE);

        // 密码不为空
        if (TextUtils.isEmpty(tempPwd)) {
            toast("请输入原密码");
            return false;
        }

        // 密码6-12位
        if (!tempPwd.equals(SpUtil.getString(SpUtil.PWD))) {
            toast("原密码不正确");
            return false;
        }

        // 密码不为空
        if (TextUtils.isEmpty(tempPwd1)) {
            toast("请输入新密码");
            return false;
        }

        // 密码6-12位
        if (!pwd(tempPwd1)) {
            toast("新密码不正确");
            return false;
        }

        // 再次输入密码不为空
        if (TextUtils.isEmpty(tempPwd2)) {
            toast(context.getString(R.string.verify_pwd2_empty));
            return false;
        }

        // 两次输入密码需一致
        if (!tempPwd1.equals(tempPwd2)) {
            toast(context.getString(R.string.verify_pwd2_right));
            return false;
        }

        if (tempPwd.equals(tempPwd1) || tempPwd.equals(tempPwd2)) {
            toast("新密码不可与原密码相同");
            return false;
        }

        // 验证码不为空
        if (TextUtils.isEmpty(tempCode)) {
            toast(context.getString(R.string.verify_code_empty));
            return false;
        }

        // 验证码和手机号不匹配
        if (!savePhone.equals(tempPhone) || !saveCode.equals(tempCode)) {
            toast(context.getString(R.string.verify_code_right));
            return false;
        }

        return true;
    }

    /**
     * P3_3身份认证
     */
    public static boolean buyPerson(TextView country, TextView city, EditText name, EditText phone) {

        String tempCountry = country.getText().toString();
        String tempCity = city.getText().toString();
        String tempName = name.getText().toString();
        String tempPhone = phone.getText().toString();

        if (TextUtils.isEmpty(tempName)) {
            toast(context.getString(R.string.identification_user_name_hint));
            return false;
        }

        if (TextUtils.isEmpty(tempPhone)) {
            toast(context.getString(R.string.identification_user_phone_hint));
            return false;
        }

        if (tempCountry.equals(context.getString(R.string.identification_country_choose))) {
            toast(context.getString(R.string.identification_country_choose));
            return false;
        }

        if (tempCity.equals(context.getString(R.string.identification_city_choose))) {
            toast(context.getString(R.string.identification_city_choose));
            return false;
        }

//        if (files.size() < 2) {
//            toast("请上传证件照");
//            return false;
//        }

        return true;
    }

    /**
     * P3_3身份认证
     */
    public static boolean buyCompany(TextView country, TextView city, EditText name, EditText phone, EditText address, EditText person) {

        String tempCountry = country.getText().toString();
        String tempCity = city.getText().toString();
        String tempName = name.getText().toString();
        String tempPhone = phone.getText().toString();
        String tempAddress = address.getText().toString();
        String tempPerson = person.getText().toString();

        if (TextUtils.isEmpty(tempName)) {
            toast(context.getString(R.string.identification_company_name_hint));
            return false;
        }

        if (TextUtils.isEmpty(tempPhone)) {
            toast(context.getString(R.string.identification_company_phone_hint));
            return false;
        }

        if (TextUtils.isEmpty(tempAddress)) {
            toast(context.getString(R.string.identification_company_address_hint));
            return false;
        }

        if (TextUtils.isEmpty(tempPerson)) {
            toast(context.getString(R.string.identification_company_person_hint));
            return false;
        }

        if (tempCountry.equals(context.getString(R.string.identification_country_choose))) {
            toast(context.getString(R.string.identification_country_choose));
            return false;
        }

        if (tempCity.equals(context.getString(R.string.identification_city_choose))) {
            toast(context.getString(R.string.identification_city_choose));
            return false;
        }

//        if (files.size() < 1) {
//            toast("请上传证件照");
//            return false;
//        }

        return true;
    }

    /**
     * P3_3身份认证
     */
    public static boolean salePerson(TextView country, TextView city, EditText name, EditText phone, EditText bankName, TextView bank, EditText bankId, List<String> citys, HashMap<Integer, File> files) {

        String tempCountry = country.getText().toString();
        String tempCity = city.getText().toString();
        String tempName = name.getText().toString();
        String tempPhone = phone.getText().toString();
        String tempBankName = bankName.getText().toString();
        String tempBank = bank.getText().toString();
        String tempBankId = bankId.getText().toString();

        if (TextUtils.isEmpty(tempName)) {
            toast(context.getString(R.string.identification_user_name_hint));
            return false;
        }

        if (TextUtils.isEmpty(tempPhone)) {
            toast(context.getString(R.string.identification_user_phone_hint));
            return false;
        }

        if (TextUtils.isEmpty(tempBankName)) {
            toast(context.getString(R.string.identification_bank_name_hint));
            return false;
        }

        if (TextUtils.isEmpty(tempBank)) {
            toast(context.getString(R.string.identification_bank_hint));
            return false;
        }

        if (TextUtils.isEmpty(tempBankId)) {
            toast(context.getString(R.string.identification_bank_id_hint));
            return false;
        }

        if (citys.size() == 0) {
            toast(context.getString(R.string.verify_city_empty));
            return false;
        }

        if (tempCountry.equals(context.getString(R.string.identification_country_choose))) {
            toast(context.getString(R.string.identification_country_choose));
            return false;
        }

        if (tempCity.equals(context.getString(R.string.identification_city_choose))) {
            toast(context.getString(R.string.identification_city_choose));
            return false;
        }

        if (files.size() < 2) {
            toast("请上传证件照");
            return false;
        }

        return true;
    }


    /**
     * P3_3身份认证
     */
    public static boolean saleCompany(TextView country, TextView city, EditText name, EditText phone, EditText address, EditText person, EditText bankName, TextView bank, EditText bankId, List<String> citys, HashMap<Integer, File> files) {

        String tempCountry = country.getText().toString();
        String tempCity = city.getText().toString();
        String tempName = name.getText().toString();
        String tempPhone = phone.getText().toString();
        String tempAddress = address.getText().toString();
        String tempPerson = person.getText().toString();
        String tempBankName = bankName.getText().toString();
        String tempBank = bank.getText().toString();
        String tempBankId = bankId.getText().toString();

        if (TextUtils.isEmpty(tempName)) {
            toast(context.getString(R.string.identification_company_name_hint));
            return false;
        }

        if (TextUtils.isEmpty(tempPhone)) {
            toast(context.getString(R.string.identification_company_phone_hint));
            return false;
        }

        if (TextUtils.isEmpty(tempAddress)) {
            toast(context.getString(R.string.identification_company_address_hint));
            return false;
        }

        if (TextUtils.isEmpty(tempPerson)) {
            toast(context.getString(R.string.identification_company_person_hint));
            return false;
        }

        if (TextUtils.isEmpty(tempBankName)) {
            toast(context.getString(R.string.identification_bank_name_hint));
            return false;
        }

        if (TextUtils.isEmpty(tempBank)) {
            toast(context.getString(R.string.identification_bank_hint));
            return false;
        }

        if (TextUtils.isEmpty(tempBankId)) {
            toast(context.getString(R.string.identification_bank_id_hint));
            return false;
        }

        if (citys.size() == 0) {
            toast(context.getString(R.string.verify_city_empty));
            return false;
        }

        if (tempCountry.equals(context.getString(R.string.identification_country_choose))) {
            toast(context.getString(R.string.identification_country_choose));
            return false;
        }

        if (tempCity.equals(context.getString(R.string.identification_city_choose))) {
            toast(context.getString(R.string.identification_city_choose));
            return false;
        }

        if (files.size() < 1) {
            toast("请上传证件照");
            return false;
        }

        return true;
    }

    /**
     * 修改个人信息
     */
    public static boolean changePersonInfo(EditText name, EditText address, EditText bankName, TextView bank, EditText bankId, List<String> citys) {
        String tempName = name.getText().toString();
        String tempAddress = address.getText().toString();
        String tempBankName = bankName.getText().toString();
        String tempBank = bank.getText().toString();
        String tempBankId = bankId.getText().toString();

        if (TextUtils.isEmpty(tempName)) {
            toast(context.getString(R.string.identification_user_name_hint));
            return false;
        }

        if (TextUtils.isEmpty(tempAddress)) {
            toast("请输入地址");
            return false;
        }

        /**
         * 如果是买家不显示银行信息
         */
        if (SpUtil.getString(SpUtil.USERFLAG).equals("1")) {

            if (TextUtils.isEmpty(tempBankName)) {
                toast(context.getString(R.string.identification_bank_name_hint));
                return false;
            }

            if (TextUtils.isEmpty(tempBank)) {
                toast(context.getString(R.string.identification_bank_hint));
                return false;
            }

            if (TextUtils.isEmpty(tempBankId)) {
                toast(context.getString(R.string.identification_bank_id_hint));
                return false;
            }

            if (citys.size() == 0) {
                toast(context.getString(R.string.verify_city_empty));
                return false;
            }
        }


        return true;
    }

    /**
     * 修改个人信息
     */
    public static boolean changeCompanyInfo(EditText name, EditText phone, EditText address, EditText person, EditText bankName, TextView bank, EditText bankId, List<String> citys) {
        String tempName = name.getText().toString();
        String tempPhone = phone.getText().toString();
        String tempAddress = address.getText().toString();
        String tempPerson = person.getText().toString();
        String tempBankName = bankName.getText().toString();
        String tempBank = bank.getText().toString();
        String tempBankId = bankId.getText().toString();

        if (TextUtils.isEmpty(tempName)) {
            toast(context.getString(R.string.identification_user_name_hint));
            return false;
        }

        if (TextUtils.isEmpty(tempPhone)) {
            toast("公司电话不能为空");
            return false;
        }

        if (TextUtils.isEmpty(tempAddress)) {
            toast("请输入地址");
            return false;
        }

        if (TextUtils.isEmpty(tempPerson)) {
            toast("请输入负责人姓名");
            return false;
        }

        /**
         * 如果是买家不显示银行信息
         */
        if (SpUtil.getString(SpUtil.USERFLAG).equals("1")) {
            if (TextUtils.isEmpty(tempBankName)) {
                toast(context.getString(R.string.identification_bank_name_hint));
                return false;
            }

            if (TextUtils.isEmpty(tempBank)) {
                toast(context.getString(R.string.identification_bank_hint));
                return false;
            }

            if (TextUtils.isEmpty(tempBankId)) {
                toast(context.getString(R.string.identification_bank_id_hint));
                return false;
            }

            if (citys.size() == 0) {
                toast(context.getString(R.string.verify_city_empty));
                return false;
            }

        }

        return true;
    }

    /**
     * 发布买箱信息
     */
    public static boolean sendBuyInfo(String countryId, String cityId, String typeId, String statusId, String num, String timeId, String titleName, String content, String age) {
        if (TextUtils.isEmpty(countryId)) {
            toast("请选择国家");
            return false;
        }

        if (TextUtils.isEmpty(cityId)) {
            toast("请选择城市");
            return false;
        }

        if (TextUtils.isEmpty(titleName)) {
            toast("请输入标题");
            return false;
        }

        if (TextUtils.isEmpty(typeId)) {
            toast("请选择箱型");
            return false;
        }

        if (TextUtils.isEmpty(statusId)) {
            toast("请选择箱况");
            return false;
        }

        if (TextUtils.isEmpty(age)) {
            toast("请输入箱子生产年份");
            return false;
        }

        Integer ageVaule = Integer.valueOf(age);
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        if (ageVaule < 1990 || ageVaule > yearCurrent) {
            toast("请输正确的年份");
            return false;
        }

        if (TextUtils.isEmpty(num) || Integer.valueOf(num) <= 0) {
            toast("请填写数量");
            return false;
        }


        if (TextUtils.isEmpty(timeId)) {
            toast("请选择时间");
            return false;
        }

        return true;

    }

    /**
     * 发布卖箱信息
     */
    public static boolean sendSaleInfo(String countryId, String cityId, String typeId, String statusId, String num,
                                       String tradeId, String money, String timeId, String isSpecial, String specialFee,
                                       String hasInvoice, String titleName, String editLowPriceVaule, String age, HashMap<Integer, File> files) {
        if (TextUtils.isEmpty(countryId)) {
            toast("请选择国家");
            return false;
        }

        if (TextUtils.isEmpty(cityId)) {
            toast("请选择城市");
            return false;
        }

        if (TextUtils.isEmpty(titleName)) {
            toast("请输入标题");
            return false;
        }

        if (TextUtils.isEmpty(typeId)) {
            toast("请选择箱型");
            return false;
        }

        if (TextUtils.isEmpty(statusId)) {
            toast("请选择箱况");
            return false;
        }

        if (TextUtils.isEmpty(age)) {
            toast("请输入箱子生产年份");
            return false;
        }

        Integer ageVaule = Integer.valueOf(age);
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        if (ageVaule < 1990 || ageVaule > yearCurrent) {
            toast("请输正确的年份");
            return false;
        }

        if (TextUtils.isEmpty(num) || Integer.valueOf(num) <= 0) {
            toast("请填写数量");
            return false;
        }

        if (tradeId.equals("0") && TextUtils.isEmpty(money)) {
            toast("请输入报价金额");
            return false;
        } else if (tradeId.equals("0") && !TextUtils.isEmpty(money)) {
            if (Integer.valueOf(money) <= 0) {
                toast("请输入报价金额");
                return false;
            }

        }

        if (tradeId.equals("1") && TextUtils.isEmpty(timeId)) {
            toast("请选择有效时间");
            return false;
        }

        if (tradeId.equals("1") && TextUtils.isEmpty(editLowPriceVaule)) {
            toast("请输入投标底价");
            return false;
        } else if (tradeId.equals("1") && !TextUtils.isEmpty(editLowPriceVaule)) {
            if (Integer.valueOf(editLowPriceVaule) <= 0) {
                toast("请输入投标底价");
                return false;
            }
        }

        if (isSpecial.equals("1") && TextUtils.isEmpty(specialFee)) {
            toast("请输入特殊费用");
            return false;
        } else if (isSpecial.equals("1") && !TextUtils.isEmpty(specialFee)) {
            if (Integer.valueOf(specialFee) <= 0) {
                toast("请输入特殊费用");
                return false;
            }
        }

//		if (files.size() == 0) {
//			toast("请至少选择一张箱子图片");
//			return false;
//		}

//		if (files.get(0) == null) {
//			toast("请选择正面图片");
//			return false;
//		}
//
//		if (files.get(1) == null) {
//			toast("请选择侧面（左）图片");
//			return false;
//		}
//
//		if (files.get(2) == null) {
//			toast("CSC PLATE图片");
//			return false;
//		}
//
//		if (files.get(3) == null) {
//			toast("请选择面后图片");
//			return false;
//		}
//
//		if (files.get(4) == null) {
//			toast("请选择侧面（右）图片");
//			return false;
//		}
//
//		if (files.get(5) == null) {
//			toast("请选择箱子内部图片");
//			return false;
//		}

        return true;

    }

    /**
     * 出价
     */
    public static boolean offerPrice(String number, String price, String isSpecial, String specialPice) {
        if (TextUtils.isEmpty(number)) {
            toast("请输入可提供数量");
            return false;
        }
        if (TextUtils.isEmpty(price)) {
            toast("请输入出价");
            return false;
        }

//        if (isSpecial.equals(1) && specialPice.isEmpty()) {
//            toast("请输入特殊费用");
//            return false;
//        }

        if (isSpecial.equals("1") && TextUtils.isEmpty(specialPice)) {
            toast("请输入特殊费用");
            return false;
        } else if (isSpecial.equals("1") && !TextUtils.isEmpty(specialPice) && Integer.valueOf(specialPice) <= 0) {
            toast("请输入特殊费用");
            return false;
        }

        return true;
    }

    /**
     * 购买订单
     * 点击购买
     */
    public static boolean buyOrderBuy(CheckBox checkInvoice, boolean isCheckedVaule, String head, String bankName, String bankIdText, String etAdd, String invoicePhone, String content) {

        if (checkInvoice.isChecked()) {

            if (isCheckedVaule) {
                if (TextUtils.isEmpty(head)) {
                    toast("请输入发票抬头");
                    return false;
                }
            } else {

                if (TextUtils.isEmpty(head)) {
                    toast("请输入发票抬头");
                    return false;
                }

                if (TextUtils.isEmpty(content)) {
                    toast("请输纳税人识别号");
                    return false;
                }

                if (TextUtils.isEmpty(bankName)) {
                    toast("请输入开户行名称");
                    return false;
                }

                if (TextUtils.isEmpty(bankIdText)) {
                    toast("请输入开户行账号");
                    return false;
                }

                if (TextUtils.isEmpty(etAdd)) {
                    toast("请输入公司地址");
                    return false;
                }

                if (TextUtils.isEmpty(invoicePhone)) {
                    toast("请输入公司电话");
                    return false;
                }

            }


//            if (TextUtils.isEmpty(content)) {
//                toast("请填写发票内容");
//                return false;
//            }

//            if (TextUtils.isEmpty(head)) {
//                toast("请填写手机号码");
//                return false;
//            }

//            if (!phone(phone)) {
//                toast("手机号不正确");
//                return false;
//            }

        }
        return true;
    }

    /**
     * 出售订单
     * 出价
     */
    public static boolean offerPrice(CheckBox checkInvoice, boolean isCheckedVaule, String head, String bankName, String bankIdText, String etAdd, String invoicePhone, String content, String price) {
        if (checkInvoice.isChecked()) {

            if (isCheckedVaule) {

                if (TextUtils.isEmpty(head)) {
                    toast("请输入发票抬头");
                    return false;
                }

            } else {

                if (TextUtils.isEmpty(head)) {
                    toast("请输入发票抬头");
                    return false;
                }

                if (TextUtils.isEmpty(content)) {
                    toast("请输纳税人识别号");
                    return false;
                }

                if (TextUtils.isEmpty(bankName)) {
                    toast("请输入开户行名称");
                    return false;
                }

                if (TextUtils.isEmpty(bankIdText)) {
                    toast("请输入开户行账号");
                    return false;
                }

                if (TextUtils.isEmpty(etAdd)) {
                    toast("请输入公司地址");
                    return false;
                }

                if (TextUtils.isEmpty(invoicePhone)) {
                    toast("请输入公司电话");
                    return false;
                }

            }

//            if (TextUtils.isEmpty(head)) {
//                toast("请填写发票抬头");
//                return false;
//            }
//
//            if (TextUtils.isEmpty(content)) {
//                toast("请填写发票内容");
//                return false;
//            }
//
//            if (TextUtils.isEmpty(head)) {
//                toast("请填写手机号码");
//                return false;
//            }

//            if (!phone(phone)) {
//                toast("手机号不正确");
//                return false;
//            }

        }

        if (TextUtils.isEmpty(price)) {
            toast("请填写出价");
            return false;
        }

        return true;
    }

    /**
     * P3_1注册
     * <p>
     * （要勾选注册协议）
     */

    public static boolean billOfLading(String orderNo, String containerHeapNo, String containerTypeName,
                                       String count, String containerNo, String heapName, String heapTelephone,
                                       String heapContact, String inputAddress, String heapEMail) {


        if (TextUtils.isEmpty(orderNo)) {
            toast("订单编号不能为空");
            return false;
        }

        if (TextUtils.isEmpty(containerHeapNo)) {
            toast("请输入堆场放箱号");
            return false;
        }

        if (TextUtils.isEmpty(containerTypeName)) {
            toast("箱型不能为空");
            return false;
        }

        if (TextUtils.isEmpty(count)) {
            toast("数量不能为空");
            return false;
        }

//        if (TextUtils.isEmpty(containerNo)) {
//            toast("请添加箱号");
//            return false;
//        }

        // 验证码不为空
        if (TextUtils.isEmpty(heapName)) {
            toast("请输入堆场名称");
            return false;
        }

        if (TextUtils.isEmpty(heapTelephone)) {
            toast("请输入堆场电话");
            return false;
        }

        if (TextUtils.isEmpty(heapContact)) {
            toast("请输入堆场联系人姓名");
            return false;
        }

        if (TextUtils.isEmpty(inputAddress)) {
            toast("请输入堆场地址");
            return false;
        }

//        if (TextUtils.isEmpty(deliveryDate)) {
//            toast("请输入时间");
//            return false;
//        }

        if (TextUtils.isEmpty(heapEMail)) {
            toast("请输入邮箱地址");
            return false;
        }

        if (!CheckParamsUtils.checkEmail(heapEMail)) {
            toast("请填写正确格式邮箱地址");
            return false;
        }

        return true;
    }

}