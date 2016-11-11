<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="/service/loginCheck.jsp"></jsp:include>
<!--로그인 여부 체크  -->
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#submit").click(function() {
					if ($("#a_title").val() == "") {
						alert("제목을 입력하세요");
						return false;
					}
					if ($("#a_content").val() == "") {
						alert("본문을 입력하세요");
						return false;
					}
					if ($("#category").val() == "") {
						alert("카테고리를 입력하세요");
						return false;
					}
				});
				$.ajax({
					type : "post",
					url : "${initParam.root}/DispatcherServlet",
					dataType : "json",
					data : "command=c_categoryAjax",
					success : function(data) {
						var html = "<option value=''>-- </option>";
						for (var i = 0; i < data.length; i++) {
							var ex = JSON.parse(data[i]);
							html += "<option value=" + ex.c_c_no+ ">"
									+ ex.c_c_name + "</option>";
						}
						$("#category").html(html);
					}
				});
			});//ready;

	function cancle() {
		location.href = "DispatcherServlet?command=Eplist"
	}
</script>


<form action="DispatcherServlet?command=Epilogue_register"
	enctype="multipart/form-data" method="post">
	<!--   <input type="hidden" name="command" value="epilogue_register"> -->
	<table class="inputForm" border="3">
		<tbody>
			<tr>
				<td>제목</td>
				<td colspan="3"><input type="text" size="48" name="title"
					id="a_title"></td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td><select name="category" id="category"></select></td>

			</tr>
			<tr>
				<td colspan="4" align="center">&nbsp;&nbsp; <textarea cols="50"
						rows="20" name="content" id="a_content"></textarea> <input
					type="file" name="upfile">
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit" value="등록"
					id="submit" /> <input type="button" value="취소"
					onclick=javascsript:cancle(); /></td>
			</tr>
		</tbody>
	</table>
</form>
