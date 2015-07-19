<%@ page language="java" contentType="text/html;charset=gb2312"
	import="java.util.*"%>
<%@ page import="com.Echarge.Charging.*"%>
<%@ page import="com.Echarge.admin.*"%>
<%@ page import="com.Echarge.Rate.*"%>
<%@ page import="com.Echarge.User.*"%>
<%@ page import="com.Echarge.Analysis.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
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
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>Echarge 管理中心 - 充电记录录入</title>
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
				clientAccount : {
					required : true,
					rangelength : [ 3, 12 ]
				},
				machineNo : {
					required : true,
					rangelength : [ 5, 5 ]
				},
				rateValue : {
					required : true
				},
				elecQuantity : {
					required : true,
					number:true
				},
				startTime : {
					required : true,
					rangelength : [ 16, 16 ]
				},
				endTime : {
					required : true,
					rangelength : [ 16, 16 ]
				},
				cFlag : {
					required : true
				}
			},
			messages : {
				clientAccount : {
					required : "客户账号不能为空",
					rangelength : "客户账号应为3-12位之间",
					remote : "客户账号已被占用"
				},
				machineNo : {
					required : "充电桩号不能为空",
					rangelength : "充电桩号应为5位"
				},
				rateValue : {
					required : "费率不能为空"
				},
				elecQuantity : {
					required : "充电量不能为空",
					number: "必须是浮点型数字"
				},
				startTime:{
					required:"开始时间不能为空",
					rangelength: "请填写正确的格式"
				},
				endTime:{
					required : "结束时间不能为空",
					rangelength: "请填写正确的格式"
				},
				cFlag:{
					required : "有效标志不能为空"
				}
			},
			errorPlacement : function(error, element) {
				error.appendTo(element.next().find("span"));
			}
		});
	});
</script>
		
		<script language="javascript">
	document.form1.loginName.focus;
	function CheckForm() {
		var theform = document.form1;
		if (theform['loginName'].value == "") {
			alert("操作员账号不能为空!");
			theform.loginName.focus();
			return false;
		}
		if (theform['clientAccount'].value == "") {
			alert("客户账号不能为空!");
			theform.clientAccount.focus();
			return false;
		}
		if (theform['clientName'].value == "") {
			alert("客户姓名不能为空!");
			theform.clientName.focus();
			return false;
		}
		if (theform['servFlag'].value == "") {
			alert("服务类型不能为空!");
			theform.servFlag.focus();
			return false;
		}
		if (theform['jtfFlag'].value == "") {
			alert("费用类型不能为空!");
			theform.jtfFlag.focus();
			return false;
		}
		
		if (theform['jtfMoney'].value == "") {
			alert("费用不能为空!");
			theform.jtfMoney.focus();
			return false;
		}
		
		if (theform['thenBalance'].value == "") {
			alert("当时余额不能为空!");
			theform.thenBalance.focus();
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
							<span class="action-span"></span><span>Echarge 管理中心 - 充电记录录入</span>
						</h1>
				</td>
				</tr>
			</tbody>
		</table>
		<br/>

		<div class="fill_message">
			<form name="form1" method="post" action="ChargingInsert.jsp" id="f">
			<input type="hidden" name="action" value="ChargingInsert" />
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							客户账号:
						</td>
						<td>
							<input name="clientAccount" type="text" id="txtclientAccount"
								class="text_input"/>
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
						<span id="mcname" style="color:red">*</span>
							充电桩号:
						</td>
						<td>
							<input name="machineNo" type="text" id="txtclientName"
								class="text_input"/>
							<div class="text_left" id="clientNameValidMsg">
								<p>
									充电桩号由5位整数数字组成，前三位表示设备种类，后两位表示设备号。 
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							充电量（度）:
						</td>
						<td>
							<input name="elecQuantity" type="text" id="txtjtfMoney"
								class="text_input"/>
							<div class="text_left" id="jtfMoneyValidMsg">
								<p>
									充电量可以为整数或者小数。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<!-- <tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							费率（元/度）:
						</td>
						<td>
							<select name="rateValue"  class="text_input">
								<option value="">
									请选择
								</option>
								<%
									List<Rate> rates = new ArrayList<Rate>();
									Rate.getRates(rates, 1, 100);
									for (int i = 0; i < rates.size(); i++) {
										Rate r = rates.get(i);
								%>
								<option value="<%=r.getRateValue()%>"><%=r.getRateValue()%></option>
								<%
									}
								%>
							</select>
							<div class="text_left" id="jtfMoneyValidMsg">
								<p>
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr style="overflow:hidden;">
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							充电费用（元） :
						</td>
						<td>
							<input name="cost" type="text" id="txtjtfMoney"
								class="text_input"/>
							<div class="text_left" id="jtfMoneyValidMsg">
								<p>
									充电费用可以为整数或者小数。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							当时余额（元） :
						</td>
						<td>
							<input name="theBalance" type="text" id="txttheBalance"
								class="text_input"/>
							<div class="text_left" id="theBalanceValidMsg">
								<p>
									当时余额可以为整数或者小数。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							充电时间:
						</td>
						<td>
							<input name="chargingTime" type="text" id="txtjtfMoney"
								class="text_input"/>
							<div class="text_left" id="jtfMoneyValidMsg">
								<p>
									时间格式为:YYYY-MM-DD HH:MM:SS。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr> -->
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							开始时间:
						</td>
						<td>
							<input name="startTime" type="text" class="text_input"/>
							<div class="text_left" id="jtfMoneyValidMsg">
								<p>
									时间格式为:YYYY-MM-DD HH:MM。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							结束时间:
						</td>
						<td>
							<input name="endTime" type="text" id="txtjtfMoney"
								class="text_input"/>
							<div class="text_left" id="jtfMoneyValidMsg">
								<p>
									时间格式为:YYYY-MM-DD HH:MM。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							有效标志:
						</td>
						<td>
							<select name="cFlag" class="text_input">
								<option value="">
									请选择
								</option>
								<option value="有效">
									有效
								</option>
								<option value="无效">
									无效
								</option>
							</select>
							<div class="text_left" id="servFlagValidMsg">
								<p>
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