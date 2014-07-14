<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript" src="<c:url value='/resource/js/jquery-1.8.2.min.js'/>" charset="utf-8"></script>

<title>用户登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="login">
<meta http-equiv="description" content="login">
<script type="text/javascript">
	
</script>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	font-size: 12px;
	background: url(<%=path %>/resource/style/images/index/bg.jpg) top repeat-x;
}

.input {
	width: 150px;
	height: 17px;
	border-top: 1px solid #404040;
	border-left: 1px solid #404040;
	border-right: 1px solid #D4D0C8;
	border-bottom: 1px solid #D4D0C8;
}
</style>
		<script type="text/javascript">      
        	$(function(){           
	            $('#kaptchaImage').click(function () {//生成验证码  
	             $(this).hide().attr('src', '<%=path %>/login/captcha-image.do?' + Math.floor(Math.random()*100) ).fadeIn(); })      
	        });   
        
       </script>   
</head>

<body>
	<form id="loginForm" action="login.do"
		method="post">
		<table width="750" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tbody>
				<tr>
					<td height="200">&nbsp;</td>
				</tr>
				<tr>
					<td><table width="100%" border="0" cellspacing="0"
							cellpadding="0">
							<tbody>
								<tr>
									<td width="423" height="280" valign="top"><table
											width="100%" border="0" cellspacing="0" cellpadding="0">
											<tbody>
												<tr>
													<td><img src="<%=path %>/resource/style/images/index/ltop.jpg">
													</td>
												</tr>
												<tr>
													<td><img src="<%=path %>/resource/style/images/index/llogo.jpg">
													</td>
												</tr>
											</tbody>
										</table>
									</td>
									<td width="40" align="center" valign="bottom"><img
										src="<%=path %>/resource/style/images/index/line.jpg" width="23" height="232">
									</td>
									<td valign="top"><table width="100%" border="0"
											cellspacing="0" cellpadding="0">
											<tbody>
												<tr>
													<td height="90" align="center" valign="bottom"><img
														src="<%=path %>/resource/style/images/index/ltitle.jpg">
													</td>
												</tr>
												<tr>
													<td>
														<div></div>
														<table width="100%" border="0" align="center"
															cellpadding="0" cellspacing="5">
															<tbody>
																<tr>
																	<td colspan="2" align="center">${msg}</td>
																</tr>
																<tr>
																	<td width="91" height="40" align="right"><strong>
																			用户名：</strong>
																	</td>
																	<td width="211"><input type="text" id="username"
																		name="cname" class="input">
																	</td>
																</tr>
																<tr>
																	<td height="40" align="right"><strong>密码：</strong>
																	</td>
																	<td><input name="cpwd" type="password"
																		id="password" class="input">
																	</td>
																</tr>
																<tr>
																	<td height="40" align="right"><strong>验证码：</strong>
																	</td>
																	<td><input name="securityCode" type="text"
																		id="securityCode" class="input">
																	</td>
																</tr>
																<tr>
																	<td height="40" align="center" colspan="2">
																	<img src="<%=path %>/login/captcha-image.do" id="kaptchaImage"/>
																	</td>
																</tr>
																<tr>
																	<td height="40" colspan="2" align="center"><input
																		type="image" src="<%=path %>/resource/style/images/index/login.jpg">
																		&nbsp; &nbsp; <img name="reg" style="cursor: pointer"
																		src="<%=path %>/resource/style/images/index/reset.jpg"
																		onclick="document.forms[0].reset()"></td>
																</tr>
															</tbody>
														</table>
													</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
