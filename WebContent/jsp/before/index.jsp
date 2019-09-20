<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="head.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<link href="css/before/daohang.css" rel="stylesheet" type="text/css" />
<link href="css/before/common.css" rel="stylesheet" type="text/css" />
<link href="css/before/style.css" rel="stylesheet" type="text/css" />
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <script> 
$(function(){
                $('#myCarousel').carousel({interval:2000});
            })
 </script> 
 <title>首页</title>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
		<div id="myCarousel" class="carousel slide">
                   <ol class="carousel-indicators">
                    <li data-target = '#myCarousel' data-slide-to = "0" class="active"></li>
                    <li data-target = '#myCarousel' data-slide-to = "1"></li>
                    <li data-target = '#myCarousel' data-slide-to = "2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="images/before/main.jpg" alt="first slide" />
                    </div>
                    <div class="item">
                        <img src="images/before/main.jpg" alt="second slide" />
                    </div>
                    <div class="item">
                        <img src="images/before/main.jpg" alt="third slide" />
                    </div>
                </div>
              </div>  
			<div class="row clearfix">
				<div class="col-md-12 column">
			 <!--最新商品列表-->
				<div class="blank5"></div>
				<div class="box">
					<div class="box_color ared">
						<div class="title_bt">
							<span><a href="#">更多</a></span>
							<h3>最新商品</h3>
						</div>
						<div class="itemgood_nr clearfix">
							<ul>
								<c:forEach items="${lastedlist }" var="sg">
									<li>
										<div>
											<p class="pic">
												<a href="goodsDetail?id=${sg.id }">
												
												<img src="logos/${sg.gpicture}" /></a>
											</p>
											<p class="wz">
												<strong><a href="goodsDetail?id=${sg.id }">${sg.gname }</a></strong>
												<em>现价:<span>￥${sg.grprice}</span></em>
											</p>
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				<!--最新商品列表end-->
				
				
			    </div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
