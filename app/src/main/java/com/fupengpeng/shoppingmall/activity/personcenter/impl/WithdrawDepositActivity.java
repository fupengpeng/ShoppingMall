package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.fupengpeng.shoppingmall.MainActivity;
import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.activity.BaseActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.view.IWithdrawDepositView;
import com.fupengpeng.shoppingmall.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 提现余额界面
 */
public class WithdrawDepositActivity extends AppCompatActivity implements IWithdrawDepositView,View.OnClickListener{
    private static final String TAG = "WithdrawDepositActivity";
    /**
     * 返回个人中心界面
     */
    @BindView(R.id.iv_activity_withdraw_deposit_return)
    ImageView ivActivityWithdrawDepositReturn;
    /**
     * 分享
     */
    @BindView(R.id.iv_activity_withdraw_deposit_share)
    ImageView ivActivityWithdrawDepositShare;
    /**
     * 提现金额
     */
    @BindView(R.id.et_activity_withdraw_deposit_withdraw_deposit_sum)
    EditText etActivityWithdrawDepositWithdrawDepositSum;
    /**
     * 账户余额
     */
    @BindView(R.id.tv_activity_withdraw_deposit_account_remaining_sum)
    TextView tvActivityWithdrawDepositAccountRemainingSum;
    /**
     * 全部提现
     */
    @BindView(R.id.tv_activity_withdraw_deposit_withdraw_deposit_all)
    TextView tvActivityWithdrawDepositWithdrawDepositAll;
    /**
     * 确认提现
     */
    @BindView(R.id.btn_activity_withdraw_deposit_withdraw_deposit_affirm)
    Button btnActivityWithdrawDepositWithdrawDepositAffirm;

    Button btnItemActivityWithdrawDepositNotSufficientFundsReturn;

    private String withdrawDepositSum;
    private AlertDialog dialog;
    private Intent intent;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw_deposit);
        unbinder = ButterKnife.bind(this);
        initEditText();
        initDialog();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    private void initEditText() {
        etActivityWithdrawDepositWithdrawDepositSum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                withdrawDepositSum = etActivityWithdrawDepositWithdrawDepositSum.getText().toString().trim();
            }
        });

    }

    private void initDialog() {
        if (!(Double.parseDouble(tvActivityWithdrawDepositAccountRemainingSum.getText().toString()) >= 10)){
            AlertDialog.Builder builder = new AlertDialog.Builder(WithdrawDepositActivity.this);
            LayoutInflater inflater = getLayoutInflater();
            View viewDialog = inflater.inflate(R.layout.item_activity_withdraw_deposit_not_sufficient_funds, null);
            btnItemActivityWithdrawDepositNotSufficientFundsReturn = (Button) viewDialog.findViewById(R.id.btn_item_activity_withdraw_deposit_not_sufficient_funds_return);
            btnItemActivityWithdrawDepositNotSufficientFundsReturn.setOnClickListener(this);
            builder.setView(viewDialog);//添加自定义View
            builder.create();
            dialog = builder.show();
        }else {

        }



    }

    @OnClick({R.id.iv_activity_withdraw_deposit_return,
            R.id.iv_activity_withdraw_deposit_share,
            R.id.tv_activity_withdraw_deposit_withdraw_deposit_all,
            R.id.btn_activity_withdraw_deposit_withdraw_deposit_affirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_activity_withdraw_deposit_return:
                intent = new Intent(WithdrawDepositActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_activity_withdraw_deposit_share:
                ToastUtils.showLong(this, "分享待实现");
                break;
            case R.id.tv_activity_withdraw_deposit_withdraw_deposit_all:
                etActivityWithdrawDepositWithdrawDepositSum.setText(tvActivityWithdrawDepositAccountRemainingSum.getText());
                break;
            case R.id.btn_activity_withdraw_deposit_withdraw_deposit_affirm:

                if (!TextUtils.isEmpty(etActivityWithdrawDepositWithdrawDepositSum.getText().toString().trim())){
                    // TODO: 2017/6/13 0013  执行提现操作

                }else {
                    ToastUtils.showLong(WithdrawDepositActivity.this,"请输入提现金额");
                }

                ToastUtils.showLong(WithdrawDepositActivity.this,"确认提现");
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_item_activity_withdraw_deposit_not_sufficient_funds_return:
                intent = new Intent(WithdrawDepositActivity.this,MainActivity.class);
                startActivity(intent);
                dialog.dismiss();
                break;
        }
    }
}
