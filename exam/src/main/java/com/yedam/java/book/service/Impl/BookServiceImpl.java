package com.yedam.java.book.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.book.mapper.BookMapper;
import com.yedam.java.book.service.BookRentVO;
import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookMapper bookMapper;

	@Override
	public List<BookVO> getBookAll() {
		return bookMapper.selectBookList();
	}

	@Override
	public List<BookRentVO> getBookRentAll() {
		return bookMapper.selectBookRentList();
	}

	@Override
	public int insertBookInfo(BookVO bookVO) {
		int result = bookMapper.insertBook(bookVO);
		if(result == 1) {
			return bookVO.getBookNo();
		} else {
			return -1;
		}
	}

	@Override
	public int getBookNum() {
		return bookMapper.insertBookNum();
	}
	
	
}
