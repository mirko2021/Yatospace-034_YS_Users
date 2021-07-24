<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Reports for erasing</title>
		<link rel='stylesheet' type='text/css' href='${pageContext.request.contextPath}/CSS/report.css'/>
		<script type='text/javascript' src='${pageContext.request.contextPath}/JS/user_erase.js'></script>
	</head>
	<body>
		<h3>Преглед корисника за брисање</h3>
		<jsp:include page="/WEB-INF/FORMS/header/report-eraser-header.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/FORMS/content/report-eraser-content.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/FORMS/footer/report-eraser-footer.jsp"></jsp:include>
	</body>
</html>