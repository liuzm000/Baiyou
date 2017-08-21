package com.baiyou.ui;

import java.util.ArrayList;
import java.util.List;

import org.library.base.BaseView;
import org.library.utils.MapV2;

import com.baiyou.R;
import com.baiyou.adapter.CollectionAdapter;
import com.baiyou.base.BaseActivity;
import com.baiyou.controller.CollectionController;
import com.baiyou.controller.CollectionController.CollectionView;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.View;
import android.widget.ListView;
/**
 * 我的收藏界面
 * */
public class CollectionActivity extends BaseActivity implements BaseView, CollectionView {
	{
		mBaseView = this;
	}

	private CollectionController mController;
	private ListView mListView;
	private SwipeRefreshLayout mSwipeRefreshLayout;
	
	private CollectionAdapter mAdapter;
	private List<MapV2> dataList = new ArrayList<MapV2>();

	@Override
	public int layout() {
		return R.layout.activity_collection;
	}

	@Override
	public void findById() {
		initTitle();
		mListView = (ListView) findViewById(R.id.lv_collection_list);
		mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.srl_collection);
	}

	@Override
	protected void initTitle() {
		super.initTitle();
		left.setText(" ");
		left.setOnClickListener(this);
		center.setText(getResources().getString(R.string.title_activity_collection));
		right.setVisibility(View.GONE);
	}

	@Override
	public void setListener() {
		mSwipeRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
			
			@Override
			public void onRefresh() {
				loadMore();
				
			}
		});

	}

	@Override
	public void initData() {
		mController = new CollectionController(this, mHelper);
		refresh();
	}

	@Override
	public void initAdapter() {
		mAdapter = new CollectionAdapter(this, dataList);
		mListView.setAdapter(mAdapter);
	}

	@Override
	public void onclick(View v) {
		switch (v.getId()) {
		case R.id.left:
			finish();
			break;

		default:
			break;
		}

	}

	@Override
	public void updateList(int id, List<MapV2> data) {
		if (data.size() <= 0) {
			return;
		}
		if (pageNumber == 1) {
			this.dataList.clear();
			this.dataList.addAll(data);
			mAdapter.notifyDataSetChanged();
		} else {
			this.dataList.addAll(data);
			mAdapter.appendDataList(data);
		}
		
		
	}

	@Override
	public void refresh() {
		pageNumber = 1;
		mController.getData(pageNumber, pageSize);
		
	}

	@Override
	public void loadMore() {
		pageNumber++;
		mController.getData(pageNumber, pageSize);
		
	}
	
	public void loadEnd() {
		mSwipeRefreshLayout.setRefreshing(false);
	}
	

}
