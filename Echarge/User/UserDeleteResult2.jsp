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
	String clientAccount = request.getParameter("clientAccount");
//	String url = request.getParameter("from");
	try {
		User u = User.checkAccount(clientAccount);
	} catch (Exception e) {
		out.println(e.getMessage());
		return;
	}
	User.deleteAccount(clientAccount);
	out.println("删除成功！");
	response.sendRedirect("UserList.jsp");
%>

<html>
	<head>
		<title>删除客户</title>
	</head>
	<body>
		<center>		
		</center>
		<script type="text/javascript">	
			parent.main.location.reload();			
		</script>
	</body>
</html>
