package com.fupengpeng.shoppingmall.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.activity.personcenter.impl.IntegralShoppingMallActivity;
import com.fupengpeng.shoppingmall.customerview.ScrollViewNestedGridView;
import com.fupengpeng.shoppingmall.entity.IntegralCommodityList;
import com.fupengpeng.shoppingmall.entity.IntegralCommodityObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 积分商城0元兑换Fragment
 */
public class IntegralShoppingMallZeroConversionFragment extends Fragment {


    Unbinder unbinder;
    @BindView(R.id.gv_fragment_integral_shopping_mall_zero_conversion)
    ScrollViewNestedGridView gvFragmentIntegralShoppingMallZeroConversion;


    /**
     * 数据对象列表
     */
    private IntegralCommodityList integralCommodityList;
    /**
     * 上下文
     */
    protected Context context = null;
    /**
     * 依附的MainActivity
     */
    protected Activity integralShoppingMallActivity = null;

    /**
     * 获取Fragment依赖的MainActivity
     *
     * @return
     */
    public Activity getIntegralShoppingMallActivity() {
        integralShoppingMallActivity = (IntegralShoppingMallActivity) getActivity();
        context = integralShoppingMallActivity;
        return integralShoppingMallActivity;
    }

    /**
     * 数据源
     */
    List<Map<String, Object>> list;
    /**
     * 适配器
     */
    IntegralShoppingMallZeroConversionFragmentAdapter integralShoppingMallZeroConversionFragmentAdapter;


    private View integralShoppingMallZeroConversionView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        integralShoppingMallZeroConversionView = inflater.inflate(R.layout.fragment_integral_shopping_mall_zero_conversion, container, false);
        unbinder = ButterKnife.bind(this, integralShoppingMallZeroConversionView);

        getIntegralShoppingMallActivity();
        parseData();

        list = getData();
        integralShoppingMallZeroConversionFragmentAdapter = new IntegralShoppingMallZeroConversionFragmentAdapter(getActivity(), list);
        gvFragmentIntegralShoppingMallZeroConversion.setAdapter(integralShoppingMallZeroConversionFragmentAdapter);
        return integralShoppingMallZeroConversionView;
    }

    /**
     * 根据数据对象设置适配器数据
     *
     * @return
     */
    private List<Map<String, Object>> getData() {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        for (int i = 0; i < integralCommodityList.getCommodityObjectList().size(); i++) {
            map = new HashMap<String, Object>();
            map.put("commodityPic", integralCommodityList.getCommodityObjectList().get(i).getCommodityPic());
            map.put("commodityName", integralCommodityList.getCommodityObjectList().get(i).getCommodityName());
            map.put("commodityIntegral", integralCommodityList.getCommodityObjectList().get(i).getCommodityIntegral());
            map.put("commodityTag", integralCommodityList.getCommodityObjectList().get(i).getCommodityTag());
            list.add(map);

        }
        return list;
    }

    /**
     * 数据对象获取
     */
    private void parseData() {
        integralCommodityList = new IntegralCommodityList();
        List<IntegralCommodityObject> integralCommodityObjects = new ArrayList<IntegralCommodityObject>();
        for (int i = 0; i < 20; i++) {
            IntegralCommodityObject integralCommodityObject = new IntegralCommodityObject();
            integralCommodityObject.setCommodityName("商品名：--0元兑换--" + i + "---");
            integralCommodityObject.setCommodityIntegral("积分：---" + i + "---");
            integralCommodityObject.setCommodityPic(R.drawable.nvshengtouxiang);
            integralCommodityObject.setCommodityTag("商品状态：---" + i + "---");
            integralCommodityObjects.add(integralCommodityObject);
        }
        integralCommodityList.setCommodityObjectList(integralCommodityObjects);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    static class IntegralShoppingMallZeroConversionFragmentAdapter extends BaseAdapter {

        public static final String ZERO_CONVERSION = "1000";

        private LayoutInflater mInflater = null;
        private Context context;
        private List<Map<String, Object>> data;

        public IntegralShoppingMallZeroConversionFragmentAdapter(Context context, List<Map<String, Object>> data) {
            //根据context上下文加载布局，这里的是Activity本身，即this
            this.mInflater = LayoutInflater.from(context);
            this.context = context;
            this.data = data;
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
                convertView = mInflater.inflate(R.layout.item_fragment_integral_shopping_mall, null);
                viewHolder = new ViewHolder(convertView);
                //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.ivItemFragmentIntegralShoppingMallCommodityPic.setImageResource((Integer) data.get(position).get("commodityPic"));
            viewHolder.tvItemFragmentIntegralShoppingMallCommodityName.setText((String) data.get(position).get("commodityName"));
            viewHolder.tvItemFragmentIntegralShoppingMallCommodityIntegral.setText((String) data.get(position).get("commodityIntegral"));
            viewHolder.tvItemFragmentIntegralShoppingMallCommodityTag.setText((String) data.get(position).get("commodityTag"));

            //判断订单状态，决定订单条目所要展示的订单状态栏的状态和条目按钮有哪些
            if (data.get(position).get("commodityTag").toString().equals(ZERO_CONVERSION)) {
                viewHolder.tvItemFragmentIntegralShoppingMallCommodityTag.setText("0元兑换");
            } else {
                viewHolder.tvItemFragmentIntegralShoppingMallCommodityTag.setText("抽奖");
            }


            return convertView;
        }

        //ViewHolder静态类
        static class ViewHolder {
            @BindView(R.id.iv_item_fragment_integral_shopping_mall_commodity_pic)
            ImageView ivItemFragmentIntegralShoppingMallCommodityPic;
            @BindView(R.id.tv_item_fragment_integral_shopping_mall_commodity_name)
            TextView tvItemFragmentIntegralShoppingMallCommodityName;
            @BindView(R.id.tv_item_fragment_integral_shopping_mall_commodity_integral)
            TextView tvItemFragmentIntegralShoppingMallCommodityIntegral;
            @BindView(R.id.tv_item_fragment_integral_shopping_mall_commodity_tag)
            TextView tvItemFragmentIntegralShoppingMallCommodityTag;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }

    }
}
