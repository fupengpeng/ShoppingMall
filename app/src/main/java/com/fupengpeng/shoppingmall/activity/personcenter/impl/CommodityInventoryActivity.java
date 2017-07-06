package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.fupengpeng.shoppingmall.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fupengpeng on 2017/7/6 0006.
 * 商品清单界面
 */

public class CommodityInventoryActivity extends AppCompatActivity {

    private static final String TAG = "CommodityInventoryActivity";
    /**
     * 返回
     */
    @BindView(R.id.iv_title_activity_left)
    ImageView ivTitleActivityLeft;
    /**
     * 标题
     */
    @BindView(R.id.tv_title_activity_title)
    TextView tvTitleActivityTitle;
    /**
     * 商品数量
     */
    @BindView(R.id.tv_title_activity_right)
    TextView tvTitleActivityRight;
    /**
     * listview
     */
    @BindView(R.id.lv_activity_commodity_inventory)
    ListView lvActivityCommodityInventory;

    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_commodity_inventory);
        ButterKnife.bind(this);

        tvTitleActivityTitle.setText("商品清单");
        ivTitleActivityLeft.setImageResource(R.drawable.ic_left_return_black_24dp);
        tvTitleActivityRight.setText("共4件");

    }

    @OnClick({R.id.iv_title_activity_left,
            R.id.iv_title_activity_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_title_activity_left:
                intent = new Intent(CommodityInventoryActivity.this, SettleAccountsActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_title_activity_right:
                Log.e(TAG, "onViewClicked: " + "分享待实现");
                break;
        }
    }
}
