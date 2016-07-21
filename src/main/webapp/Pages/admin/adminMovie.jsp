<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: serj27
  Date: 18.07.2016
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Управление фильмами</title>
</head>
<body>
<table border="1" width="100%">
    <col col1 width="150px">
    <tr>
        <th class="col1">Сёрфинг по кнотеатру</th>
        <th>Список фильмов:</th>
    </tr>
    <tr>
        <td><p><a href="/app">Главная страничка</a></p></td>
        <td rowspan="200" valign="top" align="center">
            <br/>
            <h4>Выберите фильм, который вы хотите редактировать</h4>
            <c:forEach items="${movieDTOList}" var="movies">
                <a href="changeMovie.jsp?id=${movies.id}">${movies.title}</a><br/>
            </c:forEach>
            <a href="addMovie.jsp">Добавить фильм</a>
        </td>
    </tr>
    <tr>
        <td><p><a href="/app/pages/admin/admin.jsp">Личный кабинет</a></p></td>
    </tr>
</table>
</body>
</html>
