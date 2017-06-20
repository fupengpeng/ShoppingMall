package com.fupengpeng.shoppingmall.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.Window;

/**
 * Created by fupengpeng on 2017/5/25 0025.
 */

public class WaitDialog extends ProgressDialog {

    public WaitDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setCanceledOnTouchOutside(false);
        setProgressStyle(STYLE_SPINNER);
        setMessage("正在请求，请稍后…");
    }
}

