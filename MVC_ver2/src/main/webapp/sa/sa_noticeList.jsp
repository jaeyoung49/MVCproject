<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(document).ready(
			function() {

				$("#list td:last-child").click(
						function() {
							$.ajax({
								type : "post",
								url : "${initParam.root}/DispatcherServlet",
								data : "command=sa_NoticeDeleteAjax&a_no="
										+ $(this).parent().children().eq(0).text(),
								success : function() {
									location.reload();
								}
							}); // ajax
						}); // click
			});// ready
</script>
<table border=1 id="list">
	<tr>
		<td>글번호</td>
		<td>글제목</td>
		<td>작성자</td>
		<td>등록일</td>
		<td>조회수</td>
		<td>긴급공지</td>
		<td>삭제</td>
	</tr>
	<c:forEach items="${requestScope.ldto.nlist[1]}" var="row">
		<tr>
			<td>필독사항</td>
			<td>${row.articleDTO.a_title }</td>
			<td>운영자</td>
			<td>${row.articleDTO.a_regdate }</td>
			<td>${row.articleDTO.hit }</td>
			<td>긴급공지</td>
			<td></td>
		</tr>
	</c:forEach>
	<c:forEach items="${requestScope.ldto.nlist[0]}" var="row1">
		<tr>
			<td>${row1.articleDTO.a_no }</td>
			<td>${row1.articleDTO.a_title }</td>
			<td>운영자</td>
			<td>${row1.articleDTO.a_regdate }</td>
			<td>${row1.articleDTO.hit }</td>
			<td>${row1.priority }</td>
			<td><input type="hidden" name="command" value="sa_NoticeDelete">
				<input type="button" value="삭제"></td>
		</tr>
	</c:forEach>
	<c:if test="${ldto.pagingBean.previousPageGroup == true }">
		<a
			href="${initParam.root }/DispatcherServlet?command=sa_noticeList&nowPage=${ldto.pagingBean.startPageOfPageGroup - 1}">[prev]</a>
	</c:if>
	<c:forEach begin="${ldto.pagingBean.startPageOfPageGroup }"
		end="${ldto.pagingBean.endPageOfPageGroup }" var="page">
		<c:choose>
			<c:when test="${page == ldto.pagingBean.nowPage }">
					&nbsp;[${page}]&nbsp;
				</c:when>
			<c:otherwise>
					&nbsp;<a
					href="${initParam.root }/DispatcherServlet?command=sa_noticeList&nowPage=${page}">[${page}]</a>&nbsp;
				</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${ldto.pagingBean.nextPageGroup == true }">
		<a
			href="${initParam.root }/DispatcherServlet?command=sa_noticeList&nowPage=${ldto.pagingBean.endPageOfPageGroup + 1}">[next]</a>
	</c:if>
</table>
