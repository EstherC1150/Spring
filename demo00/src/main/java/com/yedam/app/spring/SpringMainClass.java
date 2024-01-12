package com.yedam.app.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
//		GenericXmlApplicationContext : 이렇게 써도되고...
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appicationContext.xml");
		System.out.println("Spring 방식");

		// 동작하는 코드는 건드리지 않고 xml파일 경로, bean에 있는 것만 건드려주면 결과가 다르게 나옴
		// 직접적으로 New 써서 하지 않기에 유지보수에도 도움을 많이 준다
		TV tv = (TV) ctx.getBean("tv");

//		각 방식에 따라서 컴포넌트로 등록하는 방식이 달라짐 : 이름이 붙으면 bean도 이름이 있어야 하고 이름이 없으면 bean도 별도로 이름이 필요 없음
//		TV tv = (TV)ctx.getBean(TV.class);
		tv.on();
	}

}
