package com.fupengpeng.shoppingmall.model.personcenter.interf;

/**
 * Created by fupengpeng on 2017/6/6 0006.
 */

public interface IAddressEditModel {

    /**
     * 设为默认
     */
    public void setDefault();
    /**
     * 编辑保存
     */
    public void getEditSave();
    /**
     * 添加新地址保存
     */
    public void getAddNewSave();
    /**
     * 删除
     */
    public void getDelete();
    /**
     * 一键获取微信地址
     */
    public void getObtain();
}
