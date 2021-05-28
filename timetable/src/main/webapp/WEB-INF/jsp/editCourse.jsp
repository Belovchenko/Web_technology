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
    <form id="addingform" action="/editCourse?course_id=${course.course_id}" method="post">
        <ul>
            <li>
                <label for="name" >Название</label>
                <input type="text" id="name" name="name" value="${course.course_name}" required>
            </li>
            <li>
                <label for="year" >Год обучения</label>
                <input type="text" id="year" name="year" value="${course.year}" required>
            </li>
            <li>
                <label for="students" >ID студентов через пробел</label>
                <textarea wrap="soft" id="students" name="students" rows="10" cols="45">${students}</textarea>
            </li>
            <li>
                <label for="teachers" >ID преподавателей через пробел</label>
                <textarea wrap="soft" id="teachers" name="teachers" rows="10" cols="45">${teachers}</textarea>
            </li>
            <button type="submit">Сохранить изменения</button>
        </ul>
    </form>
</div>
</body>
</html>