package com.fupengpeng.shoppingmall.presenter.personcenter.impl;


import com.fupengpeng.shoppingmall.MainActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.view.IPhoneNumberBindView;
import com.fupengpeng.shoppingmall.common.Consts;
import com.fupengpeng.shoppingmall.common.ObjectCallBack;
import com.fupengpeng.shoppingmall.model.personcenter.factory.PhoneNumberBindModelFactory;
import com.fupengpeng.shoppingmall.model.personcenter.interf.IPhoneNumberBindModel;
import com.fupengpeng.shoppingmall.presenter.BaseActivityPresenter;
import com.fupengpeng.shoppingmall.presenter.personcenter.interf.IPhoneNumberBindPresenter;
import com.fupengpeng.shoppingmall.util.ToastUtils;

/**
 * Created by fupengpeng on 2017/6/9 0009.
 */

public class PhoneNumberBindPresenter extends BaseActivityPresenter implements IPhoneNumberBindPresenter {
    private IPhoneNumberBindView phoneNumberBindView;

    private IPhoneNumberBindModel phoneNumberBindModel;


    public PhoneNumberBindPresenter(IPhoneNumberBindView phoneNumberBindView) {
        super(phoneNumberBindView);
        this.phoneNumberBindView = phoneNumberBindView;
        this.phoneNumberBindModel = PhoneNumberBindModelFactory.newInstance();

    }

    @Override
    public void getVerificationCode(String phoneNumber) {
        // 显示等待对话框
        showWaitDialog(Consts.WaitDialogMessage.DATA_LODING);

        phoneNumberBindModel.getVerificationCode(phoneNumber, new ObjectCallBack<String>() {
            @Override
            public void onSuccess(String data) {// 获取验证码成功
                // 关闭等待对话框
                closeWaitDialog();

            }

            @Override
            public void onFail(Exception e) {// 获取验证码失败
                // 关闭等待对话框
                closeWaitDialog();
            }
        });
    }

    @Override
    public void getBind(String phoneNumber, String verificationCode, String password) {
        // 显示等待对话框
        showWaitDialog(Consts.WaitDialogMessage.DATA_LODING);

        phoneNumberBindModel.getBind(phoneNumber, verificationCode, password, new ObjectCallBack<String>() {
            @Override
            public void onSuccess(String data) {
                closeWaitDialog();
                startActivity(MainActivity.class);
            }

            @Override
            public void onFail(Exception e) {
                closeWaitDialog();
                ToastUtils.showLong(activity,"绑定失败，请重新绑定");
            }
        });
    }
}
