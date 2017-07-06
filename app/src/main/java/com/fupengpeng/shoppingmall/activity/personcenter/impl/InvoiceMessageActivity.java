package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.fupengpeng.shoppingmall.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fupengpeng on 2017/7/6 0006.
 * 设置发票信息界面
 */

public class InvoiceMessageActivity extends AppCompatActivity {

    @BindView(R.id.iv_title_activity_left)
    ImageView ivTitleActivityLeft;
    @BindView(R.id.tv_title_activity_title)
    TextView tvTitleActivityTitle;
    @BindView(R.id.tv_title_activity_right)
    TextView tvTitleActivityRight;
    @BindView(R.id.tv_activity_invoice_message_paper_invoice)
    TextView tvActivityInvoiceMessagePaperInvoice;
    @BindView(R.id.tv_activity_invoice_message_electron_invoice)
    TextView tvActivityInvoiceMessageElectronInvoice;
    @BindView(R.id.tv_activity_invoice_message_added_value_tax_invoice)
    TextView tvActivityInvoiceMessageAddedValueTaxInvoice;
    @BindView(R.id.cb_activity_invoice_message_personage)
    CheckBox cbActivityInvoiceMessagePersonage;
    @BindView(R.id.cb_activity_invoice_message_corporation)
    CheckBox cbActivityInvoiceMessageCorporation;
    @BindView(R.id.et_activity_invoice_message_name)
    EditText etActivityInvoiceMessageName;
    @BindView(R.id.et_activity_invoice_message_phone_number)
    EditText etActivityInvoiceMessagePhoneNumber;
    @BindView(R.id.et_activity_invoice_message_mailbox)
    EditText etActivityInvoiceMessageMailbox;
    @BindView(R.id.tv_activity_invoice_message_ex)
    TextView tvActivityInvoiceMessageEx;
    @BindView(R.id.cb_activity_invoice_message_un_books_particulars)
    CheckBox cbActivityInvoiceMessageUnBooksParticulars;
    @BindView(R.id.cb_activity_invoice_message_un_books_consumable)
    CheckBox cbActivityInvoiceMessageUnBooksConsumable;
    @BindView(R.id.cb_activity_invoice_message_un_books_office_supplies)
    CheckBox cbActivityInvoiceMessageUnBooksOfficeSupplies;
    @BindView(R.id.cb_activity_invoice_message_un_books_computer_fittings)
    CheckBox cbActivityInvoiceMessageUnBooksComputerFittings;
    @BindView(R.id.cb_activity_invoice_message_books_particulars)
    CheckBox cbActivityInvoiceMessageBooksParticulars;
    @BindView(R.id.cb_activity_invoice_message_books_book)
    CheckBox cbActivityInvoiceMessageBooksBook;
    @BindView(R.id.cb_activity_invoice_message_books_video)
    CheckBox cbActivityInvoiceMessageBooksVideo;
    @BindView(R.id.cb_activity_invoice_message_books_textbook)
    CheckBox cbActivityInvoiceMessageBooksTextbook;
    @BindView(R.id.cb_activity_invoice_message_books_data)
    CheckBox cbActivityInvoiceMessageBooksData;
    @BindView(R.id.btn_activity_invoice_message_confirm)
    Button btnActivityInvoiceMessageConfirm;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_invoice_message);
        ButterKnife.bind(this);

        tvTitleActivityTitle.setText("设置发票信息");
        ivTitleActivityLeft.setImageResource(R.drawable.ic_left_return_black_24dp);
        tvTitleActivityRight.setText("发票须知");


    }

    @OnClick({R.id.iv_title_activity_left,
            R.id.tv_title_activity_right,
            R.id.tv_activity_invoice_message_paper_invoice,
            R.id.tv_activity_invoice_message_electron_invoice,
            R.id.tv_activity_invoice_message_added_value_tax_invoice})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_title_activity_left:
                intent = new Intent(InvoiceMessageActivity.this,SettleAccountsActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_title_activity_right:
                // TODO: 2017/7/6 0006   popupwindow  待实现
                break;
            case R.id.tv_activity_invoice_message_paper_invoice:

                break;
            case R.id.tv_activity_invoice_message_electron_invoice:
                break;
            case R.id.tv_activity_invoice_message_added_value_tax_invoice:
                break;
        }
    }
}
