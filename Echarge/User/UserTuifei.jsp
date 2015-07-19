<%@ page language="java" contentType="text/html;charset=gb2312"
	import="java.util.*"%>
<%@ page import="com.Echarge.User.*"%>
<%@ page pageEncoding="GB18030"%>
<%@ page import="com.Echarge.admin.*"%>
<%@ page import="com.Echarge.Jtf.*"%>
<%
	//检查session，查看用户是否登陆
	Admin a = (Admin) session.getAttribute("admin");
	if (a == null) {
		response.sendRedirect("../Admin_Login.jsp");
		return;
	}
	String loginName = a.getLoginName();
%>
<%
	Jtf j = new Jtf();
	User u = (User) session.getAttribute("User");
	String action = request.getParameter("action");
	if (action != null && action.trim().equals("UserTuifei")) {
		String clientAccount = request.getParameter("clientAccount");
		Double cardBalance = Double.parseDouble(request.getParameter("cardBalance"));
		Double money = Double.parseDouble(request.getParameter("money"));
		cardBalance -= money;
		u.setClientAccount(clientAccount);
		u.setCardBalance(cardBalance);
		u.updateCardBalance();//更新用户信息
		
		String clientName = u.getClientName();
		j.setLoginName(loginName);
		j.setClientAccount(clientAccount);
		j.setClientName(clientName);
		j.setServFlag("退费");
		j.setJtfMoney(money);
		j.setThenBalance(cardBalance);
		j.setJtfTime(new Date());
		j.inertJtf();//更新交易记录
		response.sendRedirect("UserInfo.jsp");
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>Echarge 管理中心 - 客户退费</title>
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
				money : {
					required : true,
					number : true
				}
			},
			messages : {
				money : {
					required : "交纳费用不能为空",
					number : "交纳费用为浮点型数字"
				}
			},
			errorPlacement : function(error, element) {
				error.appendTo(element.next().find("span"));
			}
		});
	});
</script>
		<script language="javascript">
document.form1.money.focus;
function CheckForm(){
 var theform = document.form1;
 if (theform['money'].value == "") {
    alert("费用不能为空!");
  	theform.money.focus();
  	return false;
 }
 return true;
}
</script>
	</head>
	<body>
		<table style="table-layout: fixed;" align="center" border="0" cellpadding="0" cellspacing="0" width="97%">
			<tbody>
				<tr>
				<td class="nav" align="left" nowrap="nowrap" width="100%">
					<h1>
			<span class="action-span"></span><span>Echarge 管理中心 - 客户退费</span>
					</h1>
				</td>
				</tr>
			</tbody>
		</table>
		<br/>

		<div class="fill_message">
			<form name="form1" method="post" action="UserTuifei.jsp" id="f">
			<input type="hidden" name="action" value="UserTuifei" />
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							真实姓名:
						</td>
						<td>
							<div class="text_input"><%=u.getClientName()%></div>
							<input name="clientName" type="hidden" id="txtAdminName"
								class="text_input" readonly="readonly"
								value="<%=u.getClientName()%>" />
							<div class="text_left" id="adminNameValidMsg">
								<p>
									真实姓名可以由中文组成，长度2－4个字符，一个汉字为一个字符。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							客户账号:
						</td>
						<td>
							<div class="text_input"><%=u.getClientAccount()%></div>
							<input name="clientAccount" type="hidden" id="txtclientAccount"
								class="text_input" readonly="readonly"
								value="<%=u.getClientAccount()%>" />
							<div class="text_left" id="clientAccountValidMsg">
								<p>
									客户账号可以由小写英文字母、中文、数字组成，长度3－12个字符，一个汉字为一个字符。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							客户余额(元):
						</td>
						<td>
							<div class="text_input"><%=u.getCardBalance()%></div>
							<input name="cardBalance" type="hidden" id="txtcardBalance"
								class="text_input" readonly="readonly"
								value="<%=u.getCardBalance()%>" />
							<div class="text_left" id="cardBalanceValidMsg">
								<p>
									客户余额为浮点型数字。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							欲退还的费用(元):
						</td>
						<td>
							<input name="money" type="text" id="txtmoney" class="text_input" />
							<div class="text_left" id="moneyValidMsg">
								<p>
									交纳费用为浮点型数字。
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