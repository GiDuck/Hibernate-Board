<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" contentType="text/html; charset=utf-8"%>

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
    <header class="masthead" style="background-image: url('${pageContext.request.contextPath}/resources/startbootstrap/img/home-bg.jpg'); height:auto">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="site-heading">
              <h1>Clean Blog</h1>
              <span class="subheading">A Blog Theme by Start Bootstrap</span>
            </div>
          </div>
        </div>
      </div>
    </header>

    <!-- Main Content -->
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          
          <c:forEach var="board" items="${boards}">
          <div class="post-preview">
            <a href="/testboard/board/getBoardDetailView?num=${board.boardNum}">
              <h2 class="post-title">
                ${board.boardTitle}
              </h2>
              <h3 class="post-subtitle">
                <c:choose>
                
                <c:when test="${fn:length(board.boardContent)>20}">
                
                <c:out value="${fn:substring(board.boardContent, 0, 20)}"/>
                
                </c:when>
                <c:otherwise>
                <c:out value="${board.boardContent}"/>
                </c:otherwise>
                
                </c:choose>
              </h3>
            </a>
            <p class="post-meta">${board.boardWriter}</p>
            <p class="post-meta"><fmt:formatDate value="${board.boardDate}" type="both" pattern="yyyy-MM-dd HH시 mm분"/> </p>
          </div>
          <hr>
          </c:forEach>
          
          <!-- Pager -->
          <div class="clearfix">
            <a class="btn btn-primary float-right" href="/testboard/board/getBoardWritingView">글쓰기 &rarr;</a>
          </div>
          
         <div class="row w-100">
         
         <nav aria-label="Page navigation" class="text-center"  style="margin:0 auto">
			  <ul class="pagination">
			    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
			    <li class="page-item"><a class="page-link" href="#">1</a></li>
			    <li class="page-item"><a class="page-link" href="#">2</a></li>
			    <li class="page-item"><a class="page-link" href="#">3</a></li>
			    <li class="page-item"><a class="page-link" href="#">Next</a></li>
			  </ul>
		</nav>
         
          </div>
          
          
        </div>
      </div>
    </div>

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

