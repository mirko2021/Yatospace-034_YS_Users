<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id='reportPaggingBean' class='yatospace.jsp.user.web.bean.PaggingBean' scope='session'></jsp:useBean>


<c:if test='${param["report_page_previous"] ne null}'>
	<c:out value="${reportPaggingBean.setPageSize(param['pageSize'])}"></c:out>
	<c:out value="${reportPaggingBean.previous(param['pageNo'])}"></c:out>
</c:if>

<c:if test='${param["report_page_refresh"] ne null}'>
	<c:out value="${reportPaggingBean.setPageSize(param['pageSize'])}"></c:out>
	<c:out value="${reportPaggingBean.refresh(param['pageNo'])}"></c:out>
</c:if>

<c:if test='${param["report_page_next"] ne null}'>
	<c:out value="${reportPaggingBean.setPageSize(param['pageSize'])}"></c:out>
	<c:out value="${reportPaggingBean.next(param['pageNo'])}"></c:out>
</c:if>
