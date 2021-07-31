<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id='reportPaggingBeanCUS' class='yatospace.jsp.user.web.bean.PaggingBean' scope='session'></jsp:useBean>

<div id='report_page_place_us'>
	<form id='report_page_form_us' name='report_page_form_us' method='POST'>
		<table>
			<tr>
				<td>Величина странице: </td>
				<td><input type='number' value='${reportPaggingBeanCUS.pageSize}' min='1' name='pageSize'/></td>
			</tr>
			<tr>
				<td>Број странице: </td>
				<td><input type='number' value='${reportPaggingBeanCUS.pageNo}' min='0' name='pageNo'/></td>
			</tr>
		</table>
		<br>
		<input type='submit' name='report_page_previous_us' value='Назад'        />
		<input type='submit' name='report_page_refresh_us'  value='освјежавање'  />
		<input type='submit' name='report_page_next_us'     value='напријед'     />
	</form>
</div>