<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="com.Echarge.admin.*"%>

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
	//String url = request.getParameter("from");
	try {
		a = Admin.checkName(loginName);
	} catch (UserNotFoundException e) {
		out.println(e.getMessage());
		return;
	}
	Admin.deleteLoginName(loginName);
	out.println("删除成功！");
	response.sendRedirect("Admin_UserList.jsp");
%>

<html>
	<head>
		<title>删除用户</title>
	</head>
	<body>
		<center>		
		</center>
	</body>
</html>
