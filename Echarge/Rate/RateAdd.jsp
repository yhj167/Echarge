<%@ page language="java" contentType="text/html;charset=gb2312" pageEncoding="GB18030"%>
<%@ page import="com.Echarge.Rate.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.Echarge.admin.*"%>
<%
	//检查session，查看用户是否登陆
	Admin a = (Admin) session.getAttribute("admin");
	if (a == null) {
		response.sendRedirect("../Admin_Login.jsp");
		return;
	}
%>
<%
	request.setCharacterEncoding("GBK");
	String action = request.getParameter("action");
	if (action != null && action.trim().equals("RateAdd")) {
		String rateName = request.getParameter("rateName");
		float rateValue = Float.parseFloat(request.getParameter("rateValue"));
		int rateTime = Integer.parseInt(request.getParameter("rateTime"));
		Rate r = new Rate();
		try {
			r = Rate.checkRole(rateName);
		} catch (UserNotFoundException e) {
			out.println(e.getMessage());
			return;
		}
		r.setRateName(rateName);
		r.setRateValue(rateValue);
		r.setRateTime(rateTime);
		r.setAddDate(new Date());
		r.save();
		out.println("添加成功!");
		response.sendRedirect("RateList.jsp");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>Echarge 管理中心 - 添加策略</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="../js/jquery.validate.js"></script>
		<link href="../Admin/styles/main.css" rel="stylesheet" type="text/css" />
		<link href="../Admin/styles/general.css" rel="stylesheet" type="text/css" />	
	
		<script>

	$(function() {

		$('#f').validate( {
			rules : {
				rateName : {
					required : true,
					rangelength : [ 3, 12 ]
				},
				rateValue:{
					required:true,
					number:true
				},
				rateTime:{
					required:true,
					number:true
				}
			},
			messages : {
				rateName : {
					required : "策略名不能为空",
					rangelength : "策略名应为3-12位之间"
				},
				rateValue:{
					required:"费率值不能为空",
					number:"必须是十进制数字(包括小数)"
				},
				rateTime:{
					required : "时间段不能为空",
					number:"必须是十进制数字"
				}
			},
			errorPlacement : function(error, element) {
				error.appendTo(element.next().find("span"));
			}
		});
	});
</script>

		<script language="javascript">
document.form1.clientAccount.focus;
function CheckForm(){
 var theform = document.form1;
 
 if (theform['rateName'].value == "") {
    alert("策略名不能为空!");
  	theform.rateName.focus();
  	return false;
 }
 if (theform['rateValue'].value == "") {
    alert("费率不能为空!");
  	theform.rateValue.focus();
  	return false;
 }
 return true;
}</script>
	</head>

	<body>
		<table style="table-layout: fixed;" align="center" border="0" cellpadding="0" cellspacing="0" width="97%">
			<tbody>
				<tr>
				<td class="nav" align="left" nowrap="nowrap" width="100%">
					<h1>
			<span class="action-span"></span><span>Echarge 管理中心 - 添加策略</span>
					</h1>
				</td>
				</tr>
			</tbody>
		</table>
		<br/>

		<div class="fill_message">
			<form name="form1" method="post" action="RateAdd.jsp" id="f">
			<input type="hidden" name="action" value="RateAdd" />
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							费率名:
						</td>
						<td>
							<input name="rateName" type="text" id="txtAdminName" class="text_input" />
							<div class="text_left" id="adminNameValidMsg">
								<p>
									策略名由小写英文字母、中文、数字组成，长度3－12个字符，一个汉字为一个字符。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							费率值:
						</td>
						<td>
							<input name="rateValue" type="text" id="txtphoneNum" class="text_input" />
							<div class="text_left" id="phoneNumValidMsg">
								<p>
									费率值由浮点型数据组成。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							时间段:
						</td>
						<td>
							<input name="rateTime" type="text" id="txtrateTime" class="text_input" />
							<div class="text_left" id="rateTimeValidMsg">
								<p>
									时间段采用8位数字形式、24小时格式，如17002300，表示下午5点到11点的时间段。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
				</table>
				
				<br/>
				<table align="center">
				<tr>
					<td align="center">
						<input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="重填" />
					</td>
				</tr>
				</table>
			</form>
		</div>
	</body>
</html>