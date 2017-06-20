package com.fupengpeng.shoppingmall.presenter.personcenter.impl;


import com.fupengpeng.shoppingmall.activity.personcenter.view.IAddressEditView;
import com.fupengpeng.shoppingmall.model.personcenter.factory.AddressEditModelFactory;
import com.fupengpeng.shoppingmall.model.personcenter.interf.IAddressEditModel;
import com.fupengpeng.shoppingmall.presenter.personcenter.BaseActivityPresenter;
import com.fupengpeng.shoppingmall.presenter.personcenter.interf.IAddressEditPresenter;

/**
 * Created by fupengpeng on 2017/6/6 0006.
 */

public class AddressEditPresenter extends BaseActivityPresenter implements IAddressEditPresenter {

    private IAddressEditView addressEditView;

    private IAddressEditModel addressEditModel;


    public AddressEditPresenter(IAddressEditView addressEditView) {
        super(addressEditView);
        this.addressEditView = addressEditView;
        this.addressEditModel = AddressEditModelFactory.newInstance();


    }

    @Override
    public void setDefault() {

    }

    @Override
    public void getEditSave() {

    }

    @Override
    public void getAddNewSave() {

    }

    @Override
    public void getDelete() {

    }

    @Override
    public void getObtain() {

    }
}
