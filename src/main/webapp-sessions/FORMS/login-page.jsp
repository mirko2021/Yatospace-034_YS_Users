<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id='executeBean' class='yatospace.jsp.user.web.bean.PageExecutingBean' scope='request'></jsp:useBean>
<jsp:useBean id='logonBean' class='yatospace.jsp.user.web.bean.LogonBean' scope='session'></jsp:useBean>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login page</title>
	</head>
	<body>
		<h3>ПРИЈАВА КОРИСНИКА</h3>
		<jsp:include page="/WEB-INF/FORMS/header/login-header.jsp"></jsp:include>
		<c:if test="${logonBean.isLogged()}">
					<jsp:include page="/WEB-INF/FORMS/content/login-form.jsp"></jsp:include>
		</c:if>
		<c:if test="${not logonBean.isLogged()}">
			<jsp:include page="/WEB-INF/FORMS/content/logout-form.jsp"></jsp:include>
		</c:if>
		<jsp:include page="/WEB-INF/FORMS/footer/login-footer.jsp"></jsp:include>
	</body>
</html>