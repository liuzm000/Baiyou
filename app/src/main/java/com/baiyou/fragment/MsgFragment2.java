package com.baiyou.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.View;
import android.widget.ListView;

import com.baiyou.R;
import com.baiyou.adapter.MessageAdapter;
import com.baiyou.base.BaseFragment;
import com.baiyou.controller.MsgFragmentController;

import org.library.base.BaseView;
import org.library.listener.LoadMoreListener;
import org.library.listener.LoadMoreListenerV2;
import org.library.utils.MapV2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author x 消息
 */
public class MsgFragment2 extends BaseFragment implements BaseView, MsgFragmentController.ControllerView, LoadMoreListener {

	{
		mBaseView = this;
	}
	MsgFragmentController mMsgFragmentController;

	private SwipeRefreshLayout mSwipeRefreshLayout;
	private ListView mListView;
	private MessageAdapter mAdapter;
	private List<MapV2> dataList = new ArrayList<MapV2>();

	@Override
	public int layout() {
		return R.layout.fragment_msg;
	}

	@Override
	public void findById() {
		initTitle();
		mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
		mListView = (ListView) findViewById(R.id.listView);
	}

	@Override
	public void setListener() {
		mSwipeRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
			
			@Override
			public void onRefresh() {
				loadMore();
				
			}
		});
		mListView.setOnScrollListener(new LoadMoreListenerV2(this));
	}

	public void refresh() {
		pageNumber = 1;
		mMsgFragmentController.getData(pageNumber, pageSize);
	}

	@Override
	public void initData() {
		mMsgFragmentController = new MsgFragmentController(this, mHelper);
		refresh();
	}
	
	

	@Override
	public void initAdapter() {
		mAdapter = new MessageAdapter(mContext, dataList);
		mListView.setAdapter(mAdapter);

	}

	@Override
	public void onclick(View v) {
		switch (v.getId()) {
		case R.id.right:
			
			break;

		default:
			break;
		}

	}

	@Override
	public void updateList(int id, List<MapV2> data) {
		mSwipeRefreshLayout.setRefreshing(false);
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
	public void loadMore() {
		pageNumber++;
		mMsgFragmentController.getData(pageNumber, pageSize);
	}
	
	@Override
	protected void initTitle() {
		super.initTitle();
		left.setVisibility(View.GONE);
		center.setVisibility(View.VISIBLE);
		center.setText("消息");
		right.setBackgroundResource(R.drawable.search);
		right.setOnClickListener(this);
		right.setText("");
		right.setVisibility(View.GONE);
	}

	@Override
	public void loadEnd() {
		mSwipeRefreshLayout.setRefreshing(false);
	}
	
	

}
