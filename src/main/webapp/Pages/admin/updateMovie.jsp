<jsp:useBean id="movieDTO" scope="request" type="com.sun.corba.se.impl.ior.GenericIdentifiable"/>
<%--
  Created by IntelliJ IDEA.
  User: serj27
  Date: 18.07.2016
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Обновление фильма</title>
</head>
<body>
<table border="1" width="100%">
    <col col1 width="150px">

    <tr>
        <th class="col1">Сёрфинг по кинотеатру</th>
        <th>Заполните информацию о фильме</th>
    </tr>
    <tr>

        <td><p><a href="${pageContext.servletContext.contextPath}webapp">Главная страничка</a></p></td>
        <td rowspan="200" valign="top" align="center">
            <form name="updForm" method="post" action="${pageContext.servletContext.contextPath}/thxForUpdateMovie?&id=${movieDTO.id}">
                Title: <input type="text" name="title"/> <br/>
                Description: <input type="text" name="description"/> <br/>
                Duration: <input type="text" name="duration"/> <br/>
                Genre: <input type="text" name="genre"/> <br/>
                Rating: <input type="text" name="rating"/> <br/>
                Rent Start: Year:<input type="text" name="syear"/> Month:<input type="text" name="smonth"/>: Day:<input type="text" name="sday"/> <br/>
                Rent End: Year:<input type="text" name="eyear"/> Month:<input type="text" name="emonth"/>: Day:<input type="text" name="eday"/> <br/>
                <input type="submit" value="Обновить" />
            </form>
        </td>
    </tr>
    <tr>
        <td><p><a href="${pageContext.servletContext.contextPath}webapp/moviesPage">Фильмы</a></p></td>
    </tr>
    <tr>
        <td><p><a href="${pageContext.servletContext.contextPath}webapp/Pages/admin/admin">Личный кабинет</a></p></td>
    </tr>
</table>
</body>
</html>
