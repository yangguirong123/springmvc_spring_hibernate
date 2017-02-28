<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<table width="100%" border="0" 
		bgcolor="#cccccc">
		<tr>
			<td>ID</td>
			<td>用户名</td>
			<td>编号</td>
			<td colspan="2">操作</td>
		</tr>
		
		<%
			String color = "";
			int c = 1;
		%>
		<c:forEach items="${userLists}" var="user">
		    <%
			    if (c == 1) {
					color = "#ffffff";
					c = 0;
				} else {
					color = "#f5f5f5";
					c = 1;
				}
		    %>
			<tr bgcolor="<%=color%>">
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.number}</td>
				<td><a href="../user/delete.do?id=${user.id}">删除</a></td>
				<td><a href="../user/update.do?name=${user.name}">修改</a></td>
			</tr>
			
		</c:forEach>
	</table>
	<br>
	${url}

</body>
</html>