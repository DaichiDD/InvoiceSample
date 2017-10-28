<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>請求書更新</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8");  %>
	<h1>更新</h1>
	<div>
		<table border=1>
			<tr>
				<th>請求書ID</th>
				<td><c:out value="${invoices.invoiceId}" /></td>
			</tr>
			<tr>
			<th>タイトル</th>
				<td><c:out value="${invoices.title}" /></td>
			</tr>
			<tr>
				<th>詳細</th>
				<td><c:out value="${invoices.detail}" /></td>
			</tr>
			<tr>
				<th>請求金額</th>
				<td><c:out value="${invoices.totalFee}" /></td>
			</tr>
			<tr>
				<th>更新日時</th>
				<td><fmt:formatDate pattern="yyyy-MMM-dd" value="${invoices.update_date}" /></td>
			</tr>
	</table>
	</div>
</body>
</html>