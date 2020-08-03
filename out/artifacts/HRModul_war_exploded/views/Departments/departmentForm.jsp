<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: akhojayev
  Date: 20-Jul-20
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<jsp:include page="../navbar.jsp"></jsp:include>
<div class="container">
    <form action="${ctx}/saveDepartment" method="post" class="form">

        <div class="form-group">
            <label for="department_id">Department ID:</label>
            <input type="number" name="department_id" id="department_id" placeholder="Department ID">
        </div>

        <div class="form-group">
            <label for="department_name">Department name:</label>
            <input type="text" name="department_name" id="department_name" placeholder="Department name">
        </div>
        <div class="form-group">
            <label for="manager_id">Select Manager:</label>
            <select class="form-control" id="manager_id"  name="manager_id">
                <c:forEach items="${empList}" var="emp">
                    <option value='<c:out value="${emp.getEmployeeId()}"></c:out>' >
                        <c:out value="${emp.getFirstName()}"></c:out>
                        <c:out value="${emp.getLastName()}"></c:out>
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="location_id">Select Location:</label>
            <select class="form-control" id="location_id"  name="location_id">
                <c:forEach items="${locationList}" var="location">
                    <option value='<c:out value="${location.getLocationId()}"></c:out>' > <c:out value="${location.getLocationId()}"></c:out></option>
                </c:forEach>
            </select>
        </div>

        <input type="submit" class="btn btn-success" value="Submit">
    </form>

</div>
</body>
</html>
