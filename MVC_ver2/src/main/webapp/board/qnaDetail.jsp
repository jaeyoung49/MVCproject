<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script>
	//QnA 답글 작성 페이지
	function goResponse(){
		location.href = "qnaResponsePage.do?articleNo=${requestScope.qnaVO.articleNo }";
	}
	//QnA 작성 페이지
	function goReg(){
		location.href= "qnaWritePage.do";
	}
	//QnA 수정 페이지
	function goUpdate(){
		location.href= "qnaUpdatePage.do?articleNo=${requestScope.qnaVO.articleNo }";
	}
	//목록
	function goList(){
		location.href= "noticeList.do";
	}
	//JQuery
	$(document).ready(function(){
		//댓글 답변부 감추기
		$(".replyResp").hide();

		//QnA 상세글 삭제
		$("#deleteArticle").click(function(){
			var flag = confirm("삭제하시겠습니까?");
			if(flag==true){
				$(document).ready(function(){
					$.ajax({
						type : "get",
						url : "qnaDelete.do",
						data : "articleNo=${requestScope.qnaVO.articleNo}",
						success : function(){
							alert("삭제되었습니다");
							location.href="noticeList.do";
						}
					});	//ajax
				}); //ready
			}
		}); //삭제
		
		// 댓글 작성
		$("#replyReg").click(function(){
			$.ajax({
				type : "get",
				url : "replyRegister.do",
				data : $("#regForm").serialize(),
				success : function() {
					location.reload();
				}
			}); //ajax
		});
		
		// 댓글 클릭시 답글 작성 toggle
		$(".reply").click(function(){
			$(".replyResp").hide();
			$(this).next(".replyResp").toggle();
		});

		// 댓글의 답글 작성
		$(".replyRespReg").click(function(){
			var replyRespRegForm = $(this).parent(".replyRespRegForm");
			$.ajax({
				type : "get",
				url : "replyResponseRegister.do",
				data : replyRespRegForm.serialize(),
				success : function() {
					location.reload();
				}
			}); //ajax
		});
	});
</script>
<!-- QnA상세내용 -->
<table border=1>
	<tr>
		<td>글번호</td>
		<td>${requestScope.qnaVO.articleNo }</td>
		<td>조회수</td>
		<td>${requestScope.qnaVO.articleHit }</td>
	<tr>
		<td>제목</td>
		<td colspan=3>${requestScope.qnaVO.articleTitle }</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td>${requestScope.qnaVO.memberVO.id }</td>
		<td>작성일</td>
		<td>${requestScope.qnaVO.articleDate }</td>
	</tr>						
	<tr>
		<td colspan=4>내용</td>
	</tr>
	<tr>
		<td colspan=4>
			<textarea cols="54" rows="10" readonly>${requestScope.qnaVO.articleContent }</textarea>
		</td>
	</tr>
</table>
<input type="button" value="답글" onclick="goResponse()" class="button">
<input type="button" value="작성" onclick="goReg()">
<input type="button" value="삭제" onclick="deleteArticle()">
<input type="button" value="수정" onclick="goUpdate()">
<input type="button" value="목록" onclick="goList()">
<br>
<hr>
<br>
<!-- 댓글 테이블 -->
<form id="regForm" class="table table-condensed">
	<input type="text" name="replyContent">
	<input type="button" value="댓글 등록" id="replyReg" class="button"> 
	<input type="hidden" name="articleVO.articleNo" value="${requestScope.qnaVO.articleNo }"> 
	<input type="hidden" name="memberVO.id" value="${sessionScope.memberVO.id }">
</form>

<table class="table table-condensed">
	<tr>
		<td>댓글번호</td>
		<td>댓글내용</td>
		<td>작성자</td>
		<td>등록일</td>
	</tr>
	<c:forEach items="${requestScope.replyListVO.replyList}" var="replyRow" varStatus="row">
		<tr class="reply">
			<td>${replyRow.replyNo }</td>
			<td>
				<c:forEach begin="1" end="${replyRow.replyResponseStep}" step="1">
					&nbsp;
				</c:forEach>
				${replyRow.replyContent }
			</td>
			<td>${replyRow.memberVO.id }</td>
			<td>${replyRow.replyDate }</td>
		</tr>
		<tr class="replyResp">
			<td colspan="4">
				<form class="replyRespRegForm">
					<input type="text" name="replyContent">
					<input type="button" class="replyRespReg" value="댓글 등록">
					<input type="hidden" name="memberVO.id" value="${sessionScope.memberVO.id }">
					<input type="hidden" name="articleVO.articleNo" value="${requestScope.qnaVO.articleNo }"> 
					<input type="hidden" name="replyResponseGroup" value="${replyRow.replyResponseGroup }" >
					<input type="hidden" name="replyResponseOrder" value="${replyRow.replyResponseOrder+1 }" >
					<input type="hidden" name="replyResponseStep" value="${replyRow.replyResponseStep+1 }" >
				</form>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan=5>
			<c:if test="${replyListVO.pagingBean.previousPageGroup == true }">
				<a href="noticeDetail.do?replyNowPage=${replyListVO.pagingBean.startPageOfPageGroup - 1}&articleVO.articleNo=${requestScope.qna.articleNo }">[prev]</a>
			</c:if> 
			<c:forEach begin="${replyListVO.pagingBean.startPageOfPageGroup }" end="${replyListVO.pagingBean.endPageOfPageGroup }" var="replyPage">
				<c:choose>
					<c:when test="${replyPage == replyListVO.pagingBean.nowPage }">
						&nbsp;[${replyPage}]&nbsp;
					</c:when>
					<c:otherwise>
						&nbsp;<a href="noticeDetail.do?replyNowPage=${replyPage}&articleVO.articleNo=${requestScope.qnaVO.articleNo }">[${replyPage}]</a>&nbsp;
					</c:otherwise>
				</c:choose>
			</c:forEach> 
			<c:if test="${replyListVO.pagingBean.nextPageGroup == true }">
				<a href="noticeDetail.do?replyNowPage=${replyListVO.pagingBean.endPageOfPageGroup + 1}&articleVO.articleNo=${requestScope.qnaVO.articleNo }">[next]</a>
			</c:if>
		</td>
	</tr>
</table>