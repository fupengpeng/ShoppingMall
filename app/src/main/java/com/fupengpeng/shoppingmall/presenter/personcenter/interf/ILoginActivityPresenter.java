package com.fupengpeng.shoppingmall.presenter.personcenter.interf;

/**
 * 登录界面主导器接口
 */
public interface ILoginActivityPresenter {
    /**
     * 登录
     *
     * @param account  账号
     * @param password 密码
     */
    void login(String account, String password);
}
