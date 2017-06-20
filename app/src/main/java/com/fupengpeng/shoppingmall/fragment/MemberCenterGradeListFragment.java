package com.fupengpeng.shoppingmall.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fupengpeng.shoppingmall.R;


/**
 * 会员等级列表
 */
public class MemberCenterGradeListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_member_center_grade_list, container, false);
    }


}
