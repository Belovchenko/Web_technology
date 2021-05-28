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


<form action="/Schedule" method="get">
    <input type="hidden" id="student" name="student" value="${student.student_id}" readonly>
    <input type="datetime-local" placeholder="Начало периода" id="timestamp1" name="timestamp1" required>
    <input type="datetime-local" placeholder="Конец периода" id="timestamp2" name="timestamp2" required>
    <button type="submit" id="showfreeaudit">Показать расписание</button>
</form>


<form action="/deleteStudent?student_id=${student.student_id}" method="post">
    <button type="submit" id="delete_student">Удалить студента</button>
</form>

<form action="/editStudent" method="get">
    <input type="hidden" id="student1" name="student" value="${student.student_id}" readonly>
    <button type="submit" id="edit_student">Изменить данные</button>
</form>

<table>
    <tr>
        <td>ID</td>
        <td>${student.student_id}</td>
    </tr>
    <tr>
        <td>Имя</td>
        <td>${student.student_name}</td>
    </tr>
    <tr>
        <td>Список курсов</td>
        <td>
            <ul>
                <c:forEach var="cs_info" items="${student.courses}">
                    <li>
                            ${cs_info.course.course_id}: ${cs_info.course.course_name}
                    </li>
                </c:forEach>
            </ul>
        </td>
    </tr>
</table>

</body>
</html>
