package com.fupengpeng.shoppingmall.model.personcenter.impl;

import com.alibaba.fastjson.JSON;
import com.fupengpeng.shoppingmall.common.Consts;
import com.fupengpeng.shoppingmall.common.ObjectCallBack;
import com.fupengpeng.shoppingmall.entity.netresponse.LoginResponse;
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
}
