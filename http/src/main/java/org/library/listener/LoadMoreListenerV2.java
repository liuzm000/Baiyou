package org.library.listener;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;

public class LoadMoreListenerV2 implements AbsListView.OnScrollListener {

	LoadMoreListener mLoadMoreListenerCall;
	public boolean can_load_more = true ; 
	
	public LoadMoreListenerV2() {
	}

	public LoadMoreListenerV2(final LoadMoreListener mLoadMoreListenerCall) {
		super();
		this.mLoadMoreListenerCall = mLoadMoreListenerCall;
	}
	
	int mListViewHeight = -100 ;
	public void onScroll(final AbsListView listView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		
		if(!can_load_more){
			return ;
		}
		
		if( mListViewHeight == -100 ){
			
			listView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
	
				@SuppressLint("NewApi")
				public void onGlobalLayout() {
					mListViewHeight = listView.getHeight();
					if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
						listView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
					} else {
						listView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
					}
				}
			
			});
			
			return ;
		}
		
		if (firstVisibleItem == 0) {
			
			View firstVisibleItemView = listView.getChildAt(0);
			if (firstVisibleItemView != null && firstVisibleItemView.getTop() == 0) {
				Log.d("ListView", "<----滚动到顶部----->");
			}
			
		} else if ((firstVisibleItem + visibleItemCount) == totalItemCount) {
			
			View lastVisibleItemView = listView.getChildAt(listView .getChildCount() - 1);
			if (lastVisibleItemView != null && lastVisibleItemView.getBottom() == mListViewHeight) {
				Log.d("ListView", "#####滚动到底部######");
				mLoadMoreListenerCall.loadMore();
			}
		}
		
	}

	@Override
	public void onScrollStateChanged(AbsListView arg0, int arg1) {
		
	}
	
}
