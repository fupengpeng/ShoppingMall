package com.fupengpeng.shoppingmall.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fupengpeng.shoppingmall.R;

/**
 * 主界面Fragment
 */
public class HomeFragment extends Fragment {

    View homeFragmentView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        homeFragmentView = inflater.inflate(R.layout.fragment_home, container, false);
        return homeFragmentView;
    }

}
