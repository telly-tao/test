<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>主页</title>
<style type="text/css">
fieldset {
	width: 700px;
	height: auto;
	margin-left: 25%;
}

.d {
	text-align: left;
	font-size: 18px;
}

.data_table {
	width: 700px;
	height: 400px;
	border: solid 1px black;
}

.data_table td, th {
	height: 10px;
	border: solid 1px black;
	text-align: center;
}
</style>
</head>
<body>
	<fieldset>
		<form action="http://127.0.0.1:8080/webTestProject2/search"
			method="get" id="form1">
			按姓名查询：<input type="text" name="username" id="username" value="${searchname }"></input> <input type="submit" onclick="submit()"></input>
		</form>
		<legend>注册信息</legend>
		<div class="d">
			<table class="data_table">
				<tr>
					<th>账号</th>
					<th>密码</th>
					<th>性别</th>
					<th>籍贯</th>
					<th>爱好</th>
					<th>简介</th>
				</tr>
				<c:forEach items="${userlist}" var="item">
					<tr>
						<td>${item.username}</td>
						<td>${item.password}</td>
						<td>${item.sex}</td>
						<td>${item.jg}</td>
						<td>${item.love}</td>
						<td>${item.jianjie}</td>
					</tr>
				</c:forEach>
			</table>
			<div>
			
			<table>
				<tr>
					<td>总共${count}页</td>
					<td>当前第${page}页</td>
					<c:if test="${page==1 }">
					<td>上一页</td>
					<td><a href="search?page=${page+1 }&username=${searchname }">下一页</a></td>
					</c:if>
					<c:if test="${page==count}">
					<td><a href="search?page=${page-1 }&username=${searchname }">上一页</a></td>
					<td>下一页</td>
					</c:if>
					<c:if test="${page!=1&&page!=count}">
					<td><a href="search?page=${page-1 }&username=${searchname }">上一页</a></td>
					<td><a href="search?page=${page+1 }&username=${searchname }">下一页</a></td>
					</c:if>
					</tr>
			</table>
		

			</div>
		</div>
	</fieldset>

	主页正在建设中...
</body>
</html>
