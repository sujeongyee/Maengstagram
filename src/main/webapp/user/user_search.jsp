<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file = "../include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>

   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-idth, initial-scale=1">
   

    <title>Welcome to MyWorld</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
 
    <!-- Custom CSS -->
    <link href="<%=request.getContextPath()%>/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
   
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
    <div class="address-bar"></div>
    
    <nav class="navbar navbar-default abc" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
                <a class="navbar-brand" href="/hong"></a>
            </div>
           
           
            
            
            
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
 	<!-- end header -->

<section>
	<div align = "center" size = "50"> <!-- 글자 가운데로 -->
		

		<h2>SEARCH   🔎</h2>

		<hr/>
		
		<br/>
		

		<h5>아이디를 검색해주세요~ </h5>

		<br/>
		<form action = "search.user" method="post">
		<input type="text" name = "search_id" placeholder="검색할 아이디 입력!">
		<input type = "submit" value = "검색하기">
		<br/>
		<br/>
		${ddu2}
				
		</form>	
		<br/>
		<hr/>

		
	</div>

</section>
  <%@ include file = "../include/footer.jsp" %>