package com.fupengpeng.shoppingmall.presenter.personcenter.impl;


import com.fupengpeng.shoppingmall.activity.personcenter.view.IDataView;
import com.fupengpeng.shoppingmall.model.personcenter.factory.DataModelFactory;
import com.fupengpeng.shoppingmall.model.personcenter.interf.IDataModel;
import com.fupengpeng.shoppingmall.presenter.BaseActivityPresenter;
import com.fupengpeng.shoppingmall.presenter.personcenter.interf.IDataPresenter;

/**
 * Created by fupengpeng on 2017/6/6 0006.
 */

public class DataPresenter extends BaseActivityPresenter implements IDataPresenter {

    private IDataView dataView;

    private IDataModel dataModel;

    public DataPresenter (IDataView dataView){
        super(dataView);
        this.dataView = dataView;
        this.dataModel = DataModelFactory.newInstance();

    }

    @Override
    public void getConfirm() {

    }
}
