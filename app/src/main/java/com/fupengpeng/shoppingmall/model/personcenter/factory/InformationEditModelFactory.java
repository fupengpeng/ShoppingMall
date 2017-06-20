package com.fupengpeng.shoppingmall.model.personcenter.factory;


import com.fupengpeng.shoppingmall.model.personcenter.impl.InformationEditModel;
import com.fupengpeng.shoppingmall.model.personcenter.interf.IInformationEditModel;

/**
 * 用户信息业务工厂
 */
public class InformationEditModelFactory {

    /**
     * 创建用户信息业务
     *
     * @return 用户信息业务
     */
    public static IInformationEditModel newInstance() {
        return new InformationEditModel();
    }
}
