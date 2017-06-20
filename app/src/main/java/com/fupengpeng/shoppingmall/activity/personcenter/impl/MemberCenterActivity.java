package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.activity.BaseActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.view.IMemgerCenterView;
import com.fupengpeng.shoppingmall.fragment.MemberCenterGradeListFragment;
import com.fupengpeng.shoppingmall.fragment.MemberCenterStrategyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 会员中心界面
 */
public class MemberCenterActivity extends AppCompatActivity implements IMemgerCenterView,View.OnClickListener{

    /**
     * 会员成长值疑问？？？
     */
    @BindView(R.id.iv_activity_member_center_query)
    ImageView ivActivityMemberCenterQuery;
    /**
     * 会员等级列表文字
     */
    @BindView(R.id.tv_activity_member_center_grade_list)
    TextView tvActivityMemberCenterGradeList;
    @BindView(R.id.v_activity_member_center_grade_list)
    View vActivityMemberCenterGradeList;
    /**
     * 会员等级列表的切换
     */
    @BindView(R.id.ll_activity_member_center_grade_list)
    LinearLayout llActivityMemberCenterGradeList;

    /**
     * 会员攻略
     */
    @BindView(R.id.tv_activity_member_center_strategy)
    TextView tvActivityMemberCenterStrategy;
    @BindView(R.id.v_activity_member_center_strategy)
    View vActivityMemberCenterStrategy;
    /**
     * 会员攻略列表切换
     */
    @BindView(R.id.ll_activity_member_center_strategy)
    LinearLayout llActivityMemberCenterStrategy;

    /**
     * 会员等级列表与会员攻略的Fragment容器
     */
    @BindView(R.id.ll_activity_member_center_parent)
    LinearLayout llActivityMemberCenterParent;
    /**
     * dialog 关闭按钮
     */
    ImageView ivItemActivityMemberCenterQuery;
    private Intent intent;
    private static final int GRADE_LIST = 1;
    private static final int STRATEGY = 2;

    /**
     * 用于展示会员等级列表的Fragment
     */
    private MemberCenterGradeListFragment memberCenterGradeListFragment;

    /**
     * 用于展示会员攻略的Fragment
     */
    private MemberCenterStrategyFragment memberCenterStrategyFragment;

    /**
     * 用于对Fragment的管理
     */
    FragmentManager fragmentManager;
    FragmentTransaction transaction;

    public static final String TAG = "MemberCenterActivity";
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_center);
        ButterKnife.bind(this);

        //添加一个FragmentTransaction的实例
        fragmentManager = getFragmentManager();
        // 开启一个Fragment事务
        transaction = fragmentManager.beginTransaction();

        setTabSelection(1);

    }

    @OnClick({R.id.iv_activity_member_center_query,
            R.id.ll_activity_member_center_grade_list,
            R.id.ll_activity_member_center_strategy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_activity_member_center_query:
                AlertDialog.Builder builder = new AlertDialog.Builder(MemberCenterActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View viewDialog = inflater.inflate(R.layout.item_activity_member_center_query, null);
                ivItemActivityMemberCenterQuery = (ImageView) viewDialog.findViewById(R.id.iv_item_activity_member_center_query);
                ivItemActivityMemberCenterQuery.setOnClickListener(this);
//                Window window = dialog.getWindow();
//                window.setGravity(Gravity.CENTER); //可设置dialog的位置
//                window.setLayout(240,400);


                builder.setView(viewDialog);//添加自定义View
                builder.create();
                dialog = builder.show();
                break;
            case R.id.ll_activity_member_center_grade_list:
                setTabSelection(1);
                break;
            case R.id.ll_activity_member_center_strategy:
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
            case GRADE_LIST:
                // 当点击了已解决图片时，改变控件的图片
                tvActivityMemberCenterGradeList.setTextColor(0xffffffff);
                vActivityMemberCenterGradeList.setBackgroundColor(0xffff0000);
                if (memberCenterGradeListFragment == null) {
                    // 如果memberCenterGradeListFragment为空，则创建一个并添加到界面上
                    memberCenterGradeListFragment = new MemberCenterGradeListFragment();
                    transaction.add(R.id.ll_activity_member_center_parent, memberCenterGradeListFragment);
                } else {
                    // 如果memberCenterGradeListFragment不为空，则直接将它显示出来
                    transaction.show(memberCenterGradeListFragment);
                }
                break;
            case STRATEGY:

                // 当点击了未解决图片时，改变控件的图片
                tvActivityMemberCenterStrategy.setTextColor(0xffffffff);
                vActivityMemberCenterStrategy.setBackgroundColor(0xffff0000);
                if (memberCenterStrategyFragment == null) {
                    // 如果memberCenterStrategyFragment为空，则创建一个并添加到界面上
                    memberCenterStrategyFragment = new MemberCenterStrategyFragment();
                    transaction.add(R.id.ll_activity_member_center_parent, memberCenterStrategyFragment);
                } else {
                    // 如果memberCenterStrategyFragment不为空，则直接将它显示出来
                    transaction.show(memberCenterStrategyFragment);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。（字体颜色和view背景颜色）
     */
    private void clearSelection() {
        tvActivityMemberCenterGradeList.setTextColor(0xffdddddd);
        vActivityMemberCenterGradeList.setBackgroundColor(0xdddddddd);
        tvActivityMemberCenterStrategy.setTextColor(0xffdddddd);
        vActivityMemberCenterStrategy.setBackgroundColor(0xdddddddd);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     * 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (memberCenterGradeListFragment != null) {
            transaction.hide(memberCenterGradeListFragment);
        }
        if (memberCenterStrategyFragment != null) {
            transaction.hide(memberCenterStrategyFragment);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_item_activity_member_center_query:
                dialog.dismiss();
                break;
        }
    }
}
