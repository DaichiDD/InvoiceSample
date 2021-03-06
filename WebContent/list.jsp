<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>請求書一覧</title>
</head>
<body>
	<h1>請求書アプリ</h1>
	<div>
		<a href="ListAction">一覧</a>
		<a href="NewAction">請求書追加</a>
	</div>
	<table border=1>
		<thead>
			<tr>
				<th>請求書ID</th>
				<th>タイトル</th>
				<th>詳細</th>
				<th>更新日時</th>
				<th>請求金額</th>
				<th colspan=3></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${invoices}" var="invoice">
				<tr>
					<td><c:out value="${invoices.invoiceId}" /></td>
					<td><c:out value="${invoices.title}" /></td>
					<td><c:out value="${invoices.detail}" /></td>
					<td><fmt:formatDate pattern="yyyy-MMM-dd" value="${invoices.update_date}" /></td>
					<td><c:out value="${invoices.totalFee}" /></td>
					<td><a href="DetailAction?invoiceId=<c:out value="${invoice.incoiceId}"/>">詳細</a></td>
					<td><a href="EditAction?invoiceId=<c:out value="${invoice.incoideId}" />">更新</a></td>
					<td><a href="#">削除</a>td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>