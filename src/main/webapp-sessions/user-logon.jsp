<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User logon index</title>
	</head>
	<body>
		<dl>
			<dt>Logon forms</dt>
			<dd><br></dd>
			<dd><a href='${pageContext.request.contextPath}/FORMS/login-page.jsp' target='_blank'>Login form</a></dd>
			<dd><br></dd>
			<dt>Session reports</dt>
			<dd><br></dd>
			<dd><a href='${pageContext.request.contextPath}/REPORTS/user-sessions-list-admin.jsp' target='_blank'>Sessions reports</a></dd>
			<dd><a href='${pageContext.request.contextPath}/REPORTS/user-sessions-list-logged.jsp' target='_blank'>User sessions reports</a></dd>
			<dd><a href='${pageContext.request.contextPath}/REPORTS/user-sessions-logout-admin.jsp' target='_blank'>Sessions logout administrations</a></dd>
			<dd><a href='${pageContext.request.contextPath}/REPORTS/user-sessions-logout-logged.jsp' target='_blank'>User sessions logout administrations</a></dd>
			<dd><br></dd>
			<dt>Links</dt>
			<dd><br></dd>
			<dd><a href='${pageContext.request.contextPath}/index.jsp'>Index</a></dd>
		</dl>
	</body>
</html>