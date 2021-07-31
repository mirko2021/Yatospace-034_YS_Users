<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id='reportPaggingBeanCUS' class='yatospace.jsp.user.web.bean.PaggingBean' scope='session'></jsp:useBean>
<jsp:useBean id='sessionsBean'        class='yatospace.jsp.user.web.bean.SessionsBean' scope='session'></jsp:useBean>
<jsp:useBean id='logonBean'           class='yatospace.jsp.user.web.bean.LogonBean' scope='session'></jsp:useBean>


<c:forEach var='session' items='${sessionsBean.sessionsLogged(pageContext.request.session, reportPaggingBeanCUS)}'>
	<table class='report_table'>
		<tr>
			<td><b>Сесија: </b></td>
			<td><c:out value='${session.descriptor.generalId()}'></c:out></td>
		</tr>
		<tr>
			<td><b>Корисник: </b></td>
			<td><c:out value='${sessionsBean.username(session)}'></c:out></td>
		</tr>
	</table>
	<br>
</c:forEach>	
