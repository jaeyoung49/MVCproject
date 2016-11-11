<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<nav class="navbar navbar-inverse navbar-fixed-to p">
<div class="container">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#navbar" aria-expanded="false"
			aria-controls="navbar">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<img src="mvc.jpg">
		<a class="navbar-brand"></a>
	</div>
	<ul class="nav navbar-nav">
		<li id="navbar-page"><a href="index.jsp"><i
				class="fa fa-home fa-fw"></i> #HOME</a></li>
		<li class="dropdown"><a href="#" class="dropdown-category"
			id="dropdownCategoryMenu" data-toggle="dropdown"><i
				class="fa fa-folder-open"></i> #EPILOGUE <i class="caret"></i></a>
			<ul class="dropdown-menu" role="menu"
				aria-labelledby="dropdownCategoryMenu">
				<li class="divider"></li>
				<li><a
					href="${initParam.root }/DispatcherServlet?command=Eplist"> <i
						class="fa fa-folder"></i> 화장품 후기 게시판
				</a></li>
			</ul></li>
			
		<li id="navbar-guestbook"><a
			href="${initParam.root }/DispatcherServlet?command=Notice"><i
				class="fa fa-book fa-fw"></i> #NOCTICE</a></li>
		<li id="navbar-guestbook"><a
			href="${initParam.root }/index.jsp?page=join"><i
				class="fa fa-book fa-fw"></i> #JOIN</a></li>
	</ul>
	<div id="navbar" class="navbar-collapse collapse">
		<c:choose>
         <c:when test="${empty sessionScope.dto}">
            <form class="navbar-form navbar-right" action="DispatcherServlet"
               method="post">
               <a class="btn btn-primary btn-xs2" href="${initParam.root }/index.jsp?page=LoginPage" role="button">LOGIN</a>
            </form>
         </c:when>
         <c:otherwise>
            <span>${sessionScope.dto.m_name } 님 환영합니다.</span>
            <span> <a href="/MVC/DispatcherServlet?command=Logout">로그아웃</a></span>
            <span>회원등급 : ${sessionScope.dto.m_grade_name } </span>
            <span> <a href="${initParam.root }/service/myinfo.jsp">
                  정보</a></span>
         </c:otherwise>
      </c:choose>
	</div>
</div>
</nav>