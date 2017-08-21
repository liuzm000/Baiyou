package com.baiyou.fragment;

import org.library.base.BaseView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.baiyou.R;
import com.baiyou.base.BaseFragment;
import com.baiyou.controller.MainFragmentController;
import com.baiyou.ui.SearchActivity;

/**
 * @author x 出发攻略
 */
public class MainFragment extends BaseFragment implements BaseView,
		MainFragmentController.ControllerView {

	{
		mBaseView = this;
	}
	MainFragmentController mMainFragmentController;

	@Override
	public int layout() {
		return R.layout.fragment_main;
	}

	@Override
	public void findById() {
		initTitle();
	}
	
	@Override
	protected void initTitle() {
		super.initTitle();
		left.setVisibility(View.GONE);
		center.setVisibility(View.VISIBLE);
		center.setText("攻略");
//		right.setBackgroundResource(R.drawable.search);
		right.setText("");
		right.setOnClickListener(this);
		Drawable drawable = mContext.getResources().getDrawable(R.drawable.search);
		right.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
	}

	@Override
	public void setListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		mMainFragmentController = new MainFragmentController(this, mHelper);
	}

	@Override
	public void initAdapter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onclick(View v) {
		switch (v.getId()) {
		case R.id.right:
			Intent intent = new Intent(getActivity(),SearchActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}

	}

}
