package com.fupengpeng.shoppingmall.util;

import android.os.AsyncTask;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

/**
 * 上下拉刷新工具
 */
public class PullToRefreshUtils {

    /**
     * 刷新完成
     *
     * @param refreshListView ListView
     */
    public static void refreshComplete(final PullToRefreshListView refreshListView) {
        new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String... params) {
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                refreshListView.onRefreshComplete();
            }
        }.execute();
    }

    /**
     * 刷新完成
     *
     * @param refreshScrollView ListView
     */
    public static void refreshComplete(final PullToRefreshScrollView refreshScrollView) {
        new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String... params) {
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                refreshScrollView.onRefreshComplete();
            }
        }.execute();
    }

    /**
     * 设置上下拉
     *
     * @param refreshListView ListView
     */
    public static void setPullBoth(PullToRefreshListView refreshListView) {
        // 设置PullToRefreshListView的模式
        refreshListView.setMode(PullToRefreshBase.Mode.BOTH);

        // 设置PullRefreshListView上提加载时的加载提示
        refreshListView.getLoadingLayoutProxy(false, true).setPullLabel("上拉加载...");
        refreshListView.getLoadingLayoutProxy(false, true).setRefreshingLabel("正在加载...");
        refreshListView.getLoadingLayoutProxy(false, true).setReleaseLabel("松开加载更多...");

        // 设置PullRefreshListView下拉加载时的加载提示
        refreshListView.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新...");
        refreshListView.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在加载...");
        refreshListView.getLoadingLayoutProxy(true, false).setReleaseLabel("松开加载更多...");
    }

    /**
     * 设置上下拉
     *
     * @param refreshListView ListView
     */
    public static void setPullFromStart(PullToRefreshListView refreshListView) {
        // 设置PullToRefreshListView的模式
        refreshListView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);

        // 设置PullRefreshListView上提加载时的加载提示
        refreshListView.getLoadingLayoutProxy(false, true).setPullLabel("上拉加载...");
        refreshListView.getLoadingLayoutProxy(false, true).setRefreshingLabel("正在加载...");
        refreshListView.getLoadingLayoutProxy(false, true).setReleaseLabel("松开加载更多...");
    }

    /**
     * 设置上下拉
     *
     * @param refreshScrollView ScrollView
     */
    public static void setPullFromStart(PullToRefreshScrollView refreshScrollView) {
        refreshScrollView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);

        // 设置PullRefreshListView上提加载时的加载提示
        refreshScrollView.getLoadingLayoutProxy(false, true).setPullLabel("上拉加载...");
        refreshScrollView.getLoadingLayoutProxy(false, true).setRefreshingLabel("正在加载...");
        refreshScrollView.getLoadingLayoutProxy(false, true).setReleaseLabel("松开加载更多...");
    }
}
