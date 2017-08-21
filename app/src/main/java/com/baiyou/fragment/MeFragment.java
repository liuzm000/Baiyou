package com.baiyou.fragment;

import org.library.base.BaseView;
import org.library.utils.PreferencesUtils;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.baiyou.R;
import com.baiyou.base.BaseFragment;
import com.baiyou.controller.MainFragmentController;
import com.baiyou.controller.MeFragmentController;
import com.baiyou.dialog.SelectPicDialog;
import com.baiyou.ui.CollectionActivity;
import com.baiyou.ui.ModifyNicknameActivity;
import com.baiyou.ui.ModifySexActivity;
import com.baiyou.ui.MySignActivity;
import com.baiyou.ui.PhoneChangeActivity;
import com.baiyou.ui.SettingActivity;
import com.baiyou.utils.picassotransform.RoundedTransformation;
import com.squareup.picasso.Picasso;

/**
 * @author x 我
 */
public class MeFragment extends BaseFragment implements BaseView, MeFragmentController.ControllerView {

	{
		mBaseView = this;
	}

	public static final int REQUEST_CODE_IMG = 1;
	public static final int REQUEST_CODE_NICKNAME = 2;
	public static final int REQUEST_CODE_SEX = 3;
	public static final int REQUEST_CODE_PHONE = 4;
	public static final int REQUEST_CODE_MYSIGN = 5;
	public static final int REQUEST_CODE_TAKEPHOTO = 6;

	private View root_img;
	private ImageView iv_img;
	private TextView tv_account;
	private View root_nickname;
	private TextView tv_nickname;
	private View root_sex;
	private TextView tv_sex;
	private View root_phone;
	private TextView tv_phone;
	private View root_mysign;
	private TextView tv_mysign;
	private View root_address;
	private View root_collection;
	private View root_setting;

	MeFragmentController mMeFragmentController;

	@Override
	public int layout() {
		return R.layout.fragment_me;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initView();
	}

	private void initView() {
		TextView tv_center = (TextView) findViewById(R.id.center);
		tv_center.setText(getResources().getString(R.string.mine));
		TextView tv_left = (TextView) findViewById(R.id.left);
		tv_left.setVisibility(View.GONE);
		TextView tv_right = (TextView) findViewById(R.id.right);
		tv_right.setVisibility(View.GONE);
	}

	@Override
	public void findById() {
		initTitle();
		root_img = findViewById(R.id.root_me_img);
		iv_img = (ImageView) findViewById(R.id.iv_me_img);
		tv_account = (TextView) findViewById(R.id.tv_me_account);
		root_nickname = findViewById(R.id.root_me_nickname);
		tv_nickname = (TextView) findViewById(R.id.tv_me_nickname);
		root_sex = findViewById(R.id.root_me_sex);
		tv_sex = (TextView) findViewById(R.id.tv_me_sex);
		root_phone = findViewById(R.id.root_me_phone);
		tv_phone = (TextView) findViewById(R.id.tv_me_phone);
		root_mysign = findViewById(R.id.root_me_mysign);
		tv_mysign = (TextView) findViewById(R.id.tv_me_mysign);
		root_address = findViewById(R.id.root_me_address);
		root_collection = findViewById(R.id.root_me_collection);
		root_setting = findViewById(R.id.root_me_setting);
	}

	@Override
	protected void initTitle() {
		super.initTitle();
		left.setVisibility(View.GONE);
		center.setVisibility(View.VISIBLE);
		center.setText("我的");
		right.setBackgroundResource(R.drawable.search);
		right.setOnClickListener(this);
	}

	@Override
	public void setListener() {
		root_img.setOnClickListener(this);
		root_nickname.setOnClickListener(this);
		root_sex.setOnClickListener(this);
		root_phone.setOnClickListener(this);
		root_mysign.setOnClickListener(this);
		root_address.setOnClickListener(this);
		root_collection.setOnClickListener(this);
		root_setting.setOnClickListener(this);
	}

	@Override
	public void initData() {
		mMeFragmentController = new MeFragmentController(this, mHelper);
		initMyInfomation();
	}

	// PreferencesUtils.putString(helper.getCtx(), "telphone", telphone);
	// PreferencesUtils.putString(helper.getCtx(), "password", password);
	// PreferencesUtils.putString(helper.getCtx(), "IMtoken", IMtoken);
	// PreferencesUtils.putString(helper.getCtx(), "Daotoken", Daotoken);
	// PreferencesUtils.putString(helper.getCtx(), "wechatid", wechatid);
	// PreferencesUtils.putString(helper.getCtx(), "sinaid", sinaid);
	// PreferencesUtils.putString(helper.getCtx(), "alipayid", alipayid);
	// PreferencesUtils.putString(helper.getCtx(), "nickname", nickname);
	// PreferencesUtils.putString(helper.getCtx(), "headUrl", headUrl);
	// PreferencesUtils.putString(helper.getCtx(), "sex", sex);
	// PreferencesUtils.putString(helper.getCtx(), "birthdate", birthday);
	// PreferencesUtils.putString(helper.getCtx(), "created_at", createdAt);
	// PreferencesUtils.putString(helper.getCtx(), "updated_at", updatedAt);
	// PreferencesUtils.putString(helper.getCtx(), "country", country);
	// PreferencesUtils.putString(helper.getCtx(), "city", city);
	// PreferencesUtils.putString(helper.getCtx(), "destination", destination);
	// PreferencesUtils.putString(helper.getCtx(), "language", language);
	// PreferencesUtils.putString(helper.getCtx(), "birthday", birthday);
	// PreferencesUtils.putString(helper.getCtx(), "privilege", privilege);
	private void initMyInfomation() {
		Picasso.with(mContext).load(PreferencesUtils.getString(mContext, "headUrl"))
				.transform(new RoundedTransformation()).into(iv_img);
		tv_account.setText(PreferencesUtils.getString(mContext, "telphone"));
		tv_nickname.setText(PreferencesUtils.getString(mContext, "nickname"));
		String sex = PreferencesUtils.getString(mContext, "sex");
		if (sex.equals("1")) {
			tv_sex.setText("男");
		} else {
			tv_sex.setText("女");
		}
		tv_phone.setText(PreferencesUtils.getString(mContext, "telphone"));
	}

	@Override
	public void initAdapter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onclick(View v) {
		switch (v.getId()) {
		case R.id.root_me_img:
			showSelectPicDialog();
			break;
		case R.id.root_me_nickname:
			Intent i2 = new Intent(getActivity(), ModifyNicknameActivity.class);
			startActivityForResult(i2, REQUEST_CODE_NICKNAME);
			break;
		case R.id.root_me_sex:
			Intent i3 = new Intent(getActivity(), ModifySexActivity.class);
			startActivityForResult(i3, REQUEST_CODE_SEX);
			break;
		case R.id.root_me_phone:
			Intent i4 = new Intent(getActivity(), PhoneChangeActivity.class);
			startActivityForResult(i4, REQUEST_CODE_PHONE);
			break;
		case R.id.root_me_mysign:
			Intent i5 = new Intent(getActivity(), MySignActivity.class);
			startActivityForResult(i5, REQUEST_CODE_MYSIGN);
			break;
		case R.id.root_me_address:
			// TODO
			break;
		case R.id.root_me_collection:
			Intent intent = new Intent(getActivity(), CollectionActivity.class);
			startActivity(intent);
			break;
		case R.id.root_me_setting:
			Intent i8 = new Intent(getActivity(), SettingActivity.class);
			startActivity(i8);
			break;
		case R.id.right:

			break;

		default:
			break;
		}

	}

	// 弹出头像选择对话框
	private void showSelectPicDialog() {
		Dialog dialog = new SelectPicDialog(getActivity(),this);
		dialog.show();
		Window dialogWindow = dialog.getWindow();
		WindowManager m = getActivity().getWindowManager();
		Display d = m.getDefaultDisplay(); // 获取屏幕宽、高度
		WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
		p.width = (int) (d.getWidth()); // 宽度设置为屏幕的0.65，根据实际情况调整
		p.gravity = Gravity.BOTTOM;
		dialogWindow.setAttributes(p);

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == getActivity().RESULT_OK) {
			switch (requestCode) {
			case REQUEST_CODE_NICKNAME:
				String nickname = data.getStringExtra("nickname");
				tv_nickname.setText(nickname);
				break;
			case REQUEST_CODE_MYSIGN:
				String sign = data.getStringExtra("sign");
				tv_mysign.setText(sign);
				break;
			case REQUEST_CODE_SEX:
				String sex = data.getStringExtra("sex");
				tv_sex.setText(sex);
				break;
			case REQUEST_CODE_TAKEPHOTO:
				
				break;

			default:
				break;
			}
		}
	}

}
