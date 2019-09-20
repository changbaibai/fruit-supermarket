<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
    <form action="${pageContext.request.contextPath }/studentFileUpload.action"
    method="post" enctype="multipart/form-data" >
	请选择文件：<input id="file" type="file" name="uploadfile" 
                                                   multiple="multiple" /><br />
		       <input type="submit" value="上传" />
	</form>
</body>
</html>
