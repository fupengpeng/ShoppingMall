package com.fupengpeng.shoppingmall.entity;

import java.io.Serializable;

/**
 * Created by fupengpeng on 2017/6/7 0007.
 *     订单中心的订单对象
 */

public class OrderCenterOrderObject implements Serializable {
    /**
     * 订单号
     */
    private String orderCenterOrderListOrderNumber;
    /**
     * 订单状态
     */
    private String orderCenterOrderListOrderState;
    /**
     * 商品图片
     */
    private int orderCenterOrderListCommodityPic;
    /**
     * 商品名称
     */
    private String orderCenterOrderListCommodityName;
    /**
     * 商品数量
     */
    private String orderCenterOrderListCommodityQuantity;
    /**
     * 商品合计价格
     */
    private String orderCenterOrderListCommodityAggregatePrice;

    public String getOrderCenterOrderListOrderState() {
        return orderCenterOrderListOrderState;
    }

    public void setOrderCenterOrderListOrderState(String orderCenterOrderListOrderState) {
        this.orderCenterOrderListOrderState = orderCenterOrderListOrderState;
    }

    public String getOrderCenterOrderListOrderNumber() {
        return orderCenterOrderListOrderNumber;
    }

    public void setOrderCenterOrderListOrderNumber(String orderCenterOrderListOrderNumber) {
        this.orderCenterOrderListOrderNumber = orderCenterOrderListOrderNumber;
    }

    public int getOrderCenterOrderListCommodityPic() {
        return orderCenterOrderListCommodityPic;
    }

    public void setOrderCenterOrderListCommodityPic(int orderCenterOrderListCommodityPic) {
        this.orderCenterOrderListCommodityPic = orderCenterOrderListCommodityPic;
    }

    public String getOrderCenterOrderListCommodityName() {
        return orderCenterOrderListCommodityName;
    }

    public void setOrderCenterOrderListCommodityName(String orderCenterOrderListCommodityName) {
        this.orderCenterOrderListCommodityName = orderCenterOrderListCommodityName;
    }

    public String getOrderCenterOrderListCommodityQuantity() {
        return orderCenterOrderListCommodityQuantity;
    }

    public void setOrderCenterOrderListCommodityQuantity(String orderCenterOrderListCommodityQuantity) {
        this.orderCenterOrderListCommodityQuantity = orderCenterOrderListCommodityQuantity;
    }

    public String getOrderCenterOrderListCommodityAggregatePrice() {
        return orderCenterOrderListCommodityAggregatePrice;
    }

    public void setOrderCenterOrderListCommodityAggregatePrice(String orderCenterOrderListCommodityAggregatePrice) {
        this.orderCenterOrderListCommodityAggregatePrice = orderCenterOrderListCommodityAggregatePrice;
    }
}
