<%--
  Created by IntelliJ IDEA.
  User: belovchenko
  Date: 25.05.2021
  Time: 15:49
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

<input type="text" placeholder="Номер группы" id="search-group" onkeyup="SearchByGroup()">
<input type="text" placeholder="Номер потока" id="search-stream" onkeyup="SearchByStream()">

<button onclick="location.href='${pageContext.request.contextPath}/addStudent'" id="add_student">Добавить студента</button>

<script>
    function SearchByGroup() {
        var input, filter, table, tr, td, i;
        input = document.getElementById("search-group");
        filter = input.value.toUpperCase();
        table = document.getElementById("Students");
        tr = table.getElementsByTagName("tr");

        // Loop through all table rows, and hide those who don't match the search query
        for (i = 1; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[4];
            if (td) {
                if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }

    function SearchByStream() {
        var input, filter, table, tr, td, i;
        input = document.getElementById("search-stream");
        filter = input.value.toUpperCase();
        table = document.getElementById("Students");
        tr = table.getElementsByTagName("tr");

        // Loop through all table rows, and hide those who don't match the search query
        for (i = 1; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[3];
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

<table id="Students">
    <tr>
        <th>ID</th>
        <th>ФИО</th>
        <th>Год обучения</th>
        <th>Поток</th>
        <th>Группа</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.student_id}</td>
            <td><a href="${pageContext.request.contextPath}/student?student_id=${student.student_id}">${student.student_name}</a></td>
            <td>${student.student_year}</td>
            <td>${student.student_stream}</td>
            <td>${student.student_group}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
