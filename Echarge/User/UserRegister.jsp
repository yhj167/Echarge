<%@ page language="java" contentType="text/html;charset=gb2312" pageEncoding="GB18030"%>
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
	request.setCharacterEncoding("GBK");
	String action = request.getParameter("action");
	if (action != null && action.trim().equals("newUser")) {
		String clientAccount = request.getParameter("clientAccount");
		String clientName = request.getParameter("clientName");
		String clientPwd = request.getParameter("clientPwd");
		String clientSex = request.getParameter("clientSex");
		String cardNum = request.getParameter("cardNum");
		String clientEmail = request.getParameter("clientEmail");
		String clientTel = request.getParameter("clientTel");
		String clientPhone = request.getParameter("clientPhone");
		String clientAddress = request.getParameter("clientAddress");
		User u = null;
		try {
			u = User.checkUser(clientAccount);
		} catch (UserNotFoundException e) {
			out.println(e.getMessage());
			return;
		}
		u.setClientAccount(clientAccount);
		u.setClientName(clientName);
		u.setClientPwd(clientPwd);
		u.setClientSex(clientSex);
		u.setCardNum(cardNum);
		u.setClientEmail(clientEmail);
		u.setClientTel(clientTel);
		u.setClientPhone(clientPhone);
		u.setClientAddress(clientAddress);
		u.setCardBalance((double)0);
		u.setClientState("正常");
		u.setRDate(new Date());
		u.save();
		out.println("注册成功!");
		response.sendRedirect("UserList.jsp");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>Echarge 管理中心 - 添加客户</title>
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
				clientAccount1 : {
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
					equalTo : "#txtclientPwd"
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
				clientAccount1 : {
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

<script language="javascript">
	//定义一个变量用于存放XMLHttpRequest对象
	var xmlHttp; 
	
	//该函数用于创建一个XMLHttpRequest对象
	function createXMLHttpRequest() {
		if (window.ActiveXObject) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		} 
		else if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		}
	}
		
	//这是一个启动AJAX异步通信的方法
	function beginCheck(){
		var tempLoginName = document.form1.clientAccount.value;
		if (tempLoginName == ""){//如果尚未输入注册名
		 	alert("对不起，请您输入注册名!");
		 	return;
		}
		//创建一个XMLHttpRequest对象
		createXMLHttpRequest();
		//将状态触发器绑定到一个函数
		xmlHttp.onreadystatechange = processor;
		//通过GET方法向指定的URL建立服务器的调用
		xmlHttp.open("GET", "UserCheckServlet?clientAccount="+tempLoginName);
		//发送请求
		xmlHttp.send(null);
	}
	
	//这是一用来处理状态改变的函数
	function processor () {
		//定义一个变量用于存放从服务器返回的响应结果
		var responseContext;
		if(xmlHttp.readyState == 4) { //如果响应完成
			if(xmlHttp.status == 200) {//如果返回成功
				//取出服务器的响应内容
				responseContext = xmlHttp.responseText;
				//如果注册名检查有效
				if (responseContext.indexOf("true")!=-1){
					alert("恭喜您，该注册名有效！");
				}else{
					alert("对不起，该注册名已被使用！");
				}
			}
		}
	}
</script>
		
<script language="javascript">
document.form1.clientAccount.focus;
function CheckForm(){
 var theform = document.form1;
 
 if (theform['clientAccount'].value == "") {
    alert("账号不能为空!");
  	theform.clientAccount.focus();
  	return false;
 }
 if (theform['clientName'].value == "") {
    alert("姓名不能为空!");
  	theform.clientName.focus();
  	return false;
 }
 if (theform['clientPwd'].value == "") {
    alert("密码不能为空!");
  	theform.clientPwd.focus();
  	return false;
 }
 if (theform['checkPwd'].value == "") {
    alert("确认密码不能为空!");
  	theform.checkPwd.focus();
  	return false;
 }
 
 if (theform['clientPwd'].value != theform['checkPwd'].value) {
    alert("两次密码输入不一致!");
  	theform.clientPwd.focus();
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
							<span class="action-span"></span><span>Echarge 管理中心 - 添加客户</span>
						</h1>
				</td>
				</tr>
			</tbody>
		</table>
		<br/>

		<div class="fill_message">
			<form name="form1" method="post" action="UserRegister.jsp" id="f">
			<input type="hidden" name="action" value="newUser" />
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							客户账号:
						</td>
						<td>
							<input name="clientAccount" type="text" id="txtclientAccount"
								class="text_input"/>
							<div class="text_left"><input type="button" name="checkLoginName" value="有效性检查" 
								style="width:80px" onclick="beginCheck()"/></div>
							<div class="text_left" id="clientAccountValidMsg">
								<p>
									客户账号可以由小写英文字母、中文、数字组成。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							真实姓名:
						</td>
						<td>
							<input name="clientName" type="text" id="txtclientName"
								class="text_input"/>
							<div class="text_left" id="clientNameValidMsg">
								<p>
									真实姓名可以由中文组成，长度2－4个字符，一个汉字为一个字符。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							设置密码：
						</td>
						<td>
							<input name="clientPwd" type="password" id="txtclientPwd" class="text_input"/>
							<div class="text_left" id="clientPwdValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度4－20位。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							确认您设置的密码：
						</td>
						<td>
							<input name="checkPwd" type="password" id="txtcheckPwd" class="text_input"/>
							<div class="text_left" id="checkPwdValidMsg">
								<p>
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
								class="text_input"/>
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
								class="text_input"/>
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
								class="text_input"/>
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
								class="text_input"/>
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
								class="text_input"/>
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
	</body>
</html>