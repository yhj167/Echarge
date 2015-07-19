package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.Echarge.admin.*;
import java.util.*;

public final class Admin_005fMain_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

	String loginName = request.getParameter("loginName");
	try {
		a = Admin.checkName(loginName);
	} catch (UserNotFoundException e) {
		out.println(e.getMessage());
		return;
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n");
      out.write("  \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\" />\r\n");
      out.write("\t<meta http-equiv=\"Cache-Control\" content=\"no-cache, must-revalidate\" />\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"Wed, 26 Feb 1970 08:21:57 GMT\" />\r\n");
      out.write("\t<title>电动汽车智能充电系统</title>\r\n");
      out.write("\t<link href=\"styles/general.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"styles/main.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>\r\n");
      out.write("<span>Echarge V1.0</span></h1>\r\n");
      out.write("<div class=\"list-div\">\r\n");
      out.write("<table cellspacing='1' cellpadding='3' width=\"1079\" border=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <th colspan=\"4\"  class=\"group-title\">系统信息</th>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"20%\" align=\"right\" >服务器操作系统：</td>\r\n");
      out.write("    <td width=\"30%\" >Windows XP</td>\r\n");
      out.write("    <td width=\"20%\" align=\"right\" >服务器：</td>\r\n");
      out.write("    <td width=\"30%\" >Apache Tomcat 5.5</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"20%\" align=\"right\" >当前用户：</td>\r\n");
      out.write("    <td width=\"30%\" >");
      out.print(a.getLoginName());
      out.write("</td>\r\n");
      out.write("    <td width=\"20%\" align=\"right\" >登录时间：</td>\r\n");
      out.write("    <td width=\"30%\" >");
      out.print(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(session.getCreationTime()));
      out.write("</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"footer\"></div>\r\n");
      out.write("</body>\r\n");
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
