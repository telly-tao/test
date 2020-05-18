<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

			table {
				width: 700px;
				height: 400px;
				border: solid 1px black;
			}

			.d table td,
			th {
				height: 10px;
				border: solid 1px black;
				text-align: center;
			}
		</style>
	</head>
	<body>
		<form>
			<fieldset>
				<legend>注册信息</legend>
				<div class="d">
					<table>
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
							<th>${item.jianjie}</th>
						</tr>
						</c:forEach>
					</table>
				</div>
			</fieldset>
		</form>
		主页正在建设中...
	</body>
</html>
