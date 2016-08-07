<%--
  Created by IntelliJ IDEA.
  User: serj27
  Date: 18.07.2016
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить фильм</title>
</head>
<body>
<table border="1" width="100%">
    <col col1 width="150px">
    <tr>
        <th class="col1">Сёрфинг по кинотеатру</th>
        <th>Заполните информацию о фильме</th>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}../webapp">Главная страничка </a></p></td>
        <td rowspan="200" valign="top" align="center">
            <form name="addMovie" method="get" action="${pageContext.servletContext.contextPath}/thxForAddMovie">
                Title: <input type="text" name="title"/><br/>
                Description: <input type="text" name="description"/><br/>
                Duration: <input type="text" name="duration"/><br/>
                Genre: <input type="text" name="genre"/><br/>
                Rating: <input type="text" name="rating"/><br/>
                Rent Start: Year: <input type="text" name="syear"/> Month: <input type="text" name="smonth"/>: Day: <input type="text" name="sday"/><br/>
                Rent End: Year: <input type="text" name="eyear"/> Month: <input type="text" name="emonth"/>: Day: <input type="text" name="eday"/><br/>
                <input type="submit" value="Добавить"/>
            </form>
        </td>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}../webapp/moviesPage">Фильмы</a></p></td>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}../webapp/Pages/admin/admin">Личный кабинет</a></p></td>
    </tr>
</table>
</body>
</html>
