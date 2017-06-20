package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.activity.BaseActivity;
import com.fupengpeng.shoppingmall.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 订单详情
 */
public class OrderParticularsActivity extends AppCompatActivity {

    /**
     * 返回订单列表
     */
    @BindView(R.id.iv_activity_order_particulars_return)
    ImageView ivActivityOrderParticularsReturn;
    /**
     * 订单物流
     */
    @BindView(R.id.ll_activity_order_particulars_logistics_particulars)
    LinearLayout llActivityOrderParticularsLogisticsParticulars;
    /**
     * 商品图片
     */
    @BindView(R.id.iv_activity_order_particulars_commodity_pic)
    ImageView ivActivityOrderParticularsCommodityPic;
    /**
     * 商品名称
     */
    @BindView(R.id.tv_activity_order_particulars_commodity_name)
    TextView tvActivityOrderParticularsCommodityName;
    /**
     * 商品参数
     */
    @BindView(R.id.ll_activity_order_particulars_commodity_parameter)
    LinearLayout llActivityOrderParticularsCommodityParameter;
    /**
     * 商品价格
     */
    @BindView(R.id.tv_activity_order_particulars_commodity_price)
    TextView tvActivityOrderParticularsCommodityPrice;
    /**
     * 加入购物车
     */
    @BindView(R.id.btn_activity_order_particulars_add_shopping_cart)
    Button btnActivityOrderParticularsAddShoppingCart;
    /**
     * 退换无忧保险
     */
    @BindView(R.id.ll_activity_order_particulars_alteration_insurance)
    LinearLayout llActivityOrderParticularsAlterationInsurance;
    /**
     * 复制订单号
     */
    @BindView(R.id.btn_activity_order_particulars_copy)
    Button btnActivityOrderParticularsCopy;
    /**
     * 删除订单
     */
    @BindView(R.id.tv_activity_order_particulars_delete_order)
    TextView tvActivityOrderParticularsDeleteOrder;
    /**
     * 申请售后
     */
    @BindView(R.id.btn_activity_order_particulars_apply_for_after_sales)
    Button btnActivityOrderParticularsApplyForAfterSales;
    /**
     * 再次购买
     */
    @BindView(R.id.btn_activity_order_particulars_buy_again)
    Button btnActivityOrderParticularsBuyAgain;
    /**
     * 接收订单列表传递过来的分类参数
     */
    int setFragment;
    /**
     * 订单号
     */
    @BindView(R.id.tv_activity_order_particulars_order_number)
    TextView tvActivityOrderParticularsOrderNumber;
    /**
     * 接收订单号的字符串
     */
    private String orderNumber;
    //剪切板管理工具类
    private ClipboardManager mClipboardManager;
    //剪切板Data对象
    private ClipData mClipData;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_particulars);
        mClipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        orderParticulars();
        ButterKnife.bind(this);
    }

    /**
     * 在其他页面点击问题详情之后，进入到问题详情页面，在此通过intent获取传递过来的问题详情数据对象
     */
    private void orderParticulars() {
        Intent intent = this.getIntent();
        setFragment = intent.getIntExtra("setFragment", 0);
    }

    @OnClick({R.id.iv_activity_order_particulars_return,
            R.id.ll_activity_order_particulars_logistics_particulars,
            R.id.iv_activity_order_particulars_commodity_pic,
            R.id.tv_activity_order_particulars_commodity_name,
            R.id.ll_activity_order_particulars_commodity_parameter,
            R.id.tv_activity_order_particulars_commodity_price,
            R.id.btn_activity_order_particulars_add_shopping_cart,
            R.id.ll_activity_order_particulars_alteration_insurance,
            R.id.btn_activity_order_particulars_copy,
            R.id.tv_activity_order_particulars_delete_order,
            R.id.btn_activity_order_particulars_apply_for_after_sales,
            R.id.btn_activity_order_particulars_buy_again})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            /**
             * 返回订单列表
             */
            case R.id.iv_activity_order_particulars_return:
                intent = new Intent(OrderParticularsActivity.this, OrderCenterActivity.class);
                Bundle bundle = new Bundle();
                //将网络请求获取到的分类对象传递给ScreenActivity用于展示数据
                bundle.putInt("setFragment", setFragment);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            /**
             * 订单物流
             */
            case R.id.ll_activity_order_particulars_logistics_particulars:
                intent = new Intent(OrderParticularsActivity.this,OrderTrackingActivity.class);
                startActivity(intent);
                break;
            /**
             * 商品图片
             */
            case R.id.iv_activity_order_particulars_commodity_pic:
                intent = new Intent(OrderParticularsActivity.this,CommodityParticularsActivity.class);
                startActivity(intent);
                break;
            /**
             * 商品名称
             */
            case R.id.tv_activity_order_particulars_commodity_name:
                intent = new Intent(OrderParticularsActivity.this,CommodityParticularsActivity.class);
                startActivity(intent);
                break;
            /**
             * 商品参数
             */
            case R.id.ll_activity_order_particulars_commodity_parameter:
                intent = new Intent(OrderParticularsActivity.this,CommodityParticularsActivity.class);
                startActivity(intent);
                break;
            /**
             * 商品价格
             */
            case R.id.tv_activity_order_particulars_commodity_price:
                intent = new Intent(OrderParticularsActivity.this,CommodityParticularsActivity.class);
                startActivity(intent);
                break;
            /**
             * 加入购物车
             */
            case R.id.btn_activity_order_particulars_add_shopping_cart:
                ToastUtils.showLong(this, "加入购物车待实现");
                break;
            /**
             * 退换无忧保险
             */
            case R.id.ll_activity_order_particulars_alteration_insurance:
                intent = new Intent(OrderParticularsActivity.this,AlterationInsuranceActivity.class);
                startActivity(intent);
                break;
            /**
             * 复制订单号
             */
            case R.id.btn_activity_order_particulars_copy:
                ToastUtils.showLong(this, "复制订单号待实现");
                orderNumber = tvActivityOrderParticularsOrderNumber.getText().toString();
                if (!TextUtils.isEmpty(orderNumber)) {
                    //创建一个新的文本clip对象
                    mClipData = ClipData.newPlainText("订单号复制", orderNumber);
                    //把clip对象放在剪贴板中
                    mClipboardManager.setPrimaryClip(mClipData);
                    //GET贴板是否有内容
                    mClipData = mClipboardManager.getPrimaryClip();
                    //获取到内容
                    ClipData.Item item = mClipData.getItemAt(0);
                    String text = item.getText().toString();
                }else {
                    Toast.makeText(OrderParticularsActivity.this, "订单号为空，复制失败。",
                            Toast.LENGTH_SHORT).show();
                }


                break;
            /**
             * 删除订单
             */
            case R.id.tv_activity_order_particulars_delete_order:
                ToastUtils.showLong(this, "删除订单待实现");
                break;
            /**
             * 申请售后
             */
            case R.id.btn_activity_order_particulars_apply_for_after_sales:
                ToastUtils.showLong(this, "申请售后待实现");
                break;
            /**
             * 再次购买
             */
            case R.id.btn_activity_order_particulars_buy_again:
                intent = new Intent(OrderParticularsActivity.this,ShoppingCartActivity.class);
                startActivity(intent);
                break;
        }
    }
}
