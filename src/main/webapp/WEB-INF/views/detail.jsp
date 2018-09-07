<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Clean Blog - Start Bootstrap Theme</title>

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
            <div class="post-heading">
              <h1>${board.boardTitle}</h1>
              <span class="meta">Posted by  ${board.boardWriter}</span>
              <span class="meta"><fmt:formatDate value="${board.boardDate}" type="both" pattern="yyyy-MM-dd HH시 mm분"/></span>
              
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
          
          
          ${board.boardContent}


          </div>
        </div>
        
        <div class="row" style="height:50px"></div>
        
      <div class="row">
      <div class="col-4"></div>
      <div class="col-4"><input name="modifyBtn" type="button" class="btn btn-notice w-100 rounded" value="수정하기"></div>
      <div class="col-4"><input name="deleteBtn" type="button" class="btn btn-danger w-100 rounded" value="삭제하기"></div>
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


  <script>
  
  $(document).ready(function(){
	  
	  
	  /* 삭제 로직 */
	 
	  $("input[name=deleteBtn]").on('click', function(){
		 
		  var conf = window.confirm("모든 데이터가 삭제됩니다. 삭제할까요?");
		  
		  if(conf){
		  
		  $.ajax({
			  
			  url : "/testboard/board/actionBoardDelete",
			  type : "GET",
			  data : {num : "${board.boardNum}"},
			  success : function(response){
				  if(response === "success"){
					  
					  alert("삭제가 성공적으로 완료되었습니다.");
					  location.replace("/testboard/");
				  }else{
					  alert("삭제 실패..");
					  history.back();
					 
					  
				  }
				  
				  
			  },
			  error : function(xhs, status, error){
				  
				  alert("삭제 중 에러 발생.. code : " + status);
				  
			  }
			  
			  
		  });
		  
		  
		  }
		  
	  });
	  
	  
	  
	  /* 수정 로직 */
	  
	  
	  
	  $("input[name=modifyBtn]").on('click', function(){
		  
		  location.href = "/testboard/board/getBoardModifyView?num="+${board.boardNum}; 
		  
	  });
	  
  });
  
  
  </script>


</html>
