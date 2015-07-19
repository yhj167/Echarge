<%@ page language="java" import="java.util.*" contentType="text/html;charset=gbk" pageEncoding="GB18030"%>
<%@ page import="com.Echarge.admin.*"%>
<%@ page import="com.Echarge.Authority.*"%>
<%@ page import="com.Echarge.Role.*"%>
<%
	//检查session，查看用户是否登陆
	Admin a = (Admin) session.getAttribute("admin");
	if (a == null) {
		response.sendRedirect("../Admin_Login.jsp");
		return;
	}
%>
<%
	Authority au = (Authority) session.getAttribute("Authority");
%>
<%
	final int PAGE_SIZE = 30; //每页显示多少条记录
	final int PAGES_PER_TIME = 30;//每次显示多少个页码链接
	int pageNo = 1;
	String strPageNo = request.getParameter("pageNo");
	if (strPageNo != null && !strPageNo.trim().equals("")) {
		try {
			pageNo = Integer.parseInt(strPageNo);
		} catch (NumberFormatException e) {
			pageNo = 1;
		}
	}
	if (pageNo <= 0)
		pageNo = 1;
%>
<%
	request.setCharacterEncoding("GBK");
	String roleName = "殷华杰";
	if (request.getParameter("roleName") != null) {
		roleName = request.getParameter("roleName");
		roleName = new String(roleName.getBytes("ISO-8859-1"), "gb2312");
	}

	List<Authority> authoritys = new ArrayList<Authority>();
	int totalRecords = Authority.getAuthoritys(authoritys, pageNo,
			PAGE_SIZE, roleName);
	int totalPages = (totalRecords + PAGE_SIZE - 1) / PAGE_SIZE;
	int j = 0;

	if (pageNo > totalPages)
		pageNo = totalPages;
%>


<html>
	<head>
	<link href="styles/main.css" rel="stylesheet" type="text/css" />
	<link href="styles/general.css" rel="stylesheet" type="text/css" />	
	<title>设置权限</title>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<meta name="keywords"
			content="Discuz!,Board,Comsenz,forums,bulletin board,">
		<meta name="description" content="Echarge设置权限">
		<meta name="generator" content="Discuz! 4.0.0RC4 with Templates 4.0.0">
		<meta name="MSSmartTagsPreventParsing" content="TRUE">
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
		<script language="JavaScript" src="images/common.js"></script>
		<style type="text/css">.cPopText { font-family: Tahoma, Verdana; background-color: #FFFFCC; border: 1px #000000 solid; font-size: 12px; padding-right: 4px; padding-left: 4px; height: 20px; padding-top: 2px; padding-bottom: 2px; visibility: hidden; filter: Alpha(Opacity=80)}</style>
		
		
		<script type="text/javascript">
			function checkDelete() {
				var ids = document.getElementsByName("authorityId");
				if(document.formDelete.selectAll.checked) {
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
		<script type="text/javascript">
			function checkMyBox() {
				var box = document.getElementsByName("menuFlag");
				for (var i = 0; i < box.length; i++) {
					if (box[i].checked) {
					}
					else {
					}
				}
			}
		</script>						
		<script type="text/javascript">
			var req;
			var gID;
			function changeToInput(id) {
				var oNP = document.getElementById(id);
				var value = oNP.value;
				oNP.outerHTML = "<input type='text' id='" + authorityId + "' value='" + value + "' size='5' onblur='change(this.menuId)'>";
				document.getElementById(id).focus();
			}
			
			function change(id) {
				var oNP = document.getElementById(id);
				var value = oNP.value;
				gID = id;
				init();
				var url = "Menu_FoodModify.jsp?menuId=" + escape(menuId) + "&=" + value;
				req.open("GET", url, true);
				req.onreadystatechange = callback;
				req.send(null);
				
			}			
			function init() {
				if(window.XMLHttpRequest) {
					req = new XMLHttpRequest();
				} else if (window.ActiveXObject) {
					req = new ActiveXObject("Microsoft.XMLHTTP");
				}
			}			
			function callback() {
				if(4 == req.readyState) {				
					if(200 == req.status) {				
						var oNP = document.getElementById(gID);
						var value = oNP.value;
						oNP.outerHTML = "<span style='background:gray' id='" + gID + "' value='" + value + "' onclick='changeToInput(this.menuId)'>" + value + "</span>";
					}
				}				
			}			
		</script>
	</head>
	
	<body leftmargin="0" rightmargin="0" topmargin="0" onkeydown="if(event.keyCode==27) return false;">
		<div id="popLayer" style="position: absolute; z-index: 1000;"class="cPopText"></div>
		
		<table style="table-layout: fixed;" align="center" border="0"
			cellpadding="0" cellspacing="0" width="97%">
			<tbody>
				<tr>
				<td class="nav" align="left" nowrap="nowrap" width="100%">
					<h1>
				<span class="action-span"></span><span>Echarge 管理中心  - 设置权限 </span>
				</h1>
				</td>
					
				</tr>
			</tbody>
		</table>
		<br>
		
		<form action="Admin_Authority.jsp" name="form1" method="post">	
		<input type="hidden" name="action" value="authorit" />
		<table align="center" border="0" cellpadding="0" cellspacing="0"
			width="97%">
			<tbody>
				<tr>
					<td align="left">
						<table border="0" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<td height="3"></td>
								</tr>
								<tr>
									<td>
										<table class="tableborder" cellpadding="2" cellspacing="1">
											<tbody>
												<tr class="smalltxt" bgcolor="#f3f6fa">
													<td class="header">
														&nbsp;<%=totalRecords%>
													</td>
													<td class="header">
														&nbsp;<%=pageNo%>/<%=totalPages%>&nbsp;
													</td>
													
													<%
																											int start = ((pageNo - 1) / PAGES_PER_TIME) * PAGES_PER_TIME + 1;
																											for (int i = start; i < start + PAGES_PER_TIME; i++) {
																												if (i > totalPages)
																													break;
																												if (pageNo == i) {
																										%>
															<td bgcolor="#ffffff">&nbsp;<u><b><%=i%></b></u>&nbsp;</td>
														<%
															} else {
														%>
															<td>&nbsp;
																<a href="Admin_Authority.jsp?pageNo=<%=i%>"><%=i%></a>&nbsp;
															</td>
													<%
														}
														}
													%>
															<td>&nbsp;
																<a href="Admin_Authority.jsp?pageNo=<%=pageNo + 1%>">&gt;</a>&nbsp;
															</td>
													
													<td>
														&nbsp;
														<a href="http://bbs.allsmart.com/member.php?action=list&amp;srchmem=&amp;order=&amp;menus=&amp;page=100">&gt;<b>|</b>
														</a>&nbsp;
													</td>
													<td style="padding: 0pt;">
														<input name="custompage" size="2"
															style="border: 1px solid rgb(77, 118, 179);"
															onKeyDown="javascript: if(window.event.keyCode == 13) window.location='member.php?action=list&srchmem=&order=&menus=&page='+this.value;"
															type="text">
													</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td height="3"></td>
								</tr>	
							</tbody>
						</table>
					</td>
					<td align="right">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="label" align="right" style="width:120px">
									当前用户类型:
								</td>
								<td align="right">
									<select name="roleName" style="width:110px">
										<option value="">
											请选择
										</option>
										<%
											List<Role> roles = new ArrayList<Role>();
											Role.getRoles(roles, 1, 10);
											for (int i = 0; i < roles.size(); i++) {
												Role r = roles.get(i);
										%>
												<option value="<%=r.getRoleName()%>"><%=r.getRoleName()%></option>
										<%
											}
										%>
									</select>
								</td>
								<td>&nbsp;&nbsp;</td>
								<td align="right">
									<input type="submit" value="提交" style="width:60px;line-height:11px;"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
		</form><!-- end form1 -->
		
		<form action="MenuFlagServlet" name="form2" method="post">
		<table class="tableborder" align="center" cellpadding="4" cellspacing="1" width="97%">
			<tbody>
				<tr class="header">
					<td align="center" width="8%">
						菜单编号
					</td>
					<td align="center" width="30%">
						一级菜单
					</td>
					<td align="center" width="30%">
						二级菜单
					</td>
					<td align="center" width="10%">
						备注
					</td>
					<td align="center" width="22%">
						设置权限
					</td>
				</tr>
				<%
					for (int i = 0; i < authoritys.size(); i++) {
						au = authoritys.get(i);
				%>
				<tr>
					<td class="altbg2" align="center">
						<input name="roleName" type="hidden" value="<%=roleName%>">
						<%=au.getMenu_menuID()%>
					</td>
					<td class="altbg2" align="center">
						<%=au.getLev1Menu()%>
					</td>
					<td class="altbg2" align="center">
						<%=au.getLev2Menu()%>
					</td>
					<td class="altbg2" align="center">
						<%=au.getMenuNote()%>
					</td>
					<%
						if (au.getMenuFlag() == 1) {
					%>
					<td class="altbg1" align="center">
						<input type="checkbox" name="menuFlag" checked="checked" value="<%=au.getMenu_menuID()%>"/>
					</td>
					<%
						}
					%>
					<%
						if (au.getMenuFlag() == 0) {
					%>
					<td class="altbg1" align="center">
						<input type="checkbox" name="menuFlag" value="<%=au.getMenu_menuID()%>"/>
					</td>
					<%
						}
					%>
				</tr>
				<%
					}
				%>
			</tbody>
		</table><br/>
			<table align="center">
				<tr>
					<%
						if (totalRecords != 0) {
					%>
					<td align="center">
						<input type="submit" value="设置"/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="重置" />
					</td>
					<%
						}
					%>
				</tr>
			</table>
		</form><!-- end form2 -->

<script language="javascript">
var b = "<%=roleName%>";
if(b != "殷华杰"){
	document.form1.roleName.value = b;
}else document.form1.roleName.value = "";
</script>
	</body>
</html>
