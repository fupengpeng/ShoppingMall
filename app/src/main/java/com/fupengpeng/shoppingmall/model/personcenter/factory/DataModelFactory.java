package com.fupengpeng.shoppingmall.model.personcenter.factory;


import com.fupengpeng.shoppingmall.model.personcenter.impl.DataModel;
import com.fupengpeng.shoppingmall.model.personcenter.interf.IDataModel;

/**
 * Created by fupengpeng on 2017/6/6 0006.
 */

public class DataModelFactory {
    public static IDataModel newInstance() {
        return new DataModel();
    }
}
