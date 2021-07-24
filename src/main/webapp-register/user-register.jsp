<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User register</title>
	</head>
	<body>
		<dl>
			<dt>Register forms</dt>
			<dd><br></dd>
			<dd><a href='${pageContext.request.contextPath}/FORMS/user-register-classic-form.jsp' target='_blank'>Classic register form</a></dd>
			<dd><a href='${pageContext.request.contextPath}/FORMS/user-register-update-form.jsp' target='_blank'>Update user form</a></dd>
			<dd><a href='${pageContext.request.contextPath}/FORMS/user-register-rename-form.jsp' target='_blank'>Rename user form</a></dd>
			<dd><a href='${pageContext.request.contextPath}/FORMS/user-register-renew-password-form.jsp' target='_blank'>Renew password form</a></dd>
			<dd><br></dd>
			<dt>Register reports</dt>
			<dd><br></dd>
			<dd><a href='${pageContext.request.contextPath}/REPORTS/user-register-classic-report.jsp' target='_blank'>Classic register report</a></dd>
			<dd><br></dd>
			<dt>Register operations</dt>
			<dd><br></dd>
			<dd><a href='${pageContext.request.contextPath}/FORMS/user-register-eraser-report.jsp' target='_blank'>Classic register eraser</a></dd>
			<dd><br></dd>
			<dt>Links</dt>
			<dd><br></dd>
			<dd><a href='${pageContext.request.contextPath}/index.jsp'>Index</a></dd>
			<dd><br></dd>
		</dl>
	</body>
</html>