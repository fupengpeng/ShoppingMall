package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.customerview.FloatingWindowScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 商品详情界面
 */
public class CommodityParticularsActivity extends TabActivity
        implements FloatingWindowScrollView.OnScrollListener {

    @BindView(R.id.tv_activity_commodity_particulars_text01)
    TextView tvActivityCommodityParticularsText01;
    @BindView(R.id.tv_activity_commodity_particulars_text02)
    TextView tvActivityCommodityParticularsText02;
    @BindView(R.id.tv_activity_commodity_particulars_text03)
    TextView tvActivityCommodityParticularsText03;

    /**
     * 返回上一界面
     */
    @BindView(R.id.iv_title_activity_left)
    ImageView ivTitleActivityLeft;

    @BindView(R.id.tv_title_activity_title)
    TextView tvTitleActivityTitle;
    /**
     * 返回上一界面
     */
    @BindView(R.id.iv_title_activity_right)
    ImageView ivTitleActivityRight;
    @BindView(android.R.id.tabs)
    TabWidget tabs;
    @BindView(R.id.alwayswet)
    LinearLayout alwayswet;
    @BindView(R.id.isanimal)
    LinearLayout isanimal;
    @BindView(R.id.nezha)
    LinearLayout nezha;
    @BindView(android.R.id.tabcontent)
    FrameLayout tabcontent;
    @BindView(android.R.id.tabhost)
    TabHost tabhost;
    /**
     * 在ScrollView里面的购买布局
     */
    @BindView(R.id.ll_activity_commodity_particulars_tabhost)
    LinearLayout llActivityCommodityParticularsTabhost;
    /**
     * 位于顶部的购买布局
     */
    @BindView(R.id.ll_activity_commodity_particulars_tabhost_top)
    LinearLayout llActivityCommodityParticularsTabhostTop;
    /**
     * 自定义的MyScrollView
     */
    @BindView(R.id.fwsv_activity_commodity_particulars)
    FloatingWindowScrollView fwsvActivityCommodityParticulars;
    @BindView(R.id.ll_activity_commodity_particulars_parent)
    LinearLayout llActivityCommodityParticularsParent;


    private TabHost tabHost;
    private TabHost.TabSpec page1;
    private TabHost.TabSpec page2;
    private TabHost.TabSpec page3;


    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commodity_particulars);
        ButterKnife.bind(this);

        tabHost();
        tvTitleActivityTitle.setText("商品详情");


        fwsvActivityCommodityParticulars.setOnScrollListener(this);

        //当布局的状态或者控件的可见性发生改变回调的接口
        llActivityCommodityParticularsParent.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {

                    @Override
                    public void onGlobalLayout() {
                        //这一步很重要，使得上面的购买布局和下面的购买布局重合
                        onScroll(fwsvActivityCommodityParticulars.getScrollY());

                    }
                });
    }


    @Override
    public void onScroll(int scrollY) {
        int mBuyLayout2ParentTop = Math.max(scrollY, llActivityCommodityParticularsTabhost.getTop());
        llActivityCommodityParticularsTabhostTop.layout(0, mBuyLayout2ParentTop, llActivityCommodityParticularsTabhostTop.getWidth(), mBuyLayout2ParentTop + llActivityCommodityParticularsTabhostTop.getHeight());
    }

    private void tabHost() {
        tabHost = getTabHost();

        page1 = tabHost.newTabSpec("tab1")
                .setIndicator("商品详情")
                .setContent(R.id.isanimal);
        tabHost.addTab(page1);

        page2 = tabHost.newTabSpec("tab2")
                .setIndicator("参数")
                .setContent(R.id.alwayswet);
        tabHost.addTab(page2);

        page3 = tabHost.newTabSpec("tab3")
                .setIndicator("评价")
                .setContent(R.id.nezha);
        tabHost.addTab(page3);

    }

    @OnClick({R.id.tv_activity_commodity_particulars_text01,
            R.id.tv_activity_commodity_particulars_text02,
            R.id.tv_activity_commodity_particulars_text03})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_activity_commodity_particulars_text01:


                break;
            case R.id.tv_activity_commodity_particulars_text02:


                break;
            case R.id.tv_activity_commodity_particulars_text03:


                break;
        }
    }
}
