package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TabHost;
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
     * 自定义的MyScrollView
     */
    private FloatingWindowScrollView myScrollView;
    /**
     * 在MyScrollView里面的购买布局
     */
    private LinearLayout mBuyLayout;
    /**
     * 位于顶部的购买布局
     */
    private LinearLayout mTopBuyLayout;
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

        myScrollView = (FloatingWindowScrollView) findViewById(R.id.fwsv_activity_commodity_particulars);
        mBuyLayout = (LinearLayout) findViewById(R.id.ll_activity_commodity_particulars_tabhost);
        mTopBuyLayout = (LinearLayout) findViewById(R.id.ll_activity_commodity_particulars_tabhost_top);

        myScrollView.setOnScrollListener(this);

        //当布局的状态或者控件的可见性发生改变回调的接口
        findViewById(R.id.ll_activity_commodity_particulars_parent).getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {

                    @Override
                    public void onGlobalLayout() {
                        //这一步很重要，使得上面的购买布局和下面的购买布局重合
                        onScroll(myScrollView.getScrollY());

                    }
                });
    }


    @Override
    public void onScroll(int scrollY) {
        int mBuyLayout2ParentTop = Math.max(scrollY, mBuyLayout.getTop());
        mTopBuyLayout.layout(0, mBuyLayout2ParentTop, mTopBuyLayout.getWidth(), mBuyLayout2ParentTop + mTopBuyLayout.getHeight());
    }

    private void tabHost() {
        tabHost = getTabHost();

        page1 = tabHost.newTabSpec("tab1")
                .setIndicator("叫兽")
                .setContent(R.id.isanimal);
        tabHost.addTab(page1);

        page2 = tabHost.newTabSpec("tab2")
                .setIndicator("老湿")
                .setContent(R.id.alwayswet);
        tabHost.addTab(page2);

        page3 = tabHost.newTabSpec("tab3")
                .setIndicator("哪吒")
                .setContent(R.id.nezha);
        tabHost.addTab(page3);

    }

    @OnClick({R.id.tv_activity_commodity_particulars_text01, R.id.tv_activity_commodity_particulars_text02, R.id.tv_activity_commodity_particulars_text03})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_activity_commodity_particulars_text01:

                page1 = tabHost.newTabSpec("tab1")
                        .setIndicator("叫兽")
                        .setContent(R.id.isanimal);
                tabHost.addTab(page1);

                break;
            case R.id.tv_activity_commodity_particulars_text02:


                page2 = tabHost.newTabSpec("tab2")
                        .setIndicator("老湿")
                        .setContent(R.id.alwayswet);
                tabHost.addTab(page2);
                break;
            case R.id.tv_activity_commodity_particulars_text03:


                page3 = tabHost.newTabSpec("tab3")
                        .setIndicator("哪吒")
                        .setContent(R.id.nezha);
                tabHost.addTab(page3);
                break;
        }
    }
}
