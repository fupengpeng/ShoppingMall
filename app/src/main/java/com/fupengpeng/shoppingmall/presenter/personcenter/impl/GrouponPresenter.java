package com.fupengpeng.shoppingmall.presenter.personcenter.impl;


import com.fupengpeng.shoppingmall.activity.personcenter.view.IGrouponView;
import com.fupengpeng.shoppingmall.model.personcenter.factory.GrouponModelFactory;
import com.fupengpeng.shoppingmall.model.personcenter.interf.IGrouponModel;
import com.fupengpeng.shoppingmall.presenter.personcenter.BaseActivityPresenter;
import com.fupengpeng.shoppingmall.presenter.personcenter.interf.IGrouponPresenter;

/**
 * Created by fupengpeng on 2017/6/6 0006.
 */

public class GrouponPresenter extends BaseActivityPresenter implements IGrouponPresenter {

    private IGrouponView grouponView;

    private IGrouponModel grouponModel;


    public GrouponPresenter(IGrouponView grouponView) {
        super(grouponView);
        this.grouponView = grouponView;
        this.grouponModel = GrouponModelFactory.newInstance();
    }
}
