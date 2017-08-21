package com.baiyou.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.library.base.BaseControllerView;
import org.library.http.HttpAsyncTask;
import org.library.http.HttpAsyncTask.CallBack;
import org.library.utils.MapV2;

import com.baiyou.utils.Helper;

import android.util.Log;

public class MsgFragmentController {

	ControllerView view;
	Helper helper;

	public MsgFragmentController(ControllerView view, Helper helper) {
		this.view = view;
		this.helper = helper;
	}

	public interface ControllerView extends BaseControllerView{
		public void loadEnd();
	}

	public void getData(int pageNumber, int pageSize) {
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
		data1.put("img", "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2333090299,850498900&fm=5");
		data1.put("title", "7月1号在杭州一起玩");
		data1.put("content", "你们什么时候到杭州啊");
		data1.put("time", "14.06");
		dataList.add(data1);
		MapV2 data2 = new MapV2();
		data2.put("img", "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2333090299,850498900&fm=5");
		data2.put("title", "7月2号在苏州一起玩");
		data2.put("content", "你们什么时候到苏州啊");
		data2.put("time", "14.07");
		dataList.add(data2);
		view.updateList(0, dataList);
		view.loadEnd();
		
	}

}
