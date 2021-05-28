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

<button onclick="location.href='${pageContext.request.contextPath}/addCourse'" id="add_course">Добавить курс</button>

<table>
    <tr>
        <th>ID</th>
        <th>Название</th>
        <th>Год</th>
    </tr>
    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.course_id}</td>
            <td><a href="${pageContext.request.contextPath}/course?course_id=${course.course_id}">${course.course_name}</a></td>
            <td>${course.year}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
