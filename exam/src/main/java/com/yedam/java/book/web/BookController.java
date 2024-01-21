package com.yedam.java.book.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.java.book.service.BookRentVO;
import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	//전체조회
	@GetMapping("bookList")
	public String bookList(Model model) {
		List<BookVO> list = bookService.getBookAll();
		model.addAttribute("bookList", list);
		return "book/bookList";
	}
	
	//도서대여전체조회
	@GetMapping("bookRentList")
	public String bookRentList(Model model) {
		List<BookRentVO> list = bookService.getBookRentAll();
		model.addAttribute("rentList", list);
		return "book/bookRentList";
	}
		
	//등록
	@GetMapping("bookInsert")
	public String bookInsertForm(Model model) {
		int nextBookNum = bookService.getBookNum();
		model.addAttribute("bookNo", nextBookNum);
		return "book/bookInsert";
	}
	//등록 - 처리
	@PostMapping("bookInsert")
	public String bookInsertProcess(BookVO bookVO) {
		bookService.insertBookInfo(bookVO);
		return "redirect:bookList"; 
	}
}
