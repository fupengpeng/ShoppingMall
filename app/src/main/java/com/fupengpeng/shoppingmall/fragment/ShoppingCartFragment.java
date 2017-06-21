package com.fupengpeng.shoppingmall.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.fupengpeng.shoppingmall.MainActivity;
import com.fupengpeng.shoppingmall.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 购物车Fragment
 */
public class ShoppingCartFragment extends Fragment {

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
    /**
     * 购物车商品列表
     */
    @BindView(R.id.lv_fragment_shopping_cart)
    ListView lvFragmentShoppingCart;
    /**
     * 购物车全选按钮
     */
    @BindView(R.id.cb_fragment_shopping_cart_select_all)
    CheckBox cbFragmentShoppingCartSelectAll;
    /**
     * 已选商品合计
     */
    @BindView(R.id.tv_fragment_shopping_cart_total)
    TextView tvFragmentShoppingCartTotal;
    /**
     * 已选商品总计
     */
    @BindView(R.id.tv_fragment_shopping_cart_amount)
    TextView tvFragmentShoppingCartAmount;
    /**
     * 结算
     */
    @BindView(R.id.btn_fragment_shopping_cart_settlement)
    Button btnFragmentShoppingCartSettlement;

    Unbinder unbinder;
    /**
     * Fragment布局
     */
    private View shoppingCartFragmentView;

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
        shoppingCartFragmentView = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        unbinder = ButterKnife.bind(this, shoppingCartFragmentView);
        getActivity();



        return shoppingCartFragmentView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
