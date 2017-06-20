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
import com.fupengpeng.shoppingmall.activity.personcenter.view.IGrouponView;
import com.fupengpeng.shoppingmall.fragment.GrouponAtFragment;
import com.fupengpeng.shoppingmall.fragment.GrouponFinishFragment;
import com.fupengpeng.shoppingmall.fragment.GrouponUnfinishedFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GrouponActivity extends AppCompatActivity implements IGrouponView {

    @BindView(R.id.iv_activity_groupon_return)
    ImageView ivActivityGrouponReturn;
    @BindView(R.id.iv_activity_groupon_close)
    ImageView ivActivityGrouponClose;
    @BindView(R.id.ll_activity_groupon_at)
    LinearLayout llActivityGrouponAt;
    @BindView(R.id.ll_activity_groupon_finish)
    LinearLayout llActivityGrouponFinish;
    @BindView(R.id.ll_activity_groupon_unfinished)
    LinearLayout llActivityGrouponUnfinished;
    @BindView(R.id.ll_activity_groupon_parent)
    LinearLayout llActivityGrouponParent;

    @BindView(R.id.tv_activity_groupon_at)
    TextView tvActivityGrouponAt;
    @BindView(R.id.v_activity_groupon_at)
    View vActivityGrouponAt;
    @BindView(R.id.tv_activity_groupon_finish)
    TextView tvActivityGrouponFinish;
    @BindView(R.id.v_activity_groupon_finish)
    View vActivityGrouponFinish;
    @BindView(R.id.tv_activity_groupon_unfinished)
    TextView tvActivityGrouponUnfinished;
    @BindView(R.id.v_activity_groupon_unfinished)
    View vActivityGrouponUnfinished;
    private Intent intent;
    private static final int GROUP_AT = 1;
    private static final int GROUP_FINISH = 2;
    private static final int GROUP_UNFINISHED = 3;

    /**
     * 用于展示已解决的Fragment
     */
    private GrouponAtFragment grouponAtFragment;

    /**
     * 用于展示未解决的Fragment
     */
    private GrouponFinishFragment grouponFinishFragment;

    /**
     * 用于展示我要提问的Fragment
     */
    private GrouponUnfinishedFragment grouponUnfinishedFragment;


    /**
     * 用于对Fragment的管理
     */
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    private int setFragment;

    public static final String TAG = "GrouponActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupon);
        ButterKnife.bind(this);

        //添加一个FragmentTransaction的实例
        fragmentManager = getFragmentManager();
        // 开启一个Fragment事务
        transaction = fragmentManager.beginTransaction();

        setTabSelection(1);

    }

    @OnClick({R.id.iv_activity_groupon_return,
            R.id.iv_activity_groupon_close,
            R.id.ll_activity_groupon_at,
            R.id.ll_activity_groupon_finish,
            R.id.ll_activity_groupon_unfinished})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_activity_groupon_return:
                intent = new Intent(GrouponActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_activity_groupon_close:

                break;
            case R.id.ll_activity_groupon_at:
                setTabSelection(1);
                break;
            case R.id.ll_activity_groupon_finish:
                setTabSelection(2);
                break;
            case R.id.ll_activity_groupon_unfinished:
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
                tvActivityGrouponAt.setTextColor(0xffff0000);
                vActivityGrouponAt.setBackgroundColor(0xffff0000);
                Log.e(TAG, "setTabSelection--------------setTabSelection: " + "-----------0");
                if (grouponAtFragment == null) {
                    // 如果resolvedFragment为空，则创建一个并添加到界面上
                    grouponAtFragment = new GrouponAtFragment();
                    transaction.add(R.id.ll_activity_groupon_parent, grouponAtFragment);
                } else {
                    // 如果resolvedFragment不为空，则直接将它显示出来
                    transaction.show(grouponAtFragment);
                }
                setFragment = 100;
                break;
            case GROUP_FINISH:

                // 当点击了未解决图片时，改变控件的图片
                tvActivityGrouponFinish.setTextColor(0xffff0000);
                vActivityGrouponFinish.setBackgroundColor(0xffff0000);
                Log.e(TAG, "setTabSelection--------------setTabSelection: " + "-----------1");
                if (grouponFinishFragment == null) {
                    // 如果unsolvedFragment为空，则创建一个并添加到界面上
                    grouponFinishFragment = new GrouponFinishFragment();
                    transaction.add(R.id.ll_activity_groupon_parent, grouponFinishFragment);
                } else {
                    // 如果unsolvedFragment不为空，则直接将它显示出来
                    transaction.show(grouponFinishFragment);
                }
                setFragment = 200;
                break;
            case GROUP_UNFINISHED:
                // 当点击了我要提问时，改变控件的图片
                tvActivityGrouponUnfinished.setTextColor(0xffff0000);
                vActivityGrouponUnfinished.setBackgroundColor(0xffff0000);
                if (grouponUnfinishedFragment == null) {
                    // 如果iQuizFragment为空，则创建一个并添加到界面上
                    grouponUnfinishedFragment = new GrouponUnfinishedFragment();
                    transaction.add(R.id.ll_activity_groupon_parent, grouponUnfinishedFragment);
                } else {
                    // 如果iQuizFragment不为空，则直接将它显示出来
                    transaction.show(grouponUnfinishedFragment);
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
        tvActivityGrouponAt.setTextColor(0xff000000);
        vActivityGrouponAt.setBackgroundColor(0xdddddddd);
        tvActivityGrouponFinish.setTextColor(0xff000000);
        vActivityGrouponFinish.setBackgroundColor(0xdddddddd);
        tvActivityGrouponUnfinished.setTextColor(0xff000000);
        vActivityGrouponUnfinished.setBackgroundColor(0xdddddddd);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     * 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
//        Log.e(TAG, "hideFragments: " );
        if (grouponAtFragment != null) {
            transaction.hide(grouponAtFragment);
        }
        if (grouponFinishFragment != null) {
            transaction.hide(grouponFinishFragment);
        }
        if (grouponUnfinishedFragment != null) {
            transaction.hide(grouponUnfinishedFragment);
        }
    }
}
