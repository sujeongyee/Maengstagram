<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<style>
    .profile-image {
        width: 40px;
        height: 40px;
        object-fit: cover;
        object-position: center;
        border-radius: 50%;
    }

    .following {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        text-align: center;
    }

    .following-list {
        list-style-type: none;
        padding: 0;
        margin: 0;
    }

    .follower-info {
        display: flex;
        align-items: center;
        justify-content: center;
        margin-bottom: 10px;
        text-align: center;
    }

    .follower-info span {
        font-weight: bold;
    }
</style>

<body>
<div class="following">
    <h2>팔로잉</h2>
    <ul class="following-list">
        <c:forEach var="vo" items="${list}" varStatus="x">
            <li>
                <div class="follower-info">
                   <a href = "search.user?search_id=${vo.id}"> <img class="profile-image" src="../img/${vo.photo}" alt="프로필 이미지"></a>
                    <span>${vo.id}</span>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
