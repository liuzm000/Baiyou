package com.baiyou.fragment;

import java.util.ArrayList;
import java.util.List;

import org.library.base.BaseView;
import org.library.utils.MapV2;

import android.graphics.drawable.Drawable;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AbsListView;
import android.widget.ListView;

import com.baiyou.R;
import com.baiyou.adapter.TogetherAdapter;
import com.baiyou.base.BaseFragment;
import com.baiyou.controller.TogetherFragmentController;
import com.baiyou.ui.OutDetailActivity;

/**
 * @author x 结伴
 */
public class TogetherFragment extends BaseFragment implements BaseView,
		TogetherFragmentController.ControllerView {

	{
		mBaseView = this;
	}
	TogetherFragmentController mTogetherFragmentController;
	private SwipeRefreshLayout mSwipeRefreshLayout;
	private ListView mListView;
	private TogetherAdapter mAdapter;
	private List<MapV2> dataList = new ArrayList<MapV2>();

	@Override
	public int layout() {
		return R.layout.fragment_together;
	}

	@Override
	public void findById() {
		initTitle();
		mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.srl_together);
		mListView = (ListView) findViewById(R.id.lv_together);
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

	public void refresh() {
		pageNumber=1;
		mTogetherFragmentController.getData();
	}

	@Override
	public void initData() {
		mTogetherFragmentController = new TogetherFragmentController(this,
				mHelper);
		refresh();

	}

	@Override
	public void initAdapter() {
	
		mAdapter = new TogetherAdapter(mContext, dataList);
		mListView.setAdapter(mAdapter);
	}

	@Override
	public void onclick(View v) {
		switch (v.getId()) {
		case R.id.right:
			Intent intent = new Intent(getActivity(),OutDetailActivity.class);
			startActivity(intent);
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
			this.dataList = data;
			mAdapter.notifyDataSetChanged(data);
		} else {
			this.dataList.addAll(data);
			mAdapter.appendDataList(data);
		}
		
		
	}

	@Override
	public void loadMore() {
		pageNumber++;
		mTogetherFragmentController.getData();
		
	}

	@Override
	public void loadEnd() {
		mSwipeRefreshLayout.setRefreshing(false);
		
	}
	
	@Override
	protected void initTitle() {
		super.initTitle();
		left.setVisibility(View.GONE);
		center.setVisibility(View.VISIBLE);
		center.setText("我的行程");
//		right.setBackgroundResource(R.drawable.search);
		right.setOnClickListener(this);
		right.setText("");
		Drawable drawable = mContext.getResources().getDrawable(R.drawable.add);
		right.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
		
	}

//	Drawable drawable = mContext.getResources().getDrawable(logo);
//	holder.info_1.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
//	holder.item.setBackgroundResource(background);

}
