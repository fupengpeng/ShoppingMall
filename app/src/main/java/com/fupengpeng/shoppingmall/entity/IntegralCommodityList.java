package com.fupengpeng.shoppingmall.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fupengpeng on 2017/6/15 0015.
 */

public class IntegralCommodityList implements Serializable {

    List<IntegralCommodityObject> commodityObjectList ;

    public List<IntegralCommodityObject> getCommodityObjectList() {
        return commodityObjectList;
    }

    public void setCommodityObjectList(List<IntegralCommodityObject> commodityObjectList) {
        this.commodityObjectList = commodityObjectList;
    }
}
