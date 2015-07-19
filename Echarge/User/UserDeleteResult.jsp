<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="com.Echarge.admin.*"%>
<%@ page import="com.Echarge.User.*"%>

<%
	//检查session，查看用户是否登陆
	Admin a = (Admin) session.getAttribute("admin");
	if (a == null) {
		response.sendRedirect("../Admin_Login.jsp");
		return;
	}
%>

<%
int ID = Integer.parseInt(request.getParameter("ID"));
String url = request.getParameter("from");
User.delete(ID);
	response.sendRedirect("UserList.jsp");
%>

<html>
	<head>
		<title>删除客户</title>
	</head>
	<body>
		<center>
			删除成功!			
		</center>
		<script type="text/javascript">	
			parent.main.location.reload();			
		</script>
	</body>
</html>
