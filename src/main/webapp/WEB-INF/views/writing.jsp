<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html lang="KR">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>블로그 쓰기 </title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/startbootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="${pageContext.request.contextPath}/resources/startbootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/startbootstrap/css/clean-blog.min.css" rel="stylesheet">



  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand" href="/testboard/">Start Bootstrap</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="/testboard/">블로그 보기</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/testboard/board/getBoardWritingView">블로그 쓰기</a>
            </li>
       
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Header -->
    <header class="masthead" style="background-image: url('${pageContext.request.contextPath}/resources/startbootstrap/img/post-bg.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="post-heading text-center">
              <h1>게시글 쓰기</h1>
           
            </div>
          </div>
        </div>
      </div>
    </header>

    <!-- Post Content -->
    <article>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
          
         
	<form name="writingActionForm" method="post" action="/testboard/board/actionBoardWriting">         
          
         <label>제목 </label><input name="boardTitle" class="w-100 rounded" type="text" placeholder=" 제목 입력.."> 
         <label>닉네임 </label><input name="boardWriter" class="w-100 rounded" type="text" placeholder=" 닉네임 입력.."> 
         <label>이메일 </label><input name="boardEmail" class="w-100 rounded" type="text" placeholder=" 이메일 입력..">          
         <label>날짜 </label><input class="form-group w-100 rounded" type="text" readonly="readonly" value=" <fmt:formatDate value="<%=new Date()%>" type="Date" pattern="yyyy-MM-dd"/>"> 
         <label>내용</label><div class="form-group w-100 rounded"><textarea name="boardContent" class="w-100" rows="15" placeholder=" 내용을 입력하세요.."></textarea></div>
         <input type="hidden" name="boardNum" value="">
     	 <input type="hidden" name="boardDate" value="">
      
      <div class="row">
      <div class="col-4"><input type="submit" class="btn btn-success w-100 rounded" value="글쓰기"></div>
   
      </div>
      </form>    
          
          </div>
        </div>
      </div>
    </article>

    <hr>

    <!-- Footer -->
    <footer>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <ul class="list-inline text-center">
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fa fa-circle fa-stack-2x"></i>
                    <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fa fa-circle fa-stack-2x"></i>
                    <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fa fa-circle fa-stack-2x"></i>
                    <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
            </ul>
            <p class="copyright text-muted">Copyright &copy; Your Website 2018</p>
          </div>
        </div>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/startbootstrap/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/startbootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="${pageContext.request.contextPath}/resources/startbootstrap/js/clean-blog.min.js"></script>

  </body>
  


</html>
