<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="com.Echarge.admin.*"%>
<%@ page import="com.Echarge.DBtable.*"%>
<%
	//检查session，查看用户是否登陆
	Admin a = (Admin) session.getAttribute("admin");
	if (a == null) {
		response.sendRedirect("../Admin_Login.jsp");
		return;
	}
%>

<%
	String tableName = request.getParameter("tableName");
	String url = request.getParameter("from");
	DBtable.deleteTable(tableName);
	out.println("删除成功！");
	response.sendRedirect("DB_Backup.jsp");
%>

<html>
	<head>
		<title>删除数据库表</title>
	</head>
	<body>
		<center>		
		</center>
	</body>
</html>
