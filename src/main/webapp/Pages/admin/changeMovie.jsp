<%--
  Created by IntelliJ IDEA.
  User: serj27
  Date: 18.07.2016
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменение фильма</title>
</head>
<body>
<table border="1" width="100%">
    <col col1 width="150px">

    <tr>
        <th class="col1">Сёрфинг по кинотеатру</th>
        <th>Как вы хотите изминить фильмы</th>
    </tr>
    <tr>
        <td><p><a href="/app">Главная страничка</a></p></td>
        <td rowspan="200" valign="top" align="center">
            <table width="100%" border="2">
                <tr>
                    <th>Название:</th><th>Описание:</th><th>Что делать с этим фильмом:</th>
                </tr>
                <tr><td><center>${movieDTO.title}</center></td><td>${movieDTO.description}</td><td><center><a href="deleteMovie?id=${movieDTO.id}">Удалить</a><br/><a href="updateMovie?id=${movieDTO.id}">Обновить</a></center></td></tr>
            </table>
        </td>
    </tr>
    <tr>
        <td><p><a href="/app/moviesPage">Фильмы</a></p></td>
    </tr>
    <tr>
        <td><p><a href="/app/pages/admin/admin.jsp">Личный кабинет</a></p></td>
    </tr>
</table>
</body>
</html>
