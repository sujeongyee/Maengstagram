<%@ page language="java" contentType="text/html; charset=UTF-8"

         pageEncoding="UTF-8" %>
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
                <p>팔로워 : 1009 | 팔로잉 : 13</p>
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


    <div class="gallery">
        <c:forEach var="vo" items="${list}" varStatus="x">
            <div class="gallery-image" style="width: calc(33.33% - 10px);">
                <a href="${request.getContextPath()}/board/board_content.board?number=${vo.number}">
                    <div class="image-container">
                        <img src="../img/${vo.img}" alt="이미지1">
                    </div>
                </a>
            </div>
        </c:forEach>
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
    </style>
</div>

