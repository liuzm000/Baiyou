package com.baiyou.controller;

import com.baiyou.utils.Helper;

public class SignUpController {

	ControllerView view;
	Helper helper;

	public SignUpController(ControllerView view, Helper helper) {
		this.view = view;
		this.helper = helper;
	}

	public interface ControllerView {
		void next();
	}

}
