<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 style="color: blue">Attendance Form</h1>

<c:url value="/attendanceAction" var="forUrl"/>
<h1>Mark your attendance on ${date}</h1>
<h1>${result}</h1>
<c:choose>
    <c:when test="${!empty studentsList.wrapperList}">
        <form:form modelAttribute="studentsList" action="${forUrl}" method="post">
            <table border="2" cellpadding="10px">
                    <%--<tr> <td><form:input path="date"  type="Date" /></td></tr>--%>
                <tr>
                    <th bgcolor="#6495ed">Class_Name</th>
                    <th bgcolor="#6495ed">Student_RollNumber</th>
                    <th bgcolor="#6495ed">Student_Name</th>
                    <th bgcolor="#6495ed">Father_Name</th>
                    <th bgcolor="#6495ed">Mother_Name</th>
                    <th bgcolor="#6495ed">Address</th>
                    <th bgcolor="#6495ed">Date</th>
                    <th bgcolor="#6495ed">Attendance |<input type="checkbox" name="all" id="all" value="all"> <label
                            for="all">All</label></th>


                </tr>

                <c:forEach items="${studentsList.wrapperList}" var="student" varStatus="studentStatus">

                    <tr>
                        <td><form:input path="wrapperList[${student.index}].class_Name" value="${student.class_Name}" readonly="true"/></td>
                        <td><form:input path="wrapperList[${student.index}].stdRoll_Number" value="${student.stdRoll_Number}" readonly="true"/></td>
                        <td><form:input path="wrapperList[${student.index}].std_Name" value="${student.std_Name}" readonly="true"/></td>
                        <td><form:input path="wrapperList[${student.index}].father_Name" value="${student.father_Name}" readonly="true"/>
                        <td><form:input path="wrapperList[${student.index}].mother_Name" value="${student.mother_Name}" readonly="true"/>
                        <td><form:input path="wrapperList[${student.index}].address" value="${student.address}" readonly="true"/>
                        <td><form:input path="wrapperList[${student.index}].doj" value="${student.doj}" readonly="true"/>
                       <%-- <td><form:input path="wrapperList[${student.index}].attendance" value="1"/>--%>
                        <td><form:checkbox path="wrapperList[${student.index}].attendance" value="1"/><span>Persent</span> </td>
                    </tr>
                </c:forEach>
            </table>

            <tr><input type="submit" value="Update"/></tr>
        </form:form>
    </c:when>
    <c:otherwise>
        <h2>No records found</h2>
    </c:otherwise>
</c:choose>
<script>

    const all = document.getElementById('all');

    all.addEventListener('click', toggle);


    function toggle() {
        const isChecked = all.checked;
        Array.from(document.getElementsByTagName('input')).forEach(element => {
            element.checked = isChecked;
        });
    }


    Array.from(document.querySelectorAll('input:not(#all)')).forEach(element => {
        element.addEventListener('click', uncheckAll);
    });

    function uncheckAll() {
        all.checked = false
    }
</script>
