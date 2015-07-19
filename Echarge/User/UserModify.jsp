<%@ page language="java" contentType="text/html;charset=gb2312"%>
<%@ page import="com.Echarge.User.*"%>
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
	User u = (User) session.getAttribute("User");
	request.setCharacterEncoding("GBK");
	String action = request.getParameter("action");
	if (action != null && action.trim().equals("UserModi")) {
		String clientAccount = request.getParameter("clientAccount");
		String clientSex = request.getParameter("clientSex");
		String cardNum = request.getParameter("cardNum");
		String clientEmail = request.getParameter("clientEmail");
		String clientTel = request.getParameter("clientTel");
		String clientPhone = request.getParameter("clientPhone");
		String clientAddress = request.getParameter("clientAddress");
		u.setClientAccount(clientAccount);
		u.setClientSex(clientSex);
		u.setCardNum(cardNum);
		u.setClientEmail(clientEmail);
		u.setClientTel(clientTel);
		u.setClientPhone(clientPhone);
		u.setClientAddress(clientAddress);
		u.update();
		out.println("修改成功!");
		response.sendRedirect("UserInfo.jsp");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>Echarge 管理中心 - 修改客户信息</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="../js/jquery.validate.js"></script>
		<link href="../Admin/styles/main.css" rel="stylesheet" type="text/css" />
		<link href="../Admin/styles/general.css" rel="stylesheet" type="text/css" />
	
		<script>
		// 添加验证方法 (身份证号码验证) 
		jQuery.validator.addMethod("isIdCardNo", function(value, element) {
			var reg = /^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/;
			return this.optional(element) || (reg.test(value));
		}, "请输入正确的身份证号！");
		
	$(document).ready(function() {
		$('#f').validate( {
			rules : {
				clientName : {
					required : true,
					rangelength : [ 2, 4 ]
				},
				clientAccount : {
					required : true,
					rangelength : [ 3, 12 ]
				},
				clientPwd : {
					required : true,
					rangelength : [ 4, 20 ]
				},
				checkPwd : {
					required : true,
					rangelength : [ 4, 20 ],
					equalTo : "#txtPassword"
				},
				cardNum : {
					isIdCardNo : true
				},
				clientPhone : {
					rangelength : [ 11, 11 ],
					digits : true
				},
				clientTel : {
					rangelength : [ 7, 8 ],
					digits : true
				},
				clientEmail : {
					email : true
				}
			},
			messages : {
				clientName : {
					required : "真实姓名不能为空",
					rangelength : "真实姓名应为2-4位之间"
				},
				clientAccount : {
					required : "账号不能为空",
					rangelength : "账号应为3-12位之间",
					remote : "账号已被占用"
				},
				clientPwd : {
					required : "密码不能为空",
					rangelength : "密码应为4-20位之间"
				},
				checkPwd : {
					required : "密码不能为空",
					rangelength : "密码应为4-20位之间",
					equalTo : "两次密码不一致"
				},
				cardNum : {
					isIdCardNo : "身份证号不正确"
				},
				clientPhone : {
					rangelength : "手机号码格式错误",
					digits : "必须是整数数字"
				},
				clientTel : {
					rangelength : "电话号码格式错误",
					digits : "必须是整数数字"
				},
				clientEmail : {
					email : "请输入正确的email格式"
				}
			},
			errorPlacement : function(error, element) {
				error.appendTo(element.next().find("span"));
			}
		});
	});
</script>
	</head>
	<body>
		<table style="table-layout: fixed;" align="center" border="0" cellpadding="0" cellspacing="0" width="97%">
			<tbody>
				<tr>
				<td class="nav" align="left" nowrap="nowrap" width="100%">
					<h1>
							<span class="action-span"></span>
							<span>Echarge 管理中心 - 修改客户信息</span>
						</h1>
				</td>
				</tr>
			</tbody>
		</table>
		<br/>

		<div class="fill_message">
			<form name="form1" method="post" action="UserModify.jsp" id="f">
			<input type="hidden" name="action" value="UserModi" />
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
							请选择性别:
						</td>
						<td>
							<select name="clientSex" id="txtclientSex" class="text_input">
								<option value="">
									请选择</option>
								<option value="男" >
									男</option>
								<option value="女" >
									女</option>
							</select>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮箱地址：
						</td>
						<td>
							<input name="clientEmail" type="text" id="txtclientEmail"
								class="text_input" value="<%=u.getClientEmail()%>"/>
							<div class="text_left" id="clientEmailValidMsg">
								<p>
									请填写正确的邮箱格式。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							身份证号：
						</td>
						<td>
							<input name="cardNum" type="text" id="txtcardNum"
								class="text_input" value="<%=u.getCardNum()%>"/>
							<div class="text_left" id="cardNumValidMsg">
								<p>
									请填写正确的身份证号格式，身份证号为15位或18位。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							固定电话：
						</td>
						<td>
							<input name="clientTel" type="text" id="txtclientTel"
								class="text_input" value="<%=u.getClientTel()%>"/>
							<div class="text_left" id="clientTelValidMsg">
								<p>
									请填写正确的固定电话号码格式。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							移动电话：
						</td>
						<td>
							<input name="clientPhone" type="text" id="txtclientPhone"
								class="text_input" value="<%=u.getClientPhone()%>"/>
							<div class="text_left" id="clientPhoneValidMsg">
								<p>
									请填写正确的手机号码格式。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							住址：
						</td>
						<td>
							<input name="clientAddress" type="text" id="txtclientAddress"
								class="text_input" value="<%=u.getClientAddress()%>"/>
							<div class="text_left" id="clientAddressValidMsg">
								<p>
									客户余额为浮点型数字。
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
		<script language="javascript">
		document.form1.clientSex.value = "<%=u.getClientSex()%>";
		</script>
	</body>
</html>