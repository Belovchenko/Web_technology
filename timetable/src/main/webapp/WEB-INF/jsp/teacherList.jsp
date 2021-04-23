<%--
  Created by IntelliJ IDEA.
  User: belovchenko
  Date: 23.04.2021
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Teacher List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h1>Teacher List</h1>

<br/><br/>
<div>
    <table border="1">
        <tr>
            <th>teacher_id</th>
            <th>teacher_name</th>
        </tr>
        <c:forEach  items="${teachers}" var ="teachers">
            <tr>
                <td>${teachers.teacher_id}</td>
                <td>${teachers.teacher_name}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>
