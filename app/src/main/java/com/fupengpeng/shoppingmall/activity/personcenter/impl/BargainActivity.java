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


import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.activity.BaseActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.view.IBargainView;
import com.fupengpeng.shoppingmall.fragment.BargainAtFragment;
import com.fupengpeng.shoppingmall.fragment.BargainHistoryFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的砍价界面
 */
public class BargainActivity extends AppCompatActivity implements IBargainView {

    @BindView(R.id.iv_activity_bargain_return)
    ImageView ivActivityBargainReturn;
    @BindView(R.id.iv_activity_bargain_close)
    ImageView ivActivityBargainClose;

    @BindView(R.id.tv_activity_bargain_at)
    TextView tvActivityBargainAt;
    @BindView(R.id.v_activity_bargain_at)
    View vActivityBargainAt;
    @BindView(R.id.ll_activity_bargain_at)
    LinearLayout llActivityBargainAt;

    @BindView(R.id.tv_activity_bargain_history)
    TextView tvActivityBargainHistory;
    @BindView(R.id.v_activity_bargain_history)
    View vActivityBargainHistory;
    @BindView(R.id.ll_activity_bargain_history)
    LinearLayout llActivityBargainHistory;

    @BindView(R.id.ll_activity_bargain_parent)
    LinearLayout llActivityBargainParent;


    private BargainAtFragment bargainAtFragment;

    private BargainHistoryFragment bargainHistoryFragment;

    private Intent intent;

    private int setFragment = 500;

    private static final int UNUSED = 1;
    private static final int USELESS = 2;


    /**
     * 用于对Fragment的管理
     */
    FragmentManager fragmentManager;
    FragmentTransaction transaction;

    public static final String TAG = "BargainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bargain);
        ButterKnife.bind(this);

        setTabSelection(1);
    }

    @OnClick({R.id.iv_activity_bargain_return,
            R.id.iv_activity_bargain_close,
            R.id.ll_activity_bargain_at,
            R.id.ll_activity_bargain_history})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_activity_bargain_return:
                break;
            case R.id.iv_activity_bargain_close:
                break;
            case R.id.ll_activity_bargain_at:
                setTabSelection(1);
                break;
            case R.id.ll_activity_bargain_history:
                setTabSelection(2);
                break;
        }
    }


    /**
     * 根据传入的index参数来设置选中的Fragment。
     *
     * @param index
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
                tvActivityBargainAt.setTextColor(0xffff0000);
                vActivityBargainAt.setBackgroundColor(0xffff0000);
                Log.e(TAG, "setTabSelection--------------setTabSelection: " + "-----------0");
                if (bargainAtFragment == null) {
                    // 如果resolvedFragment为空，则创建一个并添加到界面上
                    bargainAtFragment = new BargainAtFragment();
                    transaction.add(R.id.ll_activity_bargain_parent, bargainAtFragment);
                } else {
                    // 如果resolvedFragment不为空，则直接将它显示出来
                    transaction.show(bargainAtFragment);
                }
                setFragment = 100;
                break;
            case USELESS:

                // 当点击了未解决图片时，改变控件的图片
                tvActivityBargainHistory.setTextColor(0xffff0000);
                vActivityBargainHistory.setBackgroundColor(0xffff0000);
                Log.e(TAG, "setTabSelection--------------setTabSelection: " + "-----------1");
                if (bargainHistoryFragment == null) {
                    // 如果unsolvedFragment为空，则创建一个并添加到界面上
                    bargainHistoryFragment = new BargainHistoryFragment();
                    transaction.add(R.id.ll_activity_bargain_parent, bargainHistoryFragment);
                } else {
                    // 如果unsolvedFragment不为空，则直接将它显示出来
                    transaction.show(bargainHistoryFragment);
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
        tvActivityBargainAt.setTextColor(0xff000000);
        vActivityBargainAt.setBackgroundColor(0xdddddddd);
        tvActivityBargainHistory.setTextColor(0xff000000);
        vActivityBargainHistory.setBackgroundColor(0xdddddddd);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     * 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
//        Log.e(TAG, "hideFragments: " );
        if (bargainAtFragment != null) {
            transaction.hide(bargainAtFragment);
        }
        if (bargainHistoryFragment != null) {
            transaction.hide(bargainHistoryFragment);
        }
    }


}
