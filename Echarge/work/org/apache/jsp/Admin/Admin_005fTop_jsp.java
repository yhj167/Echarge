package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.Echarge.admin.*;
import java.util.*;

public final class Admin_005fTop_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=gb2312");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n");
      out.write("  \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\" />\r\n");
      out.write("\t<meta http-equiv=\"Cache-Control\" content=\"no-cache, must-revalidate\" />\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"Wed, 26 Feb 1970 08:21:57 GMT\" />\r\n");
      out.write("\t<title></title>\r\n");
      out.write("\t<link href=\"styles/general.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("    #header-div {\r\n");
      out.write("      background: #278296;\r\n");
      out.write("      border-bottom: 1px solid #FFF;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    #logo-div {\r\n");
      out.write("      height: 50px;\r\n");
      out.write("      float: left;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    #submenu-div {\r\n");
      out.write("      height: 50px;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    #submenu-div ul {\r\n");
      out.write("      margin: 0;\r\n");
      out.write("      padding: 0;\r\n");
      out.write("      list-style-type: none;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    #submenu-div li {\r\n");
      out.write("      float: right;\r\n");
      out.write("      padding: 0 10px;\r\n");
      out.write("      margin: 5px 0;\r\n");
      out.write("      border-left: 1px solid #FFF;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    #submenu-div a:visited, #submenu-div a:link {\r\n");
      out.write("      color: #FFF;\r\n");
      out.write("      text-decoration: none;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    #submenu-div a:hover {\r\n");
      out.write("      color: #F5C29A;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    #loading-div {\r\n");
      out.write("      clear: right;\r\n");
      out.write("      text-align: right;\r\n");
      out.write("      display: block;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    #menu-div {\r\n");
      out.write("      background: #80BDCB;\r\n");
      out.write("      font-weight: bold;\r\n");
      out.write("      padding-left: 30px;\r\n");
      out.write("      height: 24px;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    #menu-div ul {\r\n");
      out.write("      margin: 0;\r\n");
      out.write("      padding: 0;\r\n");
      out.write("      list-style-type: none;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    #menu-div li {\r\n");
      out.write("      float: left;\r\n");
      out.write("      padding: 0 20px;\r\n");
      out.write("      margin: 5px 0;\r\n");
      out.write("      border-right: 1px solid #192E32;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    #menu-div a:visited, #menu-div a:link {\r\n");
      out.write("      text-decoration: none;\r\n");
      out.write("      color: #335B64;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    #menu-div a:hover {\r\n");
      out.write("      color: #F5C29A;\r\n");
      out.write("    }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\t<div id=\"header-div\">\r\n");
      out.write("\t\t\t<div id=\"submenu-div\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li style=\"float: right; border-right: 0;\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/Echarge/Admin_Login.jsp\" target=\"_top\">退出</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"../Help.jsp\" target=\"main-frame\">帮助</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"Admin_Setting.jsp?loginName=");
      out.print(a.getLoginName());
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\ttarget=\"main-frame\">设置</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:history.go(-1)\" target=\"_blank\">返回</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:window.top.frames['main-frame'].document.location.reload();window.top.frames['header-frame'].document.location.reload()\">刷新</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"menu-div\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<a href=\"Admin_Main.jsp?loginName=");
      out.print(a.getLoginName());
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\ttarget=\"main-frame\">起始页</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
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
