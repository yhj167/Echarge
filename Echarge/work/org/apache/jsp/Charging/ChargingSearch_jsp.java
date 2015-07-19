package org.apache.jsp.Charging;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.Echarge.admin.*;
import com.Echarge.Charging.*;

public final class ChargingSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	String action = request.getParameter("action");
	if (action != null && action.trim().equals("ChargingSearch")) {
		int ID =  Integer.parseInt(request.getParameter("ID"));
		Charging c = null;
		try {
			c = ChargingMgr.getInstance().checkID(ID);
		} catch (UserNotFoundException e) {
			out.println(e.getMessage());
			return;
		}
		session.setAttribute("Charging", c);
		response.sendRedirect("ChargingInfo.jsp");
	}

      out.write("\r\n");
      out.write(" \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\r\n");
      out.write("\t<title>Echarge 管理中心 - 充电记录查询</title>\r\n");
      out.write("\t\t<link href=\"../css/login.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t\t<link href=\"../css/page_bottom.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"../js/jquery-1.4.2.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"../js/jquery.validate.js\"></script>\r\n");
      out.write("\t\t<link href=\"../Admin/styles/main.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t\t<link href=\"../Admin/styles/general.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t$('#f').validate( {\r\n");
      out.write("\t\t\trules : {\r\n");
      out.write("\t\t\t\tID : {\r\n");
      out.write("\t\t\t\t\trequired : true\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tmessages : {\r\n");
      out.write("\t\t\t\tID : {\r\n");
      out.write("\t\t\t\t\trequired : \"充电编号不能为空\"\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terrorPlacement : function(error, element) {\r\n");
      out.write("\t\t\t\terror.appendTo(element.next().find(\"span\"));\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<script language=\"javascript\">\r\n");
      out.write("document.form1.ID.focus;\r\n");
      out.write("function CheckForm(){\r\n");
      out.write(" var theform = document.form1;\r\n");
      out.write(" \r\n");
      out.write(" if (theform['ID'].value == \"\") {\r\n");
      out.write("    alert(\"充电编号不能为空!\");\r\n");
      out.write("  \ttheform.ID.focus();\r\n");
      out.write("  \treturn false;\r\n");
      out.write(" }\r\n");
      out.write(" return true;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\t<table style=\"table-layout: fixed;\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"97%\">\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"nav\" align=\"left\" nowrap=\"nowrap\" width=\"100%\">\r\n");
      out.write("\t\t\t\t\t<h1>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"action-span\"></span><span>Echarge 管理中心 - 充电记录查询</span>\r\n");
      out.write("\t\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"fill_message\">\r\n");
      out.write("\t\t\t<form name=\"form1\" method=\"post\" action=\"ChargingInfo.jsp\" id=\"f\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"action\" value=\"ChargingSearch\" />\r\n");
      out.write("\t\t\t\t<table class=\"tab_login\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td valign=\"top\" class=\"w1\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"mcname\" style=\"color:red\">*</span>\r\n");
      out.write("\t\t\t\t\t\t\t请填写充电编号:\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"ID\" type=\"text\" id=\"txtID\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"text_input\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text_left\" id=\"IDValidMsg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t请填写正确的充电编号。\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"name.info\" style=\"color: red\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t<table align=\"center\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"提交\"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t<input type=\"reset\" value=\"重填\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
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
