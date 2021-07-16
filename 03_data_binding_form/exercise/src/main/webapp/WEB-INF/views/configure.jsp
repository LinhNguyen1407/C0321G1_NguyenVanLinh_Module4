<%--
  Created by IntelliJ IDEA.
  User: LINH NGUYEN
  Date: 7/16/2021
  Time: 10:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Configuration</title>
    <style>
        td {
            height: 10px;
        }
    </style>
</head>
<body>
<h3>Setting</h3>
<form:form action="update" method="post" modelAttribute="emailConf">
    <fieldset>
        <legend>Update</legend>
        <table>
            <tr>
                <td><form:label path="languages">Languages:</form:label></td>
                <td>
                    <form:select path="languages">
                        <form:option value="English" label="English"/>
                        <form:option value="Vietnamese" label="Vietnamese"/>
                        <form:option value="Japanese" label="Japanese"/>
                        <form:option value="Chinese" label="Chinese"/>
                    </form:select>
                </td>
            </tr>
            <tr class="row">
                <td><form:label path="pageSize">PageSize:</form:label></td>
                <td>
                    Show<form:select path="pageSize">Show
                    <form:option value="5" label="5"/>
                    <form:option value="10" label="10"/>
                    <form:option value="25" label="25"/>
                    <form:option value="50" label="50"/>
                </form:select>emails per page
                </td>
            </tr>
            <tr class="row">
                <td><form:label path="spamFilter">Spams Filter:</form:label></td>
                <td><form:checkbox path="spamFilter" value="Enable"/>Enable spams filter</td>
            </tr>
            <tr class="row">
                <td><form:label path="signature">Signature:</form:label></td>
                <td><form:textarea path="signature"/></td>
            </tr>
            <tr class="row">
                <td></td>
                <td>
                    <form:button>Update</form:button>
                    <input type="reset" value="Cancel">
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>