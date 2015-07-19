<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="com.Echarge.Analysis.*"%>
<%@ page import="com.Echarge.Repair.*" %>
<%@ page import="com.Echarge.admin.*" import="java.text.SimpleDateFormat"%>
<%
	//检查session，查看用户是否登陆
	Admin a = (Admin) session.getAttribute("admin");
	if (a == null) {
		response.sendRedirect("../Admin_Login.jsp");
		return;
	}
%>
<%
//	response.setContentType("application/vnd.ms-excel;charset=GBK"); 
	Analysis au =  new Analysis();
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
	List<Analysis> analysiss = new ArrayList<Analysis>();
	int totalRecords = Analysis.getAnalysiss(analysiss, pageNo, PAGE_SIZE);
	//out.println(totalRecords);
	int totalUseNum = Analysis.getTotalUseNum(analysiss);
	//out.println(totalUseNum);
	
	List<Analysis> analysiss1 = new ArrayList<Analysis>();
	int yesRecords = Analysis.getAnalysiss2(analysiss1);
	
	int totalPages = (totalRecords + PAGE_SIZE - 1) / PAGE_SIZE;
	if (pageNo > totalPages)
		pageNo = totalPages;
%>
<html>
	<head>
	<link href="../Admin/styles/main.css" rel="stylesheet" type="text/css" />
	<link href="../Admin/styles/general.css" rel="stylesheet" type="text/css" />	
	<title>设备使用分析</title>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<meta name="keywords" content="Discuz!,Board,Comsenz,forums,bulletin board,">
		<meta name="description" content="Echarge设备使用分析">
		<meta name="generator" content="Discuz! 4.0.0RC4 with Templates 4.0.0">
		<meta name="MSSmartTagsPreventParsing" content="TRUE">
		<meta http-equiv="MSThemeCompatible" content="Yes">	
		
		<style type="text/css">
#redlink a:link {color:#FF0000;text-decoration:underline;}
#redlink a:visited {color:#FF0000;text-decoration:none;}
#redlink a:hover {color:#000000;text-decoration:none;}
#redlink a:active {color:#FFFFFF;text-decoration:none;} 

		
		<!--
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
-->
		</style>
		<script language="JavaScript" src="../Admin/images/common.js"></script>
		<style type="text/css">.cPopText { font-family: Tahoma, Verdana; background-color: #FFFFCC; border: 1px #000000 solid; font-size: 12px; padding-right: 4px; padding-left: 4px; height: 20px; padding-top: 2px; padding-bottom: 2px; visibility: hidden; filter: Alpha(Opacity=80)}</style>
		
	<script type="text/javascript">
	function mm(f) {
		if (f == 1) {
			lay1.style.display = "inline"
			lay2.style.display = "none"
		} else {
			lay1.style.display = "none"
			lay2.style.display = "inline"
		}
	}
	</script>

<script type="text/javascript">
function Hidden(t1,t2,t3){
	var t1,t2,t3;//表格ID
	t1.style.display="none";//切换为隐藏状态
	t2.style.display="none";
	t3.style.display="none";
	window.print(); 
	t1.style.display="";//切换为隐藏状态
	t2.style.display="";
	t3.style.display="";
	return;
}
</script>	
	
<script type="text/javascript">
function ExportToExcel(Id){
	var mStr;
	mStr = window.document.body.innerHTML ;
	var mWindow = window;
	window.document.body.innerHTML =Id.innerHTML;  
	document.write(window.document.body.innerHTML);
	document.execCommand("saveAs","true","AnalysisList.xls");	
	window.document.body.innerHTML = mStr;
	history.back();
	return;
}
</script>
<script type="text/javascript" src="../js/date.js"></script>
<script>
var oCalendarChs=new PopupCalendar("oCalendarChs"); //初始化控件时,请给出实例名称:oCalendarChs
oCalendarChs.weekDaySting=new Array("日","一","二","三","四","五","六");
oCalendarChs.monthSting=new Array("一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月");
oCalendarChs.oBtnTodayTitle="今天";
oCalendarChs.oBtnCancelTitle="取消";
oCalendarChs.Init();
</script>	
	</head>
	
	<body leftmargin="0" rightmargin="0" topmargin="0" onkeydown="if(event.keyCode==27) return false;">
		<div id="popLayer" style="position: absolute; z-index: 1000;"class="cPopText"></div>
	
		<table id="t1" style="table-layout: fixed;" align="center" border="0" cellpadding="0" cellspacing="0" width="97%">
			<tbody>
				<tr>
				<td class="nav" align="left" nowrap="nowrap" width="100%">
					<h1>
						<span class="action-span"></span><span>Echarge 管理中心  - 设备使用分析 </span>
					</h1>
				</td>
				</tr>
			</tbody>
		</table>
		<br>
				
		<table id="t2" align="center" border="0" cellpadding="0" cellspacing="0" width="97%">
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
																<a href="EquipAnalysis.jsp?pageNo=<%=i%>"><%=i%></a>&nbsp;
															</td>
													<%
														}
													}
													 %>
															<td>&nbsp;
																<a href="EquipAnalysis.jsp?pageNo=<%=pageNo+1%>">&gt;</a>&nbsp;
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
					<td>
					<div align="right">
						<a href="EquipAnalysisImg1.jsp">利用率统计</a>&nbsp;|&nbsp;
						<a href="EquipAnalysisImg2.jsp">充电量统计</a>&nbsp;|&nbsp;
   						<a href="EquipAnalysisImg3.jsp">充电费用统计</a>&nbsp;|&nbsp;
   						<a href="EquipAnalysisImg4.jsp">充电模式统计</a>
					</div>
					</td>
				</tr>
			</tbody>
		</table>

		<div id="EXCEL">
		<table class="tableborder" id="Excel" align="center" cellpadding="4" cellspacing="1" width="97%">
			<tbody>
				<tr class="header">
					<td align="center" width="10%">
						序号
					</td>
					<td align="center" width="15%">
						充电桩号
					</td>
					<td align="center" width="25%">
						注册时间
					</td>
					<td align="center" width="25%">
						使用时间
					</td>
					<td align="center" width="20%">
						备注
					</td>
				</tr>
				<%
						for (int i = 0; i < analysiss.size(); i++) {
							au = analysiss.get(i);
				%>
				<tr>
					<td class="altbg2" align="center" nowrap="nowrap">
						<%=au.getaID()%>
					</td>

					<td class="altbg1" align="center">
						<%=au.getEquipNo()%>
					</td>

					<!--
					<td class="altbg1" align="center">
						<%int useNum = au.getUseNum();%>
						<%=useNum%>&nbsp;/&nbsp;<%=au.getRate(useNum, totalUseNum)%>%
					</td>

					<td class="altbg1" align="center">
					<%
						String equipNo = au.getEquipNo();
						List<Repair> repairs = new ArrayList<Repair>();
						int repairRecord = Repair.getRepairs1(repairs, pageNo, PAGE_SIZE, equipNo);
					%>
						<div id="redlink"><a href="EquipRepairRecord.jsp?equipNo=<%=au.getEquipNo()%>"><%=repairRecord%></a></div>
					</td>
					-->

					<td class="altbg1" align="center">
						<%Date rDate = au.getrDate(); //out.println(rDate);%>
						<%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rDate)%>
					</td>

					<td class="altbg1" align="center">
						<%=au.calcUseTime(rDate)%>
					</td>

					<td class="altbg1" align="center">
						<%=au.getNoteMsg()%>
					</td>
					
					<td class="altbg1" align="center" nowrap="nowrap">
						<% String url = request.getRequestURL() + (request.getQueryString() == null ? "" : "?" + request.getQueryString()); %>
						<a href="EquipAnalysisDeleteResult.jsp?equipNo=<%=au.getEquipNo()%>&from=<%=url%>" onclick="return confirm('真的要删除?')">删</a>
						<a href="EquipAnalysisModi.jsp?aID=<%=au.getaID()%>&from=<%=url%>">改</a>
					</td>
				</tr>
				<%
				}
				 %>
			</tbody>
		</table></div><br>
		<table id="t3" style="table-layout: fixed;" align="center" border="0" cellpadding="0" cellspacing="0" width="97%">
			<tr>
				<td class="nav" align="center" nowrap="nowrap" width="100%">
					<input type="button" value="打印" onclick="return Hidden(t1,t2,t3)"/>&nbsp;
					<input type="button" value="导出" onclick="return ExportToExcel(EXCEL)">
				</td>
			</tr>
		</table>
	</body>
</html>