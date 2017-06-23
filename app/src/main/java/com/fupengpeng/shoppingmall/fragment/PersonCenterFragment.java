package com.fupengpeng.shoppingmall.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fupengpeng.shoppingmall.MainActivity;
import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.activity.personcenter.impl.BargainActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.impl.DiscountCouponActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.impl.GrouponActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.impl.InformationEditActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.impl.IntegralPersonActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.impl.IntegralShoppingMallActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.impl.MemberCenterActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.impl.OrderCenterActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.impl.SetLockActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.impl.ShoppingCartActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.impl.UnlockActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.impl.WinningActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.impl.WithdrawDepositActivity;
import com.fupengpeng.shoppingmall.util.PreferenceUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 个人中心Fragment
 */
public class PersonCenterFragment extends Fragment {


    private static final String TAG = "PersonCenterFragment";
    /**
     * 上下文
     */
    protected Context context = null;
    /**
     * 依附的MainActivity
     */
    protected Activity mainActivity = null;
    /**
     * 用户头像
     */
    @BindView(R.id.iv_fragment_person_information_pic)
    ImageView ivFragmentPersonInformationPic;
    /**
     * 未登录时的登录注册
     */
    @BindView(R.id.tv_fragment_person_login_register)
    TextView tvFragmentPersonLoginRegister;
    /**
     * 登录后的用户名
     */
    @BindView(R.id.tv_fragment_person_information_username)
    TextView tvFragmentPersonInformationUsername;
    /**
     *用户手机号
     */
    @BindView(R.id.tv_fragment_person_information_phone_number)
    TextView tvFragmentPersonInformationPhoneNumber;
    /**
     *收货地址
     */
    @BindView(R.id.ll_fragment_person_information_address)
    LinearLayout llFragmentPersonInformationAddress;
    /**
     * 用户信息管理
     */
    @BindView(R.id.ll_fragment_person_information_person)
    LinearLayout llFragmentPersonInformationPerson;
    /**
     *会员中心
     */
    @BindView(R.id.btn_fragment_person_member_center)
    Button btnFragmentPersonMemberCenter;
    /**
     *会员成长值
     */
    @BindView(R.id.tv_fragment_person_growth_value)
    TextView tvFragmentPersonGrowthValue;
    /**
     *积分值
     */
    @BindView(R.id.tv_fragment_person_integral_center)
    TextView tvFragmentPersonIntegralCenter;
    /**
     *积分中心
     */
    @BindView(R.id.ll_fragment_person_integral_center)
    LinearLayout llFragmentPersonIntegralCenter;
    /**
     *用户余额
     */
    @BindView(R.id.tv_fragment_person_balance)
    TextView tvFragmentPersonBalance;
    /**
     *余额条目
     */
    @BindView(R.id.ll_fragment_person_balance)
    LinearLayout llFragmentPersonBalance;
    /**
     *提现
     */
    @BindView(R.id.btn_fragment_person_with_draw_deposit)
    Button btnFragmentPersonWithDrawDeposit;

    /**
     *全部订单
     */
    @BindView(R.id.ll_fragment_person_order_center_all)
    LinearLayout llFragmentPersonOrderCenterAll;
    /**
     *待付款
     */
    @BindView(R.id.ll_fragment_person_wait_payment)
    LinearLayout llFragmentPersonWaitPayment;
    /**
     *待发货
     */
    @BindView(R.id.ll_fragment_person_wait_shipments)
    LinearLayout llFragmentPersonWaitShipments;
    /**
     *待收货
     */
    @BindView(R.id.ll_fragment_person_wait_receiving)
    LinearLayout llFragmentPersonWaitReceiving;
    /**
     *提货
     */
    @BindView(R.id.ll_fragment_person_wait_picking)
    LinearLayout llFragmentPersonWaitPicking;
    /**
     *售后
     */
    @BindView(R.id.ll_fragment_person_refund_after_sales)
    LinearLayout llFragmentPersonRefundAfterSales;
    /**
     *购物车
     */
    @BindView(R.id.ll_fragment_person_shopping_cart)
    LinearLayout llFragmentPersonShoppingCart;
    /**
     *优惠券
     */
    @BindView(R.id.ll_fragment_person_discount_coupon)
    LinearLayout llFragmentPersonDiscountCoupon;
    /**
     *砍价
     */
    @BindView(R.id.ll_fragment_person_bargain)
    LinearLayout llFragmentPersonBargain;
    /**
     *团购
     */
    @BindView(R.id.ll_fragment_person_groupon)
    LinearLayout llFragmentPersonGroupon;
    /**
     *中奖记录
     */
    @BindView(R.id.ll_fragment_person_winning)
    LinearLayout llFragmentPersonWinning;
    /**
     *积分商城
     */
    @BindView(R.id.ll_fragment_person_integral_shopping)
    LinearLayout llFragmentPersonIntegralShopping;

    Unbinder unbinder;
    private View personCenterFragmentView;

    private Intent intent;
    private int setFragment;
    private Bundle bundle;

    /**
     * 获取Fragment依赖的MainActivity
     *
     * @return
     */
    public Activity getMainActivity() {
        mainActivity = (MainActivity) getActivity();
        context = mainActivity;
        return mainActivity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        getActivity();
        personCenterFragmentView = inflater.inflate(R.layout.fragment_person_center, container, false);
        unbinder = ButterKnife.bind(this, personCenterFragmentView);
        return personCenterFragmentView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_fragment_person_information_pic,
            R.id.tv_fragment_person_information_username,
            R.id.tv_fragment_person_information_phone_number,
            R.id.ll_fragment_person_information_address,
            R.id.ll_fragment_person_information_person,
            R.id.btn_fragment_person_member_center,
            R.id.ll_fragment_person_integral_center,
            R.id.btn_fragment_person_with_draw_deposit,
            R.id.ll_fragment_person_order_center_all,
            R.id.ll_fragment_person_wait_payment,
            R.id.ll_fragment_person_wait_shipments,
            R.id.ll_fragment_person_wait_receiving,
            R.id.ll_fragment_person_wait_picking,
            R.id.ll_fragment_person_refund_after_sales,
            R.id.ll_fragment_person_shopping_cart,
            R.id.ll_fragment_person_discount_coupon,
            R.id.ll_fragment_person_bargain,
            R.id.ll_fragment_person_groupon,
            R.id.ll_fragment_person_winning,
            R.id.ll_fragment_person_integral_shopping})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_fragment_person_information_pic:
                Log.e(TAG, "onViewClicked: "+"跳转至用户资料修改界面" );
                intent = new Intent(getMainActivity(),InformationEditActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_fragment_person_information_username:
                Log.e(TAG, "onViewClicked: "+"跳转至用户资料修改界面" );
                intent = new Intent(getMainActivity(),InformationEditActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_fragment_person_information_phone_number:
                Log.e(TAG, "onViewClicked: "+"跳转至用户资料修改界面" );
                intent = new Intent(getMainActivity(),InformationEditActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_fragment_person_information_address:
                Log.e(TAG, "onViewClicked: "+"跳转至用户资料修改界面" );
                intent = new Intent(getMainActivity(),InformationEditActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_fragment_person_information_person:
                break;
            case R.id.btn_fragment_person_member_center:
                Log.e(TAG, "onViewClicked: "+"跳转至会员中心界面" );
                intent = new Intent(getMainActivity(),MemberCenterActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_fragment_person_integral_center:
                Log.e(TAG, "onViewClicked: "+"跳转至积分中心界面" );
                intent = new Intent(getMainActivity(),IntegralPersonActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_fragment_person_with_draw_deposit:
                Log.e(TAG, "onViewClicked: "+"跳转至提现余额界面" );

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String passwordStr = PreferenceUtil.getGesturePassword(getMainActivity());

                        if (passwordStr == "") {
                            Log.e(TAG, "run: "+"true" );
                            intent = new Intent(getMainActivity(), SetLockActivity.class);
                        } else {
                            Log.e(TAG, "run: "+"false" );
                            intent = new Intent(getMainActivity(), UnlockActivity.class);
                        }
                        startActivity(intent);
                        getMainActivity().finish();
                    }
                }, 2000);




//                intent = new Intent(getMainActivity(),WithdrawDepositActivity.class);
//                startActivity(intent);
                break;
            case R.id.ll_fragment_person_order_center_all:
                Log.e(TAG, "onViewClicked: "+"跳转至 全部订单" );
                setFragment = 100;
                intent = new Intent(getMainActivity(),OrderCenterActivity.class);
                bundle = new Bundle();
                //将网络请求获取到的分类对象传递给ScreenActivity用于展示数据
                bundle.putInt("setFragment", setFragment);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.ll_fragment_person_wait_payment:
                Log.e(TAG, "onViewClicked: "+"跳转至 待付款" );
                setFragment = 200;
                intent = new Intent(getMainActivity(),OrderCenterActivity.class);
                bundle = new Bundle();
                //将网络请求获取到的分类对象传递给ScreenActivity用于展示数据
                bundle.putInt("setFragment", setFragment);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.ll_fragment_person_wait_shipments:
                Log.e(TAG, "onViewClicked: "+"跳转至 待发货" );
                setFragment = 300;
                intent = new Intent(getMainActivity(),OrderCenterActivity.class);
                bundle = new Bundle();
                //将网络请求获取到的分类对象传递给ScreenActivity用于展示数据
                bundle.putInt("setFragment", setFragment);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.ll_fragment_person_wait_receiving:
                Log.e(TAG, "onViewClicked: "+"跳转至 待收货" );
                setFragment = 400;
                intent = new Intent(getMainActivity(),OrderCenterActivity.class);
                bundle = new Bundle();
                //将网络请求获取到的分类对象传递给ScreenActivity用于展示数据
                bundle.putInt("setFragment", setFragment);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.ll_fragment_person_wait_picking:
                Log.e(TAG, "onViewClicked: "+"跳转至 提货" );
                setFragment = 600;
                intent = new Intent(getMainActivity(),OrderCenterActivity.class);
                bundle = new Bundle();
                //将网络请求获取到的分类对象传递给ScreenActivity用于展示数据
                bundle.putInt("setFragment", setFragment);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.ll_fragment_person_refund_after_sales:
                Log.e(TAG, "onViewClicked: "+"跳转至 退货售后" );
                setFragment = 700;
                intent = new Intent(getMainActivity(),OrderCenterActivity.class);
                bundle = new Bundle();
                //将网络请求获取到的分类对象传递给ScreenActivity用于展示数据
                bundle.putInt("setFragment", setFragment);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.ll_fragment_person_shopping_cart:
                Log.e(TAG, "onViewClicked: "+"跳转至 购物车" );
                intent = new Intent(getMainActivity(),ShoppingCartActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_fragment_person_discount_coupon:
                Log.e(TAG, "onViewClicked: "+"跳转至 优惠券" );
                intent = new Intent(getMainActivity(),DiscountCouponActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_fragment_person_bargain:
                Log.e(TAG, "onViewClicked: "+"跳转至 砍价" );
                intent = new Intent(getMainActivity(),BargainActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_fragment_person_groupon:
                Log.e(TAG, "onViewClicked: "+"跳转至 团购订单" );
                intent = new Intent(getMainActivity(),GrouponActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_fragment_person_winning:
                Log.e(TAG, "onViewClicked: "+"跳转至 中奖纪录" );
                intent = new Intent(getMainActivity(),WinningActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_fragment_person_integral_shopping:
                Log.e(TAG, "onViewClicked: "+"跳转至 积分商城" );
                intent = new Intent(getMainActivity(),IntegralShoppingMallActivity.class);
                startActivity(intent);
                break;
        }
    }

}
