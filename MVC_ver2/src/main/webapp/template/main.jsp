<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:choose>
	<%--  회원가입 폼 --%>
	<c:when test="${param.page == 'join'}">
		<jsp:include page="/service/join.jsp" />
	</c:when>
    <%--  로그인 페이지 --%>
	<c:when test="${param.page =='loginPage' || page == 'loginPage'}">
      <jsp:include page="/service/loginPage.jsp" />
	</c:when>
	<%--  회원정보 변경 --%>
	<c:when test="${page=='myInfo'}">
		<jsp:include page="/service/myInfo.jsp" />
	</c:when>

	<%-- 공지글 리스트 --%>
	<c:when test="${page=='noticeList'}">
		<jsp:include page="/board/noticeList.jsp" />
	</c:when>
	<%--  공지글 작성 --%>
	<c:when test="${page=='noticeWrite'}">
		<jsp:include page="/board/noticeWrite.jsp" />
	</c:when>
	<%--  공지글 디테일 --%>
	<c:when test="${param.page=='noticeDetail' || page == 'noticeDetail'}">
		<jsp:include page="/board/noticeDetail.jsp" />
	</c:when>
	<%--  공지글 업데이트 --%>
	<c:when test="${param.page=='noticeUpdate' || page=='noticeUpdate'}">
		<jsp:include page="/board/noticeUpdate.jsp" />
	</c:when>
	<%--  공지글 답글 --%>
	<c:when test="${param.page=='noticeResponse' || page=='noticeResponse'}">
		<jsp:include page="/board/noticeResponse.jsp" />
	</c:when>

	<%--  QnA 작성 --%>
	<c:when test="${page=='qnaWrite'}">
		<jsp:include page="/board/qnaWrite.jsp" />
	</c:when>
	<%--  QnA 디테일 --%>
	<c:when test="${page=='qnaDetail'}">
		<jsp:include page="/board/qnaDetail.jsp" />
	</c:when>
	<%--  QnA 업데이트 --%>
	<c:when test="${page=='qnaUpdate'}">
		<jsp:include page="/board/qnaUpdate.jsp" />
	</c:when>
	<%--  QnA 답글 --%>
	<c:when test="${param.page=='qnaResponse' || page=='qnaResponse'}">
		<jsp:include page="/board/qnaResponse.jsp" />
	</c:when>
	
	
	<%--  메인페이지 --%>
	<c:otherwise>
		<jsp:include page="/service/main.jsp" />
	</c:otherwise>
</c:choose>

