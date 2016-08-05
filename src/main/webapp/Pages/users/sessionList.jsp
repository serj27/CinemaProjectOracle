<jsp:useBean id="sessionDTOs" scope="request" type="java.util.List"/>
<%--
  Created by IntelliJ IDEA.
  User: serjd
  Date: 21.07.2016
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список доступных сеансов</title>
</head>
<body>
<table border="1" width="100%">

    <col col1 width="150px">
    <tr>
        <th class="col1">Сёрфинг по кинотеатру</th>
        <th>Список доступных сеансов</th>
    </tr>
   <tr><td><p><a href="${pageContext.request.contextPath}webapp">Главная страничка</a> </p></td>
   <td rowspan="200" valign="top" align="center">

       <c:forEach items="${sessionDTOs}" var="session">
           <a href="session.jsp?hall_id=${session.hallID}&session_id=${session.id}">${session.id}</a><br/>
       </c:forEach>
   </td> </tr>
    <tr><td><p><a href="${pageContext.request.contextPath}webapp/moviesPage">Фильмы</a> </p></td></tr>
    <td><p><a href="${pageContext.request.contextPath}webapp/pages/users/personalPage">Личный кабинет</a> </p></td>
</table>
</body>
</html>
