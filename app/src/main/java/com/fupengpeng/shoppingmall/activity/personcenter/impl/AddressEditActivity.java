package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.activity.personcenter.view.IAddressEditView;
import com.fupengpeng.shoppingmall.adapter.AddressEditAdapter;
import com.fupengpeng.shoppingmall.customerview.AddressEditPopupWindow;
import com.fupengpeng.shoppingmall.customerview.EditAddressEditPopupWindow;
import com.fupengpeng.shoppingmall.entity.ShippingAddress;
import com.fupengpeng.shoppingmall.util.ToastUtils;

import java.util.LinkedList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 地址管理界面
 */
public class AddressEditActivity extends AppCompatActivity
        implements IAddressEditView,
        AdapterView.OnItemClickListener,
        View.OnClickListener {
    public static final String TAG = "AddressEditActivity";

    /**
     * 返回
     */
    @BindView(R.id.iv_title_activity_left)
    ImageView ivTitleActivityLeft;
    /**
     * 地址列表
     */
    @BindView(R.id.lv_activity_address_edit_list)
    ListView lvActivityAddressEditList;
    /**
     * 添加地址
     */
    @BindView(R.id.btn_activity_address_edit_add)
    Button btnActivityAddressEditAdd;
    /**
     * 一键获取微信地址
     */
    @BindView(R.id.btn_activity_address_edit_obtain)
    Button btnActivityAddressEditObtain;
    /**
     * 标题
     */
    @BindView(R.id.tv_title_activity_title)
    TextView tvTitleActivityTitle;


    /**
     * 地址数据列表
     */
    private LinkedList<ShippingAddress> shippingAddressList;


    /**
     * 添加地址的popupwindow
     */
    AddressEditPopupWindow addressEditPopupWindow;

    /**
     * 修改地址的popupwindow
     */
    EditAddressEditPopupWindow editAddressEditPopupWindow;
    /**
     * 删除地址的dialog
     */
    private AlertDialog dialog;
    /**
     * 确认删除
     */
    private Button btn_affirm;
    /**
     * 取消删除
     */
    private Button btn_cancle;
    /**
     * 适配器
     */
    private AddressEditAdapter addressEditAdapter;

    /**
     * 接收popupwindow返回的收货地址数据
     */
    private String username;
    private String phoneNumber;
    private String addressProvinceCity;
    private String addressStreet;
    private String postCode;

    /**
     * 手机号的正则判断              SettleAccountsActivity
     */
    private String telRegex;
    private Intent intent;

    /**
     * 所点击条目的position
     */
    int viewTag;

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_edit);
        unbinder = ButterKnife.bind(this);

        tvTitleActivityTitle.setText("资料编辑");
        ivTitleActivityLeft.setImageResource(R.drawable.ic_left_return_black_24dp);
        /**
         * 模拟地址数据
         */
        getShippingAddressList();

        addressEditAdapter = new AddressEditAdapter(this, shippingAddressList);

        lvActivityAddressEditList.setAdapter(addressEditAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    /**
     * 模拟地址数据
     */
    private void getShippingAddressList() {
        shippingAddressList = new LinkedList<ShippingAddress>();

        ShippingAddress shippingAddress01 = new ShippingAddress();
        shippingAddress01.setUsername("张三--" + 01);
        shippingAddress01.setPhoneNumber("11111111--" + 01);
        shippingAddress01.setArea("山东省" + "-济宁市" + "-任城区");
        shippingAddress01.setDetailedAddress("诗仙路25号");
        shippingAddress01.setZipCode("123456");
        shippingAddress01.setDefault(true);

        ShippingAddress shippingAddress02 = new ShippingAddress();
        shippingAddress02.setUsername("张三--" + 02);
        shippingAddress02.setPhoneNumber("11111111--" + 02);
        shippingAddress02.setArea("山东省" + "-济宁市" + "-任城区");
        shippingAddress02.setDetailedAddress("诗仙路25号");
        shippingAddress02.setZipCode("123456");
        shippingAddress02.setDefault(false);

        ShippingAddress shippingAddress03 = new ShippingAddress();
        shippingAddress03.setUsername("张三--" + 03);
        shippingAddress03.setPhoneNumber("11111111--" + 03);
        shippingAddress03.setArea("山东省" + "-济宁市" + "-任城区");
        shippingAddress03.setDetailedAddress("诗仙路25号");
        shippingAddress03.setZipCode("123456");
        shippingAddress03.setDefault(false);


        ShippingAddress shippingAddress04 = new ShippingAddress();
        shippingAddress04.setUsername("张三--" + 04);
        shippingAddress04.setPhoneNumber("11111111--" + 04);
        shippingAddress04.setArea("山东省" + "-济宁市" + "-任城区");
        shippingAddress04.setDetailedAddress("诗仙路25号");
        shippingAddress04.setZipCode("123456");
        shippingAddress04.setDefault(false);


        ShippingAddress shippingAddress05 = new ShippingAddress();
        shippingAddress05.setUsername("张三--" + 05);
        shippingAddress05.setPhoneNumber("11111111--" + 05);
        shippingAddress05.setArea("山东省" + "-济宁市" + "-任城区");
        shippingAddress05.setDetailedAddress("诗仙路25号");
        shippingAddress05.setZipCode("123456");
        shippingAddress05.setDefault(false);

        ShippingAddress shippingAddress06 = new ShippingAddress();
        shippingAddress06.setUsername("张三--" + 06);
        shippingAddress06.setPhoneNumber("11111111--" + 06);
        shippingAddress06.setArea("山东省" + "-济宁市" + "-任城区");
        shippingAddress06.setDetailedAddress("诗仙路25号");
        shippingAddress06.setZipCode("123456");
        shippingAddress06.setDefault(false);

        ShippingAddress shippingAddress07 = new ShippingAddress();
        shippingAddress07.setUsername("张三--" + 07);
        shippingAddress07.setPhoneNumber("11111111--" + 07);
        shippingAddress07.setArea("山东省" + "-济宁市" + "-任城区");
        shippingAddress07.setDetailedAddress("诗仙路25号");
        shippingAddress07.setZipCode("123456");
        shippingAddress07.setDefault(false);

        ShippingAddress shippingAddress10 = new ShippingAddress();
        shippingAddress10.setUsername("张三--" + 10);
        shippingAddress10.setPhoneNumber("11111111--" + 10);
        shippingAddress10.setArea("山东省" + "-济宁市" + "-任城区");
        shippingAddress10.setDetailedAddress("诗仙路25号");
        shippingAddress10.setZipCode("123456");
        shippingAddress10.setDefault(false);


        shippingAddressList.add(shippingAddress01);
        shippingAddressList.add(shippingAddress02);
        shippingAddressList.add(shippingAddress03);
        shippingAddressList.add(shippingAddress04);
        shippingAddressList.add(shippingAddress05);
        shippingAddressList.add(shippingAddress06);
        shippingAddressList.add(shippingAddress07);
        shippingAddressList.add(shippingAddress10);


//        for (int i = 0; i < 20; i++) {
//            ShippingAddress shippingAddress = new ShippingAddress();
//            shippingAddress.setUsername("张三--" + i);
//            shippingAddress.setPhoneNumber("11111111--" + i);
//            shippingAddress.setAddress("地址--" + i);
//            shippingAddress.setIsDefault(false);
//
//            shippingAddressList.add(shippingAddress);
//        }
    }

    @OnClick({R.id.iv_title_activity_left,
            R.id.btn_activity_address_edit_add,
            R.id.btn_activity_address_edit_obtain})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            /**
             * 地址管理界面的返回按钮
             */
            case R.id.iv_title_activity_left:
                Toast.makeText(
                        AddressEditActivity.this,
                        "点击返回按钮",
                        Toast.LENGTH_SHORT).show();
                intent = new Intent(AddressEditActivity.this, InformationEditActivity.class);
                startActivity(intent);
                break;
            /**
             * 添加新地址
             */
            case R.id.btn_activity_address_edit_add:

                //实例化SelectPicPopupWindow
                addressEditPopupWindow = new AddressEditPopupWindow(AddressEditActivity.this, itemsOnClick);
                addressEditPopupWindow.setFocusable(true);


                //显示窗口
                addressEditPopupWindow.showAtLocation(AddressEditActivity.this.findViewById(R.id.ll_activity_address_edit_parent),
                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

                Toast.makeText(
                        AddressEditActivity.this,
                        "点击添加按钮",
                        Toast.LENGTH_SHORT).show();
                break;
            /**
             * 一键获取微信地址
             */
            case R.id.btn_activity_address_edit_obtain:
                // TODO: 2017/6/8 0008 一键获取待实现
                Toast.makeText(
                        AddressEditActivity.this,
                        "点击一键获取按钮",
                        Toast.LENGTH_SHORT).show();

//                startActivity(MapSelectAddressActivity.class);
                break;
        }
    }

//    /**
//     * 设置添加屏幕的背景透明度
//     * @param bgAlpha
//     */
//    public void backgroundAlpha(float bgAlpha)
//    {
//        WindowManager.LayoutParams lp = getWindow().getAttributes();
//        lp.alpha = bgAlpha; //0.0-1.0
//        getWindow().setAttributes(lp);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//    }


    /**
     * popupwindow实现监听类
     */
    private View.OnClickListener itemsOnClick = new View.OnClickListener() {

        public void onClick(View v) {

            switch (v.getId()) {
                /**
                 * 添加新地址的保存
                 */
                case R.id.btn_address_edit_popup_window_save:
                    username = addressEditPopupWindow.getUsername();
                    phoneNumber = addressEditPopupWindow.getPhoneNumber();
                    addressProvinceCity = addressEditPopupWindow.getAddressProvinceCity();
                    addressStreet = addressEditPopupWindow.getAddressStreet();
                    postCode = addressEditPopupWindow.getPostCode();

                    telRegex = "[1][34578]\\d{9}";
                    if (TextUtils.isEmpty(username) &&
                            TextUtils.isEmpty(phoneNumber) &&
                            TextUtils.isEmpty(addressProvinceCity) &&
                            TextUtils.isEmpty(addressStreet)) {
                        ToastUtils.showLong(AddressEditActivity.this, "请填写空白输入框");
                    } else if (!phoneNumber.matches(telRegex)) {
                        ToastUtils.showLong(AddressEditActivity.this, "查无此号码，请重新输入手机号码");
                    } else if (!(postCode.length() == 6) || postCode.length() == 0) {
                        ToastUtils.showLong(AddressEditActivity.this, "请输入正确的邮政编码");
                    } else {
                        // TODO: 2017/6/8 0008 添加新地址
                        Log.e(TAG, "onClick: " + "收货人姓名：" + username + "    手机号码：" + phoneNumber + "    区域信息：" +
                                addressProvinceCity + "    详细地址：" + addressStreet + "    邮政编码：" + postCode);
                        ToastUtils.showLong(AddressEditActivity.this, "onClick: " + "收货人姓名：" + username + "    手机号码：" + phoneNumber + "    区域信息：" +
                                addressProvinceCity + "    详细地址：" + addressStreet + "    邮政编码：" + postCode);


                        ShippingAddress shippingAddress = new ShippingAddress();
                        shippingAddress.setUsername(username);
                        shippingAddress.setPhoneNumber(phoneNumber);
                        shippingAddress.setArea(addressProvinceCity);
                        shippingAddress.setDetailedAddress(addressStreet);
                        shippingAddress.setZipCode(postCode);
                        shippingAddress.setDefault(false);

                        synchronized (shippingAddressList) {
                            for (int i = 0; i < shippingAddressList.size(); i++) {
                                if (i == viewTag) {
                                    shippingAddressList.add(shippingAddress);
                                }
                            }
                        }

                        //更新数据源
                        addressEditAdapter.notifyDataSetChanged();
                    }

                    addressEditPopupWindow.dismiss();
                    break;

                /**
                 * 添加新地址的关闭popupwindow按钮
                 */
                case R.id.tv_address_edit_popup_window_close:
                    addressEditPopupWindow.dismiss();
                    break;

                /**
                 * 编辑地址的关闭popupwindow按钮
                 */
                case R.id.tv_address_edit_popup_window_edit_close:
                    editAddressEditPopupWindow.dismiss();
                    break;
                /**
                 * 编辑地址的保存按钮
                 */
                case R.id.btn_address_edit_popup_window_edit_save:
                    username = editAddressEditPopupWindow.getUsername();
                    phoneNumber = editAddressEditPopupWindow.getPhoneNumber();
                    addressProvinceCity = editAddressEditPopupWindow.getAddressProvinceCity();
                    addressStreet = editAddressEditPopupWindow.getAddressStreet();
                    postCode = editAddressEditPopupWindow.getPostCode();
                    telRegex = "[1][34578]\\d{9}";
                    if (TextUtils.isEmpty(username) &&
                            TextUtils.isEmpty(phoneNumber) &&
                            TextUtils.isEmpty(addressProvinceCity) &&
                            TextUtils.isEmpty(addressStreet)) {
                        ToastUtils.showLong(AddressEditActivity.this, "请填写空白输入框");
                    } else if (!phoneNumber.matches(telRegex)) {
                        ToastUtils.showLong(AddressEditActivity.this, "查无此号码，请重新输入手机号码");
                    } else if (!(postCode.length() == 6) || postCode.length() == 0) {
                        ToastUtils.showLong(AddressEditActivity.this, "请输入正确的邮政编码");
                    } else {
                        // TODO: 2017/6/8 0008 编辑地址
//                        Log.e(TAG, "onClick: "+"收货人姓名："+username+"    手机号码："+phoneNumber+"    区域信息："+
//                                addressProvinceCity+"    详细地址："+addressStreet+"    邮政编码："+postCode );
//                        ToastUtils.showLong(AddressEditActivity.this,"onClick: "+"收货人姓名："+username+"    手机号码："+phoneNumber+"    区域信息："+
//                                addressProvinceCity+"    详细地址："+addressStreet+"    邮政编码："+postCode);


                        ShippingAddress shippingAddress = new ShippingAddress();
                        shippingAddress.setUsername(username);
                        shippingAddress.setPhoneNumber(phoneNumber);
                        shippingAddress.setArea(addressProvinceCity);
                        shippingAddress.setDetailedAddress(addressStreet);
                        shippingAddress.setZipCode(postCode);
                        shippingAddress.setDefault(false);

                        synchronized (shippingAddressList) {
                            for (int i = 0; i < shippingAddressList.size(); i++) {
                                if (i == viewTag) {
                                    shippingAddressList.remove(i);
                                    shippingAddressList.add(viewTag, shippingAddress);
                                }
                            }
                        }

                        //更新数据源
                        addressEditAdapter.notifyDataSetChanged();
                    }

                    editAddressEditPopupWindow.dismiss();
                    break;
                /**
                 * 编辑地址的删除按钮
                 */
                case R.id.btn_address_edit_popup_window_edit_delete:

                    synchronized (shippingAddressList) {
                        for (int i = 0; i < shippingAddressList.size(); i++) {
                            if (i == viewTag && shippingAddressList.get(viewTag).isDefault()) {
                                shippingAddressList.remove(i);
                                shippingAddressList.get(0).setDefault(true);
                            } else if (i == viewTag && !(shippingAddressList.get(viewTag).isDefault())) {
                                shippingAddressList.remove(i);
                            }
                        }
                    }
                    addressEditAdapter.notifyDataSetChanged();
                    editAddressEditPopupWindow.dismiss();
                    break;
                default:
                    break;
            }


        }

    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /**
             * 删除dialog的取消按钮
             */
            case R.id.item_item_activity_address_edit_delete_cancel:
                dialog.dismiss();
                break;
            /**
             * 删除dialog的确定删除按钮
             */
            case R.id.item_item_activity_address_edit_delete_affirm:
                Log.e(TAG, "onClick: " + "确定删除");
                synchronized (shippingAddressList) {
                    for (int i = 0; i < shippingAddressList.size(); i++) {
                        if (i == viewTag && shippingAddressList.get(viewTag).isDefault()) {
                            shippingAddressList.remove(i);
                            shippingAddressList.get(0).setDefault(true);
                        } else if (i == viewTag && !(shippingAddressList.get(viewTag).isDefault())) {
                            shippingAddressList.remove(i);
                        }
                    }
                }

                addressEditAdapter.notifyDataSetChanged();
                dialog.dismiss();
                break;
            /**
             * 子条目设置默认地址的点击事件
             */
            case R.id.item_activity_address_edit_is_default:
                // TODO: 2017/6/8 0008   设置默认地址，待实现
                Toast.makeText(
                        AddressEditActivity.this,
                        "listview的内部的是否默认按钮被点击了！，位置是-->" + (Integer) v.getTag()
                                + ",内容是-->" + shippingAddressList.get((Integer) v.getTag()),
                        Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onClick: ----------------" + v.getTag());

                ShippingAddress shippingAddressFirst = shippingAddressList.get((Integer) v.getTag());
                shippingAddressFirst.setDefault(true);
                synchronized (shippingAddressList) {
                    for (int i = 0; i < shippingAddressList.size(); i++) {
                        if (i == (Integer) v.getTag()) {
                            shippingAddressList.remove(i);
                        }
                    }
                }
                shippingAddressList.get(0).setDefault(false);
                shippingAddressList.addFirst(shippingAddressFirst);
                //更新数据源
                addressEditAdapter.notifyDataSetChanged();
                break;

            /**
             * 子条目编辑按钮的点击事件
             */
            case R.id.item_activity_address_edit_edit:
                viewTag = (int) v.getTag();
                ShippingAddress sa = shippingAddressList.get(viewTag);
                //实例化SelectPicPopupWindow
                editAddressEditPopupWindow = new EditAddressEditPopupWindow(AddressEditActivity.this, itemsOnClick, sa);
                //显示窗口
                editAddressEditPopupWindow.showAtLocation(AddressEditActivity.this.findViewById(R.id.ll_activity_address_edit_parent),
                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

                //设置layout在PopupWindow中显示的位置
//                Toast.makeText(
//                        AddressEditActivity.this,
//                        "listview的内部的编辑按钮被点击了！，位置是-->" + (Integer) v.getTag()
//                                + ",内容是-->" + shippingAddressList.get((Integer) v.getTag()),
//                        Toast.LENGTH_SHORT).show();

                break;
            /**
             * 子条目删除按钮的点击事件
             */
            case R.id.item_activity_address_edit_delete:


                AlertDialog.Builder builder = new AlertDialog.Builder(AddressEditActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.item_item_activity_address_edit_delete, null);

                btn_cancle = (Button) view.findViewById(R.id.item_item_activity_address_edit_delete_cancel);
                btn_affirm = (Button) view.findViewById(R.id.item_item_activity_address_edit_delete_affirm);
                btn_affirm.setOnClickListener(this);
                btn_cancle.setOnClickListener(this);

                viewTag = (int) v.getTag();
                builder.setView(view);//添加自定义View
                builder.create();
                dialog = builder.show();

//                Toast.makeText(
//                        AddressEditActivity.this,
//                        "listview的内部的删除按钮被点击了！，位置是-->" + (Integer) v.getTag()
//                                + ",内容是-->" + shippingAddressList.get((Integer) v.getTag()),
//                        Toast.LENGTH_SHORT).show();
//                Log.e(TAG, "onClick: "+"listview的内部的删除按钮被点击了！，位置是-->" + (Integer) v.getTag()
//                        + ",内容是-->" + shippingAddressList.get((Integer) v.getTag()) );
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "点击的条目位置是-->" + position, Toast.LENGTH_SHORT)
                .show();
    }


}
