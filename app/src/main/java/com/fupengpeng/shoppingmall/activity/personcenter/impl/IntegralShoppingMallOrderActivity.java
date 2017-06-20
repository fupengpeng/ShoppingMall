package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.fupengpeng.shoppingmall.MainActivity;
import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.activity.BaseActivity;
import com.fupengpeng.shoppingmall.fragment.IntegralShoppingMallOrderAccomplishFragment;
import com.fupengpeng.shoppingmall.fragment.IntegralShoppingMallOrderAllFragment;
import com.fupengpeng.shoppingmall.fragment.IntegralShoppingMallOrderWaitReceivingFragment;
import com.fupengpeng.shoppingmall.fragment.IntegralShoppingMallOrderWaitShipmentsFragment;
import com.fupengpeng.shoppingmall.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 商城订单界面
 */
public class IntegralShoppingMallOrderActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 返回
     */
    @BindView(R.id.iv_activity_integral_shopping_mall_return)
    ImageView ivActivityIntegralShoppingMallReturn;
    @BindView(R.id.tv_activity_integral_shopping_mall_title)
    TextView tvActivityIntegralShoppingMallTitle;
    /**
     * 分享
     */
    @BindView(R.id.iv_activity_integral_shopping_mall_share)
    ImageView ivActivityIntegralShoppingMallShare;
    /**
     * 全部订单Fragment控制按钮
     */
    @BindView(R.id.tv_activity_integral_shopping_mall_all)
    TextView tvActivityIntegralShoppingMallAll;
    @BindView(R.id.v_activity_integral_shopping_mall_all)
    View vActivityIntegralShoppingMallAll;
    @BindView(R.id.ll_activity_integral_shopping_mall_all)
    LinearLayout llActivityIntegralShoppingMallAll;
    /**
     * 待发货订单Fragment控制按钮
     */
    @BindView(R.id.tv_activity_integral_shopping_mall_wait_shipments)
    TextView tvActivityIntegralShoppingMallWaitShipments;
    @BindView(R.id.v_activity_integral_shopping_mall_wait_shipments)
    View vActivityIntegralShoppingMallWaitShipments;
    @BindView(R.id.ll_activity_integral_shopping_mall_wait_shipments)
    LinearLayout llActivityIntegralShoppingMallWaitShipments;
    /**
     * 待收货订单Fragment控制按钮
     */
    @BindView(R.id.tv_activity_integral_shopping_mall_wait_receiving)
    TextView tvActivityIntegralShoppingMallWaitReceiving;
    @BindView(R.id.v_activity_integral_shopping_mall_wait_receiving)
    View vActivityIntegralShoppingMallWaitReceiving;
    @BindView(R.id.ll_activity_integral_shopping_mall_wait_receiving)
    LinearLayout llActivityIntegralShoppingMallWaitReceiving;
    /**
     * 已完成订单的Fragment控制按钮
     */
    @BindView(R.id.tv_activity_integral_shopping_mall_accomplish)
    TextView tvActivityIntegralShoppingMallAccomplish;
    @BindView(R.id.v_activity_integral_shopping_mall_accomplish)
    View vActivityIntegralShoppingMallAccomplish;
    @BindView(R.id.ll_activity_integral_shopping_mall_accomplish)
    LinearLayout llActivityIntegralShoppingMallAccomplish;
    /**
     * 订单列表Fragment容器
     */
    @BindView(R.id.ll_activity_integral_shopping_mall_parent)
    LinearLayout llActivityIntegralShoppingMallParent;


    /**
     * 全部订单Fragment
     */
    private IntegralShoppingMallOrderAllFragment integralShoppingMallOrderAllFragment;
    /**
     * 待发货订单Fragment
     */
    private IntegralShoppingMallOrderWaitShipmentsFragment integralShoppingMallOrderWaitShipmentsFragment;
    /**
     * 待收货订单Fragment
     */
    private IntegralShoppingMallOrderWaitReceivingFragment integralShoppingMallOrderWaitReceivingFragment;
    /**
     * 已完成Fragment
     */
    private IntegralShoppingMallOrderAccomplishFragment integralShoppingMallOrderAccomplishFragment;


    private Intent intent;

    /**
     * 设置展示Fragment的参数
     */
    private int setFragment ;

    /**
     * 全部订单
     */
    private static final int ALL = 1;
    /**
     * 待发货订单
     */
    private static final int WAIT_SHIPMENTS = 2;
    /**
     * 待收货订单
     */
    private static final int WAIT_RECEIVING = 3;
    /**
     * 已完成订单
     */
    private static final int ACCOMPLISH = 4;
    /**
     * 用于对Fragment的管理
     */
    FragmentManager fragmentManager;
    FragmentTransaction transaction;

    public static final String TAG = "OrderCenterActivity";
    private Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integral_shopping_mall_order);
        ButterKnife.bind(this);
        //添加一个FragmentTransaction的实例
        fragmentManager = getFragmentManager();
        // 开启一个Fragment事务
        transaction = fragmentManager.beginTransaction();

        questionList();

    }


    /**
     * Fragment列表子条目内控件的点击事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /**
             * 点击跳转至订单详情界面
             */
            case R.id.tv_item_fragment_order_center_order_list_order_number_explain:
                intent = new Intent(this, OrderParticularsActivity.class);
                bundle = new Bundle();
                bundle.putInt("fragmentRequestSign", 200);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            /**
             * 点击跳转至订单详情界面
             */
            case R.id.tv_item_fragment_order_center_order_list_order_number:
                intent = new Intent(this, OrderParticularsActivity.class);
                bundle = new Bundle();
                bundle.putInt("fragmentRequestSign", 200);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            /**
             * 点击跳转至订单详情界面
             */
            case R.id.tv_item_fragment_order_center_order_list_order_state:
                intent = new Intent(this, OrderParticularsActivity.class);
                bundle = new Bundle();
                bundle.putInt("fragmentRequestSign", 200);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            /**
             * 点击删除此订单
             */
            case R.id.iv_item_fragment_order_center_order_list_delete_order:
                // TODO: 2017/6/9 0009  删除订单待实现
                ToastUtils.showLong(this, "删除订单待实现");
                break;
            /**
             * 点击跳转至订单详情界面
             */
            case R.id.iv_item_fragment_order_center_order_list_commodity_pic:
                intent = new Intent(this, OrderParticularsActivity.class);
                bundle = new Bundle();
                bundle.putInt("fragmentRequestSign", 200);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            /**
             * 点击跳转至订单详情界面
             */
            case R.id.tv_item_fragment_order_center_order_list_commodity_name:
                intent = new Intent(this, OrderParticularsActivity.class);
                bundle = new Bundle();
                bundle.putInt("fragmentRequestSign", 200);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            /**
             * 点击跳转至订单详情界面
             */
            case R.id.tv_item_fragment_order_center_order_list_commodity_quantity:
                intent = new Intent(this, OrderParticularsActivity.class);
                bundle = new Bundle();
                bundle.putInt("fragmentRequestSign", 200);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            /**
             * 点击跳转至订单详情界面
             */
            case R.id.tv_item_fragment_order_center_order_list_commodity_pay:
                intent = new Intent(this, OrderParticularsActivity.class);
                bundle = new Bundle();
                bundle.putInt("fragmentRequestSign", 200);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            /**
             * 点击跳转至订单详情界面
             */
            case R.id.tv_item_fragment_order_center_order_list_commodity_aggregate_price:
                intent = new Intent(this, OrderParticularsActivity.class);
                bundle = new Bundle();
                bundle.putInt("fragmentRequestSign", 200);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            /**
             * 点击跳转至订单详情界面
             */
            case R.id.v_item_fragment_order_center_order_list_blank:
                intent = new Intent(this, OrderParticularsActivity.class);
                bundle = new Bundle();
                bundle.putInt("fragmentRequestSign", 200);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            /**
             * 点击按钮one实现对应操作
             */
            case R.id.btn_item_fragment_order_center_order_list_one:
                // TODO: 2017/6/9 0009 订单相关操作待实现
                ToastUtils.showLong(this, "再次购买待实现");
                break;
            /**
             * 点击按钮two实现对应操作
             */
            case R.id.btn_item_fragment_order_center_order_list_two:
                ToastUtils.showLong(this, "取消订单待实现");
                break;
            /**
             * 点击按钮three实现对应操作
             */
            case R.id.btn_item_fragment_order_center_order_list_three:
                ToastUtils.showLong(this, "待付款待实现");
                break;

        }

    }


    /**
     * 根据传入的index参数来设置选中的Fragment。
     *
     * @param index 每个图片对应的下标。0表示已解决，1表示未解决，2表示我要提问，3表示我的问题。
     */
    private void setTabSelection(int index) {
//        Log.e(TAG, "setTabSelection: " );
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        //添加一个FragmentTransaction的实例
        fragmentManager = getFragmentManager();
        // 开启一个Fragment事务
        transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);

        switch (index) {
            /**
             * 全部订单
             */
            case ALL:
                tvActivityIntegralShoppingMallAll.setTextColor(0xffff0000);
                vActivityIntegralShoppingMallAll.setBackgroundColor(0xffff0000);
                if (integralShoppingMallOrderAllFragment == null) {
                    integralShoppingMallOrderAllFragment = new IntegralShoppingMallOrderAllFragment();
                    transaction.add(R.id.ll_activity_integral_shopping_mall_parent, integralShoppingMallOrderAllFragment);
                } else {
                    transaction.show(integralShoppingMallOrderAllFragment);
                }
                setFragment = 100;
                break;
            /**
             * 待发货订单
             */
            case WAIT_SHIPMENTS:
                tvActivityIntegralShoppingMallWaitShipments.setTextColor(0xffff0000);
                vActivityIntegralShoppingMallWaitShipments.setBackgroundColor(0xffff0000);
                if (integralShoppingMallOrderWaitShipmentsFragment == null) {
                    integralShoppingMallOrderWaitShipmentsFragment = new IntegralShoppingMallOrderWaitShipmentsFragment();
                    transaction.add(R.id.ll_activity_integral_shopping_mall_parent, integralShoppingMallOrderWaitShipmentsFragment);
                } else {
                    transaction.show(integralShoppingMallOrderWaitShipmentsFragment);
                }
                setFragment = 200;
                break;
            /**
             * 待收货订单
             */
            case WAIT_RECEIVING:
                tvActivityIntegralShoppingMallWaitReceiving.setTextColor(0xffff0000);
                vActivityIntegralShoppingMallWaitReceiving.setBackgroundColor(0xffff0000);
                if (integralShoppingMallOrderWaitReceivingFragment == null) {
                    integralShoppingMallOrderWaitReceivingFragment = new IntegralShoppingMallOrderWaitReceivingFragment();
                    transaction.add(R.id.ll_activity_integral_shopping_mall_parent, integralShoppingMallOrderWaitReceivingFragment);
                } else {
                    transaction.show(integralShoppingMallOrderWaitReceivingFragment);
                }
                setFragment = 300;
                break;
            /**
             * 已完成订单
             */
            case ACCOMPLISH:
                tvActivityIntegralShoppingMallAccomplish.setTextColor(0xffff0000);
                vActivityIntegralShoppingMallAccomplish.setBackgroundColor(0xffff0000);
                if (integralShoppingMallOrderAccomplishFragment == null) {
                    integralShoppingMallOrderAccomplishFragment = new IntegralShoppingMallOrderAccomplishFragment();
                    transaction.add(R.id.ll_activity_integral_shopping_mall_parent, integralShoppingMallOrderAccomplishFragment);
                } else {
                    transaction.show(integralShoppingMallOrderAccomplishFragment);
                }
                setFragment = 400;
                break;
        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。（字体颜色和view背景颜色）
     */
    private void clearSelection() {
        tvActivityIntegralShoppingMallAll.setTextColor(0xff000000);
        vActivityIntegralShoppingMallAll.setBackgroundColor(0xdddddddd);

        tvActivityIntegralShoppingMallWaitShipments.setTextColor(0xff000000);
        vActivityIntegralShoppingMallWaitShipments.setBackgroundColor(0xdddddddd);

        tvActivityIntegralShoppingMallWaitReceiving.setTextColor(0xff000000);
        vActivityIntegralShoppingMallWaitReceiving.setBackgroundColor(0xdddddddd);

        tvActivityIntegralShoppingMallAccomplish.setTextColor(0xff000000);
        vActivityIntegralShoppingMallAccomplish.setBackgroundColor(0xdddddddd);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     * 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (integralShoppingMallOrderAllFragment != null) {
            transaction.hide(integralShoppingMallOrderAllFragment);
        }
        if (integralShoppingMallOrderWaitShipmentsFragment != null) {
            transaction.hide(integralShoppingMallOrderWaitShipmentsFragment);
        }
        if (integralShoppingMallOrderWaitReceivingFragment != null) {
            transaction.hide(integralShoppingMallOrderWaitReceivingFragment);
        }
        if (integralShoppingMallOrderAccomplishFragment != null) {
            transaction.hide(integralShoppingMallOrderAccomplishFragment);
        }
    }

    /**
     * 初始化展示和点击筛选之后的fragment展示
     */
    private void questionList() {
        Intent intent = this.getIntent();
        setFragment = intent.getIntExtra("setFragment", 0);
        Log.e(TAG, "questionList: --------" + setFragment);
        switch (setFragment) {
            /**
             * 全部订单
             */
            case 100:
                setTabSelection(ALL);
                break;
            /**
             * 待发货订单
             */
            case 200:
                setTabSelection(WAIT_SHIPMENTS);
                break;
            /**
             * 待收货订单
             */
            case 300:
                setTabSelection(WAIT_RECEIVING);
                break;
            /**
             * 已完成订单
             */
            case 400:
                setTabSelection(ACCOMPLISH);
                break;
            /**
             * 默认全部订单
             */
            default:
                setTabSelection(ALL);
                break;
        }
    }


    @OnClick({R.id.iv_activity_integral_shopping_mall_return,
            R.id.iv_activity_integral_shopping_mall_share,
            R.id.ll_activity_integral_shopping_mall_all,
            R.id.ll_activity_integral_shopping_mall_wait_shipments,
            R.id.ll_activity_integral_shopping_mall_wait_receiving,
            R.id.tv_activity_integral_shopping_mall_accomplish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            /**
             * 返回个人中心界面
             */
            case R.id.iv_activity_integral_shopping_mall_return:
                intent = new Intent(IntegralShoppingMallOrderActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_activity_integral_shopping_mall_share:
                // TODO: 2017/6/15 0015 分享待实现
                break;
            /**
             * 点击展示全部订单Fragment
             */
            case R.id.ll_activity_integral_shopping_mall_all:
                setTabSelection(1);
                break;
            /**
             * 点击展示待发货订单Fragment
             */
            case R.id.ll_activity_integral_shopping_mall_wait_shipments:
                setTabSelection(2);
                break;
            /**
             * 点击展示待收货订单Fragment
             */
            case R.id.ll_activity_integral_shopping_mall_wait_receiving:
                setTabSelection(3);
                break;
            /**
             * 点击展示已完成订单Fragment
             */
            case R.id.tv_activity_integral_shopping_mall_accomplish:
                setTabSelection(4);
                break;
        }
    }

}
