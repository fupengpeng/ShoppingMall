package com.fupengpeng.shoppingmall.model.personcenter.factory;


import com.fupengpeng.shoppingmall.model.personcenter.impl.AddressEditModel;
import com.fupengpeng.shoppingmall.model.personcenter.interf.IAddressEditModel;

/**
 * Created by fupengpeng on 2017/6/6 0006.
 */

public class AddressEditModelFactory {
    public static IAddressEditModel newInstance() {
        return new AddressEditModel();
    }
}
