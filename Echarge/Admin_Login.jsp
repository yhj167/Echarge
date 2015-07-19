<%@ page contentType="text/html; charset=gb2312" language="java"
	pageEncoding="GB18030" import="com.Echarge.admin.*" import="java.sql.*"%>
<%
	String action = request.getParameter("action");
	if (action != null && action.equals("adminLogin")) {
		String loginName = request.getParameter("loginName");
		String loginPwd = request.getParameter("loginPwd");
		Admin a = null;
		try {
			a = Admin.check(loginName, loginPwd);
		} catch (UserNotFoundException e) {
			out.println(e.getMessage());
			return;
		} catch (PasswordNotCorrectException e) {
			out.println(e.getMessage());
			return;
		}
		session.setAttribute("admin", a);
		response.sendRedirect("Admin/Admin_Index.jsp");

		/*
		if (!loginName.equals("admin") || !loginPwd.equals("admin")) {
			out.println("username or password not correct!");
			return;
		}
		session.setAttribute("admin", "admin");
		response.sendRedirect("Admin_Index.jsp");
		 */
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>管理员登陆</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<style type="text/css">
body {
	color: white;
}
</style>

		<script language="javascript">
		<!--start_of_saved_settings-->
<!--type,text,name,loginName,required,true,errMsg,用户名不能为空!-->
<!--type,password,name,loginPwd,required,true,errMsg,密码不能为空!-->
<!--end_of_saved_settings-->
document.form1.loginName.focus();
function CheckForm(){ 
 var f = document.form1;
  if (f.loginName.value == "") {
    alert("用户名不能为空!");
    f.loginName.value='';
  	f.loginName.focus();
	return false; 
 }
 
 if (f.loginPwd.value == "") {
    alert("密码不能为空!");
    f.loginPwd.value == '';
  	f.loginPwd.focus();
	return false; 
 }
 return true;
} 
</script>
	</head>

	<body style="background: #278296">
		<form method="post" name="form1" action="Admin_Login.jsp">
			<input type="hidden" name="action" value="adminLogin" />
			<table cellspacing="0" cellpadding="0" style="margin-top: 100px"
				align="center">

				<tr>
					<td colspan="2" align="center">
						<img src="Admin/images/logo.gif" width="346" height="60"
							align="middle" />
					</td>
				</tr>
				<tr>
					<td>
						<img src="Admin/images/login.jpg" width="178" height="256" border="0" />
					</td>
					<td style="padding-left: 50px">
						<table>
							<tr>
								<td>
									用户名：
								</td>
								<td>
									<input type="text" size="20" name="loginName" />
								</td>
							</tr>
							<tr>
								<td>
									密码：
								</td>
								<td>
									<input type="password" size="21" name="loginPwd" />
								</td>
								<td>&nbsp;</td>
							</tr>
							<!-- <tr>
								<td colspan="2">
									<label>
										<input type="checkbox" value="1" name="remember" />
										<font size=2>请保存我这次的登录信息。</font>
									</label>
								</td>
							</tr> -->
							<tr>
								<td>
									&nbsp;
								</td>
								<td><input type="submit" value="进入管理中心" onclick="return CheckForm()" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>

	</body>
</html>