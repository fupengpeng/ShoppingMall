package com.fupengpeng.shoppingmall.presenter.personcenter.factory;


import com.fupengpeng.shoppingmall.activity.personcenter.view.IGrouponView;
import com.fupengpeng.shoppingmall.presenter.personcenter.impl.GrouponPresenter;
import com.fupengpeng.shoppingmall.presenter.personcenter.interf.IGrouponPresenter;

/**
 * Created by fupengpeng on 2017/6/6 0006.
 */

public class GrouponPresenterFactory {
    public static IGrouponPresenter newInstance(IGrouponView grouponView) {
        return new GrouponPresenter(grouponView);
    }
}
