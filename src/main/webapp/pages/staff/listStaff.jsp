<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>

    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>
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
                    postSelect.innerHTML = "<option value = '-1'>--请选择职务--</option>";
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

            xhr.open("POST", "${pageContext.request.contextPath}/getPostByDeptId");

            xhr.send(data);
        }
        function onStaffsQuery() {

            var deptId = document.getElementById("deptID").value;
            var postId = document.getElementById("postID").value;
            var staffName = document.getElementById("staffName").value;
            var data = new FormData();

            data.append("deptID", deptId);
            data.append("postID", postId);
            data.append("staffName",staffName);

            var xhr = new XMLHttpRequest();
            xhr.withCredentials = true;

            xhr.addEventListener("readystatechange", function () {
                if (this.readyState === 4) {
                    console.log(this.responseText);
                    // 对请求回来的数据进行解析
                    json = eval('(' + this.responseText + ')');
                    // 获取服务器的标签
                    serverSelect = document.getElementById("postID");
                    // 获取option标签
                    optionElement = serverSelect.getElementsByTagName("option");
                    // 获取option 的数量
                    length = optionElement.length;
                    // 使用循环清空所有的option标签
                    for (var i = 0; i < length; i++) {
                        serverSelect.removeChild(optionElement[0]);
                    }


                    var tableEle = document.getElementById("staff");
                    var length = tableEle.rows.length
                    for (var i = 0; i < length - 1; i++) {
                        tableEle.deleteRow(1);
                    }

                    for (var i = 0; i < json.length; i++) {
                        var tr = document.createElement("tr");
//                        tr.appendChild(createTD(json[i].staffId));
                        tr.appendChild(createTD(json[i].staffName));
                        tr.appendChild(createTD(json[i].gender));
                        tr.appendChild(createTD(json[i].onDutyDate));
                        tr.appendChild(createTD(json[i].department.deptName));
                        tr.appendChild(createTD(json[i].post.postName));
                        tr.appendChild(createTD())
                        tableEle.appendChild(tr);
                    }


                    function createTD(text) {
                        var td = document.createElement("td");
                        td.setAttribute("align", "center");
                        var textNode = document.createTextNode(text);
                        td.appendChild(textNode);
                        return td;
                    }
                }
            });

            xhr.open("POST", "${pageContext.request.contextPath}/queryStaff");
            xhr.send(data);
        }
    </script>
</head>

<body>
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="39%" align="left">[员工管理]</td>

        <td width="57%" align="right">
            <%--高级查询 --%>
            <a href="javascript:void(0)" onclick="onStaffsQuery()"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif"/></a>
            <%--员工注入 --%>
            <a href="getDeptList_Staff.action"><img src="${pageContext.request.contextPath}/images/button/tianjia.gif"/>
            </a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>

<!-- 查询条件：马上查询 -->
<form method="post">
    <table width="88%" border="0" style="margin: 20px;">
        <tr>
            <td width="80px">部门：</td>
            <td width="200px">

                <select id="deptID" name="department.deptID" onchange="onDeptSelected(value)">
                    <option value="">--请选择部门--</option>
                    <s:iterator value="deptList" var="d">
                        <option value="${d.deptID}">${d.deptName}</option>
                    </s:iterator>
                </select>

            </td>
            <td width="80px">职务：</td>
            <td width="200px">

                <select name="post.postID" id="postID">
                    <option value="">--请选择职务--</option>
                </select>

            </td>
            <td width="80px">姓名：</td>
            <td width="200px"><input type="text" name="staffName" size="12" id="staffName"/></td>
            <td></td>
        </tr>
    </table>
</form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
    <tr>
        <td><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
    </tr>
</table>

<table width="100%" border="1" id="staff">
    <tr class="henglan" style="font-weight:bold;">
        <td width="10%" align="center">员工姓名</td>
        <td width="6%" align="center">性别</td>
        <td width="12%" align="center">入职时间</td>
        <td width="15%" align="center">所属部门</td>
        <td width="10%" align="center">职务</td>
        <td width="10%" align="center">编辑</td>
    </tr>

    <s:iterator value="staffs" var="sta">
        <tr class="tabtd1">
            <td align="center">${sta.staffName}</td>
            <td align="center">${sta.gender}</td>
            <td align="center">${sta.onDutyDate}</td>
            <td align="center">${sta.department.deptName}</td>
            <td align="center">${sta.post.postName}</td>
            <td width="7%" align="center">

                <a href="passStaff.action?staffID=${sta.staffID}&model.post.department.deptID=${sta.department.deptID}&model.post.postID=${sta.post.postID}">
                    <img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
            </td>

        </tr>
    </s:iterator>
</table>


<%-- 
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第1/3页</span>
        <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
    </td>
  </tr>
</table>
--%>
</body>
</html>
