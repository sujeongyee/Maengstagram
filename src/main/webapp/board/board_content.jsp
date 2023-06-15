<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp" %>

<div align="center" class="div_center">

    <h3>게시글</h3>
    <hr>
    <table border="1" width="1000">
        <tr>
            <td>ID</td>
            <td>${vo.id}</td>
        </tr>

        <tr> <!--이미지-->
            <td colspan="3" height="300px" style="text-align: center;">
                <div style="display: flex; align-items: center; justify-content: center; height: 100%;">
                    <img src="../img/${vo.img}" alt="이미지1" style="max-width: 90%; max-height: 90%;">
                </div>
            </td>
        </tr>

        <tr>
                 <td>좋아요 수</td>
            <td >
            	<c:choose>
				<c:when test="${ddu==null}"> <input type = "button" value = "🤍" onclick = "location.href='likeUpdate.board?number=${vo.number}'"></c:when>  
				<c:otherwise><input type = "button" value = "❤" onclick = "location.href = 'likeDelete.board?number=${vo.number}'"></c:otherwise>         
       			</c:choose>좋아요수 : ${vo.post_like}
       			
        	</td>

        </tr>

        <tr>
            <td width="20%">글내용</td>
            <td colspan="3" height="50px"><h5>${vo.content}</h5></td>
        </tr>

        <tr>
            <td>작성일</td>
            <td><fmt:formatDate value="${vo.time }" pattern="yyyy-MM-dd HH:mm(E)"/></td>
        </tr>
        
              
        
        
		
        <tr>
            <td colspan="4" align="center">
                <input type="button" value="목록" onclick="location.href='<%=request.getContextPath()%>/user/search.user?search_id=${vo.id}'">&nbsp;&nbsp;
                <input type="button" value="수정" onclick="location.href='board_modify.board?number=${vo.number}&img=${vo.img}&id=${vo.id}'">&nbsp;&nbsp;
                <input type="button" value="삭제" onclick="location.href='board_delete.board?number=${vo.number}&id=${vo.id}'">&nbsp;&nbsp;
            </td>
        </tr>
    </table>
   
    <br/>
 
<br/><br/>
<form action="regist_comment.main">
             <input type = "text" style="width:700px;height:40px;" name = "comment" >
             <input type= "hidden"  name="number" value="${vo.number}">
            <p> </p><input type = "submit" value = "댓글 달기" >
            </form>
	

</div>
<br/>
<br/>
<br/>
<div align="center">
<div align="left">
    <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글목록 💌</h3>
            <br/>
             <c:forEach var = "c_list" items = "${c_list}">

            	
          <h5> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${c_list.user_id} :  ${c_list.com_content}</h5> 
         
          <div align="right"> <c:choose> <c:when test="${c_list.user_id==user_id}">
          <input type = "button" value = "댓글삭제하기" size="10;" style=" font-size: 3;" 
          onclick = "location.href='<%=request.getContextPath()%>/user/deleteComment.user?com_num=${c_list.com_num}&number=${vo.number}'" ></c:when> 
          <c:otherwise> <br/></c:otherwise></c:choose></div>
          
           
         
             </c:forEach>
             <br/>
 <br/> <br/> <br/> <br/><hr/>
            <br/>
    </div>
</div>
  <%@ include file = "../include/footer.jsp" %>