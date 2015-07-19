package org.apache.jsp.dbManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.Echarge.admin.*;
import com.Echarge.DBtable.*;

public final class DB_005fReduction_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	List<DBtable> DBtables = new ArrayList<DBtable>();
	int totalRecords = DBtable.getDBtables(DBtables);

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t<link href=\"../Admin/styles/main.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"../Admin/styles/general.css\" rel=\"stylesheet\" type=\"text/css\" />\t\r\n");
      out.write("\t<title>数据库恢复</title>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\r\n");
      out.write("\t<meta name=\"keywords\" content=\"Discuz!,Board,Comsenz,forums,bulletin board,\">\r\n");
      out.write("\t\t<meta name=\"description\" content=\"Echarge数据库恢复\"/>\r\n");
      out.write("\t\t<meta name=\"generator\" content=\"Discuz! 4.0.0RC4 with Templates 4.0.0\"/>\r\n");
      out.write("\t\t<meta name=\"MSSmartTagsPreventParsing\" content=\"TRUE\"/>\r\n");
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
      out.write("<script language=\"JavaScript\" src=\"../Admin/images/common.js\"></script>\r\n");
      out.write("<style type=\"text/css\">.cPopText { font-family: Tahoma, Verdana; background-color: #FFFFCC; border: 1px #000000 solid; font-size: 12px; padding-right: 4px; padding-left: 4px; height: 20px; padding-top: 2px; padding-bottom: 2px; visibility: hidden; filter: Alpha(Opacity=80)}</style>\r\n");
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
      out.write("\t\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("\t<body leftmargin=\"0\" rightmargin=\"0\" topmargin=\"0\" onkeydown=\"if(event.keyCode==27) return false;\">\r\n");
      out.write("\t\t<div id=\"popLayer\" style=\"position: absolute; z-index: 1000;\" class=\"cPopText\"></div>\r\n");
      out.write("\t\t<table style=\"table-layout: fixed;\" align=\"center\" border=\"0\"\r\n");
      out.write("\t\t\tcellpadding=\"0\" cellspacing=\"0\" width=\"97%\">\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"nav\" align=\"left\" nowrap=\"nowrap\" width=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t<h1>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"action-span\"></span><span>Echarge 管理中心 - 数据库恢复</span>\r\n");
      out.write("\t\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<form name=\"form1\" method=\"post\" action=\"ReductionResult.jsp\" id=\"f\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"action\" value=\"DB_Reduction\" />\r\n");
      out.write("\r\n");
      out.write("\t\t\t<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"97%\">\r\n");
      out.write("\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td height=\"3\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td class=\"altbg1\" align=\"right\" nowrap=\"nowrap\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input name=\"path\" type=\"file\" class=\"text_input\" value=\"浏览...\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"submit\" value=\"开始导入\" onclick=\"return confirm('开始导入?')\" style=\"width: 80px;\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td height=\"3\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<table class=\"tableborder\" align=\"center\" cellpadding=\"4\" cellspacing=\"1\" width=\"97%\">\r\n");
      out.write("\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t<tr class=\"header\">\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\" width=\"15%\">\r\n");
      out.write("\t\t\t\t\t\t\t编号\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\" width=\"45%\">\r\n");
      out.write("\t\t\t\t\t\t\t数据库中的表\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\" width=\"40%\">\r\n");
      out.write("\t\t\t\t\t\t\t备注\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");

						for (int i = 0; i < DBtables.size(); i++) {
							DBtable t = DBtables.get(i);
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"altbg2\" align=\"center\" nowrap=\"nowrap\">\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.print(t.getTableID());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"altbg1\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.print(t.getTableName());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"altbg1\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t");

								String Msg =  t.getTableMsg();
								//Msg =  new String(Msg.getBytes("iso-8859-1"),"gbk");
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.print(Msg);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<!-- \r\n");
      out.write("\t\t\t\t\t\t<td class=\"altbg1\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"altbg1\" align=\"center\" width=\"10%\">\r\n");
      out.write("\t\t\t\t\t\t\t");
 String url = request.getRequestURL() + (request.getQueryString() == null ? "" : "?" + request.getQueryString()); 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"DBtableDelete.jsp?tableName=");
      out.print(t.getTableName());
      out.write("&from=");
      out.print(url);
      out.write("\" onclick=\"return confirm('真的要删除?')\">删除</a>\r\n");
      out.write("\t\t\t\t\t\t</td> -->\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
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
