package com.yedam.java.book.service;

import lombok.Data;

@Data
public class BookRentVO {
	private Integer bookNo;
	private String bookName;
	private Integer sumPrice;
	private Integer cntStat;
}
