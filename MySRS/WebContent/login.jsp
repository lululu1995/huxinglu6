<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="service.login" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生登录</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
<% String ne="";
String pd="";
Cookie[] cookies=request.getCookies(); 
if(cookies!=null){ 
	for(int i=0;i<cookies.length;i++){ 
		if(cookies[i].getName().equals("username")){ 
			ne=cookies[i].getValue();
			} 
		if(cookies[i].getName().equals("password")){
			pd=cookies[i].getValue();
		}
	} 
	}
%>

<div class="header"></div>
<div class="login">
	 <div class="container">
		 <h2>学生登录</h2>
		 <div class="col-md-6 log">			 
				 <form method="post" action="login">
					 <h5>学生姓名:</h5>	
					 <input type="text" name="username" class="form-control" value="<%=ne%>">
					 <h5>密码:</h5>
					 <input type="password" name="password" class="form-control" value="<%=pd%>">		
					  <input type="checkbox" name="isRemberPwd" value="isRemberPwd"> 记住密码
					  <br>	
					  <br>			
					 <input type="submit" value="Login">
					
					  <a href="#">忘记密码 ?</a>
				 </form>				 
		 </div>
		  
    </div>
    </div>

</body>

</html>