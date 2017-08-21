package org.library.utils;

import java.util.List;

import org.library.base.BaseActivity;
import org.library.base.BaseView;
import org.library.http.R;
import org.library.listener.LoadMoreListener;
import org.library.listener.LoadMoreListenerV2;
import org.library.utils.controller.TestController;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ListView;

public class TestActivity extends BaseActivity
		implements LoadMoreListener, BaseView, TestController.ControllerView, SwipeRefreshLayout.OnRefreshListener {

	@Override
	public void updateList(int id, List<MapV2> data) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int layout() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void findById() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setListener() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initAdapter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onclick(View v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadMore() {
		// TODO Auto-generated method stub
		
	}

	

}
