<%--
  Created by IntelliJ IDEA.
  User: serj27
  Date: 21.07.2016
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>СеансХолл</title>
</head>
<body>
<table border="1" width="100%">
    <col col1 width="150px">

    <tr>
        <th class="col1">Сёрфинг по кинотеатру</th>
        <th>Список мест в зале</th>
    </tr>
    <tr>
        <td><p><a href="/app">Главная страничка</a></p></td>
        <td rowspan="200" valign="top" align="center">
            <form name="seats" method="post" action="${pageContext.servletContext.contextPath}/thxForBuyTickets?session_id=${sessionDTO.id}">
                <c:forEach items="${rowsDTOs}" var="row">
                    <c:forEach var="seat" begin="1" end="${row.amountSeats}">
                        <input type="checkbox" name="row-seat" value="${row.rowNumber}-${seat}">
                    </c:forEach>
                    <br/>
                </c:forEach>
                <input type="submit" value="Покупка"/></form></td>
    </tr>
    <tr>
        <td><p><a href="/app/moviesPage">Фильмы</a></p></td>
    </tr>
    <td><p><a href="/app/pages/users/personalPage">Личный кабинет</a></p></td>
</table>
</body>
</html>
