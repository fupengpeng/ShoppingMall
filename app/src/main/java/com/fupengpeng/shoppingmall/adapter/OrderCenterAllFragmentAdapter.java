package com.fupengpeng.shoppingmall.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.fupengpeng.shoppingmall.R;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 适配器
 */
public class OrderCenterAllFragmentAdapter extends BaseAdapter implements View.OnClickListener{

    public static final String TAG = "OrderCenterAllFragmentAdapter";
    public static final String ORDER_STATE_WAIT_PAYMENT = "1000";
    public static final String ORDER_STATE_WAIT_SHIPMENTS = "2000";
    public static final String ORDER_STATE_WAIT_RECEIVING = "3000";
    public static final String ORDER_STATE_WAIT_EVALUATION = "4000";
    public static final String ORDER_STATE_WAIT_PICKING = "5000";
    public static final String ORDER_STATE_REFUND_AFTER_SALES = "6000";

    private LayoutInflater mInflater = null;
    private Context context;
    private List<Map<String, Object>> data;

    public OrderCenterAllFragmentAdapter(Context context, List<Map<String, Object>> data) {
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
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.e(TAG, "getView: " + "----009");
        ViewHolder viewHolder = null;
        //如果缓存convertView为空，则需要创建View
        if (convertView == null) {
            Log.e(TAG, "getView: " + "----010");
            //根据自定义的Item布局加载布局
            convertView = mInflater.inflate(R.layout.item_fragment_order_center_order_list, null);


            viewHolder = new ViewHolder(convertView);
            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(viewHolder);
        } else {
            Log.e(TAG, "getView: " + "----011");
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Log.e(TAG, "getView: " + "适配器数据设置");



        viewHolder.tvItemFragmentOrderCenterOrderListOrderNumber.setText((String) data.get(position).get("orderCenterOrderListOrderNumber"));
        viewHolder.ivItemFragmentOrderCenterOrderListCommodityPic.setImageResource((Integer) data.get(position).get("orderCenterOrderListCommodityPic"));
        viewHolder.tvItemFragmentOrderCenterOrderListCommodityName.setText((String) data.get(position).get("orderCenterOrderListCommodityName"));
        viewHolder.tvItemFragmentOrderCenterOrderListCommodityQuantity.setText((String) data.get(position).get("orderCenterOrderListCommodityQuantity"));
        viewHolder.tvItemFragmentOrderCenterOrderListCommodityAggregatePrice.setText((String) data.get(position).get("orderCenterOrderListCommodityAggregatePrice"));

        //判断订单状态，决定订单条目所要展示的订单状态栏的状态和条目按钮有哪些
        if (data.get(position).get("orderCenterOrderListOrderState").toString().equals(ORDER_STATE_WAIT_PAYMENT)){
            viewHolder.tvItemFragmentOrderCenterOrderListOrderState.setText("待付款");
            viewHolder.btnItemFragmentOrderCenterOrderListOne.setVisibility(View.GONE);
            viewHolder.btnItemFragmentOrderCenterOrderListTwo.setVisibility(View.VISIBLE);
            viewHolder.btnItemFragmentOrderCenterOrderListThree.setVisibility(View.VISIBLE);
        }else if (data.get(position).get("orderCenterOrderListOrderState").toString().equals(ORDER_STATE_WAIT_SHIPMENTS)){
            viewHolder.tvItemFragmentOrderCenterOrderListOrderState.setText("待发货");
            viewHolder.btnItemFragmentOrderCenterOrderListThree.setText("提醒发货");
            viewHolder.btnItemFragmentOrderCenterOrderListOne.setVisibility(View.GONE);
            viewHolder.btnItemFragmentOrderCenterOrderListTwo.setVisibility(View.VISIBLE);
            viewHolder.btnItemFragmentOrderCenterOrderListThree.setVisibility(View.VISIBLE);
        }else if (data.get(position).get("orderCenterOrderListOrderState").toString().equals(ORDER_STATE_WAIT_RECEIVING)){
            viewHolder.tvItemFragmentOrderCenterOrderListOrderState.setText("待收货");
            viewHolder.btnItemFragmentOrderCenterOrderListOne.setVisibility(View.GONE);
            viewHolder.btnItemFragmentOrderCenterOrderListTwo.setVisibility(View.VISIBLE);
            viewHolder.btnItemFragmentOrderCenterOrderListThree.setVisibility(View.VISIBLE);

        }else if (data.get(position).get("orderCenterOrderListOrderState").toString().equals(ORDER_STATE_WAIT_EVALUATION)){
            viewHolder.tvItemFragmentOrderCenterOrderListOrderState.setText("已完成");
            viewHolder.btnItemFragmentOrderCenterOrderListOne.setVisibility(View.GONE);
            viewHolder.btnItemFragmentOrderCenterOrderListTwo.setVisibility(View.VISIBLE);
            viewHolder.btnItemFragmentOrderCenterOrderListThree.setVisibility(View.VISIBLE);
        }else if (data.get(position).get("orderCenterOrderListOrderState").toString().equals(ORDER_STATE_WAIT_PICKING)){
            viewHolder.tvItemFragmentOrderCenterOrderListOrderState.setText("待提货");
            viewHolder.btnItemFragmentOrderCenterOrderListOne.setVisibility(View.GONE);
            viewHolder.btnItemFragmentOrderCenterOrderListTwo.setVisibility(View.VISIBLE);
            viewHolder.btnItemFragmentOrderCenterOrderListThree.setVisibility(View.VISIBLE);
        }else if (data.get(position).get("orderCenterOrderListOrderState").toString().equals(ORDER_STATE_REFUND_AFTER_SALES)){
            viewHolder.tvItemFragmentOrderCenterOrderListOrderState.setText("已完成");
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

