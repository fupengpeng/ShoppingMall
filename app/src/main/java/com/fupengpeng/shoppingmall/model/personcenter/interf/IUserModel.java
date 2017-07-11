package com.fupengpeng.shoppingmall.model.personcenter.interf;


import com.fupengpeng.shoppingmall.common.ObjectCallBack;

/**
 * 用户信息业务接口
 */
public interface IUserModel {

    /**
     * 登录
     *
     * @param account  账号
     * @param password 密码
     * @param callBack 回调
     */
    void login(String account, String password, ObjectCallBack<String> callBack);

    /**
     * 获取验证码
     * @param mobilePhoneNumber  手机号码
     * @param callBack  回调
     */
    void getVerificationCode(String mobilePhoneNumber, ObjectCallBack<String> callBack);

    /**
     * 注册
     * @param tel  手机号码
     * @param password  密码
     * @param callBack  回调
     */
    void register(String tel, String password, ObjectCallBack<String> callBack);
}
