<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script>
	function goReg() {
		location.href = "${initParam.root}/index.jsp?page=Notice_write";
	}
	function goRegQnA() {
		location.href = "${initParam.root}/index.jsp?page=QnA_write";
	}
</script>
<div align="center">
	<table class="table">
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${requestScope.ldto.nlist[1]}" var="row">
			<tr>
				<td>필독사항</td>
				<td><a href=${initParam.root }/DispatcherServlet?command=NoticeDetail&a_no=${row.articleDTO.a_no}>${row.articleDTO.a_title }</a></td>
				<td>운영자</td>
				<td>${row.articleDTO.a_regdate }</td>
				<td>${row.articleDTO.hit }</td>
			</tr>
		</c:forEach>
		<c:forEach items="${requestScope.ldto.nlist[0]}" var="row1">
			<tr>
				<td>${row1.articleDTO.a_no }</td>
				<td><a href=${initParam.root }
					/DispatcherServlet?command=NoticeDetail&a_no=${row1.articleDTO.a_no}>${row1.articleDTO.a_title }</a></td>
				<td>운영자</td>
				<td>${row1.articleDTO.a_regdate }</td>
				<td>${row1.articleDTO.hit }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan=5>
				<div align="center">
					<c:if test="${ldto.pagingBean.previousPageGroup == true }">
						<a
							href="${initParam.root }/DispatcherServlet?command=Notice&nowPage=${ldto.pagingBean.startPageOfPageGroup - 1}&nowPageQnA=${qdto.pagingBean.nowPage}">[prev]</a>
					</c:if>
					<c:forEach begin="${ldto.pagingBean.startPageOfPageGroup }"
						end="${ldto.pagingBean.endPageOfPageGroup }" var="page">
						<c:choose>
							<c:when test="${page == ldto.pagingBean.nowPage }">
						&nbsp;[${page}]&nbsp;
					</c:when>
							<c:otherwise>
						&nbsp;<a
									href="${initParam.root }/DispatcherServlet?command=Notice&nowPage=${page}&nowPageQnA=${qdto.pagingBean.nowPage}">[${page}]</a>&nbsp;
					</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${ldto.pagingBean.nextPageGroup == true }">
						<a
							href="${initParam.root }/DispatcherServlet?command=Notice&nowPage=${ldto.pagingBean.endPageOfPageGroup + 1}&nowPageQnA=${qdto.pagingBean.nowPage}">[next]</a>
					</c:if>
				</div>
			</td>

		</tr>
	</table>
	<div align="center">
		<input type="button" class="button" value="공지작성" onclick="goReg()">
	</div>
	<hr>
	<table class="table">
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${requestScope.qdto.qlist}" var="row2">
			<tr>
				<td>${row2.articleDTO.a_no }</td>
				<td><a href=${initParam.root }
					/DispatcherServlet?command=QnADetail&a_no=${row2.articleDTO.a_no}>${row2.articleDTO.a_title }</a></td>
				<td>${row2.articleDTO.id }</td>
				<td>${row2.articleDTO.a_regdate }</td>
				<td>${row2.articleDTO.hit }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan=5><div align="center">
					<c:if test="${qdto.pagingBean.previousPageGroup == true }">
						<a class="btn btn-primary btn-xs"
							href="${initParam.root }/DispatcherServlet?command=Notice&nowPageQnA=${qdto.pagingBean.startPageOfPageGroup - 1}&nowPage=${ldto.pagingBean.nowPage}">[prev]</a>
					</c:if>
					<c:forEach begin="${qdto.pagingBean.startPageOfPageGroup }"
						end="${qdto.pagingBean.endPageOfPageGroup }" var="page1">
						<c:choose>
							<c:when test="${page1 == qdto.pagingBean.nowPage }">
						&nbsp;[${page1}]&nbsp;
					</c:when>
							<c:otherwise>
						&nbsp;<a class="btn btn-primary btn-xs"
									href="${initParam.root }/DispatcherServlet?command=Notice&nowPageQnA=${page1}&nowPage=${ldto.pagingBean.nowPage}">[${page1}]</a>&nbsp;
					</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${qdto.pagingBean.nextPageGroup == true }">
						<a class="btn btn-primary btn-xs"
							href="${initParam.root }/DispatcherServlet?command=Notice&nowPageQnA=${qdto.pagingBean.endPageOfPageGroup + 1}&nowPage=${ldto.pagingBean.nowPage}">[next]</a>
					</c:if>
				</div></td>
		</tr>
	</table>
	<div align="center">
		<input type="button" class="button" value="QnA작성" onclick="goRegQnA()">
	</div>
</div>









