<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${param.page == 'sa_VideoUrlList'}">
		<jsp:include page="/sa/sa_VideoUrlList.jsp"></jsp:include>
	</c:when>
	<c:when test="${param.page == 'sa_VideoUrlUpLoad'}">
		<jsp:include page="/sa/sa_VideoUrlUpLoad.jsp"></jsp:include>
	</c:when>
	<c:when test="${param.page == 'sa_noticeList'}">
		<jsp:include page="/sa/sa_noticeList.jsp"></jsp:include>
	</c:when>
	<c:when test="${param.page == 'sa_epilogueList'}">
		<jsp:include page="/sa/sa_epilogueList.jsp"></jsp:include>
	</c:when>
	<c:when test="${param.page == 'sa_memberManagement'}">
		<!-- 회원 리스트 -->
		<jsp:include page="/sa/sa_memberManagement.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
		<jsp:include page="/sa/sa_main.jsp"></jsp:include>
	</c:otherwise>
</c:choose>

