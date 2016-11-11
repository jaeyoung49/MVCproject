<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<nav class="navbar navbar-inverse navbar-fixed-to p">
<div class="container">
	<ul class="nav navbar-nav">
		<li id="navbar-page">
			<a href="index.jsp">
				<i class="fa fa-home fa-fw"></i> #HOME
			</a>
		</li>
		<li id="navbar-guestbook">
			<a href="noticeList.do">
				<i class="fa fa-book fa-fw"></i> #NOCTICE
			</a>
		</li>
		<li id="navbar-guestbook">
			<c:choose>
				<c:when test="${empty sessionScope.memberVO}">
					<a href="index.jsp?page=join">
						<i class="fa fa-book fa-fw"></i> #JOIN
					</a>
				</c:when>
				<c:otherwise>
					<a href="myInfo.do">
						<i class="fa fa-book fa-fw"></i> #MYINFO
					</a>
				</c:otherwise>
			</c:choose>
		</li>
	</ul>
	<div id="navbar" class="navbar-collapse collapse">
		<c:choose>
         <c:when test="${empty sessionScope.memberVO}">
            <form class="navbar-form navbar-right" action="DispatcherServlet"
               method="post">
               <a class="btn btn-primary btn-xs2" href="index.jsp?page=loginPage" role="button">LOGIN</a>
            </form>
         </c:when>
         <c:otherwise>
            <span>${sessionScope.memberVO.name } 님 환영합니다.</span>
            <span> <a href="logout.do">로그아웃</a></span>
            <span>회원등급 : ${sessionScope.memberVO.gradeVO.gradeName } </span>
         </c:otherwise>
      </c:choose>
	</div>
</div>
</nav>