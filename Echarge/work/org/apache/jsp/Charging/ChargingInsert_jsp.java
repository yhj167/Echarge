package org.apache.jsp.Charging;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.Echarge.Charging.*;
import com.Echarge.admin.*;
import com.Echarge.Rate.*;
import com.Echarge.User.*;
import com.Echarge.Analysis.*;
import java.text.SimpleDateFormat;

public final class ChargingInsert_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	if (action != null && action.trim().equals("ChargingInsert")) {
		String clientAccount = request.getParameter("clientAccount");
		User u = null;
		try {
			u = User.checkAccount(clientAccount);
		} catch (UserNotFoundException e) {
			out.println(e.getMessage());
			return;
		}
		String machineNo = request.getParameter("machineNo");
		Analysis an = null;
		try {
			an = Analysis.checkMachineNo(machineNo);
		} catch (UserNotFoundException e) {
			out.println(e.getMessage());
			return;
		}
		Double elecQuantity = Double.parseDouble(request.getParameter("elecQuantity"));
		Double rateValue = Double.parseDouble(request.getParameter("rateValue"));
		//Double cost = Double.parseDouble(request.getParameter("cost"));
		//Double theBalance = Double.parseDouble(request.getParameter("theBalance"));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		//Date chargingTime = df.parse(request.getParameter("chargingTime"));
		Date startTime = df.parse(request.getParameter("startTime"));
		Date endTime = df.parse(request.getParameter("endTime"));
		Charging c = new Charging();
		c.setClientAccount(clientAccount);
		c.setMachineNo(machineNo);
		c.setElecQuantity(elecQuantity);
		Double cost = elecQuantity * rateValue;//充电费用等于费率乘充电量
		Double cardBalance = u.getCardBalance();//客户余额
		Double theBalance = cardBalance - cost;//当时余额等于客户余额减充电费用
		String chargingTime = ChargingMgr.getInstance().calcChargingTime(startTime,endTime);
		//充电时间等于结束时间减开始时间
		c.setCost(cost);
		c.setTheBalance(theBalance);
		c.setChargingTime(chargingTime);
		c.setStartTime(startTime);
		c.setEndTime(endTime);
		ChargingMgr.getInstance().save(c);
		out.println("录入成功!");
		response.sendRedirect("ChargingList.jsp");
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\r\n");
      out.write("\t\t<title>Echarge 管理中心 - 充电记录录入</title>\r\n");
      out.write("\t\t<link href=\"../css/login.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t\t<link href=\"../css/page_bottom.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"../js/jquery-1.4.2.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"../js/jquery.validate.js\"></script>\r\n");
      out.write("\t\t<link href=\"../Admin/styles/main.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t\t<link href=\"../Admin/styles/general.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t$('#f').validate( {\r\n");
      out.write("\t\t\trules : {\r\n");
      out.write("\t\t\t\tclientAccount : {\r\n");
      out.write("\t\t\t\t\trequired : true,\r\n");
      out.write("\t\t\t\t\trangelength : [ 3, 12 ]\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tmachineNo : {\r\n");
      out.write("\t\t\t\t\trequired : true,\r\n");
      out.write("\t\t\t\t\trangelength : [ 5, 5 ]\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\trateValue : {\r\n");
      out.write("\t\t\t\t\trequired : true\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\telecQuantity : {\r\n");
      out.write("\t\t\t\t\trequired : true,\r\n");
      out.write("\t\t\t\t\tnumber:true\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tstartTime : {\r\n");
      out.write("\t\t\t\t\trequired : true,\r\n");
      out.write("\t\t\t\t\trangelength : [ 16, 16 ]\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tendTime : {\r\n");
      out.write("\t\t\t\t\trequired : true,\r\n");
      out.write("\t\t\t\t\trangelength : [ 16, 16 ]\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tcFlag : {\r\n");
      out.write("\t\t\t\t\trequired : true\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tmessages : {\r\n");
      out.write("\t\t\t\tclientAccount : {\r\n");
      out.write("\t\t\t\t\trequired : \"客户账号不能为空\",\r\n");
      out.write("\t\t\t\t\trangelength : \"客户账号应为3-12位之间\",\r\n");
      out.write("\t\t\t\t\tremote : \"客户账号已被占用\"\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tmachineNo : {\r\n");
      out.write("\t\t\t\t\trequired : \"充电桩号不能为空\",\r\n");
      out.write("\t\t\t\t\trangelength : \"充电桩号应为5位\"\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\trateValue : {\r\n");
      out.write("\t\t\t\t\trequired : \"费率不能为空\"\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\telecQuantity : {\r\n");
      out.write("\t\t\t\t\trequired : \"充电量不能为空\",\r\n");
      out.write("\t\t\t\t\tnumber: \"必须是浮点型数字\"\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tstartTime:{\r\n");
      out.write("\t\t\t\t\trequired:\"开始时间不能为空\",\r\n");
      out.write("\t\t\t\t\trangelength: \"请填写正确的格式\"\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tendTime:{\r\n");
      out.write("\t\t\t\t\trequired : \"结束时间不能为空\",\r\n");
      out.write("\t\t\t\t\trangelength: \"请填写正确的格式\"\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tcFlag:{\r\n");
      out.write("\t\t\t\t\trequired : \"有效标志不能为空\"\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terrorPlacement : function(error, element) {\r\n");
      out.write("\t\t\t\terror.appendTo(element.next().find(\"span\"));\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script language=\"javascript\">\r\n");
      out.write("\tdocument.form1.loginName.focus;\r\n");
      out.write("\tfunction CheckForm() {\r\n");
      out.write("\t\tvar theform = document.form1;\r\n");
      out.write("\t\tif (theform['loginName'].value == \"\") {\r\n");
      out.write("\t\t\talert(\"操作员账号不能为空!\");\r\n");
      out.write("\t\t\ttheform.loginName.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (theform['clientAccount'].value == \"\") {\r\n");
      out.write("\t\t\talert(\"客户账号不能为空!\");\r\n");
      out.write("\t\t\ttheform.clientAccount.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (theform['clientName'].value == \"\") {\r\n");
      out.write("\t\t\talert(\"客户姓名不能为空!\");\r\n");
      out.write("\t\t\ttheform.clientName.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (theform['servFlag'].value == \"\") {\r\n");
      out.write("\t\t\talert(\"服务类型不能为空!\");\r\n");
      out.write("\t\t\ttheform.servFlag.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (theform['jtfFlag'].value == \"\") {\r\n");
      out.write("\t\t\talert(\"费用类型不能为空!\");\r\n");
      out.write("\t\t\ttheform.jtfFlag.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (theform['jtfMoney'].value == \"\") {\r\n");
      out.write("\t\t\talert(\"费用不能为空!\");\r\n");
      out.write("\t\t\ttheform.jtfMoney.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (theform['thenBalance'].value == \"\") {\r\n");
      out.write("\t\t\talert(\"当时余额不能为空!\");\r\n");
      out.write("\t\t\ttheform.thenBalance.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<table style=\"table-layout: fixed;\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"97%\">\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"nav\" align=\"left\" nowrap=\"nowrap\" width=\"100%\">\r\n");
      out.write("\t\t\t\t\t<h1>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"action-span\"></span><span>Echarge 管理中心 - 充电记录录入</span>\r\n");
      out.write("\t\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"fill_message\">\r\n");
      out.write("\t\t\t<form name=\"form1\" method=\"post\" action=\"ChargingInsert.jsp\" id=\"f\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"action\" value=\"ChargingInsert\" />\r\n");
      out.write("\t\t\t\t<table class=\"tab_login\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td valign=\"top\" class=\"w1\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"mcname\" style=\"color:red\">*</span>\r\n");
      out.write("\t\t\t\t\t\t\t客户账号:\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"clientAccount\" type=\"text\" id=\"txtclientAccount\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"text_input\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text_left\" id=\"clientAccountValidMsg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t客户账号可以由小写英文字母、中文、数字组成，长度3－12个字符，一个汉字为一个字符。\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"name.info\" style=\"color: red\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td valign=\"top\" class=\"w1\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"mcname\" style=\"color:red\">*</span>\r\n");
      out.write("\t\t\t\t\t\t\t充电桩号:\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"machineNo\" type=\"text\" id=\"txtclientName\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"text_input\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text_left\" id=\"clientNameValidMsg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t充电桩号由5位整数数字组成，前三位表示设备种类，后两位表示设备号。 \r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"name.info\" style=\"color: red\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td valign=\"top\" class=\"w1\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"mcname\" style=\"color:red\">*</span>\r\n");
      out.write("\t\t\t\t\t\t\t充电量（度）:\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"elecQuantity\" type=\"text\" id=\"txtjtfMoney\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"text_input\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text_left\" id=\"jtfMoneyValidMsg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t充电量可以为整数或者小数。\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"name.info\" style=\"color: red\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<!-- <tr>\r\n");
      out.write("\t\t\t\t\t\t<td valign=\"top\" class=\"w1\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"mcname\" style=\"color:red\">*</span>\r\n");
      out.write("\t\t\t\t\t\t\t费率（元/度）:\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<select name=\"rateValue\"  class=\"text_input\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t请选择\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");

									List<Rate> rates = new ArrayList<Rate>();
									Rate.getRates(rates, 1, 100);
									for (int i = 0; i < rates.size(); i++) {
										Rate r = rates.get(i);
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"");
      out.print(r.getRateValue());
      out.write('"');
      out.write('>');
      out.print(r.getRateValue());
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");

									}
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text_left\" id=\"jtfMoneyValidMsg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"name.info\" style=\"color: red\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr style=\"overflow:hidden;\">\r\n");
      out.write("\t\t\t\t\t\t<td valign=\"top\" class=\"w1\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"mcname\" style=\"color:red\">*</span>\r\n");
      out.write("\t\t\t\t\t\t\t充电费用（元） :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"cost\" type=\"text\" id=\"txtjtfMoney\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"text_input\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text_left\" id=\"jtfMoneyValidMsg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t充电费用可以为整数或者小数。\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"name.info\" style=\"color: red\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td valign=\"top\" class=\"w1\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"mcname\" style=\"color:red\">*</span>\r\n");
      out.write("\t\t\t\t\t\t\t当时余额（元） :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"theBalance\" type=\"text\" id=\"txttheBalance\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"text_input\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text_left\" id=\"theBalanceValidMsg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t当时余额可以为整数或者小数。\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"name.info\" style=\"color: red\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td valign=\"top\" class=\"w1\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"mcname\" style=\"color:red\">*</span>\r\n");
      out.write("\t\t\t\t\t\t\t充电时间:\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"chargingTime\" type=\"text\" id=\"txtjtfMoney\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"text_input\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text_left\" id=\"jtfMoneyValidMsg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t时间格式为:YYYY-MM-DD HH:MM:SS。\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"name.info\" style=\"color: red\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr> -->\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td valign=\"top\" class=\"w1\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"mcname\" style=\"color:red\">*</span>\r\n");
      out.write("\t\t\t\t\t\t\t开始时间:\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"startTime\" type=\"text\" class=\"text_input\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text_left\" id=\"jtfMoneyValidMsg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t时间格式为:YYYY-MM-DD HH:MM。\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"name.info\" style=\"color: red\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td valign=\"top\" class=\"w1\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"mcname\" style=\"color:red\">*</span>\r\n");
      out.write("\t\t\t\t\t\t\t结束时间:\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"endTime\" type=\"text\" id=\"txtjtfMoney\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"text_input\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text_left\" id=\"jtfMoneyValidMsg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t时间格式为:YYYY-MM-DD HH:MM。\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"name.info\" style=\"color: red\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td valign=\"top\" class=\"w1\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"mcname\" style=\"color:red\">*</span>\r\n");
      out.write("\t\t\t\t\t\t\t有效标志:\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<select name=\"cFlag\" class=\"text_input\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t请选择\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"有效\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t有效\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"无效\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t无效\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text_left\" id=\"servFlagValidMsg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
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
