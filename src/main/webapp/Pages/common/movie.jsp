<jsp:useBean id="movieDTO" scope="request" type="com.sun.deploy.security.ruleset.RuleId"/>
<jsp:useBean id="movieDTO" scope="request" type="java.util.List"/>
<%--
  Created by IntelliJ IDEA.
  User: serj27
  Date: 19.07.2016
  Time: 0:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${movieDTO.title}</title>
</head>
<body>
<table border="1" width="100%">
    <col col1 width="150px">

    <tr>
        <th class="col1">Сёрфинг по кинотеатру</th>
        <th>Детальная информация о фильме</th>
    </tr>
    <tr>
        <td><p><a href="homePage.jsp">Главная страничка</a></p></td>
        <td rowspan="200" valign="top" align="center">
            <table width="100%" border="2">
                <tr>
                    <th>Название:</th><th>Описание:</th><th>Сеансы:</th>
                </tr>
                <tr><td><center>${movieDTO.title}</center></td><td>${movieDTO.description}</td><td><center><a href="Pages/users/sessionList?movieId=${movieDTO.id}">Список сеансов</a></center></td></tr>
            </table>
        </td>
    </tr>
    <tr>
        <td><p><a href="moviesPage">Фильмы</a></p></td>
    </tr>
    <tr>
        <td><p><a href="Pages/users/personalPage">Личный кабинет</a></p></td>
    </tr>
</table>
</body>
</html>
