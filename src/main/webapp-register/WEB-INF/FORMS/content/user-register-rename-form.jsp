<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id='executeBean' class='yatospace.jsp.user.web.bean.PageExecutingBean' scope='request'></jsp:useBean>
<jsp:useBean id='registerBean' class='yatospace.jsp.user.web.bean.RegistrationBean' scope='session'></jsp:useBean>

<form method='POST' name='user_register_rename_form'>
	<table>
		<tr>
			<td>Корисничко име: </td>
			<td><input type='text' name='username' id='user_register_rename_username' required autofocus value='${registerBean.username}'/></td>
		</tr>
		<tr>
			<td>Ново корисничко име: </td>
			<td><input type='text' name='newUsername' id='user_register_rename_newusername' value='${registerBean.newUsername}'/></td>
		</tr>
	</table>
	<br>
	<input type='submit' name='user_register_rename_submit' value='Измјене'/>
	<input type='submit' name='user_register_rename_reset' value='ресетовање'/>
	<input type='submit' name='user_register_rename_test' value='тестирање'/>
</form>
