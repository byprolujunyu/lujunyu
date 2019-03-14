package com.bm.container.http;

import android.text.TextUtils;

import com.bm.container.Tools.SpUtil;
import com.bm.container.entity.AlipayBaenEntity;
import com.bm.container.entity.OrderEntity;
import com.bm.container.entity.SaveSaleOfferInfoEntity;
import com.bm.container.entity.UserMeesageEntity;
import com.bm.container.entity.WeiXinPayEntity;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.BaseFragment;
import com.bm.container.module.base.Entity.CheckVersionEntity;
import com.bm.container.module.base.bean.AllCityBean;
import com.bm.container.module.base.bean.HotCityBean;
import com.bm.container.module.base.bean.MainBannerBean;
import com.bm.container.module.discuss.bean.BannerBean;
import com.bm.container.module.discuss.bean.DiscussListBean;
import com.bm.container.module.login.bean.GetCityListBean;
import com.bm.container.module.login.bean.GetCountryListBean;
import com.bm.container.module.login.bean.LoginBean;
import com.bm.container.module.market.adapter.StatusBean;
import com.bm.container.module.market.adapter.TypeBean;
import com.bm.container.module.market.bean.BuyContainerBean;
import com.bm.container.module.market.bean.BuyListBean;
import com.bm.container.module.market.bean.OfferBuyListBean;
import com.bm.container.module.market.bean.OfferListBean;
import com.bm.container.module.market.bean.SaleContainerBean;
import com.bm.container.module.market.bean.SaleListBean;
import com.bm.container.module.personal.bean.ContainerOrderRedPointBean;
import com.bm.container.module.personal.bean.DeliveryNoteByBean;
import com.bm.container.module.personal.bean.DeliveryNoteRedPointBean;
import com.bm.container.module.personal.bean.DeliveryOrderBean;
import com.bm.container.module.personal.bean.FeedbackListBean;
import com.bm.container.module.personal.bean.HtmlInfoBean;
import com.bm.container.module.personal.bean.MessageList;
import com.bm.container.module.personal.bean.OrderDetailBean;
import com.bm.container.module.personal.bean.OrderDetailBeanTwo;
import com.bm.container.module.personal.bean.OrderListBean;
import com.bm.container.module.personal.bean.SeeDeliveryOrderBean;
import com.bm.container.module.personal.bean.UserInfoBean;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

/**
 * @author nfmomo
 * <p>
 * 接口数据的处理
 */

public class Collection {
    private static Api api;
    private static Api api2;


    private static Api get() {
        if (api == null) {
            OkHttpClient.Builder okhttp = new OkHttpClient().newBuilder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Api.baseUrl)
                    .client(okhttp.build())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MyConverterFactory.create())
                    .build();

            api = retrofit.create(Api.class);
        }
        return api;
    }


    private static Api get1() {
        if (api2 == null) {
            OkHttpClient.Builder okhttp = new OkHttpClient().newBuilder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://116.62.168.251:8000")
                    .client(okhttp.build())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MyConverterFactory.create())
                    .build();

            api2 = retrofit.create(Api.class);
        }
        return api2;
    }

    /**
     * P3登录
     * <p>
     * 登录
     */
    public static Disposable login(BaseActivity activity, String phone, String pwd, Consumer<LoginBean> consumer) {
        activity.showLoading();
        return get().login(phone, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * P3登录
     * <p>
     * 登录
     */
    public static Disposable login(BaseActivity activity, String phone, String pwd, Consumer<LoginBean> consumer, Consumer<Throwable> error) {
        activity.showLoading();
        return get().login(phone, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, error, ConverterCol.completeWithLoading(activity));
    }


    public static Disposable loginVerifyUser(BaseActivity activity, String regId, String userFlag, String appUserType, String id, Consumer<BaseBean> consumer) {
        activity.showLoading();
//        return get().loginVerifyUser(regId, userFlag, appUserType, id)
        return get().loginVerifyUser(userFlag, appUserType, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    public static Disposable updateRegIdByUserId(BaseActivity activity, String regId, String userId, Consumer<BaseBean> consumer) {
        activity.showLoading();
        return get().updateRegIdByUserId(regId, userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * P3_4忘记密码
     * <p>
     * 发送验证码
     */
    public static Disposable codeForget(BaseActivity activity, String phone, Consumer<BaseBean> consumer) {
        activity.showLoading();
        return get().sendCode(phone, "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * P3_1注册
     * <p>
     * 发送验证码
     */
    public static Disposable codeRegister(BaseActivity activity, String phone, Consumer<BaseBean> consumer) {
        activity.showLoading();
        return get().sendCode(phone, "0")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }


    /**
     * P3_4忘记密码
     * P8_1 修改密码
     */
    public static Disposable changePwd(BaseActivity activity, String phone, String pwd, Consumer<BaseBean> consumer) {
        activity.showLoading();
        return get().changePwd(phone, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 获取热门城市列表
     */
    public static Disposable hotCityList(BaseActivity activity, Consumer<HotCityBean> consumer) {
        return get().hotCityList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorToast());
    }

    /**
     * 获取所有城市列表
     */
    public static Disposable allCityList(BaseActivity activity, Consumer<AllCityBean> consumer) {
        return get().allCityList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorToast());
    }

    /**
     * 获取国家
     */
    public static Disposable getCountryList(BaseActivity activity, Consumer<GetCountryListBean> consumer) {
        activity.showLoading();
        return get().getCountryList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 获取国家获取下属城市
     */
    public static Disposable getCityList(BaseActivity activity, String id, Consumer<GetCityListBean> consumer) {
        activity.showLoading();
        return get().getCityList(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 获取国家获取下属城市
     */
    public static Disposable getCityList(BaseFragment fragment, String id, Consumer<GetCityListBean> consumer) {
        fragment.showLoading();
        return get().getCityList(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(fragment.bindToLifecycle())
                .subscribe(consumer, ConverterCol.error(fragment), ConverterCol.completeWithLoading(fragment));
    }

    /**
     * 自动生成用户ID
     */
    public static Disposable createId(BaseActivity activity, String id, Consumer<BaseBean> consumer) {
        activity.showLoading();
        return get().createId(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 身份认证之（买家－个人）
     */
    public static Disposable buyPerson(BaseActivity activity, String phone, String pwd, String country, String city,
                                       String user, String name, String userPhone, String weixin, String qq, HashMap<Integer, File> files, Consumer<BaseBean> consumer) {
        activity.showLoading();

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);

        builder.addFormDataPart("userFlag", "0");//用户类型
        builder.addFormDataPart("appUserType", "0");//身份类型
        builder.addFormDataPart("telephone", phone); //手机号
        builder.addFormDataPart("password", pwd);//密码
        builder.addFormDataPart("country", country);//国家
        builder.addFormDataPart("city", city); //城市
        builder.addFormDataPart("userId", user);//用户id
        builder.addFormDataPart("userName", name);//姓名
        builder.addFormDataPart("contact", userPhone);//联系方式
        builder.addFormDataPart("weixin", weixin);//微信
        builder.addFormDataPart("qq", qq);//qq

        for (Map.Entry<Integer, File> entry : files.entrySet()) {
            RequestBody pic = RequestBody.create(MediaType.parse("multipart/form-data"), entry.getValue());
            builder.addFormDataPart("file" + entry.getKey(), entry.getValue().getName(), pic);
        }

        return get().buyPerson(builder.build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));

//        return get().buyPerson("0", "0", phone, pwd, country, city, user, name, userPhone, weixin, qq)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .compose(activity.bindToLifecycle())
//                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }


    /**
     * 身份认证之（买家－公司）
     */
    public static Disposable buyCompany(BaseActivity activity, String phone, String pwd, String country, String city,
                                        String user, String companyName, String companyPhone, String address, String person, HashMap<Integer, File> files, Consumer<BaseBean> consumer) {
        activity.showLoading();

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);

        builder.addFormDataPart("userFlag", "0");//用户类型
        builder.addFormDataPart("appUserType", "1");//身份类型
        builder.addFormDataPart("telephone", phone); //手机号
        builder.addFormDataPart("password", pwd);//密码
        builder.addFormDataPart("country", country);//国家
        builder.addFormDataPart("city", city); //城市
        builder.addFormDataPart("userId", user);//用户id
        builder.addFormDataPart("companyName", companyName);//公司名
        builder.addFormDataPart("companyTelephone", companyPhone);//公司电话
        builder.addFormDataPart("companyAddress", address);//公司地址
        builder.addFormDataPart("companyPerson", person);//公司负责人

        for (Map.Entry<Integer, File> entry : files.entrySet()) {
            RequestBody pic = RequestBody.create(MediaType.parse("multipart/form-data"), entry.getValue());
            builder.addFormDataPart("file" + entry.getKey(), entry.getValue().getName(), pic);
        }

        return get().buyCompany(builder.build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));

//        return get().buyCompany("0", "1", phone, pwd, country, city, user, companyName, companyPhone, address, person)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .compose(activity.bindToLifecycle())
//                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 身份认证之（卖家－个人）
     */
    public static Disposable salePerson(BaseActivity activity, String phone, String pwd, String country, String city,
                                        String user, String name, String telephone, String bankName, String bank, String bankId, String citys,
                                        HashMap<Integer, File> files, Consumer<BaseBean> consumer) {
        activity.showLoading();

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);


        builder.addFormDataPart("userFlag", "1");//用户类型
        builder.addFormDataPart("appUserType", "0");//身份类型
        builder.addFormDataPart("telephone", phone); //手机号
        builder.addFormDataPart("password", pwd);//密码
        builder.addFormDataPart("country", country);//国家
        builder.addFormDataPart("city", city); //城市
        builder.addFormDataPart("userId", user);//用户id
        builder.addFormDataPart("userName", name);//姓名
        builder.addFormDataPart("contact", telephone);//联系方式
        builder.addFormDataPart("accountName", bankName);//账号名
        builder.addFormDataPart("accountSource", bank);//银行
        builder.addFormDataPart("bankAccount", bankId);//账号
        builder.addFormDataPart("cities", citys);//主营城市

        for (Map.Entry<Integer, File> entry : files.entrySet()) {
            RequestBody pic = RequestBody.create(MediaType.parse("multipart/form-data"), entry.getValue());
            builder.addFormDataPart("file" + entry.getKey(), entry.getValue().getName(), pic);
        }

        return get().salePerson(builder.build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));

//        return get().salePerson("1", "0", phone, pwd, country, city, user, name, telephone, bankName, bank, bankId, citys)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .compose(activity.bindToLifecycle())
//                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 身份认证之（卖家－公司）
     */
    public static Disposable saleCompany(BaseActivity activity, String phone, String pwd, String country, String city,
                                         String user, String companyName, String companyPhone, String address,
                                         String person, String bankName, String bank, String bankId, String citys,
                                         HashMap<Integer, File> files, Consumer<BaseBean> consumer) {
        activity.showLoading();

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);

        builder.addFormDataPart("userFlag", "1");//用户类型
        builder.addFormDataPart("appUserType", "1");//身份类型
        builder.addFormDataPart("telephone", phone); //手机号
        builder.addFormDataPart("password", pwd);//密码
        builder.addFormDataPart("country", country);//国家
        builder.addFormDataPart("city", city); //城市
        builder.addFormDataPart("userId", user);//用户id
        builder.addFormDataPart("companyName", companyName);//公司名
        builder.addFormDataPart("companyTelephone", companyPhone);//公司电话
        builder.addFormDataPart("companyAddress", address);//公司地址
        builder.addFormDataPart("companyPerson", person);//公司负责人
        builder.addFormDataPart("accountName", bankName);//账号名
        builder.addFormDataPart("accountSource", bank);//银行
        builder.addFormDataPart("bankAccount", bankId);//账号
        builder.addFormDataPart("cities", citys);//主营城市

        for (Map.Entry<Integer, File> entry : files.entrySet()) {
            RequestBody pic = RequestBody.create(MediaType.parse("multipart/form-data"), entry.getValue());
            builder.addFormDataPart("file" + entry.getKey(), entry.getValue().getName(), pic);
        }

        return get().saleCompany(builder.build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));

//        return get().saleCompany("1", "1", phone, pwd, country, city, user, companyName, companyPhone, address, person, bankName, bank, bankId, citys)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .compose(activity.bindToLifecycle())
//                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 获取APP介绍
     */
    public static Disposable introductiong(BaseActivity activity, Consumer<BaseBean> consumer) {
        activity.showLoading();
        return get().introduction()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 获取注册协议
     */
    public static Disposable agreement(BaseActivity activity, Consumer<BaseBean> consumer) {
        activity.showLoading();
        return get().agreement()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }


    /**
     * 获取广告（最多三个）
     */
    public static Disposable banner(BaseFragment fragment, Consumer<BannerBean> consumer) {
        fragment.showLoading();
        return get().banner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(fragment.bindToLifecycle())
                .subscribe(consumer, ConverterCol.error(fragment), ConverterCol.completeWithLoading(fragment));
    }

    /**
     * 首页广告
     */
    public static Disposable mainBanner(BaseFragment fragment, Consumer<MainBannerBean> consumer) {
        fragment.showLoading();
        return get().mainBanner("1", "10")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(fragment.bindToLifecycle())
                .subscribe(consumer, ConverterCol.error(fragment), ConverterCol.completeWithLoading(fragment));
    }

    /**
     * 讨论列表
     */
    public static Disposable discussList(BaseFragment fragment, int page, Consumer<DiscussListBean> consumer) {
        fragment.showLoading();
        String id = SpUtil.getString(SpUtil.ID);
        if (id.isEmpty()) {//接口要求用户不登录仍然可以阅读列表，但是传参得传一个6位数
            id = "000000";
        }
        return get().discussList(id, "" + page, "10")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(fragment.bindToLifecycle())
                .subscribe(consumer, ConverterCol.error(fragment), ConverterCol.completeWithLoading(fragment));
    }

    /**
     * 回复帖子
     */
    public static Disposable reply(BaseActivity activity, String id, String targetId, String targetName, String content, Consumer<BaseBean> consumer) {
        activity.showLoading();
        String phone = SpUtil.getString(SpUtil.PHONE);
        String name = SpUtil.getString(SpUtil.USERID);
        String userId = SpUtil.getString(SpUtil.ID);
        return get().reply(id, phone, name, content, targetId, targetName, userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 多图上传
     */
    public static Disposable comment(BaseActivity activity, String content, List<File> files, Consumer<BaseBean> consumer) {
        activity.showLoading();
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);

        String id = SpUtil.getString(SpUtil.ID);
        String phone = SpUtil.getString(SpUtil.PHONE);
        String name = SpUtil.getString(SpUtil.USERID);

        builder.addFormDataPart("createUser", id);
        builder.addFormDataPart("telephone", phone);
        builder.addFormDataPart("createUserName", name);
        builder.addFormDataPart("content", content);

        int i = 0;
        for (File file : files) {
            RequestBody pic = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            builder.addFormDataPart("pic" + i, file.getName(), pic);
            i++;
        }

        return get().comment(builder.build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 点赞
     */
    public static Disposable zan(BaseActivity activity, String id, Consumer<BaseBean> consumer) {
        String userId = SpUtil.getString(SpUtil.ID);
        return get().zan(userId, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorToast());
    }

    /**
     * 取消点赞
     */
    public static Disposable zanCancel(BaseActivity activity, String id, Consumer<BaseBean> consumer) {
        String userId = SpUtil.getString(SpUtil.ID);
        return get().zanCancel(userId, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorToast());
    }

    /**
     * 获取用户信息
     */
    public static Disposable userInfo(BaseActivity activity, Consumer<UserInfoBean> consumer) {
        String userId = SpUtil.getString(SpUtil.ID);
        String phone = SpUtil.getString(SpUtil.PHONE);

        return get().userInfo(userId, phone)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.error());
    }


    /**
     * 获取用户信息
     */
    public static Disposable userInfo(BaseFragment fragment, Consumer<UserInfoBean> consumer) {
        String userId = SpUtil.getString(SpUtil.ID);
        String phone = SpUtil.getString(SpUtil.PHONE);

        return get().userInfo(userId, phone)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(fragment.bindToLifecycle())
                .subscribe(consumer, ConverterCol.error());
    }


    /**
     * 系统消息
     */
    public static Disposable messageClick(BaseActivity activity, Consumer<BaseBean> consumer) {
        String userId = SpUtil.getString(SpUtil.ID);

        return get().messageClick(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.error());
    }


    /**
     * 我的帖子
     */
    public static Disposable myDiscussList(BaseActivity activity, int page, Consumer<DiscussListBean> consumer) {
        activity.showLoading();
        String id = SpUtil.getString(SpUtil.ID);
        if (id.isEmpty()) {//接口要求用户不登录仍然可以阅读列表，但是传参得传一个6位数
            id = "000000";
        }
        return get().myDiscussList(id, "" + page, "10")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.error(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 我的帖子
     */
    public static Disposable saveFeedback(BaseActivity activity, String content, Consumer<BaseBean> consumer) {
        activity.showLoading();
        String id = SpUtil.getString(SpUtil.USERID);
        String phone = SpUtil.getString(SpUtil.PHONE);

        return get().saveFeedback(id, phone, content)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorToast(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 反馈列表
     */
    public static Disposable feedbackList(BaseActivity activity, String page, Consumer<FeedbackListBean> consumer) {
        activity.showLoading();
        String user = SpUtil.getString(SpUtil.USERID);

        return get().feedbackList(user, page, "1000")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.error(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 修改个人信息
     */
    public static Disposable changePersonInfo(BaseActivity activity, String name, String address, String bankName, String bank, String bankId, String weixin, String qq, String citys, Consumer<BaseBean> consumer) {
        activity.showLoading();
        String id = SpUtil.getString(SpUtil.ID);
        String userFlag = SpUtil.getString(SpUtil.USERFLAG);
        String appUserType = SpUtil.getString(SpUtil.APPUSERTYPE);

        return get().changePersonInfo(id, userFlag, appUserType, name, address, bankName, bank, bankId, weixin, qq, citys)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 修改公司信息
     */
    public static Disposable changeCompanyInfo(BaseActivity activity, String name, String phone, String address, String person, String bankName, String bank, String bankId, String citys, Consumer<BaseBean> consumer) {
        activity.showLoading();
        String id = SpUtil.getString(SpUtil.ID);
        String userFlag = SpUtil.getString(SpUtil.USERFLAG);
        String appUserType = SpUtil.getString(SpUtil.APPUSERTYPE);

        return get().changeCompanyInfo(id, userFlag, appUserType, name, phone, address, person, bankName, bank, bankId, citys)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 多图上传
     */
    public static Disposable uploadFace(BaseActivity activity, List<File> files, Consumer<BaseBean> consumer) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);

        String id = SpUtil.getString(SpUtil.ID);
        builder.addFormDataPart("id", id);
        int i = 0;
        for (File file : files) {
            RequestBody pic = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            builder.addFormDataPart("pic" + i, file.getName(), pic);
            i++;
        }

        return get().uploadFace(builder.build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }


    /**
     * 消息列表
     */
    public static Disposable messageList(BaseActivity activity, Consumer<MessageList> consumer) {
        activity.showLoading();
        String id = SpUtil.getString(SpUtil.ID);

        return get().messageList(id, "1", "1000")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.error(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 箱型
     */
    public static Disposable containerType(BaseActivity activity, Consumer<TypeBean> consumer) {
        activity.showLoading();
        return get().containerType()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 箱型
     */
    public static Disposable containerType(BaseFragment fragment, Consumer<TypeBean> consumer) {
        fragment.showLoading();
        return get().containerType()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(fragment.bindToLifecycle())
                .subscribe(consumer, ConverterCol.error(fragment), ConverterCol.completeWithLoading(fragment));
    }

    /**
     * 状态
     */
    public static Disposable containerStatus(BaseActivity activity, Consumer<StatusBean> consumer) {
        activity.showLoading();
        return get().containerStatus()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 发送买箱信息
     */
    public static Disposable sendBuyInfo(BaseActivity activity, String countryId,
                                         String cityId, String typeId, String statusId,
                                         String num, String timeId, String content,
                                         String title, String age, Consumer<BaseBean> consumer) {
        activity.showLoading();
        String id = SpUtil.getString(SpUtil.ID);

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);

        builder.addFormDataPart("createUser", id);
        builder.addFormDataPart("country", countryId);
        builder.addFormDataPart("city", cityId);
        builder.addFormDataPart("containerType", typeId);
        builder.addFormDataPart("statusType", statusId);
        builder.addFormDataPart("count", num);
        builder.addFormDataPart("timeType", timeId);
        builder.addFormDataPart("specialRemark", content);
        builder.addFormDataPart("title", title);
        builder.addFormDataPart("age", age);

        return get().sendBuyInfo(builder.build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 发送卖箱信息
     */
    public static Disposable sendSaleInfo(BaseActivity activity,
                                          String countryId, String cityId, String typeId,
                                          String statusId, String num, String tradeId,
                                          String timeId, String isSpecial, String specialFee,
                                          String hasInvoice, String price, String title,
                                          String remark, String startPrice, String age,
                                          HashMap<Integer, File> files, Consumer<BaseBean> consumer) {
        activity.showLoading();
        String id = SpUtil.getString(SpUtil.ID);
        if (tradeId.equals("0")) {
            timeId = "9";
        }

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);

        builder.addFormDataPart("createUser", id);
        builder.addFormDataPart("country", countryId);
        builder.addFormDataPart("city", cityId);
        builder.addFormDataPart("containerType", typeId);
        builder.addFormDataPart("statusType", statusId);
        builder.addFormDataPart("count", num);
        builder.addFormDataPart("tradeType", tradeId);
        builder.addFormDataPart("timeType", timeId);
        builder.addFormDataPart("isSpecialPrice", isSpecial);
        builder.addFormDataPart("specialPrice", specialFee);
        builder.addFormDataPart("isSupportBill", hasInvoice);
        builder.addFormDataPart("price", price);
        builder.addFormDataPart("title", title);
        builder.addFormDataPart("remark", remark);
        builder.addFormDataPart("startPrice", startPrice);
        builder.addFormDataPart("age", age);

        for (Map.Entry<Integer, File> entry : files.entrySet()) {
            RequestBody pic = RequestBody.create(MediaType.parse("multipart/form-data"), entry.getValue());
            builder.addFormDataPart("file" + entry.getKey(), entry.getValue().getName(), pic);
        }

        return get().sendSaleInfo(builder.build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 首页买箱列表
     */
    public static Disposable mainBuyList(BaseFragment fragment, Consumer<BuyListBean> consumer) {
        fragment.showLoading();
        String id;
        if (SpUtil.getString(SpUtil.USERFLAG).equals("0")) {
            id = SpUtil.getString(SpUtil.ID);
        } else {
            id = "";
        }

        return get().buyList("", "1", "3", "", "", "", "", "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(fragment.bindToLifecycle())
                .subscribe(consumer, ConverterCol.error(fragment), ConverterCol.completeWithLoading(fragment));
    }

    /**
     * 首页卖箱列表
     */
    public static Disposable mainSaleList(BaseFragment fragment, Consumer<SaleListBean> consumer) {
        fragment.showLoading();

        return get().saleList("", "1", "3", "", "", "", "", "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(fragment.bindToLifecycle())
                .subscribe(consumer, ConverterCol.error(fragment), ConverterCol.completeWithLoading(fragment));
    }

    /**
     * 市场买箱列表
     */
    public static Disposable buyList(BaseFragment fragment, String cityId, String typeId, String statusId, String content, Consumer<BuyListBean> consumer, Consumer<Throwable> error) {
        fragment.showLoading();
        String id;
        if (SpUtil.getString(SpUtil.USERFLAG).equals("0")) {
            id = SpUtil.getString(SpUtil.ID);
        } else {
            id = "";
        }

        return get().buyList(id, "1", "1000", cityId, typeId, statusId, content, "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(fragment.bindToLifecycle())
                .subscribe(consumer, error);
    }

    /**
     * 市场卖箱列表
     */
    public static Disposable saleList(BaseFragment fragment, String cityId, String typeId, String statusId, String sort, String content, Consumer<SaleListBean> consumer, Consumer<Throwable> error) {
        fragment.showLoading();
        String id = SpUtil.getString(SpUtil.ID);

        return get().saleList("", "1", "1000", cityId, typeId, statusId, sort, content)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(fragment.bindToLifecycle())
                .subscribe(consumer, error);
    }

    /**
     * 市场卖箱列表   发起的卖箱信息
     */
    public static Disposable saleListTow(BaseActivity activity, Consumer<SaleListBean> consumer, Consumer<Throwable> error) {
        activity.showLoading();
        String id = SpUtil.getString(SpUtil.ID);
//        System.out.println("base------id----发起的卖箱信息--->" + id);
        return get().saleListTwo(id, "", "", "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, error);
    }

    /**
     * 市场卖箱列表   参与的卖箱信息
     */
    public static Disposable listWithBid(BaseActivity activity, Consumer<SaleListBean> consumer, Consumer<Throwable> error) {
        activity.showLoading();
        String id = SpUtil.getString(SpUtil.ID);

//        System.out.println("base------id--参与的卖箱信息----->" + id);

        return get().listWithBid(id, "1", "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, error);
    }

    /**
     * 市场买箱列表 发起的买箱信息 买家
     */
    public static Disposable myBuyList(BaseActivity activity, Consumer<BuyListBean> consumer, Consumer<Throwable> error) {
        activity.showLoading();
        String id;
        id = SpUtil.getString(SpUtil.ID);

        System.out.println("base------id--发起的买箱信息----->" + id);

        return get().buyList(id, "1", "1000", "", "", "", "", "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, error);
    }


    /**
     * 市场买箱列表  参与的买箱信息 买家
     */
    public static Disposable myBuyListWithBuy(BaseActivity activity, Consumer<BuyListBean> consumer, Consumer<Throwable> error) {
        activity.showLoading();
        String id;
        id = SpUtil.getString(SpUtil.ID);
        return get().buyListWithBuy(id, "1", "1000")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, error);
    }

    /**
     * 市场卖箱列表
     */
    public static Disposable mySaleList(BaseActivity activity, Consumer<SaleListBean> consumer, Consumer<Throwable> error) {
        activity.showLoading();
        String id;
        id = SpUtil.getString(SpUtil.ID);

        return get().saleList(id, "1", "1000", "", "", "", "", "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, error);
    }

    /**
     * 根据市场交易编号获取出价记录(涮选本人的纪录)
     */
    public static Disposable getOfferList(BaseActivity activity, String orderId, Consumer<OfferListBean> consumer) {
        activity.showLoading();
        String id = SpUtil.getString(SpUtil.ID);
        return get().getOfferList(orderId, id, "1", "1000")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.error(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 根据市场交易编号获取出价记录(全部纪录)
     */
    public static Disposable getAllOfferList(BaseActivity activity, String orderId, Consumer<OfferListBean> consumer) {
        activity.showLoading();
        return get().getOfferList(orderId, "", "1", "1000")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.error(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 发送买箱信息
     */
    public static Disposable offerPrice(BaseActivity activity, String orderId,
                                        String number, String price,
                                        String isSpecial, String specialPrice,
                                        String isInvoice, HashMap<Integer, File> files, Consumer<BaseBean> consumer) {
        activity.showLoading();
        String id = SpUtil.getString(SpUtil.ID);

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);

//        System.out.println("base--------id-------->"+id);
//        System.out.println("base--------orderId-------->"+orderId);
//        System.out.println("base----------number------>"+number);
//        System.out.println("base---------price------->"+price);
//        System.out.println("base--------isSpecial-------->"+isSpecial);
//        System.out.println("base-------specialPrice--------->"+specialPrice);
//        System.out.println("base--------isInvoice-------->"+isInvoice);

        builder.addFormDataPart("createUser", id);
        builder.addFormDataPart("containerId", orderId);
        builder.addFormDataPart("bidCount", number);
        builder.addFormDataPart("price", price);
        builder.addFormDataPart("isSpecialPrice", isSpecial);
        builder.addFormDataPart("specialPrice", specialPrice);
        builder.addFormDataPart("isSupportBill", isInvoice);

        for (Map.Entry<Integer, File> entry : files.entrySet()) {
            RequestBody pic = RequestBody.create(MediaType.parse("multipart/form-data"), entry.getValue());
            builder.addFormDataPart("file" + entry.getKey(), entry.getValue().getName(), pic);
        }

        return get().offerPrice(builder.build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 直接购买
     *
     * @param activity
     * @param invoiceType       发票类型名称  0 1
     * @param invoiceHead       发票抬头 个人  公司
     * @param invoiceContent    发票内容
     * @param invoicePhone      发票电话 （隐藏了）
     * @param price             价格
     * @param billNo            发票税号
     * @param billAccountSource 发票帐号开户行
     * @param billBankAccount   发票银行帐号
     * @param billAddress       发票地址
     * @param consumer
     * @return
     */
    public static Disposable buyOrder(BaseActivity activity, String orderId, String invoiceType, String invoiceHead, String invoiceContent, String invoicePhone, String price,
                                      String billNo, String billAccountSource, String billBankAccount, String billAddress, Consumer<BaseBean> consumer) {
        activity.showLoading();
        String id = SpUtil.getString(SpUtil.ID);

        System.out.println("base---billType---->" + invoiceType);
        System.out.println("base---invoiceHead---->" + invoiceType);
        System.out.println("base---invoiceContent---->" + invoiceContent);
        System.out.println("base---invoicePhone---->" + invoicePhone);
        System.out.println("base---invoicePhone---->" + invoicePhone);
        System.out.println("base---price---->" + price);
        System.out.println("base---containerId---->" + orderId);
        System.out.println("base---createUser---->" + id);

        System.out.println("base---billNo---->" + billNo);
        System.out.println("base---billBankAccount---->" + billBankAccount);
        System.out.println("base---billAccountSource---->" + billAccountSource);
        System.out.println("base---billAddress---->" + billAddress);


        return get().buyOrder(invoiceType, invoiceHead, invoiceContent, invoicePhone, price, orderId, id, billNo, billBankAccount, billAccountSource, billAddress)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 根据市场交易编号获取出价记录(涮选本人的纪录)
     */
    public static Disposable getOfferBuyList(BaseActivity activity, String orderId, Consumer<OfferBuyListBean> consumer) {
        activity.showLoading();
        String id = SpUtil.getString(SpUtil.ID);
        return get().getOfferBuyList(orderId, id, "1", "1000")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.error(activity), ConverterCol.completeWithLoading(activity));
    }


    /**
     * 根据市场交易编号获取出价记录(全部纪录)(买家出价)
     */
    public static Disposable getAllOfferBuyList(BaseActivity activity, String orderId, Consumer<OfferBuyListBean> consumer) {
        activity.showLoading();
        return get().getOfferBuyList(orderId, "", "1", "1000")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.error(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 我的订单
     */
    public static Disposable getOrderList(BaseActivity activity, String type, Consumer<OrderListBean> consumer, Consumer<Throwable> error) {
        activity.showLoading();
        String id = SpUtil.getString(SpUtil.ID);
        System.out.println("base------id-------->" + id);
        System.out.println("base------type-------->" + type);
        return get().orderList(id, id, type, "1", "100")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, error, ConverterCol.completeWithLoading(activity));
    }

    /**
     * 催单
     */
    public static Disposable requestRemind(BaseActivity activity, String orderNo, Consumer<BaseBean> consumer, Consumer<Throwable> error) {
        activity.showLoading();
//        String id = SpUtil.getString(SpUtil.ID);
        System.out.println("base------orderNo-------->" + orderNo);

        return get().requestRemind(orderNo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, error, ConverterCol.completeWithLoading(activity));
    }

    /**
     * 取消订单
     */
    public static Disposable cancelOrder(BaseActivity activity, String id, Consumer<BaseBean> consumer) {
        activity.showLoading();
        return get().cancelOrder(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 修改箱号
     */
    public static Disposable changContainerNo(BaseActivity activity, String id, String no, Consumer<BaseBean> consumer) {
        activity.showLoading();
        return get().changContainerNo(id, no)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }


//	/**
//	 * 支付前生成订单号
//	 */
//	public static Disposable beforePay(BaseActivity activity, String type, String id, String owner, Consumer<BeforePayBean> consumer) {
//		activity.showLoading();
//		String payer = SpUtil.getString(SpUtil.ID);
//		return get().beforePay(type, id, payer, owner)
//				.subscribeOn(Schedulers.io())
//				.observeOn(AndroidSchedulers.mainThread())
//				.compose(activity.bindToLifecycle())
//				.subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
//	}

    /**
     * 支付宝
     */
    public static Disposable alipay(BaseActivity activity, String content, Consumer<BaseBean> consumer) {
        activity.showLoading();
        String payer = SpUtil.getString(SpUtil.ID);
        return get().alipay(content)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 买箱信息详情
     * 请求浏览量
     */
    public static Disposable requesetBrowser(BaseActivity activity, String id, Consumer<BuyContainerBean> consumer) {
//        System.out.println("base------getBuyContainer---id------>"+id);
        activity.showLoading();
        return get().requesetBrowser(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 根据编号获取卖箱信息
     * 请求浏览量
     */
    public static Disposable requesetSellBox(BaseActivity activity, String id, Consumer<SaleContainerBean> consumer, Consumer<Throwable> error) {
//        System.out.println("base-----getSaleContainer----id------>"+id);
        return get().requesetSellBox(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, error, ConverterCol.completeWithLoading(activity));
    }

    /**
     * 保存出售出价表信息
     *
     * @param activity
     * @param billType          发票类型 0 个人 1 公司
     * @param name              发票类型名称 个人  公司
     * @param top               发票抬头
     * @param content           发票内容
     * @param phone             发票电话 （隐藏了）
     * @param money             价格
     * @param no                卖箱信息编号
     * @param billNo            发票税号
     * @param billAccountSource 发票帐号开户行
     * @param billBankAccount   发票银行帐号
     * @param billAddress       发票地址
     * @param consumer
     * @return
     */
    public static Disposable saveSaleOfferInfo(BaseActivity activity, String billType, String name, String top, String content, String phone, String money, String no,
                                               String billNo, String billAccountSource, String billBankAccount, String billAddress,
                                               Consumer<SaveSaleOfferInfoEntity> consumer) {
        activity.showLoading();
        System.out.println("base---billType---->" + billType);
        System.out.println("base---name---->" + name);
        System.out.println("base---top---->" + top);
        System.out.println("base---content---->" + content);
        System.out.println("base---phone---->" + phone);
        System.out.println("base---money---->" + money);
        System.out.println("base---no---->" + no);

        System.out.println("base---billNo---->" + billNo);
        System.out.println("base---billAccountSource---->" + billAccountSource);
        System.out.println("base---billBankAccount---->" + billBankAccount);
        System.out.println("base---billAddress---->" + billAddress);


        return get().saveSaleOfferInfo(billType, name, top, content, phone, money, no, SpUtil.getString(SpUtil.ID), billNo, billBankAccount, billAccountSource, billAddress)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 生成支付订单
     */
    public static Disposable alipayOrder(BaseActivity activity, String payType, String containerId, String paidUser, String createUser, String buyNo, String saleNo, String orderNo, Consumer<OrderEntity> consumer, Consumer<Throwable> error) {
        activity.showLoading();

        System.out.println("base-----------生成支付订单--------------------------------");
        System.out.println("base---billType---->" + payType);
        System.out.println("base---containerId---->" + containerId);
        System.out.println("base---paidUser---->" + paidUser);
        System.out.println("base---createUser---->" + createUser);
        System.out.println("base---buyNo---->" + buyNo);
        System.out.println("base---saleNo---->" + saleNo);
        System.out.println("base---no---->" + orderNo);

        return get().creatOrder(payType, containerId, paidUser, createUser, buyNo, saleNo, orderNo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 生成支付订单
     */
    public static Disposable weiXinPay(BaseActivity activity, String outTradeNo, String totalFee, String nonceStr, String timeStamp, Consumer<WeiXinPayEntity> consumer) {
//		activity.showLoading();
        return get().weiXinPay(outTradeNo, totalFee, nonceStr, timeStamp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 生成支付订单 支付宝
     */
    public static Disposable alipayPay(BaseActivity activity, String outTradeNo, Consumer<AlipayBaenEntity> consumer) {
//		activity.showLoading();
        return get().alipayPay(outTradeNo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 卖家提货单
     */
    public static Disposable getDeliveryOrder(BaseActivity activity, String type, String currentPage, String pageSize, Consumer<DeliveryOrderBean> consumer, Consumer<Throwable> error) {
        activity.showLoading();
        String userId = SpUtil.getString(SpUtil.ID);

        System.out.println("base---userId--->" + userId);
        System.out.println("base----type-->" + type);
        System.out.println("base----currentPage-->" + currentPage);
        System.out.println("base----pageSize-->" + pageSize);

        return get().deliveryOrder(type, userId, currentPage, pageSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, error, ConverterCol.completeWithLoading(activity));
    }

    /**
     * 根据订单号获取提货单
     */
    public static Disposable getDeliveryNoteByOrderNo(BaseActivity activity, String orderId, Consumer<DeliveryNoteByBean> consumer, Consumer<Throwable> error) {
        activity.showLoading();
        String userId = SpUtil.getString(SpUtil.ID);
//        System.out.println("base-------orderNo----------》"+orderId);
//        System.out.println("base-------userId----------》"+userId);
        return get().getDeliveryNoteByOrderNo(orderId, userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, error, ConverterCol.completeWithLoading(activity));
    }

    /**
     * 根据订单号获取订单详情
     */
    public static Disposable getMyOrderDelivery(BaseActivity activity, String orderId, Consumer<OrderDetailBean> consumer, Consumer<Throwable> error) {
        activity.showLoading();
        String userId = SpUtil.getString(SpUtil.ID);
        System.out.println("base-------orderNo----------》" + orderId);
        System.out.println("base-------userId----------》" + userId);
        return get().getMyOrderDelivery(orderId, userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, error, ConverterCol.completeWithLoading(activity));
    }


    /**
     * 根据订单号获取订单详情 无发票信息
     */
    public static Disposable getMyOrderDeliveryTwo(BaseActivity activity, String orderId, Consumer<OrderDetailBeanTwo> consumer, Consumer<Throwable> error) {
        activity.showLoading();
        String userId = SpUtil.getString(SpUtil.ID);
        System.out.println("base-------orderNo----------》" + orderId);
        System.out.println("base-------userId----------》" + userId);
        return get().getMyOrderDeliveryTwo(orderId, userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, error, ConverterCol.completeWithLoading(activity));
    }

    /**
     * 保存提货单
     */
    public static Disposable saveDeliveryNote(BaseActivity activity, String orderNo, String containerHeapNo, String containerType,
                                              String containerTypeName, String count, String containerNo,
                                              String heapName, String heapTelephone, String heapAddress, String heapContact, String deliveryDate,
                                              String isSpecialPrice, String specialPrice, String heapEMail, String motorcadeList, Consumer<BaseBean> consumer) {
        activity.showLoading();
        String createUser = SpUtil.getString(SpUtil.ID);

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);

        builder.addFormDataPart("orderNo", orderNo);//订单号
        builder.addFormDataPart("containerHeapNo", containerHeapNo);//堆场编号
        builder.addFormDataPart("containerType", containerType);//集装箱类型编号
        builder.addFormDataPart("containerTypeName", containerTypeName);//集装箱类型名称
        builder.addFormDataPart("count", count);//数量
        builder.addFormDataPart("containerNo", containerNo);//集装箱编号
        builder.addFormDataPart("heapName", heapName);//堆场名称
        builder.addFormDataPart("heapTelephone", heapTelephone);//堆场电话
        builder.addFormDataPart("heapAddress", heapAddress);//堆场地址
        builder.addFormDataPart("heapContact", heapContact);//堆场联系人
        builder.addFormDataPart("deliveryDate", deliveryDate);//预计提货时间
        builder.addFormDataPart("isSpecialPrice", isSpecialPrice);//是否有特殊费用
        builder.addFormDataPart("specialPrice", specialPrice);//特殊费用
        builder.addFormDataPart("heapEMail", heapEMail);//堆场邮件
        builder.addFormDataPart("createUser", createUser);//创建人
//        builder.addFormDataPart("id", id);//创建人

        if (!TextUtils.isEmpty(motorcadeList)) {
            builder.addFormDataPart("motorcadeList", motorcadeList);//车队信息列表   gson  买家传
        }

        return get().saveDeliveryNote(builder.build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }


    /**
     * 保存提货单 买家 提交
     */
    public static Disposable saveDeliveryNoteMai(BaseActivity activity, String id, String motorcadeList, Consumer<BaseBean> consumer) {
        activity.showLoading();
        String userId = SpUtil.getString(SpUtil.ID);

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);

        builder.addFormDataPart("id", id);
        builder.addFormDataPart("createUser", userId);//创建人

        if (!TextUtils.isEmpty(motorcadeList)) {
            builder.addFormDataPart("motorcadeList", motorcadeList);//车队信息列表   gson  买家传
        }

        return get().saveDeliveryNote(builder.build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    /**
     * 查看提货单
     */
    public static Disposable requestSeeDeliveryOrder(BaseActivity activity, String orderId, Consumer<SeeDeliveryOrderBean> consumer, Consumer<Throwable> error) {
        activity.showLoading();
        System.out.println();
        return get().seeDeliveryOrder(orderId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, error, ConverterCol.completeWithLoading(activity));
    }

    /**
     *
     */
    public static Disposable requestDeliveryNoteRedPoint(BaseActivity activity, Consumer<DeliveryNoteRedPointBean> consumer, Consumer<Throwable> error) {
        activity.showLoading();
        String userId = SpUtil.getString(SpUtil.ID);
        return get().deliveryNoteRedPoint(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, error, ConverterCol.completeWithLoading(activity));
    }

    public static Disposable requestContainerOrderRedPoint(BaseActivity activity, Consumer<ContainerOrderRedPointBean> consumer) {
        activity.showLoading();
        String userId = SpUtil.getString(SpUtil.ID);
        return get().containerOrderRedPoint(userId, userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    public static Disposable requestContainerOrderRedPointPersonal(BaseFragment fragment, Consumer<ContainerOrderRedPointBean> consumer, Consumer<Throwable> error) {
        String userId = SpUtil.getString(SpUtil.ID);
        return get().containerOrderRedPoint(userId, userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(fragment.bindToLifecycle())
                .subscribe(consumer, error, ConverterCol.completeWithLoading(fragment));
    }

    public static Disposable requestSendDeliveryNote(BaseActivity activity, String orderNo, String email, Consumer<BaseBean> consumer) {
        activity.showLoading();
        return get().sendDeliveryNote(orderNo, email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, ConverterCol.errorDialog(activity), ConverterCol.completeWithLoading(activity));
    }

    public static Disposable getHtmlInfo(BaseActivity activity, String orderNo, Consumer<HtmlInfoBean> consumer, Consumer<Throwable> error) {
        activity.showLoading();
        return get().getHtmlInfo(orderNo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, error, ConverterCol.completeWithLoading(activity));
    }

    public static Disposable checkVersionHtml(BaseActivity activity, String type, String versionCode, Consumer<CheckVersionEntity> consumer, Consumer<Throwable> error) {
        activity.showLoading();
        return get().checkVersionHtml(type, versionCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, error, ConverterCol.completeWithLoading(activity));
    }


    /**
     * 获取用户信息
     */
    public static Disposable userMessage(BaseActivity activity, Consumer<UserMeesageEntity> consumer, Consumer<Throwable> error) {
        String userId = SpUtil.getString(SpUtil.ID);

        return get().userMessage(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer, error, ConverterCol.completeWithLoading(activity));
    }

    public static Disposable demo(BaseActivity activity, Consumer<Api.pics> consumer) {
        return get1().entity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(consumer);

    }

}
