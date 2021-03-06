package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.customerview.LockPatternView;
import com.fupengpeng.shoppingmall.util.PreferenceUtil;


public class SetLockActivity extends AppCompatActivity {
    public static final String TAG = "SetLockActivity";

    private TextView mTitleTv;
    private LockPatternView mLockPatternView;
//    private LinearLayout mBottomLayout;
    private Button mClearBtn;
//    private Button mConfirmBtn;

    private String mPassword;
    /**
     * 是否是第一次输入密码
     */
    private boolean isFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_lock);

        Log.e(TAG, "onCreate: "+"003" );
        initViews();
        initEvents();
    }

    private void initEvents() {
        mLockPatternView.setLockListener(new LockPatternView.OnLockListener() {
            @Override
            public void getStringPassword(String password) {
                if (isFirst) {
                    Log.e(TAG, "getStringPassword: "+"设置锁屏密码" );
                    mPassword = password;
                    mTitleTv.setText("再次输入手势密码");
                    isFirst = false;
                    mClearBtn.setVisibility(View.VISIBLE);
                } else {
                    if (password.equals(mPassword)) {
                        setPasswordToPreference(password);
                        startActivity(new Intent(SetLockActivity.this, WithdrawDepositActivity.class));
                        Log.e(TAG, "getStringPassword: "+"密码设置成功" );
                        SetLockActivity.this.finish();
                    }else {
                        Toast.makeText(SetLockActivity.this,"两次密码不一致，请重新设置",Toast.LENGTH_SHORT).show();
                        mPassword = "";
                        Log.e(TAG, "getStringPassword: "+"密码设置失败重新设置密码" );
                        mTitleTv.setText("设置手势密码");
                        isFirst = false;
                        mClearBtn.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public boolean isPassword() {
                return false;
            }
        });

        mClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPassword = "";
                isFirst = true;
                mClearBtn.setVisibility(View.GONE);
            }
        });

    }

    private void setPasswordToPreference(String password) {
        PreferenceUtil.setGesturePassword(SetLockActivity.this, password);
    }

    private void initViews() {
        mTitleTv = (TextView) findViewById(R.id.tv_activity_set_lock_title);
        mLockPatternView = (LockPatternView) findViewById(R.id.lockView);
        mClearBtn = (Button) findViewById(R.id.btn_password_clear);
    }
}
