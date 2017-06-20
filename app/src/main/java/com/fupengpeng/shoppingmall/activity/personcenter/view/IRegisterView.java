package com.fupengpeng.shoppingmall.activity.personcenter.view;

import com.fupengpeng.shoppingmall.activity.IBaseView;
/**
 * Created by fupengpeng on 2017/5/26 0026.
 *
 */

public interface IRegisterView extends IBaseView {
    /**
     * 设置注册成功
     */
    void setRegisterSuccess();
    /**
     * 验证码获取成功
     */
    void setGetVerificationCodeSuccess();
}
