<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="com.Echarge.admin.*"%>
<%@ page import="com.Echarge.Analysis.*"%>

<%
	//检查session，查看用户是否登陆
	Admin a = (Admin) session.getAttribute("admin");
	if (a == null) {
		response.sendRedirect("../Admin_Login.jsp");
		return;
	}
%>

<%
	String equipNo = request.getParameter("equipNo");
//	String url = request.getParameter("from");
	Analysis.delete(equipNo);
	out.println("删除成功！");
	response.sendRedirect("EquipAnalysis.jsp");
%>

<html>
	<head>
		<title>删除使用分析</title>
	</head>
	<body>
		<center>		
		</center>
		<script type="text/javascript">	
			parent.main.location.reload();			
		</script>
	</body>
</html>
