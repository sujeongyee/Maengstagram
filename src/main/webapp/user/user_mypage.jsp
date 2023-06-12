<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file = "../include/header.jsp"%>

<body>
<div class="container">
	<div class="profile-header">
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
		</style>

		<img class="profile-image" src="../img/99.png" style="width: 70px; height: 70px; border-radius: 50%; border: 1px solid #ccc;"alt="프로필 이미지">
		<div class="profile-info">
			<div class="profile-info-text">
				<h4>맹구</h4>
				<p>팔로워 : 1009 | 팔로잉 : 13</p>
			</div>
		</div>
	</div>
	<hr/>

	<div class="gallery">
		<div class="gallery-image">
			<img src="../img/11.png" alt="이미지1">
		</div>
		<div class="gallery-image">
			<img src="../img/99.png" alt="">
		</div>
		<div class="gallery-image">
			<img src="../img/22.png" alt="">
		</div>
		<div class="gallery-image">
			<img src="../img/33.png" alt="">
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
				margin-bottom: 10px;
			}

			.gallery-image img {
				width: 100%;
				height: auto;
				object-fit: cover;
				aspect-ratio: 1/1;
			}

			@media (max-width: 768px) {
				.gallery-image {
					width: calc(50% - 10px);
				}
			}

			@media (max-width: 480px) {
				.gallery-image {
					width: 100%;
				}
			}
		</style>
	</div>



</div>


<%@ include file = "../include/footer.jsp"%>