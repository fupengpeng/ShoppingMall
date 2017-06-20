package com.fupengpeng.shoppingmall.common;

/**
 * 常量
 */
public class Consts {
    /**
     * 网络请求URL
     */
    public class NetUrl {
        /**
         * 域名（IP）
         */
        public static final String BASE_URL = "http://www.91taoke.com/";
        /**
         * 个人中心：登录
         */
        public static final String PERSONAL_CENTER_LOGIN = BASE_URL + "LoginInterface/studentLogin";
        /**
         * 个人中心：注册之获取验证码
         */
        public static final String PERSONAL_CENTER_GET_VERIFICATION_CODE = BASE_URL + "RegisterInterface/send_yanzhengma";
        /**
         * 个人中心：注册
         */
        public static final String PERSONAL_CENTER_REGISTER = BASE_URL + "RegisterInterface/register";

    }
    /**
     * 等待对话框提示的信息
     */
    public class WaitDialogMessage {
        /**
         * 登录
         */
        public static final String LOGIN = "登录中...";
        /**
         * 数据加载中
         */
        public static final String DATA_LODING = "数据加载中...";
    }

    /**
     * 网络请求失败
     */
    public static final String NET_REQUEST_EXCEPTION = "数据加载失败，请重新加载";

}
