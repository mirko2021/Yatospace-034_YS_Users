<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id='executeBean' class='yatospace.jsp.user.web.bean.PageExecutingBean' scope='request'></jsp:useBean>
<jsp:useBean id='registerBean' class='yatospace.jsp.user.web.bean.RegistrationBean' scope='session'></jsp:useBean>

<c:if test='${param["user_register_rename_submit"] ne null}'>
	<jsp:setProperty name='registerBean' property='*'></jsp:setProperty>
	<c:out value='${registerBean.rename(pageContext.request.session, executeBean)}'></c:out>
</c:if>

<c:if test='${param["user_register_rename_reset"] ne null}'>
	<c:out value='${registerBean.resetForRename()}'></c:out>
</c:if>

<c:if test='${param["user_register_rename_test"] ne null}'>
	<c:out value='${registerBean.testUsername(pageContext.request, executeBean)}'></c:out>
</c:if>