<%@ page language="java" contentType="text/html;charset=gb2312" %>
<%@ page import="com.Echarge.admin.*" %>
<%@ page import="java.util.*"%>
<%
	//检查session，查看用户是否登陆
	Admin a = (Admin) session.getAttribute("admin");
	if (a == null) {
		response.sendRedirect("../Admin_Login.jsp");
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate" />
	<meta http-equiv="expires" content="Wed, 26 Feb 1970 08:21:57 GMT" />
	<title>电动汽车智能充电系统</title>
	<link href="Admin/styles/general.css" rel="stylesheet" type="text/css" />
	<link href="Admin/styles/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<center><h1>HELP</h1></center>
</body>
</html>