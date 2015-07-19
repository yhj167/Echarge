<%@ page language="java" contentType="text/html;charset=gb2312" import="com.Echarge.admin.*" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
  
<%
Admin a = (Admin)session.getAttribute("admin");
if(a == null) {
	response.sendRedirect("../Admin_Login.jsp");
	return;
}
%> 
  
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate" />
	<meta http-equiv="expires" content="Wed, 26 Feb 1970 08:21:57 GMT" />
	<title>电动汽车充电站智能管理系统</title>
	<frameset rows="76,*" framespacing="0" border="0">
	<frame src="Admin_Top.jsp" id="header-frame" name="header-frame" frameborder="no" scrolling="no" >
		<frameset cols="180, 10, *" framespacing="0" border="0" id="frame-body">
		    <frame src="Admin_Left.jsp" id="menu-frame" name="menu-frame" frameborder="no" scrolling="yes" ></frame>
		    <frame src="Admin_Drag.jsp" id="drag-frame" name="drag-frame" frameborder="no" scrolling="no" ></frame>
		    <frame src="Admin_Main.jsp?loginName=<%=a.getLoginName()%>" id="main-frame" name="main-frame" frameborder="no" scrolling="yes" ></frame>
		</frameset>
	</frame>
	</frameset>
</head>
<body>
</body>
</html>