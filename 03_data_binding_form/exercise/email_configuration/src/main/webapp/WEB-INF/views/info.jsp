<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LINH NGUYEN
  Date: 7/16/2021
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Configuration</title>
</head>
<body>
<h2>Show Email Configuration</h2>
<table>
    <tr>
        <td>Languages:</td>
        <td>${emailConf.languages}</td>
    </tr>
    <tr>
        <td>PageSize:</td>
        <td>${emailConf.pageSize}</td>
    </tr>
    <tr>
        <td>Spams Filter:</td>
        <td>
            <c:if test="${emailConf.spamFilter == 'Enable'}">Enable</c:if>
            <c:if test="${emailConf.spamFilter == null}">Disable</c:if>
        </td>
    </tr>
    <tr>
        <td>Signature:</td>
        <td>${emailConf.signature}</td>
    </tr>
</table>
</body>
</html>
