package com.baiyou.controller;

import java.util.ArrayList;
import java.util.List;

import org.library.base.BaseControllerView;
import org.library.http.HttpAsyncTask;
import org.library.http.HttpAsyncTask.CallBack;
import org.library.utils.MapV2;

import com.baiyou.utils.Helper;

import android.util.Log;

public class TogetherFragmentController {

	ControllerView view;
	Helper helper;

	public TogetherFragmentController(ControllerView view, Helper helper) {
		this.view = view;
		this.helper = helper;
	}
	
	public void getData(){
		String url = "http://www.baidu.com/s?wd=水电费";
		HttpAsyncTask.post(url, new CallBack() {
			
			@Override
			public void onSuccess(String result) {
				Log.i("百度一下", result);
				
			}
			
			@Override
			public void onError(String msg) {
				view.loadEnd();
				
			}
		});
		List<MapV2> dataList = new ArrayList<MapV2>();
		MapV2 data1 = new MapV2();
		data1.put("time", "7.1~7.2");
		data1.put("destination", "浙江");
		data1.put("state", "未完成");
		data1.put("group", "结伴群");
		dataList.add(data1);
		MapV2 data2 = new MapV2();
		data2.put("time", "7.1~7.3");
		data2.put("destination", "苏州");
		data2.put("state", "完成");
		data2.put("group", "结伴群");
		dataList.add(data2);
		view.updateList(0, dataList);
		view.loadEnd();
	}

	public interface ControllerView extends BaseControllerView{
		void loadEnd();
	}

}
