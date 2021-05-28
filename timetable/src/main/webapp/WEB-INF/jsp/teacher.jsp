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

<form action="/tSchedule" method="get">
    <input type="hidden" id="teacher" name="teacher" value="${teacher.teacher_id}" readonly>
    <input type="datetime-local" placeholder="Начало периода" id="timestamp1" name="timestamp1" required>
    <input type="datetime-local" placeholder="Конец периода" id="timestamp2" name="timestamp2" required>
    <button type="submit" id="showfreeaudit">Показать расписание</button>
</form>

<form action="/deleteTeacher?teacher_id=${teacher.teacher_id}" method="post">
    <button type="submit" id="delete_teacher">Удалить преподавателя</button>
</form>

<form action="/editTeacher" method="get">
    <input type="hidden" id="teacher1" name="teacher" value="${teacher.teacher_id}" readonly>
    <button type="submit" id="edit_student">Изменить данные</button>

<table id="Teachers">
    <tr>
        <th>ID</th>
        <th>ФИО</th>
        <th>Курсы</th>
    </tr>
    <tr>
        <td>${teacher.teacher_id}</td>
        <td>${teacher.teacher_name}</td>
        <td>
            <ul>
                <c:forEach var="ct_info" items="${teacher.course_teacher_info}">
                    <li>
                            ${ct_info.course.course_name}
                    </li>
                </c:forEach>
            </ul>
        </td>
    </tr>

</table>

</body>
</html>
