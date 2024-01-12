package com.yedam.app.emp.mapper;

import java.util.List;

public interface EmpMapper {
	// SQL문을 실행할 메소드만 있으면 된다
	public List<EmpVO> selectEmpList();
}
