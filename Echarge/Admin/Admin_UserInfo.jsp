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
	Admin b = null;
	try {
		b = Admin.checkName(loginName);
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
<span class="action-span"></span><span>Echarge 管理中心  - 用户信息</span></h1>
<div class="list-div">
<table cellspacing='1' cellpadding='3' border="0">
  <tr>
    <th colspan="4" align="center"   class="tab-front">基本信息</th>
  </tr>
  <tr>
    <td width="20%" align="right"  >用户账号：</td>
    <td width="30%"  ><%=loginName%></td>
    <td width="20%" align="right"  >用户姓名：</td>
    <td width="30%"  ><%=a.getAdminName()%></td>
  </tr>
  <tr>
	<td align="right"  >密码：</td>
    <td  >*******</td>
    <td align="right"  >自主操作：</td>
    <td  >
    	<input type="button" value="修改密码" style="width:160px;" 
    	onclick="javascript:window.location.href ='Admin_ModiPSW.jsp?loginName=<%=b.getLoginName()%>';"/>
    </td>
  </tr>
</table>
<table cellspacing='1' cellpadding='3' border="0">
  <tr>
    <th colspan="4" class="tab-front" align="center">详细信息</th>
  </tr>
  <tr>
    <td width="20%" align="right">用户类型：</td>
    <td width="30%"><%=b.getAdminType()%></td>
    <td width="20%" align="right">邮箱地址：</td>
    <td width="30%"><%=b.getAdminEmail()%></td>
  </tr>
  <tr>
    <td align="right">住址：</td>
    <td><%=b.getAdminAddress()%></td>
    <td align="right">移动电话：</td>
    <td><%=b.getPhoneNum()%></td>
  </tr>
  <tr>
    <td align="right">注册时间：</td>
    <td><%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(b.getAddDate())%></td>
    <td align="right"  >自主操作：</td>
    <td  >
    	<input type="button" value="修改个人信息" style="width:160px;" 
    	onclick="javascript:window.location.href ='Admin_ModiUser.jsp?loginName=<%=b.getLoginName()%>';"/>
    </td>
  </tr>
</table>
</div>
<div id="footer"></div>
</body>
</html>