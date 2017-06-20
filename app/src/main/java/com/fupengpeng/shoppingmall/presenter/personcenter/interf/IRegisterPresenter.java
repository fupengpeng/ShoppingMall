package com.fupengpeng.shoppingmall.presenter.personcenter.interf;

/**
 * Created by fupengpeng on 2017/5/26 0026.
 * 注册主导器接口
 */

public interface IRegisterPresenter {
    /**
     * 获取验证码
     * @param mobilePhoneNumber  手机号码
     */
    void getVerificationCode(String mobilePhoneNumber);

    /**
     * 注册
     * @param tel  手机号码
     * @param password  密码
     */
    void register(String tel, String password);
}
