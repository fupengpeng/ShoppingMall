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
import com.fupengpeng.shoppingmall.activity.personcenter.view.IDiscountCouponView;
import com.fupengpeng.shoppingmall.fragment.DiscountCouponUnusedFragment;
import com.fupengpeng.shoppingmall.fragment.DiscountCouponUselessFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的优惠券
 */
public class DiscountCouponActivity extends AppCompatActivity implements IDiscountCouponView {

    @BindView(R.id.iv_activity_discount_coupon_return)
    ImageView ivActivityDiscountCouponReturn;
    @BindView(R.id.iv_activity_discount_coupon_close)
    ImageView ivActivityDiscountCouponClose;

    @BindView(R.id.tv_activity_discount_coupon_unused)
    TextView tvActivityDiscountCouponUnused;
    @BindView(R.id.v_activity_discount_coupon_unused)
    View vActivityDiscountCouponUnused;
    @BindView(R.id.ll_activity_discount_coupon_unused)
    LinearLayout llActivityDiscountCouponUnused;

    @BindView(R.id.tv_activity_discount_coupon_useless)
    TextView tvActivityDiscountCouponUseless;
    @BindView(R.id.v_activity_discount_coupon_useless)
    View vActivityDiscountCouponUseless;
    @BindView(R.id.ll_activity_discount_coupon_useless)
    LinearLayout llActivityDiscountCouponUseless;

    @BindView(R.id.ll_activity_discount_coupon_parent)
    LinearLayout llActivityDiscountCouponParent;


    private DiscountCouponUnusedFragment discountCouponUnusedFragment;

    private DiscountCouponUselessFragment discountCouponUselessFragment;

    private Intent intent;


    private static final int UNUSED = 1;
    private static final int USELESS = 2;


    /**
     * 用于对Fragment的管理
     */
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    private int setFragment;

    public static final String TAG = "BargainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount_coupon);
        ButterKnife.bind(this);



        setTabSelection(1);

    }

    @OnClick({R.id.iv_activity_discount_coupon_return,
            R.id.iv_activity_discount_coupon_close,
            R.id.ll_activity_discount_coupon_unused,
            R.id.ll_activity_discount_coupon_useless})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_activity_discount_coupon_return:
                intent = new Intent(DiscountCouponActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_activity_discount_coupon_close:
                break;
            case R.id.ll_activity_discount_coupon_unused:
                setTabSelection(1);
                break;
            case R.id.ll_activity_discount_coupon_useless:
                setTabSelection(2);
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
            case UNUSED:
                // 当点击了已解决图片时，改变控件的图片
                tvActivityDiscountCouponUnused.setTextColor(0xffff0000);
                vActivityDiscountCouponUnused.setBackgroundColor(0xffff0000);
                Log.e(TAG, "setTabSelection--------------setTabSelection: " + "-----------0");
                if (discountCouponUnusedFragment == null) {
                    // 如果resolvedFragment为空，则创建一个并添加到界面上
                    discountCouponUnusedFragment = new DiscountCouponUnusedFragment();
                    transaction.add(R.id.ll_activity_discount_coupon_parent, discountCouponUnusedFragment);
                } else {
                    // 如果resolvedFragment不为空，则直接将它显示出来
                    transaction.show(discountCouponUnusedFragment);
                }
                setFragment = 100;
                break;
            case USELESS:

                // 当点击了未解决图片时，改变控件的图片
                tvActivityDiscountCouponUseless.setTextColor(0xffff0000);
                vActivityDiscountCouponUseless.setBackgroundColor(0xffff0000);
                Log.e(TAG, "setTabSelection--------------setTabSelection: " + "-----------1");
                if (discountCouponUselessFragment == null) {
                    // 如果unsolvedFragment为空，则创建一个并添加到界面上
                    discountCouponUselessFragment = new DiscountCouponUselessFragment();
                    transaction.add(R.id.ll_activity_discount_coupon_parent, discountCouponUselessFragment);
                } else {
                    // 如果unsolvedFragment不为空，则直接将它显示出来
                    transaction.show(discountCouponUselessFragment);
                }
                setFragment = 200;
                break;
        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。（字体颜色和view背景颜色）
     */
    private void clearSelection() {
        tvActivityDiscountCouponUnused.setTextColor(0xff000000);
        vActivityDiscountCouponUnused.setBackgroundColor(0xdddddddd);
        tvActivityDiscountCouponUseless.setTextColor(0xff000000);
        vActivityDiscountCouponUseless.setBackgroundColor(0xdddddddd);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     * 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
//        Log.e(TAG, "hideFragments: " );
        if (discountCouponUnusedFragment != null) {
            transaction.hide(discountCouponUnusedFragment);
        }
        if (discountCouponUselessFragment != null) {
            transaction.hide(discountCouponUselessFragment);
        }
    }
}
