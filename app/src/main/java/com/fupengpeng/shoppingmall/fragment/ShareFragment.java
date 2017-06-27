package com.fupengpeng.shoppingmall.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fupengpeng.shoppingmall.MainActivity;
import com.fupengpeng.shoppingmall.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 分享Fragment
 */
public class ShareFragment extends Fragment {

    private static final String TAG = "PersonCenterFragment";
    /**
     * 上下文
     */
    protected Context context = null;
    /**
     * 依附的MainActivity
     */
    protected Activity mainActivity = null;

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

    @BindView(R.id.pts_fragment_share)
    PagerTabStrip ptsFragmentShare;

    @BindView(R.id.vp_fragment_share)
    ViewPager vpFragmentShare;

    Unbinder unbinder;

    ArrayList<View> viewContainter = new ArrayList<View>();
    ArrayList<String> titleContainer = new ArrayList<String>();
    private View shareFragmentView;

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

        getActivity();
        // Inflate the layout for this fragment
        shareFragmentView = inflater.inflate(R.layout.fragment_share, container, false);
        unbinder = ButterKnife.bind(this, shareFragmentView);


        setViewPager();

        return shareFragmentView;
    }

    private void setViewPager() {




        //取消tab下面的长横线
        ptsFragmentShare.setDrawFullUnderline(false);
        //设置tab的背景色
        ptsFragmentShare.setBackgroundColor(this.getResources().getColor(R.color.colorDc));
        //设置当前tab页签的下划线颜色
        ptsFragmentShare.setTabIndicatorColor(this.getResources().getColor(R.color.red));
        ptsFragmentShare.setTextSpacing(100);

        View view1 = LayoutInflater.from(getMainActivity()).inflate(R.layout.tab1, null);
        View view2 = LayoutInflater.from(getMainActivity()).inflate(R.layout.tab2, null);
        View view3 = LayoutInflater.from(getMainActivity()).inflate(R.layout.tab3, null);
        View view4 = LayoutInflater.from(getMainActivity()).inflate(R.layout.tab4, null);
        //viewpager开始添加view
        viewContainter.add(view1);
        viewContainter.add(view2);
        viewContainter.add(view3);
        viewContainter.add(view4);
        //页签项
        titleContainer.add("直播");
        titleContainer.add("视频");
        titleContainer.add("试用");
        titleContainer.add("新品");

        vpFragmentShare.setAdapter(new PagerAdapter() {

            //viewpager中的组件数量
            @Override
            public int getCount() {
                return viewContainter.size();
            }
            //滑动切换的时候销毁当前的组件
            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                ((ViewPager) container).removeView(viewContainter.get(position));
            }
            //每次滑动的时候生成的组件
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ((ViewPager) container).addView(viewContainter.get(position));
                return viewContainter.get(position);
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override
            public int getItemPosition(Object object) {
                return super.getItemPosition(object);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleContainer.get(position);
            }
        });

        vpFragmentShare.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int arg0) {
                Log.d(TAG, "--------changed:" + arg0);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                Log.d(TAG, "-------scrolled arg0:" + arg0);
                Log.d(TAG, "-------scrolled arg1:" + arg1);
                Log.d(TAG, "-------scrolled arg2:" + arg2);
            }

            @Override
            public void onPageSelected(int arg0) {
                Log.d(TAG, "------selected:" + arg0);
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
