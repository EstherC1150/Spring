<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 사원 조회</title>
</head>
<body>
	<div class="container">
		<button></button>
		<table border="1">
			<thead>
				<tr>
					<th>No.</th>
					<th>employee_id</th>
					<th>last_name</th>
					<th>email</th>
					<th>hire_date</th>
					<th>job_id</th>
					<th>salary</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${empList}" var="info" varStatus="sts">
					<!-- info = empVO다! -->
					<tr onclick="location.href='empInfo?employeeId=${info.employeeId}'">
						<td>${sts.count}</td>
						<td>${info.employeeId}</td>
						<td>${info.lastName}</td>
						<td>${info.email}</td>
						<td>
							<fmt:formatDate value="${info.hireDate}" pattern="yyyy년MM월dd일"/>
						</td>
						<td>${info.jobId}</td>
						<td>${info.salary}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 내부에 el태그 쓰지말기 왜냐하면 그 자체가 주석이 안먹힘... -->
		<!-- JSP -> Servlet -> Java => html -> css -> javascript -->
	</div>
</body>
</html>