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

</script>
<title>Insert title here</title>
</head>
<body>

<div class="container">
	<div class="row clearfix">
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-inline" method="post" 
				      action="${pageContext.request.contextPath }/toStudent.action">
				
					
					<div class="form-group">
						<label for="customerName">用户名</label> 
						<input type="text" class="form-control" id="username" 
						                   value="${username}" name="username" />
					</div>
					
					
					<button type="submit" class="btn btn-primary">查询</button>
					
				</form>
				
			</div>
		</div>
	</div>
	
	
	
	
	<div class="container">
	<div class="row clearfix">

	</div>
</div>
	
	<div class="row clearfix">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="col-md-12 column">
				<form action="${pageContext.request.contextPath }/downloadStudent.action" method="post">
					<table class="table  table-hover">
						<thead>
							<tr>
								<th></th>
								<th>id</th>
								<th>用户名</th>
								<th>密码</th>
								<th>操作</th>
								
							</tr>
						</thead>
						<tbody>
						
							<c:forEach var="student" items="${page.rows}" varStatus="status" >
								<tr >
									<td><input type="checkbox" name="studentId" value="${student.id }"></td>
									<td >
										<c:out value="${student.id }"/>
									</td>
									<td>
										<c:out value="${student.username }"/>
									</td>
									<td>
										<c:out value="${student.password }"/>
									</td>
									<td>
										<a href="${pageContext.request.contextPath }/toEditStudent.action?id=${student.id }">修改 </a>
										<a href="${pageContext.request.contextPath }/deleteStudent.action?id=${student.id }">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<input type="submit" value="下载">     <!-- 下载 -->
				</form>
					<div class="col-md-12 text-right">
						<navigationTag:page url="${pageContext.request.contextPath }/toStudent.action" />
					</div>
					
				</div>
			</div>
		</div>
		</div>
		
	</div>
</body>
</html>