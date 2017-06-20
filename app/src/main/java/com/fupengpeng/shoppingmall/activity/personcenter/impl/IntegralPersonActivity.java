package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.fupengpeng.shoppingmall.MainActivity;
import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.activity.BaseActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.view.IIntegralPersonView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 积分中心
 */
public class IntegralPersonActivity extends AppCompatActivity implements IIntegralPersonView {

    /**
     * 返回个人中心
     */
    @BindView(R.id.iv_activity_integral_person_return)
    ImageView ivActivityIntegralPersonReturn;
    /**
     * 用户图像
     */
    @BindView(R.id.iv_activity_integral_person_pic)
    ImageView ivActivityIntegralPersonPic;
    /**
     * 普通会员
     */
    @BindView(R.id.btn_activity_integral_person_member_center)
    Button btnActivityIntegralPersonMemberCenter;
    /**
     * 用户名称
     */
    @BindView(R.id.tv_activity_integral_person_username)
    TextView tvActivityIntegralPersonUsername;
    /**
     * 可用积分
     */
    @BindView(R.id.tv_activity_integral_person_usable_integral)
    TextView tvActivityIntegralPersonUsableIntegral;
    /**
     * 已用积分
     */
    @BindView(R.id.tv_activity_integral_person_already_use)
    TextView tvActivityIntegralPersonAlreadyUse;
    /**
     * 商城内获得积分
     */
    @BindView(R.id.tv_activity_integral_person_gain_integral)
    TextView tvActivityIntegralPersonGainIntegral;
    /**
     * 小伙伴中的排名
     */
    @BindView(R.id.tv_activity_integral_person_ranking)
    TextView tvActivityIntegralPersonRanking;
    /**
     * 积分榜
     */
    @BindView(R.id.ll_activity_integral_person_integral_sequence)
    LinearLayout llActivityIntegralPersonIntegralSequence;
    /**
     * 积分商城
     */
    @BindView(R.id.ll_activity_integral_person_integral_shopping_mall)
    LinearLayout llActivityIntegralPersonIntegralShoppingMall;
    /**
     * 基础任务
     */
    @BindView(R.id.ll_activity_integral_person_integral_task)
    LinearLayout llActivityIntegralPersonBasisTask;
    /**
     * 积分用途
     */
    @BindView(R.id.ll_activity_integral_person_integral_use)
    LinearLayout llActivityIntegralPersonIntegralUse;
    /**
     * 积分明细
     */
    @BindView(R.id.ll_activity_integral_person_integral_particulars)
    LinearLayout llActivityIntegralPersonIntegralParticulars;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integral_person);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_activity_integral_person_return,
            R.id.btn_activity_integral_person_member_center,
            R.id.ll_activity_integral_person_integral_sequence,
            R.id.ll_activity_integral_person_integral_shopping_mall,
            R.id.ll_activity_integral_person_integral_task,
            R.id.ll_activity_integral_person_integral_use,
            R.id.ll_activity_integral_person_integral_particulars})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            /**
             * 返回个人中心
             */
            case R.id.iv_activity_integral_person_return:
                intent = new Intent(IntegralPersonActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            /**
             * 跳转至会员中心
             */
            case R.id.btn_activity_integral_person_member_center:
                intent = new Intent(IntegralPersonActivity.this,MemberCenterActivity.class);
                startActivity(intent);
                break;
            /**
             * 跳转至积分榜界面
             */
            case R.id.ll_activity_integral_person_integral_sequence:
                intent = new Intent(IntegralPersonActivity.this,IntegralSequenceActivity.class);
                startActivity(intent);
                break;
            /**
             * 跳转至积分商城界面
             */
            case R.id.ll_activity_integral_person_integral_shopping_mall:
                intent = new Intent(IntegralPersonActivity.this,IntegralShoppingMallActivity.class);
                startActivity(intent);
                break;
            /**
             * 跳转至基础任务界面
             */
            case R.id.ll_activity_integral_person_integral_task:
                intent = new Intent(IntegralPersonActivity.this,IntegralTaskActivity.class);
                startActivity(intent);
                break;
            /**
             * 跳转至积分用途介绍界面
             */
            case R.id.ll_activity_integral_person_integral_use:
                intent = new Intent(IntegralPersonActivity.this,IntegralUseActivity.class);
                startActivity(intent);
                break;
            /**
             * 跳转至积分明细界面
             */
            case R.id.ll_activity_integral_person_integral_particulars:
                intent = new Intent(IntegralPersonActivity.this,IntegralParticularsActivity.class);
                startActivity(intent);
                break;
        }
    }
}
