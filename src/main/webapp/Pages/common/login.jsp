<%--
  Created by IntelliJ IDEA.
  User: serj27
  Date: 19.07.2016
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<c:out value="${sessionScope.message}"/>
<form name="loginForm" method="post" action="${pageContext.servletContext.contextPath}/login">
    Username: <input type="text" name="login"/> <br/>
    Password: <input type="password" name="password"/> <br/>
    <input type="submit" value="Login" />
</form>
<form name="gotoReg" method="post" action="${pageContext.servletContext.contextPath}/registration">
    <input type="submit" value="Registration">
</form>
</body>
</html>
