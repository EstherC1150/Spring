<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<h1>게시글 등록</h1>
	<form name="insertForm" action="boardInsert" method="post">
		<table class="table">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents"></textarea></td>
			</tr>
			<tr>
				<th>이미지</th><!-- app.jpg를 입력한다고 생각을 하고 페이지를 완성하면 된다 -->
				<td><input type="text" name="image"></td>
			</tr>
		</table>
		<button class="btn btn-primary" type="submit">등록</button>
	</form>
</div>
<script>
	//자바스크립트
	document.querySelector('form[name="insertForm"]')
			.addEventListener('submit', boardInsertJs);

	function boardInsertJs(event) {
		event.preventDefault();

		//전부 다 배열로 넘어오기 때문에 인덱스를 기반으로 하나로 좁히기
		let title = document.getElementsByName('title')[0];
		let writer = document.getElementsByName('writer')[0];

		//value 속성은 사용자가 값을 입력했든 하지 않았든 null을 반환하지 않음 그래서 비교값은 반드시 공백이어야 함
		if(title.value == '') {
			alert('제목이 입력되지 않았습니다.');
			//태그기반으로 동작가능하기 때문에 태그를 가져온것 ↓
			title.focus();
			//이 의미는 함수 자체를 종료시키는 것 그렇다고 break랑 상관없음 break는 반복문과 상관있음 그래서 return을 기반으로 핸들러를 stop시키기
			return;
		}
		//if-else로 묶으면 안된다. 개별개별 확인해야 하기 때문에 따로따로 if로 해야함
		if(writer.value == '') {
			alert('작성자가 입력되지 않았습니다.');
			writer.focus();
			return;
		}
		//insertForm Form태그가 가지고 있는 name속성: 하나의 변수로 본다. 그래서 바로 부르면 됨 form태그가 가지고 있는 submit을 강제로 발생시키기
		insertForm.submit();
	}

	document.querySelector('form[name="insertForm"]')
			.removeEventListener('submit', boardInsertJs);
	//jQuery
	//일단은 가져와서, submin에 on으로 이벤트 걸기
	$('form[name="insertForm"]').on('submit', boardInsertJq);

	function boardInsertJq(event) {
		event.preventDefault();

		let title = $('[name="title"]');
		let writer = $('[name="writer"]');

		if(title.val() == '') {
			alert("제목을 확인해주세요.");
			title.focus();
			return;
		}

		if(writer.val() == '') {
			alert("작성자를 확인해주세요.");
			writer.focus();
			return;
		}
		insertForm.submit();
	}

</script>