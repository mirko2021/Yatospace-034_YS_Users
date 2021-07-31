<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id='reportPaggingBeanUS' class='yatospace.jsp.user.web.bean.PaggingBean' scope='session'></jsp:useBean>


<c:if test='${param["report_page_previous_us"] ne null}'>
	<c:out value="${reportPaggingBeanUS.setPageSize(param['pageSize'])}"></c:out>
	<c:out value="${reportPaggingBeanUS.previous(param['pageNo'])}"></c:out>
</c:if>

<c:if test='${param["report_page_refresh_us"] ne null}'>
	<c:out value="${reportPaggingBeanUS.setPageSize(param['pageSize'])}"></c:out>
	<c:out value="${reportPaggingBeanUS.refresh(param['pageNo'])}"></c:out>
</c:if>

<c:if test='${param["report_page_next_us"] ne null}'>
	<c:out value="${reportPaggingBeanUS.setPageSize(param['pageSize'])}"></c:out>
	<c:out value="${reportPaggingBeanUS.next(param['pageNo'])}"></c:out>
</c:if>
