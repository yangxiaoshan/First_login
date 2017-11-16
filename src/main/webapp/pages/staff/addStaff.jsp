<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
<script>
	function onDeptSelected(value) {
		var data = new FormData();
		data.append("deptID", value);

		var xhr = new XMLHttpRequest();
		xhr.withCredentials = true;

		xhr.addEventListener("readystatechange", function () {
			if (this.readyState === 4) {
				console.log(this.responseText);

				json = eval('(' + this.responseText + ')');
				//获取服务器的标签
				postSelect = document.getElementById("postID");
				//获取option标签
				optionEle = postSelect.getElementsByTagName("option")
				//获取option数量
				length = optionEle.length;
				//使用循环清空所有的option标签
				for (var i = 0; i < length; i++) {
					postSelect.removeChild(optionEle[0]);
				}
				postSelect.innerHTML = "<option value = '-1'>--请选择--</option>";
				//将json数据插入到option中
				for (var i = 0; i < json.length; i++) {
					//创建一个option标签
					option = document.createElement("option");
					//设置value属性
					option.setAttribute("value", json[i].postID);
					//设置文本信息
					text = document.createTextNode(json[i].postName);
					//把文本信息添加到option标签中
					option.appendChild(text);
					//把option标签添加到servers的select中
					postSelect.appendChild(option);
				}
			}
		});

		xhr.open("POST", "http://localhost:8080/getPostByDeptId");

		xhr.send(data);
	}
</script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<form action="addStaff.action" method="post">
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td><input type="text" name="loginName" value="" /> </td>
	    <td>密码：</td>
	    <td><input type="password" name="loginPwd" value=""/> </td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td><input type="text" name="staffName" value="" id="staffAction_add_staffName"/> </td>
	    <td>性别：</td>
	    <td><input type="radio" name="gender"  value="男"/>男
	    	<input type="radio" name="gender"  value="女"/>女
		</td>
	  </tr>
	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%">

	    	<select id="deptID" name="model.department.deptID" onchange="onDeptSelected(value)">

				<s:iterator value="departments" var="dep">
			    <option value="${dep.deptID}">${dep.deptName}</option>
				</s:iterator>
			</select>

	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">
	    	<select id="postID" name="model.post.postID">
	    		<option value="-1">----请--选--择----</option>
	    	</select>
	    </td>
	  </tr>
	   <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
	    	<input type="text" name="onDutyDate" value="" readonly="readonly"  onfocus="c.showMoreDay=true; c.show(this);" />
	    </td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
	</table>
</form>
</body>
</html>
