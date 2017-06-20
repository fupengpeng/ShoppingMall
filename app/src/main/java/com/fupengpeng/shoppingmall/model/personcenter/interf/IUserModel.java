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
}
