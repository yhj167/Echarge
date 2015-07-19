<%@ page language="java" pageEncoding="GB18030"%>
<%@ page import="com.Echarge.admin.*"%>
<%@ page import="com.Echarge.Role.*"%>

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
	if (action != null && action.trim().equals("newRole")) {
		String roleName = request.getParameter("roleName");
		Role r = null;
		try {
			r = Role.checkName1(roleName);
		} catch (UserNotFoundException e) {
			out.println(e.getMessage());
			return;
		}
		r.setRoleName(roleName);
		r.save();
		response.sendRedirect("Admin_RoleList.jsp");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>Echarge 管理中心 - 添加角色</title>
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
				email : {
					required : true,
					email : true,
					remote : {
						url : "/Admin/Admin_AddRole.jsp?action='CheckRole'",
						type : "post",
						dataType : "json",
						data : {
							roleName : function() {
								return $("#txtRoleName").val();
							}
						}
					}
				},
				roleName : {
					required : true,
					rangelength : [ 3, 12 ]
				}
			},
			messages : {
				email : {
					required : "email不能为空",
					email : "请输入正确的email格式",
					remote : "email已被占用"
				},
				roleName : {
					required : "角色名不能为空",
					rangelength : "角色名应为3-12位之间",
					remote : "角色名已被占用"
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
					<span class="action-span"></span><span>Echarge 管理中心  - 添加角色 </span>
					</h1>
				</td>
				</tr>
			</tbody>
		</table>
		<br/>
		
		<div class="fill_message">
			<form name="form1" method="post" action="Admin_AddRole.jsp" id="f">
			<input type="hidden" name="action" value="newRole" />
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							请输入角色名：
						</td>
						<td>
							<input name="roleName" type="text" id="txtRoleName" class="text_input" />
							<div class="text_left" id="roleNameValidMsg">
								<p>
									角色名可以由小写英文字母、中文、数字组成，长度3－12个字符，一个汉字为一个字符。
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