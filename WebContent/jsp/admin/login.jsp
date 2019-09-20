<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="js/tools.js"></script>


</head>
<body>
<div class="header">
	<img class="logo" src="images/before/logo.png" width="40px" height="40px;" style="padding: 10px;">
</div>
<div class="container">
	<div class="container_middle">
		<div class="container_right">
			<h3 class="title">管理员登录</h3>
				${msg }
			<div class="login_form">
				<form action="admin/login" method="post">
					<p id="message" style='color:red'></p>
					<div class="user-name">
						<input name="username" id="user" placeholder="邮箱/手机/用户名" type="text">
                 	</div>
                 	<div class="user-pass">
						<label for="password"></label>
						<input name="password" id="password" placeholder="请输入密码" type="password">
                 	</div>
					<span class="span1"><input type="checkbox">记住密码</span>
					<span class="span2" style='cursor: pointer'>忘记密码</span>
							<div class="col-sm-offset-2 col-sm-10">
								<input type="submit" width="100" value="登录" name="submit"
									style="background:red; height: 35px; width: 100%; color: black;">
							</div>
	
	
	
	        </form>
		    
			</div>
			
		</div>
	</div>
</div>
<div class="footer">
	<div class="footer_top">
	</div>

</div>
</body>
</html>

