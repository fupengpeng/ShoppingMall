package com.fupengpeng.shoppingmall.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fupengpeng.shoppingmall.MainActivity;
import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.entity.ShareAttentionList;
import com.fupengpeng.shoppingmall.entity.ShareAttentionObject;
import com.fupengpeng.shoppingmall.util.PullToRefreshUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @BindView(R.id.pts_fragment_share)
    PagerTabStrip ptsFragmentShare;

    @BindView(R.id.vp_fragment_share)
    ViewPager vpFragmentShare;

    Unbinder unbinder;

    ArrayList<View> viewContainter = new ArrayList<View>();
    ArrayList<String> titleContainer = new ArrayList<String>();
    private View shareFragmentView;
    private ShareAttentionList shareAttentionList;

    private ListViewAdapter listViewAdapter01,ptrlvItemFragmentShareSelectionAdapter;
    /**
     * 数据源
     */
    List<Map<String, Object>> list01,list02,list03,list04,list05,list06,list07,list08,list09,list10;
    private ListView listView02,listView03,listView04,listView05,listView06,listView07,listView08,listView09,listView10;
    private PullToRefreshListView ptrlvItemFragmentShareSelection;

    /**
     * 当前页
     */
    private int currentPage;
    /**
     * 总页数
     */
    private int totalPage;

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

        View view2 = LayoutInflater.from(getMainActivity()).inflate(R.layout.item_fragment_share_live_telecast, null);
        View view3 = LayoutInflater.from(getMainActivity()).inflate(R.layout.item_fragment_share_attention, null);
        View view4 = LayoutInflater.from(getMainActivity()).inflate(R.layout.item_fragment_share_inventory, null);
        View view5 = LayoutInflater.from(getMainActivity()).inflate(R.layout.item_fragment_share_consult, null);
        View view6 = LayoutInflater.from(getMainActivity()).inflate(R.layout.item_fragment_share_video_shopping, null);
        View view7 = LayoutInflater.from(getMainActivity()).inflate(R.layout.item_fragment_share_good_cargo, null);
        View view8 = LayoutInflater.from(getMainActivity()).inflate(R.layout.item_fragment_share_community, null);
        View view9 = LayoutInflater.from(getMainActivity()).inflate(R.layout.item_fragment_share_life, null);
        View view10 = LayoutInflater.from(getMainActivity()).inflate(R.layout.item_fragment_share_digit, null);

        View selectionView = LayoutInflater.from(getMainActivity()).inflate(R.layout.item_fragment_share_selection, null);
//        View liveTelecastView = LayoutInflater.from(getMainActivity()).inflate(R.layout.item_fragment_share_live_telecast, null);
//        View attentionView = LayoutInflater.from(getMainActivity()).inflate(R.layout.item_fragment_share_attention, null);
//        View inventoryView = LayoutInflater.from(getMainActivity()).inflate(R.layout.item_fragment_share_inventory, null);
//        View consultView = LayoutInflater.from(getMainActivity()).inflate(R.layout.item_fragment_share_consult, null);
//        View videoShoppingView = LayoutInflater.from(getMainActivity()).inflate(R.layout.item_fragment_share_video_shopping, null);
//        View goodCargoView = LayoutInflater.from(getMainActivity()).inflate(R.layout.item_fragment_share_good_cargo, null);
//        View communityView = LayoutInflater.from(getMainActivity()).inflate(R.layout.item_fragment_share_community, null);
//        View lifeView = LayoutInflater.from(getMainActivity()).inflate(R.layout.item_fragment_share_life, null);
//        View digitView = LayoutInflater.from(getMainActivity()).inflate(R.layout.item_fragment_share_digit, null);


        //viewpager开始添加view
        viewContainter.add(view2);
        viewContainter.add(view3);
        viewContainter.add(view4);
        viewContainter.add(view5);
        viewContainter.add(view6);
        viewContainter.add(view7);
        viewContainter.add(view8);
        viewContainter.add(view9);
        viewContainter.add(view10);

        viewContainter.add(selectionView);
//        viewContainter.add(liveTelecastView);
//        viewContainter.add(attentionView);
//        viewContainter.add(inventoryView);
//        viewContainter.add(consultView);
//        viewContainter.add(videoShoppingView);
//        viewContainter.add(goodCargoView);
//        viewContainter.add(communityView);
//        viewContainter.add(lifeView);
//        viewContainter.add(digitView);

        //页签项
        titleContainer.add("精选");
        titleContainer.add("直播");
        titleContainer.add("关注");
        titleContainer.add("清单");
        titleContainer.add("问答");
        titleContainer.add("视频购");
        titleContainer.add("好东西");
        titleContainer.add("社区");
        titleContainer.add("生活");
        titleContainer.add("数码");




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

        ptrlvItemFragmentShareSelection = (PullToRefreshListView) selectionView.findViewById(R.id.ptrlv_item_fragment_share_selection);

        listView02 = (ListView) view2.findViewById(R.id.lv_tab2);
        listView03 = (ListView) view3.findViewById(R.id.lv_tab3);
        listView04 = (ListView) view4.findViewById(R.id.lv_tab4);
        listView05 = (ListView) view5.findViewById(R.id.lv_tab5);
        listView06 = (ListView) view6.findViewById(R.id.lv_tab6);
        listView07 = (ListView) view7.findViewById(R.id.lv_tab7);
        listView08 = (ListView) view8.findViewById(R.id.lv_tab8);
        listView09 = (ListView) view9.findViewById(R.id.lv_tab9);
        listView10 = (ListView) view10.findViewById(R.id.lv_tab10);



        // TODO: 2017/6/28 0028 适配器待完善


        parseData();
        list01 = getData();
        Log.e(TAG, "setViewPager:---------- "+list01.get(1).get("tag").toString().trim() );
        Log.e(TAG, "setViewPager:--------------------------------------- "+list01.get(1).get("title").toString().trim() );
        listViewAdapter01 = new ListViewAdapter(context, list01);


        // 初始化
        init();
        // 设置监听器
        setListeners();


        listView02.setAdapter(listViewAdapter01);
        listView03.setAdapter(listViewAdapter01);
        listView04.setAdapter(listViewAdapter01);
        listView05.setAdapter(listViewAdapter01);
        listView06.setAdapter(listViewAdapter01);
        listView07.setAdapter(listViewAdapter01);
        listView08.setAdapter(listViewAdapter01);
        listView09.setAdapter(listViewAdapter01);
        listView10.setAdapter(listViewAdapter01);


    }





    /**
     * 初始化
     */
    private void init() {
        // 绑定数据
        bindData();
        // 设置加载模式
        PullToRefreshUtils.setPullBoth(ptrlvItemFragmentShareSelection);
        // 刷新数据
        refreshData(1);
    }

    /**
     * 设置监听器
     */
    private void setListeners() {
        Log.e(TAG, "setListeners: "+"777777777777777777777777777777777777777777" );
        // 刷新监听器
        ptrlvItemFragmentShareSelection.setOnRefreshListener(new InnerOnRefreshListener2());
        // 子项点击监听器
        ptrlvItemFragmentShareSelection.setOnItemClickListener(new InnerOnItemClickListener());
    }


    /**
     * 刷新监听器
     */
    private class InnerOnRefreshListener2 implements PullToRefreshBase.OnRefreshListener2 {
        @Override
        public void onPullDownToRefresh(PullToRefreshBase refreshView) {
            // 下拉刷新
            refreshData(1);
            Log.e(TAG, "onPullDownToRefresh: " + "----004");

            ShareAttentionList sal = new ShareAttentionList();
            List<ShareAttentionObject> shareAttentionObjects = new ArrayList<ShareAttentionObject>();
            for (int i = 0; i < 3; i++) {
                ShareAttentionObject shareAttentionObject = new ShareAttentionObject();
                shareAttentionObject.setTag("2000");
                shareAttentionObject.setUsername("用户：---" + 2000 + "---");
                shareAttentionObject.setUserPic(R.drawable.nvshengtouxiang);
                shareAttentionObject.setUserAddress("用户地址：---" + 2000 + "---");
                shareAttentionObject.setUserIdentifying("用户标识：---" + 2000 + "---");
                shareAttentionObject.setTitle("咨询标题：---" + 2000 + "---");
                shareAttentionObject.setTitleExplain("咨询标题说明：---" + 2000 + "---");
                shareAttentionObject.setTitlePicOne(R.drawable.nvshengtouxiang);
                shareAttentionObject.setTitlePicTwo(R.drawable.nvshengtouxiang);
                shareAttentionObject.setTitlePicThree(R.drawable.nvshengtouxiang);
                shareAttentionObject.setBrowseNumber("2000");
                shareAttentionObject.setCowrieNumber("2000");
                shareAttentionObject.setCowrieClassify("宝贝分类：---" + 2000 + "---");
                shareAttentionObject.setTime("资讯发布时间：---" + 2000 + "---");
                shareAttentionObject.setCowriePrice(2000);

                shareAttentionObjects.add(shareAttentionObject);
            }
            sal.setShareAttentionObjectList(shareAttentionObjects);



            List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
            Map<String, Object> map;
            for (int i = 0; i < sal.getShareAttentionObjectList().size(); i++) {
                map = new HashMap<String, Object>();

                mapPut(sal, map, i);

                lista.add(map);
            }


            ptrlvItemFragmentShareSelectionAdapter.addFirst(lista);
            new ShareFragment.FinishRefresh().execute();
            ptrlvItemFragmentShareSelectionAdapter.notifyDataSetChanged();
        }

        @Override
        public void onPullUpToRefresh(PullToRefreshBase refreshView) {

            Log.e(TAG, "onPullUpToRefresh: " + "----005");

            totalPage = 5;
            // 判断是否还有更多数据
            if (currentPage >= totalPage) {
                Toast.makeText(getMainActivity(), "没有更多数据", Toast.LENGTH_SHORT).show();
                // 加载完成
                PullToRefreshUtils.refreshComplete(ptrlvItemFragmentShareSelection);
                return;
            }
            // 上拉加载
            currentPage++;
            refreshData(currentPage);

            ShareAttentionList sal = new ShareAttentionList();
            List<ShareAttentionObject> shareAttentionObjects = new ArrayList<ShareAttentionObject>();
            for (int i = 0; i < 3; i++) {
                ShareAttentionObject shareAttentionObject = new ShareAttentionObject();

                shareAttentionObject.setTag("2000");
                shareAttentionObject.setUsername("用户：---" + 2000 + "---");
                shareAttentionObject.setUserPic(R.drawable.nvshengtouxiang);
                shareAttentionObject.setUserAddress("用户地址：---" + 2000 + "---");
                shareAttentionObject.setUserIdentifying("用户标识：---" + 2000 + "---");
                shareAttentionObject.setTitle("咨询标题：---" + 2000 + "---");
                shareAttentionObject.setTitleExplain("咨询标题说明：---" + 2000 + "---");
                shareAttentionObject.setTitlePicOne(R.drawable.nvshengtouxiang);
                shareAttentionObject.setTitlePicTwo(R.drawable.nvshengtouxiang);
                shareAttentionObject.setTitlePicThree(R.drawable.nvshengtouxiang);
                shareAttentionObject.setBrowseNumber("2000");
                shareAttentionObject.setCowrieNumber("2000");
                shareAttentionObject.setCowrieClassify("宝贝分类：---" + 2000 + "---");
                shareAttentionObject.setTime("资讯发布时间：---" + 2000 + "---");
                shareAttentionObject.setCowriePrice(2000);

                shareAttentionObjects.add(shareAttentionObject);
            }
            sal.setShareAttentionObjectList(shareAttentionObjects);

            List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
            Map<String, Object> map;
            for (int i = 0; i < sal.getShareAttentionObjectList().size(); i++) {
                map = new HashMap<String, Object>();

                mapPut(sal, map, i);

                lista.add(map);
            }


            ptrlvItemFragmentShareSelectionAdapter.addLast(lista);
            new ShareFragment.FinishRefresh().execute();
            ptrlvItemFragmentShareSelectionAdapter.notifyDataSetChanged();
        }
    }

    private void mapPut(ShareAttentionList sal, Map<String, Object> map, int i) {
        map.put("tag", sal.getShareAttentionObjectList().get(i).getTag());
        map.put("username", sal.getShareAttentionObjectList().get(i).getUsername());
        map.put("userPic", sal.getShareAttentionObjectList().get(i).getUserPic());
        map.put("userAddress", sal.getShareAttentionObjectList().get(i).getUserAddress());
        map.put("userIdentifying", sal.getShareAttentionObjectList().get(i).getUserIdentifying());
        map.put("title", sal.getShareAttentionObjectList().get(i).getTitle());
        map.put("titleExplain", sal.getShareAttentionObjectList().get(i).getTitleExplain());
        map.put("titlePicOne", sal.getShareAttentionObjectList().get(i).getTitlePicOne());
        map.put("titlePicTwo", sal.getShareAttentionObjectList().get(i).getTitlePicTwo());
        map.put("titlePicThree", sal.getShareAttentionObjectList().get(i).getTitlePicThree());
        map.put("browseNumber", sal.getShareAttentionObjectList().get(i).getBrowseNumber());
        map.put("cowrieNumber", sal.getShareAttentionObjectList().get(i).getCowrieNumber());
        map.put("cowrieClassify", sal.getShareAttentionObjectList().get(i).getCowrieClassify());
        map.put("time", sal.getShareAttentionObjectList().get(i).getTime());
        map.put("cowriePrice", sal.getShareAttentionObjectList().get(i).getCowriePrice());
    }

    /**
     * 绑定数据
     */
    private void bindData() {
        list01 = getData();
        if (list01 == null){
            ptrlvItemFragmentShareSelection.setVisibility(View.GONE);
        }else {
            ptrlvItemFragmentShareSelection.setVisibility(View.VISIBLE);
            ptrlvItemFragmentShareSelectionAdapter = new ListViewAdapter(context, list01);
            ptrlvItemFragmentShareSelection.setAdapter(ptrlvItemFragmentShareSelectionAdapter);
        }

    }

    /**
     * 子项点击监听器
     */
    public class InnerOnItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // 数据源当前索引
            int pos = position - 1;
            Log.e(TAG, "onItemClick: " + "----007---------------------------------------------" + position);

        }
    }

    /**
     * 刷新数据
     */
    private void refreshData(int page) {
        currentPage = page;
    }


    /**
     * 异步任务，模仿网络请求
     */
    private class FinishRefresh extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            ptrlvItemFragmentShareSelectionAdapter.notifyDataSetChanged();
            ptrlvItemFragmentShareSelection.onRefreshComplete();
        }
    }



    /**
     * 根据数据对象设置适配器数据
     *
     * @return
     */
    private List<Map<String, Object>> getData() {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;

        for (int i = 0; i < shareAttentionList.getShareAttentionObjectList().size(); i++) {
            map = new HashMap<String, Object>();
            mapPut(shareAttentionList, map, i);
            list.add(map);
        }
        Log.e(TAG, "getData: " + "数据设置");
        return list;
    }

    /**
     * 数据对象获取
     */
    private void parseData() {
        shareAttentionList = new ShareAttentionList();
        List<ShareAttentionObject> shareAttentionObjects = new ArrayList<ShareAttentionObject>();

        ShareAttentionObject shareAttentionObject2000 = new ShareAttentionObject();
        shareAttentionObject2000.setTag("2000");
        shareAttentionObject2000.setUsername("用户：---" + 2000 + "---");
        shareAttentionObject2000.setUserPic(R.drawable.nvshengtouxiang);
        shareAttentionObject2000.setUserAddress("用户地址：---" + 2000 + "---");
        shareAttentionObject2000.setUserIdentifying("用户标识：---" + 2000 + "---");
        shareAttentionObject2000.setTitle("咨询标题：---" + 2000 + "---");
        shareAttentionObject2000.setTitleExplain("咨询标题说明：---" + 2000 + "---");
        shareAttentionObject2000.setTitlePicOne(R.drawable.nvshengtouxiang);
        shareAttentionObject2000.setTitlePicTwo(R.drawable.nvshengtouxiang);
        shareAttentionObject2000.setTitlePicThree(R.drawable.nvshengtouxiang);
        shareAttentionObject2000.setBrowseNumber("2000");
        shareAttentionObject2000.setCowrieNumber("2000");
        shareAttentionObject2000.setCowrieClassify("宝贝分类：---" + 2000 + "---");
        shareAttentionObject2000.setTime("资讯发布时间：---" + 2000 + "---");
        shareAttentionObject2000.setCowriePrice(2000);

        shareAttentionObjects.add(shareAttentionObject2000);

        ShareAttentionObject shareAttentionObject3000 = new ShareAttentionObject();
        shareAttentionObject3000.setTag("3000");
        shareAttentionObject3000.setUsername("用户：---" + 3000 + "---");
        shareAttentionObject3000.setUserPic(R.drawable.nvshengtouxiang);
        shareAttentionObject3000.setUserAddress("用户地址：---" + 3000 + "---");
        shareAttentionObject3000.setUserIdentifying("用户标识：---" + 3000 + "---");
        shareAttentionObject3000.setTitle("咨询标题：---" + 3000 + "---");
        shareAttentionObject3000.setTitleExplain("咨询标题说明：---" + 3000 + "---");
        shareAttentionObject3000.setTitlePicOne(R.drawable.nvshengtouxiang);
        shareAttentionObject3000.setTitlePicTwo(R.drawable.nvshengtouxiang);
        shareAttentionObject3000.setTitlePicThree(R.drawable.nvshengtouxiang);
        shareAttentionObject3000.setBrowseNumber("3000");
        shareAttentionObject3000.setCowrieNumber("3000");
        shareAttentionObject3000.setCowrieClassify("宝贝分类：---" + 3000 + "---");
        shareAttentionObject3000.setTime("资讯发布时间：---" + 3000 + "---");
        shareAttentionObject3000.setCowriePrice(3000);

        shareAttentionObjects.add(shareAttentionObject3000);

        ShareAttentionObject shareAttentionObject4000 = new ShareAttentionObject();
        shareAttentionObject4000.setTag("4000");
        shareAttentionObject4000.setUsername("用户：---" + 4000 + "---");
        shareAttentionObject4000.setUserPic(R.drawable.nvshengtouxiang);
        shareAttentionObject4000.setUserAddress("用户地址：---" + 4000 + "---");
        shareAttentionObject4000.setUserIdentifying("用户标识：---" + 4000 + "---");
        shareAttentionObject4000.setTitle("咨询标题：---" + 4000 + "---");
        shareAttentionObject4000.setTitleExplain("咨询标题说明：---" + 4000 + "---");
        shareAttentionObject4000.setTitlePicOne(R.drawable.nvshengtouxiang);
        shareAttentionObject4000.setTitlePicTwo(R.drawable.nvshengtouxiang);
        shareAttentionObject4000.setTitlePicThree(R.drawable.nvshengtouxiang);
        shareAttentionObject4000.setBrowseNumber("4000");
        shareAttentionObject4000.setCowrieNumber("4000");
        shareAttentionObject4000.setCowrieClassify("宝贝分类：---" + 4000 + "---");
        shareAttentionObject4000.setTime("资讯发布时间：---" + 4000 + "---");
        shareAttentionObject4000.setCowriePrice(4000);

        shareAttentionObjects.add(shareAttentionObject4000);

        ShareAttentionObject shareAttentionObject5000 = new ShareAttentionObject();
        shareAttentionObject5000.setTag("5000");
        shareAttentionObject5000.setUsername("用户：---" + 5000 + "---");
        shareAttentionObject5000.setUserPic(R.drawable.nvshengtouxiang);
        shareAttentionObject5000.setUserAddress("用户地址：---" + 5000 + "---");
        shareAttentionObject5000.setUserIdentifying("用户标识：---" + 5000 + "---");
        shareAttentionObject5000.setTitle("咨询标题：---" + 5000 + "---");
        shareAttentionObject5000.setTitleExplain("咨询标题说明：---" + 5000 + "---");
        shareAttentionObject5000.setTitlePicOne(R.drawable.nvshengtouxiang);
        shareAttentionObject5000.setTitlePicTwo(R.drawable.nvshengtouxiang);
        shareAttentionObject5000.setTitlePicThree(R.drawable.nvshengtouxiang);
        shareAttentionObject5000.setBrowseNumber("5000");
        shareAttentionObject5000.setCowrieNumber("5000");
        shareAttentionObject5000.setCowrieClassify("宝贝分类：---" + 5000 + "---");
        shareAttentionObject5000.setTime("资讯发布时间：---" + 5000 + "---");
        shareAttentionObject5000.setCowriePrice(5000);

        shareAttentionObjects.add(shareAttentionObject5000);

        ShareAttentionObject shareAttentionObject6000 = new ShareAttentionObject();
        shareAttentionObject6000.setTag("6000");
        shareAttentionObject6000.setUsername("用户：---" + 6000 + "---");
        shareAttentionObject6000.setUserPic(R.drawable.nvshengtouxiang);
        shareAttentionObject6000.setUserAddress("用户地址：---" + 6000 + "---");
        shareAttentionObject6000.setUserIdentifying("用户标识：---" + 6000 + "---");
        shareAttentionObject6000.setTitle("咨询标题：---" + 6000 + "---");
        shareAttentionObject6000.setTitleExplain("咨询标题说明：---" + 6000 + "---");
        shareAttentionObject6000.setTitlePicOne(R.drawable.nvshengtouxiang);
        shareAttentionObject6000.setTitlePicTwo(R.drawable.nvshengtouxiang);
        shareAttentionObject6000.setTitlePicThree(R.drawable.nvshengtouxiang);
        shareAttentionObject6000.setBrowseNumber("6000");
        shareAttentionObject6000.setCowrieNumber("6000");
        shareAttentionObject6000.setCowrieClassify("宝贝分类：---" + 6000 + "---");
        shareAttentionObject6000.setTime("资讯发布时间：---" + 6000 + "---");
        shareAttentionObject6000.setCowriePrice(6000);

        shareAttentionObjects.add(shareAttentionObject6000);

        ShareAttentionObject shareAttentionObject7000 = new ShareAttentionObject();
        shareAttentionObject7000.setTag("7000");
        shareAttentionObject7000.setUsername("用户：---" + 7000 + "---");
        shareAttentionObject7000.setUserPic(R.drawable.nvshengtouxiang);
        shareAttentionObject7000.setUserAddress("用户地址：---" + 7000 + "---");
        shareAttentionObject7000.setUserIdentifying("用户标识：---" + 7000 + "---");
        shareAttentionObject7000.setTitle("咨询标题：---" + 7000 + "---");
        shareAttentionObject7000.setTitleExplain("咨询标题说明：---" + 7000 + "---");
        shareAttentionObject7000.setTitlePicOne(R.drawable.nvshengtouxiang);
        shareAttentionObject7000.setTitlePicTwo(R.drawable.nvshengtouxiang);
        shareAttentionObject7000.setTitlePicThree(R.drawable.nvshengtouxiang);
        shareAttentionObject7000.setBrowseNumber("7000");
        shareAttentionObject7000.setCowrieNumber("7000");
        shareAttentionObject7000.setCowrieClassify("宝贝分类：---" + 7000 + "---");
        shareAttentionObject7000.setTime("资讯发布时间：---" + 7000 + "---");
        shareAttentionObject7000.setCowriePrice(7000);

        shareAttentionObjects.add(shareAttentionObject7000);

        ShareAttentionObject shareAttentionObject8000 = new ShareAttentionObject();
        shareAttentionObject8000.setTag("8000");
        shareAttentionObject8000.setUsername("用户：---" + 8000 + "---");
        shareAttentionObject8000.setUserPic(R.drawable.nvshengtouxiang);
        shareAttentionObject8000.setUserAddress("用户地址：---" + 8000 + "---");
        shareAttentionObject8000.setUserIdentifying("用户标识：---" + 8000 + "---");
        shareAttentionObject8000.setTitle("咨询标题：---" + 8000 + "---");
        shareAttentionObject8000.setTitleExplain("咨询标题说明：---" + 8000 + "---");
        shareAttentionObject8000.setTitlePicOne(R.drawable.nvshengtouxiang);
        shareAttentionObject8000.setTitlePicTwo(R.drawable.nvshengtouxiang);
        shareAttentionObject8000.setTitlePicThree(R.drawable.nvshengtouxiang);
        shareAttentionObject8000.setBrowseNumber("8000");
        shareAttentionObject8000.setCowrieNumber("8000");
        shareAttentionObject8000.setCowrieClassify("宝贝分类：---" + 8000 + "---");
        shareAttentionObject8000.setTime("资讯发布时间：---" + 8000 + "---");
        shareAttentionObject8000.setCowriePrice(8000);

        shareAttentionObjects.add(shareAttentionObject8000);


        for (int i = 0; i < 10; i++) {
            ShareAttentionObject shareAttentionObject = new ShareAttentionObject();
            shareAttentionObject.setTag("9000");
            shareAttentionObject.setUsername("用户：-9000--" + i + "---");
            shareAttentionObject.setUserPic(R.drawable.nvshengtouxiang);
            shareAttentionObject.setUserAddress("用户地址：-9000--" + i + "---");
            shareAttentionObject.setUserIdentifying("用户标识：-9000--" + i + "---");
            shareAttentionObject.setTitle("咨询标题：-9000--" + i + "---");
            shareAttentionObject.setTitleExplain("咨询标题说明：-9000--" + i + "---");
            shareAttentionObject.setTitlePicOne(R.drawable.nvshengtouxiang);
            shareAttentionObject.setTitlePicTwo(R.drawable.nvshengtouxiang);
            shareAttentionObject.setTitlePicThree(R.drawable.nvshengtouxiang);
            shareAttentionObject.setBrowseNumber("9000---"+i);
            shareAttentionObject.setCowrieNumber("9000==="+i);
            shareAttentionObject.setCowrieClassify("宝贝分类：-9000--" + i + "---");
            shareAttentionObject.setTime("资讯发布时间：-9000--" + i + "---");
            shareAttentionObject.setCowriePrice(i);

            shareAttentionObjects.add(shareAttentionObject);
        }
        shareAttentionList.setShareAttentionObjectList(shareAttentionObjects);
        Log.e(TAG, "parseData: " + shareAttentionList.getShareAttentionObjectList().get(2).getCowrieClassify().toString().trim());

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    /**
     * 适配器
     */
    class ListViewAdapter extends BaseAdapter implements View.OnClickListener {

        public static final String TAG = "OrderCenterAllFragmentAdapter";
        public static final String LIVE_TELECASE = "2000";
        public static final String ATTENTION = "3000";
        public static final String INVENTORY = "4000";
        public static final String CONSULT = "5000";
        public static final String VIDEO_SHOPPING = "6000";
        public static final String GOOD_CARGO = "7000";
        public static final String COMMUNITY = "8000";
        public static final String LIFE = "9000";
        public static final String DIGIT = "1000";

        private LayoutInflater mInflater = null;
        private Context context;
        private List<Map<String, Object>> data;

        public ListViewAdapter(Context context, List<Map<String, Object>> data) {
            //根据context上下文加载布局，这里的是Activity本身，即this
            this.mInflater = LayoutInflater.from(context);
            this.context = context;
            this.data = data;
            Log.e(TAG, "OrderCenterAllFragmentAdapter: " + "初始化适配器");
        }


        /**
         * 下拉刷新加载数据
         *
         * @param list
         */
        public void addFirst(List<Map<String, Object>> list) {
            Log.e(TAG, "addFirst: " + "----007");
            for (int i = 0; i < list.size(); i++) {
                data.add(0, list.get(i));
            }
        }

        /**
         * 上拉加载加载数据
         *
         * @param list
         */
        public void addLast(List<Map<String, Object>> list) {
            Log.e(TAG, "addLast: " + "----008");
            for (int i = 0; i < list.size(); i++) {
                data.add(list.get(i));
            }
        }

        @Override
        public int getCount() {
            //How many items are in the data set represented by this Adapter.
            //在此适配器中所代表的数据集中的条目数
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            // Get the data item associated with the specified position in the data set.
            //获取数据集中与指定索引对应的数据项
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            //Get the row id associated with the specified position in the list.
            //获取在列表中与指定索引对应的行id
            return position;
        }

        //Get a View that displays the data at the specified position in the data set.
        //获取一个在数据集中指定索引的视图来显示数据
        ViewHolder viewHolder = null;
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Log.e(TAG, "getView: " + "----009");


            //如果缓存convertView为空，则需要创建View
            if (convertView == null) {
                Log.e(TAG, "getView: " + "----010");
                //根据自定义的Item布局加载布局


                convertView = mInflater.inflate(R.layout.item_fragment_share_item, null);
//                viewHolder = new ViewHolder();
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
//
//                viewHolder.tvItemFragmentShareItemLiveTelecastUsername = (TextView) convertView.findViewById(R.id.tv_item_fragment_share_item_live_telecast_username);
//
//                viewHolder.tvItemFragmentShareItemLiveTelecastUserAddress = (TextView) convertView.findViewById(R.id.tv_item_fragment_share_item_live_telecast_user_address);
//
//                viewHolder.ivItemFragmentShareItemLiveTelecastTitlePicOne = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_title_pic_one);
//
//                viewHolder.tvItemFragmentShareItemLiveTelecastIdentifying = (TextView) convertView.findViewById(R.id.tv_item_fragment_share_item_live_telecast_identifying);
//
//                viewHolder.tvItemFragmentShareItemLiveTelecastTitle = (TextView) convertView.findViewById(R.id.tv_item_fragment_share_item_live_telecast_title);
//
//                viewHolder.tvItemFragmentShareItemLiveTelecastCowrieClassify = (TextView) convertView.findViewById(R.id.tv_item_fragment_share_item_live_telecast_cowrie_classify);
//
//                viewHolder.tvItemFragmentShareItemLiveTelecastTitleExplain = (TextView) convertView.findViewById(R.id.tv_item_fragment_share_item_live_telecast_title_explain);
//
//                viewHolder.llItemFragmentShareItemLiveTelecast = (LinearLayout) convertView.findViewById(R.id.ll_item_fragment_share_item_live_telecast);
//
//
//
//
//                viewHolder.tvItemFragmentShareItemAttentionTitle = (TextView) convertView.findViewById(R.id.tv_item_fragment_share_item_attention_title);
//
//                viewHolder.ivItemFragmentShareItemAttentionUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_attention_user_pic);
//
//                viewHolder.tvItemFragmentShareItemAttentionUsername = (TextView) convertView.findViewById(R.id.tv_item_fragment_share_item_attention_username);
//
//                viewHolder.tvItemFragmentShareItemAttentionBrowseNumber = (TextView) convertView.findViewById(R.id.tv_item_fragment_share_item_attention_browse_number);
//
//                viewHolder.ivItemFragmentShareItemAttentionTitlePicOne = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_attention_title_pic_one);
//
//                viewHolder.tvItemFragmentShareItemAttentionCowriePrice = (TextView) convertView.findViewById(R.id.tv_item_fragment_share_item_attention_cowrie_price);
//
//                viewHolder.llItemFragmentShareItemAttention = (LinearLayout) convertView.findViewById(R.id.ll_item_fragment_share_item_attention);
//
//
//
////                @BindView(R.id.tv_item_fragment_share_item_inventory_title)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemInventoryTitle;
////                @BindView(R.id.tv_item_fragment_share_item_inventory_title_explain)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemInventoryTitleExplain;
////                @BindView(R.id.iv_item_fragment_share_item_inventory_title_pic_one)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                ImageView ivItemFragmentShareItemInventoryTitlePicOne;
////                @BindView(R.id.iv_item_fragment_share_item_inventory_title_pic_two)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                ImageView ivItemFragmentShareItemInventoryTitlePicTwo;
////                @BindView(R.id.iv_item_fragment_share_item_inventory_title_pic_three)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                ImageView ivItemFragmentShareItemInventoryTitlePicThree;
////                @BindView(R.id.iv_item_fragment_share_item_inventory_user_pic)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                ImageView ivItemFragmentShareItemInventoryUserPic;
////                @BindView(R.id.tv_item_fragment_share_item_inventory_username)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemInventoryUsername;
////                @BindView(R.id.tv_item_fragment_share_item_inventory_cowrie_number)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemInventoryCowrieNumber;
////                @BindView(R.id.tv_item_fragment_share_item_inventory_browse_number)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemInventoryBrowseNumber;
////                @BindView(R.id.)
//                viewHolder.llItemFragmentShareItemInventory = (LinearLayout) convertView.findViewById(R.id.ll_item_fragment_share_item_inventory);
////                 ;
//
//
////                @BindView(R.id.tv_item_fragment_share_item_consult_title)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemConsultTitle;
////                @BindView(R.id.iv_item_fragment_share_item_consult_user_pic)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                ImageView ivItemFragmentShareItemConsultUserPic;
////                @BindView(R.id.tv_item_fragment_share_item_consult_username)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemConsultUsername;
////                @BindView(R.id.tv_item_fragment_share_item_consult_user_identifying)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemConsultUserIdentifying;
////                @BindView(R.id.iv_item_fragment_share_item_consult_title_pic_one)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                ImageView ivItemFragmentShareItemConsultTitlePicOne;
//
//                viewHolder.llItemFragmentShareItemConsult = (LinearLayout) convertView.findViewById(R.id.ll_item_fragment_share_item_consult);
//
//
//
////                @BindView(R.id.vv_item_fragment_share_item_video_shopping_video)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                ImageView vvItemFragmentShareItemVideoShoppingVideo;
////                @BindView(R.id.tv_item_fragment_share_item_video_shopping_title)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemVideoShoppingTitle;
////                @BindView(R.id.iv_item_fragment_share_item_video_shopping_user_pic)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                ImageView ivItemFragmentShareItemVideoShoppingUserPic;
////                @BindView(R.id.tv_item_fragment_share_item_video_shopping_username)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemVideoShoppingUsername;
////                @BindView(R.id.tv_item_fragment_share_item_video_shopping_browse_number)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemVideoShoppingBrowseNumber;
////                @BindView(R.id.tv_item_fragment_share_item_video_shopping_cowrie_number)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemVideoShoppingCowrieNumber;
//
//                viewHolder.llItemFragmentShareItemVideoShopping = (LinearLayout) convertView.findViewById(R.id.ll_item_fragment_share_item_video_shopping);
//
//
//
////                @BindView(R.id.iv_item_fragment_share_item_good_cargo_title_pic_one)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                ImageView ivItemFragmentShareItemGoodCargoTitlePicOne;
////                @BindView(R.id.tv_item_fragment_share_item_good_cargo_title)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemGoodCargoTitle;
////                @BindView(R.id.tv_item_fragment_share_item_good_cargo_title_explain)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemGoodCargoTitleExplain;
////                @BindView(R.id.tv_item_fragment_share_item_good_cargo_browse_number)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemGoodCargoBrowseNumber;
////                @BindView(R.id.)
//                viewHolder.llItemFragmentShareItemGoodCargo = (LinearLayout) convertView.findViewById(R.id.ll_item_fragment_share_item_good_cargo);
////                 ;
//
//
////                @BindView(R.id.iv_item_fragment_share_item_community_user_pic)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                ImageView ivItemFragmentShareItemCommunityUserPic;
////                @BindView(R.id.tv_item_fragment_share_item_community_username)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemCommunityUsername;
////                @BindView(R.id.tv_item_fragment_share_item_community_user_identifying)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemCommunityUserIdentifying;
////                @BindView(R.id.tv_item_fragment_share_item_community_time)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemCommunityTime;
////                @BindView(R.id.tv_item_fragment_share_item_community_title)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemCommunityTitle;
////                @BindView(R.id.tv_item_fragment_share_item_community_title_explain)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemCommunityTitleExplain;
////                @BindView(R.id.iv_item_fragment_share_item_community_title_pic_one)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                ImageView ivItemFragmentShareItemCommunityTitlePicOne;
////                @BindView(R.id.iv_item_fragment_share_item_community_title_pic_two)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                ImageView ivItemFragmentShareItemCommunityTitlePicTwo;
////                @BindView(R.id.iv_item_fragment_share_item_community_title_pic_three)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                ImageView ivItemFragmentShareItemCommunityTitlePicThree;
////                @BindView(R.id.tv_item_fragment_share_item_community_cowrie_number)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemCommunityCowrieNumber;
////                @BindView(R.id.tv_item_fragment_share_item_community_browse_number)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemCommunityBrowseNumber;
//
//                viewHolder.llItemFragmentShareItemCommunity = (LinearLayout) convertView.findViewById(R.id.ll_item_fragment_share_item_community);
//
//
//
////                @BindView(R.id.tv_item_fragment_share_item_life_title)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemLifeTitle;
////                @BindView(R.id.iv_item_fragment_share_item_life_title_pic_one)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                ImageView ivItemFragmentShareItemLifeTitlePicOne;
////                @BindView(R.id.iv_item_fragment_share_item_life_title_pic_two)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                ImageView ivItemFragmentShareItemLifeTitlePicTwo;
////                @BindView(R.id.iv_item_fragment_share_item_life_title_pic_three)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                ImageView ivItemFragmentShareItemLifeTitlePicThree;
////                @BindView(R.id.iv_item_fragment_share_item_life_user_pic)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                ImageView ivItemFragmentShareItemLifeUserPic;
////                @BindView(R.id.tv_item_fragment_share_item_life_username)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemLifeUsername;
////                @BindView(R.id.tv_item_fragment_share_item_life_browse_number)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemLifeBrowseNumber;
////                @BindView(R.id.tv_item_fragment_share_item_life_cowrie_number)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemLifeCowrieNumber;
//
//                viewHolder.llItemFragmentShareItemLife = (LinearLayout) convertView.findViewById(R.id.ll_item_fragment_share_item_life);
//
//
//
////                @BindView(R.id.tv_item_fragment_share_item_digit_title)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemDigitTitle;
////                @BindView(R.id.iv_item_fragment_share_item_digit_user_pic)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                ImageView ivItemFragmentShareItemDigitUserPic;
////                @BindView(R.id.tv_item_fragment_share_item_digit_username)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemDigitUsername;
////                @BindView(R.id.tv_item_fragment_share_item_digit_browse_number)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemDigitBrowseNumber;
////                @BindView(R.id.iv_item_fragment_share_item_digit_title_pic_one)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                ImageView ivItemFragmentShareItemDigitTitlePicOne;
////                @BindView(R.id.tv_item_fragment_share_item_digit_cowrie_number)
//                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic = (ImageView) convertView.findViewById(R.id.iv_item_fragment_share_item_live_telecast_user_pic);
////                TextView tvItemFragmentShareItemDigitCowrieNumber;
//
//                viewHolder.llItemFragmentShareItemDigit = (LinearLayout) convertView.findViewById(R.id.ll_item_fragment_share_item_digit);


                viewHolder = new ViewHolder(convertView);
                //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
                convertView.setTag(viewHolder);
            } else {
                Log.e(TAG, "getView: " + "----011");
                viewHolder = (ViewHolder) convertView.getTag();
            }

            Log.e(TAG, "getView: " + "适配器数据设置");


            Log.e(TAG, "getView: ------------------"+data.get(position).get("tag").toString().trim() );
            if (data.get(position).get("tag") == LIVE_TELECASE) {
                hideItemLayout();
                viewHolder.llItemFragmentShareItemLiveTelecast.setVisibility(View.VISIBLE);

                Log.e(TAG, "getView: "+"直播界面数据设置成功" );
                viewHolder.ivItemFragmentShareItemLiveTelecastUserPic.setImageResource((Integer) data.get(position).get("userPic"));
                viewHolder.tvItemFragmentShareItemLiveTelecastUsername.setText((String) data.get(position).get("username"));
                viewHolder.tvItemFragmentShareItemLiveTelecastUserAddress.setText((String) data.get(position).get("userAddress"));
                viewHolder.ivItemFragmentShareItemLiveTelecastTitlePicOne.setImageResource((Integer) data.get(position).get("titlePicOne"));
                viewHolder.tvItemFragmentShareItemLiveTelecastIdentifying.setText((String) data.get(position).get("userIdentifying"));
                viewHolder.tvItemFragmentShareItemLiveTelecastTitle.setText((String) data.get(position).get("title"));
                viewHolder.tvItemFragmentShareItemLiveTelecastCowrieClassify.setText((String) data.get(position).get("cowrieClassify"));
                viewHolder.tvItemFragmentShareItemLiveTelecastTitleExplain.setText((String) data.get(position).get("titleExplain"));


            } else if (data.get(position).get("tag") == ATTENTION) {
                hideItemLayout();
                viewHolder.llItemFragmentShareItemAttention.setVisibility(View.VISIBLE);

                Log.e(TAG, "getView: "+"关注界面数据设置成功" );
                viewHolder.ivItemFragmentShareItemAttentionUserPic.setImageResource((Integer) data.get(position).get("userPic"));
                viewHolder.tvItemFragmentShareItemAttentionUsername.setText((String) data.get(position).get("username"));
                viewHolder.tvItemFragmentShareItemAttentionBrowseNumber.setText((String) data.get(position).get("browseNumber"));
                viewHolder.ivItemFragmentShareItemAttentionTitlePicOne.setImageResource((Integer) data.get(position).get("titlePicOne"));
                Log.e(TAG, "getView: " +data.get(position).get("cowriePrice"));
                viewHolder.tvItemFragmentShareItemAttentionCowriePrice.setText(String.valueOf(data.get(position).get("cowriePrice")));
                viewHolder.tvItemFragmentShareItemAttentionTitle.setText((String) data.get(position).get("title"));
            } else if (data.get(position).get("tag") == INVENTORY) {
                hideItemLayout();
                viewHolder.llItemFragmentShareItemInventory.setVisibility(View.VISIBLE);

                viewHolder.ivItemFragmentShareItemInventoryUserPic.setImageResource((Integer) data.get(position).get("userPic"));
                viewHolder.tvItemFragmentShareItemInventoryUsername.setText((String) data.get(position).get("username"));
                viewHolder.tvItemFragmentShareItemInventoryCowrieNumber.setText((String) data.get(position).get("cowrieNumber"));
                viewHolder.ivItemFragmentShareItemInventoryTitlePicOne.setImageResource((Integer) data.get(position).get("titlePicOne"));
                viewHolder.ivItemFragmentShareItemInventoryTitlePicTwo.setImageResource((Integer) data.get(position).get("titlePicTwo"));
                viewHolder.ivItemFragmentShareItemInventoryTitlePicThree.setImageResource((Integer) data.get(position).get("titlePicThree"));
                viewHolder.tvItemFragmentShareItemInventoryBrowseNumber.setText((String) data.get(position).get("browseNumber"));
                viewHolder.tvItemFragmentShareItemInventoryTitle.setText((String) data.get(position).get("title"));
                viewHolder.tvItemFragmentShareItemInventoryTitleExplain.setText((String) data.get(position).get("titleExplain"));


            } else if (data.get(position).get("tag") == CONSULT) {
                hideItemLayout();
                viewHolder.llItemFragmentShareItemConsult.setVisibility(View.VISIBLE);


                viewHolder.ivItemFragmentShareItemConsultUserPic.setImageResource((Integer) data.get(position).get("userPic"));
                viewHolder.tvItemFragmentShareItemConsultUsername.setText((String) data.get(position).get("username"));
                viewHolder.ivItemFragmentShareItemConsultTitlePicOne.setImageResource((Integer) data.get(position).get("titlePicOne"));
                viewHolder.tvItemFragmentShareItemConsultTitle.setText((String) data.get(position).get("title"));
                viewHolder.tvItemFragmentShareItemConsultUserIdentifying.setText((String) data.get(position).get("userIdentifying"));


            } else if (data.get(position).get("tag") == VIDEO_SHOPPING) {
                hideItemLayout();
                viewHolder.llItemFragmentShareItemVideoShopping.setVisibility(View.VISIBLE);


                viewHolder.ivItemFragmentShareItemVideoShoppingUserPic.setImageResource((Integer) data.get(position).get("userPic"));
                viewHolder.tvItemFragmentShareItemVideoShoppingUsername.setText((String) data.get(position).get("username"));
                viewHolder.tvItemFragmentShareItemVideoShoppingCowrieNumber.setText((String) data.get(position).get("cowrieNumber"));
                viewHolder.tvItemFragmentShareItemVideoShoppingBrowseNumber.setText((String) data.get(position).get("browseNumber"));
                viewHolder.tvItemFragmentShareItemVideoShoppingTitle.setText((String) data.get(position).get("title"));
                viewHolder.vvItemFragmentShareItemVideoShoppingVideo.setImageResource((Integer) data.get(position).get("titlePicOne"));


            } else if (data.get(position).get("tag") == GOOD_CARGO) {

                hideItemLayout();
                viewHolder.llItemFragmentShareItemGoodCargo.setVisibility(View.VISIBLE);

                viewHolder.ivItemFragmentShareItemGoodCargoTitlePicOne.setImageResource((Integer) data.get(position).get("titlePicOne"));
                viewHolder.tvItemFragmentShareItemGoodCargoBrowseNumber.setText((String) data.get(position).get("browseNumber"));
                viewHolder.tvItemFragmentShareItemGoodCargoTitle.setText((String) data.get(position).get("title"));
                viewHolder.tvItemFragmentShareItemGoodCargoTitleExplain.setText((String) data.get(position).get("titleExplain"));

            } else if (data.get(position).get("tag") == COMMUNITY) {
                hideItemLayout();
                viewHolder.llItemFragmentShareItemCommunity.setVisibility(View.VISIBLE);


                viewHolder.ivItemFragmentShareItemCommunityUserPic.setImageResource((Integer) data.get(position).get("userPic"));
                viewHolder.tvItemFragmentShareItemCommunityUsername.setText((String) data.get(position).get("username"));
                viewHolder.tvItemFragmentShareItemCommunityCowrieNumber.setText((String) data.get(position).get("cowrieNumber"));
                viewHolder.ivItemFragmentShareItemCommunityTitlePicOne.setImageResource((Integer) data.get(position).get("titlePicOne"));
                viewHolder.ivItemFragmentShareItemCommunityTitlePicTwo.setImageResource((Integer) data.get(position).get("titlePicTwo"));
                viewHolder.ivItemFragmentShareItemCommunityTitlePicThree.setImageResource((Integer) data.get(position).get("titlePicThree"));
                viewHolder.tvItemFragmentShareItemCommunityBrowseNumber.setText((String) data.get(position).get("browseNumber"));
                viewHolder.tvItemFragmentShareItemCommunityTitle.setText((String) data.get(position).get("title"));
                viewHolder.tvItemFragmentShareItemCommunityTitleExplain.setText((String) data.get(position).get("titleExplain"));
                viewHolder.tvItemFragmentShareItemCommunityUserIdentifying.setText((String) data.get(position).get("userIdentifying"));
                viewHolder.tvItemFragmentShareItemCommunityTime.setText((String) data.get(position).get("time"));

            } else if (data.get(position).get("tag") == LIFE) {
                hideItemLayout();
                viewHolder.llItemFragmentShareItemLife.setVisibility(View.VISIBLE);

                viewHolder.ivItemFragmentShareItemLifeUserPic.setImageResource((Integer) data.get(position).get("userPic"));
                viewHolder.tvItemFragmentShareItemLifeUsername.setText((String) data.get(position).get("username"));
                viewHolder.tvItemFragmentShareItemLifeCowrieNumber.setText((String) data.get(position).get("cowrieNumber"));
                viewHolder.ivItemFragmentShareItemLifeTitlePicOne.setImageResource((Integer) data.get(position).get("titlePicOne"));
                viewHolder.ivItemFragmentShareItemLifeTitlePicTwo.setImageResource((Integer) data.get(position).get("titlePicTwo"));
                viewHolder.ivItemFragmentShareItemLifeTitlePicThree.setImageResource((Integer) data.get(position).get("titlePicThree"));
                viewHolder.tvItemFragmentShareItemLifeBrowseNumber.setText((String) data.get(position).get("browseNumber"));
                viewHolder.tvItemFragmentShareItemLifeTitle.setText((String) data.get(position).get("title"));

            } else if (data.get(position).get("tag") == DIGIT) {

                hideItemLayout();
                viewHolder.llItemFragmentShareItemDigit.setVisibility(View.VISIBLE);

                viewHolder.ivItemFragmentShareItemDigitUserPic.setImageResource((Integer) data.get(position).get("userPic"));
                viewHolder.tvItemFragmentShareItemDigitUsername.setText((String) data.get(position).get("username"));
                viewHolder.tvItemFragmentShareItemDigitCowrieNumber.setText((String) data.get(position).get("cowrieNumber"));
                viewHolder.ivItemFragmentShareItemDigitTitlePicOne.setImageResource((Integer) data.get(position).get("titlePicOne"));
                viewHolder.tvItemFragmentShareItemDigitBrowseNumber.setText((String) data.get(position).get("browseNumber"));
                viewHolder.tvItemFragmentShareItemDigitTitle.setText((String) data.get(position).get("title"));


            }


            return convertView;
        }

        private void hideItemLayout() {
            viewHolder.llItemFragmentShareItemCommunity.setVisibility(View.GONE);
            viewHolder.llItemFragmentShareItemConsult.setVisibility(View.GONE);
            viewHolder.llItemFragmentShareItemDigit.setVisibility(View.GONE);
            viewHolder.llItemFragmentShareItemGoodCargo.setVisibility(View.GONE);
            viewHolder.llItemFragmentShareItemInventory.setVisibility(View.GONE);
            viewHolder.llItemFragmentShareItemLife.setVisibility(View.GONE);
            viewHolder.llItemFragmentShareItemLiveTelecast.setVisibility(View.GONE);
            viewHolder.llItemFragmentShareItemVideoShopping.setVisibility(View.GONE);
            viewHolder.llItemFragmentShareItemAttention.setVisibility(View.GONE);

        }


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
//                case R.id.iv_item_fragment_order_center_order_list_delete_order:
//                    synchronized (data) {
//                        for (int i = 0; i < data.size(); i++) {
//                            if (i == (Integer) v.getTag()) {
//                                data.remove(i);
//                            } else {
//
//                            }
//                        }
//                    }
//                    notifyDataSetChanged();
//                    break;
            }
        }

        class ViewHolder {
            @BindView(R.id.iv_item_fragment_share_item_live_telecast_user_pic)
            ImageView ivItemFragmentShareItemLiveTelecastUserPic;
            @BindView(R.id.tv_item_fragment_share_item_live_telecast_username)
            TextView tvItemFragmentShareItemLiveTelecastUsername;
            @BindView(R.id.tv_item_fragment_share_item_live_telecast_user_address)
            TextView tvItemFragmentShareItemLiveTelecastUserAddress;
            @BindView(R.id.iv_item_fragment_share_item_live_telecast_title_pic_one)
            ImageView ivItemFragmentShareItemLiveTelecastTitlePicOne;
            @BindView(R.id.tv_item_fragment_share_item_live_telecast_identifying)
            TextView tvItemFragmentShareItemLiveTelecastIdentifying;
            @BindView(R.id.tv_item_fragment_share_item_live_telecast_title)
            TextView tvItemFragmentShareItemLiveTelecastTitle;
            @BindView(R.id.tv_item_fragment_share_item_live_telecast_cowrie_classify)
            TextView tvItemFragmentShareItemLiveTelecastCowrieClassify;
            @BindView(R.id.tv_item_fragment_share_item_live_telecast_title_explain)
            TextView tvItemFragmentShareItemLiveTelecastTitleExplain;
            @BindView(R.id.ll_item_fragment_share_item_live_telecast)
            LinearLayout llItemFragmentShareItemLiveTelecast;
            @BindView(R.id.tv_item_fragment_share_item_attention_title)
            TextView tvItemFragmentShareItemAttentionTitle;
            @BindView(R.id.iv_item_fragment_share_item_attention_user_pic)
            ImageView ivItemFragmentShareItemAttentionUserPic;
            @BindView(R.id.tv_item_fragment_share_item_attention_username)
            TextView tvItemFragmentShareItemAttentionUsername;
            @BindView(R.id.tv_item_fragment_share_item_attention_browse_number)
            TextView tvItemFragmentShareItemAttentionBrowseNumber;
            @BindView(R.id.iv_item_fragment_share_item_attention_title_pic_one)
            ImageView ivItemFragmentShareItemAttentionTitlePicOne;
            @BindView(R.id.tv_item_fragment_share_item_attention_cowrie_price)
            TextView tvItemFragmentShareItemAttentionCowriePrice;
            @BindView(R.id.ll_item_fragment_share_item_attention)
            LinearLayout llItemFragmentShareItemAttention;
            @BindView(R.id.tv_item_fragment_share_item_inventory_title)
            TextView tvItemFragmentShareItemInventoryTitle;
            @BindView(R.id.tv_item_fragment_share_item_inventory_title_explain)
            TextView tvItemFragmentShareItemInventoryTitleExplain;
            @BindView(R.id.iv_item_fragment_share_item_inventory_title_pic_one)
            ImageView ivItemFragmentShareItemInventoryTitlePicOne;
            @BindView(R.id.iv_item_fragment_share_item_inventory_title_pic_two)
            ImageView ivItemFragmentShareItemInventoryTitlePicTwo;
            @BindView(R.id.iv_item_fragment_share_item_inventory_title_pic_three)
            ImageView ivItemFragmentShareItemInventoryTitlePicThree;
            @BindView(R.id.iv_item_fragment_share_item_inventory_user_pic)
            ImageView ivItemFragmentShareItemInventoryUserPic;
            @BindView(R.id.tv_item_fragment_share_item_inventory_username)
            TextView tvItemFragmentShareItemInventoryUsername;
            @BindView(R.id.tv_item_fragment_share_item_inventory_cowrie_number)
            TextView tvItemFragmentShareItemInventoryCowrieNumber;
            @BindView(R.id.tv_item_fragment_share_item_inventory_browse_number)
            TextView tvItemFragmentShareItemInventoryBrowseNumber;
            @BindView(R.id.ll_item_fragment_share_item_inventory)
            LinearLayout llItemFragmentShareItemInventory;
            @BindView(R.id.tv_item_fragment_share_item_consult_title)
            TextView tvItemFragmentShareItemConsultTitle;
            @BindView(R.id.iv_item_fragment_share_item_consult_user_pic)
            ImageView ivItemFragmentShareItemConsultUserPic;
            @BindView(R.id.tv_item_fragment_share_item_consult_username)
            TextView tvItemFragmentShareItemConsultUsername;
            @BindView(R.id.tv_item_fragment_share_item_consult_user_identifying)
            TextView tvItemFragmentShareItemConsultUserIdentifying;
            @BindView(R.id.iv_item_fragment_share_item_consult_title_pic_one)
            ImageView ivItemFragmentShareItemConsultTitlePicOne;
            @BindView(R.id.ll_item_fragment_share_item_consult)
            LinearLayout llItemFragmentShareItemConsult;
            @BindView(R.id.vv_item_fragment_share_item_video_shopping_video)
            ImageView vvItemFragmentShareItemVideoShoppingVideo;
            @BindView(R.id.tv_item_fragment_share_item_video_shopping_title)
            TextView tvItemFragmentShareItemVideoShoppingTitle;
            @BindView(R.id.iv_item_fragment_share_item_video_shopping_user_pic)
            ImageView ivItemFragmentShareItemVideoShoppingUserPic;
            @BindView(R.id.tv_item_fragment_share_item_video_shopping_username)
            TextView tvItemFragmentShareItemVideoShoppingUsername;
            @BindView(R.id.tv_item_fragment_share_item_video_shopping_browse_number)
            TextView tvItemFragmentShareItemVideoShoppingBrowseNumber;
            @BindView(R.id.tv_item_fragment_share_item_video_shopping_cowrie_number)
            TextView tvItemFragmentShareItemVideoShoppingCowrieNumber;
            @BindView(R.id.ll_item_fragment_share_item_video_shopping)
            LinearLayout llItemFragmentShareItemVideoShopping;
            @BindView(R.id.iv_item_fragment_share_item_good_cargo_title_pic_one)
            ImageView ivItemFragmentShareItemGoodCargoTitlePicOne;
            @BindView(R.id.tv_item_fragment_share_item_good_cargo_title)
            TextView tvItemFragmentShareItemGoodCargoTitle;
            @BindView(R.id.tv_item_fragment_share_item_good_cargo_title_explain)
            TextView tvItemFragmentShareItemGoodCargoTitleExplain;
            @BindView(R.id.tv_item_fragment_share_item_good_cargo_browse_number)
            TextView tvItemFragmentShareItemGoodCargoBrowseNumber;
            @BindView(R.id.ll_item_fragment_share_item_good_cargo)
            LinearLayout llItemFragmentShareItemGoodCargo;
            @BindView(R.id.iv_item_fragment_share_item_community_user_pic)
            ImageView ivItemFragmentShareItemCommunityUserPic;
            @BindView(R.id.tv_item_fragment_share_item_community_username)
            TextView tvItemFragmentShareItemCommunityUsername;
            @BindView(R.id.tv_item_fragment_share_item_community_user_identifying)
            TextView tvItemFragmentShareItemCommunityUserIdentifying;
            @BindView(R.id.tv_item_fragment_share_item_community_time)
            TextView tvItemFragmentShareItemCommunityTime;
            @BindView(R.id.tv_item_fragment_share_item_community_title)
            TextView tvItemFragmentShareItemCommunityTitle;
            @BindView(R.id.tv_item_fragment_share_item_community_title_explain)
            TextView tvItemFragmentShareItemCommunityTitleExplain;
            @BindView(R.id.iv_item_fragment_share_item_community_title_pic_one)
            ImageView ivItemFragmentShareItemCommunityTitlePicOne;
            @BindView(R.id.iv_item_fragment_share_item_community_title_pic_two)
            ImageView ivItemFragmentShareItemCommunityTitlePicTwo;
            @BindView(R.id.iv_item_fragment_share_item_community_title_pic_three)
            ImageView ivItemFragmentShareItemCommunityTitlePicThree;
            @BindView(R.id.tv_item_fragment_share_item_community_cowrie_number)
            TextView tvItemFragmentShareItemCommunityCowrieNumber;
            @BindView(R.id.tv_item_fragment_share_item_community_browse_number)
            TextView tvItemFragmentShareItemCommunityBrowseNumber;
            @BindView(R.id.ll_item_fragment_share_item_community)
            LinearLayout llItemFragmentShareItemCommunity;
            @BindView(R.id.tv_item_fragment_share_item_life_title)
            TextView tvItemFragmentShareItemLifeTitle;
            @BindView(R.id.iv_item_fragment_share_item_life_title_pic_one)
            ImageView ivItemFragmentShareItemLifeTitlePicOne;
            @BindView(R.id.iv_item_fragment_share_item_life_title_pic_two)
            ImageView ivItemFragmentShareItemLifeTitlePicTwo;
            @BindView(R.id.iv_item_fragment_share_item_life_title_pic_three)
            ImageView ivItemFragmentShareItemLifeTitlePicThree;
            @BindView(R.id.iv_item_fragment_share_item_life_user_pic)
            ImageView ivItemFragmentShareItemLifeUserPic;
            @BindView(R.id.tv_item_fragment_share_item_life_username)
            TextView tvItemFragmentShareItemLifeUsername;
            @BindView(R.id.tv_item_fragment_share_item_life_browse_number)
            TextView tvItemFragmentShareItemLifeBrowseNumber;
            @BindView(R.id.tv_item_fragment_share_item_life_cowrie_number)
            TextView tvItemFragmentShareItemLifeCowrieNumber;
            @BindView(R.id.ll_item_fragment_share_item_life)
            LinearLayout llItemFragmentShareItemLife;
            @BindView(R.id.tv_item_fragment_share_item_digit_title)
            TextView tvItemFragmentShareItemDigitTitle;
            @BindView(R.id.iv_item_fragment_share_item_digit_user_pic)
            ImageView ivItemFragmentShareItemDigitUserPic;
            @BindView(R.id.tv_item_fragment_share_item_digit_username)
            TextView tvItemFragmentShareItemDigitUsername;
            @BindView(R.id.tv_item_fragment_share_item_digit_browse_number)
            TextView tvItemFragmentShareItemDigitBrowseNumber;
            @BindView(R.id.iv_item_fragment_share_item_digit_title_pic_one)
            ImageView ivItemFragmentShareItemDigitTitlePicOne;
            @BindView(R.id.tv_item_fragment_share_item_digit_cowrie_number)
            TextView tvItemFragmentShareItemDigitCowrieNumber;
            @BindView(R.id.ll_item_fragment_share_item_digit)
            LinearLayout llItemFragmentShareItemDigit;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }


//         class ViewHolder {
//            ImageView ivItemFragmentShareItemLiveTelecastUserPic;
//            TextView tvItemFragmentShareItemLiveTelecastUsername;
//            TextView tvItemFragmentShareItemLiveTelecastUserAddress;
//            ImageView ivItemFragmentShareItemLiveTelecastTitlePicOne;
//            TextView tvItemFragmentShareItemLiveTelecastIdentifying;
//            TextView tvItemFragmentShareItemLiveTelecastTitle;
//            TextView tvItemFragmentShareItemLiveTelecastCowrieClassify;
//            TextView tvItemFragmentShareItemLiveTelecastTitleExplain;
//            LinearLayout llItemFragmentShareItemLiveTelecast;
//            TextView tvItemFragmentShareItemAttentionTitle;
//            ImageView ivItemFragmentShareItemAttentionUserPic;
//            TextView tvItemFragmentShareItemAttentionUsername;
//            TextView tvItemFragmentShareItemAttentionBrowseNumber;
//            ImageView ivItemFragmentShareItemAttentionTitlePicOne;
//            TextView tvItemFragmentShareItemAttentionCowriePrice;
//            LinearLayout llItemFragmentShareItemAttention;
//            TextView tvItemFragmentShareItemInventoryTitle;
//            TextView tvItemFragmentShareItemInventoryTitleExplain;
//            ImageView ivItemFragmentShareItemInventoryTitlePicOne;
//            ImageView ivItemFragmentShareItemInventoryTitlePicTwo;
//            ImageView ivItemFragmentShareItemInventoryTitlePicThree;
//            ImageView ivItemFragmentShareItemInventoryUserPic;
//            TextView tvItemFragmentShareItemInventoryUsername;
//            TextView tvItemFragmentShareItemInventoryCowrieNumber;
//            TextView tvItemFragmentShareItemInventoryBrowseNumber;
//            LinearLayout llItemFragmentShareItemInventory;
//            TextView tvItemFragmentShareItemConsultTitle;
//            ImageView ivItemFragmentShareItemConsultUserPic;
//            TextView tvItemFragmentShareItemConsultUsername;
//            TextView tvItemFragmentShareItemConsultUserIdentifying;
//            ImageView ivItemFragmentShareItemConsultTitlePicOne;
//            LinearLayout llItemFragmentShareItemConsult;
//            ImageView vvItemFragmentShareItemVideoShoppingVideo;
//            TextView tvItemFragmentShareItemVideoShoppingTitle;
//            ImageView ivItemFragmentShareItemVideoShoppingUserPic;
//            TextView tvItemFragmentShareItemVideoShoppingUsername;
//            TextView tvItemFragmentShareItemVideoShoppingBrowseNumber;
//            TextView tvItemFragmentShareItemVideoShoppingCowrieNumber;
//            LinearLayout llItemFragmentShareItemVideoShopping;
//            ImageView ivItemFragmentShareItemGoodCargoTitlePicOne;
//            TextView tvItemFragmentShareItemGoodCargoTitle;
//            TextView tvItemFragmentShareItemGoodCargoTitleExplain;
//            TextView tvItemFragmentShareItemGoodCargoBrowseNumber;
//            LinearLayout llItemFragmentShareItemGoodCargo;
//            ImageView ivItemFragmentShareItemCommunityUserPic;
//            TextView tvItemFragmentShareItemCommunityUsername;
//            TextView tvItemFragmentShareItemCommunityUserIdentifying;
//            TextView tvItemFragmentShareItemCommunityTime;
//            TextView tvItemFragmentShareItemCommunityTitle;
//            TextView tvItemFragmentShareItemCommunityTitleExplain;
//            ImageView ivItemFragmentShareItemCommunityTitlePicOne;
//            ImageView ivItemFragmentShareItemCommunityTitlePicTwo;
//            ImageView ivItemFragmentShareItemCommunityTitlePicThree;
//            TextView tvItemFragmentShareItemCommunityCowrieNumber;
//            TextView tvItemFragmentShareItemCommunityBrowseNumber;
//            LinearLayout llItemFragmentShareItemCommunity;
//            TextView tvItemFragmentShareItemLifeTitle;
//            ImageView ivItemFragmentShareItemLifeTitlePicOne;
//            ImageView ivItemFragmentShareItemLifeTitlePicTwo;
//            ImageView ivItemFragmentShareItemLifeTitlePicThree;
//            ImageView ivItemFragmentShareItemLifeUserPic;
//            TextView tvItemFragmentShareItemLifeUsername;
//            TextView tvItemFragmentShareItemLifeBrowseNumber;
//            TextView tvItemFragmentShareItemLifeCowrieNumber;
//            LinearLayout llItemFragmentShareItemLife;
//            TextView tvItemFragmentShareItemDigitTitle;
//            ImageView ivItemFragmentShareItemDigitUserPic;
//            TextView tvItemFragmentShareItemDigitUsername;
//            TextView tvItemFragmentShareItemDigitBrowseNumber;
//            ImageView ivItemFragmentShareItemDigitTitlePicOne;
//            TextView tvItemFragmentShareItemDigitCowrieNumber;
//            LinearLayout llItemFragmentShareItemDigit;
//
//        }
    }

}
