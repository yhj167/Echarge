<%@ page language="java" contentType="text/html;charset=gb2312" import="java.util.*"%>
<%@ page import="com.Echarge.User.*" %>
<%@ page import="com.Echarge.admin.*"%>
<%
	//检查session，查看用户是否登陆
	Admin a = (Admin) session.getAttribute("admin");
	if (a == null) {
		response.sendRedirect("../Admin_Login.jsp");
		return;
	}
%>

 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<title>Echarge 管理中心 - 删除用户</title>
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
				}
			},
			messages : {
				clientAccount : {
					required : "客户账号不能为空",
					rangelength : "客户账号应为3-12位之间"
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
		<table style="table-layout: fixed;" align="center" border="0"
			cellpadding="0" cellspacing="0" width="97%">
			<tbody>
				<tr>
					<td class="nav" align="left" nowrap="nowrap" width="100%">
						<h1>
							<span class="action-span"></span><span>Echarge 管理中心 - 删除客户</span>
						</h1>
					</td>
				</tr>
			</tbody>
		</table>
		<br/>

		<div class="fill_message">
			<form name="form1" method="post" action="UserDeleteResult2.jsp" id="f">
			<input type="hidden" name="action" value="DeleteUser" />
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							<span id="mcname" style="color:red">*</span>客户账号：
						</td>
						<td>
							<input name="clientAccount" type="text" id="txtclientAccount" class="text_input"/>
							<div class="text_left" id="clientAccountValidMsg">
								<p>
									客户账号可以由小写英文字母、中文、数字组成，长度3－12个字符，一个汉字为一个字符。
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