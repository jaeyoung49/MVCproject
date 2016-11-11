<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#list")
								.click(
										function() {
											location.href = "${initParam.root }/DispatcherServlet?command=Eplist";
										});
						$("#update")
								.click(
										function() {
											location.href = "DispatcherServlet?command=Epupdatewrite&a_no=${a_no}";
										});
						$("#delete")
								.click(
										function() {
											if (confirm("삭제하시겠습니까?"))
												location.href = "DispatcherServlet?command=Epdelete&a_no=${a_no}";
											else
												return;
										});
					});
</script>
</head>
<div class="container">
	<div align="left|center">home>화장품후기 게시판> ${c_name}</div>
	<table border="1" height="600" width="1000" align="center"
		class="type10">
		<tr height=20%>
			<td colspan="3" char><font size="40">${EpDto.get(EpilogueDTO).articleDTO.a_title}</font></td>
		</tr>
		<tr height=5%>
			<td width=40%>by ${EpDto.get(EpilogueDTO).memberDTO.nickname}</td>
			<td width=40%>${EpDto.get(EpilogueDTO).articleDTO.a_regdate}</td>
			<td width=20%>${EpDto.get(EpilogueDTO).articleDTO.hit}</td>
		</tr>
		<tr height=75%>
			<c:choose>
				<c:when test="${EpDto.get(EpilogueDTO).file_name eq null}">
					<td colspan="3">${EpDto.get(EpilogueDTO).articleDTO.a_content}</td>
				</c:when>
				<c:otherwise>
					<td colspan="2"><img width="500"
						src="${initParam.root}/img/${EpDto.get(EpilogueDTO).file_name}.${EpDto.get(EpilogueDTO).file_ext}">
					</td>
					<td>${EpDto.get(EpilogueDTO).articleDTO.a_content}</td>
				</c:otherwise>
			</c:choose>

		</tr>
	</table>
	<input type="button" class="button" value="글 수정" id="update"> <input
		type="button" class="button" value="글 삭제" id="delete"> <input
		type="button" class="button" value="전체목록" id="list">
</div>
