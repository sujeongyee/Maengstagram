<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp"%>


<div align="center" class="div_center">
	<h3>게시판 글 수정 페이지</h3>
	<hr>
	
	<form action="board_update.board" method="post">
	
		<!--  화면에서 보여질 필요는 없지만, 데이터는 form 으로 전송해야 할 때
				input 태그의 hidden 속성을 씁니다. -->
	
		<input type ="hidden" name = "bno" value = "${vo.bno}" >
	
		
		<table border="1" width="500">


			<tr>
				<td align="center">글 내용</td>
				<td>
					<textarea rows="10" style="width: 95%; color: ${empty param.content ? '#999' : '#000'};" name="content" onfocus="if (this.value === '본문을 입력하세요.') {this.value = ''; this.style.color = '#000';}" onblur="if (this.value === '') {this.value = '본문을 입력하세요.'; this.style.color = '#999';}">${empty param.content ? '본문을 입력하세요.' : param.content}</textarea>

				</td>
			</tr>
			<tr>
				<td align="center" >사진</td>
				<td>
					<input type="file" name="picture" size="45">
				</td>
			</tr>

			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정하기" onclick="">&nbsp;&nbsp;
					<input type="button" value="취소" onclick="location.href='../user/user_mypage.jsp'">
				</td>
			</tr>
			
		</table>
	</form>
	
</div>


<%@ include file = "../include/footer.jsp"%>