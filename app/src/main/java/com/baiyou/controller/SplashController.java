package com.baiyou.controller;

import com.baiyou.utils.Helper;

public class SplashController {
	
	ControllerView view;
	Helper helper;
	
	public SplashController(ControllerView view,Helper helper){
		this.view = view;
		this.helper = helper;
	}
	
	
	public interface ControllerView{
		
	}

}
