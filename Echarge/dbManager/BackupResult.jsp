<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="java.io.InputStreamReader"
	import="java.io.IOException"
	import="java.io.LineNumberReader"%>
<%
	String backupPath = request.getParameter("path"); 
	String bTime = request.getParameter("bTime"); 
	String url = "DB_Backup.jsp";
	//out.println(bTime);
/*	String action = request.getParameter("action");
	if (action != null && action.trim().equals("DB_Backup")) {
		String backupPath = request.getParameter("path");
		String command = "cmd /c mysqldump -uroot -proot --add-locks --opt charge> " + backupPath + "charge.sql";
		try {
			Process process = Runtime.getRuntime().exec(command);
			InputStreamReader ir = new InputStreamReader(process .getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			String line;
			while ((line = input.readLine()) != null){
				System.out.println(line);
			}
			input.close();
			//out.println("数据库已导出到文件charge.sql中");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//response.sendRedirect("DB_Backup.jsp");
		//response.setHeader("Refresh","2;URL=DB_Backup.jsp");
	}
	*/
%>
<html>
	<head>
		<title>备份</title>
	</head>
	<body>
		<center>
			数据库已导出到路径<%=backupPath%>中!
			<br>
			<span id="delay" style="background:red">3</span>秒钟后跳转到上一页面, 或者请点击下面的链接 自己跳转
			<br>
			<a href="<%=url%>"><%=url%></a>
		</center>
		<script type="text/javascript">	
			
			var delay = 3;
			function goBack() {
				document.getElementById("delay").innerHTML=delay;
				delay--;
				if(delay == 0) 
					document.location.href="DB_Backup.jsp";
				else 
					setTimeout(goBack, 1000);
			}
			goBack();
		</script>
	</body>
</html>
