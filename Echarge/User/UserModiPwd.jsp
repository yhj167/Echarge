<%@ page language="java" contentType="text/html;charset=gb2312" %>
<%@ page import="com.Echarge.admin.*" %>
<%@ page import="com.Echarge.User.*" %>
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
	User u =(User) session.getAttribute("User");
	request.setCharacterEncoding("GBK");
	String action = request.getParameter("action");
	if (action != null && action.trim().equals("modiPwd")) {	
		String clientAccount = request.getParameter("clientAccount");
		String clientPwd = request.getParameter("clientPwd");

		u.setClientAccount(clientAccount);
		u.setClientPwd(clientPwd);
		u.updatePassword();
		out.println("更改成功!");
		response.sendRedirect("UserInfo.jsp");
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<title>Echarge 管理中心 - 修改密码 </title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="../js/jquery.validate.js"></script>
		<link href="../Admin/styles/main.css" rel="stylesheet" type="text/css" />
		<link href="../Admin/styles/general.css" rel="stylesheet" type="text/css" />
	
		<script>
	$(document).ready(function() {
		$('#f').validate( {
			rules : {
				clientPwd : {
					required : true,
					rangelength : [ 4, 20 ]
				},
				checkPwd : {
					required : true,
					rangelength : [ 4, 20 ],
					equalTo : "#txtclientPwd"
				}
			},
			messages : {
				clientPwd : {
					required : "密码不能为空",
					rangelength : "密码应为4-20位之间"
				},
				checkPwd : {
					required : "密码不能为空",
					rangelength : "密码应为4-20位之间",
					equalTo : "两次密码不一致"
				}
			},
			errorPlacement : function(error, element) {
				error.appendTo(element.next().find("span"));
			}
		});
	});
</script>
	<script language="javascript">
        document.register.loginPwd.focus();
        function test(){
             var f=document.register;
             var newPsw1 = f.clientPwd.value;
             var newPsw2 = f.checkPwd.value;
             if(newPsw1 == "" || newPsw2 == ""){
                  alert("密码框不能为空!");
                  f.clientPwd.value='';
                  f.checkPwd.value='';
                  f.clientPwd.focus();
                  return false;
             }
             if(newPsw1 != newPsw2){
                  alert("两次密码输入不一致!");
                  f.clientPwd.value='';
                  f.checkPwd.value='';
                  f.clientPwd.focus();
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
							<span class="action-span"></span><span>Echarge 管理中心 - 修改密码</span>
						</h1>
					</td>
				</tr>
			</tbody>
		</table>
		<br/>

		<div class="fill_message">
			<form name="form1" method="post" action="UserModiPwd.jsp" id="f">
			<input type="hidden" name="action" value="modiPwd" />
				<table class="tab_login">
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