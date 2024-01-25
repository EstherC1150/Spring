package com.yedam.java.book.service;

import java.util.List;

public interface BookService {
	
	//도서 목록 조회
	public List<BookVO> getBookAll();
	
	//도서 대여 목록 조회
	public List<BookRentVO> getBookRentAll();
	
	//도서 등록
	public int insertBookInfo(BookVO bookVO);
	
	//도서 번호 겟하기
	public int getBookNum();
	
}
