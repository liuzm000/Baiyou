package org.library.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.library.http.HttpAsyncTaskUtils;
import org.library.widget.MyProgressDialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.Toast;

public class HelperUtils {

	protected Context ctx;
	protected Activity act;
	protected MyProgressDialog mMyProgressDialog,mpd2;
	protected String tag = "HttpAsyncTask";

	protected Toast toast;

	public HelperUtils() {
	}
	
	public HelperUtils(Context ctx, Activity act) {
		super();
		this.ctx = ctx;
		this.act = act;
	}

	public Context getCtx(){
		return this.ctx ;
	}
	
	public void setCtx(Context ctx){
		this.ctx  =  ctx;
	}
	
	public void toast(String txt) {
		if (toast == null) {
			toast = Toast.makeText(ctx, txt, Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.TOP, 0, 100);
		}
		toast.setText(txt);
		toast.show();
	}



	/**
	 * @param mEditTexts
	 * @return
	 */
	public boolean isNull(EditText... mEditTexts) {
		for (int i = 0; i < mEditTexts.length; i++) {
			EditText mEditText = mEditTexts[i];
			if (mEditText == null) {
				continue;
			}
			String txt = mEditText.getText().toString();
			if (TextUtils.isEmpty(txt)) {
				String hit = mEditText.getHint().toString();
				toast(hit);
				return false;
			}
		}
		return true;
	}

	public int add(EditText... mEditTexts) {
		int total = 0;
		for (int i = 0; i < mEditTexts.length; i++) {
			EditText mEditText = mEditTexts[i];
			total += getEint(mEditText);
		}
		return total;
	}

	public float addFloat(EditText... mEditTexts) {
		float total = 0;
		for (int i = 0; i < mEditTexts.length; i++) {
			EditText mEditText = mEditTexts[i];
			total += getEfloat(mEditText);
		}
		return total;
	}

	public float getEfloat(EditText mEditText) {
		if (mEditText == null) {
			return 0;
		}
		String txt = mEditText.getText().toString();
		return JTextUtils.toFloat(txt);
	}

	public String getEstring(EditText mEditText) {
		if (mEditText == null) {
			return "";
		}
		String txt = mEditText.getText().toString();
		if (txt == null) {
			return "";
		}
		if ("".equals(txt.trim())) {
			return "";
		}
		return txt.trim();
	}

	public int getEint(EditText mEditText) {
		if (mEditText == null) {
			return 0;
		}
//		String txt = mEditText.getText().toString();
		return JTextUtils.toInt( getEstring( mEditText ) );
	}

	public String getBString(String key) {
		Bundle value = getArgs();
		if (value == null) {
			return "";
		}
		return value.getString(key);
	}

	public int getBint(String key) {
		Bundle value = getArgs();
		if (value == null) {
			return 0;
		}
		return value.getInt(key);
	}

	public float getBfloat(String key) {
		Bundle value = getArgs();
		if (value == null) {
			return 0;
		}
		return value.getFloat(key);
	}

	public float getFloat(EditText mEditText, int point) {
//		return new BigDecimal(getEfloat(mEditText)).setScale(point, BigDecimal.ROUND_HALF_UP).floatValue();
		return JTextUtils.toFloat( getEstring( mEditText ) ,point);
	}

	public String getResString(int id) {
		return ctx.getResources().getString(id);
	}
	
	public int getResColor(int id){
		return ctx.getResources().getColor(id);
	}

	public int getVersionCode() {
		PackageManager manager = ctx.getPackageManager();
		try {
			PackageInfo info = manager.getPackageInfo(ctx.getPackageName(), 0);
			return info.versionCode;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return 1;
	}

	public String getVersionName() {
		PackageManager manager = ctx.getPackageManager();
		try {
			PackageInfo info = manager.getPackageInfo(ctx.getPackageName(), 0);
			return info.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return "";
	}

	public float getVersionNameFloat() {
		PackageManager manager = ctx.getPackageManager();
		try {
			PackageInfo info = manager.getPackageInfo(ctx.getPackageName(), 0);
			return JTextUtils.toFloat(info.versionName.trim());
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * getSerialNumber
	 * 
	 * @return result is same to getSerialNumber1()
	 */
	public String getSerialNumber() {
		String serial = "";
		try {
			Class<?> c = Class.forName("android.os.SystemProperties");
			Method get = c.getMethod("get", String.class);
			serial = (String) get.invoke(c, "ro.serialno");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serial;
	}

	public void info(String msg) {
		if (HttpAsyncTaskUtils.debug)
			Log.i(tag, msg);
	}

	public void error(String msg) {
		if (HttpAsyncTaskUtils.debug)
			Log.e(tag, msg);
	}

	public void warm(String msg) {
		if (HttpAsyncTaskUtils.debug)
			Log.w(tag, msg);
	}

	public void debug(String msg) {
		if (HttpAsyncTaskUtils.debug)
			Log.d(tag, msg);
	}
	
	public void showLoading() {
		if(mMyProgressDialog==null){
			mMyProgressDialog = new MyProgressDialog(ctx);
		}
		if(!mMyProgressDialog.isShowing()){
			mMyProgressDialog.show();
		}
	}
	
	public void showLoading2(int progress) {
		if (this.mpd2 == null) {
			this.mpd2 = new MyProgressDialog(ctx,"downloading...");
		}
		if(mpd2.isShowing()){
			mpd2.setProgress(progress+"%");
		}else{
			this.mpd2.show();
		}
	};

	public void hideLoading() {
		if (mMyProgressDialog != null && mMyProgressDialog.isShowing()) {
			mMyProgressDialog.dismiss();
		}
		if (mpd2 != null && mpd2.isShowing()) {
			mpd2.dismiss();
		}
	}

	public String md5(String string) {
		byte[] hash;
		try {
			hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Huh, MD5 should be supported?", e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Huh, UTF-8 should be supported?", e);
		}
		StringBuilder hex = new StringBuilder(hash.length * 2);
		for (byte b : hash) {
			if ((b & 0xFF) < 0x10) {
				hex.append("0");
			} else {
				hex.append(Integer.toHexString(b & 0xFF));
			}
		}
		return hex.toString();
	}

	public String decodeBase64(String content) {
		try {
			byte[] bs = Base64.decode(content, Base64.DEFAULT);
			return new String(bs, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "decodeBase64 error";
	}

	public String ecodeBase64(String content) {
		try {
			return Base64.encodeToString(content.getBytes("UTF-8"), Base64.DEFAULT);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "ecodeBase64 error";
	}

	public JSONObject getJSON(String json) {
		try {
			return new JSONObject(json);
		} catch (JSONException e) {
			return null;
		}
	}

	public int dip2px(float dpValue) {
		final float scale = ctx.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	// 取幕
	public int getScreenWidth() {
		DisplayMetrics metrics = new DisplayMetrics();
		act.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int width = metrics.widthPixels;// 幕龋兀
		return width;
	}

	// 取幕
	public int getScreenHeight() {
		DisplayMetrics metrics = new DisplayMetrics();
		act.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int width = metrics.heightPixels;// 幕龋兀
		return width;
	}


	public Date getDate(String time, String ff) {// yyyy-MM-dd HH:mm:ss
		SimpleDateFormat formatter = new SimpleDateFormat(ff);
		// String dateString = formatter.format(currentTime);
		Date date = null;
		try {
			date = formatter.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public String getPic(Intent data) {
		Bitmap photo = null;
		Uri uri = data.getData();
		if (uri != null) {
			photo = BitmapFactory.decodeFile(uri.getPath());
		}
		if (photo == null) {
			Bundle bundle = data.getExtras();
			if (bundle != null) {
				photo = (Bitmap) bundle.get("data");
			} else {
				return null;
			}
		}

		FileOutputStream fileOutputStream = null;
		try {
			// 获取 SD 卡根目录
			String saveDir = Environment.getExternalStorageDirectory() + "/meitian_photos";
			// 新建目录
			File dir = new File(saveDir);
			if (!dir.exists())
				dir.mkdir();
			// 生成文件名
			SimpleDateFormat t = new SimpleDateFormat("yyyyMMddssSSS");
			String filename = "MT" + (t.format(new Date())) + ".jpg";
			// 新建文件
			File file = new File(saveDir, filename);
			// 打开文件输出流
			fileOutputStream = new FileOutputStream(file);
			// 生成图片文件
			photo.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
			// 相片的完整路径
			String picPath = file.getPath();

			if (photo != null && !photo.isRecycled()) {
				photo.recycle();
				photo = null;
			}

			return picPath;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	public void startActivity(Class cls) {
		Intent i = new Intent(ctx, cls);
		ctx.startActivity(i);
	}
	
	public void startActivity(Class cls, Bundle value) {
		Intent i = new Intent(ctx, cls);
		i.putExtra("args", value);
		ctx.startActivity(i);
	}

	public void startActivityForResult(Class cls, int requestCode) {
		Intent intent = new Intent(ctx, cls);
		act.startActivityForResult(intent, requestCode);
	}

	public void startActivityForResult(Class cls, int requestCode, Bundle value) {
		Intent intent = new Intent(ctx, cls);
		intent.putExtra("args", value);
		act.startActivityForResult(intent, requestCode);
	}

	public Bundle getArgs() {
		Intent intent = act.getIntent();
		Bundle value = intent.getBundleExtra("args");
		return value;
	}
	
	
}
