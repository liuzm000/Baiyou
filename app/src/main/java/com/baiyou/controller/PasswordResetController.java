package com.baiyou.controller;
import com.baiyou.utils.Helper;

public class PasswordResetController {
	private ControllerView view;
	private Helper helper;


	public PasswordResetController(ControllerView view,Helper helper){
		this.view = view;
		this.helper = helper;
	}
	
	
	public interface ControllerView{
		
	}
}
