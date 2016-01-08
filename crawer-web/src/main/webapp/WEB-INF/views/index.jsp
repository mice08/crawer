<%@ page import="com.mk.crawer.utils.CrawerUtils" %><%--
  Created by IntelliJ IDEA.
  User: kirinli
  Date: 15/9/9
  Time: 下午6:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>爬虫系统</title>
</head>
<body>
<h1>Hello, crawler</h1>
<form action="index.jsp" method="post" name="fm" id="fm">
    <input type="hidden" id="channgeCodeValue" name="channgeCodeValue">
</form>
<div class="tipfiled">
    <p id="tip"> </p>
</div>
<table>
    <tr>
        <td>ip</td>
        <td><%=%>
    </tr>
    <tr>
        <td>验证码</td>
        <td><img src="<%CrawerUtils.downloadChallageCode()%>"></td>
    </tr>
    <tr>
        <td>输入</td>
        <input type="text" id="challagecode"/>

    </tr>
    <tr>
        <td><input type="button" id="unblock" value="解封" onclick="unBlock();"/></td>
    </tr>


</table>
<script type="text/javascript">
    function unBlock() {
        document.getElementById("channgeCodeValue").value =   document.getElementById("challagecode").value;
        fm.submit();

        <%
            String challageCode =  request.getParameter("channgeCodeValue");

        %>

        document.getElementById("tip").value =  = <%= CrawerUtils.postChallageCode(proxyServer,challageCode);%>

    }
</script>

</body>
</html>
