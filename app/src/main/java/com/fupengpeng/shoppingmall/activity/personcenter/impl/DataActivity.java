package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.activity.personcenter.view.IDataView;
import com.fupengpeng.shoppingmall.util.ToastUtils;
import com.lljjcoder.citypickerview.widget.CityPicker;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 资料完善界面
 */
public class DataActivity extends AppCompatActivity implements IDataView {
    public static final String TAG = "DataActivity";

    /**
     * 姓名
     */
    @BindView(R.id.et_activity_data_username)
    EditText etActivityDataUsername;
    /**
     * 所在地
     */
    @BindView(R.id.tv_activity_data_province_city)
    TextView tvActivityDataProvinceCity;
    /**
     * 微信号
     */
    @BindView(R.id.et_activity_data_we_chat)
    EditText etActivityDataWeChat;
    /**
     * 确定
     */
    @BindView(R.id.btn_activity_data_confirm)
    Button btnActivityDataConfirm;
    /**
     * 男
     */
    @BindView(R.id.rbtn_activity_data_male)
    RadioButton rbtnActivityDataMale;
    /**
     * 女
     */
    @BindView(R.id.rbtn_activity_data_female)
    RadioButton rbtnActivityDataFemale;
    /**
     * 性别
     */
    @BindView(R.id.rg_activity_data_sex)
    RadioGroup rgActivityDataSex;
    /**
     * 生日
     */
    @BindView(R.id.tv_activity_data_birthday)
    TextView tvActivityDataBirthday;
    /**
     * 返回资料修改界面
     */
    @BindView(R.id.iv_title_activity_left)
    ImageView ivTitleActivityLeft;
    /**
     * 标题
     */
    @BindView(R.id.tv_title_activity_title)
    TextView tvTitleActivityTitle;



    private String sex;
    private String provinceCity;
    private String username;
    private String birthday;
    private String weChat;
    private Intent intent;

    // 记录当前的时间
    private int mYear;
    private int mMonth;
    private int mDay;
    private DatePickerDialog datePickerDialog;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        unbinder = ButterKnife.bind(this);
        tvTitleActivityTitle.setText("完善会员资料");
        ivTitleActivityLeft.setImageResource(R.drawable.ic_left_return_black_24dp);
        etActivityDataUsername.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                username = etActivityDataUsername.getText().toString().trim();
//                        Log.e(TAG, "afterTextChanged: "+username );
            }
        });
//                String sex = String.valueOf(rbtnActivityDataMale.isChecked());
        if (rbtnActivityDataMale.isChecked()) {
            sex = "男";
        } else {
            sex = "女";
        }
        provinceCity = tvActivityDataProvinceCity.getText().toString().trim();

        etActivityDataWeChat.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                weChat = etActivityDataWeChat.getText().toString().trim();
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @OnClick({R.id.tv_activity_data_province_city,
            R.id.btn_activity_data_confirm,
            R.id.tv_activity_data_birthday,
            R.id.iv_title_activity_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_activity_data_province_city:
                setSelectAddress(this);
                break;
            case R.id.btn_activity_data_confirm:
                setConfirm();
                break;
            case R.id.tv_activity_data_birthday:
                setBirthday();

                break;
            case R.id.iv_title_activity_left:
                intent = new Intent(DataActivity.this, InformationEditActivity.class);
                startActivity(intent);
                break;

        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }




    @Override
    public void setSelectAddress(Context context) {
        CityPicker cityPicker = new CityPicker.Builder(context)
                .textSize(14)
                .title("地址选择")
                .titleBackgroundColor("#ffffff")
                .confirTextColor("#696969")
                .cancelTextColor("#696969")
                .province("山东省")
                .city("济宁市")
                .textColor(Color.parseColor("#000000"))
                .provinceCyclic(true)
                .cityCyclic(false)
                .visibleItemsCount(7)
                .itemPadding(10)
                .onlyShowProvinceAndCity(true)
                .build();
        cityPicker.show();
        //监听方法，获取选择结果
        cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
            @Override
            public void onSelected(String... citySelected) {
                //省份
                String province = citySelected[0];
                //城市
                String city = citySelected[1];
                //邮编
                String code = citySelected[3];
                //为TextView赋值
                tvActivityDataProvinceCity.setText(province.trim() + "  " + city.trim());
            }
        });
    }

    @Override
    public void setConfirm() {
        // TODO: 2017/6/6 确认修改 待实现

        ToastUtils.showLong(this, "姓名：" + username + "   性别：" + sex + "    所在地：" + provinceCity + "    生日：" + birthday + "    微信号：" + weChat);

        intent = new Intent(DataActivity.this, InformationEditActivity.class);
        startActivity(intent);
    }

    @Override
    public void setBirthday() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            datePickerDialog = new DatePickerDialog(this);
        }
        datePickerDialog.show();

        // 获取当前的年月日，小时，分钟
        Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);

        // 设置文本的内容：
        tvActivityDataBirthday.setText(new StringBuilder().append(mYear).append("年")
                .append(mMonth + 1).append("月")// 得到的月份+1，因为从0开始
                .append(mDay).append("日"));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    mYear = year;
                    mMonth = month;
                    mDay = dayOfMonth;

                    birthday = new String(new StringBuilder().append(mYear)
                            .append("年").append(mMonth + 1).append("月")// 得到的月份+1，因为从0开始
                            .append(mDay).append("日"));
                    // 设置文本的内容：
                    tvActivityDataBirthday.setText(birthday);
                }
            });
        }
    }
}
