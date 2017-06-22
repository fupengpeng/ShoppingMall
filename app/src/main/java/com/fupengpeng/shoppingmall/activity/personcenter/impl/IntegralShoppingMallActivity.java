package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.fupengpeng.shoppingmall.MainActivity;
import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.activity.personcenter.view.IIntegralView;
import com.fupengpeng.shoppingmall.fragment.IntegralShoppingMallAllFragment;
import com.fupengpeng.shoppingmall.fragment.IntegralShoppingMallIntegralLottoFragment;
import com.fupengpeng.shoppingmall.fragment.IntegralShoppingMallZeroConversionFragment;
import com.fupengpeng.shoppingmall.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 积分商城
 */
public class IntegralShoppingMallActivity extends AppCompatActivity implements IIntegralView {

    /**
     * 返回个人中心
     */
    @BindView(R.id.iv_activity_integral_shopping_mall_return)
    ImageView ivActivityIntegralShoppingMallReturn;
    /**
     * 积分商城标题
     */
    @BindView(R.id.tv_activity_integral_shopping_mall_title)
    TextView tvActivityIntegralShoppingMallTitle;
    /**
     * 分享
     */
    @BindView(R.id.iv_activity_integral_shopping_mall_share)
    ImageView ivActivityIntegralShoppingMallShare;
    /**
     * 店铺首页图片
     */
    @BindView(R.id.iv_activity_integral_shopping_mall_store_pic)
    ImageView ivActivityIntegralShoppingMallStorePic;
    /**
     * 店铺首页
     */
    @BindView(R.id.ll_activity_integral_shopping_mall_store_home)
    LinearLayout llActivityIntegralShoppingMallStoreHome;
    /**
     * 积分
     */
    @BindView(R.id.tv_activity_integral_shopping_mall_integral)
    TextView tvActivityIntegralShoppingMallIntegral;
    /**
     * 如何获取积分
     */
    @BindView(R.id.tv_activity_integral_shopping_mall_integral_gain)
    TextView tvActivityIntegralShoppingMallIntegralGain;
    /**
     * 积分订单
     */
    @BindView(R.id.btn_activity_integral_shopping_mall_order)
    Button btnActivityIntegralShoppingMallOrder;
    /**
     * 全部商品
     */
    @BindView(R.id.tv_activity_integral_shopping_mall_all)
    TextView tvActivityIntegralShoppingMallAll;
    @BindView(R.id.v_activity_integral_shopping_mall_all)
    View vActivityIntegralShoppingMallAll;
    @BindView(R.id.ll_activity_integral_shopping_mall_all)
    LinearLayout llActivityIntegralShoppingMallAll;
    /**
     * 0元兑换
     */
    @BindView(R.id.tv_activity_integral_shopping_mall_zero_conversion)
    TextView tvActivityIntegralShoppingMallZeroConversion;
    @BindView(R.id.v_activity_integral_shopping_mall_zero_conversion)
    View vActivityIntegralShoppingMallZeroConversion;
    @BindView(R.id.ll_activity_integral_shopping_mall_zero_conversion)
    LinearLayout llActivityIntegralShoppingMallZeroConversion;
    /**
     * 积分抽奖
     */
    @BindView(R.id.tv_activity_integral_shopping_mall_integral_lotto)
    TextView tvActivityIntegralShoppingMallIntegralLotto;
    @BindView(R.id.v_activity_integral_shopping_mall_integral_lotto)
    View vActivityIntegralShoppingMallIntegralLotto;
    @BindView(R.id.ll_activity_integral_shopping_mall_integral_lotto)
    LinearLayout llActivityIntegralShoppingMallIntegralLotto;
    /**
     * Fragment容器
     */
    @BindView(R.id.ll_activity_integral_shopping_mall_parent)
    LinearLayout llActivityIntegralShoppingMallParent;

    @BindView(R.id.ll_activity_integral_shopping_mall_scrollview)
    LinearLayout llActivityIntegralShoppingMallScrollview;
    @BindView(R.id.scv_activity_integral_shopping_mall)
    ScrollView scvActivityIntegralShoppingMall;


    private Intent intent;

    private int setFragment = 500;

    private static final int GROUP_AT = 1;
    private static final int GROUP_FINISH = 2;
    private static final int GROUP_UNFINISHED = 3;

    /**
     * 用于展示全部商品的Fragment
     */
    private IntegralShoppingMallAllFragment integralShoppingMallAllFragment;

    /**
     * 用于展示0元换购的Fragment
     */
    private IntegralShoppingMallZeroConversionFragment integralShoppingMallZeroConversionFragment;

    /**
     * 用于展示积分抽奖的Fragment
     */
    private IntegralShoppingMallIntegralLottoFragment integralShoppingMallIntegralLottoFragment;


    /**
     * 用于对Fragment的管理
     */
    FragmentManager fragmentManager;
    FragmentTransaction transaction;

    public static final String TAG = "GrouponActivity";
    private Intent intent1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integral_shopping_mall);
        ButterKnife.bind(this);

        scvActivityIntegralShoppingMall.requestChildFocus(llActivityIntegralShoppingMallScrollview,null);
        Log.e(TAG, "onCreate: " + "进入积分商城");
        setTabSelection(1);

    }


    @OnClick({R.id.iv_activity_integral_shopping_mall_return,
            R.id.iv_activity_integral_shopping_mall_share,
            R.id.ll_activity_integral_shopping_mall_store_home,
            R.id.tv_activity_integral_shopping_mall_integral_gain,
            R.id.btn_activity_integral_shopping_mall_order,
            R.id.ll_activity_integral_shopping_mall_all,
            R.id.ll_activity_integral_shopping_mall_zero_conversion,
            R.id.ll_activity_integral_shopping_mall_integral_lotto})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            /**
             * 返回和分享
             */
            case R.id.iv_activity_integral_shopping_mall_return:
                intent1 = new Intent(IntegralShoppingMallActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.iv_activity_integral_shopping_mall_share:
                // TODO: 2017/6/15 0015 分享待实现
                ToastUtils.showLong(IntegralShoppingMallActivity.this, "分享待实现");
                break;
            /**
             * 店铺首页
             */
            case R.id.ll_activity_integral_shopping_mall_store_home:
                ToastUtils.showLong(IntegralShoppingMallActivity.this, "店铺首页待实现");
                break;
            /**
             * 获取积分
             */
            case R.id.tv_activity_integral_shopping_mall_integral_gain:
                intent = new Intent(IntegralShoppingMallActivity.this, IntegralPersonActivity.class);
                startActivity(intent);
                break;
            /**
             * 积分商城订单
             */
            case R.id.btn_activity_integral_shopping_mall_order:
                intent = new Intent(IntegralShoppingMallActivity.this, IntegralShoppingMallOrderActivity.class);
                startActivity(intent);
                break;
            /**
             * 全部商品  0元兑换  积分抽奖
             */
            case R.id.ll_activity_integral_shopping_mall_all:
                setTabSelection(1);
                break;
            case R.id.ll_activity_integral_shopping_mall_zero_conversion:
                setTabSelection(2);
                break;
            case R.id.ll_activity_integral_shopping_mall_integral_lotto:
                setTabSelection(3);
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
            case GROUP_AT:
                // 当点击了已解决图片时，改变控件的图片
                tvActivityIntegralShoppingMallAll.setTextColor(0xffff0000);
                vActivityIntegralShoppingMallAll.setBackgroundColor(0xffff0000);
                if (integralShoppingMallAllFragment == null) {
                    integralShoppingMallAllFragment = new IntegralShoppingMallAllFragment();
                    transaction.add(R.id.ll_activity_integral_shopping_mall_parent, integralShoppingMallAllFragment);
                } else {
                    transaction.show(integralShoppingMallAllFragment);
                }
                setFragment = 100;
                break;
            case GROUP_FINISH:

                // 当点击了未解决图片时，改变控件的图片
                tvActivityIntegralShoppingMallZeroConversion.setTextColor(0xffff0000);
                vActivityIntegralShoppingMallZeroConversion.setBackgroundColor(0xffff0000);
                if (integralShoppingMallZeroConversionFragment == null) {
                    integralShoppingMallZeroConversionFragment = new IntegralShoppingMallZeroConversionFragment();
                    transaction.add(R.id.ll_activity_integral_shopping_mall_parent, integralShoppingMallZeroConversionFragment);
                } else {
                    transaction.show(integralShoppingMallZeroConversionFragment);
                }
                setFragment = 200;
                break;
            case GROUP_UNFINISHED:
                // 当点击了我要提问时，改变控件的图片
                tvActivityIntegralShoppingMallIntegralLotto.setTextColor(0xffff0000);
                vActivityIntegralShoppingMallIntegralLotto.setBackgroundColor(0xffff0000);
                if (integralShoppingMallIntegralLottoFragment == null) {
                    integralShoppingMallIntegralLottoFragment = new IntegralShoppingMallIntegralLottoFragment();
                    transaction.add(R.id.ll_activity_integral_shopping_mall_parent, integralShoppingMallIntegralLottoFragment);
                } else {
                    transaction.show(integralShoppingMallIntegralLottoFragment);
                }
                setFragment = 300;
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
        tvActivityIntegralShoppingMallZeroConversion.setTextColor(0xff000000);
        vActivityIntegralShoppingMallZeroConversion.setBackgroundColor(0xdddddddd);
        tvActivityIntegralShoppingMallIntegralLotto.setTextColor(0xff000000);
        vActivityIntegralShoppingMallIntegralLotto.setBackgroundColor(0xdddddddd);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     * 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (integralShoppingMallAllFragment != null) {
            transaction.hide(integralShoppingMallAllFragment);
        }
        if (integralShoppingMallZeroConversionFragment != null) {
            transaction.hide(integralShoppingMallZeroConversionFragment);
        }
        if (integralShoppingMallIntegralLottoFragment != null) {
            transaction.hide(integralShoppingMallIntegralLottoFragment);
        }
    }


}
