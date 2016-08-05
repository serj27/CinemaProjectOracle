<jsp:useBean id="userDTO" scope="request" type="dto.UserDTO"/>
<%--
  Created by IntelliJ IDEA.
  User: serj27
  Date: 21.07.2016
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Личный кабинет</title>
</head>
<body>
<table border="1" width="100%">
    <col col1 width="150px">

    <tr>
        <th class="col1">Сёрфинг по кинотеатру</th>
        <th> Информация о профиле</th>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}webapp">Главная страничка</a></p></td>
        <td rowspan="200" valign="top">
            Firstname: ${userDTO.firstName}<br/>
            Lastname: ${userDTO.secondName} <br/>
            Login: ${userDTO.login} <br/>
            Password: ${userDTO.password} <br/>
            Email: ${userDTO.email} <br/>
            Sex:   ${userDTO.gender} <br/>
            Birthday: ${userDTO.birthday}<br/>
            <br/>
            <a href="myTickets.jsp">Мои билеты</a>
        </td>
    </tr>
    <tr>
        <td><p><a href="${pageContext.request.contextPath}webapp/moviesPage">Фильмы</a></p></td>
    </tr>
    <tr>
        <td><p><a href="personalPage.jsp">Личный кабинет</a></p></td>
    </tr>
</table>
</body>
</html>
