package com.fupengpeng.shoppingmall.activity.personcenter.impl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.BuildConfig;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.fupengpeng.shoppingmall.R;
import com.fupengpeng.shoppingmall.activity.BaseActivity;
import com.fupengpeng.shoppingmall.activity.personcenter.view.IInformationEditView;
import com.fupengpeng.shoppingmall.util.AppUtils;
import com.fupengpeng.shoppingmall.util.ToastUtils;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 资料编辑界面
 */
public class InformationEditActivity extends AppCompatActivity implements IInformationEditView, View.OnClickListener {


    /**
     * 资料完善
     */
    @BindView(R.id.ll_activity_information_edit_data)
    LinearLayout llActivityInformationEditData;
    /**
     * 收货地址管理
     */
    @BindView(R.id.ll_activity_information_edit_address)
    LinearLayout llActivityInformationEditAddress;
    /**
     * 修改头像
     */
    @BindView(R.id.ll_activity_information_edit_pic)
    LinearLayout llActivityInformationEditPic;
    /**
     * 修改密码
     */
    @BindView(R.id.ll_activity_information_edit_password)
    LinearLayout llActivityInformationEditPassword;
    /**
     * 返回至PersonActivity按钮
     */
    @BindView(R.id.iv_activity_information_return)
    ImageView ivActivityInformationReturn;
    /**
     * 修改密码dialog的关闭按钮
     */
    ImageView ivItemActivityInformationEditChangePasswordClose;
    /**
     * 修改密码dialog的原密码
     */
    EditText etItemActivityInformationEditChangePasswordOld;
    /**
     * 修改密码dialog的新密码
     */
    EditText etItemActivityInformationEditChangePasswordNew;
    /**
     * 修改密码dialog的再次输入密码
     */
    EditText etItemActivityInformationEditChangePasswordConfirm;
    /**
     * 修改密码dialog的确认修改密码按钮
     */
    Button btnItemActivityInformationEditChangePasswordConfirm;


    /**
     * 接收dialog得到的密码
     */
    private String oldPassword, newPassword, confirmPassword;

    /**
     * 修改密码的dialog
     */
    private AlertDialog dialog;
    private Intent intent;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_edit);
        unbinder = ButterKnife.bind(this);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /**
             * 修改密码的dialog关闭按钮
             */
            case R.id.iv_item_activity_information_edit_change_password_close:
                dialog.dismiss();
                break;
            /**
             * 修改密码的确认提交密码按钮
             */
            case R.id.btn_item_activity_information_edit_change_password_confirm:

                if (TextUtils.isEmpty(etItemActivityInformationEditChangePasswordOld.getText().toString().trim())){
                    ToastUtils.showLong(InformationEditActivity.this,"请输入原密码");
                }else if (!(etItemActivityInformationEditChangePasswordNew.getText().toString().trim())
                        .equals(etItemActivityInformationEditChangePasswordConfirm.getText().toString().trim())){
                    ToastUtils.showLong(InformationEditActivity.this, "两次输入不同，请重新输入");
                    etItemActivityInformationEditChangePasswordNew.setText("");
                    etItemActivityInformationEditChangePasswordConfirm.setText("");
                    etItemActivityInformationEditChangePasswordOld.setText("");
                }else {
                    // 密码
                    String newPassword = etItemActivityInformationEditChangePasswordNew.getText().toString().trim();
                    // 验证原密码
                    String oldPassword = etItemActivityInformationEditChangePasswordOld.getText().toString().trim();

                    // 确认提交
                    // TODO: 2017/6/6 验证原密码是否正确，正确，修改密码，错误，提示原密码输入错误
                    ToastUtils.showLong(this, "原密码：----" + oldPassword + "----    新密码：----" + newPassword+"----");
                    // TODO: 2017/6/8 0008 修改成功  提示，失败  提示

                    dialog.dismiss();
                }
                break;
        }
    }

    @OnClick({R.id.ll_activity_information_edit_data,
            R.id.ll_activity_information_edit_address,
            R.id.ll_activity_information_edit_pic,
            R.id.ll_activity_information_edit_password,
            R.id.iv_activity_information_return})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            /**
             * 资料完善跳转
             */
            case R.id.ll_activity_information_edit_data:
                intent = new Intent(InformationEditActivity.this, DataActivity.class);
                startActivity(intent);
                break;
            /**
             * 收货地址管理跳转
             */
            case R.id.ll_activity_information_edit_address:
                intent = new Intent(InformationEditActivity.this, AddressEditActivity.class);
                startActivity(intent);
                break;
            /**
             * 修改头像跳转
             */
            case R.id.ll_activity_information_edit_pic:
//                showChoicePhotoWindow();
                // 从相册中选择
                selectFromAlbum();

                break;
            /**
             * 修改密码点击事件
             */
            case R.id.ll_activity_information_edit_password:
                AlertDialog.Builder builder = new AlertDialog.Builder(InformationEditActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View viewDialog = inflater.inflate(R.layout.item_activity_information_edit_change_password, null);
                ivItemActivityInformationEditChangePasswordClose = (ImageView) viewDialog.findViewById(R.id.iv_item_activity_information_edit_change_password_close);
                btnItemActivityInformationEditChangePasswordConfirm = (Button) viewDialog.findViewById(R.id.btn_item_activity_information_edit_change_password_confirm);
                etItemActivityInformationEditChangePasswordOld = (EditText) viewDialog.findViewById(R.id.et_item_activity_information_edit_change_password_old);
                etItemActivityInformationEditChangePasswordNew = (EditText) viewDialog.findViewById(R.id.et_item_activity_information_edit_change_password_new);
                etItemActivityInformationEditChangePasswordConfirm = (EditText) viewDialog.findViewById(R.id.et_item_activity_information_edit_change_password_confirm);

                ivItemActivityInformationEditChangePasswordClose.setOnClickListener(this);
                btnItemActivityInformationEditChangePasswordConfirm.setOnClickListener(this);
                etItemActivityInformationEditChangePasswordOld.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        oldPassword = etItemActivityInformationEditChangePasswordOld.getText().toString().trim();
                    }
                });
                etItemActivityInformationEditChangePasswordNew.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        newPassword = etItemActivityInformationEditChangePasswordNew.getText().toString().trim();
                    }
                });
                etItemActivityInformationEditChangePasswordConfirm.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        confirmPassword = etItemActivityInformationEditChangePasswordConfirm.getText().toString().trim();
                    }
                });

                builder.setView(viewDialog);//添加自定义View
                builder.create();
                dialog = builder.show();
                break;
        }
    }


    /**
     * 拍照临时图片
     */
    protected static final String tempPhotoPath = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_PICTURES) + File.separator + "tks_temp_photo.jpeg";
    /**
     * 裁剪临时图片
     */
    protected static final String tempCropPhotoPath = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_PICTURES) + File.separator + "tks_temp_crop_photo.jpeg";

    /**
     * 相册选图标记
     */
    private static final int GALLERY_REQUEST_CODE = 100;
    /**
     * 相机拍照标记
     */
    private static final int CAMERA_REQUEST_CODE = 101;
    /**
     * 显示图片
     */
    protected static final int SHOW_PICTURE = 102;


    /**
     * 显示选择图片窗口
     */
    public void showChoicePhotoWindow() {
        //弹出对话框
        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.show();
        //自定义dialog的ui
        Window window = dialog.getWindow();
        View dialogView = View.inflate(this, R.layout.dialog_select_image, null);
        LinearLayout llPhotoGraph = (LinearLayout) dialogView.findViewById(R.id.ll_photograph);
        llPhotoGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 判断有无存储空间权限
                if (!AppUtils.hasWriteExternalStoragePermission(InformationEditActivity.this, true)) {
                    return;
                }
                // 拍照
                takePhoto();
                dialog.dismiss();
            }
        });

        LinearLayout llSelectFromAlbum = (LinearLayout) dialogView.findViewById(R.id.ll_select_from_album);
        llSelectFromAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 判断有无存储空间权限
                if (!AppUtils.hasWriteExternalStoragePermission(InformationEditActivity.this, true)) {
                    return;
                }
                // 从相册中选择
                selectFromAlbum();
                dialog.dismiss();
            }
        });

        window.setContentView(dialogView);
    }

    /**
     * 从相册中选择
     */
    private void selectFromAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    /**
     * 拍照
     */
    private void takePhoto() {
        // 打开系统拍照界面
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // 获得拍照图片的保存Uri
        Uri mImageCaptureUri;
        File file = new File(tempPhotoPath);
        deletePic(file);
        //判断是否是AndroidN以及更高的版本
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            mImageCaptureUri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".fileProvider", file);
        } else {
            mImageCaptureUri = Uri.fromFile(file);
        }
        intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
        intent.putExtra("return-data", false);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        startActivityForResult(intent, CAMERA_REQUEST_CODE);
    }

    /**
     * 裁剪图片
     *
     * @param uri
     */
    public void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("scale", true);

        // 限制图片裁剪框宽高比例 1:1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 设置图片像素 200 * 200
        intent.putExtra("outputX", 200);
        intent.putExtra("outputY", 200);

        File file = new File(tempCropPhotoPath);
        deletePic(file);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
        intent.putExtra("return-data", false);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        //判断是否是AndroidN以及更高的版本
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        }
        startActivityForResult(intent, SHOW_PICTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case CAMERA_REQUEST_CODE:   // 调用相机拍照
                    // 裁剪相片
                    // 获得拍照图片的保存Uri
                    Uri mImageCaptureUri;
                    File file = new File(tempPhotoPath);
                    //判断是否是AndroidN以及更高的版本
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        mImageCaptureUri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".fileProvider", file);
                    } else {
                        mImageCaptureUri = Uri.fromFile(file);
                    }
                    cropPhoto(mImageCaptureUri);
                    break;

                case GALLERY_REQUEST_CODE:   // 从相册中选择
                    // 裁剪相片
                    cropPhoto(data.getData());
                    break;

                case SHOW_PICTURE: // 显示图片
                    try {
                        file = new File(tempCropPhotoPath);
                        Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                        // 删除临时图片
                        deletePic(file);
                        deletePic(new File(tempPhotoPath));
                        // 设置裁剪后的图片
                        setCropPhoto(bitmap);
                    } catch (Exception e) {
                    }
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 删除图片
     *
     * @param file
     */
    public void deletePic(File file) {
        if (file != null && file.exists()) {
            file.delete();
        }
    }

    /**
     * 设置裁剪后的图片
     *
     * @param bitmap 图片
     */
    public void setCropPhoto(Bitmap bitmap) {

    }



}
