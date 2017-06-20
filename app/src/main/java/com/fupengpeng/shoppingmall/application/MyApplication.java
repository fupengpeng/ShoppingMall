package com.fupengpeng.shoppingmall.application;

import android.app.Activity;
import android.app.Application;
import android.os.Process;

import com.fupengpeng.shoppingmall.crash.CrashHandler;
import com.mob.MobApplication;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.rest.RequestQueue;

import java.util.ArrayList;
import java.util.List;


/**
 * 应用
 */
public class MyApplication extends MobApplication {
    /**
     * Application实例
     */
    private static MyApplication instance;
    /**
     * Activity集合，用于彻底退出应用
     */
    private List<Activity> activities;

    //声明全局请求队列
    public static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化实例
        instance = this;
        // 创建Activity集合
        activities = new ArrayList<>();

        // 初始化未知异常处理
        initCrashHandler();
        // 初始化NoHttp
        initNoHttp();
    }

    /**
     * 初始化未知异常处理
     */
    private void initCrashHandler() {
        // 创建未知异常处理类
        CrashHandler crashHandler = new CrashHandler(this);
        //通知android框架，出了异常，并且没加catch,android框架调crashHandler
        Thread.setDefaultUncaughtExceptionHandler(crashHandler);
    }

    /**
     * 初始化NoHttp
     */
    private void initNoHttp() {
        // 初始化NoHttp
        NoHttp.setDefaultConnectTimeout(15000);
        NoHttp.setDefaultReadTimeout(15000);
        NoHttp.initialize(this);

        // 开始NoHttp的调试模式, 这样就能看到请求过程和日志（可选）
        Logger.setTag("jdlx");
        Logger.setDebug(true);

        //实例化全局请求队列
        requestQueue = NoHttp.newRequestQueue();
    }
    /**
     * 提供一个方法获取请求队列
     * @return
     */
    public static RequestQueue getHttpQueues(){
        return requestQueue;
    }

    /**
     * 结束进程
     */
    public void finishActivity() {
        // 关闭Activity
        for (Activity activity : activities) {
            if (activity != null) {
                activity.finish();
            }
        }
        //结束进程
        Process.killProcess(Process.myPid());
    }

    /**
     * 向Activity集合中添加元素
     *
     * @param activity activity
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * 从Activity集合中移除元素
     *
     * @param activity activity
     */
    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * 获取Application实例
     *
     * @return Application实例
     */
    public static MyApplication getInstance() {
        return instance;
    }
}
