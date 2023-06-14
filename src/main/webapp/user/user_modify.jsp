<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp"%>

<section>
	<div align = "center">

		<h3>회원 정보 수정</h3>

		<hr/>
		<br/>
		<b>${sessionScope.user_id}님 회원 정보를 수정합니다</b>
		<br/>
		<!-- 
		readonly는 태그의 읽기전용
		disable는 태그의 사용금지 (파라미터값에서 제외)
		checked는 미리 선택함
		required 는 필수로 값을 지정
		
		인풋태그에 미리 값을 가지려면 value를 사용합니다
		 -->
		
		
		<form action = "user_update.user" method = "post">
		<table border = "1">
				<tr>
					<td>아 이 디</td>
					<td><input type = "text" name = "id" value = "${vo.id}" required="required" readonly="readonly" ></td>
				</tr>			
				<tr>
					<td>비밀번호</td>
					<td><input type = "password" name = "pw"  required="required"  pattern="\w{4,}"></td>
				</tr>
				<tr>
					<td>닉 네 임</td>
				<td><input type = "text" name = "nick"  value = "${vo.nick}"></td>
				</tr>
				<tr>
				<td>소개하기</td>
				<td><input type = "text" name = "intro" value = "${vo.intro}"></td>
				</tr>
				<br/>
				</table>
				프로필 사진 변경하기  ↓           <br/><br/>
				<div align="center">
				<input type="file" name="photo" value="프로필사진">
				<br/>
				</div>
			
			<div style = "color: red;">${msg}</div>
			<br/>
			
			<input type = "submit" value = "정보수정">
			
				
		</form>	
		
	</div>
</section>

