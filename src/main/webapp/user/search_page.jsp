<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../include/header.jsp" %>

<body>







<div class="container">
    <div class="profile-header">
        <img class="profile-image" src="../img/${search_info.photo}"
             style="width: 70px; height: 70px; border-radius: 50%; border: 1px solid #ccc;" alt="프로필 이미지">
        <div class="profile-info">
            <div class="profile-info-text">
                <h4>${search_info.id}</h4>
                <p> <a href="user_followingFriend.follow?id=${search_info.id}">팔로워</a> : ${followerFriendCount}  | <a href="user_followerFriend.follow?id=${search_info.id}">팔로잉</a> : ${followingFriendCount} <c:choose>
	<c:when test="${user_id==search_info.id}"></c:when>
	<c:otherwise>
	<c:choose>
    <c:when test="${check==null}"><input type="button" value="팔로우하기" onclick="location.href='user_search_followUpdate.user?search_id=${search_info.id}'"></c:when>
    <c:otherwise><input type="button" value="팔로우취소" onclick="location.href='user_search_followDelete.user?search_id=${search_info.id}'"></c:otherwise>
</c:choose>
	
	</c:otherwise>
</c:choose></p>     
                <p>${search_info.intro}</p>
            </div>
        </div>
    </div>

<br/><br/><br/>


    <style>
        .gallery {
            display: flex;
            flex-wrap: nowrap;
            justify-content: space-between;
        }
    </style>

    <div class="gallery">
        <c:forEach var="vo2" items="${search_list}" varStatus="x">
            <div class="gallery-image" style="width: calc(33.33% - 10px);">
                <a href="../board/board_content.board?number=${vo2.number}">
                    <div class="image-container"  >
                        <img src="../img/${vo2.img}" alt="이미지1" width="200">
                    </div>
                </a>
            </div>
        </c:forEach>
    </div>

    <div class="center-content">
        <c:if test="${empty search_list}">
            <div class="no-posts">
                <div class="no-posts-content">
                    <p>게시물이 없습니다😭<br/></p>
                </div>
            </div>
        </c:if>
    </div>
</div>

<style>
    .profile-header {
        display: flex;
        align-items: center;
    }

    .profile-image {
        width: 45px;
        height: 45px;
        margin-right: 10px;
    }

    .profile-info {
        display: flex;
        align-items: center;
    }

    .profile-info-text {
        margin-left: 10px;
    }

    .profile-info h4 {
        margin: 0;
        font-size: 18px;
        font-weight: bold;
    }

    .profile-info p {
        margin: 0;
        font-size: 14px;
    }

    .gallery {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
    }

    .gallery-image {
        width: calc(33.33% - 10px);
        margin-bottom: 20px;
    }

    .image-container {
        width: 100%;
        padding-bottom: 100%;
        position: relative;
        overflow: hidden;
    }

    .image-container img {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        object-fit: cover;
        border-radius: 5px;
    }

    .no-posts {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 300px;
    }

    .center-content {
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .no-posts-content {
        text-align: center;
    }

    .no-posts p {
        font-size: 16px;
        margin-bottom: 10px;
    }

    .button {
        display: inline-block;
        padding: 12px 24px;
        background-color: #FF5A5F;
        color: #fff;
        text-decoration: none;
        border-radius: 30px;
        transition: background-color 0.3s ease;
    }

    .button:hover {
        background-color: #FF1D23;
    }
</style>

</div>