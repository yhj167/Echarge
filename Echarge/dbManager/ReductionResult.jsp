<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="java.io.InputStreamReader"
	import="java.io.IOException"
	import="java.io.LineNumberReader"%>
<%	
	String path =null;
	String url = "http://localhost/dbManager/DB_Reduction.jsp";
	String action = request.getParameter("action");
	if (action != null && action.trim().equals("DB_Reduction")) {
		Runtime rt = Runtime.getRuntime();
		rt.exec("cmd /c mysqladmin -uroot -proot create charge");
		path = request.getParameter("path");//路径
		String command = "cmd /c mysql -uroot -h 10.22.78.218 -proot charge < " + path;
		try {
			Process process = rt.exec(command);
			InputStreamReader ir = new InputStreamReader(process .getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			String line;
			while ((line = input.readLine()) != null){
				System.out.println(line);
			}
			input.close();
			//out.println("文件charge.sql已导入到数据库中");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//response.sendRedirect("DB_Reduction.jsp");
	}
%>
<html>
	<head>
		<title>备份</title>
	</head>
	<body>
		<center>
			路径<%=path%>中的sql文件已导入到数据库中!
			<br>
			<span id="delay" style="background:red">3</span>秒钟后跳转到上一页面, 或者请点击下面的链接 自己跳转
			<br>
			<a href="<%=url%>"><%=url%></a>
		</center>
		<script type="text/javascript">	
			
			var delay = 3;
			function goBack() {
				document.getElementById("delay").innerHTML=delay;
				delay --;
				if(delay == 0) 
					document.location.href='<%=url%>';
				else 
					setTimeout(goBack, 2000);
			}
			goBack();
		</script>
	</body>
</html>
