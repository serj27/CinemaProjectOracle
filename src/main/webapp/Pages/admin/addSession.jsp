<jsp:useBean id="hall" scope="request" type="model.Hall"/>
<jsp:useBean id="hallDTOs" scope="request" type=""/>
<jsp:useBean id="movieDTOs" scope="request" type=""/>

<%--
  Created by IntelliJ IDEA.
  User: serj27
  Date: 18.07.2016
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление фильиа</title>
</head>
<body>
<table border="1" width="100%">
    <col col1 width="150px">
    <tr>
        <th class="col1">Сёрфинг по кинотеатру</th>
        <th>Заполните информацию о сеансе</th>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}webapp">Главная страничка</a></p></td>
        <td rowspan="200" valign="top" align="center">
            <form name="addSession" method="get" action="${pageContext.servletContext.contextPath}thxForAddSession">
                Movie: <select name="movie_id">
                <c:forEach items="${movieDTOs}" var="movies">
                    <option value="${movies.id}">${movies.title}</option>
                </c:forEach>
            </select>
                Hall: <select name="hall_id">
                <c: forEach items="${hallDTOs}" var="hall">
                    <option value="${hall.id}">${hall.hallName}</option>
                </c: forEach>
            </select>
                Price: <input type="text" name="price"/>
                Start Time: Year: <input type="text" name="syear"/> Month: <input type="text" name="smonth"/>: Day: <input type="text" name="sday"/><br/>
                <input type="submit" value="Добавить"/>
            </form>
        </td>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}webapp/moviesPage">Фильмы</a></p></td>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}webapp/Pages/admin/admin">Личный кабинет</a></p></td>
    </tr>
</table>
</body>
</html>
