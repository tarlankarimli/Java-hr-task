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

<jsp:include page="navbar.jsp"></jsp:include>
<div class="container">
    <form action="${ctx}/employee/saveDepartment" method="post" class="form">

        <div class="form-group">
            <label for="id">Department ID:</label>
            <input type="number" name="id" id="id" placeholder="name" disabled readonly>
        </div>

        <div class="form-group">
            <label for="first_name">First Name:</label>
            <input type="text" name="first_name"  placeholder="first name">
        </div>


        <div class="form-group">
            <label for="job">Select Job:</label>
            <select class="form-control" id="sel1"  name="job_id">
                <c:forEach items="${jobList}" var="job">
                    <option value='<c:out value="${job.getJobId()}"></c:out>' > <c:out value="${job.getJobTitle()}"></c:out></option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="department">Select Department:</label>
            <select class="form-control" id="sel21"  name="department_id">
                <c:forEach items="${deptList}" var="dept">
                    <option value='<c:out value="${dept.getDepartmentId()}"></c:out>' > <c:out value="${dept.getDepartmentName()}"></c:out></option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="manager">Select Manager:</label>
            <select class="form-control" id="selw21"  name="manager_id">
                <c:forEach items="${empList}" var="emp">
                    <option value='<c:out value="${emp.getEmployeeId()}"></c:out>' >
                        <c:out value="${emp.getFirstName()}"></c:out>
                        <c:out value="${emp.getLastName()}"></c:out>
                    </option>
                </c:forEach>
            </select>
        </div>

        <input type="submit" class="btn btn-success" value="Submit">
    </form>

</div>
</body>
</html>