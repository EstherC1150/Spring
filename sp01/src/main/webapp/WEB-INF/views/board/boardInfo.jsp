<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
	<h1>게시글 조회</h1>
		<table class="table">
			<tr>
				<th>번호</th>
				<td>${boardInfo.bno}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${boardInfo.title}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${boardInfo.writer}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="3" cols="2" style="width:100px;" readonly>${boardInfo.contents}</textarea></td>
			</tr>
			<tr>
				<th>이미지</th>
				<td><img style="width:200px;" src="<c:url value='/resources/${boardInfo.image}'/>"></td>
			</tr>
			<tr>
				<th>작성날짜</th>
				<td><fmt:formatDate value="${boardInfo.regdate}" pattern="yyyy년MM월dd일 HH시mm분ss초"/></td>
			</tr>
		</table>
		<button class="btn btn-primary" onclick="location.href='boardUpdate?bno=${boardInfo.bno}'" type="button">수정</button>
		<button class="btn btn-warning" onclick="location.href='boardDelete?bno=${boardInfo.bno}'" type="button">삭제</button>
</div>

