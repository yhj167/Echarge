<%@ page language="java" contentType="text/html;charset=gb2312"
	pageEncoding="GB18030"%>
<%@ page import="java.util.*"%>
<%@ page import="com.Echarge.User.*"%>
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
	String action = request.getParameter("action");
	if (action != null && action.trim().equals("State")) {
		String clientAccount = request.getParameter("clientAccount");
		String clientState = request.getParameter("clientState");
		clientState = new String(clientState.getBytes("iso-8859-1"),"gbk");
		u.setClientAccount(clientAccount);
		u.setClientState(clientState);
		u.updateState();
		out.println("更改成功!");
		response.sendRedirect("UserList.jsp");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>Echarge 管理中心 - 锁定客户</title>
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
					required : "账号不能为空",
					rangelength : "账号应为3-12位之间",
					remote : "账号不存在"
				}
			},
			errorPlacement : function(error, element) {
				error.appendTo(element.next().find("span"));
			}
		});
	});
</script>

<script type="text/javascript">	
	document.form1.clientAccount.focus;
 	function check()
    {
        var radios = document.getElementsByName("clientState");
        for(var i=0;i<radios.length;i++)
        {
            if(radios[0].checked==true)
            {
                alert("解锁客户？");
            }
            else if(radios[1].checked==true)
            {
                alert("锁定客户？");
            } 
            else return false;           
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
			<span class="action-span"></span><span>Echarge 管理中心 - 锁定客户</span>
						</h1>
				</td>
				</tr>
			</tbody>
		</table>
		<br/>

		<div class="fill_message">
			<form name="form1" method="post" action="UserState.jsp" id="f">
			<input type="hidden" name="action" value="State" />
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							客户账号:
						</td>
						<td>
							<div class="text_input"><%=u.getClientAccount()%></div>
							<input name="clientAccount" type="hidden" id="txtclientAccount"
								class="text_input" value="<%=u.getClientAccount()%>"/>
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
							选择一种规则:
						</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;
							<span><input type="radio" name="clientState" value="正常"/>解锁</span>
							<span><input type="radio" name="clientState" value="锁定"/>锁定</span>
						</td>
					</tr>
				</table>
				
				<br/>
				<table align="center">
				<tr>
					<td align="center">
						<input type="submit" value="提交" onclick="return check()"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="重填" />
					</td>
				</tr>
				</table>
			</form>
		</div>
	<script language="javascript">
		var clientState = "<%=u.getClientState()%>"
        var radios = document.getElementsByName("clientState");
		if(clientState=="正常"){
			radios[0].checked=true;
		}else{
			radios[1].checked=true;
		}
	</script>
	</body>
</html>