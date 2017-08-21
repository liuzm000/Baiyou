package com.baiyou.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baiyou.R;
import com.baiyou.utils.Helper;

public class BaseFragment extends org.library.base.BaseFragment {

	protected int pageSize = 10, pageNumber = 1;
	protected Helper mHelper;

	protected View title;
	protected TextView left;
	protected TextView center;
	protected TextView right;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mHelper = new Helper(getActivity(), getActivity());
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	public View findViewById(int id) {
		return rootView.findViewById(id);
	}

	protected void initTitle() {
		title = findViewById(R.id.title);
		left = (TextView) findViewById(R.id.left);
		center = (TextView) findViewById(R.id.center);
		right = (TextView) findViewById(R.id.right);
	}

}
