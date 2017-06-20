package com.fupengpeng.shoppingmall.model.personcenter.interf;

/**
 * Created by fupengpeng on 2017/6/9 0009.
 * 订单管理
 *     全部订单model接口
 */

public interface IOrderCenterAllFragmentModel {

    /**
     * 删除订单
     * @param orderNumber
     */
    public void deleteOrder(String orderNumber);

    /**
     * 订单详情
     * @param orderNumber
     */
    public void orderParticulars(String orderNumber);

    /**
     * 再次购买
     * @param orderNumber
     */
    public void againBuy(String orderNumber);

    /**
     * 评价晒单
     */
    public void evaluateShowOrder(String orderNumber);

    /**
     * 下拉刷新
     */


    /**
     * 下拉加载
     */


}
