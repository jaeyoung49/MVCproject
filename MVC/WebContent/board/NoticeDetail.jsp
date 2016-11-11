<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function goList() {
		location.href = "${initParam.root}/DispatcherServlet?command=Notice";
	}
	function goReg() {
		location.href = "${initParam.root}/index.jsp?page=Notice_write";
	}
	function goUpdate() {
		location.href = "${initParam.root}/DispatcherServlet?command=NoticeUpdateForm&a_no=${requestScope.nDto.articleDTO.a_no }";
	}

	//상세글 삭제
	function deleteArti() {
		var flag = confirm("삭제하시겠습니까?");
		if (flag == true) {
			$(document)
					.ready(
							function() {
								$
										.ajax({
											type : "get",
											url : "DispatcherServlet",
											data : "command=Notice_Delete&a_no=${requestScope.nDto.articleDTO.a_no}",
											success : function() {
												alert("삭제되었습니다");
												location.href = "DispatcherServlet?command=Notice";
											}
										});
							});
		}
	}
	// 댓글 작성
	function regRep() {
		$(document).ready(function() {
			$.ajax({
				type : "get",
				url : "DispatcherServlet",
				data : $("#regForm").serialize(),
				success : function() {
					location.reload();
				}
			});
		});
	}
</script>
<!-- Notice 상세내용 -->
<table class="table table-condensed">
	<tr>
		<td>글번호</td>
		<td>${requestScope.nDto.articleDTO.a_no }</td>
		<td>조회수</td>
		<td>${requestScope.nDto.articleDTO.hit }</td>
	<tr>
		<td>제목</td>
		<td colspan=3>${requestScope.nDto.articleDTO.a_title }</td>
	</tr>
	<tr>
		<td>닉네임(아이디)</td>
		<td>${requestScope.nDto.memberDTO.nickname }(${requestScope.nDto.articleDTO.id })</td>
		<td>작성일</td>
		<td>${requestScope.nDto.articleDTO.a_regdate }</td>
	</tr>
	<tr>
		<td colspan=4>내용</td>
	</tr>
	<tr>
		<td colspan=4><textarea cols="120" rows="10" readonly>${requestScope.nDto.articleDTO.a_content }</textarea></td>
	</tr>
</table>
<div align="center">
	<input type="button" value="공지작성" onclick="goReg()" class="button">
	<input type="button" value="삭제" onclick="deleteArti()" class="button">
	<input type="button" value="공지수정" onclick="goUpdate()" class="button">
	<input type="button" value="목록" onclick="goList()" class="button">
</div>
<hr>
<!-- 댓글 테이블 -->
<form id="regForm" class="table table-condensed">
	<textarea rows="1" cols="120" name="r_content"></textarea>
	<br> <input type="button" value="댓글 등록" onclick="regRep()"
		class="button"> <input type="hidden" name="command"
		value="Reply_Register"> <input type="hidden" name="a_no"
		value="${requestScope.nDto.articleDTO.a_no }"> <input
		type="hidden" name="id" value="${sessionScope.dto.id }">

</form>

<table class="table table-condensed">
	<tr>
		<td>댓글번호</td>
		<td>댓글내용</td>
		<td>작성자</td>
		<td>등록일</td>
	</tr>
	<c:forEach items="${requestScope.rdto.rlist}" var="row2">
		<tr>
			<td>${row2.r_no }</td>
			<td>${row2.r_content }</td>
			<td>${row2.memberDTO.id }</td>
			<td>${row2.r_regdate }</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan=5><c:if
				test="${rdto.pagingBean.previousPageGroup == true }">
				<a
					href="${initParam.root }/DispatcherServlet?command=NoticeDetail&nowPage=${rdto.pagingBean.startPageOfPageGroup - 1}&a_no=${requestScope.qDto.articleDTO.a_no }">[prev]</a>
			</c:if> <c:forEach begin="${rdto.pagingBean.startPageOfPageGroup }"
				end="${rdto.pagingBean.endPageOfPageGroup }" var="page1">
				<c:choose>
					<c:when test="${page1 == rdto.pagingBean.nowPage }">
						&nbsp;[${page1}]&nbsp;
					</c:when>
					<c:otherwise>
						&nbsp;<a
							href="${initParam.root }/DispatcherServlet?command=NoticeDetail&nowPage=${page1}&a_no=${requestScope.qDto.articleDTO.a_no }">[${page1}]</a>&nbsp;
					</c:otherwise>
				</c:choose>
			</c:forEach> <c:if test="${rdto.pagingBean.nextPageGroup == true }">
				<a
					href="${initParam.root }/DispatcherServlet?command=NoticeDetail&nowPage=${rdto.pagingBean.endPageOfPageGroup + 1}&a_no=${requestScope.qDto.articleDTO.a_no }">[next]</a>
			</c:if></td>
	</tr>
</table>


