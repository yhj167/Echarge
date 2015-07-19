<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="com.Echarge.Charging.*"%>
<%@ page import="com.Echarge.admin.*" %>

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
	Charging c = (Charging) session.getAttribute("Charging");
%>
<html>
	<head>
	<link href="../Admin/styles/main.css" rel="stylesheet" type="text/css" />
	<link href="../Admin/styles/general.css" rel="stylesheet" type="text/css" />	
	<title>客户充电表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<meta name="keywords"
			content="Discuz!,Board,Comsenz,forums,bulletin board,">
		<meta name="description" content="Echarge客户充电表">
		<meta name="generator" content="Discuz! 4.0.0RC4 with Templates 4.0.0">
		<meta name="MSSmartTagsPreventParsing" content="TRUE">
		<meta http-equiv="MSThemeCompatible" content="Yes">	
		
		<style type="text/css">
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
		} else if(f == 2){
			lay1.style.display = "none"
			lay2.style.display = "inline"
		} else if (f == 3) {
			lay3.style.display = "inline"
			lay4.style.display = "none"
		} else {
			lay3.style.display = "none"
			lay4.style.display = "inline"
		}

	}
	</script>

<script type="text/javascript">
function Hidden(t1,t2,t3,t4,t5){
	var t1,t2,t3,t4;//表格ID
	t1.style.display="none";//切换为隐藏状态
	t2.style.display="none";
	t3.style.display="none";
	t4.style.display="none";
	t5.style.display="none";
	window.print(); 
	t1.style.display="";//切换为显示状态
	t2.style.display="";
	t3.style.display="";
	t4.style.display="";
	t5.style.display="";
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
	document.execCommand("saveAs","true","ChargingList.xls");	
	window.document.body.innerHTML = mStr;
	history.back();
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
	
		<table id="t1" style="table-layout: fixed;" align="center" border="0"
			cellpadding="0" cellspacing="0" width="97%">
			<tbody>
				<tr>
				<td class="nav" align="left" nowrap="nowrap" width="100%">
					<h1>
				<span class="action-span"></span><span>Echarge 管理中心  - 客户充电表 </span>
				</h1>
				</td>
					
				</tr>
			</tbody>
		</table><br>
		<center>查询结果</center><br>

		<input name="formhash" value="93a2a31f" type="hidden">
		<div id="EXCEL">
		<table class="tableborder" align="center" cellpadding="4" cellspacing="1" width="97%">
			<tbody>
				<tr class="header">
					<td align="center" width="7%">
						充电编号
					</td>
					<td align="center" width="7%">
						客户账号
					</td>
					<td align="center" width="7%">
						充电桩号
					</td>
					<td align="center" width="9%">
						充电量（度）
					</td>
					<td align="center" width="9%">
						充电费用（元）
					</td>	
					<td align="center" width="9%">
						当时余额（元）
					</td>
					<td align="center" width="9%">
						充电模式
					</td>
					<td align="center" width="12%">
						充电时间
					</td>
					<td align="center" width="12%">
						开始时间
					</td>
					<td align="center" width="12%">
						结束时间
					</td>
				</tr>
				<tr>					
					<td class="altbg2" align="center">
						<%=c.getcID()%>
					</td>					
					<td class="altbg1" align="center">
						<%=c.getClientAccount()%>
					</td>									
					<td class="altbg1" align="center">
						<%=c.getMachineNo()%>
					</td>
					<td class="altbg1" align="center">
						<%=c.getElecQuantity()%>
					</td>
					<td class="altbg1" align="center">
						<%=c.getCost()%>
					</td>
					<td class="altbg1" align="center">
						<%=c.getTheBalance()%>
					</td>				
					<td class="altbg1" align="center">
						<%=c.getChargingMode()%>
					</td>				
					<td class="altbg1" align="center">
						<%=c.getChargingTime()%>
					</td>
					<td class="altbg1" align="center">
						<%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").format(c.getStartTime())%>
					</td>
					<td class="altbg1" align="center">
						<%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").format(c.getEndTime())%>
					</td>
					<td class="altbg1" align="center">
						<div id="redlink"><a href="ChargeDetailInfo.jsp?cID=<%=c.getcID()%>">详细</a></div>
					</td>		
				</tr>
			</tbody>
		</table></div><br>
	</body>
</html>