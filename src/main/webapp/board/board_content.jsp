<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>

<div align="center" class="div_center">

    <h3>게시글</h3>
    <hr>
    <table border="1" width="500">
        <tr>
            <td>ID</td>
            <td>${vo.id}</td>
        </tr>

        <tr> <!--이미지-->
            <td colspan="3" height="300px" style="text-align: center;">
                <div style="display: flex; align-items: center; justify-content: center; height: 100%;">
                    <img src="img/${vo.img}" alt="이미지1" style="max-width: 90%; max-height: 90%;">
                </div>
            </td>
        </tr>

        <tr>
            <td>좋아요 수</td>
            <td align="right">
                <input type="button" value="❤️">
            </td>
        </tr>

        <tr>
            <td width="20%">글내용</td>
            <td colspan="3" height="50px">${vo.content}</td>
        </tr>

        <tr>
            <td>작성일</td>
            <td>${vo.time}</td>
        </tr>

        <tr>
            <td colspan="4" align="center">
                <input type="button" value="목록" onclick="location.href='<%=request.getContextPath()%>/user/user_mypage.user'">&nbsp;&nbsp;
                <input type="button" value="수정" onclick="location.href='board_modify.board?number=${vo.number}&img=${vo.img}'">&nbsp;&nbsp;
                <input type="button" value="삭제" onclick="location.href='board_delete.board?number=${vo.number}'">&nbsp;&nbsp;
            </td>
        </tr>
    </table>


</div>

<%@ include file="../include/footer.jsp" %>
