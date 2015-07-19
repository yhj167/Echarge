package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.Echarge.admin.*;
import java.util.*;

public final class Admin_005fIndex_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n");
      out.write("  \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("  \r\n");

Admin a = (Admin)session.getAttribute("admin");
if(a == null) {
	response.sendRedirect("../Admin_Login.jsp");
	return;
}

      out.write(" \r\n");
      out.write("  \r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\" />\r\n");
      out.write("\t<meta http-equiv=\"Cache-Control\" content=\"no-cache, must-revalidate\" />\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"Wed, 26 Feb 1970 08:21:57 GMT\" />\r\n");
      out.write("\t<title>电动汽车充电站智能管理系统</title>\r\n");
      out.write("\t<frameset rows=\"76,*\" framespacing=\"0\" border=\"0\">\r\n");
      out.write("\t<frame src=\"Admin_Top.jsp\" id=\"header-frame\" name=\"header-frame\" frameborder=\"no\" scrolling=\"no\" >\r\n");
      out.write("\t\t<frameset cols=\"180, 10, *\" framespacing=\"0\" border=\"0\" id=\"frame-body\">\r\n");
      out.write("\t\t    <frame src=\"Admin_Left.jsp\" id=\"menu-frame\" name=\"menu-frame\" frameborder=\"no\" scrolling=\"yes\" ></frame>\r\n");
      out.write("\t\t    <frame src=\"Admin_Drag.jsp\" id=\"drag-frame\" name=\"drag-frame\" frameborder=\"no\" scrolling=\"no\" ></frame>\r\n");
      out.write("\t\t    <frame src=\"Admin_Main.jsp?loginName=");
      out.print(a.getLoginName());
      out.write("\" id=\"main-frame\" name=\"main-frame\" frameborder=\"no\" scrolling=\"yes\" ></frame>\r\n");
      out.write("\t\t</frameset>\r\n");
      out.write("\t</frame>\r\n");
      out.write("\t</frameset>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
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
