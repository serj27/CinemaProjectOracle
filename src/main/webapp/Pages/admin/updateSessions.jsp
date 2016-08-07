<jsp:useBean id="sessionDTO" scope="request" type="com.sun.corba.se.impl.ior.GenericIdentifiable"/>
<%--
  Created by IntelliJ IDEA.
  User: serj27
  Date: 18.07.2016
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Обновление сеанса</title>
</head>
<body>
<table border="1" width="100%">
    <col col1 width="150px">

    <tr>
        <th class="col1">Сёрфинг по кинотеатру</th>
        <th>Заполните информацию о сеансе</th>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}../webapp">Главная страничка</a></p></td>
        <td rowspan="200" valign="top" align="center">
            <form name="updForm" method="post" action="${pageContext.servletContext.contextPath}/thxForUpdateSession?&id=${sessionDTO.id}">
                Start time: Year:<input type="text" name="syear"/> Month:<input type="text" name="smonth"/>: Day:<input type="text" name="sday"/> <br/>
                Price: <input type="text" name="price"/>
                <input type="submit" value="Обновить" />
            </form>
        </td>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}../webapp/moviesPage">Фильмы</a></p></td>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}webapp/Pages/admin/admin.jsp">Личный кабинет</a></p></td>
    </tr>
</table>
</body>
</html>
