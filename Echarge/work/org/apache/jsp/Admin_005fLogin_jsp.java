package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.Echarge.admin.*;
import java.sql.*;

public final class Admin_005fLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=gb2312");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	String action = request.getParameter("action");
	if (action != null && action.equals("adminLogin")) {
		String loginName = request.getParameter("loginName");
		String loginPwd = request.getParameter("loginPwd");
		Admin a = null;
		try {
			a = Admin.check(loginName, loginPwd);
		} catch (UserNotFoundException e) {
			out.println(e.getMessage());
			return;
		} catch (PasswordNotCorrectException e) {
			out.println(e.getMessage());
			return;
		}
		session.setAttribute("admin", a);
		response.sendRedirect("Admin/Admin_Index.jsp");

		/*
		if (!loginName.equals("admin") || !loginPwd.equals("admin")) {
			out.println("username or password not correct!");
			return;
		}
		session.setAttribute("admin", "admin");
		response.sendRedirect("Admin_Index.jsp");
		 */
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>管理员登陆</title>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\r\n");
      out.write("\t\t<style type=\"text/css\">\r\n");
      out.write("body {\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\t\t<script language=\"javascript\">\r\n");
      out.write("\t\t<!--start_of_saved_settings-->\r\n");
      out.write("<!--type,text,name,loginName,required,true,errMsg,用户名不能为空!-->\r\n");
      out.write("<!--type,password,name,loginPwd,required,true,errMsg,密码不能为空!-->\r\n");
      out.write("<!--end_of_saved_settings-->\r\n");
      out.write("document.form1.loginName.focus();\r\n");
      out.write("function CheckForm(){ \r\n");
      out.write(" var f = document.form1;\r\n");
      out.write("  if (f.loginName.value == \"\") {\r\n");
      out.write("    alert(\"用户名不能为空!\");\r\n");
      out.write("    f.loginName.value='';\r\n");
      out.write("  \tf.loginName.focus();\r\n");
      out.write("\treturn false; \r\n");
      out.write(" }\r\n");
      out.write(" \r\n");
      out.write(" if (f.loginPwd.value == \"\") {\r\n");
      out.write("    alert(\"密码不能为空!\");\r\n");
      out.write("    f.loginPwd.value == '';\r\n");
      out.write("  \tf.loginPwd.focus();\r\n");
      out.write("\treturn false; \r\n");
      out.write(" }\r\n");
      out.write(" return true;\r\n");
      out.write("} \r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body style=\"background: #278296\">\r\n");
      out.write("\t\t<form method=\"post\" name=\"form1\" action=\"Admin_Login.jsp\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"action\" value=\"adminLogin\" />\r\n");
      out.write("\t\t\t<table cellspacing=\"0\" cellpadding=\"0\" style=\"margin-top: 100px\"\r\n");
      out.write("\t\t\t\talign=\"center\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"2\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"Admin/images/logo.gif\" width=\"346\" height=\"60\"\r\n");
      out.write("\t\t\t\t\t\t\talign=\"middle\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<img src=\"Admin/images/login.jpg\" width=\"178\" height=\"256\" border=\"0\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"padding-left: 50px\">\r\n");
      out.write("\t\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t用户名：\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" size=\"20\" name=\"loginName\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t密码：\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"password\" size=\"21\" name=\"loginPwd\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<!-- <tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"1\" name=\"remember\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<font size=2>请保存我这次的登录信息。</font>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr> -->\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type=\"submit\" value=\"进入管理中心\" onclick=\"return CheckForm()\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\r\n");
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
