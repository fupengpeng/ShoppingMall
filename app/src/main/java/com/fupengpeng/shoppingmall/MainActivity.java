package com.fupengpeng.shoppingmall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fupengpeng.shoppingmall.entity.eventbusbean.ShoppingCartFragmentEvent;
import com.fupengpeng.shoppingmall.fragment.ClassifyFragment;
import com.fupengpeng.shoppingmall.fragment.HomeFragment;
import com.fupengpeng.shoppingmall.fragment.PersonCenterFragment;
import com.fupengpeng.shoppingmall.fragment.ShareFragment;
import com.fupengpeng.shoppingmall.fragment.ShoppingCartFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.iv_title_activity_left)
    ImageView ivTitleActivityLeft;

    @BindView(R.id.tv_title_activity_left)
    TextView tvTitleActivityLeft;

    @BindView(R.id.tv_title_activity_title)
    TextView tvTitleActivityTitle;

    @BindView(R.id.tv_title_activity_right)
    TextView tvTitleActivityRight;

    @BindView(R.id.iv_title_activity_right)
    ImageView ivTitleActivityRight;


    @BindView(R.id.ll_activity_main_parent)
    LinearLayout llActivityMainParent;

    @BindView(R.id.iv_activity_main_home)
    ImageView ivActivityMainHome;
    @BindView(R.id.tv_activity_main_home)
    TextView tvActivityMainHome;
    @BindView(R.id.ll_activity_main_home)
    LinearLayout llActivityMainHome;

    @BindView(R.id.iv_activity_main_classify)
    ImageView ivActivityMainClassify;
    @BindView(R.id.tv_activity_main_classify)
    TextView tvActivityMainClassify;
    @BindView(R.id.ll_activity_main_classify)
    LinearLayout llActivityMainClassify;

    @BindView(R.id.iv_activity_main_shopping_cart)
    ImageView ivActivityMainShoppingCart;
    @BindView(R.id.tv_activity_main_shopping_cart)
    TextView tvActivityMainShoppingCart;
    @BindView(R.id.ll_activity_main_shopping_cart)
    LinearLayout llActivityMainShoppingCart;

    @BindView(R.id.iv_activity_main_share)
    ImageView ivActivityMainShare;
    @BindView(R.id.tv_activity_main_share)
    TextView tvActivityMainShare;
    @BindView(R.id.ll_activity_main_share)
    LinearLayout llActivityMainShare;

    @BindView(R.id.iv_activity_main_person_center)
    ImageView ivActivityMainPersonCenter;
    @BindView(R.id.tv_activity_main_person_center)
    TextView tvActivityMainPersonCenter;
    @BindView(R.id.ll_activity_main_person_center)
    LinearLayout llActivityMainPersonCenter;

    @BindView(R.id.tv_title_activity_right_edit)
    TextView tvTitleActivityRightEdit;


    /**
     * 主界面Fragment
     */
    private HomeFragment homeFragment;
    /**
     * 分类Fragment
     */
    private ClassifyFragment classifyFragment;
    /**
     * 分享Fragment
     */
    private ShareFragment shareFragment;
    /**
     * 购物车Fragment
     */
    private ShoppingCartFragment shoppingCartFragment;
    /**
     * 个人中心Fragment
     */
    private PersonCenterFragment personCenterFragment;

    private Intent intent;

    /**
     * 设置展示Fragment的参数
     */
    private int setFragment = 100;

    /**
     * 主界面
     */
    private static final int HOME = 1;
    /**
     * 分类
     */
    private static final int CLASSIFY = 2;
    /**
     * 分享
     */
    private static final int SHARE = 3;
    /**
     * 购物车
     */
    private static final int SHOPPING_CART = 4;
    /**
     * 个人中心
     */
    private static final int PERSON_CENTER = 5;


    /**
     * 用于对Fragment的管理
     */
    FragmentManager fragmentManager;
    FragmentTransaction transaction;

    public static final String TAG = "MainActivity";
    private Bundle bundle;

    /**
     * 用于购物车编辑按钮的处理事件
     */
    private boolean isBatchModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        questionList();

        EventBus.getDefault().register(this);//订阅


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//解除订阅

    }

    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void onDataSynEvent(ShoppingCartFragmentEvent shoppingCartFragmentEvent) {
        isBatchModel = shoppingCartFragmentEvent.isBatchModel();
        Log.e(TAG, "onDataSynEvent: ---------------------------------" + isBatchModel);


    }


    @OnClick({R.id.ll_activity_main_home,
            R.id.ll_activity_main_classify,
            R.id.ll_activity_main_shopping_cart,
            R.id.ll_activity_main_share,
            R.id.ll_activity_main_person_center,
            R.id.iv_title_activity_right,
            R.id.tv_title_activity_right_edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_activity_main_home:
                setTabSelection(1);
                break;
            case R.id.ll_activity_main_classify:
                setTabSelection(2);
                break;
            case R.id.ll_activity_main_share:
                setTabSelection(3);
                break;
            case R.id.ll_activity_main_shopping_cart:
                setTabSelection(4);
                break;
            case R.id.ll_activity_main_person_center:
                setTabSelection(5);
                break;
            case R.id.iv_title_activity_right:
                showShare();
                break;
            case R.id.tv_title_activity_right_edit:
                Log.e(TAG, "onClick: " + "----0008----");
                isBatchModel = !isBatchModel;
                if (isBatchModel) {
                    tvTitleActivityRightEdit.setText(getResources().getString(R.string.menu_enter));
                } else {
                    tvTitleActivityRightEdit.setText(getResources().getString(R.string.menu_edit));
                }

                ShoppingCartFragmentEvent shoppingCartFragmentEvent =
                        new ShoppingCartFragmentEvent(
                                isBatchModel);

                EventBus.getDefault().post(shoppingCartFragmentEvent);
//                EventBus.getDefault().postSticky(new ShoppingCartFragmentEvent());

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
        fragmentManager = getSupportFragmentManager();
        // 开启一个Fragment事务
        transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);


        if (index == SHOPPING_CART) {
            tvTitleActivityRight.setVisibility(View.GONE);
            tvTitleActivityRightEdit.setVisibility(View.VISIBLE);
            tvTitleActivityRightEdit.setText(getResources().getString(R.string.menu_edit));

        } else {
            tvTitleActivityRightEdit.setText(getResources().getString(R.string.menu_enter));
            tvTitleActivityRight.setVisibility(View.VISIBLE);
            tvTitleActivityRightEdit.setVisibility(View.GONE);
        }

        switch (index) {

            /**
             * 首页
             */
            case HOME:
                tvActivityMainHome.setTextColor(0xffff0000);
                tvTitleActivityTitle.setText("首页");
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.ll_activity_main_parent, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                break;
            /**
             * 分类界面
             */
            case CLASSIFY:
                tvActivityMainClassify.setTextColor(0xffff0000);
                tvTitleActivityTitle.setText("分类");
                if (classifyFragment == null) {
                    classifyFragment = new ClassifyFragment();
                    transaction.add(R.id.ll_activity_main_parent, classifyFragment);
                } else {
                    transaction.show(classifyFragment);
                }
                break;
            /**
             * 分享界面
             */
            case SHARE:
                tvTitleActivityTitle.setText("分享");
                tvActivityMainShare.setTextColor(0xffff0000);
                if (shareFragment == null) {
                    shareFragment = new ShareFragment();
                    transaction.add(R.id.ll_activity_main_parent, shareFragment);
                } else {
                    transaction.show(shareFragment);
                }
                break;
            /**
             * 购物车界面
             */
            case SHOPPING_CART:
                tvTitleActivityTitle.setText("购物车");
                tvActivityMainShoppingCart.setTextColor(0xffff0000);
                if (shoppingCartFragment == null) {
                    shoppingCartFragment = new ShoppingCartFragment();
                    transaction.add(R.id.ll_activity_main_parent, shoppingCartFragment);
                } else {
                    transaction.show(shoppingCartFragment);
                }
                break;
            /**
             * 个人中心界面
             */
            case PERSON_CENTER:
                tvTitleActivityTitle.setText("个人中心");
                tvActivityMainPersonCenter.setTextColor(0xffff0000);
                if (personCenterFragment == null) {
                    personCenterFragment = new PersonCenterFragment();
                    transaction.add(R.id.ll_activity_main_parent, personCenterFragment);
                } else {
                    transaction.show(personCenterFragment);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。（字体颜色和view背景颜色）
     */
    private void clearSelection() {
        tvActivityMainHome.setTextColor(0xff000000);

        tvActivityMainClassify.setTextColor(0xff000000);

        tvActivityMainShare.setTextColor(0xff000000);

        tvActivityMainShoppingCart.setTextColor(0xff000000);

        tvActivityMainPersonCenter.setTextColor(0xff000000);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     * 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
//        Log.e(TAG, "hideFragments: " );
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (classifyFragment != null) {
            transaction.hide(classifyFragment);
        }
        if (shareFragment != null) {
            transaction.hide(shareFragment);
        }
        if (shoppingCartFragment != null) {
            transaction.hide(shoppingCartFragment);
        }
        if (personCenterFragment != null) {
            transaction.hide(personCenterFragment);
        }
    }

    /**
     * 初始化展示和点击筛选之后的fragment展示
     */
    private void questionList() {
        Intent intent = this.getIntent();
        setFragment = intent.getIntExtra("setFragment", 0);
        Log.e(TAG, "questionList: --------" + setFragment);
        switch (setFragment) {
            /**
             * 首页界面
             */
            case 100:
                setTabSelection(HOME);
                break;
            /**
             * 分类界面
             */
            case 200:
                setTabSelection(CLASSIFY);
                break;
            /**
             * 分享界面
             */
            case 300:
                setTabSelection(SHARE);
                break;
            /**
             * 购物车界面
             */
            case 400:
                setTabSelection(SHOPPING_CART);
                break;
            /**
             * 个人中心界面
             */
            case 500:
                setTabSelection(PERSON_CENTER);
                break;
            /**
             * 默认首页界面
             */
            default:
                setTabSelection(HOME);
                break;
        }
    }

    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("标题");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("http://sharesdk.cn");
// text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(this);
    }
}
