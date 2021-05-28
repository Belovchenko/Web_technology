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

<form action="/cSchedule" method="get">
    <input type="hidden" id="course" name="course" value="${course.course_id}" readonly>
    <input type="datetime-local" placeholder="Начало периода" id="timestamp1" name="timestamp1" required>
    <input type="datetime-local" placeholder="Конец периода" id="timestamp2" name="timestamp2" required>
    <button type="submit" id="showfreeaudit">Показать расписание</button>
</form>

<form action="/deleteCourse?course_id=${course.course_id}" method="post">
    <button type="submit" id="delete_course">Удалить курс</button>
</form>

<form action="/editCourse" method="get">
    <input type="hidden" id="course1" name="course" value="${course.course_id}" readonly>
    <button type="submit" id="edit_course">Изменить данные</button>
</form>

<form action="/editSchedule" method="get">
    <input type="hidden" id="course2" name="course" value="${course.course_id}" readonly>
    <button type="submit" id="edit_course1">Составить расписание</button>
</form>

<table>
    <tr>
        <td>Название</td>
        <td>${course.course_name}</td>
    </tr>
    <tr>
        <td>Список студентов</td>
        <td>
            <ul>
                <c:forEach var="cs_info" items="${course.course_student_info}">
                    <li>
                            ${cs_info.student.student_id}: ${cs_info.student.student_name}
                    </li>
                </c:forEach>
            </ul>
        </td>
    </tr>
</table>

</body>
</html>
