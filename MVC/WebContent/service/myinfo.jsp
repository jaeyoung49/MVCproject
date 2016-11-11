<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="/service/loginCheck.jsp"></jsp:include>
<!--로그인 여부 체크  -->
<script src="//code.jquery.com/jquery.min.js"></script>
<!-- 회원정보 수정 페이지 -->
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#infoForm").hide();
				$("#pw").keyup(
						function() {
							$.ajax({
								type : "post",
								url : "${initParam.root}/DispatcherServlet",
								dataType : "json",
								data : "command=findMyInfoAjax&id="
										+ $("#id").val(),
								success : function(data) {
									if (data.pw == $("#pw").val()) {
										$("#infoForm").show();
										$("#idc").val($("#id").val());
										$("#nickname").val(data.nickname);
										$("#email").val(data.email);
										$("#birthday").val(data.birthday);
										$("#pwmsg").html("");
									} else {
										$("#pwmsg").html("비밀번호가 일치하지 않습니다.")
												.css("color", "red");
										return;
									}
								}
							});//ajax
						});//keyup				
			});
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
		<input type="hidden" name="command" value="changeInfo">
	</form>
	<div id="infoForm">
		<form method="post" action="${initParam.root }/DispatcherServlet">
			<table>
				<tr>
					<td>닉네임</td>
					<td><input type="text" name="nickname" id="nickname"></td>
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
			<input type="hidden" name="id" id="idc" value=""> <input
				type="hidden" name="command" value="changeMyInfo"> <input
				type="submit" value="정보수정"> <input type="button"
				value="탈퇴하기">
		</form>

	</div>