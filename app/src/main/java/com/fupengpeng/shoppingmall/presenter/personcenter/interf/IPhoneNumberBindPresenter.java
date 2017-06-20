package com.fupengpeng.shoppingmall.presenter.personcenter.interf;

/**
 * Created by fupengpeng on 2017/6/9 0009.
 */

public interface IPhoneNumberBindPresenter {

    public void getVerificationCode(String phoneNumber);

    public void getBind(String phoneNumber, String verificationCode, String password);
}
