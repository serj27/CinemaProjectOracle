<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: serj27
  Date: 18.07.2016
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Управление сеансами</title>
</head>
<body>
<table border="1" width="100%">
    <col col1 width="150px">
    <tr>
        <th class="=col1">Сёофинг по кинотеатру</th>
        <th>Список фильмов:</th>
    </tr>
    <tr>
        <td><p><a href="/app">Главная страничка</a></p></td>
        <td rowspan="200" valign="top" align="center">
            <br/>
            <h4>Выберите фильм, сеанс которого, вы хотите редактировать</h4>
            <c:forEach items="${movieDTOList}" var="movies">
                <a href="changeSessions?id=${movies.id}">${movies.title}</a><br/>
            </c:forEach><br/>
            <a href="addSession.jsp">Добавить сеанс</a>
        </td>
    </tr>
    <tr>
        <td><p><a href="/app/moviesPage">Фильмы</a> </p></td>
    </tr>
    <td><p><a href="/app/pages/admin/admin.jsp">Личный кабинет</a> </p></td>
</table>
</body>
</html>
