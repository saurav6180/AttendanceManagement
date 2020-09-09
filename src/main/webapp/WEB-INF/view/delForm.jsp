<%--
  Created by IntelliJ IDEA.
  User: Interview
  Date: 3/3/2020
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 style="color: blue">Registration Form</h1>
<c:url value="/delete" var="formUrl"/>
<form:form modelAttribute="del" action="${formUrl}" method="post">
    <table>
        <tr>
            <td>stdRoll_Name  : </td>
            <td><form:input path="stdRoll_Number" /></td>
        </tr>
        <tr>
            <td>date  :</td>
            <td><form:input path="date" type="Date" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Delete" style="color: darkblue"></td>
        </tr>

    </table>

</form:form>
