<jsp:useBean id="movieDTOList" scope="request" type="java.util.List"/>
<%--
  Created by IntelliJ IDEA.
  User: serj27
  Date: 19.07.2016
  Time: 0:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Фильмы</title>
</head>
<body>
<table border="1" width="100%">
    <col col1 width="150px">

    <tr>
        <th class="col1">Сёрфинг по кинотеатру</th>
        <th>Список Фильмов:</th>
    </tr>
    <tr>
        <td><p><a href="${pageContext.servletContext.contextPath}../webapp">Главная страничка</a></p></td>
        <td rowspan="200" valign="top" align="center">

            <c:forEach items="${movieDTOList}" var="movies">
                <a href="${pageContext.servletContext.contextPath}/movie?id=${movies.id}">${movies.title}</a><br/>
            </c:forEach></td>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}../moviesPage.jsp">Фильмы</a></p></td>
    </tr>
    <td><p><a href="${pageContext.request.contextPath}../Pages/users/personalPage">Личный кабинет</a></p></td>
</table>
</body>
</html>
