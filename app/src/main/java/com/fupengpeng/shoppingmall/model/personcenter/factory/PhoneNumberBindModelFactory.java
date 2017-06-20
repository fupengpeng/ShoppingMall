package com.fupengpeng.shoppingmall.model.personcenter.factory;


import com.fupengpeng.shoppingmall.model.personcenter.impl.PhoneNumberBindModel;
import com.fupengpeng.shoppingmall.model.personcenter.interf.IPhoneNumberBindModel;

/**
 * Created by fupengpeng on 2017/6/9 0009.
 *     手机号修改的model工厂
 */

public class PhoneNumberBindModelFactory {
    public static IPhoneNumberBindModel newInstance(){
        return new PhoneNumberBindModel();
    }
}
