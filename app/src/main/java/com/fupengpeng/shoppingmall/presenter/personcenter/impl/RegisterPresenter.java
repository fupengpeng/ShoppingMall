package com.fupengpeng.shoppingmall.presenter.personcenter.impl;


import android.util.Log;

import com.fupengpeng.shoppingmall.activity.personcenter.impl.LoginActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.view.IRegisterView;
import com.fupengpeng.shoppingmall.common.Consts;
import com.fupengpeng.shoppingmall.common.ObjectCallBack;
import com.fupengpeng.shoppingmall.model.personcenter.factory.RegisterModelFactory;
import com.fupengpeng.shoppingmall.model.personcenter.interf.IRegisterModel;
import com.fupengpeng.shoppingmall.presenter.BaseActivityPresenter;
import com.fupengpeng.shoppingmall.presenter.personcenter.interf.IRegisterPresenter;
import com.fupengpeng.shoppingmall.util.InfoUtils;

/**
 * Created by fupengpeng on 2017/5/26 0026.
 * 注册界面主导器
 */

public class RegisterPresenter extends BaseActivityPresenter implements IRegisterPresenter {
    public static final String TAG = "RegisterPresenter";

    /**
     * 注册界面
     */
    private IRegisterView registerView;
    /**
     * 注册信息业务
     */
    private IRegisterModel registerModel;

    /**
     * 有参主导器构造
     * @param registerView  注册界面接口
     */
    public RegisterPresenter(IRegisterView registerView) {
        super(registerView);
        Log.e(TAG, "RegisterPresenter: "+"创建RegisterPresenter对象" );
        this.registerView = registerView;
        this.registerModel = RegisterModelFactory.newInstance();
    }


    /**
     * 获取验证码
     * @param mobilePhoneNumber  手机号码
     */
    @Override
    public void getVerificationCode(String mobilePhoneNumber) {
        // 显示等待对话框
        showWaitDialog(Consts.WaitDialogMessage.LOGIN);
        // 获取验证码
        registerModel.getVerificationCode(mobilePhoneNumber, new ObjectCallBack<String>() {

            @Override
            public void onSuccess(String userId) { // 获取验证码成功
                // 关闭等待对话框
                closeWaitDialog();
                // 设置获取验证码成功
                registerView.setGetVerificationCodeSuccess();
            }

            @Override
            public void onFail(Exception e) { // 获取验证码失败
                // 关闭等待对话框
                closeWaitDialog();
                // 显示错误信息
                InfoUtils.showInfo(activity, e.getMessage());
            }
        });
    }

    /**
     * 注册
     * @param tel  手机号码
     * @param password  密码
     */
    @Override
    public void register(String tel, String password) {
        // 显示等待对话框
        showWaitDialog(Consts.WaitDialogMessage.LOGIN);
        // 注册
        registerModel.register(tel, password, new ObjectCallBack<String>() {
            @Override
            public void onSuccess(String userId) { // 注册成功
                // 关闭等待对话框
                closeWaitDialog();
                // 设置注册成功
                registerView.setRegisterSuccess();
                Log.e(TAG, "onSuccess: "+"--------------------" );
                // 返回登录界面
                startActivity(LoginActivity.class);
                // 关闭注册界面
                activity.finish();
            }

            @Override
            public void onFail(Exception e) { // 注册失败
                // 关闭等待对话框
                closeWaitDialog();
                // 显示错误信息
                InfoUtils.showInfo(activity, e.getMessage());
            }
        });
    }
}
