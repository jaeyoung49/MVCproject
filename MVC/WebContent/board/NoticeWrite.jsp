<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function cancel(){
		var flag = confirm("작성을 취소하시겠습니까?");
		if(flag==true){
			history.back();
		}
	}
	function regArti(){
		var flag = confirm("작성을 완료하시겠습니까?");
		if(flag == true){
			$(document).ready(function(){
				$.ajax({
					type : "get",
					url : "DispatcherServlet",
					data : $("#regForm").serialize(),
					success : function(){
						alert("등록되었습니다");
						location.href="DispatcherServlet?command=Notice";
					}
				});
			});
		}
	}
</script>
<form id="regForm">
<table border=1>
	<tr>
		<td colspan=4>
			<input type="checkbox" value="1" name="priority">공지글 상위 표시 여부
		</td>
	<tr>
		<td>제목</td>
		<td colspan=3>
			<input type="text" name="title">
		</td>
	</tr>
	<tr>
		<td>닉네임(아이디)</td>
		<td colspan=3>
		${sessionScope.dto.nickname }(${sessionScope.dto.id })
		</td>
	</tr>						
	<tr>
		<td colspan=4>내용</td>
	</tr>
	<tr>
		<td colspan=4>
			<textarea cols="54" rows="10" name="content"></textarea>
		</td>
	</tr>
</table>
<input type="button" value="등록" onclick="regArti()">
<input type="button" value="작성취소" onclick="cancel()">
<input type="hidden" name="command" value="Notice_Register">
<input type="hidden" name="id" value=${sessionScope.dto.id }>
</form>