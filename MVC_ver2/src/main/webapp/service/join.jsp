<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//code.jquery.com/jquery.min.js"></script>
<title>회원가입</title>
<!-- 회원가입 페이지 -->
<style>
#content {
	font-size: 12px;
	font-style: "돋음"
}

font {
	float: right;
}

span .joinForm {
	color: red;
}

input {
	border: 1px solid #ccccc;
}

select option {
	border: 1px solid #ccccc;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$("#id").keyup(function() {
			var id=$(this).val();
			if (id.length < 4 || id.length> 10) {
				$("#idmsg").html("아이디는 4자이상 10자이하만 가능").css("color", "red");
				return false;
			} //if
			$.ajax({
				type : "post",
				url : "duplicateIdCheck.do",
				data : "id="+$("#id").val(),
				success : function(data) {
					if (data == "ok") {
						$("#idmsg").html("사용가능").css("color", "green");
					} else {
						$("#idmsg").html("중복된 아이디 사용불가").css("color", "red");
						return false;
					}
				}
			});//ajax
		});//keyup				
		$("#password").keyup(function(){
			var pw=$(this).val();
			if (pw.length < 4 || pw.length> 10) {
			$("#passwordMsg").html("비밀번호는 4자이상 10자이하만 가능").css("color", "red");
			return false;
			}else{
				$("#passwordMsg").html("");
			}
		});
				
		$("#rePassword").keyup(function(){
			if ($("#password").val() != $("#rePassword").val()) {
				$("#rePasswordMsg").html("입력한 비밀번호와 동일한 비밀번호가 아닙니다.").css("color", "red");
				return false;
			}else{
				$("#rePasswordMsg").html("");
			}
		});
		
		$('form').submit(function(){ 
			if($("#id").val()==""){
				$("#idmsg").html("필수정보입니다.");
				 return false;
			}else{
				$("#idmsg").html("");
			} 
				
				
			if($("#password").val()==""){
				$("#passwordMsg").html("필수정보입니다.");
				return false;
			} else if ($("#m_name").val() == "") { // 성명 입력란
				$("#m_namemsg").show();
				return false;
			} else if ($("#nickName").val() == "") { // 닉네임 입력란
				$("#nickNamemsg").show();
				return false;
			} else if ($("td :radio[name=sex]:checked").length == 0) { // 성별 입력란
				$("#sexmsg").show();
				return false;
			} else if ($("#birthday").val() == "") { // 생년월일 입력란
				$("#birthmsg").show();
				return false;
			} else if ($("#birthday").val().length != 6) { // 생년월일 6자리
				$("#birthmsg1").show();
				return false;
			} else if ($("#email").val() == "") { // 이메일 입력란
				$("#emailmsg").show();
				return false;
			}
			
			var email =  $("#email").val();
			var regex = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
			if(regex.test(email)==false) {  
				$("#selectMailmsg").show();
				return false;
			}
		});
	});//ready
</script>
</head>
<body>
	<!-- 가입시 필수 입력사항 :  id, pw, m_name(성명), sex, email, nickname, birthday -->
	<div id="content">
		<form method="post" action="join.do" name="joinForm">
			<table>
				<tr>
					<td>아이디</td>
					<td>
						<input type='text' name="id" id="id"> 
						<span id="idmsg"></span>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="text" name="password" id="password"> 
						<span id="passwordMsg"></span>
					</td>
				</tr>
				<tr>
					<td>비밀번호 재확인</td>
					<td>
						<input type="text" name="rePassword" id="rePassword"> 
						<span id="rePasswordMsg"></span>
					</td>
				</tr>
				<tr>
					<td>성명</td>
					<td>
						<input type="text" name="name" id="m_name"> 
						<span id="m_namemsg" style="display: none">필수정보입니다.</span>
					</td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td>
						<input type="text" name="nick" id="nickName">
						<span id="nickNamemsg" style="display: none">필수정보입니다.</span>
					</td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<input type="radio" name="sex" id="sex" value="남">남
						<input type="radio" name="sex" id="sex" value="여">여 
						<span id="sexmsg" style="display: none">필수정보입니다.</span>
					</td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td>
						<input type="text" name="birthday" id="birthday" placeholder="생년월일 6자리"> 
						<span id="birthmsg" style="display: none">필수정보입니다.</span>
						<span id="birthmsg1" style="display: none">6자리로 입력바랍니다.</span>
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<input type="text" name="email" id="email"> 
						<span id="emailmsg" style="display: none">필수정보입니다.</span> 
						<span id="selectMailmsg" style="display: none">이메일 주소를 정확하게 입력바랍니다.</span>
					</td>
				</tr>
			</table>
			<input type="hidden" name="command" value="Join"> 
			<input type="submit" value="가입">
		</form>
	</div>
</body>
</html>