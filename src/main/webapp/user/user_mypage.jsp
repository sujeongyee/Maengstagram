<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp"%>

<section>
	<div align = "center">
		<h3>회원정보 페이지</h3>
		${sessionScope.user_id}
		(${sessionScope.user_name}) 님의 정보를 관리중입니다.
		
		<a href = "user_modify.user">회원수정</a>
		
		<a href = "user_logout.user">로그아웃</a>
		
		<a href = "user_delete.user">회원탈퇴</a>
		
	</div>

</section>

<script>

	<!--alert("안녕하세요 자바스크립트란 이런거에요");-->

</script>


<%@ include file = "../include/footer.jsp"%>