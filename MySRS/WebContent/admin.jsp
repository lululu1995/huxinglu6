<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="service.login" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

</head>

<body>

<div class="header"></div>
<div class="login">
	 <div class="container">
		 <ul class="breadcrumb">
            <li><a href="index.jsp">首页</a> <span class="divider">/</span></li>
            <li class="active">教师登录</li>
        </ul>
		 <div class="col-md-6 log">			 
				 <form method="post" action="admin">
					 <h5>管理员名:</h5>	
					 <input type="text" name="adminname" class="form-control" >
					 <h5>密码:</h5>
					 <input type="password" name="password" class="form-control" >		
					
					  <br>	
					  <br>			
					 <input type="submit" value="登录">

				 </form>				 
		 </div>
		 
    </div>
    </div>

</body>

</html>