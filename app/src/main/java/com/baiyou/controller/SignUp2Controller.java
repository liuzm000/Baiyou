package com.baiyou.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.library.http.HttpAsyncTask;
import org.library.http.HttpGetAsyncTask;
import org.library.http.HttpGetAsyncTask.CallBack;

import com.baiyou.R;
import com.baiyou.api.HttpAPI;
import com.baiyou.utils.Helper;

import android.text.TextUtils;
import android.util.Log;

public class SignUp2Controller {
	
	private static final String TAG = "SignUp2Controller";

	private ControllerView view;
	private Helper helper;

	public SignUp2Controller(ControllerView view, Helper helper) {
		this.view = view;
		this.helper = helper;
	}

	public void register(String phone, String name, String password, String password2) {
		
		
		helper.showLoading();
		String url = HttpAPI.API_REGISTER + "?telphone=" + phone + "&name=" + name + "&password=" + password
				+ "&password2=" + password2;
		HttpGetAsyncTask.get(url, null, new CallBack() {
			//
			// {"code":200,"success":"\u6ce8\u518c\u6210\u529f",
			// "message":"OK","IMtoken":"c7b02fba3be9f6885f753ee9eb5d2a9b",
			// "userid":"341",
			// "info":{"name":"sdf","IMtoken":"c7b02fba3be9f6885f753ee9eb5d2a9b",
			// "icon":"https:\/\/ss1.bdstatic.com\/70cFuXSh_Q1YnxGkpoWK1HF6hhy\/it\/u=3478489966,2081485319&fm=26&gp=0.jpg",
			// "telphone":"341"}}
			@Override
			public void onSuccess(String result) {
				JSONObject json = null;
				try {
					json = new JSONObject(result);
					int code = json.getInt("code");
					if (code == 200) {
						view.successRegister();
						helper.hideLoading();
					}else{
						helper.toast(helper.getCtx().getResources().getString(R.string.signUp_failed));
						helper.hideLoading();
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}

			}

			@Override
			public void onError(String msg) {
				Log.e(TAG, msg);
				helper.toast(helper.getCtx().getResources().getString(R.string.signUp_failed));

			}
		});
	}

	public interface ControllerView {
		void successRegister();
	}

}
