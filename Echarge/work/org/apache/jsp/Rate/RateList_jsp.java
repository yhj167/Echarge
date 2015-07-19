package org.apache.jsp.Rate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.Echarge.Rate.*;
import com.Echarge.admin.*;

public final class RateList_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	//检查session，查看用户是否登陆
	Admin a = (Admin) session.getAttribute("admin");
	if (a == null) {
		response.sendRedirect("../Admin_Login.jsp");
		return;
	}

      out.write('\r');
      out.write('\n');

	Rate r = (Rate) session.getAttribute("Rate"); 

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

	List<Rate> rates = new ArrayList<Rate>();
	int totalRecords = Rate.getRates(rates, pageNo, PAGE_SIZE);
	int totalPages = (totalRecords + PAGE_SIZE - 1) / PAGE_SIZE;

	if (pageNo > totalPages)
		pageNo = totalPages;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t<link href=\"../Admin/styles/main.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"../Admin/styles/general.css\" rel=\"stylesheet\" type=\"text/css\" />\t\r\n");
      out.write("\t<title>账户列表</title>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\r\n");
      out.write("\t<meta name=\"keywords\"\r\n");
      out.write("\t\t\tcontent=\"Discuz!,Board,Comsenz,forums,bulletin board,\">\r\n");
      out.write("\t\t<meta name=\"description\" content=\"Echarge账户列表\">\r\n");
      out.write("\t\t<meta name=\"generator\" content=\"Discuz! 4.0.0RC4 with Templates 4.0.0\">\r\n");
      out.write("\t\t<meta name=\"MSSmartTagsPreventParsing\" content=\"TRUE\">\r\n");
      out.write("\t\t<meta http-equiv=\"MSThemeCompatible\" content=\"Yes\">\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<style type=\"text/css\"><!--\r\n");
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
      out.write("--></style>\r\n");
      out.write("\t\t<script language=\"JavaScript\" src=\"../Admin/images/common.js\"></script>\r\n");
      out.write("\t\t<style type=\"text/css\">.cPopText { font-family: Tahoma, Verdana; background-color: #FFFFCC; border: 1px #000000 solid; font-size: 12px; padding-right: 4px; padding-left: 4px; height: 20px; padding-top: 2px; padding-bottom: 2px; visibility: hidden; filter: Alpha(Opacity=80)}</style>\r\n");
      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tfunction checkDelete() {\r\n");
      out.write("\t\t\t\tvar ids = document.getElementsByName(\"id\");\r\n");
      out.write("\t\t\t\tif(document.form1.selectAll.checked) {\r\n");
      out.write("\t\t\t\t\tfor(var i=0; i<ids.length; i++) {\r\n");
      out.write("\t\t\t\t\t\tids[i].checked=\"checked\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\tfor(var i=0; i<ids.length; i++) {\r\n");
      out.write("\t\t\t\t\t\tids[i].checked=\"\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>\t\t\t\t\t\t\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tvar req;\r\n");
      out.write("\t\t\tvar gID;\r\n");
      out.write("\t\t\tfunction changeToInput(id) {\r\n");
      out.write("\t\t\t\tvar oNP = document.getElementById(id);\r\n");
      out.write("\t\t\t\tvar value = oNP.value;\r\n");
      out.write("\t\t\t\toNP.outerHTML = \"<input type='text' id='\" + adminId + \"' value='\" + value + \"' size='5' onblur='change(this.adminId)'>\";\r\n");
      out.write("\t\t\t\tdocument.getElementById(id).focus();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction change(id) {\r\n");
      out.write("\t\t\t\tvar oNP = document.getElementById(id);\r\n");
      out.write("\t\t\t\tvar value = oNP.value;\r\n");
      out.write("\t\t\t\tgID = id;\r\n");
      out.write("\t\t\t\tinit();\r\n");
      out.write("\t\t\t\tvar url = \"Admin_FoodModify.jsp?adminId=\" + escape(adminId) + \"&=\" + value;\r\n");
      out.write("\t\t\t\treq.open(\"GET\", url, true);\r\n");
      out.write("\t\t\t\treq.onreadystatechange = callback;\r\n");
      out.write("\t\t\t\treq.send(null);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\t\t\t\r\n");
      out.write("\t\t\tfunction init() {\r\n");
      out.write("\t\t\t\tif(window.XMLHttpRequest) {\r\n");
      out.write("\t\t\t\t\treq = new XMLHttpRequest();\r\n");
      out.write("\t\t\t\t} else if (window.ActiveXObject) {\r\n");
      out.write("\t\t\t\t\treq = new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\t\t\t\r\n");
      out.write("\t\t\tfunction callback() {\r\n");
      out.write("\t\t\t\tif(4 == req.readyState) {\t\t\t\t\r\n");
      out.write("\t\t\t\t\tif(200 == req.status) {\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tvar oNP = document.getElementById(gID);\r\n");
      out.write("\t\t\t\t\t\tvar value = oNP.value;\r\n");
      out.write("\t\t\t\t\t\toNP.outerHTML = \"<span style='background:gray' id='\" + gID + \"' value='\" + value + \"' onclick='changeToInput(this.adminId)'>\" + value + \"</span>\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\t\t\t\t\r\n");
      out.write("\t\t\t}\t\t\t\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t\r\n");
      out.write("\t<body leftmargin=\"0\" rightmargin=\"0\" topmargin=\"0\" onkeydown=\"if(event.keyCode==27) return false;\">\r\n");
      out.write("\t\t<div id=\"popLayer\" style=\"position: absolute; z-index: 1000;\"class=\"cPopText\"></div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<table style=\"table-layout: fixed;\" align=\"center\" border=\"0\"\r\n");
      out.write("\t\t\tcellpadding=\"0\" cellspacing=\"0\" width=\"97%\">\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"nav\" align=\"left\" nowrap=\"nowrap\" width=\"100%\">\r\n");
      out.write("\t\t\t\t\t<h1>\r\n");
      out.write("\t\t\t\t<span class=\"action-span\"></span><span>Echarge 管理中心  - 费率列表 </span>\r\n");
      out.write("\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<center><a href=\"RateAdd.jsp\" >添加费率策略</a></center>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<form action=\"RateDownloadServlet\" name=\"form2\" method=\"post\">\r\n");
      out.write("\t\t<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\r\n");
      out.write("\t\t\twidth=\"97%\">\r\n");
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
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"RateList.jsp?pageNo=");
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
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"RateList.jsp?pageNo=");
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
      out.write("\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td class=\"altbg1\" align=\"right\" nowrap=\"nowrap\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"submit\" value=\"费率下发\" style=\"width: 100px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td height=\"3\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t<form action=\"RateDeleteServlet\" name=\"form1\" method=\"post\">\r\n");
      out.write("\t\t<input name=\"formhash\" value=\"93a2a31f\" type=\"hidden\">\r\n");
      out.write("\t\t<table class=\"tableborder\" align=\"center\" cellpadding=\"4\"\r\n");
      out.write("\t\t\tcellspacing=\"1\" width=\"97%\">\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr class=\"header\">\r\n");
      out.write("\t\t\t\t\t<td align=\"center\" width=\"10%\">选择</td>\r\n");
      out.write("\t\t\t\t\t<td align=\"center\" width=\"15%\">费率名</td>\r\n");
      out.write("\t\t\t\t\t<td align=\"center\" width=\"15%\">费率值（元/度）</td>\r\n");
      out.write("\t\t\t\t\t<td align=\"center\" width=\"25%\">时间段</td>\r\n");
      out.write("\t\t\t\t\t<td align=\"center\" width=\"30%\">生效日期</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

						for (int i = 0; i < rates.size(); i++) {
						r = rates.get(i);
				
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"altbg2\" align=\"center\" nowrap=\"nowrap\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"checkbox\" name=\"id\" value=\"");
      out.print(r.getRateID());
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td class=\"altbg1\" align=\"center\" nowrap=\"nowrap\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(r.getRateName());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td class=\"altbg1\" align=\"center\" nowrap=\"nowrap\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(r.getRateValue());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td class=\"altbg1\" align=\"center\" nowrap=\"nowrap\">\r\n");
      out.write("\t\t\t\t\t\t");

							int t = r.getRateTime();
							int w,x,y,w1,x1,z;
							w = t/1000000;
							w1 = t%1000000;
							x = w1/10000;
							x1 = w1%10000;
							y = x1/100;
							z = x1%100;
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
if(w<10){
      out.write('0');
}
      out.print(w);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t:\r\n");
      out.write("\t\t\t\t\t\t");
if(x<10){
      out.write('0');
}
      out.print(x);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t——\r\n");
      out.write("\t\t\t\t\t\t");
if(y<10){
      out.write('0');
}
      out.print(y);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t:\r\n");
      out.write("\t\t\t\t\t\t");
if(z<10){
      out.write('0');
}
      out.print(z);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td class=\"altbg1\" align=\"center\" nowrap=\"nowrap\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(r.getAddDate()));
      out.write(" \r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td class=\"altbg1\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t");
 String url = request.getRequestURL() + (request.getQueryString() == null ? "" : "?" + request.getQueryString()); 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a href=\"RateDeleteResult.jsp?rateID=");
      out.print(r.getRateID());
      out.write("&from=");
      out.print(url);
      out.write("\" onclick=\"return confirm('真的要删除?')\">删</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"RateModi.jsp?rateName=");
      out.print(r.getRateName());
      out.write("&from=");
      out.print(url);
      out.write("\">改</a>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

				}
				 
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input name=\"selectAll\" type=\"checkbox\" onclick=\"return checkDelete()\"/>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"Delete\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"8\" class=\"altbg2\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
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
