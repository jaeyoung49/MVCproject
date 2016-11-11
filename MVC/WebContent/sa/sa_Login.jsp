<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form action="${initParam.root }/DispatcherServlet" method="post">
	ID :<input type="text" name="id"> PW : <input type="text"
		name="pw"> <input type="hidden" name="command"
		value="sa_Login"><input type="submit" value="로그인">
</form>
