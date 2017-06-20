package com.fupengpeng.shoppingmall.presenter.personcenter.factory;


import com.fupengpeng.shoppingmall.activity.personcenter.view.IInformationEditView;
import com.fupengpeng.shoppingmall.presenter.personcenter.impl.InformationEditPresenter;
import com.fupengpeng.shoppingmall.presenter.personcenter.interf.IInformationEditPresenter;

/**
 * 资料编辑界面主导器工厂
 */
public class InformationEditPresenterFactory {

    /**
     * 创建资料编辑界面主导器
     *
     * @param informationEditView 资料编辑界面
     * @return 资料编辑界面主导器实例
     */
    public static IInformationEditPresenter newInstance(IInformationEditView informationEditView) {
        return new InformationEditPresenter(informationEditView);
    }

}
