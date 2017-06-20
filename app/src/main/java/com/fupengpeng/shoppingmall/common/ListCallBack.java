package com.fupengpeng.shoppingmall.common;

import java.util.List;

/**
 * 数据集回调
 */
public interface ListCallBack<T> {

    /**
     * 当操作成功时，调用该方法
     *
     * @param datas
     */
    void onSuccess(List<T> datas);

    /**
     * 当操作失败时，调用该方法
     *
     * @param e
     */
    void onFail(Exception e);
}
