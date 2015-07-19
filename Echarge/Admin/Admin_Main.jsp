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
<%
	String loginName = request.getParameter("loginName");
	try {
		a = Admin.checkName(loginName);
	} catch (UserNotFoundException e) {
		out.println(e.getMessage());
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
	<link href="styles/general.css" rel="stylesheet" type="text/css" />
	<link href="styles/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>
<span>Echarge V1.0</span></h1>
<div class="list-div">
<table cellspacing='1' cellpadding='3' width="1079" border="0">
  <tr>
    <th colspan="4"  class="group-title">系统信息</th>
  </tr>
  <tr>
    <td width="20%" align="right" >服务器操作系统：</td>
    <td width="30%" >Windows XP</td>
    <td width="20%" align="right" >服务器：</td>
    <td width="30%" >Apache Tomcat 5.5</td>
  </tr>
  <tr>
    <td width="20%" align="right" >当前用户：</td>
    <td width="30%" ><%=a.getLoginName()%></td>
    <td width="20%" align="right" >登录时间：</td>
    <td width="30%" ><%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(session.getCreationTime())%></td>
  </tr>
</table>
</div>
<div id="footer"></div>
</body>
</html>