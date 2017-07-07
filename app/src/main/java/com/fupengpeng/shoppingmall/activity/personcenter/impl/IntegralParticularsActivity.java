package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.fragment.IntegralParticularsAllFragment;
import com.fupengpeng.shoppingmall.fragment.IntegralParticularsExpendFragment;
import com.fupengpeng.shoppingmall.fragment.IntegralParticularsGainFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 积分详情界面
 */
public class IntegralParticularsActivity extends AppCompatActivity {

    /**
     * 返回积分中心
     */
    @BindView(R.id.iv_title_activity_left)
    ImageView ivTitleActivityLeft;
    /**
     * 全部积分的按钮
     */
    @BindView(R.id.tv_activity_integral_particulars_all)
    TextView tvActivityIntegralParticularsAll;
    @BindView(R.id.v_activity_integral_particulars_all)
    View vActivityIntegralParticularsAll;
    @BindView(R.id.ll_activity_integral_particulars_all)
    LinearLayout llActivityIntegralParticularsAll;
    /**
     * 获得积分的按钮
     */
    @BindView(R.id.tv_activity_integral_particulars_gain)
    TextView tvActivityIntegralParticularsGain;
    @BindView(R.id.v_activity_integral_particulars_gain)
    View vActivityIntegralParticularsGain;
    @BindView(R.id.ll_activity_integral_particulars_gain)
    LinearLayout llActivityIntegralParticularsGain;
    /**
     * 消耗积分的按钮
     */
    @BindView(R.id.tv_activity_integral_particulars_expend)
    TextView tvActivityIntegralParticularsExpend;
    @BindView(R.id.v_activity_integral_particulars_expend)
    View vActivityIntegralParticularsExpend;
    @BindView(R.id.ll_activity_integral_particulars_expend)
    LinearLayout llActivityIntegralParticularsExpend;
    /**
     * Fragment的容器
     */
    @BindView(R.id.ll_activity_integral_particulars_parent)
    LinearLayout llActivityIntegralParticularsParent;

    /**
     * 用于对Fragment的管理
     */
    FragmentManager fragmentManager;
    FragmentTransaction transaction;

    public static final String TAG = "IntegralParticularsActivity";


    @BindView(R.id.tv_title_activity_title)
    TextView tvTitleActivityTitle;


    private Intent intent;
    private static final int ALL = 1;
    private static final int GAIN = 2;
    public static final int EXPEND = 3;

    /**
     * 用于展示全部积分的Fragment
     */
    private IntegralParticularsAllFragment integralParticularsAllFragment;

    /**
     * 用于展示获得积分的Fragment
     */
    private IntegralParticularsGainFragment integralParticularsGainFragment;

    /**
     * 用于展示消耗积分的Fragment
     */
    private IntegralParticularsExpendFragment integralParticularsExpendFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integral_particulars);
        ButterKnife.bind(this);

        tvTitleActivityTitle.setText("积分任务");
        ivTitleActivityLeft.setImageResource(R.drawable.ic_left_return_black_24dp);

        setTabSelection(1);
    }

    @OnClick({R.id.iv_title_activity_left,
            R.id.ll_activity_integral_particulars_all,
            R.id.ll_activity_integral_particulars_gain,
            R.id.ll_activity_integral_particulars_expend})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_title_activity_left:
                intent = new Intent(IntegralParticularsActivity.this, IntegralPersonActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_integral_particulars_all:
                setTabSelection(1);
                break;
            case R.id.ll_activity_integral_particulars_gain:
                setTabSelection(2);
                break;
            case R.id.ll_activity_integral_particulars_expend:
                setTabSelection(3);
                break;
        }
    }


    /**
     * 根据传入的index参数来设置选中的Fragment。
     *
     * @param index 每个图片对应的下标。
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
            case ALL:
                // 当点击了已解决图片时，改变控件的图片
                tvActivityIntegralParticularsAll.setTextColor(0xffffffff);
                vActivityIntegralParticularsAll.setBackgroundColor(0xffff0000);
                if (integralParticularsAllFragment == null) {
                    // 如果integralParticularsAllFragment为空，则创建一个并添加到界面上
                    integralParticularsAllFragment = new IntegralParticularsAllFragment();
                    transaction.add(R.id.ll_activity_integral_particulars_parent, integralParticularsAllFragment);
                } else {
                    // 如果integralParticularsAllFragment不为空，则直接将它显示出来
                    transaction.show(integralParticularsAllFragment);
                }
                break;
            case GAIN:

                // 当点击了未解决图片时，改变控件的图片
                tvActivityIntegralParticularsGain.setTextColor(0xffffffff);
                vActivityIntegralParticularsGain.setBackgroundColor(0xffff0000);
                if (integralParticularsGainFragment == null) {
                    // 如果integralParticularsGainFragment为空，则创建一个并添加到界面上
                    integralParticularsGainFragment = new IntegralParticularsGainFragment();
                    transaction.add(R.id.ll_activity_integral_particulars_parent, integralParticularsGainFragment);
                } else {
                    // 如果integralParticularsGainFragment不为空，则直接将它显示出来
                    transaction.show(integralParticularsGainFragment);
                }
                break;

            case EXPEND:

                // 当点击了未解决图片时，改变控件的图片
                tvActivityIntegralParticularsExpend.setTextColor(0xffffffff);
                vActivityIntegralParticularsExpend.setBackgroundColor(0xffff0000);
                if (integralParticularsExpendFragment == null) {
                    // 如果integralParticularsExpendFragment为空，则创建一个并添加到界面上
                    integralParticularsExpendFragment = new IntegralParticularsExpendFragment();
                    transaction.add(R.id.ll_activity_integral_particulars_parent, integralParticularsExpendFragment);
                } else {
                    // 如果integralParticularsExpendFragment不为空，则直接将它显示出来
                    transaction.show(integralParticularsExpendFragment);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。（字体颜色和view背景颜色）
     */
    private void clearSelection() {
        tvActivityIntegralParticularsAll.setTextColor(0xffdddddd);
        vActivityIntegralParticularsAll.setBackgroundColor(0xdddddddd);
        tvActivityIntegralParticularsGain.setTextColor(0xffdddddd);
        vActivityIntegralParticularsGain.setBackgroundColor(0xdddddddd);
        tvActivityIntegralParticularsExpend.setTextColor(0xffdddddd);
        vActivityIntegralParticularsExpend.setBackgroundColor(0xdddddddd);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     * 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (integralParticularsAllFragment != null) {
            transaction.hide(integralParticularsAllFragment);
        }
        if (integralParticularsGainFragment != null) {
            transaction.hide(integralParticularsGainFragment);
        }
        if (integralParticularsExpendFragment != null) {
            transaction.hide(integralParticularsExpendFragment);
        }
    }


}
