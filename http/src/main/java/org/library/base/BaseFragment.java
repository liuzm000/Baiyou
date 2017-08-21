package org.library.base;

import org.library.utils.HelperUtils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class BaseFragment extends Fragment implements OnClickListener {

	protected BaseView mBaseView = null;
	protected View rootView;
	protected Context mContext;
	protected Activity mActivity;
	protected LayoutInflater mInflater;
//	protected int pageSize = 10, pageNumber = 1;
	protected HelperUtils mHelperUtils ;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		if (null != rootView) {
			
			ViewGroup parent = (ViewGroup) rootView.getParent();
			
			if (null != parent) {
				parent.removeView(rootView);
			}
			
		} else {
			
			mInflater = inflater;
			mContext = getActivity();
			mActivity = getActivity();
			mHelperUtils = new HelperUtils(mContext, mActivity);
			
			
			if( mBaseView != null ){
				rootView = inflater.inflate(mBaseView.layout(), null);
				mBaseView.findById();
				mBaseView.setListener();
				mBaseView.initAdapter();
				mBaseView.initData();
			}

		}
		return rootView;
	}

	@Override
	public void onClick(View v) {
		mBaseView.onclick(v);
	}

	
/*	
	public void onSuccess(int id, String msg) {
		mHelperUtils.hideLoading();
	}

	public void onFailed(int id, String msg) {
		mHelperUtils.hideLoading();
	}

	public void loadStart() {
		mHelperUtils.showLoading();
	}
	
	*/
	
}
