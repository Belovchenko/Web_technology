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
    <form action="/free_auditoriums" method="get">
        <input type="datetime-local" placeholder="Начало периода" id="timestamp1" name="timestamp1" required>
        <input type="datetime-local" placeholder="Конец периода" id="timestamp2" name="timestamp2" required>
        <button type="submit" id="showfreeaudit">Показать свободные</button>
    </form>
</div>
<table>
    <tr>
        <th>Номер</th>
        <th>Кол-во мест</th>
    </tr>
    <c:forEach var="auditorium" items="${auditoriums}">
        <tr>
            <td><a href="${pageContext.request.contextPath}/auditorium?auditorium_num=${auditorium.auditorium_num}">${auditorium.auditorium_num}</a></td>
            <td>${auditorium.capacity}</td>
    </c:forEach>
</table>

</body>
</html>
