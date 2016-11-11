<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${empty sessionScope.dto }">
		<script type="text/javascript">
			alert("로그인 후 이용 바랍니다.")
			location.href = "index.jsp";
		</script>
	</c:when>
</c:choose>