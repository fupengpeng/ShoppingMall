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
import com.fupengpeng.shoppingmall.activity.personcenter.view.IOrderCenterView;
import com.fupengpeng.shoppingmall.fragment.OrderCenterAllFragment;
import com.fupengpeng.shoppingmall.fragment.OrderCenterRefundAfterSalesFragment;
import com.fupengpeng.shoppingmall.fragment.OrderCenterWaitEvaluationFragment;
import com.fupengpeng.shoppingmall.fragment.OrderCenterWaitPaymentFragment;
import com.fupengpeng.shoppingmall.fragment.OrderCenterWaitPickingFragment;
import com.fupengpeng.shoppingmall.fragment.OrderCenterWaitReceivingFragment;
import com.fupengpeng.shoppingmall.fragment.OrderCenterWaitShipmentsFragment;
import com.fupengpeng.shoppingmall.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 订单管理界面
 */
public class OrderCenterActivity extends AppCompatActivity implements IOrderCenterView,View.OnClickListener {

    /**
     * 返回个人中心界面
     */
    @BindView(R.id.iv_activity_order_center_return)
    ImageView ivActivityOrderCenterReturn;
    /**
     * 关闭订单管理界面
     */
    @BindView(R.id.iv_activity_order_center_close)
    ImageView ivActivityOrderCenterClose;

    /**
     * 全部订单按钮TextView
     */
    @BindView(R.id.tv_activity_order_center_all)
    TextView tvActivityOrderCenterAll;
    @BindView(R.id.v_activity_order_center_all)
    View vActivityOrderCenterAll;
    /**
     * 全部订单Fragment控制按钮
     */
    @BindView(R.id.ll_activity_order_center_all)
    LinearLayout llActivityOrderCenterAll;

    /**
     * 待付款订单按钮TextView
     */
    @BindView(R.id.tv_activity_order_center_wait_payment)
    TextView tvActivityOrderCenterWaitPayment;
    @BindView(R.id.v_activity_order_center_wait_payment)
    View vActivityOrderCenterWaitPayment;
    /**
     * 待付款订单Fragment控制按钮
     */
    @BindView(R.id.ll_activity_order_center_wait_payment)
    LinearLayout llActivityOrderCenterWaitPayment;

    /**
     * 待发货订单按钮TextView
     */
    @BindView(R.id.tv_activity_order_center_wait_shipments)
    TextView tvActivityOrderCenterWaitShipments;
    @BindView(R.id.v_activity_order_center_wait_shipments)
    View vActivityOrderCenterWaitShipments;
    /**
     * 待发货订单Fragment控制按钮
     */
    @BindView(R.id.ll_activity_order_center_wait_shipments)
    LinearLayout llActivityOrderCenterWaitShipments;

    /**
     * 待收货订单按钮TextView
     */
    @BindView(R.id.tv_activity_order_center_wait_receiving)
    TextView tvActivityOrderCenterWaitReceiving;
    @BindView(R.id.v_activity_order_center_wait_receiving)
    View vActivityOrderCenterWaitReceiving;
    /**
     * 待收货订单Fragment控制按钮
     */
    @BindView(R.id.ll_activity_order_center_wait_receiving)
    LinearLayout llActivityOrderCenterWaitReceiving;

    /**
     * 待评价订单按钮TextView
     */
    @BindView(R.id.tv_activity_order_center_wait_picking)
    TextView tvActivityOrderCenterWaitPicking;
    @BindView(R.id.v_activity_order_center_wait_picking)
    View vActivityOrderCenterWaitPicking;
    /**
     * 待评价订单Fragment控制按钮
     */
    @BindView(R.id.ll_activity_order_center_wait_picking)
    LinearLayout llActivityOrderCenterWaitPicking;

    /**
     * 待提货订单按钮TextView
     */
    @BindView(R.id.tv_activity_order_center_wait_evaluation)
    TextView tvActivityOrderCenterWaitEvaluation;
    @BindView(R.id.v_activity_order_center_wait_evaluation)
    View vActivityOrderCenterWaitEvaluation;
    /**
     * 待提货订单Fragment控制按钮
     */
    @BindView(R.id.ll_activity_order_center_wait_evaluation)
    LinearLayout llActivityOrderCenterWaitEvaluation;

    /**
     * 售后按钮TextView
     */
    @BindView(R.id.tv_activity_order_center_refund_after_sales)
    TextView tvActivityOrderCenterRefundAfterSales;
    @BindView(R.id.v_activity_order_center_refund_after_sales)
    View vActivityOrderCenterRefundAfterSales;
    /**
     * 售后Fragment控制按钮
     */
    @BindView(R.id.ll_activity_order_center_refund_after_sales)
    LinearLayout llActivityOrderCenterRefundAfterSales;

    /**
     * 订单列表Fragment容器
     */
    @BindView(R.id.ll_activity_order_center_parent)
    LinearLayout llActivityOrderCenterParent;

    /**
     * 全部订单Fragment
     */
    private OrderCenterAllFragment orderCenterAllFragment;
    /**
     * 待付款订单Fragment
     */
    private OrderCenterWaitPaymentFragment orderCenterWaitPaymentFragment;
    /**
     * 待发货订单Fragment
     */
    private OrderCenterWaitShipmentsFragment orderCenterWaitShipmentsFragment;
    /**
     * 待收货订单Fragment
     */
    private OrderCenterWaitReceivingFragment orderCenterWaitReceivingFragment;
    /**
     * 待评价订单Fragment
     */
    private OrderCenterWaitPickingFragment orderCenterWaitPickingFragment;
    /**
     * 待提货订单Fragment
     */
    private OrderCenterWaitEvaluationFragment orderCenterWaitEvaluationFragment;
    /**
     * 售后Fragment
     */
    private OrderCenterRefundAfterSalesFragment orderCenterRefundAfterSalesFragment;


    private Intent intent;

    /**
     * 设置展示Fragment的参数
     */
    private int setFragment;

    /**
     * 全部订单
     */
    private static final int ALL = 1;
    /**
     * 待付款订单
     */
    private static final int WAIT_PAYMENT = 2;
    /**
     * 待发货订单
     */
    private static final int WAIT_SHIPMENTS = 3;
    /**
     * 待收货订单
     */
    private static final int WAIT_RECEIVING = 4;
    /**
     * 待评价订单
     */
    private static final int WAIT_PICKING = 5;
    /**
     * 待提货订单
     */
    private static final int WAIT_EVALUATION = 6;
    /**
     * 售后订单
     */
    private static final int REFUND_AFTER_SALES = 7;

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
        setContentView(R.layout.activity_order_center);
        ButterKnife.bind(this);


        questionList();

    }

    @OnClick({R.id.iv_activity_order_center_return,
            R.id.iv_activity_order_center_close,
            R.id.tv_activity_order_center_all,
            R.id.tv_activity_order_center_wait_payment,
            R.id.tv_activity_order_center_wait_shipments,
            R.id.tv_activity_order_center_wait_receiving,
            R.id.tv_activity_order_center_wait_picking,
            R.id.tv_activity_order_center_wait_evaluation,
            R.id.tv_activity_order_center_refund_after_sales})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            /**
             * 返回个人中心界面
             */
            case R.id.iv_activity_order_center_return:
                intent = new Intent(OrderCenterActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            /**
             * 点击展示全部订单Fragment
             */
            case R.id.tv_activity_order_center_all:
                setTabSelection(1);
                break;
            /**
             * 点击展示待付款订单Fragment
             */
            case R.id.tv_activity_order_center_wait_payment:
                setTabSelection(2);
                break;
            /**
             * 点击展示待发货订单Fragment
             */
            case R.id.tv_activity_order_center_wait_shipments:
                setTabSelection(3);
                break;
            /**
             * 点击展示待收货订单Fragment
             */
            case R.id.tv_activity_order_center_wait_receiving:
                setTabSelection(4);
                break;
            /**
             * 点击展示待评价订单Fragment
             */
            case R.id.tv_activity_order_center_wait_picking:
                setTabSelection(5);
                break;
            /**
             * 点击展示待提货订单Fragment
             */
            case R.id.tv_activity_order_center_wait_evaluation:
                setTabSelection(6);
                break;
            /**
             * 点击展示售后Fragment
             */
            case R.id.tv_activity_order_center_refund_after_sales:
                setTabSelection(7);
                break;
        }
    }


    /**
     * Fragment列表子条目内控件的点击事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            /**
             * 点击跳转至订单详情界面
             */
            case R.id.tv_item_fragment_order_center_order_list_order_number_explain:
                intent = new Intent(this, OrderParticularsActivity.class);
                bundle = new Bundle();
                bundle.putInt("setFragment",setFragment);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            /**
             * 点击跳转至订单详情界面
             */
            case R.id.tv_item_fragment_order_center_order_list_order_number:
                intent = new Intent(this, OrderParticularsActivity.class);
                bundle = new Bundle();
                bundle.putInt("setFragment",setFragment);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            /**
             * 点击跳转至订单详情界面
             */
            case R.id.tv_item_fragment_order_center_order_list_order_state:
                intent = new Intent(this, OrderParticularsActivity.class);
                bundle = new Bundle();
                bundle.putInt("setFragment",setFragment);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            /**
             * 点击跳转至订单详情界面
             */
            case R.id.iv_item_fragment_order_center_order_list_commodity_pic:
                intent = new Intent(this, OrderParticularsActivity.class);
                bundle = new Bundle();
                bundle.putInt("setFragment",setFragment);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            /**
             * 点击跳转至订单详情界面
             */
            case R.id.tv_item_fragment_order_center_order_list_commodity_name:
                intent = new Intent(this, OrderParticularsActivity.class);
                bundle = new Bundle();
                bundle.putInt("setFragment",setFragment);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            /**
             * 点击跳转至订单详情界面
             */
            case R.id.tv_item_fragment_order_center_order_list_commodity_quantity:
                intent = new Intent(this, OrderParticularsActivity.class);
                bundle = new Bundle();
                bundle.putInt("setFragment",setFragment);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            /**
             * 点击跳转至订单详情界面
             */
            case R.id.tv_item_fragment_order_center_order_list_commodity_pay:
                intent = new Intent(this, OrderParticularsActivity.class);
                bundle = new Bundle();
                bundle.putInt("setFragment",setFragment);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            /**
             * 点击跳转至订单详情界面
             */
            case R.id.tv_item_fragment_order_center_order_list_commodity_aggregate_price:
                intent = new Intent(this, OrderParticularsActivity.class);
                bundle = new Bundle();
                bundle.putInt("setFragment",setFragment);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            /**
             * 点击跳转至订单详情界面
             */
            case R.id.v_item_fragment_order_center_order_list_blank:
                intent = new Intent(this, OrderParticularsActivity.class);
                bundle = new Bundle();
                bundle.putInt("setFragment",setFragment);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            /**
             * 点击按钮one实现对应操作
             */
            case R.id.btn_item_fragment_order_center_order_list_one:
                // TODO: 2017/6/9 0009 订单相关操作待实现
                ToastUtils.showLong(this,"再次购买待实现");
                break;
            /**
             * 点击按钮two实现对应操作
             */
            case R.id.btn_item_fragment_order_center_order_list_two:
                ToastUtils.showLong(this,"取消订单待实现");
                break;
            /**
             * 点击按钮three实现对应操作
             */
            case R.id.btn_item_fragment_order_center_order_list_three:
                ToastUtils.showLong(this,"待付款待实现");
                break;

        }

    }


    /**
     * 根据传入的index参数来设置选中的Fragment。
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
             * 订单管理界面
             */
            case ALL:
                // 当点击了已解决图片时，改变控件的图片
                tvActivityOrderCenterAll.setTextColor(0xffff0000);
                vActivityOrderCenterAll.setBackgroundColor(0xffff0000);
                Log.e(TAG, "setTabSelection--------------setTabSelection: " + "-----------0");
                if (orderCenterAllFragment == null) {
                    // 如果resolvedFragment为空，则创建一个并添加到界面上
                    orderCenterAllFragment = new OrderCenterAllFragment();
                    transaction.add(R.id.ll_activity_order_center_parent, orderCenterAllFragment);
                } else {
                    // 如果resolvedFragment不为空，则直接将它显示出来
                    transaction.show(orderCenterAllFragment);
                }
                setFragment = 100;
                break;
            /**
             * 订单管理界面
             */
            case WAIT_PAYMENT:

                // 当点击了未解决图片时，改变控件的图片
                tvActivityOrderCenterWaitPayment.setTextColor(0xffff0000);
                vActivityOrderCenterWaitPayment.setBackgroundColor(0xffff0000);
                Log.e(TAG, "setTabSelection--------------setTabSelection: " + "-----------1");
                if (orderCenterWaitPaymentFragment == null) {
                    // 如果unsolvedFragment为空，则创建一个并添加到界面上
                    orderCenterWaitPaymentFragment = new OrderCenterWaitPaymentFragment();
                    transaction.add(R.id.ll_activity_order_center_parent, orderCenterWaitPaymentFragment);
                } else {
                    // 如果unsolvedFragment不为空，则直接将它显示出来
                    transaction.show(orderCenterWaitPaymentFragment);
                }
                setFragment = 200;
                break;
            /**
             * 订单管理界面
             */
            case WAIT_SHIPMENTS:
                // 当点击了我要提问时，改变控件的图片
                tvActivityOrderCenterWaitShipments.setTextColor(0xffff0000);
                vActivityOrderCenterWaitShipments.setBackgroundColor(0xffff0000);
                if (orderCenterWaitShipmentsFragment == null) {
                    // 如果iQuizFragment为空，则创建一个并添加到界面上
                    orderCenterWaitShipmentsFragment = new OrderCenterWaitShipmentsFragment();
                    transaction.add(R.id.ll_activity_order_center_parent, orderCenterWaitShipmentsFragment);
                } else {
                    // 如果iQuizFragment不为空，则直接将它显示出来
                    transaction.show(orderCenterWaitShipmentsFragment);
                }
                setFragment = 300;
                break;
            /**
             * 订单管理界面
             */
            case WAIT_RECEIVING:
                // 当点击了我要提问时，改变控件的图片
                tvActivityOrderCenterWaitReceiving.setTextColor(0xffff0000);
                vActivityOrderCenterWaitReceiving.setBackgroundColor(0xffff0000);
                if (orderCenterWaitReceivingFragment == null) {
                    // 如果iQuizFragment为空，则创建一个并添加到界面上
                    orderCenterWaitReceivingFragment = new OrderCenterWaitReceivingFragment();
                    transaction.add(R.id.ll_activity_order_center_parent, orderCenterWaitReceivingFragment);
                } else {
                    // 如果iQuizFragment不为空，则直接将它显示出来
                    transaction.show(orderCenterWaitReceivingFragment);
                }
                setFragment = 400;
                break;
            /**
             * 订单管理界面
             */
            case WAIT_PICKING:
                // 当点击了我要提问时，改变控件的图片
                tvActivityOrderCenterWaitPicking.setTextColor(0xffff0000);
                vActivityOrderCenterWaitPicking.setBackgroundColor(0xffff0000);
                if (orderCenterWaitPickingFragment == null) {
                    // 如果iQuizFragment为空，则创建一个并添加到界面上
                    orderCenterWaitPickingFragment = new OrderCenterWaitPickingFragment();
                    transaction.add(R.id.ll_activity_order_center_parent, orderCenterWaitPickingFragment);
                } else {
                    // 如果iQuizFragment不为空，则直接将它显示出来
                    transaction.show(orderCenterWaitPickingFragment);
                }
                setFragment = 500;
                break;
            /**
             * 订单管理界面
             */
            case WAIT_EVALUATION:
                // 当点击了我要提问时，改变控件的图片
                tvActivityOrderCenterWaitEvaluation.setTextColor(0xffff0000);
                vActivityOrderCenterWaitEvaluation.setBackgroundColor(0xffff0000);
                if (orderCenterWaitEvaluationFragment == null) {
                    // 如果iQuizFragment为空，则创建一个并添加到界面上
                    orderCenterWaitEvaluationFragment = new OrderCenterWaitEvaluationFragment();
                    transaction.add(R.id.ll_activity_order_center_parent, orderCenterWaitEvaluationFragment);
                } else {
                    // 如果iQuizFragment不为空，则直接将它显示出来
                    transaction.show(orderCenterWaitEvaluationFragment);
                }
                setFragment = 600;
                break;
            /**
             * 订单管理界面
             */
            case REFUND_AFTER_SALES:
                // 当点击了我要提问时，改变控件的图片
                tvActivityOrderCenterRefundAfterSales.setTextColor(0xffff0000);
                vActivityOrderCenterRefundAfterSales.setBackgroundColor(0xffff0000);
                if (orderCenterRefundAfterSalesFragment == null) {
                    // 如果iQuizFragment为空，则创建一个并添加到界面上
                    orderCenterRefundAfterSalesFragment = new OrderCenterRefundAfterSalesFragment();
                    transaction.add(R.id.ll_activity_order_center_parent, orderCenterRefundAfterSalesFragment);
                } else {
                    // 如果iQuizFragment不为空，则直接将它显示出来
                    transaction.show(orderCenterRefundAfterSalesFragment);
                }
                setFragment = 700;
                break;
        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。（字体颜色和view背景颜色）
     */
    private void clearSelection() {
        tvActivityOrderCenterAll.setTextColor(0xff000000);
        vActivityOrderCenterAll.setBackgroundColor(0xdddddddd);

        tvActivityOrderCenterWaitPayment.setTextColor(0xff000000);
        vActivityOrderCenterWaitPayment.setBackgroundColor(0xdddddddd);

        tvActivityOrderCenterWaitShipments.setTextColor(0xff000000);
        vActivityOrderCenterWaitShipments.setBackgroundColor(0xdddddddd);

        tvActivityOrderCenterWaitReceiving.setTextColor(0xff000000);
        vActivityOrderCenterWaitReceiving.setBackgroundColor(0xdddddddd);

        tvActivityOrderCenterWaitPicking.setTextColor(0xff000000);
        vActivityOrderCenterWaitPicking.setBackgroundColor(0xdddddddd);

        tvActivityOrderCenterWaitEvaluation.setTextColor(0xff000000);
        vActivityOrderCenterWaitEvaluation.setBackgroundColor(0xdddddddd);

        tvActivityOrderCenterRefundAfterSales.setTextColor(0xff000000);
        vActivityOrderCenterRefundAfterSales.setBackgroundColor(0xdddddddd);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     * 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
//        Log.e(TAG, "hideFragments: " );
        if (orderCenterAllFragment != null) {
            transaction.hide(orderCenterAllFragment);
        }
        if (orderCenterWaitPaymentFragment != null) {
            transaction.hide(orderCenterWaitPaymentFragment);
        }
        if (orderCenterWaitShipmentsFragment != null) {
            transaction.hide(orderCenterWaitShipmentsFragment);
        }
        if (orderCenterWaitReceivingFragment != null) {
            transaction.hide(orderCenterWaitReceivingFragment);
        }
        if (orderCenterWaitPickingFragment != null) {
            transaction.hide(orderCenterWaitPickingFragment);
        }
        if (orderCenterWaitEvaluationFragment != null) {
            transaction.hide(orderCenterWaitEvaluationFragment);
        }
        if (orderCenterRefundAfterSalesFragment != null) {
            transaction.hide(orderCenterRefundAfterSalesFragment);
        }
    }

    /**
     * 初始化展示和点击筛选之后的fragment展示
     */
    private void questionList(){
        Intent intent = this.getIntent();
        setFragment = intent.getIntExtra("setFragment",0);
        Log.e(TAG, "questionList: --------"+ setFragment);
        switch (setFragment){
            /**
             * 订单管理界面
             */
            case 100:
                //展示OrderCenterWaitPaymentFragment
                Log.e(TAG, "questionList: "+"001" );
                setTabSelection(ALL);
                break;
            /**
             * 订单管理界面
             */
            case 200:
                //展示OrderCenterWaitPaymentFragment
                Log.e(TAG, "questionList: "+"002" );
                setTabSelection(WAIT_PAYMENT);
                break;
            /**
             * 订单管理界面
             */
            case 300:
                //展示OrderCenterWaitShipmentsFragment
                Log.e(TAG, "questionList: "+"003" );
                setTabSelection(WAIT_SHIPMENTS);
                break;
            /**
             * 订单管理界面
             */
            case 400:
                //展示我的已解决问题Fragment
                Log.e(TAG, "questionList: "+"004" );
                setTabSelection(WAIT_RECEIVING);
                break;
            /**
             * 订单管理界面
             */
            case 500:
                //展示OrderCenterWaitPaymentFragment
                Log.e(TAG, "questionList: "+"005" );
                setTabSelection(WAIT_PICKING);
                break;
            /**
             * 订单管理界面
             */
            case 600:
                //展示我的未解决Fragment
                Log.e(TAG, "questionList: "+"006" );
                setTabSelection(WAIT_EVALUATION);
                break;
            /**
             * 订单管理界面
             */
            case 700:
                //展示我的未解决Fragment
                Log.e(TAG, "questionList: "+"007" );
                setTabSelection(REFUND_AFTER_SALES);
                break;
            /**
             * 订单管理界面
             */
            default:
                //展示ResolvedFragment
                Log.e(TAG, "questionList: "+"001" );
                setTabSelection(ALL);
                break;
        }
    }


}
