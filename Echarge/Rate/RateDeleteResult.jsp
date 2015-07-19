<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="com.Echarge.Rate.*"%>


<%
	request.setCharacterEncoding("GBK");
	int rate_ID = Integer.parseInt(request.getParameter("rateID"));
	String url = request.getParameter("url");
	out.println(rate_ID);
	Rate.delete(rate_ID);
	response.sendRedirect("RateList.jsp");
%>

<html>
	<head>
		<title></title>
	</head>
	<body>
		<center>		
		</center>
		<script type="text/javascript">	
			parent.main.location.reload();			
		</script>
	</body>
</html>
