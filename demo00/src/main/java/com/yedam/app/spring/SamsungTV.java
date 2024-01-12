package com.yedam.app.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
//@Component() --> 이렇게 할 시 class를 불러주면 된다
public class SamsungTV implements TV {
//	필드 방식의 injection
	@Autowired
	Speaker speaker;

//	@Autowired
	// 1. 생성자 방식
	SamsungTV(Speaker speaker) {
		this.speaker = speaker;
	}

	// setter injection을 사용하기 위해서 기본 생성자 코드 명시한 추가코드, 위에 생성자 사용 안하려고! 위에 생성자 주석처리하면
	// 안 만들어줘도 됨
	SamsungTV() {
	}

	// 사용하고자 하는 위치에 따라 Autowired를 붙여주면 된다
//	@Autowired
	// 2. setter 방식
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	@Override
	public void on() {
		System.out.println("삼성 TV를 켰습니다.");
		speaker.on();
	}
}
