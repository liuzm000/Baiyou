package org.library.base;

import org.library.utils.HelperUtils;
import org.library.utils.MyActivityManagerUtils;
import org.library.widget.MyProgressDialog;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.View.OnClickListener;

@SuppressLint("NewApi")
public class BaseFragmentActivity extends FragmentActivity implements OnClickListener {

	protected BaseView mBaseView = null;
	protected Context mContext = this;
	protected Activity mActivity = this;
//	protected int pageSize = 10, pageNumber = 1;
	protected HelperUtils mHelperUtils = new HelperUtils(this, this);
//	protected SwipeRefreshLayout mSwipeRefreshLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyActivityManagerUtils.addActivity(this);
		if( mBaseView != null ){
			setContentView(mBaseView.layout());
			mBaseView.findById();
			mBaseView.setListener();
			mBaseView.initAdapter();
			mBaseView.initData();
		}
	}

	public void onClick(View v) {
		mBaseView.onclick(v);
	}

	
/*	
	public void onSuccess(int id, String msg) {
		dismiss();
		loadFinish();
	}

	public void onFailed(int id, String msg) {
		dismiss();
		loadFinish();
	}

	public void loadStart() {
		mHelperUtils.showLoading();
	}

	public void dismiss() {
		mHelperUtils.hideLoading();
	}

	public void loadFinish() {
		if (mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing()) {
			mSwipeRefreshLayout.setRefreshing(false);
		}
	}

	*/

}
