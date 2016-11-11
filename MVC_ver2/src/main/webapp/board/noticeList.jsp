<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script>
	function goReg() {
		location.href = "noticeWritePage.do";
	}
	function goRegQnA() {
		location.href = "qnaWritePage.do";
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
		<c:forEach items="${noticeListVO.priorityNoticeList}" var="row">
			<tr>
				<td>필독</td>
				<td><a href="noticeDetail.do?articleVO.articleNo=${row.articleVO.articleNo}">${row.articleVO.articleTitle }</a></td>
				<td>${row.articleVO.memberVO.id }</td>
				<td>${row.articleVO.articleDate }</td>
				<td>${row.articleVO.articleHit }</td>
			</tr>
		</c:forEach>
		<c:forEach items="${noticeListVO.noticeList}" var="row1">
			<tr>
				<td>${row1.articleVO.articleNo }</td>
				<td>
					<c:forEach begin="1" end="${row1.articleVO.responseStep}" step="1">
						&nbsp;&nbsp;
					</c:forEach>
					<a href="noticeDetail.do?articleVO.articleNo=${row1.articleVO.articleNo}">
						${row1.articleVO.articleTitle }
					</a>
				</td>
				<td>${row1.articleVO.memberVO.id }</td>
				<td>${row1.articleVO.articleDate }</td>
				<td>${row1.articleVO.articleHit }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan=5>
				<div align="center">
					<c:if test="${noticeListVO.pagingBean.previousPageGroup == true }">
						<a href="noticeList.do?noticeNowPage=${noticeListVO.pagingBean.startPageOfPageGroup - 1}&qnaNowPage=${qnaListVO.pagingBean.nowPage}">[prev]</a>
					</c:if>
					<c:forEach begin="${noticeListVO.pagingBean.startPageOfPageGroup }"	end="${noticeListVO.pagingBean.endPageOfPageGroup }" var="page">
						<c:choose>
							<c:when test="${page == noticeListVO.pagingBean.nowPage }">
								&nbsp;[${page}]&nbsp;
							</c:when>
							<c:otherwise>
								&nbsp;<a href="noticeList.do?noticeNowPage=${page}&qnaNowPage=${qnaListVO.pagingBean.nowPage}">[${page}]</a>&nbsp;
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${noticeListVO.pagingBean.nextPageGroup == true }">
						<a
							href="noticeList.do?noticeNowPage=${noticeListVO.pagingBean.endPageOfPageGroup + 1}&qnaNowPage=${qnaListVO.pagingBean.nowPage}">[next]</a>
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
		<c:forEach items="${requestScope.qnaListVO.qnaList}" var="row2">
			<tr>
				<td>${row2.articleNo }</td>
				<td>
					<c:forEach begin="1" end="${row2.responseStep}" step="1">
						&nbsp;&nbsp;
					</c:forEach>
					<a href=qnaDetail.do?articleNo=${row2.articleNo}>
						${row2.articleTitle }
					</a>
				</td>
				<td>${row2.memberVO.id }</td>
				<td>${row2.articleDate }</td>
				<td>${row2.articleHit }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan=5><div align="center">
					<c:if test="${qnaListVO.pagingBean.previousPageGroup == true }">
						<a class="btn btn-primary btn-xs"
							href="noticeList.do?qnaNowPage=${qnaListVO.pagingBean.startPageOfPageGroup - 1}&noticeNowPage=${noticeListVO.pagingBean.nowPage}">[prev]</a>
					</c:if>
					<c:forEach begin="${qnaListVO.pagingBean.startPageOfPageGroup }"
						end="${qnaListVO.pagingBean.endPageOfPageGroup }" var="page1">
						<c:choose>
							<c:when test="${page1 == qnaListVO.pagingBean.nowPage }">
								&nbsp;[${page1}]&nbsp;
							</c:when>
							<c:otherwise>
								&nbsp;
								<a class="btn btn-primary btn-xs" href="noticeList.do?qnaNowPage=${page1}&noticeNowPage=${noticeListVO.pagingBean.nowPage}">
									[${page1}]
								</a>
								&nbsp;
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${qnaListVO.pagingBean.nextPageGroup == true }">
						<a class="btn btn-primary btn-xs"
							href="noticeList.do?qnaNowPage=${qnaListVO.pagingBean.endPageOfPageGroup + 1}&noticeNowPage=${noticeListVO.pagingBean.nowPage}">[next]</a>
					</c:if>
				</div></td>
		</tr>
	</table>
	<div align="center">
		<input type="button" class="button" value="QnA작성" onclick="goRegQnA()">
	</div>
</div>









