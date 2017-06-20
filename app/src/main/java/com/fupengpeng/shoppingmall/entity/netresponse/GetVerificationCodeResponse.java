package com.fupengpeng.shoppingmall.entity.netresponse;

import com.fupengpeng.shoppingmall.entity.BaseResponse;

/**
 * Created by fupengpeng on 2017/5/26 0026.
 * 获取验证码的响应
 */

public class GetVerificationCodeResponse extends BaseResponse {
    /**
     * 响应数据
     */
    private String data;

    public GetVerificationCodeResponse() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
