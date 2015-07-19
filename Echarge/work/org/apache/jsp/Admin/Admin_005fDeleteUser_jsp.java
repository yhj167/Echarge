package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.Echarge.admin.*;

public final class Admin_005fDeleteUser_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\r\n");
      out.write("\t\t<title>Echarge 管理中心 - 删除用户</title>\r\n");
      out.write("\t\t\r\n");
      out.write("\t<link href=\"../css/login.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t\t<link href=\"../css/page_bottom.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"../js/jquery-1.4.2.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"../js/jquery.validate.js\"></script>\r\n");
      out.write("\t\t<link href=\"styles/main.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t\t<link href=\"styles/general.css\" rel=\"stylesheet\" type=\"text/css\" />\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t$('#f').validate( {\r\n");
      out.write("\t\t\trules : {\r\n");
      out.write("\t\t\t\tloginName : {\r\n");
      out.write("\t\t\t\t\trequired : true,\r\n");
      out.write("\t\t\t\t\trangelength : [ 3, 12 ]\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tmessages : {\r\n");
      out.write("\t\t\t\tloginName : {\r\n");
      out.write("\t\t\t\t\trequired : \"账号不能为空\",\r\n");
      out.write("\t\t\t\t\trangelength : \"账号应为3-12位之间\"\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terrorPlacement : function(error, element) {\r\n");
      out.write("\t\t\t\terror.appendTo(element.next().find(\"span\"));\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\t<table style=\"table-layout: fixed;\" align=\"center\" border=\"0\"\r\n");
      out.write("\t\t\tcellpadding=\"0\" cellspacing=\"0\" width=\"97%\">\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"nav\" align=\"left\" nowrap=\"nowrap\" width=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t<h1>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"action-span\"></span><span>Echarge 管理中心 - 删除用户</span>\r\n");
      out.write("\t\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("<div class=\"fill_message\">\r\n");
      out.write("\t\t\t<form name=\"form1\" method=\"post\" action=\"Admin_DeleteResult.jsp\" id=\"f\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"action\" value=\"DeleteUser\" />\r\n");
      out.write("\t\t\t\t<table class=\"tab_login\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td valign=\"top\" class=\"w1\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"mcname\" style=\"color:red\">*</span>\r\n");
      out.write("\t\t\t\t\t\t\t请输入用户账号:\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"loginName\" type=\"text\" id=\"txtLoginName\" class=\"text_input\" />\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text_left\" id=\"loginNameValidMsg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t用户账号可以由小写英文字母、中文、数字组成，长度3－12个字符，一个汉字为一个字符。\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"name.info\" style=\"color: red\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t<table align=\"center\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"提交\" onclick=\"return confirm('真的要删除?')\"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t<input type=\"reset\" value=\"重填\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
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
