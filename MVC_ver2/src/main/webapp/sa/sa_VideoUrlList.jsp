<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<a href="${initParam.root }/sa/sa_index.jsp?page=sa_VideoUrlUpLoad">동영상
	등록</a>
<table border="1">
	<tr>
		<td>NO</td>
		<td>제목</td>
		<td>내용</td>
		<td>링크</td>
		<td>작성일자</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>
	<c:forEach items="${list }" var="list">
		<tr>
			<td>${list.no }</td>
			<td>${list.title }</td>
			<td>${list.url_info }</td>
			<td><textarea cols="100">${list.url_link }</textarea></td>
			<td>${list.regdate }</td>
			<td><input type="button" value="삭제"></td>
			<td><input type="button" value="수정"></td>
		</tr>

	</c:forEach>
</table>