package com.baiyou.controller;

import com.baiyou.utils.Helper;

public class MainActivityController {

	ControllerView view;
	Helper helper;

	public MainActivityController(ControllerView view, Helper helper) {
		this.view = view;
		this.helper = helper;
	}

	public interface ControllerView {
	}

}
