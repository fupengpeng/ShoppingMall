package com.fupengpeng.shoppingmall.entity;

import java.io.Serializable;

/**
 * 列数据的bean
 */
public class ClassifyParentData implements Serializable {
    public int id;
    public String name;
    public int flag;

    public ClassifyParentData(int id, String name, int flag) {
        this.id = id;
        this.name = name;
        this.flag = flag;
    }

    public ClassifyParentData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
