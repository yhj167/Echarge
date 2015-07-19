package org.apache.jsp.Equip;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.Echarge.Analysis.*;
import com.Echarge.admin.*;

public final class EquipAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");

	//检查session，查看用户是否登陆
	Admin a = (Admin) session.getAttribute("admin");
	if (a == null) {
		response.sendRedirect("../Admin_Login.jsp");
		return;
	}

      out.write('\r');
      out.write('\n');

	request.setCharacterEncoding("GBK");
	String action = request.getParameter("action");
	if (action != null && action.trim().equals("EquipAdd")) {
		//String equipName = request.getParameter("equipName");
		//String equipModel = request.getParameter("equipModel");
		String equipNo = request.getParameter("equipNo");
		String noteMsg = request.getParameter("noteMsg");
		//String intactFlag = request.getParameter("intactFlag");
		//int useNum = Integer.parseInt(request.getParameter("useNum"));
		//String rDate = request.getParameter("rDate");
		//Double useTime = Double.parseDouble(request.getParameter("useTime"));
		Analysis au = new Analysis();
		try {
			au = Analysis.checkEquipNo(equipNo);
		} catch (UserNotFoundException e) {
			out.println(e.getMessage());
			return;
		}
		au.setEquipName("充电桩");
		au.setEquipModel("cdz_1");
		au.setEquipNo(equipNo);
		au.setNoteMsg(noteMsg);
		//au.setIntactFlag("是");
		au.setUseNum(0);
		au.setrDate(new Date());
		au.setUseTime("0年0月0天0时0分0秒");
		au.save();
		response.sendRedirect("EquipAnalysis.jsp");
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\r\n");
      out.write("\t\t<title>Echarge 管理中心 - 添加设备</title>\r\n");
      out.write("\t\t<link href=\"../css/login.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t\t<link href=\"../css/page_bottom.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"../js/jquery-1.4.2.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"../js/jquery.validate.js\"></script>\r\n");
      out.write("\t\t<link href=\"../Admin/styles/main.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t\t<link href=\"../Admin/styles/general.css\" rel=\"stylesheet\" type=\"text/css\" />\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t$('#f').validate( {\r\n");
      out.write("\t\t\trules : {\r\n");
      out.write("\t\t\t\tequipName : {\r\n");
      out.write("\t\t\t\t\trequired : true,\r\n");
      out.write("\t\t\t\t\trangelength : [ 2, 12 ]\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tequipModel : {\r\n");
      out.write("\t\t\t\t\trequired : true,\r\n");
      out.write("\t\t\t\t\trangelength : [ 2, 12 ]\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tequipNo:{\r\n");
      out.write("\t\t\t\t\trequired:true,\r\n");
      out.write("\t\t\t\t\trangelength:[5,5],\r\n");
      out.write("\t\t\t\t\tdigits:true\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tintactFlag:{\r\n");
      out.write("\t\t\t\t\trequired:true\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tuseNum:{\r\n");
      out.write("\t\t\t\t\trequired:true,\r\n");
      out.write("\t\t\t\t\tdigits:true\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\trDate:{\r\n");
      out.write("\t\t\t\t\trequired:true\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tuseTime : {\r\n");
      out.write("\t\t\t\t\trequired : true,\r\n");
      out.write("\t\t\t\t\tnumber:true\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tmessages : {\r\n");
      out.write("\t\t\t\tequipName : {\r\n");
      out.write("\t\t\t\t\trequired : \"设备名称不能为空\",\r\n");
      out.write("\t\t\t\t\trangelength : \"设备名称应为2-12位之间\"\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tequipModel : {\r\n");
      out.write("\t\t\t\t\trequired : \"设备型号不能为空\",\r\n");
      out.write("\t\t\t\t\trangelength : \"说明型号应为2-12位之间\"\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tequipNo:{\r\n");
      out.write("\t\t\t\t\trequired:\"设备编号不能为空\",\r\n");
      out.write("\t\t\t\t\trangelength:\"设备编号应为5位\",\r\n");
      out.write("\t\t\t\t\tdigits:\"必须是整数数字\"\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tintactFlag:{\r\n");
      out.write("\t\t\t\t\trequired:\"请选择设备状态。\"\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tuseNum:{\r\n");
      out.write("\t\t\t\t\trequired:\"设备使用次数不能为空\",\r\n");
      out.write("\t\t\t\t\tdigits:\"设备使用次数为整数数字\"\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\trDate:{\r\n");
      out.write("\t\t\t\t\trequired:\"设备注册时间不能为空\"\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tuseTime : {\r\n");
      out.write("\t\t\t\t\trequired:\"设备使用时间不能为空\",\r\n");
      out.write("\t\t\t\t\tnumber:\"设备使用时间为十进制数字（包括小数）\"\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terrorPlacement : function(error, element) {\r\n");
      out.write("\t\t\t\terror.appendTo(element.next().find(\"span\"));\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\t\t<script language=\"javascript\">\r\n");
      out.write("\tdocument.form1.loginName.focus;\r\n");
      out.write("\tfunction CheckForm() {\r\n");
      out.write("\t\tvar theform = document.form1;\r\n");
      out.write("\t\tif (theform['equipName'].value == \"\") {\r\n");
      out.write("\t\t\talert(\"设备名称不能为空!\");\r\n");
      out.write("\t\t\ttheform.equipName.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (theform['equipNo'].value == \"\") {\r\n");
      out.write("\t\t\talert(\"设备编号不能为空!\");\r\n");
      out.write("\t\t\ttheform.equipNo.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (theform['firstTime'].value == \"\") {\r\n");
      out.write("\t\t\talert(\"开始时间不能为空!\");\r\n");
      out.write("\t\t\ttheform.firstTime.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\t\t\r\n");
      out.write("\t\tif (theform['lastTime'].value == \"\") {\r\n");
      out.write("\t\t\talert(\"结束时间不能为空!\");\r\n");
      out.write("\t\t\ttheform.lastTime.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t<table style=\"table-layout: fixed;\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"97%\">\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"nav\" align=\"left\" nowrap=\"nowrap\" width=\"100%\">\r\n");
      out.write("\t\t\t\t\t<h1>\r\n");
      out.write("\t\t\t<span class=\"action-span\"></span><span>Echarge 管理中心 - 添加设备</span>\r\n");
      out.write("\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"fill_message\">\r\n");
      out.write("\t\t\t<form name=\"form1\" method=\"post\" action=\"EquipAdd.jsp\" id=\"f\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"action\" value=\"EquipAdd\" />\r\n");
      out.write("\t\t\t\t<table class=\"tab_login\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td valign=\"top\" class=\"w1\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"mcname\" style=\"color:red\">*</span>\r\n");
      out.write("\t\t\t\t\t\t\t请填写充电桩号:\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"equipNo\" type=\"text\" id=\"equipNo\" class=\"text_input\" />\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text_left\" id=\"equipNoValidMsg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t设备编号由5位整数数字组成，前三位表示设备种类，后两位表示设备号。\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"name.info\" style=\"color: red\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td valign=\"top\" class=\"w1\">\r\n");
      out.write("\t\t\t\t\t\t\t备注:\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"noteMsg\" type=\"text\" id=\"noteMsg\" class=\"text_input\" />\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text_left\" id=\"useNumValidMsg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"name.info\" style=\"color: red\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<!--\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td valign=\"top\" class=\"w1\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"mcname\" style=\"color:red\">*</span>\r\n");
      out.write("\t\t\t\t\t\t\t设备是否可用:\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<select name=\"intactFlag\" class=\"text_input\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"\">请选择</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"是\">是</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"否\">否</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text_left\" id=\"intactFlagValidMsg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&nbsp;请选择设备状态。\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"name.info\" style=\"color: red\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td valign=\"top\" class=\"w1\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"mcname\" style=\"color:red\">*</span>\r\n");
      out.write("\t\t\t\t\t\t\t设备使用次数:\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"useNum\" type=\"text\" id=\"useNum\" class=\"text_input\" />\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text_left\" id=\"useNumValidMsg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t设备使用次数由整数数字组成。\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"name.info\" style=\"color: red\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td valign=\"top\" class=\"w1\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"mcname\" style=\"color:red\">*</span>\r\n");
      out.write("\t\t\t\t\t\t\t设备注册日期:\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"rDate\" type=\"text\" class=\"text_input\" />\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text_left\" id=\"rDateValidMsg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t时间填写格式为:YYYY-MM-DD。\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"name.info\" style=\"color: red\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td valign=\"top\" class=\"w1\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"mcname\" style=\"color:red\">*</span>\r\n");
      out.write("\t\t\t\t\t\t\t设备使用时间（月）:\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"useTime\" type=\"text\" id=\"useTime\" class=\"text_input\" />\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text_left\" id=\"useTimeValidMsg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t设备使用时间由浮点型数字组成。\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"name.info\" style=\"color: red\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>-->\r\n");
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
