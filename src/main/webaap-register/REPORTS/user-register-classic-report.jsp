<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User register classic report</title>
		<link rel='stylesheet' type='text/css' href='${pageContext.request.contextPath}/CSS/report.css'/>
	</head>
	<body>
		<h3>Преглед корисника</h3>
		<jsp:include page="/WEB-INF/REPORTS/header/report-classic-header.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/REPORTS/content/report-classic-content.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/REPORTS/footer/report-classic-footer.jsp"></jsp:include>
	</body>
</html>