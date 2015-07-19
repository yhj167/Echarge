<%@ page language="java" contentType="text/html;charset=gb2312"%>
<%@ page import="com.Echarge.admin.*"%>
<%@ page import="java.util.*"%>
<%
	//检查session，查看用户是否登陆
	Admin a = (Admin) session.getAttribute("admin");
	if (a == null) {
		response.sendRedirect("../Admin_Login.jsp");
		return;
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate" />
	<meta http-equiv="expires" content="Wed, 26 Feb 1970 08:21:57 GMT" />
	<title></title>
	<link href="styles/general.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
    #header-div {
      background: #278296;
      border-bottom: 1px solid #FFF;
    }
    
    #logo-div {
      height: 50px;
      float: left;
    }
    
    #submenu-div {
      height: 50px;
    }
    
    #submenu-div ul {
      margin: 0;
      padding: 0;
      list-style-type: none;
    }
    
    #submenu-div li {
      float: right;
      padding: 0 10px;
      margin: 5px 0;
      border-left: 1px solid #FFF;
    }
    
    #submenu-div a:visited, #submenu-div a:link {
      color: #FFF;
      text-decoration: none;
    }
    
    #submenu-div a:hover {
      color: #F5C29A;
    }
    
    #loading-div {
      clear: right;
      text-align: right;
      display: block;
    }
    
    #menu-div {
      background: #80BDCB;
      font-weight: bold;
      padding-left: 30px;
      height: 24px;
    }
    
    #menu-div ul {
      margin: 0;
      padding: 0;
      list-style-type: none;
    }
    
    #menu-div li {
      float: left;
      padding: 0 20px;
      margin: 5px 0;
      border-right: 1px solid #192E32;
    }
    
    #menu-div a:visited, #menu-div a:link {
      text-decoration: none;
      color: #335B64;
    }
    
    #menu-div a:hover {
      color: #F5C29A;
    }
    </style>
</head>
<body>
		<div id="header-div">
			<div id="submenu-div">
				<ul>
					<li style="float: right; border-right: 0;">
						<a href="/Echarge/Admin_Login.jsp" target="_top">退出</a>
					</li>
					<li>
						<a href="../Help.jsp" target="main-frame">帮助</a>
					</li>
					<li>
						<a href="Admin_Setting.jsp?loginName=<%=a.getLoginName()%>"
							target="main-frame">设置</a>
					</li>
					<li>
						<a href="javascript:history.go(-1)" target="_blank">返回</a>
					</li>
					<li>
						<a href="javascript:window.top.frames['main-frame'].document.location.reload();window.top.frames['header-frame'].document.location.reload()">刷新</a>
					</li>
				</ul>
			</div>
		</div>
		<div id="menu-div">
			<ul>
				<li>
					<a href="Admin_Main.jsp?loginName=<%=a.getLoginName()%>"
						target="main-frame">起始页</a>
				</li>
			</ul>
		</div>
	</body>
</html>