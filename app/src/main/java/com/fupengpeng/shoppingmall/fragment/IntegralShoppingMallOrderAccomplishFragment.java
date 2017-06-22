package com.fupengpeng.shoppingmall.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fupengpeng.shoppingmall.R;

import com.fupengpeng.shoppingmall.activity.personcenter.impl.IntegralShoppingMallOrderActivity;
import com.fupengpeng.shoppingmall.entity.OrderCenterOrderList;
import com.fupengpeng.shoppingmall.entity.OrderCenterOrderObject;
import com.fupengpeng.shoppingmall.util.PullToRefreshUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 积分商城已完成订单
 */
public class IntegralShoppingMallOrderAccomplishFragment extends Fragment {



    public static final String TAG = "IntegralShoppingMallOrderAllFragment";

    /**
     * 时间格式
     */
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
    /**
     * 上下文
     */
    protected Context context = null;
    /**
     * 依附的MainActivity
     */
    protected Activity integralShoppingMallOrderActivity = null;

    /**
     * 获取Fragment依赖的MainActivity
     *
     * @return
     */
    public Activity getIntegralShoppingMallOrderActivity() {
        integralShoppingMallOrderActivity = (IntegralShoppingMallOrderActivity) getActivity();
        context = integralShoppingMallOrderActivity;
        return integralShoppingMallOrderActivity;
    }
    /**
     * 当前页
     */
    private int currentPage;
    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 数据源对象
     */
    private OrderCenterOrderList orderCenterOrderList;
    /**
     * 数据源
     */
    List<Map<String, Object>> list;


    /**
     * Adapter
     */
    private IntegralShoppingMallOrderAccomplishFragmentAdapter integralShoppingMallOrderAccomplishFragmentAdapter;

    @BindView(R.id.ll_fragment_integral_shopping_mall_order_accomplish)
    LinearLayout llFragmentIntegralShoppingMallOrderAccomplish;
    @BindView(R.id.ptrlv_fragment_integral_shopping_mall_order_accomplish)
    PullToRefreshListView ptrlvFragmentIntegralShoppingMallOrderAccomplish;
    Unbinder unbinder;
    private View integralShoppingMallOrderAccomplishFragmentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        integralShoppingMallOrderAccomplishFragmentView = inflater.inflate(R.layout.fragment_integral_shopping_mall_order_accomplish, container, false);
        unbinder = ButterKnife.bind(this, integralShoppingMallOrderAccomplishFragmentView);


        getIntegralShoppingMallOrderActivity();
        parseData();
        // 初始化
        init();
        // 设置监听器
        setListeners();

        return integralShoppingMallOrderAccomplishFragmentView;
    }



    /**
     *
     * 根据数据对象设置适配器数据
     * @return
     */
    private List<Map<String, Object>> getData() {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        for (int i = 0; i < orderCenterOrderList.getOrderCenterOrderObjectList().size(); i++) {
            map = new HashMap<String, Object>();
            map.put("orderCenterOrderListOrderNumber", orderCenterOrderList.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListOrderNumber());
            map.put("orderCenterOrderListOrderState",orderCenterOrderList.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListOrderState());
            map.put("orderCenterOrderListCommodityPic", orderCenterOrderList.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListCommodityPic());
            map.put("orderCenterOrderListCommodityName", orderCenterOrderList.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListCommodityName());
            map.put("orderCenterOrderListCommodityQuantity", orderCenterOrderList.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListCommodityQuantity());
            map.put("orderCenterOrderListCommodityAggregatePrice", orderCenterOrderList.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListCommodityAggregatePrice());
            list.add(map);
        }
        return list;
    }

    /**
     * 数据对象获取
     */
    private void parseData() {
        orderCenterOrderList = new OrderCenterOrderList();
        List<OrderCenterOrderObject> orderCenterOrderObjects = new ArrayList<OrderCenterOrderObject>();
        for (int i = 0; i < 30; i++) {
            OrderCenterOrderObject orderCenterOrderObject = new OrderCenterOrderObject();
            orderCenterOrderObject.setOrderCenterOrderListOrderNumber("订单号：---" + i + "---");
            orderCenterOrderObject.setOrderCenterOrderListOrderState("订单状态：---"+i+"---");
            orderCenterOrderObject.setOrderCenterOrderListCommodityPic(R.drawable.nvshengtouxiang);
            orderCenterOrderObject.setOrderCenterOrderListCommodityName("商品名称：---" + i + "---");
            orderCenterOrderObject.setOrderCenterOrderListCommodityQuantity("商品数量：---" + i + "---");
            orderCenterOrderObject.setOrderCenterOrderListCommodityAggregatePrice("商品价格：---" + i + "---");
            orderCenterOrderObjects.add(orderCenterOrderObject);
        }
        orderCenterOrderList.setOrderCenterOrderObjectList(orderCenterOrderObjects);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 初始化
     */
    private void init() {
        // 绑定数据
        bindData();
        // 设置加载模式
        PullToRefreshUtils.setPullBoth(ptrlvFragmentIntegralShoppingMallOrderAccomplish);
        // 刷新数据
        refreshData(1);
    }

    /**
     * 设置监听器
     */
    private void setListeners() {
        // 刷新监听器
        ptrlvFragmentIntegralShoppingMallOrderAccomplish.setOnRefreshListener(new InnerOnRefreshListener2());
        // 子项点击监听器
        ptrlvFragmentIntegralShoppingMallOrderAccomplish.setOnItemClickListener(new InnerOnItemClickListener());
    }



    /**
     * 刷新监听器
     */
    private class InnerOnRefreshListener2 implements PullToRefreshBase.OnRefreshListener2 {
        @Override
        public void onPullDownToRefresh(PullToRefreshBase refreshView) {
            // 下拉刷新
            refreshData(1);

            OrderCenterOrderList ocola = new OrderCenterOrderList();
            List<OrderCenterOrderObject> orderCenterOrderObjects = new ArrayList<OrderCenterOrderObject>();
            for (int i = 0; i < 3; i++) {
                OrderCenterOrderObject orderCenterOrderObject = new OrderCenterOrderObject();
                orderCenterOrderObject.setOrderCenterOrderListOrderNumber("订单号：----下拉刷新----" + i + "--------");
                orderCenterOrderObject.setOrderCenterOrderListOrderState("订单状态：----下拉刷新----"+i+"--------");
                orderCenterOrderObject.setOrderCenterOrderListCommodityPic(R.drawable.nvshengtouxiang);
                orderCenterOrderObject.setOrderCenterOrderListCommodityName("商品名称：----下拉刷新----" + i + "--------");
                orderCenterOrderObject.setOrderCenterOrderListCommodityQuantity("商品数量：----下拉刷新----" + i + "--------");
                orderCenterOrderObject.setOrderCenterOrderListCommodityAggregatePrice("商品价格：----下拉刷新----" + i + "---------");
                orderCenterOrderObjects.add(orderCenterOrderObject);
            }
            ocola.setOrderCenterOrderObjectList(orderCenterOrderObjects);

            List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
            Map<String, Object> map;
            for (int i = 0; i < ocola.getOrderCenterOrderObjectList().size(); i++) {
                map = new HashMap<String, Object>();
                map.put("orderCenterOrderListOrderNumber", ocola.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListOrderNumber());
                map.put("orderCenterOrderListOrderState",ocola.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListOrderState());
                map.put("orderCenterOrderListCommodityPic", ocola.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListCommodityPic());
                map.put("orderCenterOrderListCommodityName", ocola.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListCommodityName());
                map.put("orderCenterOrderListCommodityQuantity", ocola.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListCommodityQuantity());
                map.put("orderCenterOrderListCommodityAggregatePrice", ocola.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListCommodityAggregatePrice());
                lista.add(map);
            }
            integralShoppingMallOrderAccomplishFragmentAdapter.addFirst(lista);
            new FinishRefresh().execute();
            integralShoppingMallOrderAccomplishFragmentAdapter.notifyDataSetChanged();
        }

        @Override
        public void onPullUpToRefresh(PullToRefreshBase refreshView) {


            totalPage = 5;
            // 判断是否还有更多数据
            if (currentPage >= totalPage) {
                Toast.makeText(getIntegralShoppingMallOrderActivity(), "没有更多数据", Toast.LENGTH_SHORT).show();
                // 加载完成
                PullToRefreshUtils.refreshComplete(ptrlvFragmentIntegralShoppingMallOrderAccomplish);
                return;
            }
            // 上拉加载
            currentPage++;
            refreshData(currentPage);

            OrderCenterOrderList ocola = new OrderCenterOrderList();
            List<OrderCenterOrderObject> orderCenterOrderObjects = new ArrayList<OrderCenterOrderObject>();
            for (int i = 0; i < 3; i++) {
                OrderCenterOrderObject orderCenterOrderObject = new OrderCenterOrderObject();
                orderCenterOrderObject.setOrderCenterOrderListOrderNumber("订单号：----上拉加载----" + i + "--------");
                orderCenterOrderObject.setOrderCenterOrderListOrderState("订单状态：----上拉加载----"+i+"--------");
                orderCenterOrderObject.setOrderCenterOrderListCommodityPic(R.drawable.nvshengtouxiang);
                orderCenterOrderObject.setOrderCenterOrderListCommodityName("商品名称：----上拉加载----" + i + "--------");
                orderCenterOrderObject.setOrderCenterOrderListCommodityQuantity("商品数量：----上拉加载----" + i + "--------");
                orderCenterOrderObject.setOrderCenterOrderListCommodityAggregatePrice("商品价格：----上拉加载----" + i + "---------");
                orderCenterOrderObjects.add(orderCenterOrderObject);
            }
            ocola.setOrderCenterOrderObjectList(orderCenterOrderObjects);

            List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
            Map<String, Object> map;
            for (int i = 0; i < ocola.getOrderCenterOrderObjectList().size(); i++) {
                map = new HashMap<String, Object>();
                map.put("orderCenterOrderListOrderNumber", ocola.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListOrderNumber());
                map.put("orderCenterOrderListOrderState",ocola.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListOrderState());
                map.put("orderCenterOrderListCommodityPic", ocola.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListCommodityPic());
                map.put("orderCenterOrderListCommodityName", ocola.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListCommodityName());
                map.put("orderCenterOrderListCommodityQuantity", ocola.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListCommodityQuantity());
                map.put("orderCenterOrderListCommodityAggregatePrice", ocola.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListCommodityAggregatePrice());
                lista.add(map);
            }
            integralShoppingMallOrderAccomplishFragmentAdapter.addLast(lista);
            new FinishRefresh().execute();
            integralShoppingMallOrderAccomplishFragmentAdapter.notifyDataSetChanged();
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
     * 绑定数据
     */
    private void bindData() {
        list = getData();
        if (list == null){
            llFragmentIntegralShoppingMallOrderAccomplish.setVisibility(View.VISIBLE);
            ptrlvFragmentIntegralShoppingMallOrderAccomplish.setVisibility(View.GONE);
        }else {
            llFragmentIntegralShoppingMallOrderAccomplish.setVisibility(View.GONE);
            ptrlvFragmentIntegralShoppingMallOrderAccomplish.setVisibility(View.VISIBLE);
            integralShoppingMallOrderAccomplishFragmentAdapter = new IntegralShoppingMallOrderAccomplishFragmentAdapter(context,list);
            ptrlvFragmentIntegralShoppingMallOrderAccomplish.setAdapter(integralShoppingMallOrderAccomplishFragmentAdapter);
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
        protected void onPostExecute(Void result){
            integralShoppingMallOrderAccomplishFragmentAdapter.notifyDataSetChanged();
            ptrlvFragmentIntegralShoppingMallOrderAccomplish.onRefreshComplete();
        }
    }


    static class IntegralShoppingMallOrderAccomplishFragmentAdapter extends BaseAdapter implements View.OnClickListener{
        public static final String TAG = "OrderCenterAllFragmentAdapter";
        public static final String ORDER_STATE_WAIT_SHIPMENTS = "1000";
        public static final String ORDER_STATE_WAIT_RECEIVING = "2000";
        public static final String ORDER_STATE_ACCOMPLISH = "3000";


        private LayoutInflater mInflater = null;
        private Context context;
        private List<Map<String, Object>> data;

        public IntegralShoppingMallOrderAccomplishFragmentAdapter(Context context, List<Map<String, Object>> data) {
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
                convertView = mInflater.inflate(R.layout.item_fragment_order_center_order_list, null);


                viewHolder = new ViewHolder(convertView);
                //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }



            viewHolder.tvItemFragmentOrderCenterOrderListOrderNumber.setText((String) data.get(position).get("orderCenterOrderListOrderNumber"));
            viewHolder.ivItemFragmentOrderCenterOrderListCommodityPic.setImageResource((Integer) data.get(position).get("orderCenterOrderListCommodityPic"));
            viewHolder.tvItemFragmentOrderCenterOrderListCommodityName.setText((String) data.get(position).get("orderCenterOrderListCommodityName"));
            viewHolder.tvItemFragmentOrderCenterOrderListCommodityQuantity.setText((String) data.get(position).get("orderCenterOrderListCommodityQuantity"));
            viewHolder.tvItemFragmentOrderCenterOrderListCommodityAggregatePrice.setText((String) data.get(position).get("orderCenterOrderListCommodityAggregatePrice"));

            //判断订单状态，决定订单条目所要展示的订单状态栏的状态和条目按钮有哪些
            if (data.get(position).get("orderCenterOrderListOrderState").toString().equals(ORDER_STATE_ACCOMPLISH)) {
                viewHolder.tvItemFragmentOrderCenterOrderListOrderState.setText("已完成");
                viewHolder.btnItemFragmentOrderCenterOrderListOne.setVisibility(View.GONE);
                viewHolder.btnItemFragmentOrderCenterOrderListTwo.setVisibility(View.VISIBLE);
                viewHolder.btnItemFragmentOrderCenterOrderListThree.setVisibility(View.VISIBLE);
            } else if (data.get(position).get("orderCenterOrderListOrderState").toString().equals(ORDER_STATE_WAIT_SHIPMENTS)) {
                viewHolder.tvItemFragmentOrderCenterOrderListOrderState.setText("待发货");
                viewHolder.btnItemFragmentOrderCenterOrderListThree.setText("提醒发货");
                viewHolder.btnItemFragmentOrderCenterOrderListOne.setVisibility(View.GONE);
                viewHolder.btnItemFragmentOrderCenterOrderListTwo.setVisibility(View.VISIBLE);
                viewHolder.btnItemFragmentOrderCenterOrderListThree.setVisibility(View.VISIBLE);
            } else if (data.get(position).get("orderCenterOrderListOrderState").toString().equals(ORDER_STATE_WAIT_RECEIVING)) {
                viewHolder.tvItemFragmentOrderCenterOrderListOrderState.setText("待收货");
                viewHolder.btnItemFragmentOrderCenterOrderListOne.setVisibility(View.GONE);
                viewHolder.btnItemFragmentOrderCenterOrderListTwo.setVisibility(View.VISIBLE);
                viewHolder.btnItemFragmentOrderCenterOrderListThree.setVisibility(View.VISIBLE);

            }

            viewHolder.tvItemFragmentOrderCenterOrderListOrderNumberExplain.setTag(position);
            viewHolder.tvItemFragmentOrderCenterOrderListOrderNumber.setTag(position);
            viewHolder.tvItemFragmentOrderCenterOrderListOrderState.setTag(position);
            viewHolder.ivItemFragmentOrderCenterOrderListDeleteOrder.setTag(position);
            viewHolder.ivItemFragmentOrderCenterOrderListCommodityPic.setTag(position);
            viewHolder.tvItemFragmentOrderCenterOrderListCommodityName.setTag(position);
            viewHolder.tvItemFragmentOrderCenterOrderListCommodityQuantity.setTag(position);
            viewHolder.tvItemFragmentOrderCenterOrderListCommodityPay.setTag(position);
            viewHolder.tvItemFragmentOrderCenterOrderListCommodityAggregatePrice.setTag(position);
            viewHolder.vItemFragmentOrderCenterOrderListBlank.setTag(position);
            viewHolder.btnItemFragmentOrderCenterOrderListOne.setTag(position);
            viewHolder.btnItemFragmentOrderCenterOrderListTwo.setTag(position);
            viewHolder.btnItemFragmentOrderCenterOrderListThree.setTag(position);


            viewHolder.tvItemFragmentOrderCenterOrderListOrderNumberExplain.setOnClickListener((View.OnClickListener) context);
            viewHolder.tvItemFragmentOrderCenterOrderListOrderNumber.setOnClickListener((View.OnClickListener) context);
            viewHolder.tvItemFragmentOrderCenterOrderListOrderState.setOnClickListener((View.OnClickListener) context);
            viewHolder.ivItemFragmentOrderCenterOrderListDeleteOrder.setOnClickListener(this);
            viewHolder.ivItemFragmentOrderCenterOrderListCommodityPic.setOnClickListener((View.OnClickListener) context);
            viewHolder.tvItemFragmentOrderCenterOrderListCommodityName.setOnClickListener((View.OnClickListener) context);
            viewHolder.tvItemFragmentOrderCenterOrderListCommodityQuantity.setOnClickListener((View.OnClickListener) context);
            viewHolder.tvItemFragmentOrderCenterOrderListCommodityPay.setOnClickListener((View.OnClickListener) context);
            viewHolder.tvItemFragmentOrderCenterOrderListCommodityAggregatePrice.setOnClickListener((View.OnClickListener) context);
            viewHolder.vItemFragmentOrderCenterOrderListBlank.setOnClickListener((View.OnClickListener) context);
            viewHolder.btnItemFragmentOrderCenterOrderListOne.setOnClickListener((View.OnClickListener) context);
            viewHolder.btnItemFragmentOrderCenterOrderListTwo.setOnClickListener((View.OnClickListener) context);
            viewHolder.btnItemFragmentOrderCenterOrderListThree.setOnClickListener((View.OnClickListener) context);


            return convertView;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.iv_item_fragment_order_center_order_list_delete_order:
                    synchronized (data) {
                        for (int i = 0; i < data.size(); i++) {
                            if (i == (Integer) v.getTag()) {
                                data.remove(i);
                            } else {

                            }
                        }
                    }
                    notifyDataSetChanged();
                    break;
            }
        }


        //ViewHolder静态类
        static class ViewHolder {
            /**
             * 订单号文本
             */
            @BindView(R.id.tv_item_fragment_order_center_order_list_order_number_explain)
            TextView tvItemFragmentOrderCenterOrderListOrderNumberExplain;
            /**
             * 订单号
             */
            @BindView(R.id.tv_item_fragment_order_center_order_list_order_number)
            TextView tvItemFragmentOrderCenterOrderListOrderNumber;
            /**
             * 订单状态
             */
            @BindView(R.id.tv_item_fragment_order_center_order_list_order_state)
            TextView tvItemFragmentOrderCenterOrderListOrderState;
            /**
             * 删除订单
             */
            @BindView(R.id.iv_item_fragment_order_center_order_list_delete_order)
            ImageView ivItemFragmentOrderCenterOrderListDeleteOrder;
            /**
             * 订单商品图片
             */
            @BindView(R.id.iv_item_fragment_order_center_order_list_commodity_pic)
            ImageView ivItemFragmentOrderCenterOrderListCommodityPic;
            /**
             * 订单商品名称
             */
            @BindView(R.id.tv_item_fragment_order_center_order_list_commodity_name)
            TextView tvItemFragmentOrderCenterOrderListCommodityName;
            /**
             * 订单商品数量
             */
            @BindView(R.id.tv_item_fragment_order_center_order_list_commodity_quantity)
            TextView tvItemFragmentOrderCenterOrderListCommodityQuantity;
            /**
             * 订单商品付款文本
             */
            @BindView(R.id.tv_item_fragment_order_center_order_list_commodity_pay)
            TextView tvItemFragmentOrderCenterOrderListCommodityPay;
            /**
             * 订单商品付款额
             */
            @BindView(R.id.tv_item_fragment_order_center_order_list_commodity_aggregate_price)
            TextView tvItemFragmentOrderCenterOrderListCommodityAggregatePrice;
            /**
             * 按钮前空隙
             */
            @BindView(R.id.v_item_fragment_order_center_order_list_blank)
            View vItemFragmentOrderCenterOrderListBlank;
            /**
             * 订单操作001
             */
            @BindView(R.id.btn_item_fragment_order_center_order_list_one)
            Button btnItemFragmentOrderCenterOrderListOne;
            /**
             * 订单操作002
             */
            @BindView(R.id.btn_item_fragment_order_center_order_list_two)
            Button btnItemFragmentOrderCenterOrderListTwo;
            /**
             * 订单操作003
             */
            @BindView(R.id.btn_item_fragment_order_center_order_list_three)
            Button btnItemFragmentOrderCenterOrderListThree;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
                btnItemFragmentOrderCenterOrderListOne.setVisibility(View.GONE);
            }
        }
    }
}
