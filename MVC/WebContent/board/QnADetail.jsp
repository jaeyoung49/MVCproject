<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script>
	function goList(){
		location.href= "${initParam.root}/DispatcherServlet?command=Notice";
	}
	function goReg(){
		location.href= "${initParam.root}/index.jsp?page=QnA_write";
	}
	function goUpdate(){
		location.href= "${initParam.root}/DispatcherServlet?command=QnAUpdateForm&a_no=${requestScope.qDto.articleDTO.a_no }";
	}
	//상세글 삭제
	function deleteArti(){
		var flag = confirm("삭제하시겠습니까?");
		if(flag==true){
			$(document).ready(function(){
				$.ajax({
					type : "get",
					url : "DispatcherServlet",
					data : "command=QnA_Delete&a_no=${requestScope.qDto.articleDTO.a_no}",
					success : function(){
						alert("삭제되었습니다");
						location.href="DispatcherServlet?command=Notice";
					}
				});
			});
		}
	}
	// 댓글 작성
	function regRep(){
		$(document).ready(function(){
			$.ajax({
				type : "get",
				url : "DispatcherServlet",
				data : $("#regForm").serialize(),
				success : function(){
					location.reload();
				}
			});
		});
	}
</script>
<!-- QnA상세내용 -->
<table border=1>
	<tr>
		<td>글번호</td>
		<td>${requestScope.qDto.articleDTO.a_no }</td>
		<td>조회수</td>
		<td>${requestScope.qDto.articleDTO.hit }</td>
	<tr>
		<td>제목</td>
		<td colspan=3>${requestScope.qDto.articleDTO.a_title }</td>
	</tr>
	<tr>
		<td>닉네임(아이디)</td>
		<td>${requestScope.qDto.memberDTO.nickname }(${requestScope.qDto.articleDTO.id })</td>
		<td>작성일</td>
		<td>${requestScope.qDto.articleDTO.a_regdate }</td>
	</tr>						
	<tr>
		<td colspan=4>내용</td>
	</tr>
	<tr>
		<td colspan=4>
			<textarea cols="54" rows="10" readonly>${requestScope.qDto.articleDTO.a_content }</textarea>
		</td>
	</tr>
</table>
<input type="button" value="공지작성" onclick="goReg()">
<input type="button" value="삭제" onclick="deleteArti()">
<input type="button" value="공지수정" onclick="goUpdate()">
<input type="button" value="목록" onclick="goList()">
<br>
<hr>
<br>
<!-- 댓글 테이블 -->
<form id="regForm">
<textarea rows="2" cols="40" name="r_content"></textarea>
<input type="button" value="댓글 등록" onclick="regRep()" >
<input type="hidden" name="command" value="Reply_Register">
<input type="hidden" name="a_no" value="${requestScope.qDto.articleDTO.a_no }">
<input type="hidden" name="id" value="${sessionScope.dto.id }">

</form>

<table border=1>
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
			<td colspan=5>
			<c:if test="${rdto.pagingBean.previousPageGroup == true }">
				<a href="${initParam.root }/DispatcherServlet?command=QnADetail&nowPage=${rdto.pagingBean.startPageOfPageGroup - 1}&a_no=${requestScope.qDto.articleDTO.a_no }">[prev]</a>
			</c:if>
			<c:forEach begin="${rdto.pagingBean.startPageOfPageGroup }" end="${rdto.pagingBean.endPageOfPageGroup }" var="page1">
				<c:choose>
					<c:when test="${page1 == rdto.pagingBean.nowPage }">
						&nbsp;[${page1}]&nbsp;
					</c:when>
					<c:otherwise>
						&nbsp;<a href="${initParam.root }/DispatcherServlet?command=QnADetail&nowPage=${page1}&a_no=${requestScope.qDto.articleDTO.a_no }">[${page1}]</a>&nbsp;
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${rdto.pagingBean.nextPageGroup == true }">
				<a href="${initParam.root }/DispatcherServlet?command=QnADetail&nowPage=${rdto.pagingBean.endPageOfPageGroup + 1}&a_no=${requestScope.qDto.articleDTO.a_no }">[next]</a>
			</c:if>
			</td>
		</tr>
</table>


