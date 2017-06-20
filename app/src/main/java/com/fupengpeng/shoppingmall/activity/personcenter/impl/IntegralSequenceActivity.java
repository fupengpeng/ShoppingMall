package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.entity.IntegralSequenceList;
import com.fupengpeng.shoppingmall.entity.IntegralSequenceObject;
import com.fupengpeng.shoppingmall.util.PullToRefreshUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 积分榜界面
 */
public class IntegralSequenceActivity extends AppCompatActivity {

    private static final String TAG = "IntegralSequenceActivity";
    @BindView(R.id.tv_activity_integral_sequence_integral)
    TextView tvActivityIntegralSequenceIntegral;
    @BindView(R.id.tv_activity_integral_sequence_ranking)
    TextView tvActivityIntegralSequenceRanking;
    @BindView(R.id.ptrlv_activity_integral_sequence)
    PullToRefreshListView ptrlvActivityIntegralSequence;

    private IntegralSequenceActivityAdapter integralSequenceActivityAdapter;

    private IntegralSequenceList integralSequenceList;


    /**
     * 数据源
     */
    List<Map<String, Object>> list;
    private int totalPage;
    private int currentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integral_sequence);
        ButterKnife.bind(this);

        parseData();
        // 初始化
        init();
        // 设置监听器
        setListeners();

    }



    /**
     * 根据数据对象设置适配器数据
     *
     * @return
     */
    private List<Map<String, Object>> getData() {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        for (int i = 0; i < integralSequenceList.getIntegralSequenceObjectList().size(); i++) {
            map = new HashMap<String, Object>();
            map.put("integralSequenceRanking", integralSequenceList.getIntegralSequenceObjectList().get(i).getIntegralSequenceRanking());
            map.put("integralSequenceUserPic", integralSequenceList.getIntegralSequenceObjectList().get(i).getIntegralSequenceUserPic());
            map.put("integralSequenceUsername", integralSequenceList.getIntegralSequenceObjectList().get(i).getIntegralSequenceUsername());
            map.put("integralSequenceRankingPic", integralSequenceList.getIntegralSequenceObjectList().get(i).getIntegralSequenceRankingPic());
            map.put("integralSequenceIntegral", integralSequenceList.getIntegralSequenceObjectList().get(i).getIntegralSequenceIntegral());
            list.add(map);
        }
        return list;
    }
    /**
     * 数据对象获取
     */
    private void parseData() {
        integralSequenceList = new IntegralSequenceList();
        List<IntegralSequenceObject> integralSequenceObjects = new ArrayList<IntegralSequenceObject>();
        for (int i = 0; i < 20; i++) {
            IntegralSequenceObject integralSequenceObject = new IntegralSequenceObject();
            integralSequenceObject.setIntegralSequenceRanking("用户名次：--" + i + "--");
            integralSequenceObject.setIntegralSequenceUserPic(R.drawable.nvshengtouxiang);
            integralSequenceObject.setIntegralSequenceUsername("用户名：--" + i + "--");
            integralSequenceObject.setIntegralSequenceRankingPic(R.drawable.nvshengtouxiang);
            integralSequenceObject.setIntegralSequenceIntegral("积分：--" + i + "--");
            integralSequenceObjects.add(integralSequenceObject);
        }
        integralSequenceList.setIntegralSequenceObjectList(integralSequenceObjects);

    }


    /**
     * 初始化
     */
    private void init() {
        // 绑定数据
        bindData();
        // 设置加载模式
        PullToRefreshUtils.setPullBoth(ptrlvActivityIntegralSequence);
        // 刷新数据
        refreshData(1);
    }

    /**
     * 设置监听器
     */
    private void setListeners() {
        // 刷新监听器
        ptrlvActivityIntegralSequence.setOnRefreshListener(new InnerOnRefreshListener2());
        // 子项点击监听器
        ptrlvActivityIntegralSequence.setOnItemClickListener(new InnerOnItemClickListener());
    }

    /**
     * 刷新监听器
     */
    private class InnerOnRefreshListener2 implements PullToRefreshBase.OnRefreshListener2 {



        @Override
        public void onPullDownToRefresh(PullToRefreshBase refreshView) {
            // 下拉刷新
//            refreshData(1);
//            Log.e(TAG, "onPullDownToRefresh: " + "----004");
//
//            IntegralSequenceList isl = new IntegralSequenceList();
//            List<IntegralSequenceObject> isos = new ArrayList<IntegralSequenceObject>();
//            for (int i = 0; i < 5; i++) {
//                IntegralSequenceObject iso = new IntegralSequenceObject();
//                iso.setIntegralSequenceRanking(i);
//                iso.setIntegralSequenceUserPic(R.drawable.nvshengtouxiang);
//                iso.setIntegralSequenceUsername("用户名：----下拉刷新----" + i + "--------");
//                iso.setIntegralSequenceRankingPic(R.drawable.nvshengtouxiang);
//                iso.setIntegralSequenceIntegral(i);
//                isos.add(iso);
//            }
//            isl.setIntegralSequenceObjectList(isos);
//            Log.e(TAG, "parseData: " + isl.getIntegralSequenceObjectList().get(2).getIntegralSequenceUsername().toString().trim());
//
//            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//            Map<String, Object> map;
//            for (int i = 0; i < isl.getIntegralSequenceObjectList().size(); i++) {
//                map = new HashMap<String, Object>();
//                map.put("integralSequenceRanking", isl.getIntegralSequenceObjectList().get(i).getIntegralSequenceRanking());
//                map.put("integralSequenceUserPic", isl.getIntegralSequenceObjectList().get(i).getIntegralSequenceUserPic());
//                map.put("integralSequenceUsername", isl.getIntegralSequenceObjectList().get(i).getIntegralSequenceUsername());
//                map.put("integralSequenceRankingPic", isl.getIntegralSequenceObjectList().get(i).getIntegralSequenceRankingPic());
//                map.put("integralSequenceIntegral", isl.getIntegralSequenceObjectList().get(i).getIntegralSequenceIntegral());
//                list.add(map);
//            }
//
//            integralSequenceActivityAdapter.addFirst(list);
//            new FinishRefresh().execute();
//            integralSequenceActivityAdapter.notifyDataSetChanged();
        }

        @Override
        public void onPullUpToRefresh(PullToRefreshBase refreshView) {


            totalPage = 5;
            // 判断是否还有更多数据
            if (currentPage >= totalPage) {
                Toast.makeText(IntegralSequenceActivity.this, "没有更多数据", Toast.LENGTH_SHORT).show();
                // 加载完成
                PullToRefreshUtils.refreshComplete(ptrlvActivityIntegralSequence);
                return;
            }
            // 上拉加载
            currentPage++;
            refreshData(currentPage);

            IntegralSequenceList isl = new IntegralSequenceList();
            List<IntegralSequenceObject> isos = new ArrayList<IntegralSequenceObject>();
            for (int i = 0; i < 5; i++) {
                IntegralSequenceObject iso = new IntegralSequenceObject();
                iso.setIntegralSequenceRanking("用户名次：--" + i + "--");
                iso.setIntegralSequenceUserPic(R.drawable.nvshengtouxiang);
                iso.setIntegralSequenceUsername("用户名：--上拉加载--" + i + "--");
                iso.setIntegralSequenceRankingPic(R.drawable.nvshengtouxiang);
                iso.setIntegralSequenceIntegral("积分：--" + i + "--");
                isos.add(iso);
            }
            isl.setIntegralSequenceObjectList(isos);

            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map;
            for (int i = 0; i < isl.getIntegralSequenceObjectList().size(); i++) {
                map = new HashMap<String, Object>();
                map.put("integralSequenceRanking", isl.getIntegralSequenceObjectList().get(i).getIntegralSequenceRanking());
                map.put("integralSequenceUserPic", isl.getIntegralSequenceObjectList().get(i).getIntegralSequenceUserPic());
                map.put("integralSequenceUsername", isl.getIntegralSequenceObjectList().get(i).getIntegralSequenceUsername());
                map.put("integralSequenceRankingPic", isl.getIntegralSequenceObjectList().get(i).getIntegralSequenceRankingPic());
                map.put("integralSequenceIntegral", isl.getIntegralSequenceObjectList().get(i).getIntegralSequenceIntegral());
                list.add(map);
            }
            integralSequenceActivityAdapter.addLast(list);
            new FinishRefresh().execute();
            integralSequenceActivityAdapter.notifyDataSetChanged();
        }
    }
    /**
     * 绑定数据
     */
    private void bindData() {
        list = getData();
        if (list == null){
            ptrlvActivityIntegralSequence.setVisibility(View.GONE);
        }else {
            ptrlvActivityIntegralSequence.setVisibility(View.VISIBLE);
            integralSequenceActivityAdapter = new IntegralSequenceActivityAdapter(this, list);
            ptrlvActivityIntegralSequence.setAdapter(integralSequenceActivityAdapter);
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
            integralSequenceActivityAdapter.notifyDataSetChanged();
            ptrlvActivityIntegralSequence.onRefreshComplete();
        }
    }









    class IntegralSequenceActivityAdapter extends BaseAdapter {

        public static final String TAG = "OrderCenterAllFragmentAdapter";

        private LayoutInflater mInflater = null;
        private Context context;
        private List<Map<String, Object>> data;

        public IntegralSequenceActivityAdapter(Context context, List<Map<String, Object>> data) {
            //根据context上下文加载布局，这里的是Activity本身，即this
            this.mInflater = LayoutInflater.from(context);
            this.context = context;
            this.data = data;
        }


        /**
         * 下拉刷新加载数据
         *
         * @param list
         */
        public void addFirst(List<Map<String, Object>> list) {
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
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            //如果缓存convertView为空，则需要创建View
            if (convertView == null) {
                //根据自定义的Item布局加载布局
                convertView = mInflater.inflate(R.layout.item_activity_integral_sequence, null);

                viewHolder = new ViewHolder(convertView);
                //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }


            viewHolder.tvItemActivityIntegralSequenceRanking.setText((String) data.get(position).get("integralSequenceRanking"));
            viewHolder.ivItemActivityIntegralSequenceUserPic.setImageResource((Integer) data.get(position).get("integralSequenceUserPic"));
            viewHolder.tvItemActivityIntegralSequenceUsername.setText((String) data.get(position).get("integralSequenceUsername"));
            viewHolder.ivItemActivityIntegralSequenceRankingPic.setImageResource((Integer) data.get(position).get("integralSequenceRankingPic"));
            viewHolder.tvItemActivityIntegralSequenceIntegral.setText((String) data.get(position).get("integralSequenceIntegral"));

            // TODO: 2017/6/13 0013  存在bug待研究解决
            if (position == 0){
                viewHolder.tvItemActivityIntegralSequenceRanking.setTextColor(0xffff0000);
                viewHolder.tvItemActivityIntegralSequenceUsername.setTextColor(0xffeeeeee);
                viewHolder.ivItemActivityIntegralSequenceRankingPic.setImageResource(R.drawable.nvshengtouxiangxiaoqingxin);
            }else if (position == 1){
                viewHolder.tvItemActivityIntegralSequenceRanking.setTextColor(0xffeeeeee);
                viewHolder.ivItemActivityIntegralSequenceRankingPic.setImageResource(R.drawable.magua);
            }else if (position == 2){
                viewHolder.tvItemActivityIntegralSequenceRanking.setTextColor(0xffcc00ee);
                viewHolder.ivItemActivityIntegralSequenceRankingPic.setImageResource(R.drawable.laoshu);
            }else {

            }

            return convertView;
        }


        class ViewHolder {
            @BindView(R.id.tv_item_activity_integral_sequence_ranking)
            TextView tvItemActivityIntegralSequenceRanking;
            @BindView(R.id.iv_item_activity_integral_sequence_user_pic)
            ImageView ivItemActivityIntegralSequenceUserPic;
            @BindView(R.id.tv_item_activity_integral_sequence_username)
            TextView tvItemActivityIntegralSequenceUsername;
            @BindView(R.id.iv_item_activity_integral_sequence_ranking_pic)
            ImageView ivItemActivityIntegralSequenceRankingPic;
            @BindView(R.id.tv_item_activity_integral_sequence_integral)
            TextView tvItemActivityIntegralSequenceIntegral;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
