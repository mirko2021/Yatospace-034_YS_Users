<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sessions report</title>
		<link rel='stylesheet' type='text/css' href='${pageContext.request.contextPath}/CSS/report.css'/>
	</head>
	<body>
		<h3>ИЗВЈЕШТАЈ О СВИМ КОРИСНИЧКИМ СЕСИЈАМА</h3>
		<jsp:include page='/WEB-INF/REPORTS/header/client-session-list-admin-header.jsp'></jsp:include>
		<jsp:include page='/WEB-INF/REPORTS/content/client-session-list-admin-page-form.jsp'></jsp:include>
		<jsp:include page='/WEB-INF/REPORTS/footer/client-session-list-admin-footer.jsp'></jsp:include>
	</body>
</html>