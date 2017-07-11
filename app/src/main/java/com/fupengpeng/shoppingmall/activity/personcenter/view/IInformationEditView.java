package com.fupengpeng.shoppingmall.activity.personcenter.view;


import com.fupengpeng.shoppingmall.activity.IBaseView;

/**
 * Created by fupengpeng on 2017/6/3 0003.
 * 个人信息接口
 */

public interface IInformationEditView extends IBaseView {

    /**
     * 设置资料完善界面变化
     */
    void setData();

    /**
     * 设置收货地址编辑界面变化
     */
    void setAddress();

    /**
     * 设置修改头像界面变化
     */
    void  setPic();

    /**
     * 设置修改密码界面变化
     */
    void setPassword();

}
