<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选课系统</title>
<link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
<ul class="breadcrumb">
            <li><a href="index.html">首页</a> <span class="divider">/</span></li>
            <li class="active">全部课程</li>
        </ul>
         
       <table class="table table-bordered table-hover">
                <tr>
                    <td>课程编号</td>
	                <td>课程名称</td>
	                <td>任课教师</td>
	                <td>处理</td>
                </tr>
	            <tr>
                	<td>001</td>
                	<td>计算机网络</td>
                	<td>杨某</td>	
                	<td><a href="DeleteCourse?ID=${p.Courid}">删除</a>
                </tr>
                <tr>
                	<td>002</td>
                	<td>JAVA应用</td>
                	<td>孟某某</td>	
                	<td><a href="DeleteCourse?ID=${p.Courid}">删除</a>
                </tr>
                <tr>
                	<td>003</td>
                	<td>企业管理</td>
                	<td>张某</td>	
                	<td><a href="DeleteCourse?ID=${p.Courid}">删除</a>
                </tr>
        </table>
</body>
</html>