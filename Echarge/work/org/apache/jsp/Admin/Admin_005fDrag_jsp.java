package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Admin_005fDrag_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\" />\r\n");
      out.write("\t<meta http-equiv=\"Cache-Control\" content=\"no-cache, must-revalidate\" />\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"Wed, 26 Feb 1970 08:21:57 GMT\" />\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("\t\tbody {\r\n");
      out.write("\t\t  margin: 0;\r\n");
      out.write("\t\t  padding: 0;\r\n");
      out.write("\t\t  background: #80BDCB;\r\n");
      out.write("\t\t  cursor: E-resize;\r\n");
      out.write("\t\t}\r\n");
      out.write("    </style>\r\n");
      out.write("\t<script type=\"text/javascript\" language=\"JavaScript\">\r\n");
      out.write("    <!--\r\n");
      out.write("    var pic = new Image();\r\n");
      out.write("    pic.src=\"images/arrow_right.gif\";\r\n");
      out.write("    function toggleMenu()\r\n");
      out.write("    {\r\n");
      out.write("      frmBody = parent.document.getElementById('frame-body');\r\n");
      out.write("      imgArrow = document.getElementById('img');\r\n");
      out.write("    \r\n");
      out.write("      if (frmBody.cols == \"0, 10, *\")\r\n");
      out.write("      {\r\n");
      out.write("        frmBody.cols=\"180, 10, *\";\r\n");
      out.write("        imgArrow.src = \"images/arrow_left.gif\";\r\n");
      out.write("      }\r\n");
      out.write("      else\r\n");
      out.write("      {\r\n");
      out.write("        frmBody.cols=\"0, 10, *\";\r\n");
      out.write("        imgArrow.src = \"images/arrow_right.gif\";\r\n");
      out.write("      }\r\n");
      out.write("    }\r\n");
      out.write("    //-->\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onselect=\"return false;\">\r\n");
      out.write("<table height=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td width=\"10\" align=\"center\" valign=\"middle\"><a href=\"javascript:toggleMenu();\"><img src=\"images/arrow_left.gif\" name=\"img\" width=\"10\" height=\"30\" border=\"0\" id=\"img\" /></a></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
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
