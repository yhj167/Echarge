<%@ page language="java" import="java.util.*" contentType="text/html;charset=gb2312"%>
<%@ page import="com.Echarge.User.*"%>
<%@ page pageEncoding="GB18030"%>
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
	List<User> users = new ArrayList<User>();
	int totalRecords = User.getBlacklists(users, pageNo, PAGE_SIZE);
	int totalPages = (totalRecords + PAGE_SIZE - 1) / PAGE_SIZE;

	if (pageNo > totalPages)
		pageNo = totalPages;
%>
<html>
	<head>
	<link href="../Admin/styles/main.css" rel="stylesheet" type="text/css" />
	<link href="../Admin/styles/general.css" rel="stylesheet" type="text/css" />	
	<title>账户列表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<meta name="keywords" content="Discuz!,Board,Comsenz,forums,bulletin board,">
		<meta name="description" content="Echarge账户列表">
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
		<script type="text/javascript">
			var req;
			var gID;
			function changeToInput(ID) {
				var oNP = document.getElementById(ID);
				var value = oNP.value;
				oNP.outerHTML = "<input type='text' id='" + ID + "' value='" + value + "' size='5' onblur='change(this.ID)'>";
				document.getElementById(id).focus();
			}
			
			function change(ID) {
				var oNP = document.getElementById(ID);
				var value = oNP.value;
				gID = ID;
				init();
				var url = "UserModify.jsp?ID=" + escape(ID) + "&=" + value;
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
						oNP.outerHTML = "<span style='background:gray' id='" + gID + "' value='" + value + "' onclick='changeToInput(this.id)'>" + value + "</span>";
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
				<span class="action-span"></span><span>Echarge 管理中心  - 黑名单列表 </span>
				</h1>
				</td>
					
				</tr>
			</tbody>
		</table>
		<br>
		
		<center><a href="UserSearchBlacklist.jsp">查找客户</a></center>
		
		<table align="center" border="0" cellpadding="0" cellspacing="0" width="97%">
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
																<a href="Admin_UserList.jsp?pageNo=<%=i%>"><%=i%></a>&nbsp;
															</td>
													<%
														}
														}
													%>
															<td>&nbsp;
																<a href="UserList.jsp?pageNo=<%=pageNo + 1%>">&gt;</a>&nbsp;
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

		<form action="BlackListDeleteServlet" name="form1" method="post">
		<input name="formhash" value="93a2a31f" type="hidden">
	    <table class="tableborder" align="center" cellpadding="4"
			cellspacing="1" width="97%">
          <tr class="header">
            <td align="center" width="10%"> 选择 </td>
            <td align="center" width="6%"> 账号 </td>
            <td align="center" width="5%"> 姓名 </td>
            <td align="center" width="5%"> 性别 </td>
            <td align="center" width="7%"> 证件类型 </td>
            <td align="center" width="9%"> 证件号码 </td>
            <td align="center" width="9%"> 邮箱地址 </td>
            <td align="center" width="6%"> 固定电话 </td>
            <td align="center" width="7%"> 移动电话 </td>
            <td align="center" width="15%"> 地址 </td>
            <td align="center" width="5%"> 余额 </td>
            <td align="center" width="5%"> 状态 </td>
            <td align="center" width="11%"> 注册时间 </td>
          </tr>
          <%
          	for (int i = 0; i < users.size(); i++) {
          		User u = users.get(i);
          %>
          <tr>
            <td class="altbg2" align="center"><input type="checkbox" name="id" value="<%=u.getID()%>"/></td>
			<td class="altbg1" align="center" nowrap="nowrap"><%=u.getClientAccount()%></td>
			<td class="altbg1" align="center"><%=u.getClientName()%> </td>
            <td class="altbg1" align="center"><%=u.getClientSex()%> </td>
            <td class="altbg1" align="center"><%=u.getCardType()%> </td>
            <td class="altbg1" align="center"><%=u.getCardNum()%> </td>
            <td class="altbg1" align="center"><%=u.getClientEmail()%> </td>
            <td class="altbg1" align="center"><%=u.getClientTel()%> </td>
            <td class="altbg1" align="center"><%=u.getClientPhone()%> </td>
            <td class="altbg1" align="center"><%=u.getClientAddress()%> </td>
            <td class="altbg1" align="center"><%=u.getCardBalance()%> </td>
            <td class="altbg1" align="center"><%=u.getClientState()%> </td>
            <td class="altbg1" align="center"><%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(u.getRDate())%> </td>
            <td class="altbg1" align="right" width="3%"><%
            	String url = request.getRequestURL()
            				+ (request.getQueryString() == null ? "" : "?"
            						+ request.getQueryString());
            %>
              <a href="UserDeleteResult.jsp?ID=<%=u.getID()%>&from=<%=url%>" onClick="return confirm('真的要删除?')">删</a> 
              <!-- 
			  <a href="BlackUserInfo.jsp?clientAccount=<%=u.getClientAccount()%>">详细</a>
              <a target="detail" href="UserModify.jsp?clientAccount=<%=u.getClientAccount()%>">改</a> 
               -->
             </td>
          </tr>
          <%
          	}
          %>
          <tr>
            <td><input name="selectAll" type="checkbox" onClick="return checkDelete()"/>
                <input name="submit" type="submit" value="Delete"/>
            </td>
            <td colspan="13" class="altbg2"></td>
          </tr>
        </table>
        </form>
	</body>
</html>
