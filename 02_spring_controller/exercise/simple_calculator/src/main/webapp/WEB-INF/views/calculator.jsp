<%--
  Created by IntelliJ IDEA.
  User: LINH NGUYEN
  Date: 7/15/2021
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/calculate" method="post">

    <input style="margin-bottom: 20px" name="firstOperator" placeholder="fOperator" value="${firstOperator}">
    <input style="margin-bottom: 20px" name="secondOperator" placeholder="sOperator" value="${secondOperator}">
    <br>
    <input type="submit" name="operand" value="Addition(+)">
    <input type="submit" name="operand" value="Subtraction(-)">
    <input type="submit" name="operand" value="Multiplication(x)">
    <input type="submit" name="operand" value="Division(/)">

    <p>Result ${operand} : ${result}</p>
</form>
</body>
</html>
