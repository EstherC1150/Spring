package com.yedam.app.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;
import com.yedam.app.emp.mapper.EmpMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	EmpMapper empMapper;
	
	@Override
	public List<BoardVO> getBoardAll() {
		return boardMapper.selectBoardList();
	}

	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		return boardMapper.selectBoard(boardVO);
	}

	@Override
	public int insertBoardInfo(BoardVO boardVO) {
		int result = boardMapper.insertBoard(boardVO);
		if(result == 1) {
			return boardVO.getBno();
		} else {
			return -1;	//의미없는 값, 실제로 bno가 가질 수 없는 값
		}
	}

	@Override
	public Map<String, Object> updateBoardInfo(BoardVO boardVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result = boardMapper.updateBoard(boardVO);
		if(result == 1) {
			isSuccessed = true;	//실제로 업데이트 성공했다면 성공했다고
		}
		map.put("result", isSuccessed);
		map.put("target", boardVO);
		return map;
	}

	@Override
	public boolean deleteBoardInfo(int boardNO) {
		int result = boardMapper.deleteBoard(boardNO);
		
		return result == 1 ? true : false;
	}
}
