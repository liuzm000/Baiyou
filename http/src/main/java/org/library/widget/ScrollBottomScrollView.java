package org.library.widget;

import org.library.listener.LoadMoreListener;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

public class ScrollBottomScrollView extends ScrollView {

    private LoadMoreListener _listener;
    private int _calCount;

    public void registerOnScrollViewScrollToBottom(LoadMoreListener l) {
        _listener = l;
    }

    public void unRegisterOnScrollViewScrollToBottom() {
        _listener = null;
    }

    public ScrollBottomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        View view = this.getChildAt(0);
        if(view == null){
        	return ;
        }
        if (this.getHeight() + this.getScrollY() == view.getHeight()) {
            _calCount++;
            if (_calCount == 1) {
                if (_listener != null) {
                    _listener.loadMore();
                }
            }
        } else {
            _calCount = 0;
        }
    }
}