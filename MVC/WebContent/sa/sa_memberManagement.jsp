<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(document).ready(
			function() {
				// 회원 삭제
				$("#list td:last-child").click(
						function() {
							$.ajax({
								type : "post",
								url : "${initParam.root}/DispatcherServlet",
								data : "command=sa_MemberDeleteAjax&id="
										+ $(this).parent().children().eq(0)
												.text(),
								success : function() {
									location.reload()
								}
							}); // ajax

						}); // click
				$("#list td select").change(
						function() {
							$.ajax({
								type : "post",
								url : "${initParam.root}/DispatcherServlet",
								data : "command=sa_memberGradeChangeAjax&id="
										+ $(this).parent().parent().children()
												.eq(0).text() + "&m_gradeno="
										+ $(this).val(),
								success : function() {
									location.reload()
								}
							});
						}); //change
				/* // 등급 변경
				$.ajax({
					type : "post",
					url : "${initParam.root}/DispatcherServlet",
					dataType : "json",
					data : "command=sa_memberGradeChangeAjax",
					success : function(data) {
						for (var i = 0; i < data.length; i++) {
							var ex = JSON.parse(data[i]);
							html += "<option value=" + ex.m_gradeno+ ">"
									+ ex.m_grade_name
									+ "</option>";
							var html = "<select name='category' id='category'><option value=''>회원 등급</option>";
							$("#gradeList"+i).html(html);
						}
					}
				}); */
			}); // ready
</script>
<table border=1 id="list">
	<!--  아이디, 비밀번호, 이름, 성별, 이메일, 닉네임, 생일, 가입일, 개시글 갯수, 댓글 갯수, 등급 번호  -->
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>성별</td>
		<td>이메일</td>
		<td>닉네임</td>
		<td>가입일</td>
		<td>게시글 갯수</td>
		<td>댓글 갯수</td>
		<td>회원 등급</td>
		<td>등급 변경</td>
		<td>탈퇴</td>
	</tr>
	<c:forEach items="${requestScope.ldto.mlist}" var="memberlist"
		varStatus="gradeList">
		<tr>
			<td>${memberlist.id }</td>
			<td>${memberlist.m_name }</td>
			<td>${memberlist.sex }</td>
			<td>${memberlist.email }</td>
			<td>${memberlist.nickname }</td>
			<td>${memberlist.m_regdate }</td>
			<td>${memberlist.a_count }</td>
			<td>${memberlist.r_count }</td>
			<td>${memberlist.m_grade_name }</td>
			<td><select name="" id="gardeName">
					<option value="">--</option>
					<option value="1">준회원</option>
					<option value="2">정회원</option>
					<option value="3">우수회원</option>
					<option value="4">VIP회원</option>
					<option value="5">운영자</option>
			</select></td>
			<td><input type="hidden" name="command" value="sa_MemberDelete">
				<input type="button" value="회원 추방"></td>
		</tr>
	</c:forEach>
</table>


