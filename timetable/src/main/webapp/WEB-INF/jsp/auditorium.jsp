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
<div>
    <form action="/aSchedule" method="get">
        <input type="datetime-local" placeholder="Начало периода" id="timestamp1" name="timestamp1" required>
        <input type="datetime-local" placeholder="Конец периода" id="timestamp2" name="timestamp2" required>
        <button type="submit" id="showfreeaudit">Показать расписание</button>
        <input type="hidden" placeholder="Аудитория" id="auditorium" name="auditorium" value="${auditorium.auditorium_num}" readonly>
    </form>
</div>
<table>
    <tr>
        <th>Номер</th>
        <th>Кол-во мест</th>
    </tr>
    <tr>
        <td>${auditorium.auditorium_num}</td>
        <td>${auditorium.capacity}</td>
</table>

</body>
</html>
