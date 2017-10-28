<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>請求書更新</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8");  %>
	<h1>更新</h1>
	<form method="POST" action="EditAction">
		<input type="hidden" name ="token" value="">
		請求書ID: <input type="text" readonly="readonly" name="invoiceId" value="<c:out value="${invoice.invoiceId}" />"/>
		<br />
		タイトル: <input type="text" name="title" value="<c:out value="${invoice.title}" />" />
		<br />
		詳細: <input type="text" name="detail" value="<c:out value="${invoice.detail}" />" />
		<br />
		請求金額: <input type="text" name="totalfee" value="<c:out value="${invoice.totalFee}" />" />
		<br />
		<input type="submit" value="更新" />
	</form>
	<a href="ListAction">一覧へ戻る</a>
</body>
</html>