package com.baiyou.controller;

import com.baiyou.utils.Helper;

public class NetCheckController {
	
	
	NetCheckView view;
	Helper helper;
	
	public NetCheckController(NetCheckView view,Helper helper){
		this.view = view;
		this.helper = helper;
	}
	
	
	public interface NetCheckView{
		
	}

}
