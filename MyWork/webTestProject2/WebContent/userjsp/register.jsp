<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>注册</title>
		<script src="./js/userjsp/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			function r() {
				roo = false;
				if ($v('userid').length == 6 && /^[0-9a-zA-Z]{6}$/.test($v('userid'))) {
					if ($v('userpwd') == $v('reppwd')) {
						
						if($("from:radio").avl()!=undefiend){
							if($("#jg").val()!=""){
								roo = true;
							}
							else{
								alert("请选择籍贯")
							}
						}
						else{
							alert("请选择性别");
						}
					} else {
						alert("前后密码不正确");

					}
				} else {
					alert("账号不正确");
				}
				return roo;
			};

			function $v(id) {
				return document.getElementById(id).value;
			}
		</script>
		<style type="text/css">
			fieldset {
				width: 700px;
				height: 600px;
				margin-left: 25%;
				
			}
			.d{
				text-align: left;
				padding-left: 30%;
				font-size: 18px;
			}
			.c_p{
				font-size: 38px;
				text-align: center;
				margin-top: 12px;
				height: 20px;
			}
			.d input,select,textarea,button{
				margin-top: 20px;
			}
			.d select{
				width: 80px;
				height:26px ;
			}
			.d button{
				margin-left: 110px;
				width: 80px;
				height: 30px;
			}
			.c_text{
				width:180px;
				height: 20px;
			}
			.area{
				width:180px;
			}
		</style>
	</head>
	<body>
		<form action="../register" method="post" accept-charset="UTF-8">
			<p class="c_p">注册</p>
			<fieldset>
				<legend>注册信息</legend>
				<div class="d">
					账号：<input class="c_text" type="text" name="username" id="userid" maxlength="6" placeholder="6位只能使用数字和字母组合" /><br />
					密码：<input class="c_text" type="password" name="password" id="userpwd" /><br />
					确认：<input class="c_text" type="password" name="repwd" id="reppwd" /><br />
					性别：<input type="radio" name="sex" checked="checked" value="男" />男<input type="radio" name="sex" value="女" />女<br />
					籍贯：
					<select id="jg" name="jg">
						<option value="">请选择</option>
						<option value="吉林省">吉林省</option>
						<option value="辽宁省">辽宁省</option>
						<option value="山东省">山东省</option>
					</select><br />
					爱好：<input type="checkbox" value="篮球" name="love" />篮球<input type="checkbox" value="足球" name="love" />足球<input type="checkbox"
					 value="排球" name="love" />排球<br />

					简介：<textarea class="area" name="jianjie" rows="10"></textarea><br />
					<input type="number" name="cmd" value="1" style="display: none;" />
					<button id="btn" onclick="return r()">注册</button>
				</div>
			</fieldset>
		</form>
	</body>
</html>
