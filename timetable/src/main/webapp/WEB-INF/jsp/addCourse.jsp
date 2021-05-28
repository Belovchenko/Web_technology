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
    <form id="addingform" action="/addCourse" method="post">
        <ul>
            <li>
                <label for="name" >Название курса</label>
                <input type="text" id="name" name="name" required>
            </li>
            <li>
                <label for="year" >Год</label>
                <input type="text" id="year" name="year" required>
            </li>
            <li>
                <label for="teachers" >Введите ID преподавателей через пробел</label>
                <textarea wrap="soft" id="teachers" name="teachers" rows="10" cols="45"></textarea>
            </li>
            <li>
                <label for="students" >Введите ID студентов через пробел</label>
                <textarea wrap="soft" id="students" name="students" rows="10" cols="45"></textarea>
            </li>
            <button type="submit">Сохранить</button>
        </ul>
    </form>
</div>
</body>
</html>
