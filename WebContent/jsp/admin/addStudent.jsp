<%@ page language="java"  import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="navigationTag" uri="http://navigationTag.com/common/"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<script src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script >
function updateCourse(){
    // 获取输入的用户名和密码
	var id = $("#id").val();
	var name = $("#name").val();
	var hour = $("#hour").val();
	$.ajax({
		url : "${pageContext.request.contextPath }/editCourse.action",
		type : "post", 
		// data表示发送的数据
		data :JSON.stringify({id:id,name:name,hour:hour}),
		// 定义发送请求的数据格式为JSON字符串
		contentType : "application/json;charset=UTF-8",
		//定义回调响应的数据格式为JSON字符串,该属性可以省略
		dataType : "json",
		//成功响应的结果
		success : function(data){
			if(data){
				alert("添加成功")
				 window.location.href="${pageContext.request.contextPath }/toCourse.action"
			}
			 
			}
		})
	};
</script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	
	
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="panel  panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">
						添加界面
					</h3>
				</div>
				<div class="panel-body">
						<div class="col-md-12 column">
							<form class="form-horizontal" role="form"  method="post">
								<div class="form-group">
									 <label for="inputEmail3" class="col-sm-2 control-label">id</label>
									<div class="col-sm-10">
										<input type="text" class="form-control " id="id" name="id" />
									</div>
								</div>
								
								<div class="form-group">
									 <label for="inputEmail3" class="col-sm-2 control-label">课程名称</label>
									<div class="col-sm-10">
										<input type="text" class="form-control " id="name" name="name" />
									</div>
								</div>
								<div class="form-group">
									 <label for="inputPassword3" class="col-sm-2 control-label">课时</label>
									<div class="col-sm-10">
										<input type="text" class="form-control password" id="hour" name="hour"  />
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										 <button onclick="updateCourse()" class="btn btn-default">添加</button>
									</div>
								</div>
							</form>
						</div>
				</div>
				<div class="panel-footer">
					editCourse
				</div>
			</div>
		</div>
	</div>
		<div class="row clearfix">
	
		</div>
	</div>
</body>
</html>