<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
	
	<%@include file ="/include/header.jsp" %>
	
	<div class="container">
	
	
			<c:forEach var = "vo" items= "${list}" varStatus="x">
			
						<!--프로필사진경로 넣기---ㄱ-->
					<h3><img src="${vo.content}" style="width: 70px; height: 70px; border-radius: 50%; border: 4px solid purple;"> ${vo.writer}</h3><!--작성자 이미지경로  -->
					<a href = "board_content.board?bno=${vo.bno}"><img src = "${vo.content}"></a><br/>  <!--  상세페이지로이동시키기-->
					 <h5>${vo.title}</h5>  
					<input type = "button" value = "❤️" onclick = "location.href='좋아요수 카운트''">      ${vo.hit}<!--좋아요수-->
					<hr/>
			</c:forEach>	
	</div>
	
    <%@ include file = "../include/footer.jsp" %>