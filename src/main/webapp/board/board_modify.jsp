<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp" %>

<div align="center" class="div_center">
	<form action="board_update.board" method="post">
		<input type="hidden" name="number" value="${vo.number}">

		<h3>게시글 수정</h3>
		<hr>
		<table border="1" width="500">

			<tr> <!--이미지-->
				<td colspan="3" height="300px" style="text-align: center;">
					<div style="display: flex; align-items: center; justify-content: center; height: 100%;">
						<img src="../img/${vo.img}" alt="이미지1" style="max-width: 90%; max-height: 90%;">
						<input type="hidden" name="img" value="${vo.img}">
					</div>
				</td>
			</tr>

			<tr>
				<td width="20%">글내용</td>
				<td colspan="3" height="150px">
					<textarea rows="10" style="width: 95%;" name="content">${vo.content}</textarea>
				</td>
			</tr>

			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정하기">&nbsp;&nbsp;
					<input type="button" value="취소" onclick="location.href='../user/user_mypage.jsp'">
				</td>
			</tr>
		</table>
	</form>
</div>

  <%@ include file = "../include/footer.jsp" %>