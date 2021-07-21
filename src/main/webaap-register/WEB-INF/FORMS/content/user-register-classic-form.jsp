<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id='executeBean' class='yatospace.jsp.user.web.bean.PageExecutingBean' scope='request'></jsp:useBean>
<jsp:useBean id='registerBean' class='yatospace.jsp.user.web.bean.RegistrationBean' scope='session'></jsp:useBean>

<form method='POST' name='user_register_form'>
	<table>
		<tr>
			<td>Корисничко име: </td>
			<td><input type='text' name='username' id='user_register_username' required autofocus value='${registerBean.username}'/></td>
		</tr>
		<tr>
			<td>Лозинка: </td>
			<td><input type='password' name='password' id='user_register_password'/></td>
		</tr>
		<tr>
			<td>Име: </td>
			<td><input type='text' name='name' id='user_register_name' value='${registerBean.name}'/></td>
		</tr>
		<tr>
			<td>Презиме: </td>
			<td><input type='text' name='surname' id='user_register_surname' value='${registerBean.surname}'/></td>
		</tr>
	</table>
	<br>
	<input type='submit' name='user_register_submit' value='Регистрација'/>
	<input type='submit' name='user_register_reset' value='ресетовање'/>
</form>