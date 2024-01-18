<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- 경우에 따라서는 버전때문에 우리 코드가 수행이 안되는 경우도 있으니 잘 확인하기 -->

<div class="container">
	<h1>자유 게시판</h1>
	<table class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th><!-- yyyy년MM월dd일 -->
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boardList}" var="board" varStatus="sts">
				<tr onclick="location.href='boardInfo?bno=${board.bno}'">
					<td>${board.bno}</td>
					<td>${board.title}</td>
					<td>${board.writer}</td>
					<td>
						<fmt:formatDate value="${board.regdate}" pattern="yyyy년MM월dd일 HH시mm분ss초"/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>