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

<h2 style=" color: #333; text-align: center; font-size: 40x;">아직  FOLLING 한 친구가 없으시군요!</h2>
<br/>
<p style=" color: #666; text-align: center; font-size: 25px;"> 🔍검색하기를 이용하여 친구를 찾아보세요!</p>
<div style="text-align: center;">
  <a href="user/user_search.user" style="" color: #0088cc; text-decoration: none; font-size: 16px;"><img src = "img/맹구5.gif"><br/><h3>친구찾기</h3></a>

</div>
<br/>
    </c:when>

      <c:otherwise>
      
      <c:forEach var = "vo" items= "${list}" varStatus="x">
      <br/>
   
      <!--프로필사진경로 넣기---ㄱ-->
     <div align="left">
      <a href = "user/search.user?search_id=${vo.fol_id}">
      
      <img src="img/${vo.user_photo}" style="width: 70px; height: 70px; border-radius: 50%; border: 4px solid skyblue;" >
      <b style="font-size: 20px; color: black; text-decoration: none;">&nbsp;&nbsp;${vo.fol_id}</b></a>
      </div>
      
     <!--작성자 이미지경로  -->
      </div>
      <br/>
      <div align="center"><a href = "board/board_content.board?number=${vo.number}"><img src="img/${vo.post_img}"></a><br/> </div> <!--  상세페이지로이동시키기-->

       <div align="left" class="container" style="text-align: left;">
     <br/>
      <h4>${vo.content}</h4>  
     <br/>
      <h4><input type="button" value="❤️" onclick="location.href='likeUpdate.main?number=${vo.number}'"> 좋아요수 : ${vo.post_like}
      <c:choose>
         <c:when test="${vo.number == number2 }">
           ${msg }</c:when>
         <c:otherwise>  ${msg } </c:otherwise>
      </c:choose>


       <c:if test = "${vo.number == number2 }"> ${msg2 } </c:if>  <!--좋아요수--><br/></h4>

         

      <br/><br/>
            
            <form action="regist_comment.main">
             <input type = "text" style="width:700px;height:40px;" name = "comment" >
             <input type= "hidden"  name="number" value="${vo.number}">
            <p> </p><input type = "submit" value = "댓글 달기" >
            </form>
           
           

            <h3>댓글목록 💌 (${list2[x.index].size()})</h3> 
            <br/>
             <c:forEach var = "vo2" items = "${list2[x.index]}" begin="0" end="1">

               
            <h5>${vo2.user_id} :  ${vo2.com_content}</h5>
             </c:forEach>
             

            <br/>
            <style>
           .long-hr {
    border: none;
    height: 1px;
    background-color: gray;
    width: 100%;
  }
</style>
<div class="long-hr">
</div> 

            
            
      

            </c:forEach>
            </c:otherwise>
            
            </c:choose>
         
         
   </div>
   
