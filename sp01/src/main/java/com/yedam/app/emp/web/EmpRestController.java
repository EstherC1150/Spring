package com.yedam.app.emp.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@CrossOrigin("*") //CORS와 관련해 허용하겠다: 스프링이 지원하는 어노테이션, 자주 쓰진 않지만 아주 간단하게 어느 오리진을 허용할지 클래스별로 설정하는 어노테이션임
//@Controller
@RestController	//이 내부에 있는 모든 메서드는 데이터를 반환한다 라는 의미: 각 메서드가 가지고 있는 @ResponseBody 생략 가능
public class EmpRestController {
	@Autowired
	EmpService empService;
	
	//전체조회
	@GetMapping("emps")
	//@ResponseBody
	public List<EmpVO> getEmpList() {
		return empService.getEmpAll();
	}
	//단건조회
	@GetMapping("emps/{eid}")
	//@ResponseBody
	public EmpVO getEmpInfo(@PathVariable Integer eid) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(eid);
		return empService.getEmpInfo(empVO);
	}
	
	//등록
	@PostMapping("emps")
	//@ResponseBody
	public Map<String, Object> insertEmp(@RequestBody EmpVO empVO) {
		int eid = empService.insertEmpInfo(empVO);
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", eid);
		return map;
	}
	
	//수정
	@PutMapping("emps/{eid}")
	//@ResponseBody
	public Map<String, Object> updateEmpInfo(@PathVariable Integer eid, @RequestBody EmpVO empVO) {
		empVO.setEmployeeId(eid);
		return empService.updateEmpInfo(empVO);
	}
	
	//삭제
	@DeleteMapping("emps/{eid}")
	//@ResponseBody
	public boolean deleteEmpInfo(@PathVariable Integer eid) {
		return empService.deleteEmpInfo(eid);
	}
}
