<%@ page language="java" contentType="text/html;charset=gb2312" import="java.util.*"%>
<%@ page import="com.Echarge.admin.*" %>
<%
	//检查session，查看用户是否登陆
	Admin a = (Admin) session.getAttribute("admin");
	if (a == null) {
		response.sendRedirect("../Admin_Login.jsp");
		return;
	}
%>
<%
/*	
	String action = request.getParameter("action");
	if (action != null && action.trim().equals("SearchUser")) {
		String loginName = request.getParameter("loginName");
		a = null;
		try {
			a = Admin.checkName(loginName);
		} catch (UserNotFoundException e) {
			out.println(e.getMessage());
			return;
		}
		session.setAttribute("admin", a);
		response.sendRedirect("Admin_UserInfo.jsp");
	}
*/
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Echarge 管理中心 - 查找用户</title>
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
				loginName : {
					required : true,
					rangelength : [ 3, 12 ]
				}
			},
			messages : {
				loginName : {
					required : "账号不能为空",
					rangelength : "账号应为3-12位之间"
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
							<span class="action-span"></span><span>Echarge 管理中心 - 查找用户</span>
						</h1>
					</td>
				</tr>
			</tbody>
		</table>
<br/>
<div class="fill_message">
			<form name="form1" method="post" action="Admin_UserInfo.jsp" id="f">
			<input type="hidden" name="action" value="SearchUser" />
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							请输入用户账号:
						</td>
						<td>
							<input name="loginName" type="text" id="txtLoginName" class="text_input" />
							<div class="text_left" id="loginNameValidMsg">
								<p>
									用户账号可以由小写英文字母、中文、数字组成，长度3－12个字符，一个汉字为一个字符。
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