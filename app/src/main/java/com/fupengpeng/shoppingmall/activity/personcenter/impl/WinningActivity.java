package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.activity.BaseActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.view.IWinningView;


/**
 * 中奖纪录
 */
public class WinningActivity extends AppCompatActivity implements IWinningView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning);
    }
}
