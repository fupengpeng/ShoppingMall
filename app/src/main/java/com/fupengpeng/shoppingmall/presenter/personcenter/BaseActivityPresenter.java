package com.fupengpeng.shoppingmall.presenter.personcenter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;

import com.fupengpeng.shoppingmall.activity.IBaseView;
import com.fupengpeng.shoppingmall.util.DialogUtils;


/**
 * 主导器基类
 */
public class BaseActivityPresenter {
    /**
     * 对话框工具类
     */
    public DialogUtils dialogUtils = null;
    /**
     * 网络请求时的等待对话框
     */
    private Dialog dialog = null;
    /**
     * Activity
     */
    protected Activity activity;

    public BaseActivityPresenter(IBaseView baseView) {
        activity = (Activity) baseView;
        // 创建对话框工具类
        dialogUtils = new DialogUtils(activity);
    }

    /**
     * 显示等待对话框
     *
     * @param message 提示信息
     */
    public void showWaitDialog(String message) {
        if (dialogUtils != null && (dialog == null || !dialog.isShowing())) {
            dialog = dialogUtils.showLoading(message);
        }
    }

    /**
     * 关闭等待对话框
     */
    public void closeWaitDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    /**
     * 打开Activity
     *
     * @param cls 目标class
     */
    public void startActivity(Class<?> cls) {
        activity.startActivity(new Intent(activity, cls));
    }

}
