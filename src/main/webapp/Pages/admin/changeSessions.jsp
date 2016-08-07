<jsp:useBean id="sessionDTOs" scope="request" type="java.util.List"/>
<%--
  Created by IntelliJ IDEA.
  User: serj27
  Date: 18.07.2016
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Сеансы фильма</title>
</head>
<body>
<table border="1" width="100%">
    <col col1 width="150px">

    <tr>
        <th class="col1">Сёрфинг по кинотеатру</th>
        <th>Список доступных сеансов</th>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}../webapp">Главная страничка</a></p></td>
        <td rowspan="200" valign="top" align="center">
            <table width="100%" border="2">
                <tr>
                    <th>Описание:</th><th>Что делать с этим сеансом:</th>
                </tr>

                <c:forEach items="${sessionDTOs}" var="session">
                    <tr><td><a href="${pageContext.request.contextPath}../session?hall_id=${session.hallID}">Сеанс номер ${session.id}</a> Время начала сеанса: ${session.startTime}</td><td><center><a href="${pageContext.request.contextPath}../deleteSessions?id=${session.id}">Удалить</a><br/><a href="${pageContext.request.contextPath}../updateSession?id=${session.id}">Обновить</a></center></td></tr>
                </c:forEach>
            </table>
        </td>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}../webapp/moviesPage">Фильмы</a></p></td>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}../webapp/Pages/admin/admin.jsp">Личный кабинет</a></p></td>
    </tr>
</table>
</body>
</html>
