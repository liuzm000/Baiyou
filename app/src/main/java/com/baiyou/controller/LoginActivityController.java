package com.baiyou.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.library.http.HttpGetAsyncTask;
import org.library.http.HttpGetAsyncTask.CallBack;
import org.library.utils.PreferencesUtils;

import com.baiyou.api.HttpAPI;
import com.baiyou.utils.Helper;
import com.netease.nim.uikit.common.util.string.MD5;

import android.text.TextUtils;
import android.util.Log;

import abc.LoginServerHelper;

public class LoginActivityController {
	private static final String TAG = "LoginActivityController";

	ControllerView view;
	Helper helper;

	public LoginActivityController(ControllerView view, Helper helper) {
		this.view = view;
		this.helper = helper;
	}

	public void login(String username, String password) {
		if(TextUtils.isEmpty(username)||TextUtils.isEmpty(password)){
			helper.toast("请检查登录信息是否填全");
			return;
		}
		helper.showLoading();
		String url = HttpAPI.API_LOGIN + "telphone=" + username + "&password=" + password;
		HttpGetAsyncTask.get(url, null, new CallBack() {

			@Override
			public void onSuccess(String result) {
				Log.d(TAG, result);
				parseJson(result);
			}

			@Override
			public void onError(String msg) {
				Log.e(TAG, msg);
				helper.toast("登录失败");
			}
		});
	}

	// {"code":200,"message":"OK","userid":"qwe","telphone":"qwe","password":"123",
	// "IMtoken":"44f185e8215ca6393e20073639e8868d","Daotoken":"",
	// "wechatid":null,"sinaid":null,"alipayid":null,
	// "nickname":"ooo",
	// "headurl":"https:\/\/ss1.bdstatic.com\/70cFuXSh_Q1YnxGkpoWK1HF6hhy\/it\/u=3478489966,2081485319&fm=26&gp=0.jpg",
	// "sex":"1","birthdate":null,"created_at":null,"updated_at":null,"country":"","city":null,
	// "destination":null,"language":null,"privilege":null}

	private void parseJson(String result) {
		JSONObject json = null;
		try {
			json = new JSONObject(result);
			int code = json.getInt("code");
			if (code == 200) {

				String telphone = json.getString("telphone") + "";
				String password = json.getString("password") + "";
				String IMtoken = json.getString("IMtoken") + "";
				String Daotoken = json.getString("Daotoken") + "";
				String wechatid = json.getString("wechatid") + "";
				String sinaid = json.getString("sinaid") + "";
				String alipayid = json.getString("alipayid") + "";
				String nickname = json.getString("nickname") + "";
				String headUrl = json.getString("headurl") + "";
				String sex = json.getString("sex") + "";
				String birthday = json.getString("birthdate") + "";
				String createdAt = json.getString("created_at") + "";
				String updatedAt = json.getString("updated_at") + "";
				String country = json.getString("country");
				String city = json.getString("city") + "";
				String destination = json.getString("destination") + "";
				String language = json.getString("language") + "";
				String privilege = json.getString("privilege");

				PreferencesUtils.putString(helper.getCtx(), "telphone", telphone);
				PreferencesUtils.putString(helper.getCtx(), "password", password);
				PreferencesUtils.putString(helper.getCtx(), "IMtoken", IMtoken);
				PreferencesUtils.putString(helper.getCtx(), "Daotoken", Daotoken);
				PreferencesUtils.putString(helper.getCtx(), "wechatid", wechatid);
				PreferencesUtils.putString(helper.getCtx(), "sinaid", sinaid);
				PreferencesUtils.putString(helper.getCtx(), "alipayid", alipayid);
				PreferencesUtils.putString(helper.getCtx(), "nickname", nickname);
				PreferencesUtils.putString(helper.getCtx(), "headUrl", headUrl);
				PreferencesUtils.putString(helper.getCtx(), "sex", sex);
				PreferencesUtils.putString(helper.getCtx(), "birthdate", birthday);
				PreferencesUtils.putString(helper.getCtx(), "created_at", createdAt);
				PreferencesUtils.putString(helper.getCtx(), "updated_at", updatedAt);
				PreferencesUtils.putString(helper.getCtx(), "country", country);
				PreferencesUtils.putString(helper.getCtx(), "city", city);
				PreferencesUtils.putString(helper.getCtx(), "destination", destination);
				PreferencesUtils.putString(helper.getCtx(), "language", language);
				PreferencesUtils.putString(helper.getCtx(), "birthday", birthday);
				PreferencesUtils.putString(helper.getCtx(), "privilege", privilege);
				helper.hideLoading();
//				view.successLogin();

				telphone  = "13175472609";
				IMtoken = "eda29ce40834379ecb2816f2ec890d87";
				IMtoken = tokenFromPassword("19890309qq");

				loginChatSer(telphone,IMtoken);

			}else{
				helper.hideLoading();
				helper.toast("登录失败");
			}
		} catch (JSONException e) {

			e.printStackTrace();
		}

	}



	//DEMO中使用 username 作为 NIM 的account ，md5(password) 作为 token
	//开发者需要根据自己的实际情况配置自身用户系统和 NIM 用户系统的关系
	public String tokenFromPassword(String password) {
		String appKey = LoginServerHelper.appKey;
//		appKey = "45c6af3c98409b18a84451215d0bdd6e";
		boolean isDemo = "45c6af3c98409b18a84451215d0bdd6e".equals(appKey) || "fe416640c8e8a72734219e1847ad2547".equals(appKey);
		return isDemo ? MD5.getStringMD5(password) : password;
	}

	public void loginChatSer(final String account,final String pwd){

		if(TextUtils.isEmpty(account)){
			helper.toast("请输入账号");
			return;
		}

		if(TextUtils.isEmpty(pwd)){
			helper.toast("请输入密码");
			return;
		}

		String token = tokenFromPassword(pwd);

		LoginServerHelper mLoginServerHelper = new LoginServerHelper();
		helper.showLoading();
		mLoginServerHelper.loginChatSer(account,token,new LoginServerHelper.LoginServerHelperInterf(){

			@Override
			public void onSuccess() {
				Log.d(TAG, "onSuccess.....");
				helper.toast("登录成功");
				view.successLogin();
				helper.hideLoading();
			}

			@Override
			public void onFailed(int code) {
				Log.d(TAG, "onSuccess....."+code);
				helper.toast("登录失败");
				helper.hideLoading();
			}

			@Override
			public void onException(Throwable exception) {
				Log.d(TAG, "onSuccess....."+ exception.getMessage() );
				helper.toast("登录失败");
				helper.hideLoading();
			}
		});
	}

	public interface ControllerView {
		void successLogin();
	}

}
