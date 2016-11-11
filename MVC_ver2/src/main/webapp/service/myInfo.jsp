<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="//code.jquery.com/jquery.min.js"></script>
<!-- 회원정보 수정 페이지 -->
<script type="text/javascript">
	$(document).ready(function() {
		$("#infoForm").hide();
		$("#pw").keyup(	function() {
			$.ajax({
				type : "post",
				url : "findMyInfoAjax.do",
				dataType : "json",
				data : "id="+ $("#id").val(),
				success : function(data) {
					if (data.password == $("#pw").val()) {
						$("#infoForm").show();
						$("#idc").val($("#id").val());
						$("#nickname").val(data.nick);
						$("#email").val(data.email);
						$("#birthday").val(data.birthday);
						$("#pwmsg").html("");
					} else {
						$("#pwmsg").html("비밀번호가 일치하지 않습니다.")
								.css("color", "red");
						$("#infoForm").hide();
						return;
					}
				}
			});//ajax
		});//keyup		
		
	});//ready
</script>
<body>
	[아이디와 비밀번호가 일치하여야 정보가 보여집니다.]
	<form>
		<table>
			<tr>
				<td>아이디</td>
				<td><input type='text' name="id" id="id" value=""> <span
					id="idmsg"></span></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw" id="pw"> <span
					id="pwmsg"></span></td>
			</tr>
		</table>
	</form>
	<div id="infoForm">
		<form method="post" action="changeMyInfo.do">
			<table>
				<tr>
					<td>닉네임</td>
					<td><input type="text" name="nick" id="nickname"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email" id="email"></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="birthday" id="birthday">
				</tr>
			</table>
			<input type="hidden" name="id" id="idc" value=""> 
			<input type="submit" value="정보수정"> 
		</form>

	</div>