package com.yedam.java.book.mapper;

import java.util.List;

import com.yedam.java.book.service.BookRentVO;
import com.yedam.java.book.service.BookVO;

public interface BookMapper {
	//도서 전체 조회
	public List<BookVO> selectBookList();
	
	//도서 대여 현황 조회
	public List<BookRentVO> selectBookRentList();
	
	//등록
	public int insertBook(BookVO bookVO);
	
	//다음 번호 get하기
	public int insertBookNum();
}
