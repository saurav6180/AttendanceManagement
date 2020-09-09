<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<center>

    <h1><h4>Student Details!!!!!!!!!!!!</h4></h1>

    <table border="2"  cellpadding="10px">
        <tr >
            <th bgcolor="#6495ed">Class_Name</th>
            <th bgcolor="#6495ed">Student_Roll</th>
            <th bgcolor="#6495ed">Student_Name</th>
            <th bgcolor="#6495ed">Father_Name</th>
            <th bgcolor="#6495ed">Mother_Name</th>
            <th bgcolor="#6495ed">Address</th>
            <th bgcolor="#6495ed">Date of Joining</th>
        </tr>
        <c:forEach items="${details}" var="dept">
            <tr>

                <td>${dept.class_Name}</td>
                <td>${dept.stdRoll_Number}</td>
                <td>${dept.std_Name}</td>
                <td>${dept.father_Name}</td>
                <td>${dept.mother_Name}</td>
                <td>${dept.address}</td>
                <td>${dept.doj}</td>
            </tr>
        </c:forEach>

    </table></center>