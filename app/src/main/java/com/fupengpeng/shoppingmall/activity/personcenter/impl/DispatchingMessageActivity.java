package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fupengpeng.shoppingmall.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fupengpeng on 2017/7/6 0006.
 * 选择支付配送方式
 */

public class DispatchingMessageActivity extends AppCompatActivity {

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
     * 在线支付
     */
    @BindView(R.id.tv_activity_dispatching_message_online_payment)
    TextView tvActivityDispatchingMessageOnlinePayment;
    /**
     * 货到付款
     */
    @BindView(R.id.tv_activity_dispatching_message_pay_on_delivery)
    TextView tvActivityDispatchingMessagePayOnDelivery;
    /**
     * 公司转账
     */
    @BindView(R.id.tv_activity_dispatching_message_company_transfers)
    TextView tvActivityDispatchingMessageCompanyTransfers;
    /**
     * 付款优惠说明
     */
    @BindView(R.id.tv_activity_dispatching_message_payment_mode_privilege)
    TextView tvActivityDispatchingMessagePaymentModePrivilege;
    /**
     * 快递方式01
     */
    @BindView(R.id.tv_activity_dispatching_message_express_one)
    TextView tvActivityDispatchingMessageExpressOne;
    /**
     * 快递方式02
     */
    @BindView(R.id.tv_activity_dispatching_message_express_two)
    TextView tvActivityDispatchingMessageExpressTwo;
    /**
     * 快递方式03
     */
    @BindView(R.id.tv_activity_dispatching_message_express_three)
    TextView tvActivityDispatchingMessageExpressThree;
    /**
     * 快递方式04
     */
    @BindView(R.id.tv_activity_dispatching_message_express_four)
    TextView tvActivityDispatchingMessageExpressFour;
    /**
     * 送货时间选择
     */
    @BindView(R.id.ll_activity_dispatching_message_delivery_time)
    LinearLayout llActivityDispatchingMessageDeliveryTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dispatching_message);
        ButterKnife.bind(this);

        tvTitleActivityTitle.setText("选择支付配送方式");
        ivTitleActivityLeft.setImageResource(R.drawable.ic_left_return_black_24dp);


    }

    @OnClick({R.id.iv_title_activity_left,
            R.id.ll_activity_dispatching_message_delivery_time})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_title_activity_left:
                Intent intent = new Intent(DispatchingMessageActivity.this,SettleAccountsActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_dispatching_message_delivery_time:
                // TODO: 2017/7/6 0006 时间选择待实现
                break;
        }
    }
}
