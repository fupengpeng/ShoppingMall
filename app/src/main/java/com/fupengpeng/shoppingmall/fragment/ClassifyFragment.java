package com.fupengpeng.shoppingmall.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.adapter.ListViewAdapter;
import com.fupengpeng.shoppingmall.entity.ClassifyParentData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 分类Fragment
 */
public class ClassifyFragment extends Fragment {


    @BindView(R.id.lv_fragment_classify_parent)
    ListView lvFragmentClassifyParent;
    @BindView(R.id.lv_fragment_classify_child)
    ListView lvFragmentClassifyChild;

    private static final String TAG = "ClassifyFragment";
    private View view1,view2;
    private ListViewAdapter mListViewParentAdapter, mListViewChildAdapter;
    private List<View> views = new ArrayList<View>();
    
    
    Unbinder unbinder;
    private View classifyFragmentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        classifyFragmentView = inflater.inflate(R.layout.fragment_classify, container, false);
        unbinder = ButterKnife.bind(this, classifyFragmentView);

        initViews();

        return classifyFragmentView;
    }

    private void initViews() {



        //一级
        List<ClassifyParentData> listParent= new ArrayList<ClassifyParentData>();

        ClassifyParentData cl = new ClassifyParentData(0,"不限",0);
        listParent.add(cl);
        for (int i = 0; i < 30; i++) {
            int j = i+1;
            ClassifyParentData classifyParentData = new ClassifyParentData();
            classifyParentData.setId(j);
            classifyParentData.setName("商品分类"+j);
            classifyParentData.setFlag(j);
            listParent.add(classifyParentData);
        }

        mListViewParentAdapter = new ListViewAdapter(getActivity(), listParent);
        mListViewParentAdapter.setSelectedBackgroundResource(R.color.white);//选中时
        mListViewParentAdapter.setHasDivider(false);
        mListViewParentAdapter.setNormalBackgroundResource(R.color.menudialog_bg_gray);//未选中
        lvFragmentClassifyParent.setAdapter(mListViewParentAdapter);// 一级菜单的listview适配器

        views.add(view1);
        views.add(view2);//加载了一二级菜单


        lvFragmentClassifyParent.setOnItemClickListener(new AdapterView.OnItemClickListener() {//一级菜单的listview子条目点击事件
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mListViewParentAdapter != null){
                    mListViewParentAdapter.setSelectedPos(position);
                }

                if (mListViewChildAdapter != null){
                    mListViewChildAdapter.setSelectedPos(-1);
                }



                ClassifyParentData classifyParentData = (ClassifyParentData) parent.getItemAtPosition(position);

                if (classifyParentData.id == 0) {//不限
                    if (mListViewChildAdapter != null) {
                        mListViewChildAdapter.setData(new ArrayList<ClassifyParentData>());
                        mListViewChildAdapter.notifyDataSetChanged();
                    }

                    // TODO: 2017/6/28 0028  ;//直接返回展示所有的商品
                } else {

                    List<ClassifyParentData> listChild= new ArrayList<ClassifyParentData>();

                    for (int i = 0; i < 30; i++) {
                        ClassifyParentData classifyChildData = new ClassifyParentData();
                        classifyChildData.setId(i);
                        classifyChildData.setName("分类下的商品"+i);
                        classifyChildData.setFlag(i);
                        listChild.add(classifyChildData);
                    }

                    if (mListViewChildAdapter == null) {
                        mListViewChildAdapter = new ListViewAdapter(getActivity(), listChild);
                        mListViewChildAdapter.setNormalBackgroundResource(R.color.white);
                        lvFragmentClassifyChild.setAdapter(mListViewChildAdapter);//二级菜单listview的适配器
                    } else {
                        mListViewChildAdapter.setData(listChild);
                        mListViewChildAdapter.notifyDataSetChanged();
                    }
                }
            }
        });



        //二级
        lvFragmentClassifyChild.setOnItemClickListener(new AdapterView.OnItemClickListener() {//二级菜单listview子条目的点击事件
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                if (mListViewChildAdapter != null) {
                    mListViewChildAdapter.setSelectedPos(position);
                    mListViewChildAdapter.setSelectedBackgroundResource(R.color.white);//选中时
                    ClassifyParentData classifyParentData = (ClassifyParentData) parent.getItemAtPosition(position);
                    // TODO: 2017/6/28 0028 跳转至商品详情界面 
                }
            }
        });


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
