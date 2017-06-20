package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.activity.BaseActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.view.IShoppingCartView;


/**
 * 我的购物车界面
 */
public class ShoppingCartActivity extends AppCompatActivity implements IShoppingCartView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
    }
}
