package com.yedam.app.java;

public class LGTV implements TV {

	// @이 이게 어노테이션...
	@Override
	public void on() {
		System.out.println("LG TV를 켰습니다.");
	}

}
