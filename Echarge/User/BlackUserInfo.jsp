<%@ page language="java" contentType="text/html;charset=gb2312"  pageEncoding="GB18030"%>
<%@ page import="com.Echarge.admin.*" %>
<%@ page import="com.Echarge.User.*" %>
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
	User u = (User) session.getAttribute("User");
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
	<link href="../Admin/styles/general.css" rel="stylesheet" type="text/css" />
	<link href="../Admin/styles/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>
<span class="action-span"></span><span>Echarge 管理中心  - 客户信息</span>
</h1>
<div class="list-div">
<table cellspacing='1' cellpadding='3' border="0">
  <tr>
    <th colspan="4" align="center"  class="tab-front">基本信息</th>
  </tr>
  <tr>
    <td width="20%" align="right" >账号：</td>
    <td width="30%" ><%=u.getClientAccount()%></td>
    <td width="20%" align="right" >姓名：</td>
    <td width="30%" ><%=u.getClientName()%></td>
  </tr>
  <tr>
	<td align="right" >密码：</td>
    <td >*******</td>
    <td align="right" ></td>
    <td ></td>
  </tr>
</table>
<table cellspacing='1' cellpadding='3' border="0">
  <tr>
    <th colspan="4" class="tab-front" align="center">详细信息</th>
  </tr>
  <tr>
    <td width="20%" align="right">性别：</td>
    <td width="30%"><%=u.getClientSex()%></td>
    <td width="20%" align="right">邮箱地址：</td>
    <td width="30%"><%=u.getClientEmail()%></td>
  </tr>
  <tr>
    <td align="right">证件类型：</td>
    <td><%=u.getCardType()%></td>
    <td align="right">证件号码：</td>
    <td><%=u.getCardNum()%></td>
  </tr>
  <tr>
    <td align="right">固定电话：</td>
    <td><%=u.getClientTel()%></td>
    <td align="right">移动电话：</td>
    <td><%=u.getClientPhone()%></td>
  </tr>
  <tr>
    <td align="right">住址：</td>
    <td><%=u.getClientAddress()%></td>
    <td align="right" ></td>
    <td ></td>
  </tr>
</table>
<table cellspacing='1' cellpadding='3' border="0">
  <tr>
    <th colspan="4" align="center"  class="tab-front">账户信息</th>
  </tr>
  <tr>
    <td width="20%" align="right" >余额：</td>
    <td width="30%" ><%=u.getCardBalance()%></td>
    <td width="20%" align="right" >自助操作：<br /></td>
    <td width="30%" >
    	<input type="button" value="锁定解锁" style="width:160px;" onclick="javascript:window.location.href ='UserState.jsp';"/>
    </td>
  </tr>
  <tr>
	<td align="right" >状态：</td>
    <td ><%=u.getClientState()%></td>
    <td align="right" ></td>
    <td ></td>
  </tr>
  <tr>
    <td align="right">注册时间：</td>
    <td ><%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(u.getRDate())%></td>
    <td align="right" ></td>
    <td ></td>
  </tr>
</table>
</div>
<div id="footer"></div>
</body>
</html>