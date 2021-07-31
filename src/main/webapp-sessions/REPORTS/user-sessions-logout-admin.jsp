<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sessions report</title>
		<link rel='stylesheet' type='text/css' href='${pageContext.request.contextPath}/CSS/report.css'/>
		<script type='text/javascript' src='${pageContext.request.contextPath}/JS/user_sessions_logout.js'></script>
	</head>
	<body>
		<h3>ИЗВЈЕШТАЈ О СВИМ КОРИСНИЧКИМ СЕСИЈАМА</h3>
		<jsp:include page='/WEB-INF/REPORTS/header/user-logout-list-admin-header.jsp'></jsp:include>
		<jsp:include page='/WEB-INF/REPORTS/content/user-logout-list-admin-page-form.jsp'></jsp:include>
		<jsp:include page='/WEB-INF/REPORTS/footer/user-logout-list-admin-footer.jsp'></jsp:include>
	</body>
</html>