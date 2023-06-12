<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
	
	<%@include file ="include/header.jsp" %>

<div align="center" class="container">
  <c:choose>
    <c:when test="${list.size() == 0}">
<div style="text-align: center;">
</div>
<br/>
<br/>
<h2 style="font-family: 'omyu_pretty', sans-serif; color: #333; text-align: center; font-size: 40x;">아직  FOLLING 한 친구가 없으시군요!</h2>
<br/>
<p style="font-family: 'omyu_pretty', sans-serif; color: #666; text-align: center; font-size: 25px;"> 🔍검색하기를 이용하여 친구를 찾아보세요!</p>
<div style="text-align: center;">
  <a href="/board/board_write.board" style="font-family: 'omyu_pretty', sans-serif; color: #0088cc; text-decoration: none; font-size: 16px;"><img src = "/maengstagram/img/run.gif"><br/><h3>>>친구찾기<<</h3></a>
</div>
<br/>
    </c:when>

      <c:otherwise>
      
      <c:forEach var = "vo" items= "${list}" varStatus="x">
      <br/>
   
      <!--프로필사진경로 넣기---ㄱ-->
      <div align="left" class="container" style="text-align: left;">
      <h4><img src="img/${vo.user_photo}" style="width: 70px; height: 70px; border-radius: 50%; border: 4px solid skyblue;"> ${vo.fol_id}</h4><!--작성자 이미지경로  -->
      </div>
      <a href = "board/board_content.board?post_num=${vo.post_num}"><img src="img/${vo.post_img}"></a><br/>  <!--  상세페이지로이동시키기-->
      <h4>${vo.post_content}</h4>  
      <div align="left" class="container" style="text-align: left;">
      <h4><input type="button" value="❤️" onclick="location.href='likeUpdate.main?post_num=${vo.post_num}'">좋아요수:  ${vo.post_like}   <!--좋아요수--><br/></h4>
         

      <br/>
            
            <form action="regist_comment.main">
             <input type = "text" style="width:700px;height:40px;" name = "comment" >
             <input type= "hidden"  name="post_num" value="${vo.post_num}">
            <p> </p><input type = "submit" value = "댓글 달기" >
            </form>
           
           
            <h3>댓글목록💌</h3>
            <br/>
             <c:forEach var = "vo2" items = "${list2[x.index]}">
            	
            <h5>${vo2.user_id} :  ${vo2.com_content}</h5>
             </c:forEach>
             
            
            
            <hr/>
            </c:forEach>
            </c:otherwise>
            
            </c:choose>
			
			
	</div>
	
  