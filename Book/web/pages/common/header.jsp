<%--
  Created by IntelliJ IDEA.
  User: 13360
  Date: 2021/2/4
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
                        request.getServerName() + ":" +
                        request.getServerPort() +
                        request.getContextPath() + "/";
    request.setAttribute("basePath", basePath);
%>
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/js/jquery-3.5.1.min.js"></script>
