package com.fupengpeng.shoppingmall.model.personcenter.interf;


import com.fupengpeng.shoppingmall.common.ObjectCallBack;

/**
 * Created by fupengpeng on 2017/6/9 0009.
 *     绑定手机号model接口
 */

public interface IPhoneNumberBindModel {


    public void getVerificationCode(String phoneNumber, ObjectCallBack<String> callBack);

    public void getBind(String phoneNumber, String verificationCode, String password, ObjectCallBack<String> callBack);



}
