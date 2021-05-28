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
    <form id="addingform" action="/addTeacher" method="post">
        <ul>
            <li>
                <label for="name" >ФИО</label>
                <input type="text" id="name" name="name" required>
            </li>
            <button type="submit">Сохранить</button>
        </ul>
    </form>
</div>
</body>
</html>
