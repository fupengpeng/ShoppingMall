package com.fupengpeng.shoppingmall.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fupengpeng on 2017/6/13 0013.
 */

public class IntegralSequenceList implements Serializable{
    private List<IntegralSequenceObject> integralSequenceObjectList;

    public List<IntegralSequenceObject> getIntegralSequenceObjectList() {
        return integralSequenceObjectList;
    }

    public void setIntegralSequenceObjectList(List<IntegralSequenceObject> integralSequenceObjectList) {
        this.integralSequenceObjectList = integralSequenceObjectList;
    }
}
