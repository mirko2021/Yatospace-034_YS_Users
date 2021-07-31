<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id='executeBean' class='yatospace.jsp.user.web.bean.PageExecutingBean' scope='request'></jsp:useBean>
<jsp:useBean id='registerBean' class='yatospace.jsp.user.web.bean.RegistrationBean' scope='session'></jsp:useBean>

<form method='POST' name='user_register_update_form'>
	<table>
		<tr>
			<td>Корисничко име: </td>
			<td><input type='text' name='username' id='user_register_upadte_username' required autofocus value='${registerBean.username}'/></td>
		</tr>
		<tr>
			<td>Име: </td>
			<td><input type='text' name='name' id='user_register_update_name' value='${registerBean.name}'/></td>
		</tr>
		<tr>
			<td>Презиме: </td>
			<td><input type='text' name='surname' id='user_register_update_surname' value='${registerBean.surname}'/></td>
		</tr>
	</table>
	<br>
	<input type='submit' name='user_register_update_submit' value='Измјене'/>
	<input type='submit' name='user_register_update_reset' value='ресетовање'/>
	<input type='submit' name='user_register_update_get' value='очитавање'/>
</form>
