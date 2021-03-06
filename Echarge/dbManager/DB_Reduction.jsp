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
	List<DBtable> DBtables = new ArrayList<DBtable>();
	int totalRecords = DBtable.getDBtables(DBtables);
%>
<html>
	<head>
	<link href="../Admin/styles/main.css" rel="stylesheet" type="text/css" />
	<link href="../Admin/styles/general.css" rel="stylesheet" type="text/css" />	
	<title>数据库恢复</title>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<meta name="keywords" content="Discuz!,Board,Comsenz,forums,bulletin board,">
		<meta name="description" content="Echarge数据库恢复"/>
		<meta name="generator" content="Discuz! 4.0.0RC4 with Templates 4.0.0"/>
		<meta name="MSSmartTagsPreventParsing" content="TRUE"/>
		<meta http-equiv="MSThemeCompatible" content="Yes">	
		
		<style type="text/css"><!--
a			{ text-decoration: none; color: #000000 }
a:hover			{ text-decoration: underline }
body			{ scrollbar-base-color: #F3F6FA; scrollbar-arrow-color: #4D76B3; font-size: 12px; background-color: #ffffff }
table			{ font: 12px Verdana,Tahoma; color: #000000 }
input,select,textarea	{ font: 11px Verdana,Tahoma; color: #000000; font-weight: normal; background-color: #F3F6FA }
select			{ font: 11px Verdana,Tahoma; color: #000000; font-weight: normal; background-color: #F3F6FA }
.nav			{ font: 12px Verdana,Tahoma; color: #000000; font-weight: bold }
.nav a			{ color: #000000 }
.header			{ font: 11px Verdana,Tahoma; color: #000000; font-weight: bold; background-image: url("images/green/bg01.gif") }
.header a		{ color: #FFFFFF }
.category		{ font: 11px Verdana,Tahoma; color: #000000; background-color: #EFEFEF }
.tableborder		{ background: #80BDCB; border: 0px solid #4D76B3 } 
.singleborder		{ font-size: 0px; line-height: 0px; padding: 0px; background-color: #F3F6FA }
.smalltxt		{ font: 11px Verdana,Tahoma }
.outertxt		{ font: 12px Verdana,Tahoma; color: #000000 }
.outertxt a		{ color: #000000 }
.bold			{ font-weight: bold }
.altbg1			{ background: #F3F6FA }
.altbg2			{ background: #FFFFFF }
--></style>
<script language="JavaScript" src="../Admin/images/common.js"></script>
<style type="text/css">.cPopText { font-family: Tahoma, Verdana; background-color: #FFFFCC; border: 1px #000000 solid; font-size: 12px; padding-right: 4px; padding-left: 4px; height: 20px; padding-top: 2px; padding-bottom: 2px; visibility: hidden; filter: Alpha(Opacity=80)}</style>

		<script type="text/javascript">
			function checkDelete() {
				var ids = document.getElementsByName("id");
				if(document.form1.selectAll.checked) {
					for(var i=0; i<ids.length; i++) {
						ids[i].checked="checked";
					}
				} else {
					for(var i=0; i<ids.length; i++) {
						ids[i].checked="";
					}
				}
			}
		</script>
</head>
	<body leftmargin="0" rightmargin="0" topmargin="0" onkeydown="if(event.keyCode==27) return false;">
		<div id="popLayer" style="position: absolute; z-index: 1000;" class="cPopText"></div>
		<table style="table-layout: fixed;" align="center" border="0"
			cellpadding="0" cellspacing="0" width="97%">
			<tbody>
				<tr>
					<td class="nav" align="left" nowrap="nowrap" width="100%">
						<h1>
							<span class="action-span"></span><span>Echarge 管理中心 - 数据库恢复</span>
						</h1>
					</td>
				</tr>
			</tbody>
		</table>
		<br>
		<form name="form1" method="post" action="ReductionResult.jsp" id="f">
			<input type="hidden" name="action" value="DB_Reduction" />

			<table align="center" border="0" cellpadding="0" cellspacing="0" width="97%">
				<tbody>
					<tr>
						<td>
							<table border="0" cellpadding="0" cellspacing="0" align="right">
								<tbody>
									<tr>
										<td height="3"></td>
									</tr>
									<tr>
										<td class="altbg1" align="right" nowrap="nowrap">
											<input name="path" type="file" class="text_input" value="浏览..."/>
											<input type="submit" value="开始导入" onclick="return confirm('开始导入?')" style="width: 80px;"/>
										</td>
									</tr>
									<tr>
										<td height="3"></td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
				</tbody>
			</table>
			<table class="tableborder" align="center" cellpadding="4" cellspacing="1" width="97%">
				<tbody>
					<tr class="header">
						<td align="center" width="15%">
							编号
						</td>
						<td align="center" width="45%">
							数据库中的表
						</td>
						<td align="center" width="40%">
							备注
						</td>
					</tr>
					<%
						for (int i = 0; i < DBtables.size(); i++) {
							DBtable t = DBtables.get(i);
					%>
					<tr>
						<td class="altbg2" align="center" nowrap="nowrap">
							<%=t.getTableID()%>
						</td>
						<td class="altbg1" align="center">
							<%=t.getTableName()%>
						</td>
						<td class="altbg1" align="center">
							<%
								String Msg =  t.getTableMsg();
								//Msg =  new String(Msg.getBytes("iso-8859-1"),"gbk");
							%>
							<%=Msg%>
						</td>
						<!-- 
						<td class="altbg1" align="center">
						</td>
						<td class="altbg1" align="center" width="10%">
							<% String url = request.getRequestURL() + (request.getQueryString() == null ? "" : "?" + request.getQueryString()); %>
							<a href="DBtableDelete.jsp?tableName=<%=t.getTableName()%>&from=<%=url%>" onclick="return confirm('真的要删除?')">删除</a>
						</td> -->
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</form>
	</body>
</html>