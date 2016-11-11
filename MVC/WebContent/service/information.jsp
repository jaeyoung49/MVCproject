<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
html {
	height: 100%
}

body {
	height: 100%;
	margin: 0px;
	padding: 0px
}

#map_canvas {
	
}
</style>
<script type="text/javascript"
	src="https://maps.google.com/maps/api/js?sensor=true"></script>
<script type="text/javascript">
	var map;
	function initialize() {
		var latlng = new google.maps.LatLng(37.402036, 127.106138);
		var myOptions = {
			zoom : 15,
			center : latlng,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		map = new google.maps.Map(document.getElementById("map_canvas"),
				myOptions);
		map.setTilt(45);
	}
	window.onload = function() {
		initialize();
	}
</script>
</head>
<body>
	<div id="map_canvas" style="width: 500px; height: 500px;"></div>


</body>
</html>