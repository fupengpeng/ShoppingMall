package com.fupengpeng.shoppingmall.model.personcenter.factory;


import com.fupengpeng.shoppingmall.model.personcenter.impl.GrouponModel;
import com.fupengpeng.shoppingmall.model.personcenter.interf.IGrouponModel;

/**
 * Created by fupengpeng on 2017/6/6 0006.
 */

public class GrouponModelFactory {

    public static IGrouponModel newInstance() {
        return new GrouponModel();
    }
}
