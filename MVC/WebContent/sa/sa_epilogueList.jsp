<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="//code.jquery.com/jquery.min.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$.ajax({
							type : "post",
							url : "${initParam.root}/DispatcherServlet",
							dataType : "json",
							data : "command=c_categoryAjax",
							success : function(data) {
								var html = "<option value=''>-- </option>";
								for (var i = 0; i < data.length; i++) {
									var ex = JSON.parse(data[i]);
									html += "<option value=" + ex.c_c_no+ ">"
											+ ex.c_c_name + "</option>";
								}
								$("#category").html(html);
							}
						});

						$("#list tr").filter(":gt(0)").hover(function() {
							$(this).css("background", "pink");
						}, function() {
							$(this).css("background", "white");
						});
						$("#list tr")
								.filter(":gt(0)")
								.click(
										function() {
											// 			alert($(this).children().eq(0).text());
											location.href = "DispatcherServlet?command=Epdetails&&a_no="
													+ $(this).children().eq(0)
															.text();
										});
						$("#category")
								.change(
										function() {

											location.href = "${initParam.root}/DispatcherServlet?command=sa_epilogueListByCategory&c_c_no="
													+ $("#category").val();
										});
						$("#epilogueListByKeyWord")
								.click(
										function() {
										if($("#KeyWord").val()=="")
												return
											location.href = "${initParam.root}/DispatcherServlet?command=sa_epilogueListByKeyWord&option="+$("#findkey").val()
													+ "&KeyWord="+$("#KeyWord").val();
										});
						$("#list td:last-child").click(
								function() {
									$.ajax({
										type : "post",
										url : "${initParam.root}/DispatcherServlet",
										data : "command=sa_EpilogueDeleteAjax&a_no="+ $(this).parent().children().eq(0).text(),
										success : function() {
											location.reload();
										}
									}); // ajax
								}); // click
					});
</script>
</head>


<body>
	<a href="${initParam.root }/DispatcherServlet?command=sa_epilogueList">
		전체보기</a>
	<select name="category" id="category">
	</select>

	<%-- 	<c:if test="${ldto.pagingBean.previousPageGroup == true }">
		<a
			href="${initParam.root }/DispatcherServlet?command=sa_epilogueList&nowPage=${ldto.pagingBean.startPageOfPageGroup - 1}">[prev]</a>
	</c:if>
	<c:forEach begin="${ldto.pagingBean.startPageOfPageGroup }"
		end="${ldto.pagingBean.endPageOfPageGroup }" var="page">
		<c:choose>
			<c:when test="${page == ldto.pagingBean.nowPage }">
					&nbsp;[${page}]&nbsp;
				</c:when>
			<c:otherwise>
					&nbsp;<a
					href="${initParam.root }/DispatcherServlet?command=sa_epilogueList&nowPage=${page}">[${page}]</a>&nbsp;
				</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${ldto.pagingBean.nextPageGroup == true }">
		<a
			href="${initParam.root }/DispatcherServlet?command=sa_epilogueList&nowPage=${ldto.pagingBean.endPageOfPageGroup + 1}">[next]</a>
	</c:if> --%>
	<table border=1 id="list">
		<tr>
			<td>글번호</td>
			<td>글제목</td>
			<td>작성자</td>
			<td>작성일자</td>
			<td>조회수</td>
			<td>삭제</td>
		</tr>
		<c:forEach items="${requestScope.eplist}" var="eplist">
			<tr>
				<td>${eplist.articleDTO.a_no }</td>
				<td>${eplist.articleDTO.a_title }</td>
				<td>${eplist.memberDTO.nickname }</td>
				<td>${eplist.articleDTO.a_regdate }</td>
				<td>${eplist.articleDTO.hit }</td>
				<td><input type="hidden" name="command"
					value="sa_EpilogueDelete"> <input type="button" value="삭제"></td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value="글 작성" id="write">
	<br>
	<select id="findkey">
		<option value="1">제목</option>
		<option value="2">본문내용</option>
		<option value="3">글번호</option>
		<option value="4">작성자</option>


	</select>
	<input type="text" id="KeyWord">
	<input type="button" value="검색" id="epilogueListByKeyWord">