package com.fupengpeng.shoppingmall.model.personcenter.impl;

import com.alibaba.fastjson.JSON;
import com.fupengpeng.shoppingmall.application.MyApplication;
import com.fupengpeng.shoppingmall.common.Consts;
import com.fupengpeng.shoppingmall.common.ObjectCallBack;
import com.fupengpeng.shoppingmall.entity.netresponse.GetVerificationCodeResponse;
import com.fupengpeng.shoppingmall.entity.netresponse.LoginResponse;
import com.fupengpeng.shoppingmall.entity.netresponse.RegisterResponse;
import com.fupengpeng.shoppingmall.model.personcenter.interf.IUserModel;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;
import com.yolanda.nohttp.rest.SimpleResponseListener;

/**
 * 用户信息业务
 */
public class UserModel implements IUserModel {

    public static final String TAG = "RegisterModel";
    //用来标志请求的what
    private static final int NOHTTP_WHAT_GET_VERIFICATION_CODE = 0x002;
    //用来标志请求的what
    private static final int NOHTTP_WHAT_REGISTER = 0x003;
    /**
     * 请求队列
     */
    private static RequestQueue requestQueue = NoHttp.newRequestQueue(1);

    /**
     * 登录
     *
     * @param account  账号
     * @param password 密码
     * @param callBack 回调
     */
    @Override
    public void login(String account, String password, final ObjectCallBack<String> callBack) {
        // 创建String请求
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.PERSONAL_CENTER_LOGIN, RequestMethod.POST);

        // 添加参数
        request.add("tel", account);
        request.add("password", password);

        //将request加入requestQueue
        requestQueue.add(0, request, new SimpleResponseListener<String>() {
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
                LoginResponse loginResponse = JSON.parseObject(result, LoginResponse.class);
                // 判断是否成功
                if (loginResponse.getCode() == 0) { // 成功
                    callBack.onSuccess(loginResponse.getInfo());
                } else { // 失败
                    Exception e = new Exception(loginResponse.getInfo());
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


    /**
     * 获取验证码
     * @param mobilePhoneNumber  手机号码
     * @param callBack  回调
     */
    @Override
    public void getVerificationCode(String mobilePhoneNumber, final ObjectCallBack<String> callBack) {

        // 创建String请求
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.PERSONAL_CENTER_GET_VERIFICATION_CODE, RequestMethod.POST);

        // 添加参数
        request.add("mobile", mobilePhoneNumber);

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

    /**
     * 注册
     * @param tel  手机号码
     * @param password  密码
     * @param callBack  回调
     */
    @Override
    public void register(String tel, String password, final ObjectCallBack<String> callBack) {

        // 创建String请求
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.PERSONAL_CENTER_REGISTER, RequestMethod.POST);

        // 添加参数
        request.add("tel", tel);
        request.add("password",password);

        //将request加入requestQueue
        MyApplication.getHttpQueues().add(NOHTTP_WHAT_REGISTER, request, new SimpleResponseListener<String>() {
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
                RegisterResponse registerResponse = JSON.parseObject(result, RegisterResponse.class);
                // 判断是否成功
                if (registerResponse.getCode() == 0) { // 成功
                    callBack.onSuccess(registerResponse.getInfo());
                } else { // 失败
                    Exception e = new Exception(registerResponse.getInfo());
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
