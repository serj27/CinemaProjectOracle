<jsp:useBean id="ticketsDTOs" scope="request" type="java.util.List"/>
<%--
  Created by IntelliJ IDEA.
  User: serj27
  Date: 19.07.2016
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Мои билеты</title>
</head>
<body>
<table border="1" width="100%">
    <col col1 width="150px">
    <tr>
        <th class="col1">Сёрфинг по кинотеатру</th>
        <th>Мои билеты</th>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}../webapp">Главная сраничка</a> </p></td>
        <td rowspan="200" valign="top" align="center">

            <c:forEach items="${ticketsDTOs}" var="ticket">
                Ряд: ${ticket.rowNumber}<br/>
                Место: ${ticket.seatNumber}<br/>
                <br/>
                <br/>
            </c:forEach>
        </td>
    </tr>
    <tr>
    <td><p><a href="${pageContext.request.contextPath}../moviesPage">Фильмы</a> </p></td>
    </tr>
    <td><p><a href="${pageContext.request.contextPath}../Pages/users/personalPage">Личный кабинет</a> </p></td>
</table>
</body>
</html>
