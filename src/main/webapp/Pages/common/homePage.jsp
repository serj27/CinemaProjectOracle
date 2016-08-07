<%--
  Created by IntelliJ IDEA.
  User: serj27
  Date: 18.07.2016
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная страничка</title>
</head>
<body>
<table border="1" width="100%">
    <col col1 width="150px">

    <tr>
        <th class="col1">Сёрфинг по кинотеатру</th>
        <th>Краткое описание кинотеатра</th>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}../homePage.jsp">Главная страничка</a></p></td>
        <td rowspan="200" valign="top" align="center">Сайт кинотеатра был создан<br> адептом Oracle Academy
            serj277 Дьяченко<br>
            в 2016 году
        </td>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}../moviesPage.jsp">Фильмы</a></p></td>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}../Pages/users/personalPage">Личный кабинет</a></p></td>
    </tr>
</table>

</body>
</html>
