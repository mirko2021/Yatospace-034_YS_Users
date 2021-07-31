<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id='eraserPaggingBean' class='yatospace.jsp.user.web.bean.PaggingBean' scope='session'></jsp:useBean>

<c:if test='${param["report_page_previous"] ne null}'>
	<c:out value="${eraserPaggingBean.setPageSize(param['pageSize'])}"></c:out>
	<c:out value="${eraserPaggingBean.previous(param['pageNo'])}"></c:out>
</c:if>

<c:if test='${param["report_page_refresh"] ne null}'>
	<c:out value="${eraserPaggingBean.setPageSize(param['pageSize'])}"></c:out>
	<c:out value="${eraserPaggingBean.refresh(param['pageNo'])}"></c:out>
</c:if>

<c:if test='${param["report_page_next"] ne null}'>
	<c:out value="${eraserPaggingBean.setPageSize(param['pageSize'])}"></c:out>
	<c:out value="${eraserPaggingBean.next(param['pageNo'])}"></c:out>
</c:if>
