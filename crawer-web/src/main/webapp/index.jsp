<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ page import="com.alibaba.fastjson.JSONObject" %>
<%@ page import="com.mk.crawer.utils.CrawerUtils" %>
<%@ page import="com.mk.framework.proxy.server.ProxyServer" %>
<%@ page import="com.mk.framework.proxy.server.ProxyServerManager" %>
<%@ page import="com.mysql.jdbc.StringUtils" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.net.CookieManager" %><%--
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
<form action="/crawer" method="post" name="fm" id="fm">
    <input type="hidden" id="channgeCodeValue" name="channgeCodeValue">
    <input type="hidden" id="unblockresult" name="unblockresult">
</form>
<div class="tipfiled">
    <p id="tip"></p>
</div>

<%--<table>--%>
    <%--<tr>--%>
        <%--<td>剩余被封 ip:</td>--%>
        <%--<td><%=ProxyServerManager.countBadServer()%>--%>
        <%--</td>--%>
    <%--</tr>--%>
    <%--<%--%>
        <%--String challageCode = request.getParameter("channgeCodeValue");--%>

    <%--%>--%>
    <%--<% ProxyServer proxyServer = ProxyServerManager.randomBlock();%>--%>
    <%--<tr>--%>

        <%--<td>ip</td>--%>
        <%--<td><%=proxyServer.getIp()%>--%>
    <%--</tr>--%>
    <%--<tr>--%>

        <%--<td>port</td>--%>
        <%--<td><%=proxyServer.getPort()%>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<%--%>
            <%--String imgurl = null;--%>
            <%--String coke=null;--%>
            <%--Map<String, Object> rtnMap = CrawerUtils.downloadChallageCode(proxyServer);--%>
            <%--if (rtnMap != null){--%>
                <%--imgurl = (String)rtnMap.get("finalName");--%>
                <%--coke = (String)rtnMap.get("QN25");--%>
                <%--Cookie cookie=new Cookie("QN25", coke);--%>
                <%--cookie.setDomain("qunar.com");--%>
                <%--cookie.setPath("/");--%>
                <%--response.addCookie(cookie);--%>
            <%--}--%>
        <%--%>--%>
        <%--<td>验证码</td>--%>
        <%--<td><img src="crawer/<%=imgurl%>"></td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td>输入</td>--%>
        <%--<td><input type="text" id="challagecode"/></td>--%>

    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td><input type="button" id="unblock" value="解封" onclick="unBlock();"/></td>--%>
    <%--</tr>--%>


<%--</table>--%>
<%--<script type="text/javascript">--%>
    <%--function unBlock() {--%>
        <%--document.getElementById("channgeCodeValue").value = document.getElementById("challagecode").value;--%>
        <%--fm.submit();--%>


        <%--<%--%>
            <%--if (!StringUtils.isNullOrEmpty(challageCode)){--%>
                <%--Cookie cookies[] = request.getCookies();--%>
                <%--String cookieInfo ="";--%>
                <%--for (Cookie cookie: cookies){--%>
                   <%--cookieInfo += cookie.getName()+"="+cookie.getValue()+";";--%>
                <%--}--%>
                <%--cookieInfo+=";Domain=.qunar.com;Path=/;";--%>
                <%--String resp = CrawerUtils.postChallageCode(proxyServer,challageCode, cookieInfo);%>--%>
                <%--alert("<%=resp %>");--%>
                <%--document.getElementById("tip").value = <%=resp %>--%>
                <%--<%--%>
                 <%--JSONObject  json = JSON.parseObject(resp);--%>

                 <%--if (json!= null && json.getInteger("code") != -1){--%>
                    <%--ProxyServerManager.removeBlock(proxyServer);--%>
                    <%--System.out.println("******************************解封 "+proxyServer.getIp() +"成功!******************" );--%>
           <%--%>--%>
                <%--alert("解封<%=proxyServer.getIp()%>成功! ")--%>
        <%--<%      }else if(json!= null &&json.getInteger("code") == -1 ){--%>

            <%--System.out.println("******************************解封 "+proxyServer.getIp() +"失败!******************" );--%>
        <%--%>--%>
        <%--alert("解封<%=proxyServer.getIp()%>失败! ")--%>
          <%--<%  }--%>
        <%--}--%>
        <%--%>--%>

    <%--}--%>

<%--</script>--%>

</body>
</html>
