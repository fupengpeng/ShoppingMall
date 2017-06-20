package com.fupengpeng.shoppingmall.entity;

import java.io.Serializable;

/**
 * Created by fupengpeng on 2017/6/15 0015.
 * 积分商城 商品实体
 */

public class IntegralCommodityObject implements Serializable {

    private int commodityPic;
    private String commodityName;
    private String commodityIntegral;
    private String commodityTag;

    public int getCommodityPic() {
        return commodityPic;
    }

    public void setCommodityPic(int commodityPic) {
        this.commodityPic = commodityPic;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityIntegral() {
        return commodityIntegral;
    }

    public void setCommodityIntegral(String commodityIntegral) {
        this.commodityIntegral = commodityIntegral;
    }

    public String getCommodityTag() {
        return commodityTag;
    }

    public void setCommodityTag(String commodityTag) {
        this.commodityTag = commodityTag;
    }
}
