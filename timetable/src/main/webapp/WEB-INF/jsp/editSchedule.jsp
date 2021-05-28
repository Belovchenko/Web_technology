<%--
  Created by IntelliJ IDEA.
  User: belovchenko
  Date: 26.05.2021
  Time: 14:18
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
    <form id="addingform" action="/editSchedule?course_id=${course.course_id}" method="post">
        <ul>
            <li>
                <label for="teacher" >ID преподавателя</label>
                <input type="text" id="teacher" name="teacher" required>
            </li>
            <li>
                <label for="aud" >Номер аудитории</label>
                <input type="text" id="aud" name="aud" required>
            </li>
            <li>
                <label for="timestamp1" >Дата и время</label>
                <input type="datetime-local" id="timestamp1" name="timestamp1" required>
            </li>
            <button type="submit">Сохранить</button>
        </ul>
    </form>
</div>
</body>
</html>
