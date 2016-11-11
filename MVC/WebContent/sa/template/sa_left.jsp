<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="//code.jquery.com/jquery.min.js"></script>
<jsp:include page="sa_sessionCheck.jsp"></jsp:include>
<script>
	setInterval(function updateClock() {
		var currentTime = new Date();
		var currentHours = currentTime.getHours();
		var currentMinutes = currentTime.getMinutes();
		var currentSeconds = currentTime.getSeconds();
		// Pad the minutes and seconds with leading zeros, if required
		currentMinutes = (currentMinutes < 10 ? "0" : "") + currentMinutes;
		currentSeconds = (currentSeconds < 10 ? "0" : "") + currentSeconds;
		// Choose either "AM" or "PM" as appropriate
		var timeOfDay = (currentHours < 12) ? "AM" : "PM";
		// Convert the hours component to 12-hour format if needed
		currentHours = (currentHours > 12) ? currentHours - 12 : currentHours;
		// Convert an hours component of "0" to "12"
		currentHours = (currentHours == 0) ? 12 : currentHours;
		// Compose the string for display
		var currentTimeString = currentHours + ":" + currentMinutes + ":"
				+ currentSeconds + " " + timeOfDay;
		$("#clock").html(currentTimeString);
	}, 1000);
</script>
<div>
	<p>
		<strong>${sessionScope.dto.id }</strong>님 환영합니다.
	</p>
</div>
<div id="clock"></div>
<a href="${initParam.root }/DispatcherSerlet?command=Logout">로그아웃</a>
<br>
<a
	href="${initParam.root }/DispatcherServlet?command=sa_memberManagement">회원관리</a>
<br>
<a href="${initParam.root }/index.jsp">사용자 페이지</a>
<br>
<a href="${initParam.root }/DispatcherServlet?command=sa_noticeList">공지사항
	게시판 관리</a>
<br>
<a href="${initParam.root }/DispatcherServlet?command=sa_epilogueList">후기
	게시판 관리</a>
<br>
<a href="${initParam.root }/DispatcherServlet?command=sa_VideoUrlList">메인
	관리</a>