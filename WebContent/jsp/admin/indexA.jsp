<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title></title>
<meta name="renderer" content="webkit"> 
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<script src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript">
function loginout(){
	if(confirm("确认退出")){
		window.location.href="<%=basePath%>exit"
	}
	
}

</script>

</head>
<body>
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default" role="navigation" >

				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				  <ul class="nav navbar-nav navbar-left">
							<li>
							<h4>后台管理系统</h4>
							</li>
		          </ul>
					<ul class="nav navbar-nav navbar-right">

	
							<li>
							<a>欢迎管理员${auser.username}！</a>
							</li>
						<li>
							 <a onclick="loginout()">退出</a>
						</li>
			
					</ul>
				</div>
				
			</nav>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-2 column">
				<div class="panel-group" id="panel-108328">
					<div class="panel panel-default">
						<div class="panel-heading">
							 <a class="panel-title" data-toggle="collapse" data-parent="#panel-108328" href="#panel-element-228487">商品管理</a>
						</div>
						<div id="panel-element-228487" class="panel-collapse in">
							<div class="panel-body">
								<ul>
									<li  > <a href="adminGoods/toAddGoods" target="table"><span>添加商品</span></a></li>
									<li  > <a href="adminGoods/selectGoods?act=deleteSelect" target="table"><span>删除商品</span></a></li>
									<li  > <a href="adminGoods/selectGoods?act=updateSelect" target="table"><span>修改商品</span></a></li>
									<li  > <a href="adminGoods/selectGoods" target="table"><span>查询商品</span></a></li>
								 </ul>
							</div>
							
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-108328" href="#panel-element-259345"> 订单管理</a>
						</div>
						<div id="panel-element-259345" class="panel-collapse collapse">
							<div class="panel-body">
								 <ul>
									<li  >  <a href="adminOrder/orderInfo" target="table"><span>删除订单</span></a></li>
								 </ul>
								
							</div>
						</div>
					</div>
					
					<div class="panel panel-default">
						<div class="panel-heading">
							 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-108328" href="#panel-element-259347"> 用户管理</a>
						</div>
						<div id="panel-element-259347" class="panel-collapse collapse">
							<div class="panel-body">
								<ul>
									<li  >  <a href="<%=basePath%>toFileUpload.action" target="table"><span>批量上传</span></a></li>
									<li  > <a href="<%=basePath%>toStudent.action" target="table"><span>用户信息</span></a></li>
								 </ul>
							</div>
						</div>
					</div>
					
					<div class="panel panel-default">
						<div class="panel-heading">
							 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-108328" href="#panel-element-259346">商品类型管理</a>
						</div>
						<div id="panel-element-259346" class="panel-collapse collapse">
							<div class="panel-body">
								<ul>
								<li><a href="adminType/toAddType"target="table"><span>添加类型</span></a></li>
					            <li><a href="adminType/toDeleteType"target="table"><span>删除类型</span></a></li>

								 </ul>
							</div>
						</div>
					</div>
			</div>
		</div>
		<div class="col-md-10 column">
			<iframe  name="table" frameborder="0" width="100%" style="height:750px;">
            </iframe>
		</div>
		
	</div>
</div>

</body>

</html>

