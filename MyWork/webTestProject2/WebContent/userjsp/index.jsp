<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登录</title>
		<script src="../js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			function submit(){
				var obb=false;
				if($("#username").val()==""||$("#password").val()==""){
					alert("用户名或密码不能为空");
				}else{
					obb=true;
				}
				return obb;
			}
			function reg(){
				window.location.href='register.jsp';
				return false;
			}
		</script>
		<style type="text/css">
			#tgg{
				width: 500px;
				height: 200px;
				border: solid 1px beige;
				background-color: antiquewhite;
				text-align: center;
				margin-top: 16%;
				margin-left: 30%;
				margin-right: 50%;
			}
			#tgg input{
				margin-top: 30px;
			}
			.text{
				width:180px;
				height: 20px;
			}
		</style>
	</head>
	<body>
		<form action="http://127.0.0.1:8080/webTestProject2/login" method="post" accept-charset="UTF-8">
			<div id="tgg">
				账号:<input class="text" type="text" name="username" id="userid" placeholder="6位只能使用数字和字母组合" maxlength="6"/><br />
				密码:<input class="text" type="password" name="password" id="userpwd" /><br />
				<input id="submit" type="submit" value="登录" onclick="return submit()" />&nbsp;&nbsp;&nbsp;&nbsp;<button onclick="return reg()">注册</button>
				<input type="number" name="cmd" value="0" style="display: none;" />
			</div>
		</form>
	</body>
</html>
