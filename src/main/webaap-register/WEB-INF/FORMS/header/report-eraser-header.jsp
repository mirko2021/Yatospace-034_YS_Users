<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id='registerBean' class='yatospace.jsp.user.web.bean.RegistrationBean' scope='session'></jsp:useBean>
<jsp:useBean id='executeBean' class='yatospace.jsp.user.web.bean.PageExecutingBean' scope='request'></jsp:useBean>

<c:if test="${param['erase_form_input'] ne null and param['erase_form_input'].trim().length() ne 0}">
	<c:out value="${registerBean.deregister(pageContext.request, executeBean)}"></c:out>
</c:if>
