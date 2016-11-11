<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
   $(document)
         .ready(
               function() {
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

                  $("#list tr").filter(":gt(0)").hover(function() {
                     $(this).css("background", "pink");
                  }, function() {
                     $(this).css("background", "white");
                  });
                  $("#list tr")
                        .filter(":gt(0)")
                        .click(
                              function() {
                                 //          alert($(this).children().eq(0).text());
                                 location.href = "DispatcherServlet?command=Epdetails&&a_no="
                                       + $(this).children().eq(0)
                                             .text();
                              });
                  $("#write")
                        .click(
                              function() {
                                 location.href = "DispatcherServlet?command=Epwrite";
                              });
                  $("#category")
                        .change(
                              function() {

                                 location.href = "${initParam.root}/DispatcherServlet?command=epilogueListByCategory&c_c_no="
                                       + $("#category").val();
                              });
                  $("#epilogueListByKeyWord")
                        .click(
                              function() {
                              if($("#KeyWord").val()=="")
                                    return
                                 location.href = "${initParam.root}/DispatcherServlet?command=epilogueListByKeyWord&option="+$("#findkey").val()
                                       + "&KeyWord="+$("#KeyWord").val();
                              });
               });
</script>
</head>


<body>
	<table id="list" class="table table-condensed">
		<tr>
			<td colspan="5"><select name="category" id="category"
				class="form-control col-xs-2"></select></td>
		</tr>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${requestScope.eplist}" var="eplist">
			<tr>
				<td>${eplist.articleDTO.a_no }</td>
				<td>${eplist.articleDTO.a_title }</td>
				<td>${eplist.memberDTO.nickname }</td>
				<td>${eplist.articleDTO.a_regdate }</td>
				<td>${eplist.articleDTO.hit }</td>
			</tr>
		</c:forEach>
	</table>
	<div align="center">
		<select id="findkey">
			<option value="1">제목</option>
			<option value="2">본문내용</option>
			<option value="3">글번호</option>
			<option value="4">작성자</option>
		</select> <input type="text" id="KeyWord"> <input type="button"
			value="검색" class="button" id="epilogueListByKeyWord"> <input
			type="submit" class="button" value="글 작성" id="write"><a
			href="${initParam.root }/DispatcherServlet?command=Eplist"
			class="button"> 다시 조회</a>
	</div>