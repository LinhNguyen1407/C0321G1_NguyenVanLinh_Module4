<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LINH NGUYEN
  Date: 7/15/2021
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List condiments</h1>
<c:if test="${empty message}">
    <table>
        <c:forEach items="${condiments}" var="condiment">
            <tr>
                <td>${condiment}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${not empty message}">
    <h2>${message}</h2>
</c:if>

</body>
</html>
