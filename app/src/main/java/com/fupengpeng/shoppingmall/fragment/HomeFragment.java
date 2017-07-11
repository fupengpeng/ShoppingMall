package com.fupengpeng.shoppingmall.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fupengpeng.shoppingmall.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 主界面Fragment
 */
public class HomeFragment extends Fragment {

    View homeFragmentView;

    private static final String TAG = "ShoppingCartFragment";
    /**
     * 上下文
     */
    protected Context context = null;
    /**
     * 依附的MainActivity
     */
    protected Activity mainActivity = null;

    /**
     * 轮播
     */
    @BindView(R.id.vp_fragment_home_carousel)
    ViewPager vpFragmentHomeCarousel;
    /**
     * 轮播图片标题
     */
    @BindView(R.id.tv_fragment_home_pic_title)
    TextView tvFragmentHomePicTitle;
    /**
     * 轮播圆点
     */
    @BindView(R.id.v_fragment_home_dot_one)
    View vFragmentHomeDotOne;
    @BindView(R.id.v_fragment_home_dot_two)
    View vFragmentHomeDotTwo;
    @BindView(R.id.v_fragment_home_dot_three)
    View vFragmentHomeDotThree;
    @BindView(R.id.v_fragment_home_dot_four)
    View vFragmentHomeDotFour;
    @BindView(R.id.v_fragment_home_dot_five)
    View vFragmentHomeDotFive;

    Unbinder unbinder;

    /**
     * 获取Fragment依赖的MainActivity
     *
     * @return
     */
    public Activity getMainActivity() {
        mainActivity = getActivity();
        context = mainActivity;
        return mainActivity;
    }


    /**
     * 图片集合
     */
    private List<ImageView> images;
    /**
     * 圆点集合
     */
    private List<View> dots;
    private int currentItem;
    //记录上一次点的位置
    private int oldPosition = 0;
    //图片资源
    private int[] imageIds = new int[]{
            R.drawable.nvshengtouxiang,
            R.drawable.nvshengtouxiangxiaoqingxin,
            R.drawable.nvshengtouxiang,
            R.drawable.nvshengtouxiangxiaoqingxin,
            R.drawable.nvshengtouxiang
    };
    //图片标题资源
    private String[] titles = new String[]{
            "二哈来了，快跑！",
            "春天到了，蝴蝶出来了！",
            "蓝色的雪花",
            "快快快，去抓老鼠。。。",
            "冬日里的美女"
    };
    /**
     * 适配器
     */
    private ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        homeFragmentView = inflater.inflate(R.layout.fragment_home, container, false);

        //显示的图片
        images = new ArrayList<ImageView>();
        for (int i = 0; i < imageIds.length; i++) {
            ImageView imageView = new ImageView(getMainActivity());
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
        }
        //显示的小点
        dots = new ArrayList<View>();
        dots.add(vFragmentHomeDotOne);
        dots.add(vFragmentHomeDotTwo);
        dots.add(vFragmentHomeDotThree);
        dots.add(vFragmentHomeDotFour);
        dots.add(vFragmentHomeDotFive);

        tvFragmentHomePicTitle.setText(titles[0]);

        adapter = new ViewPagerAdapter();
        vpFragmentHomeCarousel.setAdapter(adapter);

        vpFragmentHomeCarousel.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageSelected(int position) {
                tvFragmentHomePicTitle.setText(titles[position]);
                dots.get(position).setBackgroundResource(R.drawable.dot_focused);
                dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);

                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });


        unbinder = ButterKnife.bind(this, homeFragmentView);
        return homeFragmentView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    /**
     * 自定义Adapter
     *
     * @author liuyazhuang
     */
    private class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
//			super.destroyItem(container, position, object);
//			view.removeView(view.getChildAt(position));
//			view.removeViewAt(position);
            view.removeView(images.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            view.addView(images.get(position));
            return images.get(position);
        }

    }


    /**
     * 利用线程池定时执行动画轮播
     */
    @Override
    public void onStart() {
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPageTask(),
                2,
                2,
                TimeUnit.SECONDS);
    }


    private class ViewPageTask implements Runnable {

        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;
            mHandler.sendEmptyMessage(0);
        }
    }

    /**
     * 接收子线程传递过来的数据
     */
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            vpFragmentHomeCarousel.setCurrentItem(currentItem);
        }

        ;
    };

    @Override
    public void onStop() {
        super.onStop();
    }


}
