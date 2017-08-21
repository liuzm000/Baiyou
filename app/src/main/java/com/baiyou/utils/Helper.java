package com.baiyou.utils;

import org.library.utils.HelperUtils;

import com.baiyou.R;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Helper extends HelperUtils {

	public Helper() {
		super();
	}

	public Helper(Context ctx, Activity act) {
		super(ctx, act);
	}
	
	/**
	 * 设置titlebar
	 * @param hasLeft 是否有返回
	 * @param titleID 标题的资源
	 * @param hasRight 是否有菜单
	 * */
	public void initTitleBar(boolean hasLeft,int titleID,boolean hasRight){
	     TextView tv_left = (TextView) ((Activity)ctx).findViewById(R.id.left);
	     TextView tv_center = (TextView) ((Activity)ctx).findViewById(R.id.center);
	     TextView tv_right = (TextView) ((Activity)ctx).findViewById(R.id.right);
	     if(hasLeft){
	    	 tv_left.setVisibility(View.VISIBLE);
	    	 tv_left.setText(" ");
	    	 tv_left.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					((Activity)ctx).finish();
				}
			});
	     }else{
	    	 tv_left.setVisibility(View.GONE);
	     }
	    	 tv_center.setVisibility(View.VISIBLE);
	    	 tv_center.setText(ctx.getResources().getString(titleID));
	    	 if(hasRight){
	    		 tv_right.setVisibility(View.VISIBLE);
	    		 tv_right.setText("完成");
	    	 }else{
	    		 tv_right.setVisibility(View.GONE);
	    	 }
	}
	
	public void initTitleBar(boolean hasLeft,int titleID,boolean hasRight,OnClickListener rightClickListener){
	   initTitleBar(hasLeft, titleID, hasRight);
	   TextView tv_right = (TextView) ((Activity)ctx).findViewById(R.id.right);
	   tv_right.setOnClickListener(rightClickListener);
	}
	
	
}
