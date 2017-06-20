package com.fupengpeng.shoppingmall.entity;

import java.io.Serializable;

/**
 * Created by fupengpeng on 2017/6/5 0005.
 * 收货地址
 */

public class ShippingAddress implements Serializable{
    private String username;
    private String phoneNumber;
    private String area;
    private String detailedAddress;
    private String zipCode;
    private boolean isDefault;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public ShippingAddress() {
    }

    public ShippingAddress(String username, String phoneNumber, String area, String detailedAddress, String zipCode, boolean isDefault) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.area = area;
        this.detailedAddress = detailedAddress;
        this.zipCode = zipCode;
        this.isDefault = isDefault;
    }
}
