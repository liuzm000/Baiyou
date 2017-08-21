package org.library.utils.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.library.base.BaseControllerView;
import org.library.http.HttpAsyncTask;
import org.library.utils.MapV2;

public class TestController {

	ControllerView mControllerView;

	public TestController(ControllerView mControllerView) {
		this.mControllerView = mControllerView;
	}

	public void getdata() {
	}

	public void getdata(int pageSize, int pageNumber) {
		JSONObject data = new JSONObject();
		try {
			data.put("pageNum", pageNumber);
			data.put("pageSize", pageSize);
		} catch (JSONException e) {
			e.printStackTrace();
		}
//		mControllerView.loadStart();
		HttpAsyncTask.post("url", data.toString(), new HttpAsyncTask.CallBack() {

			public void onSuccess(String result) {
//				mControllerView.onSuccess(0, "msg..");
				parseJSON(result);
			}

			public void onError(String msg) {
//				mControllerView.onFailed(0, "msg..");
			}
		}, false);
	}

	protected void parseJSON(String json) {
		List<MapV2> data = new ArrayList<MapV2>();
		// parse json
		mControllerView.updateList(0, data);// update list 
	}

	public interface ControllerView extends BaseControllerView {

	}

}
