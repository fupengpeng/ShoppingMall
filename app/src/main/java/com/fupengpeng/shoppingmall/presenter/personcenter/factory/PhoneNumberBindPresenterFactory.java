package com.fupengpeng.shoppingmall.presenter.personcenter.factory;


import com.fupengpeng.shoppingmall.activity.personcenter.view.IPhoneNumberBindView;
import com.fupengpeng.shoppingmall.presenter.personcenter.impl.PhoneNumberBindPresenter;
import com.fupengpeng.shoppingmall.presenter.personcenter.interf.IPhoneNumberBindPresenter;

/**
 * Created by fupengpeng on 2017/6/9 0009.
 */

public class PhoneNumberBindPresenterFactory {
    public static IPhoneNumberBindPresenter newInstance(IPhoneNumberBindView phoneNumberBindView){
        return new PhoneNumberBindPresenter(phoneNumberBindView);
    }
}
