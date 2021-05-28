<%--
  Created by IntelliJ IDEA.
  User: belovchenko
  Date: 26.05.2021
  Time: 0:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../WEB-INF/jsp/include.jsp" %>
<!DOCTYPE HTML>
<html>

<div>
    <%@ include file="../../WEB-INF/jsp/navbar.jsp" %>
</div>

<body>

<table>
    <tr>
        <th>Курс</th>
        <th>Преподаватель</th>
        <th>Аудитория</th>
        <th>Время</th>
    </tr>
    <c:forEach var="schedule" items="${schedule}">
        <tr>
            <td>${schedule.course.course_name}</td>
            <td>${schedule.teacher.teacher_name}</td>
            <td>${schedule.auditorium.auditorium_num}</td>
            <td>${schedule.time}</td>
    </c:forEach>
</table>

</body>
</html>
