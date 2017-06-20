package com.fupengpeng.shoppingmall.entity.netresponse;

import com.fupengpeng.shoppingmall.entity.BaseResponse;

/**
 * 登录的响应
 */
public class LoginResponse extends BaseResponse {
    /**
     * 响应数据
     */
    private String data;

    public LoginResponse() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
