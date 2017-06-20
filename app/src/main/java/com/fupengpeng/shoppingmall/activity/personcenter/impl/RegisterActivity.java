package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.activity.BaseActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.view.IRegisterView;
import com.fupengpeng.shoppingmall.customerview.ClearEditText;
import com.fupengpeng.shoppingmall.presenter.personcenter.factory.RegisterPresenterFactory;
import com.fupengpeng.shoppingmall.presenter.personcenter.interf.IRegisterPresenter;
import com.fupengpeng.shoppingmall.util.ToastUtils;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * 注册页面
 */
public class RegisterActivity extends BaseActivity implements IRegisterView {

    public static final String TAG = "RegisterActivity";

    /**
     * 手机号
     */
    @BindView(R.id.cet_register_phone_number)
    ClearEditText cetRegisterPhoneNumber;
    /**
     * 密码
     */
    @BindView(R.id.cet_register_password)
    ClearEditText cetRegisterPassword;
    /**
     * 确认密码
     */
    @BindView(R.id.cet_register_affirm_password)
    ClearEditText cetRegisterAffirmPassword;
    /**
     * 验证码
     */
    @BindView(R.id.cet_register_verification_code)
    ClearEditText cetRegisterVerificationCode;
    /**
     * 获取验证码按钮
     */
    @BindView(R.id.btn_register_verification_code)
    Button btnRegisterVerificationCode;
    /**
     * 注册条款
     */
    @BindView(R.id.checkbox_register)
    CheckBox checkboxRegister;
    /**
     * 注册按钮
     */
    @BindView(R.id.button_register)
    Button buttonRegister;
    /**
     * 返回按钮
     */
    @BindView(R.id.iv_title_activity_left)
    ImageView ivTitleActivityLeft;
    /**
     * 注册账号标题
     */
    @BindView(R.id.tv_title_activity_title)
    TextView tvTitleActivityTitle;

    /**
     * 主导器
     */
    private IRegisterPresenter registerPresenter;

    /**
     * 密码输入格式正则表达式
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";


    /**
     * 倒计时60秒
     */
    private int recLen = 60;
    /**
     * 计时器
     */
    Timer timer = new Timer();
    /**
     * 倒计时任务
     */
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    recLen--;
                    btnRegisterVerificationCode.setText("重新获取("+recLen+")");
                    btnRegisterVerificationCode.setEnabled(false);
                    if (recLen < 0) {
                        timer.cancel();
                        btnRegisterVerificationCode.setText("获取验证码");
                        btnRegisterVerificationCode.setEnabled(true);
                    }
                }
            });
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        /**
         * 创建主导器
         */
        registerPresenter = RegisterPresenterFactory.newInstance(this);

        tvTitleActivityTitle.setText("注册账号");
        ivTitleActivityLeft.setImageResource(R.drawable.ic_left_return_black_24dp);

    }

    /**
     * 输入框的输入监听
     */
    @OnTextChanged(value = {
            R.id.cet_register_phone_number,
            R.id.cet_register_password,
            R.id.cet_register_affirm_password,
            R.id.cet_register_verification_code},
            callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void onViewTextChanged() {
        // 判断手机号、密码、确认密码、验证码是否都被输入，是否选择阅读注册条款项
        if (!TextUtils.isEmpty(cetRegisterPhoneNumber.getText().toString().trim()) &&
                !TextUtils.isEmpty(cetRegisterPassword.getText().toString().trim()) &&
                !TextUtils.isEmpty(cetRegisterAffirmPassword.getText().toString().trim()) &&
                !TextUtils.isEmpty(cetRegisterVerificationCode.getText().toString().trim()) &&
                checkboxRegister.isChecked()
                ) { // 都被输入
            // 注册按钮可操作
            buttonRegister.setEnabled(true);
            buttonRegister.setBackgroundResource(R.drawable.bg_btn_enable_selector);
        } else { // 不都被输入
            // 注册按钮不可操作
            buttonRegister.setEnabled(false);
            buttonRegister.setBackgroundResource(R.drawable.shape_rounded_rectangle_unable);
        }

    }

    /**
     * 控件点击事件
     *
     * @param view
     */
    @OnClick({R.id.btn_register_verification_code, R.id.button_register, R.id.iv_title_activity_left, R.id.checkbox_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //注册条款的选定
            case R.id.checkbox_register:
                onViewTextChanged();
                break;
            //验证码按钮的点击事件
            case R.id.btn_register_verification_code:
                String telRegex = "[1][34578]\\d{9}";
                if (TextUtils.isEmpty(cetRegisterPhoneNumber.getText().toString().trim())) {
                    ToastUtils.showLong(RegisterActivity.this, "请输入手机号码");
                } else if (cetRegisterPhoneNumber.getText().toString().trim().matches(telRegex)) {
                    String mobilePhoneNumber = cetRegisterPhoneNumber.getText().toString().trim();
                    registerPresenter.getVerificationCode(mobilePhoneNumber);
                    timer.schedule(task, 0, 1000);       // timeTask
                } else {
                    ToastUtils.showLong(RegisterActivity.this, "查无此号码，请重新输入手机号码");
                }


                break;
            //注册按钮的点击事件
            case R.id.button_register:
                // TODO: 2017/5/26 0026 点击注册时checkbox的判断   两次密码输入的判断 注册请求时验证码的判断
                if ((cetRegisterPassword.getText().toString().trim())
                        .equals(cetRegisterAffirmPassword.getText().toString().trim())) {
                    // 账号
                    String account = cetRegisterPhoneNumber.getText().toString().trim();
                    // 密码
                    String password = cetRegisterPassword.getText().toString().trim();
                    // 验证账号

                    // 验证密码

                    // 注册
                    registerPresenter.register(account, password);

                } else {
                    ToastUtils.showLong(RegisterActivity.this, "两次输入不同，请重新输入");
                    cetRegisterAffirmPassword.setText("");
                }
                break;
            //注册界面的返回登录界面按钮
            case R.id.iv_title_activity_left:
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * 清空输入项
     */
    @Override
    public void setRegisterSuccess() {
        cetRegisterPhoneNumber.setText("");
        cetRegisterPassword.setText("");
        cetRegisterAffirmPassword.setText("");
        cetRegisterVerificationCode.setText("");
    }

    /**
     * 获取验证码网络请求成功，界面的按钮计时、颜色等的展示
     */
    @Override
    public void setGetVerificationCodeSuccess() {
        // TODO: 2017/5/26 0026 验证码获取成功，获取验证码上面的时间显示

    }

}
