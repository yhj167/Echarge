<%@ page language="java" contentType="text/html;charset=gb2312"%>
<%@ page import="java.util.*"%>
<%@ page import="com.Echarge.Analysis.*"%>
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
	request.setCharacterEncoding("GBK");
	//int aID = Integer.parseInt(request.getParameter("aID"));
	int aID = 1;
	if (request.getParameter("aID") != null && !"".equals(request.getParameter("aID"))) {
		aID = Integer.parseInt(request.getParameter("aID"));
	}
	Analysis au = Analysis.loadById(aID);
	String action = request.getParameter("action");
	if (action != null && action.trim().equals("EquipAnalysisModi")) {
		//String equipName = request.getParameter("equipName");
		//String equipModel = request.getParameter("equipModel");
		String equipNo = request.getParameter("equipNo");
		String noteMsg = request.getParameter("noteMsg");
		//String intactFlag = request.getParameter("intactFlag");
		//int useNum = Integer.parseInt(request.getParameter("useNum"));
		//Double useTime = Double.parseDouble(request.getParameter("useTime")); 
		//au.setEquipName(equipName);
		//au.setEquipModel(equipModel);
		au.setEquipNo(equipNo);
		au.setNoteMsg(noteMsg);
		//au.setIntactFlag(intactFlag);
		//au.setUseNum(useNum);
		//au.setUseTime(useTime);
		au.update();
		out.println("修改成功!");
		response.sendRedirect("EquipAnalysis.jsp");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>Echarge 管理中心 - 修改设备使用分析</title>
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
				equipName : {
					required : true,
					rangelength : [ 2, 12 ]
				},
				equipModel : {
					required : true,
					rangelength : [ 2, 12 ]
				},
				equipNo:{
					required:true,
					rangelength:[5,5],
					digits:true
				},
				intactFlag:{
					required:true
				},
				useNum:{
					required:true,
					digits:true
				},
				rDate:{
					required:true
				}
			},
			messages : {
				equipName : {
					required : "设备名称不能为空",
					rangelength : "设备名称应为2-12位之间"
				},
				equipModel : {
					required : "设备型号不能为空",
					rangelength : "说明型号应为2-12位之间"
				},
				equipNo:{
					required:"设备编号不能为空",
					rangelength:"设备编号应为5位",
					digits:"必须是整数数字"
				},
				intactFlag:{
					required:"请选择设备状态。"
				},
				useNum:{
					required:"设备使用次数不能为空",
					digits:"设备使用次数为整数数字"
				},
				rDate:{
					required:"设备注册时间不能为空"
				}
			},
			errorPlacement : function(error, element) {
				error.appendTo(element.next().find("span"));
			}
		});
	});
</script>
		<script language="javascript">
	document.form1.loginName.focus;
	function CheckForm() {
		var theform = document.form1;
		if (theform['equipName'].value == "") {
			alert("设备名称不能为空!");
			theform.equipName.focus();
			return false;
		}
		if (theform['equipNo'].value == "") {
			alert("设备编号不能为空!");
			theform.equipNo.focus();
			return false;
		}
		if (theform['firstTime'].value == "") {
			alert("开始时间不能为空!");
			theform.firstTime.focus();
			return false;
		}		
		if (theform['lastTime'].value == "") {
			alert("结束时间不能为空!");
			theform.lastTime.focus();
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
			<span class="action-span"></span><span>Echarge 管理中心 - 修改设备使用分析</span>
					</h1>
				</td>
				</tr>
			</tbody>
		</table>
		<br/>

		<div class="fill_message">
			<form name="form1" method="post" action="EquipAnalysisModi.jsp" id="f">
			<input type="hidden" name="action" value="EquipAnalysisModi" />
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							充电桩号:
						</td>
						<td>
							<div class="text_input"><%=au.getEquipNo()%></div>
							<input name="equipNo" type="hidden" id="equipNo" class="text_input" value="<%=au.getEquipNo()%>"/>
							<div class="text_left" id="equipNoValidMsg">
								<p>
									设备编号由5位整数数字组成，前三位表示设备种类，后两位表示设备号。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							备注:
						</td>
						<td>
							<input name="noteMsg" type="text" id="noteMsg" class="text_input" value="<%=au.getNoteMsg()%>"/>
							<div class="text_left" id="useNumValidMsg">
								<p>
									
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<!-- <tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							请填写设备名称:
						</td>
						<td>
							<input name="equipName" type="text" id="equipName" class="text_input" value="<%=au.getEquipName()%>"/>
							<div class="text_left" id="equipNameValidMsg">
								<p>
									设备名称必须由中文组成，长度2－12个字符，一个汉字为一个字符。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							请填写设备型号:
						</td>
						<td>
							<input name="equipModel" type="text" id="equipModel" class="text_input" value="<%=au.getEquipModel()%>"/>
							<div class="text_left" id="equipModelValidMsg">
								<p>
									设备型号可以由大小写英文字母、数字和下划线组成，长度2－12个字符。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							设备是否可用:
						</td>
						<td>
							<select name="intactFlag" class="text_input">
								<option value="">请选择</option>
								<option value="是">是</option>
								<option value="否">否</option>
							</select>
							<div class="text_left" id="intactFlagValidMsg">
								<p>
									&nbsp;请选择设备状态。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							设备使用次数:
						</td>
						<td>
							<input name="useNum" type="text" id="useNum" class="text_input" value="<%=au.getUseNum()%>"/>
							<div class="text_left" id="useNumValidMsg">
								<p>
									设备使用次数由整数数字组成。
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr> -->
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							设备注册日期:
						</td>
						<td>
							<div class="text_input"><%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(au.getrDate())%></div>
							<div class="text_left" id="rDateValidMsg">
								<p>
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
						<span id="mcname" style="color:red">*</span>
							设备使用时间:
						</td>
						<td>
							<div class="text_input"><%=au.getUseTime()%></div>
							<input name="useTime" type="hidden" id="useTime" class="text_input" value="<%=au.getUseTime()%>"/>
							<div class="text_left" id="useTimeValidMsg">
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
		<script> document.form1.intactFlag.value="<%=au.getIntactFlag()%>"</script>
	</body>
</html>