<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id='reportPaggingBeanCLUS' class='yatospace.jsp.user.web.bean.PaggingBean' scope='session'></jsp:useBean>
<jsp:useBean id='executeBean' class='yatospace.jsp.user.web.bean.PageExecutingBean' scope='request'></jsp:useBean>
<jsp:useBean id='logonBean' class='yatospace.jsp.user.web.bean.LogonBean' scope='session'></jsp:useBean>


<c:if test='${param["report_page_previous_us"] ne null}'>
	<c:out value="${reportPaggingBeanCLUS.setPageSize(param['pageSize'])}"></c:out>
	<c:out value="${reportPaggingBeanCLUS.previous(param['pageNo'])}"></c:out>
</c:if>

<c:if test='${param["report_page_refresh_us"] ne null}'>
	<c:out value="${reportPaggingBeanCLUS.setPageSize(param['pageSize'])}"></c:out>
	<c:out value="${reportPaggingBeanCLUS.refresh(param['pageNo'])}"></c:out>
</c:if>

<c:if test='${param["report_page_next_us"] ne null}'>
	<c:out value="${reportPaggingBeanCLUS.setPageSize(param['pageSize'])}"></c:out>
	<c:out value="${reportPaggingBeanCLUS.next(param['pageNo'])}"></c:out>
</c:if>

<c:if test="${param['user_sessions_logout_data'] ne null and param['user_sessions_logout_data'].trim().length() ne 0}">
	<c:out value="${logonBean.logoutLogged(pageContext.request, executeBean)}"></c:out>
</c:if>

<c:if test='${param["user_sessions_logout_submit"] ne null}'>
	<c:out value="${logonBean.logoutAll(pageContext.request, executeBean)}"></c:out>
</c:if>