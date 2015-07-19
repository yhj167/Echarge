<%@ page language="java" import="java.util.*" contentType="text/html;charset=gbk" pageEncoding="GB18030"%>
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
String action = request.getParameter("action");
if(action != null && action.trim().equals("Delete")) {
	String loginName = request.getParameter("loginName");
	Admin.deleteLoginName(loginName);
	//out.println("用户删除成功");
}
 %>
 
<%
	
	final int PAGE_SIZE = 10; //每页显示多少条记录
	final int PAGES_PER_TIME = 10;//每次显示多少个页码链接
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
	List<Admin> admins = new ArrayList<Admin>();
	int totalRecords = Admin.getAdmins(admins, pageNo, PAGE_SIZE);
	int totalPages = (totalRecords + PAGE_SIZE - 1) / PAGE_SIZE;

	if (pageNo > totalPages)
		pageNo = totalPages;
%>


<html>
	<head>
	<link href="styles/main.css" rel="stylesheet" type="text/css" />
	<link href="styles/general.css" rel="stylesheet" type="text/css" />	
	<title>用户列表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<meta name="keywords"
			content="Discuz!,Board,Comsenz,forums,bulletin board,">
		<meta name="description" content="Echarge用户列表">
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
		<script type="text/javascript">
			var req;
			var gID;
			function changeToInput(id) {
				var oNP = document.getElementById(id);
				var value = oNP.value;
				oNP.outerHTML = "<input type='text' id='" + adminId + "' value='" + value + "' size='5' onblur='change(this.adminId)'>";
				document.getElementById(id).focus();
			}
			
			function change(id) {
				var oNP = document.getElementById(id);
				var value = oNP.value;
				gID = id;
				init();
				var url = "Admin_FoodModify.jsp?adminId=" + escape(adminId) + "&=" + value;
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
						oNP.outerHTML = "<span style='background:gray' id='" + gID + "' value='" + value + "' onclick='changeToInput(this.adminId)'>" + value + "</span>";
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
				<span class="action-span"></span><span>Echarge 管理中心  - 用户列表 </span>
				</h1>
				</td>
					
				</tr>
			</tbody>
		</table>
		<br>
		
		<center><a href="Admin_AddUser.jsp">添加新用户</a></center>
		
		<table align="center" border="0" cellpadding="0" cellspacing="0"
			width="97%">
			<tbody>
				<tr>
					<td>
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
														&nbsp;<%=totalRecords  %>
													</td>
													<td class="header">
														&nbsp;<%=pageNo %>/<%=totalPages %>&nbsp;
													</td>
													
													<%
													int start = ((pageNo - 1) / PAGES_PER_TIME) * PAGES_PER_TIME + 1;
													for(int i=start; i<start+PAGES_PER_TIME; i++) {
														if(i > totalPages) break;
														if(pageNo == i) {
													 %>
															<td bgcolor="#ffffff">&nbsp;<u><b><%=i %></b></u>&nbsp;</td>
														<%
														} else {
														 %>
															<td>&nbsp;
																<a href="Admin_UserList.jsp?pageNo=<%=i%>"><%=i%></a>&nbsp;
															</td>
													<%
														}
													}
													 %>
															<td>&nbsp;
																<a href="Admin_UserList.jsp?pageNo=<%=pageNo+1%>">&gt;</a>&nbsp;
															</td>
													
													<td>
														&nbsp;
														<a href="http://bbs.allsmart.com/member.php?action=list&amp;srchmem=&amp;order=&amp;admins=&amp;page=100">&gt;<b>|</b>
														</a>&nbsp;
													</td>
													<td style="padding: 0pt;">
														<input name="custompage" size="2"
															style="border: 1px solid rgb(77, 118, 179);"
															onKeyDown="javascript: if(window.event.keyCode == 13) window.location='member.php?action=list&srchmem=&order=&admins=&page='+this.value;"
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
				</tr>
			</tbody>
		</table>
		
		<form action="AdminDeleteServlet" name="form1" method="post">
		<table class="tableborder" align="center" cellpadding="4"
			cellspacing="1" width="97%">
			<tbody>
				<tr class="header">
					<td align="center" width="9%">
						选择
					</td>
					<td align="center" width="9%">
						管理员类型
					</td>
					<td align="center" width="9%">
						管理员姓名
					</td>
					<td align="center" width="9%">
						账号
					</td>
						
					<td align="center" width="10%"> 
						电话
					</td>
					<td align="center" width="12%"> 
						Email 
					</td>
					<td align="center" width="22%">
						地址
					</td>
					<td align="center" width="15%">
						注册时间
					</td>
				</tr>
				<%
						for (int i = 0; i < admins.size(); i++) {
							a = admins.get(i);
				%>
				

				<tr>
					<td class="altbg2" align="center">
						<input type="checkbox" name="id" value="<%=a.getAdminId()%>"/>
					</td>
					<td class="altbg1" align="center" nowrap="nowrap">
						<%=a.getAdminType()%>
					</td>
					<td class="altbg1" align="center">
						<%=a.getAdminName()%>
					</td>
															
					<td class="altbg1" align="center">
						<%=a.getLoginName()%>
					</td>
					<td class="altbg1" align="center">
						<%=a.getPhoneNum()%>
					</td>
					<td class="altbg1" align="center">
						<%=a.getAdminEmail()%>
					</td>
					<td class="altbg1" align="center">
						<%=a.getAdminAddress()%>
					</td>
					<td class="altbg1" align="center">
						<%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(a.getAddDate())%>
					</td>
					<td class="altbg1" align="center">
						<% String url = request.getRequestURL() + (request.getQueryString() == null ? "" : "?" + request.getQueryString()); %>
						<a href="Admin_DeleteResult.jsp?loginName=<%=a.getLoginName()%>&from=<%=url%>" onclick="return confirm('真的要删除?')">删</a>
						<a href="Admin_UserInfo.jsp?loginName=<%=a.getLoginName()%>">详细</a>
					</td>
				</tr>
				<%
				}
				 %>
				<tr>
					<td>
						<input name="selectAll" type="checkbox" onclick="return checkDelete()"/>
						<input type="submit" value="Delete"/>
					</td>
					<td colspan="8" class="altbg2">
					</td>
				</tr>
			</tbody>
		</table>
		</form><!-- end form1 -->

	</body>
</html>
