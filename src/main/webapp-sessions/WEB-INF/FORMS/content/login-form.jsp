<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id='executeBean' class='yatospace.jsp.user.web.bean.PageExecutingBean' scope='request'></jsp:useBean>
<jsp:useBean id='logonBean' class='yatospace.jsp.user.web.bean.LogonBean' scope='session'></jsp:useBean>

<form name='login_form' method='POST'>
	<table>
		<tr>
			<td>Корисничко име: </td>
			<td><input type='text' name='username' value='${logonBean.username}'/></td>
		</tr>
		<tr>
			<td>Лозинка: </td>
			<td><input type='password' name='password' value='${logonBean.password}'/></td>
		</tr>
	</table>
	<br>
	<input type='submit' name='login_form_login' value='Пријава'/>
	<input type='submit' name='login_form_reset'  value='ресетовање'>
	<input type='submit' name='login_form_test'  value='тестирање'>
</form>