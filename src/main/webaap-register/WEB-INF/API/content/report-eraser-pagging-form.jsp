<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id='eraserPaggingBean' class='yatospace.jsp.user.web.bean.PaggingBean' scope='session'></jsp:useBean>

<div id='report_page_place'>
	<form id='report_page_form' name='report_page_form' method='POST'>
		<table>
			<tr>
				<td>Величина странице: </td>
				<td><input type='number' value='${eraserPaggingBean.pageSize}' min='1' name='pageSize'/></td>
			</tr>
			<tr>
				<td>Број странице: </td>
				<td><input type='number' value='${eraserPaggingBean.pageNo}' min='0' name='pageNo'/></td>
			</tr>
		</table>
		<br>
		<input type='submit' name='report_page_previous' value='Назад'        />
		<input type='submit' name='report_page_refresh'  value='освјежавање'  />
		<input type='submit' name='report_page_next'     value='напријед'     />
	</form>
</div>
