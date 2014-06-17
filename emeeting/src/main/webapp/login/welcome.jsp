<%@ page language="java"  pageEncoding="utf-8"%>
<%@taglib prefix ="s" uri ="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>成勘院会议管理系统1.0</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<!--[if IE]> <link href="css/iestyle.css" rel="stylesheet" type="text/css" /> <![endif]-->
<script type="text/javascript" language="javascript">
function init(){
		document.getElementById("userName").focus();
}
document.onkeydown = function(event) {
	e = event ? event : (window.event ? window.event : null);
	if (e.keyCode == 13) {
		//执行的方法  
		login();
	}
};
</script>

</head>

<body onload="init()">
<div class="login">
	<div class="loginbox">
		<form action="userLogin!login.action" id="loginform" name="loginform" method="post">
			<div class="entername">
				<label>用户名：</label>
				<input type="text" id="userName" name="userName"/>
			</div>
			<div class="enterpassword">
				<label>密　码：</label>
				<input type="password" id="password" name="password"/>
			</div>
			<div class="entercheck"><FONT color="red"><s:fielderror   fieldName="failed" /></FONT></div>
			<div class="enter">
				<a class="entergo" href="#" onclick="login()">登 录</a>
				<a class="reset" href="javascript:void(0)" onclick="reset()">重 置</a>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript">


	function login(){
		var username = document.getElementById("userName").value;
		var password = document.getElementById("password").value;
		if(username.length < 1){
			alert("请填写用户名");
			document.getElementById("userName").focus();
			return;
		}
		
		if(password.length < 1){
			alert("请填写密码");
			document.getElementById("userName").focus();
			return;
		}
		document.loginform.submit();
	}
	
	function reset(){
		document.getElementById("userName").value = "";
		document.getElementById("password").value = "";
		document.getElementById("userName").focus();
	}
</script>
</body>

</html>
