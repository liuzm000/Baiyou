package com.baiyou.dialog;

import com.baiyou.R;
import com.baiyou.base.BaseFragment;
import com.baiyou.fragment.MeFragment;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
/**
 * 图片选择对话框
 * */
public class SelectPicDialog extends Dialog implements android.view.View.OnClickListener {

	private TextView tv_takePhoto;
	private TextView tv_selectFromPhone;
	private TextView tv_cancel;

	private BaseFragment mFragment;

	public SelectPicDialog(Context context) {
		super(context);
	}

	// Fragment中弹出时使用的构造器，以便在Fragment中返回ActivityResult
	public SelectPicDialog(Context context, BaseFragment fragment) {
		super(context);
		this.mFragment = fragment;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dialog_select_pic);
		setCanceledOnTouchOutside(false);
		findView();
		setListener();
	}

	private void setListener() {
		tv_takePhoto.setOnClickListener(this);
		tv_selectFromPhone.setOnClickListener(this);
		tv_cancel.setOnClickListener(this);
	}

	private void findView() {
		tv_takePhoto = (TextView) findViewById(R.id.tv_select_pic_takePhoto);
		tv_selectFromPhone = (TextView) findViewById(R.id.tv_select_pic_selectFromPhone);
		tv_cancel = (TextView) findViewById(R.id.tv_select_pic_cancel);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_select_pic_takePhoto:
			if (mFragment != null) {
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				mFragment.startActivityForResult(intent, MeFragment.REQUEST_CODE_TAKEPHOTO);
				dismiss();
			}
			break;
		case R.id.tv_select_pic_selectFromPhone:

			break;
		case R.id.tv_select_pic_cancel:
			dismiss();
			break;

		default:
			break;
		}

	}

}
