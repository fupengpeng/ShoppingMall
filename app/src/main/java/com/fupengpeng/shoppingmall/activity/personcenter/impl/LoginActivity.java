package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.activity.BaseActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.view.ILoginView;
import com.fupengpeng.shoppingmall.customerview.ClearEditText;
import com.fupengpeng.shoppingmall.presenter.personcenter.factory.LoginActivityPresenterFactory;
import com.fupengpeng.shoppingmall.presenter.personcenter.interf.ILoginActivityPresenter;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * 登录界面
 */
public class LoginActivity extends BaseActivity implements ILoginView {
    /**
     * 标题
     */
    @BindView(R.id.tv_title_activity_title)
    TextView tvTitleActivityTitle;
    /**
     * 账号
     */
    @BindView(R.id.cet_login_account)
    ClearEditText cetLoginAccount;
    /**
     * 密码
     */
    @BindView(R.id.cet_login_password)
    ClearEditText cetLoginPassword;
    /**
     * 登录按钮
     */
    @BindView(R.id.btn_login)
    Button btnLogin;

    /**
     * 主导器
     */
    private ILoginActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_login);
        // 创建主导器
        presenter = LoginActivityPresenterFactory.newInstance(this);
        // 标题
        tvTitleActivityTitle.setText("登录");
    }


    /**
     * 输入框文本改变后
     *
     * @param editable editable
     */
    @OnTextChanged(value = {R.id.cet_login_account,
            R.id.cet_login_password}, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void afterTextChanged(Editable editable) {
        // 判断账号和密码是否都被输入
        if (!TextUtils.isEmpty(cetLoginAccount.getText().toString().trim()) &&
                !TextUtils.isEmpty(cetLoginPassword.getText().toString().trim())) { // 都被输入
            // 登录按钮可操作
            btnLogin.setEnabled(true);
            btnLogin.setBackgroundResource(R.drawable.bg_btn_enable_selector);
        } else { // 不都被输入
            // 登录按钮不可操作
            btnLogin.setEnabled(false);
            btnLogin.setBackgroundResource(R.drawable.shape_rounded_rectangle_unable);
        }
    }

    /**
     * 登录
     */
    @OnClick({R.id.btn_login,R.id.tv_login_register})
    public void login(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                // 账号
                String account = cetLoginAccount.getText().toString().trim();
                // 密码
                String password = cetLoginPassword.getText().toString().trim();
                // 验证账号

                // 验证密码

                // 登录
                presenter.login(account, password);
                break;
            case R.id.tv_login_register:
                setStartRegister();
                break;
        }

    }

    /**
     * 设置登录成功
     */
    @Override
    public void setLoginSuccess() {
        cetLoginAccount.setText("");
        cetLoginPassword.setText("");
    }

    /**
     * 设置快速注册按钮的点击跳转
     */
    @Override
    public void setStartRegister() {
        startActivity(RegisterActivity.class);
    }


}
