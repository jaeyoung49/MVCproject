<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:choose>
	<c:when test="${param.page == 'EpilogueList'}">
		<!--  후기글 조회  -->
		<jsp:include page="/board/EpilogueList.jsp"></jsp:include>
	</c:when>
	<c:when test="${param.page == 'join'}">
		<!--  회원가입 폼 -->
		<jsp:include page="/service/join.jsp"></jsp:include>
	</c:when>
	<c:when test="${param.page == 'EpDetails'}">
		<!--  후기 디테일-->
		<jsp:include page="/board/Epilogue_details.jsp"></jsp:include>
	</c:when>
	<c:when test="${param.page == 'EpWrite'}">
		<!--  후기 작성-->
		<jsp:include page="/board/Epilogue_write.jsp"></jsp:include>
	</c:when>
	<c:when test="${param.page=='NoticeList'}">
		<!--  공지글 조회 -->
		<jsp:include page="/board/NoticeList.jsp"></jsp:include>
	</c:when>
	<c:when test="${param.page=='EpUpdateWrite'}">
		<!--  후기글 업데이트 -->
		<jsp:include page="/board/Epilogue_updatewrite.jsp"></jsp:include>
	</c:when>
	<c:when test="${param.page=='NoticeDetail'}">
		<!--  공지글 디테일 -->
		<jsp:include page="/board/NoticeDetail.jsp"></jsp:include>
	</c:when>
	<c:when test="${param.page=='Notice_write'}">
		<!--  공지글 작성 -->
		<jsp:include page="/board/NoticeWrite.jsp"></jsp:include>
	</c:when>
	<c:when test="${param.page=='Notice_update'}">
		<!--  공지글 업데이트 -->
		<jsp:include page="/board/NoticeUpdate.jsp" />
	</c:when>
	<c:when test="${param.page=='myinfo'}">
		<!--  회원정보 변경 -->
		<jsp:include page="/service/myinfo.jsp" />
	</c:when>
	<c:when test="${param.page=='QnADetail'}">
		<!-- QnA 디테일 -->
		<jsp:include page="/board/QnADetail.jsp" />
	</c:when>
	<c:when test="${param.page=='QnA_write'}">
		<!--  QnA 작성 -->
		<jsp:include page="/board/QnAWrite.jsp"></jsp:include>
	</c:when>
		<c:when test="${param.page=='QnA_update'}">
		<!--  QnA 업데이트 -->
		<jsp:include page="/board/QnAUpdate.jsp" />
	</c:when>
	<c:when test="${param.page=='LoginPage'}">
      <!--  로그인 페이지 -->
      <jsp:include page="/service/loginPage.jsp"></jsp:include>
   </c:when>
	<c:otherwise>
		<!--  메인페이지 -->
		<jsp:include page="/service/main.jsp"></jsp:include>
	</c:otherwise>
</c:choose>

