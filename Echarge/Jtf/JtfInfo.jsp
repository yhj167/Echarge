<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="com.Echarge.Jtf.*"%>
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
	Jtf j = (Jtf) session.getAttribute("Jtf");
%>
<html>
	<head>
		<link href="../Admin/styles/main.css" rel="stylesheet" type="text/css" />
		<link href="../Admin/styles/general.css" rel="stylesheet" type="text/css" />
		<title>流水查询</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<meta name="keywords"
			content="Discuz!,Board,Comsenz,forums,bulletin board,">
		<meta name="description" content="Echarge流水查询">
		<meta name="generator" content="Discuz! 4.0.0RC4 with Templates 4.0.0">
		<meta name="MSSmartTagsPreventParsing" content="TRUE">
		<meta http-equiv="MSThemeCompatible" content="Yes">

		<style type="text/css">
<!--
a {
	text-decoration: none;
	color: #000000
}

a:hover {
	text-decoration: underline
}

body {
	scrollbar-base-color: #F3F6FA;
	scrollbar-arrow-color: #4D76B3;
	font-size: 12px;
	background-color: #ffffff
}

table {
	font: 12px Verdana, Tahoma;
	color: #000000
}

input,select,textarea {
	font: 11px Verdana, Tahoma;
	color: #000000;
	font-weight: normal;
	background-color: #F3F6FA
}

select {
	font: 11px Verdana, Tahoma;
	color: #000000;
	font-weight: normal;
	background-color: #F3F6FA
}

.nav {
	font: 12px Verdana, Tahoma;
	color: #000000;
	font-weight: bold
}

.nav a {
	color: #000000
}

.header {
	font: 11px Verdana, Tahoma;
	color: #000000;
	font-weight: bold;
	background-image: url("images/green/bg01.gif")
}

.header a {
	color: #FFFFFF
}

.category {
	font: 11px Verdana, Tahoma;
	color: #000000;
	background-color: #EFEFEF
}

.tableborder {
	background: #80BDCB;
	border: 0px solid #4D76B3
}

.singleborder {
	font-size: 0px;
	line-height: 0px;
	padding: 0px;
	background-color: #F3F6FA
}

.smalltxt {
	font: 11px Verdana, Tahoma
}

.outertxt {
	font: 12px Verdana, Tahoma;
	color: #000000
}

.outertxt a {
	color: #000000
}

.bold {
	font-weight: bold
}

.altbg1 {
	background: #F3F6FA
}

.altbg2 {
	background: #FFFFFF
}
-->
</style>
		<script language="JavaScript" src="../Admin/images/common.js"></script>
		<style type="text/css">
.cPopText {
	font-family: Tahoma, Verdana;
	background-color: #FFFFCC;
	border: 1px #000000 solid;
	font-size: 12px;
	padding-right: 4px;
	padding-left: 4px;
	height: 20px;
	padding-top: 2px;
	padding-bottom: 2px;
	visibility: hidden;
	filter: Alpha(Opacity = 80)
}
</style>
	</head>


	<body leftmargin="0" rightmargin="0" topmargin="0" onkeydown="if(event.keyCode==27) return false;">
		<div id="popLayer" style="position: absolute; z-index: 1000;"
			class="cPopText"></div>

		<table style="table-layout: fixed;" align="center" border="0"
			cellpadding="0" cellspacing="0" width="97%">
			<tbody>
				<tr>
					<td class="nav" align="left" nowrap="nowrap" width="100%">
						<h1>
							<span class="action-span"></span><span>Echarge 管理中心 - 流水查询 </span>
						</h1>
					</td>

				</tr>
			</tbody>
		</table><br>
		<center>查询结果</center><br>
		
		<input name="formhash" value="93a2a31f" type="hidden">
		<table class="tableborder" align="center" cellpadding="4"
			cellspacing="1" width="97%">
			<tbody>
				<tr class="header">
					<td align="center" width="10%">
						操作号
					</td>
					<td align="center" width="9%">
						操作员
					</td>
					<td align="center" width="9%">
						客户账号
					</td>
					<td align="center" width="9%">
						客户姓名
					</td>

					<td align="center" width="9%">
						服务类型
					</td>

					<td align="center" width="9%">
						费用类型
					</td>

					<td align="center" width="9%">
						费用（元）
					</td>
					<td align="center" width="9%">
						当时余额（元）
					</td>
					<td align="center" width="15%">
						操作时间
					</td>
				</tr>

				<tr>
					<td class="altbg2" align="center" nowrap="nowrap">
						<%=j.getID()%>
					</td>

					<td class="altbg1" align="center">
						<%=j.getLoginName()%>
					</td>

					<td class="altbg1" align="center">
						<%=j.getClientAccount()%>
					</td>

					<td class="altbg1" align="center">
						<%=j.getClientName()%>
					</td>

					<td class="altbg1" align="center">
						<%=j.getServFlag()%>
					</td>

					<td class="altbg1" align="center">
						<%=j.getJtfFlag()%>
					</td>

					<td class="altbg1" align="center">
						<%=j.getJtfMoney()%>
					</td>

					<td class="altbg1" align="center">
						<%=j.getThenBalance()%>
					</td>

					<td class="altbg1" align="center">
						<%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(j.getJtfTime())%>
					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>