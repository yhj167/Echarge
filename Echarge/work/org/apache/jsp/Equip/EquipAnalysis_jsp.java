package org.apache.jsp.Equip;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.Echarge.Analysis.*;
import com.Echarge.Repair.*;
import com.Echarge.admin.*;
import java.text.SimpleDateFormat;

public final class EquipAnalysis_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html;charset=GB18030");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	//检查session，查看用户是否登陆
	Admin a = (Admin) session.getAttribute("admin");
	if (a == null) {
		response.sendRedirect("../Admin_Login.jsp");
		return;
	}

      out.write('\r');
      out.write('\n');

//	response.setContentType("application/vnd.ms-excel;charset=GBK"); 
	Analysis au =  new Analysis();

      out.write('\r');
      out.write('\n');
	
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

      out.write('\r');
      out.write('\n');

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

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t<link href=\"../Admin/styles/main.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"../Admin/styles/general.css\" rel=\"stylesheet\" type=\"text/css\" />\t\r\n");
      out.write("\t<title>设备使用分析</title>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\r\n");
      out.write("\t<meta name=\"keywords\" content=\"Discuz!,Board,Comsenz,forums,bulletin board,\">\r\n");
      out.write("\t\t<meta name=\"description\" content=\"Echarge设备使用分析\">\r\n");
      out.write("\t\t<meta name=\"generator\" content=\"Discuz! 4.0.0RC4 with Templates 4.0.0\">\r\n");
      out.write("\t\t<meta name=\"MSSmartTagsPreventParsing\" content=\"TRUE\">\r\n");
      out.write("\t\t<meta http-equiv=\"MSThemeCompatible\" content=\"Yes\">\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<style type=\"text/css\">\r\n");
      out.write("#redlink a:link {color:#FF0000;text-decoration:underline;}\r\n");
      out.write("#redlink a:visited {color:#FF0000;text-decoration:none;}\r\n");
      out.write("#redlink a:hover {color:#000000;text-decoration:none;}\r\n");
      out.write("#redlink a:active {color:#FFFFFF;text-decoration:none;} \r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!--\r\n");
      out.write("a\t\t\t{ text-decoration: none; color: #000000 }\r\n");
      out.write("a:hover\t\t\t{ text-decoration: underline }\r\n");
      out.write("body\t\t\t{ scrollbar-base-color: #F3F6FA; scrollbar-arrow-color: #4D76B3; font-size: 12px; background-color: #ffffff }\r\n");
      out.write("table\t\t\t{ font: 12px Verdana,Tahoma; color: #000000 }\r\n");
      out.write("input,select,textarea\t{ font: 11px Verdana,Tahoma; color: #000000; font-weight: normal; background-color: #F3F6FA }\r\n");
      out.write("select\t\t\t{ font: 11px Verdana,Tahoma; color: #000000; font-weight: normal; background-color: #F3F6FA }\r\n");
      out.write(".nav\t\t\t{ font: 12px Verdana,Tahoma; color: #000000; font-weight: bold }\r\n");
      out.write(".nav a\t\t\t{ color: #000000 }\r\n");
      out.write(".header\t\t\t{ font: 11px Verdana,Tahoma; color: #000000; font-weight: bold; background-image: url(\"images/green/bg01.gif\") }\r\n");
      out.write(".header a\t\t{ color: #FFFFFF }\r\n");
      out.write(".category\t\t{ font: 11px Verdana,Tahoma; color: #000000; background-color: #EFEFEF }\r\n");
      out.write(".tableborder\t\t{ background: #80BDCB; border: 0px solid #4D76B3 } \r\n");
      out.write(".singleborder\t\t{ font-size: 0px; line-height: 0px; padding: 0px; background-color: #F3F6FA }\r\n");
      out.write(".smalltxt\t\t{ font: 11px Verdana,Tahoma }\r\n");
      out.write(".outertxt\t\t{ font: 12px Verdana,Tahoma; color: #000000 }\r\n");
      out.write(".outertxt a\t\t{ color: #000000 }\r\n");
      out.write(".bold\t\t\t{ font-weight: bold }\r\n");
      out.write(".altbg1\t\t\t{ background: #F3F6FA }\r\n");
      out.write(".altbg2\t\t\t{ background: #FFFFFF }\r\n");
      out.write("-->\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t\t<script language=\"JavaScript\" src=\"../Admin/images/common.js\"></script>\r\n");
      out.write("\t\t<style type=\"text/css\">.cPopText { font-family: Tahoma, Verdana; background-color: #FFFFCC; border: 1px #000000 solid; font-size: 12px; padding-right: 4px; padding-left: 4px; height: 20px; padding-top: 2px; padding-bottom: 2px; visibility: hidden; filter: Alpha(Opacity=80)}</style>\r\n");
      out.write("\t\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\tfunction mm(f) {\r\n");
      out.write("\t\tif (f == 1) {\r\n");
      out.write("\t\t\tlay1.style.display = \"inline\"\r\n");
      out.write("\t\t\tlay2.style.display = \"none\"\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tlay1.style.display = \"none\"\r\n");
      out.write("\t\t\tlay2.style.display = \"inline\"\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function Hidden(t1,t2,t3){\r\n");
      out.write("\tvar t1,t2,t3;//表格ID\r\n");
      out.write("\tt1.style.display=\"none\";//切换为隐藏状态\r\n");
      out.write("\tt2.style.display=\"none\";\r\n");
      out.write("\tt3.style.display=\"none\";\r\n");
      out.write("\twindow.print(); \r\n");
      out.write("\tt1.style.display=\"\";//切换为隐藏状态\r\n");
      out.write("\tt2.style.display=\"\";\r\n");
      out.write("\tt3.style.display=\"\";\r\n");
      out.write("\treturn;\r\n");
      out.write("}\r\n");
      out.write("</script>\t\r\n");
      out.write("\t\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function ExportToExcel(Id){\r\n");
      out.write("\tvar mStr;\r\n");
      out.write("\tmStr = window.document.body.innerHTML ;\r\n");
      out.write("\tvar mWindow = window;\r\n");
      out.write("\twindow.document.body.innerHTML =Id.innerHTML;  \r\n");
      out.write("\tdocument.write(window.document.body.innerHTML);\r\n");
      out.write("\tdocument.execCommand(\"saveAs\",\"true\",\"AnalysisList.xls\");\t\r\n");
      out.write("\twindow.document.body.innerHTML = mStr;\r\n");
      out.write("\thistory.back();\r\n");
      out.write("\treturn;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/date.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("var oCalendarChs=new PopupCalendar(\"oCalendarChs\"); //初始化控件时,请给出实例名称:oCalendarChs\r\n");
      out.write("oCalendarChs.weekDaySting=new Array(\"日\",\"一\",\"二\",\"三\",\"四\",\"五\",\"六\");\r\n");
      out.write("oCalendarChs.monthSting=new Array(\"一月\",\"二月\",\"三月\",\"四月\",\"五月\",\"六月\",\"七月\",\"八月\",\"九月\",\"十月\",\"十一月\",\"十二月\");\r\n");
      out.write("oCalendarChs.oBtnTodayTitle=\"今天\";\r\n");
      out.write("oCalendarChs.oBtnCancelTitle=\"取消\";\r\n");
      out.write("oCalendarChs.Init();\r\n");
      out.write("</script>\t\r\n");
      out.write("\t</head>\r\n");
      out.write("\t\r\n");
      out.write("\t<body leftmargin=\"0\" rightmargin=\"0\" topmargin=\"0\" onkeydown=\"if(event.keyCode==27) return false;\">\r\n");
      out.write("\t\t<div id=\"popLayer\" style=\"position: absolute; z-index: 1000;\"class=\"cPopText\"></div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<table id=\"t1\" style=\"table-layout: fixed;\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"97%\">\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"nav\" align=\"left\" nowrap=\"nowrap\" width=\"100%\">\r\n");
      out.write("\t\t\t\t\t<h1>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"action-span\"></span><span>Echarge 管理中心  - 设备使用分析 </span>\r\n");
      out.write("\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t<table id=\"t2\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"97%\">\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td height=\"3\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<table class=\"tableborder\" cellpadding=\"2\" cellspacing=\"1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<tr class=\"smalltxt\" bgcolor=\"#f3f6fa\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"header\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t&nbsp;");
      out.print(totalRecords  );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"header\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t&nbsp;");
      out.print(pageNo );
      out.write('/');
      out.print(totalPages );
      out.write("&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");

													int start = ((pageNo - 1) / PAGES_PER_TIME) * PAGES_PER_TIME + 1;
													for(int i=start; i<start+PAGES_PER_TIME; i++) {
														if(i > totalPages) break;
														if(pageNo == i) {
													 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td bgcolor=\"#ffffff\">&nbsp;<u><b>");
      out.print(i );
      out.write("</b></u>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t");

														} else {
														 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"EquipAnalysis.jsp?pageNo=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</a>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");

														}
													}
													 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"EquipAnalysis.jsp?pageNo=");
      out.print(pageNo+1);
      out.write("\">&gt;</a>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"http://bbs.allsmart.com/member.php?action=list&amp;srchmem=&amp;order=&amp;admins=&amp;page=100\">&gt;<b>|</b>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</a>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"padding: 0pt;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input name=\"custompage\" size=\"2\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"border: 1px solid rgb(77, 118, 179);\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tonKeyDown=\"javascript: if(window.event.keyCode == 13) window.location='member.php?action=list&srchmem=&order=&admins=&page='+this.value;\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td height=\"3\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<div align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"EquipAnalysisImg1.jsp\">利用率统计</a>&nbsp;|&nbsp;\r\n");
      out.write("\t\t\t\t\t\t<a href=\"EquipAnalysisImg2.jsp\">充电量统计</a>&nbsp;|&nbsp;\r\n");
      out.write("   \t\t\t\t\t\t<a href=\"EquipAnalysisImg3.jsp\">充电费用统计</a>&nbsp;|&nbsp;\r\n");
      out.write("   \t\t\t\t\t\t<a href=\"EquipAnalysisImg4.jsp\">充电模式统计</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"EXCEL\">\r\n");
      out.write("\t\t<table class=\"tableborder\" id=\"Excel\" align=\"center\" cellpadding=\"4\" cellspacing=\"1\" width=\"97%\">\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr class=\"header\">\r\n");
      out.write("\t\t\t\t\t<td align=\"center\" width=\"10%\">\r\n");
      out.write("\t\t\t\t\t\t序号\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td align=\"center\" width=\"15%\">\r\n");
      out.write("\t\t\t\t\t\t充电桩号\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td align=\"center\" width=\"25%\">\r\n");
      out.write("\t\t\t\t\t\t注册时间\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td align=\"center\" width=\"25%\">\r\n");
      out.write("\t\t\t\t\t\t使用时间\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td align=\"center\" width=\"20%\">\r\n");
      out.write("\t\t\t\t\t\t备注\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

						for (int i = 0; i < analysiss.size(); i++) {
							au = analysiss.get(i);
				
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"altbg2\" align=\"center\" nowrap=\"nowrap\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(au.getaID());
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<td class=\"altbg1\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(au.getEquipNo());
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<!--\r\n");
      out.write("\t\t\t\t\t<td class=\"altbg1\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t");
int useNum = au.getUseNum();
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(useNum);
      out.write("&nbsp;/&nbsp;");
      out.print(au.getRate(useNum, totalUseNum));
      out.write("%\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<td class=\"altbg1\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t");

						String equipNo = au.getEquipNo();
						List<Repair> repairs = new ArrayList<Repair>();
						int repairRecord = Repair.getRepairs1(repairs, pageNo, PAGE_SIZE, equipNo);
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div id=\"redlink\"><a href=\"EquipRepairRecord.jsp?equipNo=");
      out.print(au.getEquipNo());
      out.write('"');
      out.write('>');
      out.print(repairRecord);
      out.write("</a></div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t-->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<td class=\"altbg1\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t");
Date rDate = au.getrDate(); //out.println(rDate);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rDate));
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<td class=\"altbg1\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(au.calcUseTime(rDate));
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<td class=\"altbg1\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(au.getNoteMsg());
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td class=\"altbg1\" align=\"center\" nowrap=\"nowrap\">\r\n");
      out.write("\t\t\t\t\t\t");
 String url = request.getRequestURL() + (request.getQueryString() == null ? "" : "?" + request.getQueryString()); 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a href=\"EquipAnalysisDeleteResult.jsp?equipNo=");
      out.print(au.getEquipNo());
      out.write("&from=");
      out.print(url);
      out.write("\" onclick=\"return confirm('真的要删除?')\">删</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"EquipAnalysisModi.jsp?aID=");
      out.print(au.getaID());
      out.write("&from=");
      out.print(url);
      out.write("\">改</a>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

				}
				 
      out.write("\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table></div><br>\r\n");
      out.write("\t\t<table id=\"t3\" style=\"table-layout: fixed;\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"97%\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"nav\" align=\"center\" nowrap=\"nowrap\" width=\"100%\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"打印\" onclick=\"return Hidden(t1,t2,t3)\"/>&nbsp;\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"导出\" onclick=\"return ExportToExcel(EXCEL)\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
