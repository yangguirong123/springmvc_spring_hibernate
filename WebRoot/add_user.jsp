<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add_user</title>
</head>
<body>
	<form action="user/add.do" method="post">
		用户名:<input type="text" name="name"/>
		编号:<input type="text" name="number"/>
		<input type="submit" value="提交">
	</form>
</body>
</html>