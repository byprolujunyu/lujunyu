package com.bm.container.module.login;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.CheckBox;

import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.Tools.NetHelper;
import com.bm.container.Tools.Verify;
import com.bm.container.constants.ConstantsTag;
import com.bm.container.databinding.ActivityRegisterBinding;
import com.bm.container.module.BaseActivity;

import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/**
 * P3_1注册
 */
public class RegisterActivity extends BaseActivity {
    private ActivityRegisterBinding binding;
    private Context context;
    public static RegisterActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        context = this;
        instance = this;
        setTopbar();
        setLoading();
        setCode();
        setNext();
        jumpAgreement();
    }

    /**
     * 验证码
     */
    private void setCode() {
        binding.codeBtn.setOnClickListener(v -> {

            if (!NetHelper.IsHaveInternet(RegisterActivity.this)) {
                toast("未连接到网络.");
                return;
            }

            Block.countDownRegister(this, binding.phone, binding.codeBtn);
        });
    }

    /**
     * 跳转协议
     */
    private void jumpAgreement() {

        binding.checkbox.setOnClickListener(v -> {
            boolean checked = ((CheckBox) v).isChecked();
            binding.checkbox.setChecked(checked);
        });

        binding.agreement.setOnClickListener(view -> {

            if (!NetHelper.IsHaveInternet(RegisterActivity.this)) {
                toast("未连接到网络.");
                return;
            }

            Intent i = new Intent(context, AgreementActivity.class);
            startAc(i);
        });
    }

    /**
     * 下一步
     */
    private void setNext() {
        binding.next.setOnClickListener(v -> {

            if (!NetHelper.IsHaveInternet(RegisterActivity.this)) {
                toast("未连接到网络.");
                return;
            }

            if (Verify.register(binding.phone, binding.code, binding.pwd1, binding.pwd2, binding.checkbox)) {
                Intent i = new Intent(context, IdentificationActivity.class);
                i.putExtra("phone", binding.phone.getText().toString());
                i.putExtra("pwd", binding.pwd1.getText().toString());
                startAc(i);
            }
        });
    }

    private void setLoading() {
        setLoading(binding.refresh);
        setLoading(binding.refresh);
        binding.refresh.setEnabled(false);
        binding.refresh.setColorSchemeColors(loadingColors);
    }

    private void setTopbar() {
        binding.topbar.toolbar.setTitle("");
        binding.topbar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        binding.topbar.title.setText(R.string.register_title);
        setSupportActionBar(binding.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }

//	/**
//	 * 特别需求，阅读文件后已阅读的勾自动勾上，后期js交互选择同意则勾上
//	 */
//	@Override
//	protected void onRestart() {
//		super.onRestart();
//		binding.checkbox.setChecked(true);
//	}

    @Subscriber(mode = ThreadMode.MAIN, tag = ConstantsTag.IS_CHECKED_TRUE)
    private void setCheckedView(String isChecked) {
        if (isChecked.equals("isCheckedTrue")) {
            if (null != binding.checkbox)
                binding.checkbox.setChecked(true);
        }

    }


}
