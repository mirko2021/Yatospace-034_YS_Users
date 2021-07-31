<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<form method='POST' name='user_register_renew_password_form'>
	<table>
		<tr>
			<td>Корисничко име: </td>
			<td><input type='text' name='username' id='user_register_renew_password_username' required autofocus value='${registerBean.username}'/></td>
		</tr>
		<tr>
			<td>Нова лозинка: </td>
			<td><input type='password' name='password' id='user_register_renew_password_newusername' value='${registerBean.newUsername}'/></td>
		</tr>
	</table>
	<br>
	<input type='submit' name='user_register_renew_password_submit' value='Измјене'/>
	<input type='submit' name='user_register_renew_password_reset' value='ресетовање'/>
	<input type='submit' name='user_register_renew_password_test' value='тестирање'/>
</form>
