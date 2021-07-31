<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id='reportPaggingBeanCLUS' class='yatospace.jsp.user.web.bean.PaggingBean' scope='session'></jsp:useBean>
<jsp:useBean id='sessionsBean' class='yatospace.jsp.user.web.bean.SessionsBean' scope='session'></jsp:useBean>
<jsp:useBean id='utilityBean' class='yatospace.jsp.user.web.bean.UtilityBean' scope='session'/>

<form name='user_sessions_logout' method='POST'>
	<c:forEach var='session' items='${sessionsBean.sessionsLogged(pageContext.request.session, reportPaggingBeanCLUS)}'>
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
		<input type='submit' value='Одјава' onclick='select_session_for_logout("${utilityBean.encodeHTML(session.descriptor.generalId())}")'>
		<br><br>
	</c:forEach>
	<input type='hidden' name='user_sessions_logout_data' id='user_sessions_logout_data'/>
</form>

<br>
<h3>ОДЈАВА СВИХ КОРИСНИЧКИХ СЕСИЈА</h3>
<form name='user_sessions_logout' method='POST'>
	<input type='submit' value='Одјава свега' name='user_sessions_logout_submit'/>
</form>