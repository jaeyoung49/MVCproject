<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form action="${initParam.root }/DispatcherServlet">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="url_info"></td>
		</tr>
		<tr>
			<td>동영상 링크</td>
			<td><input type="text" name="url_link"></td>
		</tr>
	</table>
	<input type="hidden" name="command" value="sa_VideoUrlUpLoad">
	<input type="submit" value="등록">
</form>