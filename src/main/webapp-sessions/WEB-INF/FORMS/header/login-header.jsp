<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id='executeBean' class='yatospace.jsp.user.web.bean.PageExecutingBean' scope='request'></jsp:useBean>
<jsp:useBean id='logonBean' class='yatospace.jsp.user.web.bean.LogonBean' scope='session'></jsp:useBean>

<c:if test='${param["login_form_login"] ne null}'>
	<c:out value="${logonBean.login(pageContext.request, executeBean)}"></c:out>
</c:if>
<c:if test='${param["login_form_reset"] ne null}'>
	<c:out value="${logonBean.reset()}"></c:out>
</c:if>
<c:if test='${param["login_form_test"] ne null}'>
	<c:out value="${logonBean.test(pageContext.request, executeBean)}"></c:out>
</c:if>
<c:if test='${param["login_form_logout"] ne null}'>
	<c:out value="${logonBean.logout(pageContext.request, executeBean)}"></c:out>
</c:if>