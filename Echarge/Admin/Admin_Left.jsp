<%@ page language="java" import="java.util.*" contentType="text/html;charset=gb2312" %>
<%@ page import="com.Echarge.Authority.*"%>
<%@ page import="com.Echarge.admin.*"%>
<%
	//检查session，获取登录用户
	Admin a = (Admin) session.getAttribute("admin");
	String roleName = a.getAdminType();
	
	List<Authority> authoritys = new ArrayList<Authority>();
	int totalRecords = Authority.getAuthoritys1(authoritys, roleName);
	//指定角色的 权限信息列表，按一级菜单合并
	
%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate" />
	<meta http-equiv="expires" content="Wed, 26 Feb 1970 08:21:57 GMT" />
	<title>Echarge Menu</title>
	<link href="styles/general.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
    body {
      background: #80BDCB;
    }
    #tabbar-div {
      background: #278296;
      padding-left: 10px;
      height: 21px;
      padding-top: 0px;
    }
    #tabbar-div p {
      margin: 1px 0 0 0;
    }
    .tab-front {
      background: #80BDCB;
      line-height: 20px;
      font-weight: bold;
      padding: 4px 15px 4px 18px;
      border-right: 2px solid #335b64;
      cursor: hand;
      cursor: pointer;
    }
    #main-div {
      border: 1px solid #345C65;
      padding: 5px;
      margin: 5px;
      background: #FFF;
    }
    #menu-list {
      padding: 0;
      margin: 0;
    }
    #menu-list ul {
      padding: 0;
      margin: 0;
      list-style-type: none;
      color: #335B64;
    }
    #menu-list li {
      padding-left: 16px;
      line-height: 16px;
      cursor: hand;
      cursor: pointer;
    }
    #main-div a:visited, #menu-list a:link, #menu-list a:hover {
      color: #335B64
      text-decoration: none;
    }
    #menu-list a:active {
      color: #EB8A3D;
    }
    .explode {
      background: url(images/menu_minus.gif) no-repeat 0px 3px;
      font-weight: bold;
    }
    .collapse {
	  background: url(images/menu_plus.gif) no-repeat 0px 3px;
  	  font-weight: bold;
	}
    .menu-item {
      background: url(images/menu_arrow.gif) no-repeat 0px 3px;
      font-weight: normal;
    }
    </style>

	</head>
<body> 
<div id="tabbar-div">
<p><span style="float:right; padding: 3px 5px;" >
<img src="images/menu_minus.gif" alt="闭合" name="toggleImg" width="9" height="9" border="0" id="toggleImg" style="cursor: hand;" />
</span>
  <span class="tab-front" id="menu-tab">菜单</span></p>
</div>
<div id="main-div">
			<div class="menu-item" id="menu-list">
				<ul>
					<%
					for (int i = 0; i < authoritys.size(); i++){
    					Authority au = authoritys.get(i);
    					String lev1Menu = au.getLev1Menu();
   						if(au.getMenuFlag()==1){
    				%>
					<li class="explode" id="img_<%=i%>">
						<span onclick="toggleCollapse(<%=i%>);"><%=lev1Menu%></span>
						<ul id="collapse_<%=i%>">
							<%
							List<Authority> authoritys2 = new ArrayList<Authority>();
							int totalRecords2 = Authority.getAuthoritys2(authoritys2, roleName, lev1Menu);
							//指定角色的 权限信息列表，指定一级菜单
							for (int j = 0; j < authoritys2.size(); j++){
   								Authority au2 = authoritys2.get(j);
   								if(au2.getMenuFlag()==1){
    						%>
							<li class="menu-item">
								<a href="<%=au2.getMenuLink()%>" target="main-frame"><%=au2.getLev2Menu()%></a>
							</li>
							<%
								}
							}
							%>
						</ul>
					</li>
					<%
						}
					}
					%>
				</ul>
			</div>
		</div>
	<script language="javascript">
	document.getElementById('toggleImg').onclick = function() {
	  var h = -1;
	  if(document.getElementById('toggleImg').alt == "展开") {
	 	  for(h=0;h<<%=authoritys.size()%>;h++){
		 	  var item = document.getElementById('collapse_'+h);
		 	  var explodebg = document.getElementById('img_'+h);
		 	  item.style.display = "";
		 	  document.getElementById('toggleImg').src='images/menu_minus.gif';
		 	  document.getElementById('toggleImg').alt='闭合';
		 	  explodebg.className="explode";
	 	  }
	  } else {
	 	  for(h=0;h<<%=authoritys.size()%>;h++){
		 	  var item = document.getElementById('collapse_'+h);
		 	  var explodebg = document.getElementById('img_'+h);
		 	  item.style.display = "none";
		 	  document.getElementById('toggleImg').src='images/menu_plus.gif';
		 	  document.getElementById('toggleImg').alt='展开';
		 	  explodebg.className="collapse";
	 	  }
	   }
	 }
 	
 	function toggleCollapse(e){
 		  var item = document.getElementById('collapse_'+e);
	 	  var explodebg = document.getElementById('img_'+e);
	 	  if(item.style.display == "none") {
	 	  	item.style.display = "";
	 	  	explodebg.className="explode";
	 	  } else {
	 	  	item.style.display ="none";
	 	  	explodebg.className="collapse";
	 	  }
 	}
	</script>
</body>
</html>
