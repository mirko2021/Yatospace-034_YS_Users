<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id='executeBean' class='yatospace.jsp.user.web.bean.PageExecutingBean' scope='request'></jsp:useBean>
<jsp:useBean id='logonBean' class='yatospace.jsp.user.web.bean.LogonBean' scope='session'></jsp:useBean>

<form name='logout_form' method='POST'>
	<input type='submit' name='login_form_logout' value='Одјава'/>
</form>
