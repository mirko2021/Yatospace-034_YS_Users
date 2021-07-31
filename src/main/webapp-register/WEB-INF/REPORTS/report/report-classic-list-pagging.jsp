<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id='reportPaggingBean' class='yatospace.jsp.user.web.bean.PaggingBean' scope='session'></jsp:useBean>
<jsp:useBean id='usersBean' class='yatospace.jsp.user.web.bean.UsersBean' scope='session'></jsp:useBean>

<c:forEach var='user' items='${usersBean.users(reportPaggingBean)}'>
	<table class='report_table'>
		<tr>
			<td><b>Корисничко име: </b></td>
			<td><c:out value='${user.username}'></c:out></td>
		</tr>
		<tr>
			<td><b>Запис лозинке: </b></td>
			<td><c:out value='${user.password}'></c:out></td>
		</tr>
		<tr>
			<td><b>Име: </b></td>
			<td><c:out value='${user.firstname}'></c:out></td>
		</tr>
		<tr>
			<td><b>Презиме: </b></td>
			<td><c:out value='${user.secondname}'></c:out></td>
		</tr>		
	</table>
	<br>
</c:forEach>	