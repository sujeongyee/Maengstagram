<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../include/header.jsp" %>

<body>
<div class="container">
    <div class="profile-header">
        <img class="profile-image" src="../img/${vo.photo}"
             style="width: 70px; height: 70px; border-radius: 50%; border: 1px solid #ccc;" alt="프로필 이미지">
        <div class="profile-info">
            <div class="profile-info-text">
                <h4>${vo.id}</h4>
                 <p> <a href="user_followingFriend.follow?id=${user_id}">팔로워</a> : ${followerCount}  | <a href="user_followerFriend.follow?id=${user_id}">팔로잉</a> : ${followingCount} <input type = button value = "정보수정하기" style="background:white;" onclick = "location.href = 'user_modify.user'"></p>
               
                <p>${vo.intro}</p>
            </div>
        </div>
    </div>

    <hr>

    <div class="long-hr">
    </div>

    <style>
        .gallery {
            display: flex;
            flex-wrap: nowrap;
            justify-content: space-between;
        }
    </style>
    <br/><br/><br/><br/><br/><br/>

    <div class="gallery">
        <c:forEach var="vo2" items="${list}" varStatus="x">
            <div class="gallery-image" style="width: calc(33.33% - 10px);">
                <a href="../board/board_content.board?number=${vo2.number}">
                    <div class="image-container">
                        <img src="../img/${vo2.img}" alt="이미지1">
                    </div>
                </a>
            </div>
        </c:forEach>
    </div>
    <br/><br/><div class="center-content">
        <c:if test="${empty list}">
            <div class="no-posts">
                <div class="no-posts-content">
                    <p>게시물이 없습니다😭<br/>
                        게시물을 작성해보세요.</p>
                    <a href="../board/board_write.jsp" class="button">버튼</a>
                </div>
            </div>
        </c:if>
    </div>
</div><br/><br/><br/><hr/>

    

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
