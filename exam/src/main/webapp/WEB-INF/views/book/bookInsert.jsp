<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<h3>도서등록</h3>
	<form name="insertForm" action="bookInsert" method="post">
		<table class="table">
			<tr>
				<th>도서번호</th>
				<td><input type="text" name="bookNo" value="${bookNo}" readonly></td>
			</tr>
			<tr>
				<th>도서명</th>
				<td><input type="text" name="bookName"></td>
			</tr>
			<tr>
				<th>도서표지</th>
				<td><input type="text" name="bookCovering"></td>
			</tr>
			<tr>
				<th>출판일자</th>
				<td><input type="text" name="bookDate"></td>
			</tr>
			<tr>
				<th>금액</th>
				<td><input type="text" name="bookPrice"></td>
			</tr>
			<tr>
				<th>출판사</th>
				<td><input type="text" name="bookPublisher"></td>
			</tr>
			<tr>
				<th>도서소개</th>
				<td><textarea name="bookInfo"></textarea></td>
			</tr>
		</table>
		<button class="btn btn-primary" type="submit">등록</button>
		<button class="btn btn-primary" type="button">조회</button>
	</form>
</div>
<script>
//자바스크립트
document.querySelector('form[name="insertForm"]')
		.addEventListener('submit', bookInsert);

function bookInsert(event) {
	event.preventDefault();

	let title = document.getElementsByName('bookName')[0];

	if(title.value == '') {
		alert('제목이 입력되지 않았습니다.');
		//태그기반으로 동작가능하기 때문에 태그를 가져온것 ↓
		title.focus();
		//이 의미는 함수 자체를 종료시키는 것 그렇다고 break랑 상관없음 break는 반복문과 상관있음 그래서 return을 기반으로 핸들러를 stop시키기
		return;
	}

	//insertForm Form태그가 가지고 있는 name속성: 하나의 변수로 본다. 그래서 바로 부르면 됨 form태그가 가지고 있는 submit을 강제로 발생시키기
	insertForm.submit();
	alert('도서등록이 완료되었습니다.');
}
</script>