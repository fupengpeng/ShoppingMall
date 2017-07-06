package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fupengpeng.shoppingmall.MainActivity;
import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fupengpeng on 2017/7/5 0005.
 * 结算界面
 */

public class SettleAccountsActivity extends AppCompatActivity {
    private static final String TAG = "SettleAccountsActivity";
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
     * 分享
     */
    @BindView(R.id.iv_title_activity_right)
    ImageView ivTitleActivityRight;
    /**
     * 收货人
     */
    @BindView(R.id.tv_activity_settle_accounts_username)
    TextView tvActivitySettleAccountsUsername;
    /**
     * 收货人手机号码
     */
    @BindView(R.id.tv_activity_settle_accounts_phone_number)
    TextView tvActivitySettleAccountsPhoneNumber;
    /**
     * 是否是默认地址
     */
    @BindView(R.id.tv_activity_settle_accounts_is_default)
    TextView tvActivitySettleAccountsIsDefault;
    /**
     * 收货地址
     */
    @BindView(R.id.tv_activity_settle_accounts_address)
    TextView tvActivitySettleAccountsAddress;
    /**
     * 收货地址信息管理
     */
    @BindView(R.id.ll_activity_settle_accounts_address)
    LinearLayout llActivitySettleAccountsAddress;
    /**
     * 商品图片01
     */
    @BindView(R.id.iv_activity_settle_accounts_commodity_pic_one)
    ImageView ivActivitySettleAccountsCommodityPicOne;
    /**
     * 商品图片02
     */
    @BindView(R.id.iv_activity_settle_accounts_commodity_pic_two)
    ImageView ivActivitySettleAccountsCommodityPicTwo;
    /**
     * 商品数量
     */
    @BindView(R.id.tv_activity_settle_accounts_commodity_number)
    TextView tvActivitySettleAccountsCommodityNumber;
    /**
     * 商品清单
     */
    @BindView(R.id.ll_activity_settle_accounts_commodity_inventory)
    LinearLayout llActivitySettleAccountsCommodityInventory;
    /**
     * 运费付款方式
     */
    @BindView(R.id.tv_activity_settle_accounts_payment_mode)
    TextView tvActivitySettleAccountsPaymentMode;
    /**
     * 快递方式
     */
    @BindView(R.id.tv_activity_settle_accounts_dispatching_mode)
    TextView tvActivitySettleAccountsDispatchingMode;
    /**
     * 快递信息
     */
    @BindView(R.id.ll_activity_settle_accounts_dispatching_message)
    LinearLayout llActivitySettleAccountsDispatchingMessage;
    /**
     * 发票类型
     */
    @BindView(R.id.tv_activity_settle_accounts_invoice_type)
    TextView tvActivitySettleAccountsInvoiceType;
    /**
     * 发票内容
     */
    @BindView(R.id.tv_activity_settle_accounts_invoice_content)
    TextView tvActivitySettleAccountsInvoiceContent;
    /**
     * 发票信息
     */
    @BindView(R.id.ll_activity_settle_accounts_invoice_message)
    LinearLayout llActivitySettleAccountsInvoiceMessage;
    /**
     * 优惠券信息
     */
    @BindView(R.id.ll_activity_settle_accounts_discount_coupon)
    LinearLayout llActivitySettleAccountsDiscountCoupon;
    /**
     * 商品价格
     */
    @BindView(R.id.tv_activity_settle_accounts_commodity_price)
    TextView tvActivitySettleAccountsCommodityPrice;
    /**
     * 运费
     */
    @BindView(R.id.tv_activity_settle_accounts_freight)
    TextView tvActivitySettleAccountsFreight;
    /**
     * 总计
     */
    @BindView(R.id.tv_activity_settle_accounts_aggregate)
    TextView tvActivitySettleAccountsAggregate;
    /**
     * 立即下单
     */
    @BindView(R.id.btn_activity_settle_accounts_immediately_place_an_order)
    Button btnActivitySettleAccountsImmediatelyPlaceAnOrder;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settle_accounts);
        ButterKnife.bind(this);

        tvTitleActivityTitle.setText("确认订单");
        ivTitleActivityLeft.setImageResource(R.drawable.ic_left_return_black_24dp);
        ivTitleActivityRight.setImageResource(R.drawable.ic_more_vert_black_24dp);

    }

    @OnClick({R.id.iv_title_activity_left,
            R.id.iv_title_activity_right,
            R.id.ll_activity_settle_accounts_address,
            R.id.ll_activity_settle_accounts_commodity_inventory,
            R.id.ll_activity_settle_accounts_dispatching_message,
            R.id.ll_activity_settle_accounts_invoice_message,
            R.id.ll_activity_settle_accounts_discount_coupon,
            R.id.btn_activity_settle_accounts_immediately_place_an_order})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_title_activity_left:
                intent = new Intent(SettleAccountsActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_title_activity_right:
                Log.e(TAG, "onViewClicked:"+"分享待实现" );
                break;
            case R.id.ll_activity_settle_accounts_address:
                intent = new Intent(SettleAccountsActivity.this,AddressEditActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_settle_accounts_commodity_inventory:
                intent = new Intent(SettleAccountsActivity.this,CommodityInventoryActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_settle_accounts_dispatching_message:
                intent = new Intent(SettleAccountsActivity.this,DispatchingMessageActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_settle_accounts_invoice_message:
                intent = new Intent(SettleAccountsActivity.this,InvoiceMessageActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_settle_accounts_discount_coupon:
                intent = new Intent(SettleAccountsActivity.this,DiscountCouponActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_activity_settle_accounts_immediately_place_an_order:
                ToastUtils.showLong(this,"" +
                        "提交订单");
                break;
        }
    }
}
