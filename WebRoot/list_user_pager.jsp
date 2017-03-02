<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<%
	// 获取请求的上下文
	String context = request.getContextPath();
%>
<script type="text/javascript">
// 当前第几页数据
var currentPage = ${currentPage};

// 总页数
var totalPage = ${totalPage};

function submitForm(actionUrl){
	window.location.href = actionUrl;
}

// 第一页
function firstPage(){
	if(currentPage == 1){
		alert("已经是第一页数据");
		return false;
	}else{
		submitForm("<%=context%>/pagerservlet.servlet?pageNum=1");
		return true;
	}
}

// 下一页
function nextPage(){
	if(currentPage == totalPage){
		alert("已经是最后一页数据");
		return false;
	}else{
		submitForm("<%=context%>/pagerservlet.servlet?pageNum=" + (currentPage+1));
		return true;
	}
}

// 上一页
function previousPage(){
	if(currentPage == 1){
		alert("已经是第一页数据");
		return false;
	}else{
		submitForm("<%=context%>/pagerservlet.servlet?pageNum=" + (currentPage-1));
		return true;
	}
}

// 尾页
function lastPage(){
	if(currentPage == totalPage){
		alert("已经是最后一页数据");
		return false;
	}else{
		submitForm("<%=context%>/pagerservlet.servlet?pageNum=${totalPage}");
			return true;
		}
	}
</script>
</head>
<body>
	<table width="100%" border="0" bgcolor="#cccccc">
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
	<br>共${totalPage }页&nbsp;&nbsp;当前第${currentPage }页&nbsp;&nbsp;
	<a href="#" onclick="firstPage();">首页</a>
	<a href="#" onclick="previousPage();">上一页</a>
	<a href="#" onclick="nextPage();">下一页</a>
	<a href="#" onclick="lastPage();">尾页</a>

</body>
</html>