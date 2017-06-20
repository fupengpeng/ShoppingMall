package com.fupengpeng.shoppingmall.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fupengpeng on 2017/6/7 0007.
 *     订单列表
 */

public class OrderCenterOrderList implements Serializable {

    private List<OrderCenterOrderObject> orderCenterOrderObjectList;

    public List<OrderCenterOrderObject> getOrderCenterOrderObjectList() {
        return orderCenterOrderObjectList;
    }

    public void setOrderCenterOrderObjectList(List<OrderCenterOrderObject> orderCenterOrderObjectList) {
        this.orderCenterOrderObjectList = orderCenterOrderObjectList;
    }
}
