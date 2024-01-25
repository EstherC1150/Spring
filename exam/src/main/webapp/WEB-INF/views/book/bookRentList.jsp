<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
	<h3>대여현황조회</h3>
	<table class="table">
		<thead style="text-align:center;">
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>대여총계</th>
				<th>대여횟수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${rentList}" var="bookR" varStatus="sts">
				<tr>
					<td style="text-align:center;">${bookR.bookNo}</td>
					<td style="text-align:left;">${bookR.bookName }</td>
					<td style="text-align:right;"><fmt:formatNumber type="number" maxFractionDigits="3" value="${bookR.sumPrice }" /></td>
					<td style="text-align:right;">${bookR.cntStat }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>