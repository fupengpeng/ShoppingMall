package com.fupengpeng.shoppingmall.presenter.personcenter.impl;


import com.fupengpeng.shoppingmall.MainActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.view.ILoginView;
import com.fupengpeng.shoppingmall.common.Consts;
import com.fupengpeng.shoppingmall.common.ObjectCallBack;
import com.fupengpeng.shoppingmall.model.personcenter.factory.UserModelFactory;
import com.fupengpeng.shoppingmall.model.personcenter.interf.IUserModel;
import com.fupengpeng.shoppingmall.presenter.BaseActivityPresenter;
import com.fupengpeng.shoppingmall.presenter.personcenter.interf.ILoginActivityPresenter;
import com.fupengpeng.shoppingmall.util.InfoUtils;

/**
 * 登录界面主导器
 */
public class LoginActivityPresenter extends BaseActivityPresenter implements ILoginActivityPresenter {
    /**
     * 登录界面
     */
    private ILoginView loginView;
    /**
     * 用户信息业务
     */
    private IUserModel userModel;

    public LoginActivityPresenter(ILoginView loginView) {
        super(loginView);
        this.loginView = loginView;
        this.userModel = UserModelFactory.newInstance();
    }

    /**
     * 登录
     *
     * @param account  账号
     * @param password 密码
     */
    @Override
    public void login(final String account, String password) {
        // 显示等待对话框
        showWaitDialog(Consts.WaitDialogMessage.LOGIN);
        // 登录
        userModel.login(account, password, new ObjectCallBack<String>() {
            @Override
            public void onSuccess(String userId) { // 登录成功
                // 关闭等待对话框
                closeWaitDialog();
                // 设置登录成功
                loginView.setLoginSuccess();
                // 到主界面
                startActivity(MainActivity.class);
                // 关闭登录界面
                activity.finish();
            }

            @Override
            public void onFail(Exception e) { // 登录失败
                // 关闭等待对话框
                closeWaitDialog();
                // 显示错误信息
                InfoUtils.showInfo(activity, e.getMessage());
            }
        });
    }

}
