<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script>
	function cancel(){
		var flag = confirm("작성을 취소하시겠습니까?");
		if(flag==true){
			history.back();
		}
	}
	function regArticle(){
		var flag = confirm("작성을 완료하시겠습니까?");
		if(flag == true){
			$(document).ready(function(){
				$.ajax({
					type : "get",
					url : "noticeResponse.do",
					data : $("#regForm").serialize(),
					success : function(data){
						alert("등록되었습니다");
						location.href="noticeDetailNoHit.do?articleVO.articleNo="+data;
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
	</tr>	
	<tr>
		<td>제목</td>
		<td colspan=3>
			<input type="text" name="articleVO.articleTitle" value="${requestScope.noticeVO.articleVO.articleTitle }">
		</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td colspan=3>
		${sessionScope.memberVO.id }
		</td>
	</tr>						
	<tr>
		<td colspan=4>내용</td>
	</tr>
	<tr>
		<td colspan=4>
			<textarea cols="54" rows="10" name="articleVO.articleContent">${requestScope.noticeVO.articleVO.articleContent }</textarea>
		</td>
	</tr>
</table>
<input type="button" value="등록" onclick="regArticle()">
<input type="button" value="작성취소" onclick="cancel()">
<input type="hidden" name="articleVO.memberVO.id" value=${sessionScope.memberVO.id }>
<input type="hidden" name="articleVO.articleNo" value=${requestScope.noticeVO.articleVO.articleNo }>
<input type="hidden" name="articleVO.responseGroup" value=${requestScope.noticeVO.articleVO.responseGroup }>
<input type="hidden" name="articleVO.responseOrder" value=${requestScope.noticeVO.articleVO.responseOrder+1 }>
<input type="hidden" name="articleVO.responseStep" value=${requestScope.noticeVO.articleVO.responseStep+1 }>
</form>