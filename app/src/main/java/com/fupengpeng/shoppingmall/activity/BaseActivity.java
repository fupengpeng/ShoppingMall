package com.fupengpeng.shoppingmall.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.fupengpeng.shoppingmall.application.MyApplication;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Activity基类
 * 封装Activity共有处理
 */
public class BaseActivity extends AppCompatActivity {
    /**
     * 用于解除ButterKnife绑定
     */
    private Unbinder unbinder;

    /**
     * 当Activity被创建时调用
     *
     * @param savedInstanceState Bundle
     * @param layoutResId        布局文件资源ID
     */
    public void onCreate(Bundle savedInstanceState, int layoutResId) {
        super.onCreate(savedInstanceState);
        setContentView(layoutResId);
        // ButterKnife绑定
        unbinder = ButterKnife.bind(this);
        // 保存Activity
        MyApplication.getInstance().addActivity(this);
    }

    /**
     * 打开Activity
     *
     * @param cls 目标class
     */
    public void startActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

    /**
     * 当Activity被销毁时调用
     */
    @Override
    protected void onDestroy() {
        // 移除保存的Activity
        MyApplication.getInstance().removeActivity(this);
        super.onDestroy();
        // 解除ButterKnife绑定
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
