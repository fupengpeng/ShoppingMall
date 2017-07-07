package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.fupengpeng.shoppingmall.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class OrderTrackingActivity extends AppCompatActivity {

    @BindView(R.id.iv_title_activity_left)
    ImageView ivTitleActivityLeft;
    @BindView(R.id.tv_title_activity_title)
    TextView tvTitleActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_tracking);
        ButterKnife.bind(this);

        tvTitleActivityTitle.setText("订单跟踪");
        ivTitleActivityLeft.setImageResource(R.drawable.ic_left_return_black_24dp);
    }
}
