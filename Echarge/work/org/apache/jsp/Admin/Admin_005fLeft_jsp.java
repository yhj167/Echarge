package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.Echarge.Authority.*;
import com.Echarge.admin.*;

public final class Admin_005fLeft_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	//检查session，获取登录用户
	Admin a = (Admin) session.getAttribute("admin");
	String roleName = a.getAdminType();
	
	List<Authority> authoritys = new ArrayList<Authority>();
	int totalRecords = Authority.getAuthoritys1(authoritys, roleName);
	//指定角色的 权限信息列表，按一级菜单合并
	

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\" />\r\n");
      out.write("\t<meta http-equiv=\"Cache-Control\" content=\"no-cache, must-revalidate\" />\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"Wed, 26 Feb 1970 08:21:57 GMT\" />\r\n");
      out.write("\t<title>Echarge Menu</title>\r\n");
      out.write("\t<link href=\"styles/general.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("    body {\r\n");
      out.write("      background: #80BDCB;\r\n");
      out.write("    }\r\n");
      out.write("    #tabbar-div {\r\n");
      out.write("      background: #278296;\r\n");
      out.write("      padding-left: 10px;\r\n");
      out.write("      height: 21px;\r\n");
      out.write("      padding-top: 0px;\r\n");
      out.write("    }\r\n");
      out.write("    #tabbar-div p {\r\n");
      out.write("      margin: 1px 0 0 0;\r\n");
      out.write("    }\r\n");
      out.write("    .tab-front {\r\n");
      out.write("      background: #80BDCB;\r\n");
      out.write("      line-height: 20px;\r\n");
      out.write("      font-weight: bold;\r\n");
      out.write("      padding: 4px 15px 4px 18px;\r\n");
      out.write("      border-right: 2px solid #335b64;\r\n");
      out.write("      cursor: hand;\r\n");
      out.write("      cursor: pointer;\r\n");
      out.write("    }\r\n");
      out.write("    #main-div {\r\n");
      out.write("      border: 1px solid #345C65;\r\n");
      out.write("      padding: 5px;\r\n");
      out.write("      margin: 5px;\r\n");
      out.write("      background: #FFF;\r\n");
      out.write("    }\r\n");
      out.write("    #menu-list {\r\n");
      out.write("      padding: 0;\r\n");
      out.write("      margin: 0;\r\n");
      out.write("    }\r\n");
      out.write("    #menu-list ul {\r\n");
      out.write("      padding: 0;\r\n");
      out.write("      margin: 0;\r\n");
      out.write("      list-style-type: none;\r\n");
      out.write("      color: #335B64;\r\n");
      out.write("    }\r\n");
      out.write("    #menu-list li {\r\n");
      out.write("      padding-left: 16px;\r\n");
      out.write("      line-height: 16px;\r\n");
      out.write("      cursor: hand;\r\n");
      out.write("      cursor: pointer;\r\n");
      out.write("    }\r\n");
      out.write("    #main-div a:visited, #menu-list a:link, #menu-list a:hover {\r\n");
      out.write("      color: #335B64\r\n");
      out.write("      text-decoration: none;\r\n");
      out.write("    }\r\n");
      out.write("    #menu-list a:active {\r\n");
      out.write("      color: #EB8A3D;\r\n");
      out.write("    }\r\n");
      out.write("    .explode {\r\n");
      out.write("      background: url(images/menu_minus.gif) no-repeat 0px 3px;\r\n");
      out.write("      font-weight: bold;\r\n");
      out.write("    }\r\n");
      out.write("    .collapse {\r\n");
      out.write("\t  background: url(images/menu_plus.gif) no-repeat 0px 3px;\r\n");
      out.write("  \t  font-weight: bold;\r\n");
      out.write("\t}\r\n");
      out.write("    .menu-item {\r\n");
      out.write("      background: url(images/menu_arrow.gif) no-repeat 0px 3px;\r\n");
      out.write("      font-weight: normal;\r\n");
      out.write("    }\r\n");
      out.write("    </style>\r\n");
      out.write("\r\n");
      out.write("\t</head>\r\n");
      out.write("<body> \r\n");
      out.write("<div id=\"tabbar-div\">\r\n");
      out.write("<p><span style=\"float:right; padding: 3px 5px;\" >\r\n");
      out.write("<img src=\"images/menu_minus.gif\" alt=\"闭合\" name=\"toggleImg\" width=\"9\" height=\"9\" border=\"0\" id=\"toggleImg\" style=\"cursor: hand;\" />\r\n");
      out.write("</span>\r\n");
      out.write("  <span class=\"tab-front\" id=\"menu-tab\">菜单</span></p>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"main-div\">\r\n");
      out.write("\t\t\t<div class=\"menu-item\" id=\"menu-list\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t");

					for (int i = 0; i < authoritys.size(); i++){
    					Authority au = authoritys.get(i);
    					String lev1Menu = au.getLev1Menu();
   						if(au.getMenuFlag()==1){
    				
      out.write("\r\n");
      out.write("\t\t\t\t\t<li class=\"explode\" id=\"img_");
      out.print(i);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t<span onclick=\"toggleCollapse(");
      out.print(i);
      out.write(");\">");
      out.print(lev1Menu);
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t<ul id=\"collapse_");
      out.print(i);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t");

							List<Authority> authoritys2 = new ArrayList<Authority>();
							int totalRecords2 = Authority.getAuthoritys2(authoritys2, roleName, lev1Menu);
							//指定角色的 权限信息列表，指定一级菜单
							for (int j = 0; j < authoritys2.size(); j++){
   								Authority au2 = authoritys2.get(j);
   								if(au2.getMenuFlag()==1){
    						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"menu-item\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"");
      out.print(au2.getMenuLink());
      out.write("\" target=\"main-frame\">");
      out.print(au2.getLev2Menu());
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t");

								}
							}
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t");

						}
					}
					
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t<script language=\"javascript\">\r\n");
      out.write("\tdocument.getElementById('toggleImg').onclick = function() {\r\n");
      out.write("\t  var h = -1;\r\n");
      out.write("\t  if(document.getElementById('toggleImg').alt == \"展开\") {\r\n");
      out.write("\t \t  for(h=0;h<");
      out.print(authoritys.size());
      out.write(";h++){\r\n");
      out.write("\t\t \t  var item = document.getElementById('collapse_'+h);\r\n");
      out.write("\t\t \t  var explodebg = document.getElementById('img_'+h);\r\n");
      out.write("\t\t \t  item.style.display = \"\";\r\n");
      out.write("\t\t \t  document.getElementById('toggleImg').src='images/menu_minus.gif';\r\n");
      out.write("\t\t \t  document.getElementById('toggleImg').alt='闭合';\r\n");
      out.write("\t\t \t  explodebg.className=\"explode\";\r\n");
      out.write("\t \t  }\r\n");
      out.write("\t  } else {\r\n");
      out.write("\t \t  for(h=0;h<");
      out.print(authoritys.size());
      out.write(";h++){\r\n");
      out.write("\t\t \t  var item = document.getElementById('collapse_'+h);\r\n");
      out.write("\t\t \t  var explodebg = document.getElementById('img_'+h);\r\n");
      out.write("\t\t \t  item.style.display = \"none\";\r\n");
      out.write("\t\t \t  document.getElementById('toggleImg').src='images/menu_plus.gif';\r\n");
      out.write("\t\t \t  document.getElementById('toggleImg').alt='展开';\r\n");
      out.write("\t\t \t  explodebg.className=\"collapse\";\r\n");
      out.write("\t \t  }\r\n");
      out.write("\t   }\r\n");
      out.write("\t }\r\n");
      out.write(" \t\r\n");
      out.write(" \tfunction toggleCollapse(e){\r\n");
      out.write(" \t\t  var item = document.getElementById('collapse_'+e);\r\n");
      out.write("\t \t  var explodebg = document.getElementById('img_'+e);\r\n");
      out.write("\t \t  if(item.style.display == \"none\") {\r\n");
      out.write("\t \t  \titem.style.display = \"\";\r\n");
      out.write("\t \t  \texplodebg.className=\"explode\";\r\n");
      out.write("\t \t  } else {\r\n");
      out.write("\t \t  \titem.style.display =\"none\";\r\n");
      out.write("\t \t  \texplodebg.className=\"collapse\";\r\n");
      out.write("\t \t  }\r\n");
      out.write(" \t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
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
