package com.fupengpeng.shoppingmall.model.personcenter.impl;

import com.alibaba.fastjson.JSON;
import com.fupengpeng.shoppingmall.application.MyApplication;
import com.fupengpeng.shoppingmall.common.Consts;
import com.fupengpeng.shoppingmall.common.ObjectCallBack;
import com.fupengpeng.shoppingmall.entity.netresponse.GetVerificationCodeResponse;
import com.fupengpeng.shoppingmall.model.BaseModel;
import com.fupengpeng.shoppingmall.model.personcenter.interf.IPhoneNumberBindModel;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;
import com.yolanda.nohttp.rest.SimpleResponseListener;

/**
 * Created by fupengpeng on 2017/6/9 0009.
 */

public class PhoneNumberBindModel extends BaseModel implements IPhoneNumberBindModel {
    public static final String TAG = "PhoneNumberBindModel";
    //用来标志请求的what
    private static final int NOHTTP_WHAT_GET_VERIFICATION_CODE = 0x002;
    //用来标志请求的what
    private static final int NOHTTP_WHAT_GET_BIND = 0x003;

    @Override
    public void getVerificationCode(String phoneNumber, final ObjectCallBack<String> callBack) {

        // 创建String请求
        // TODO: 2017/6/9 0009 请求地址待完善
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.PERSONAL_CENTER_GET_VERIFICATION_CODE, RequestMethod.POST);

        // 添加参数
        request.add("phoneNumber", phoneNumber);

        //将request加入requestQueue
        MyApplication.getHttpQueues().add(NOHTTP_WHAT_GET_VERIFICATION_CODE, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                // 服务器响应码。
                int responseCode = response.getHeaders().getResponseCode();
                // 这里一定要判断状态码，经测试，404错误时也走这个回调方法
                if (responseCode != 200) {
                    // 请求失败
                    Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                    callBack.onFail(e);
                    return;
                }

                // 响应结果。
                String result = response.get();
                // 解析
                // TODO: 2017/6/9 0009 数据解析待完善
                GetVerificationCodeResponse getVerificationCodeResponse = JSON.parseObject(result, GetVerificationCodeResponse.class);
                // 判断是否成功
                if (getVerificationCodeResponse.getCode() == 0) { // 成功
                    callBack.onSuccess(getVerificationCodeResponse.getInfo());
                } else { // 失败
                    Exception e = new Exception(getVerificationCodeResponse.getInfo());
                    callBack.onFail(e);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败
                Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                callBack.onFail(e);
            }
        });
    }

    @Override
    public void getBind(String phoneNumber, String verificationCode, String password, final ObjectCallBack<String> callBack) {

        // 创建String请求
        // TODO: 2017/6/9 0009 请求地址待完善
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.PERSONAL_CENTER_GET_VERIFICATION_CODE, RequestMethod.POST);

        // 添加参数
        request.add("phoneNumber", phoneNumber);
        request.add("verificationCode",verificationCode);
        request.add("password",password);

        //将request加入requestQueue
        MyApplication.getHttpQueues().add(NOHTTP_WHAT_GET_BIND, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                // 服务器响应码。
                int responseCode = response.getHeaders().getResponseCode();
                // 这里一定要判断状态码，经测试，404错误时也走这个回调方法
                if (responseCode != 200) {
                    // 请求失败
                    Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                    callBack.onFail(e);
                    return;
                }

                // 响应结果。
                String result = response.get();
                // 解析
                // TODO: 2017/6/9 0009 数据解析待完善
                GetVerificationCodeResponse getVerificationCodeResponse = JSON.parseObject(result, GetVerificationCodeResponse.class);
                // 判断是否成功
                if (getVerificationCodeResponse.getCode() == 0) { // 成功
                    callBack.onSuccess(getVerificationCodeResponse.getInfo());
                } else { // 失败
                    Exception e = new Exception(getVerificationCodeResponse.getInfo());
                    callBack.onFail(e);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败
                Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                callBack.onFail(e);
            }
        });
    }
}
