<%--
  Created by IntelliJ IDEA.
  User: serj27
  Date: 18.07.2016
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" width="100%">
    <col col1 width="150px">
    <tr>
        <th class="col1">Сёрфинг по кинотеатру</th>
        <th>Административное меню</th>
    </tr>
    <tr>
        <td><p><a href="/app">Главеая страничка</a></p></td>
        <td rowspan="200" valign="top">
            <a href="${pageContext.request.contextPath}adminMovie">Управление фильмами</a><br/>
            <a href="${pageContext.request.contextPath}adminSession">Управление сеансами</a><br/>
            <br/>
            <a href="${pageContext.request.contextPath}webapp/Pages/users/myTickets">Мои билеты</a>
        </td>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}webapp/moviesPage">Фильмы</a></p></td>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}webapp/Pages/admin/admin">Лтчный кабинет</a></p></td>
    </tr>
</table>
</body>
</html>
