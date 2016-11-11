<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="/service/loginCheck.jsp"></jsp:include>
<!--로그인 여부 체크  -->
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var num;
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
									if (ex.c_c_name == "${c_name}") {
										num = ex.c_c_no;
									}
								}
								$("#category").html(html);
								$("#category").val(num);
							}
						});
						// 		$("#update").click(function(){
						// 			if(confirm("수정하시겠습니까?"))
						// 				location.href="DispatcherServlet?command=Epdelete&a_no=${a_no}";
						// 			else
						// 				return;
						// 		});
						$("#cancle")
								.click(
										function() {
											location.href = "DispatcherServlet?command=Eplist&a_no=${a_no}";
										});
					});
</script>
<style type="text/css">
td.category {
	border-left-style: none;
	border-right-style: none;
	border-top-style: none;
}
</style>
</head>
<%-- 	${map.EpDto.get(EpilogueDTO).articleDTO.a_content} --%>
<%-- 	<img src="${map.EpDto.get(EpilogueDTO).file_name}.${map.EpDto.get(EpilogueDTO).file_ext}"> --%>

<form action="DispatcherServlet?command=Epupdate&a_no=${a_no}"
	enctype="multipart/form-data" method="post">

	<table border="1" height="600" width="1000" align="center">
		<tr height=5%>
			<td colspan="3" class="category">home> 화장품후기 게시판> <select
				name="category" id="category">
			</select> >${a_no}
			</td>
		</tr>
		<tr height=15%>
			<td colspan="3"><font size="40"><input type="text"
					value="${EpDto.get(EpilogueDTO).articleDTO.a_title}" name="title" /></font></td>
		</tr>
		<tr height=5%>
			<td width=40%>by ${EpDto.get(EpilogueDTO).memberDTO.nickname}</td>
			<td width=40%>${EpDto.get(EpilogueDTO).articleDTO.a_regdate}</td>
			<td width=20%>${EpDto.get(EpilogueDTO).articleDTO.hit}</td>
		</tr>
		<tr height=75%>
			<td colspan="4" align="center">&nbsp;&nbsp; <img width="350"
				src="${EpDto.get(EpilogueDTO).image_path}${EpDto.get(EpilogueDTO).file_name}.${EpDto.get(EpilogueDTO).file_ext}">
				<textarea cols="50" rows="20" name="content">${EpDto.get(EpilogueDTO).articleDTO.a_content}</textarea><br>
				<input type="file" name="upfile">
			</td>
		</tr>
	</table>
	<input type="submit" value="수정하기" id="update"> <input
		type="button" value="취소" id="cancle">
</form>
