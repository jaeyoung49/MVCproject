<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
   function checkLogin() {
      var f = document.loginForm;
      if (f.id.value == "") {
         alert("아이디를 입력하세요");
         return false;
      } else if (f.password.value == "") {
         alert("패스워드를 입력하세요");
         return false;
      }
   }
</script>
</head>
<body>
   <form name="loginForm" method="post" action="DispatcherServlet"
      onsubmit="return checkLogin()">
      <input type="hidden" name="command" value="Login">
      <table>
         <tr>
            <td>아이디</td>
            <td><input type="text" name="id"></td>
         </tr>
         <tr>
            <td>비밀번호</td>
            <td><input type="password" name="pw"></td>
         </tr>
         <tr>
            <td colspan="2"><input type="submit" class="button" value="로그인"></td>
         </tr>
      </table>
   </form>
</body>
</html>