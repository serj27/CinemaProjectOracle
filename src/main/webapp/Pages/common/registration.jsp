<%--
  Created by IntelliJ IDEA.
  User: serj27
  Date: 19.07.2016
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<form name="registrForm" method="get" action="${pageContext.servletContext.contextPath}/thxForRegistr">
    Firstname: <input type="text" name="firstname"/> <br/>
    Lastname: <input type="text" name="lastname"/> <br/>
    Login: <input type="text" name="login"/> <br/>
    Password: <input type="password" name="password"/> <br/>
    Email: <input type="text" name="email"/> <br/>
    Gender:    <input type="radio" name="gender" value="MALE">Male</input>
    <input type="radio" name="gender" value="FAMALE">Female</input><br/>
    Birthday: Year:<input type="text" name="year"/> Month:<input type="text" name="month"/>: Day:<input type="text" name="day"/> <br/>
    <input type="submit" value="Регистрация" />
</form>
</body>
</html>
