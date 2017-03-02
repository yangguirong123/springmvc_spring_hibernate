<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>

	<h3>权限管理 &gt; 角色管理 &gt; 浏览角色</h3>
	<p>
		[<a href="role.jspa">添加角色</a>]
	</p>
	<table width="100%%" border="0" cellpadding="2" cellspacing="2"
		bgcolor="#cccccc">
		<tr>
			<td width="17%"><div align="center">角色</div></td>
			<td width="45%"><div align="center">描述</div></td>
			<td><div align="center">操作</div></td>
		</tr>
		<%
			String color = "";
			int c = 1;
		%>
		<c:forEach items="${rolesList}" var="x">
			<%
				if (c == 1) {
						color = "#ffffff";
						c = 0;
					} else {
						color = "#f5f5f5";
						c = 1;
					}
			%>

			<tr>
				<td bgcolor="<%=color %>"><div align="center">${x.name}</div></td>
				<td bgcolor="<%=color %>" style="word-break: break-all;"><div
						align="center">${x.description}</div></td>
				<td bgcolor="<%=color %>"><div align="center">
						[<a
							href="javascript:void _delete('deleteroles.jspa?id=${x.rId}','角色')">删除</a>]
						[<a href="modifyrole.jspa?id=${x.rId}">修改</a>] [<a
							href="listfunction.jspa?roleId=${x.rId}">角色功能管理</a>]
					</div>
			
			</tr>
		</c:forEach>
	</table>



</body>
</html>