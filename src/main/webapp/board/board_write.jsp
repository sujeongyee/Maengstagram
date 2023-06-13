<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../include/header.jsp"%>

<div align="center" class="div_center">
	<h3>게시글 작성</h3>
	<hr>

	<form action="writeForm.board" method="post">
		<table border="1" width="500">

<%--			<tr>--%>
<%--				<td>ID</td>--%>
<%--				<td>--%>
<%--					<input type="text" name="writer" size="10" value="${sessionScope.ID}">--%>
<%--				</td>--%>
<%--			</tr>--%>

			<tr>
				<td align="center">글 내용</td>
				<td>
                    <textarea rows="10" style="width: 95%; color: ${empty param.content ? '#999' : '#000'};" name="content" onfocus="if (this.value === '본문을 입력하세요.') {this.value = ''; this.style.color = '#000';}" onblur="if (this.value === '') {this.value = '본문을 입력하세요.'; this.style.color = '#999';}">${empty param.content ? '본문을 입력하세요.' : param.content}</textarea>

                </td>
			</tr>
			<tr>
				<td align="center" >사진</td>
				<td>
					<input type="file" name="img" size="45">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="작성 완료" onclick="">
					&nbsp;&nbsp;
					<input type="button" value="취소" onclick = "location.href='../user/user_mypage.jsp'">
				</td>
			</tr>

		</table>
	</form>

</div>
<%@ include file = "../include/footer.jsp"%>