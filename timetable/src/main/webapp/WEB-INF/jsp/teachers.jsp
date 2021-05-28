<%--
  Created by IntelliJ IDEA.
  User: belovchenko
  Date: 25.05.2021
  Time: 20:57
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

<input type="text" placeholder="Название курса" id="search-course" onkeyup="SearchByCourse()">

<button onclick="location.href='${pageContext.request.contextPath}/addTeacher'" id="add_teacher">Добавить преподавателя</button>

<script>
    function SearchByCourse() {
        var input, filter, table, tr, td, i;
        input = document.getElementById("search-course");
        filter = input.value.toUpperCase();
        table = document.getElementById("Teachers");
        tr = table.getElementsByTagName("tr");

        // Loop through all table rows, and hide those who don't match the search query
        for (i = 1; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[2];
            if (td) {
                if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>

<table id="Teachers">
    <tr>
        <th>ID</th>
        <th>ФИО</th>
        <th>Курсы</th>
    </tr>
    <c:forEach var="teacher" items="${teachers}">
        <tr>
            <td>${teacher.teacher_id}</td>
            <td><a href="${pageContext.request.contextPath}/teacher?teacher_id=${teacher.teacher_id}">${teacher.teacher_name}</a></td>
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
    </c:forEach>
</table>

</body>
</html>
