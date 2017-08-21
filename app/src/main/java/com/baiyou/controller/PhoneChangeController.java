package com.baiyou.controller;

import com.baiyou.utils.Helper;

public class PhoneChangeController {
	private ControllerView view;
	private Helper helper;


	public PhoneChangeController(ControllerView view,Helper helper){
		this.view = view;
		this.helper = helper;
	}
	
	
	public interface ControllerView{
		
	}
}
