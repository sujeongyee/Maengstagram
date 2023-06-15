<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-idth, initial-scale=1">
   

    <title>Welcome to Maengstagram</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
 
    <!-- Custom CSS -->
    <link href="<%=request.getContextPath()%>/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <!-- 
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
    -->
   <!-- jQuery -->
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    <script>
    $('.carousel').carousel({
        interval: 2000 //changes the speed
    })
    </script>
   <style>
   .abc {
      position: sticky;
      top: 0px;
      width: 100%; 
      z-index: 10;
   }
   </style>
   	
	<style>
	
	 @font-face {
    font-family: 'OSeongandHanEum';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/OSeongandHanEum.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
	
		h1, h2, h3, h4, h5, h6, body, * {
			font-family: OSeongandHanEum
		}
		
	</style> 
   
    
</head>

<body>
   <!-- header -->
   <div class="brand"></div>        

    <div class="address-bar"><h1>MAENGSTAGRAM</h1></div>

    
    <nav class="navbar navbar-default abc" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
                <a class="navbar-brand" href="/hong">My First Web</a>
            </div>
           
           
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                   
                    <li>
                        <a href="<%=request.getContextPath()%>/main.main">HOME</a> <!-- 메인화면 -->
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/user/user_search.user">SEARCH</a> <!--  -->
                    </li>
                 	<li>
                        <a href="<%=request.getContextPath()%>/board/board_write.jsp">Write</a>
                    </li>
                    
                    <li>
                        <a href="<%=request.getContextPath()%>/user/user_mypage.user">MYPAGE</a>
                    </li>
                   	<li>
                        <a href="<%=request.getContextPath()%>/user/user_logout.user" style="color:red">LOGOUT</a>
                    </li>
                  
                      	
                    
                    
                </ul>
            </div>
            
            
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    <!-- end header -->