package com.yedam.app.emp.mapper;

import java.util.List;
import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	// SQL문을 실행할 메소드만 있으면 된다
	public List<EmpVO> selectEmpList();
}
