package com.fupengpeng.shoppingmall.activity.personcenter.view;


import android.content.Context;

import com.fupengpeng.shoppingmall.activity.IBaseView;

/**
 * Created by fupengpeng on 2017/5/26 0026.
 * 信息修改接口
 */

public interface IDataView extends IBaseView {

    /**
     * 设置地址选择dialog展示
     * @param context
     */
    void setSelectAddress(Context context);

    /**
     * 设置确认修改的界面变化
     */
    void setConfirm();

    /**
     * 设置生日选择界面变化
     */
    void setBirthday();

}
