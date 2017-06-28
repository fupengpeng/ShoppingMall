package com.fupengpeng.shoppingmall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.entity.ClassifyParentData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 要显示的adapter
 */
public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<ClassifyParentData> list;
    private LayoutInflater mInflater = null;
    private int selectedPos = -1;
    private int mSelectedBackgroundResource;//选中item时的背景颜色
    private int mNormalBackgroundResource;//为选中的背景颜色
    private boolean hasDivider = true;

    public void setSelectedBackgroundResource(int mSelectedBackgroundResource) {
        this.mSelectedBackgroundResource = mSelectedBackgroundResource;
    }

    public void setNormalBackgroundResource(int mNormalBackgroundResource) {
        this.mNormalBackgroundResource = mNormalBackgroundResource;
    }

    public void setHasDivider(boolean hasDivider) {
        this.hasDivider = hasDivider;
    }

    public ListViewAdapter(Context mContext, List<ClassifyParentData> list) {
        this.mInflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.list = list;
    }


    //选中的position,及时更新数据
    public void setSelectedPos(int selectedPos) {
        this.selectedPos = selectedPos;
        notifyDataSetChanged();
    }

    public void setData(List<ClassifyParentData> data) {
        this.list = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list == null ? null : list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        //如果缓存convertView为空，则需要创建View
        if (convertView == null) {
            //根据自定义的Item布局加载布局
            convertView = mInflater.inflate(R.layout.item_fragment_classify_list_view_parent, null);


            viewHolder = new ViewHolder(convertView);
            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ClassifyParentData classifyParentData = list.get(position);
        viewHolder.tvItemFragmentClassifyListViewParentTitle.setText(classifyParentData.name);//设置标题

        convertView.setSelected(selectedPos == position);//设置选中时的view
        viewHolder.tvItemFragmentClassifyListViewParentTitle.setSelected(selectedPos == position);

        //选中后的标题字体颜色
        viewHolder.tvItemFragmentClassifyListViewParentTitle.setTextColor(selectedPos == position ? 0xFFba55d3 : 0xFF333333);
        //选中与未选中的背景色
        if (mNormalBackgroundResource == 0)
            mNormalBackgroundResource = R.color.white;

        if (mSelectedBackgroundResource != 0)
            viewHolder.tvItemFragmentClassifyListViewParentLy.setBackgroundResource(selectedPos == position ? mSelectedBackgroundResource : mNormalBackgroundResource);

        //隐藏view
        viewHolder.tvItemFragmentClassifyListViewParentDivider.setVisibility(hasDivider ? View.VISIBLE : View.INVISIBLE);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_item_fragment_classify_list_view_parent_title)
        TextView tvItemFragmentClassifyListViewParentTitle;
        @BindView(R.id.tv_item_fragment_classify_list_view_parent_divider)
        TextView tvItemFragmentClassifyListViewParentDivider;
        @BindView(R.id.tv_item_fragment_classify_list_view_parent_ly)
        LinearLayout tvItemFragmentClassifyListViewParentLy;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }




}
