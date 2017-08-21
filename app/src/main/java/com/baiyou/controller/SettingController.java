package com.baiyou.controller;

import com.baiyou.utils.Helper;

public class SettingController {
	private ControllerView view;
	private Helper helper;


	public SettingController(ControllerView view,Helper helper){
		this.view = view;
		this.helper = helper;
	}
	
	
	public interface ControllerView{
		
	}

}
