<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp"%>

<section>
	<div align = "center">
		<h3>회원정보수정</h3>
		<b>${sessionScope.user_name}님 회원 정보를 수정합니다</b>
		
		<!-- 
		readonly는 태그의 읽기전용
		disable는 태그의 사용금지 (파라미터값에서 제외)
		checked는 미리 선택함
		required 는 필수로 값을 지정
		
		인풋태그에 미리 값을 가지려면 value를 사용합니다
		 -->
		
		
		<form action = "user_update.user" method = "post">
				아 이 디 :
				<input type = "text" name = "id" placeholder="아이디를 입력하세요" value = "${vo.id}" required="required" pattern = "\w{4,}" >
					
				<br/>
				비밀번호:
				<input type = "password" name = "pw"  required="required" style="width:175px" pattern="\w{4,}">
				<br/>
				닉 네 임 :
				<input type = "text" name = "name" placeholder= "닉네임을 입력하세요" value = "${vo.name}" style="width:175px">
				<br/>
				
				소개하기:
				<input type = "text" name = "intro" placeholder="상태 메시지를 입력하세요" value = "${vo.intro}"style="width:180px;">
				<br/>
				<br/>
				프로필 사진 변경하기  ↓           <br/><br/>
				<div align="center">
				<input type="file" name="photo" value="프로필사진">
				<br/>
				</div>
			
			<div style = "color: red;">${msg}</div>
			<br/>
			
			<input type = "submit" value = "정보수정">
			<input type = "button" value = "회원페이지로 가기" onclick = "location.href = 'user_mypage.user'">
				
		</form>	
		
	</div>
</section>

<%@ include file = "../include/footer.jsp"%>