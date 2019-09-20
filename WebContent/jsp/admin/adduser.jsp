<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<link href="css/before/daohang.css" rel="stylesheet" type="text/css" />
<link href="css/before/common.css" rel="stylesheet" type="text/css" />
<link href="css/before/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
    function formCheck(){
       var pwd1 = document.getElementById("pwd1").value;
       var pwd2 = document.getElementById("pwd2").value;
       if(pwd1!=pwd2){
       alert("两次输入的密码不一致！");
       return false;
       }
       return true;
    }
    </script>

</head>
<body>

<form method="post" action="adminUser/adduser" onsubmit= "return formCheck() ">
        <input type="text" required="required" placeholder="username" name="username"></input>  
        <input type="password" id="pwd1" required="required" placeholder="password" name="password"></input>
        <input type="password" id="pwd2" required="required" placeholder="confirm password" name="passwordconfirm"></input>  
        <button class="but" type="submit">添加</button>
</form>

</body>
</html>
