package com.baiyou.fragment;

import java.util.ArrayList;
import java.util.List;

import org.library.base.BaseView;
import org.library.listener.LoadMoreListener;
import org.library.listener.LoadMoreListenerV2;
import org.library.utils.MapV2;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AbsListView;
import android.widget.ListView;

import com.baiyou.R;
import com.baiyou.adapter.MessageAdapter;
import com.baiyou.base.BaseFragment;
import com.baiyou.controller.MsgFragmentController;

/**
 * @author x 消息
 */
public class MsgFragment extends BaseFragment implements BaseView, MsgFragmentController.ControllerView, LoadMoreListener {

    {
        mBaseView = this;
    }

    @Override
    public int layout() {
        return R.layout.fragment_msg;
    }

    @Override
    public void findById() {
        initTitle();
    }

    @Override
    public void setListener() {
    }

    public void refresh() {
    }

    @Override
    public void initData() {
    }


    @Override
    public void initAdapter() {
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
    }

    @Override
    public void loadMore() {
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

    }


}
