<jsp:useBean id="movieDTO" scope="request" type="com.sun.deploy.security.ruleset.RuleId"/>
<jsp:useBean id="movieDTO" scope="request" type="java.util.List"/>
<%--
  Created by IntelliJ IDEA.
  User: serjd
  Date: 04.08.2016
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удалить фильм</title>
</head>
<body>
<table border="1" width="100%">
    <col col1 width="150px">

    <tr>
        <th class="col1">Сёрфинг по кинотеатру</th>
        <th>Вы хотите удалить фильм?</th>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}../webapp">Главная страничка</a></p></td>
        <td rowspan="200" valign="top" align="center">
            <table width="100%" border="2">
                <tr>
                    <th>Название:</th><th>Описание:</th><th>Что делать с этим фильмом:</th>
                </tr>

                <tr><td><center>${movieDTO.title}</center></td><td>${movieDTO.description}</td><td><center><a href="${pageContext.request.contextPath}../deleteMovie.jsp?id=${movieDTO.id}">Удалить</a><br/>
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
