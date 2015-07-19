package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.Echarge.admin.*;
import com.Echarge.Role.*;

public final class Admin_005fRoleList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=gbk");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
	Role r = (Role) session.getAttribute("role");
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

	List<Role> roles = new ArrayList<Role>();
	int totalRecords = Role.getRoles(roles, pageNo, PAGE_SIZE);
	int totalPages = (totalRecords + PAGE_SIZE - 1) / PAGE_SIZE;

	if (pageNo > totalPages)
		pageNo = totalPages;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t<link href=\"styles/main.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"styles/general.css\" rel=\"stylesheet\" type=\"text/css\" />\t\r\n");
      out.write("\t<title>角色列表</title>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\r\n");
      out.write("\t<meta name=\"keywords\"\r\n");
      out.write("\t\t\tcontent=\"Discuz!,Board,Comsenz,forums,bulletin board,\">\r\n");
      out.write("\t\t<meta name=\"description\" content=\"Echarge角色列表\">\r\n");
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
      out.write("\t\t<script language=\"JavaScript\" src=\"images/common.js\"></script>\r\n");
      out.write("\t\t<style type=\"text/css\">.cPopText { font-family: Tahoma, Verdana; background-color: #FFFFCC; border: 1px #000000 solid; font-size: 12px; padding-right: 4px; padding-left: 4px; height: 20px; padding-top: 2px; padding-bottom: 2px; visibility: hidden; filter: Alpha(Opacity=80)}</style>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tfunction checkDelete() {\r\n");
      out.write("\t\t\t\tvar ids = document.getElementsByName(\"roleId\");\r\n");
      out.write("\t\t\t\tif(document.formDelete.selectAll.checked) {\r\n");
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
      out.write("\t\t\t\toNP.outerHTML = \"<input type='text' id='\" + roleId + \"' value='\" + value + \"' size='5' onblur='change(this.roleId)'>\";\r\n");
      out.write("\t\t\t\tdocument.getElementById(id).focus();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction change(id) {\r\n");
      out.write("\t\t\t\tvar oNP = document.getElementById(id);\r\n");
      out.write("\t\t\t\tvar value = oNP.value;\r\n");
      out.write("\t\t\t\tgID = id;\r\n");
      out.write("\t\t\t\tinit();\r\n");
      out.write("\t\t\t\tvar url = \"Role_FoodModify.jsp?roleId=\" + escape(roleId) + \"&=\" + value;\r\n");
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
      out.write("\t\t\t\t\t\toNP.outerHTML = \"<span style='background:gray' id='\" + gID + \"' value='\" + value + \"' onclick='changeToInput(this.roleId)'>\" + value + \"</span>\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\t\t\t\t\r\n");
      out.write("\t\t\t}\t\t\t\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t\r\n");
      out.write("\t<body leftmargin=\"0\" rightmargin=\"0\" topmargin=\"0\" onkeydown=\"if(event.keyCode==27) return false;\">\r\n");
      out.write("\t\t<div id=\"popLayer\" style=\"position: absolute; z-index: 1000;\"class=\"cPopText\"></div>\t\r\n");
      out.write("\t\t<table style=\"table-layout: fixed;\" align=\"center\" border=\"0\"\r\n");
      out.write("\t\t\tcellpadding=\"0\" cellspacing=\"0\" width=\"97%\">\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"nav\" align=\"left\" nowrap=\"nowrap\" width=\"100%\">\r\n");
      out.write("\t\t\t\t\t<h1>\r\n");
      out.write("\t\t\t\t<span class=\"action-span\"></span><span>Echarge 管理中心  - 角色列表 </span>\r\n");
      out.write("\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<center><a href=\"Admin_AddRole.jsp\">添加角色</a></center>\r\n");
      out.write("\t\t\r\n");
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
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"Admin_RoleList.jsp?pageNo=");
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
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"Admin_RoleList.jsp?pageNo=");
      out.print(pageNo+1);
      out.write("\">&gt;</a>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"http://bbs.allsmart.com/member.php?action=list&amp;srchmem=&amp;order=&amp;roles=&amp;page=100\">&gt;<b>|</b>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</a>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"padding: 0pt;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input name=\"custompage\" size=\"2\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"border: 1px solid rgb(77, 118, 179);\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tonKeyDown=\"javascript: if(window.event.keyCode == 13) window.location='member.php?action=list&srchmem=&order=&roles=&page='+this.value;\"\r\n");
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
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<form action=\"ProductDeleteMultiple.jsp\" name=\"formDelete\" method=\"post\" target=\"detail\">\r\n");
      out.write("\t\t<table class=\"tableborder\" align=\"center\" cellpadding=\"4\"\r\n");
      out.write("\t\t\tcellspacing=\"1\" width=\"97%\">\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr class=\"header\">\r\n");
      out.write("\t\t\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t角色编号\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t角色类型\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

						for (int i = 0; i < roles.size(); i++) {
							r = roles.get(i);
				
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"altbg2\" align=\"center\" width=\"10%\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(r.getRoleID());
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"altbg1\" align=\"center\" width=\"82%\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(r.getRoleName());
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"altbg1\" align=\"center\" width=\"8%\">\r\n");
      out.write("\t\t\t\t\t\t");
 String url = request.getRequestURL() + (request.getQueryString() == null ? "" : "?" + request.getQueryString()); 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a href=\"Admin_RoleDeleteResult.jsp?roleName=");
      out.print(r.getRoleName());
      out.write("&from=");
      out.print(url);
      out.write("\" onclick=\"return confirm('真的要删除?')\">删除</a>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

				}
				 
      out.write("\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</form><!-- end formDelete -->\r\n");
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
