package com.fupengpeng.shoppingmall.presenter.personcenter.impl;


import com.fupengpeng.shoppingmall.activity.personcenter.view.IInformationEditView;
import com.fupengpeng.shoppingmall.model.personcenter.factory.InformationEditModelFactory;
import com.fupengpeng.shoppingmall.model.personcenter.interf.IInformationEditModel;
import com.fupengpeng.shoppingmall.presenter.BaseActivityPresenter;
import com.fupengpeng.shoppingmall.presenter.personcenter.interf.IInformationEditPresenter;

/**
 * Created by fupengpeng on 2017/6/6 0006.
 */

public class InformationEditPresenter extends BaseActivityPresenter implements IInformationEditPresenter {

    /**
     * 登录界面
     */
    private IInformationEditView informationEditView;
    /**
     * 用户信息业务
     */
    private IInformationEditModel informationEditModel;

    public InformationEditPresenter(IInformationEditView informationEditView) {
        super(informationEditView);
        this.informationEditView = informationEditView;
        this.informationEditModel = InformationEditModelFactory.newInstance();
    }

    @Override
    public void getData() {

    }

    @Override
    public void getAddressEdit() {

    }

    @Override
    public void getEditPic() {

    }

    @Override
    public void getEditPassword() {

    }
}
