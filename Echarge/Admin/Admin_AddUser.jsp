<%@ page language="java" contentType="text/html;charset=gb2312" pageEncoding="GB18030"%>
<%@ page import="com.Echarge.admin.*"%>
<%@ page import="com.Echarge.Role.*"%>
<%@ page import="java.util.*"%>

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
	if (action != null && action.trim().equals("newAdmin")) {
		String adminName = request.getParameter("adminName");
		String loginName = request.getParameter("loginName");
		String loginPwd = request.getParameter("loginPwd");
		String adminEmail = request.getParameter("adminEmail");
		String phoneNum = request.getParameter("phoneNum");
		String adminAddress = request.getParameter("adminAddress");
		String adminType = request.getParameter("adminType");
		try {
			a = Admin.checkName1(loginName);
		} catch (UserNotFoundException e) {
			out.println(e.getMessage());
			return;
		}
		a.setAdminName(adminName);
		a.setLoginName(loginName);
		a.setLoginPwd(loginPwd);
		a.setAdminEmail(adminEmail);
		a.setPhoneNum(phoneNum);
		a.setAdminAddress(adminAddress);
		a.setAdminType(adminType);
		a.setAddDate(new Date());
		a.save();
		response.sendRedirect("Admin_UserList.jsp");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>Echarge 管理中心 - 添加用户</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="../js/jquery.validate.js"></script>
		<link href="styles/main.css" rel="stylesheet" type="text/css" />
		<link href="styles/general.css" rel="stylesheet" type="text/css" />	
	
		<script>

	$(function() {

		$('#f').validate( {
			rules : {
				adminName : {
					required : true,
					rangelength : [ 2, 4 ]
				},
				loginName1 : {
					required : true,
					rangelength : [ 3, 12 ]
				},
				loginPwd : {
					required : true,
					rangelength : [ 4, 20 ]
				},
				checkPwd : {
					required : true,
					rangelength : [ 4, 20 ],
					equalTo : "#txtPassword"
				},
				phoneNum:{
					required:true,
					rangelength:[11,11],
					digits:true
				},
				adminEmail:{
					email:true
				},
				adminType:{
					required:true
				}
			},
			messages : {
				adminName : {
					required : "真实姓名不能为空",
					rangelength : "真实姓名应为2-4位之间"
				},
				loginName1 : {
					required : "账号不能为空",
					rangelength : "账号应为3-12位之间",
					remote : "账号已被占用"
				},
				loginPwd : {
					required : "密码不能为空",
					rangelength : "密码应为4-20位之间"
				},
				checkPwd : {
					required : "密码不能为空",
					rangelength : "密码应为4-20位之间",
					equalTo : "两次密码不一致"
				},
				phoneNum:{
					required:"手机号码不能为空",
					rangelength:"手机号码格式错误",
					digits:"必须是整数数字"
				},
				adminEmail:{
					email : "请输入正确的email格式"
				},
				adminType:{
					required:"请选择用户类型"
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
		var tempLoginName = document.form1.loginName.value;
		if (tempLoginName == ""){//如果尚未输入注册名
		 	alert("对不起，请您输入注册名!");
		 	return;
		}
		//创建一个XMLHttpRequest对象
		createXMLHttpRequest();
		//将状态触发器绑定到一个函数
		xmlHttp.onreadystatechange = processor;
		//通过GET方法向指定的URL建立服务器的调用
		xmlHttp.open("GET", "AdminCheckServlet?loginName="+tempLoginName);
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
		<!--start_of_saved_settings-->
<!--type,text,name,adminName,required,true,errMsg,真实姓名不能为空!-->
<!--type,text,name,loginName,required,true,errMsg,账号不能为空!-->
<!--type,password,name,loginPwd,required,true,errMsg,密码不能为空!-->
<!--type,password,name,checkPwd,required,true,errMsg,确认密码不能为空!-->
<!--type,text,name,phoneNum,required,true,errMsg,电话不能为空!-->
<!--type,text,name,adminAddress,required,true,errMsg,地址不能为空!-->
<!--end_of_saved_settings-->
document.form1.adminName.focus;
function CheckForm(){
 var theform = document.form1;
 //var errMsg = "";
 //var setfocus = "";
 
 if (theform['adminName'].value == "") {
    alert("真实姓名不能为空!");
  	theform.adminName.focus();
  	return false;
 }
 if (theform['loginName'].value == "") {
    alert("账号不能为空!");
  	theform.loginName.focus();
  	return false;
 }
 if (theform['loginPwd'].value == "") {
    alert("密码不能为空!");
  	theform.loginPwd.focus();
  	return false;
 }
 if (theform['checkPwd'].value == "") {
    alert("确认密码不能为空!");
  	theform.checkPwd.focus();
  	return false;
 }
 
 if (theform['loginPwd'].value != theform['checkPwd'].value) {
    alert("两次密码输入不一致!");
  	theform.loginPwd.focus();
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
			<span class="action-span"></span><span>Echarge 管理中心  - 添加用户</span>
					</h1>
				</td>
				</tr>
			</tbody>
		</table>
		<br/>

		<div class="fill_message">
			<form name="form1" method="post" action="Admin_AddUser.jsp" id="f">
			<input type="hidden" name="action" value="newAdmin" />
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							用户账号:
						</td>
						<td>
							<input name="loginName" type="text" id="txtLoginName"
								class="text_input" />
							<div class="text_left"><input type="button" name="checkLoginName" value="有效性检查" 
								style="width:80px" onclick="beginCheck()"/></div>
							<div class="text_left" id="loginNameValidMsg">
								<p>
									用户账号可以由小写英文字母、中文、数字组成。
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							用户真实姓名:
						</td>
						<td>
							<input name="adminName" type="text" id="txtAdminName" class="text_input" />
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
						<span id="mcname" style="color:red">*</span>
							设置密码：
						</td>
						<td>
							<input name="loginPwd" type="password" id="txtPassword"
								class="text_input" />
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度4－20位。
								</p>
								<span id="password.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							再次输入您设置的密码：
						</td>
						<td>
							<input name="checkPwd" type="password" id="txtRepeatPass"
								class="text_input" />
							<div class="text_left" id="repeatPassValidMsg">
								<span id="password1.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="adminEmail" type="text" id="txtadminEmail" class="text_input" />
							<div class="text_left" id="adminEmailValidMsg">
								<p>
									请填写有效的Email地址。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							请填写您的手机号码:
						</td>
						<td>
							<input name="phoneNum" type="text" id="txtphoneNum" class="text_input" />
							<div class="text_left" id="phoneNumValidMsg">
								<p>
									电话必须由整数数字组成，长度11个字符。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							请填写您的住址:
						</td>
						<td>
							<input name="adminAddress" type="text" id="txtadminAddress" class="text_input" />
							<div class="text_left" id="adminAddressValidMsg">
								<p>
									住址可以由小写英文字母、中文、数字组成。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							<span id="mcname" style="color: red">*</span>
								用户类型:
						</td>
						<td>
							<select name="adminType"  class="text_input"/>
								<option value="">
									请选择
								</option>
								<%
									List<Role> roles = new ArrayList<Role>();
									Role.getRoles(roles, 1, 10);
									for (int i = 0; i < roles.size(); i++) {
										Role r = roles.get(i);
								%>
								<option value="<%=r.getRoleName()%>"><%=r.getRoleName()%></option>
								<%
									}
								%>
							</select>
							<div class="text_left" id="adminTypeValidMsg">
								<p>
									&nbsp;请选择正确的用户类型，不同类型的用户具有不同的权限
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