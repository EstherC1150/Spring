package com.yedam.app.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.mapper.AaaMapper;
import com.yedam.app.aop.service.AaaService;

@Service
public class AaaServiceImpl implements AaaService {
	
	@Autowired
	AaaMapper aaaMapper;
	
	@Transactional	//mapper가 아니라 @Service 밑에서만 동작한다!: 기능 안에서 사용되는 여러개의 메서드가 같이 묶일 수 있도록 메서드 단위로 보통 붙인다.
	public void insert() {
		aaaMapper.insertAaa("101");
		aaaMapper.insertAaa("a101");
	}
}
