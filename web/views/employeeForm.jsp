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
<form action="${ctx}/employee/${action}" method="post" class="form">

    <div class="form-group">
        <label for="id">ID:</label>
        <input type="number" name="id" id="id" placeholder="name" value="${employee.getEmployeeId()}">
    </div>

    <div class="form-group">
        <label for="first_name">First Name:</label>
        <input type="text" name="first_name" id="first_name" placeholder="first name" value="${employee.getFirstName()}">
    </div>

    <div class="form-group">
        <label for="last_name">Last Name:</label>
        <input type="text" name="last_name" id="last_name" placeholder="surname" value="${employee.getLastName()}"><br>
    </div>



    <div class="form-group">
        <label for="email">Email:</label>
        <input type="input"  id ="email" name="email"  placeholder="email" value="${employee.getEmail()}">
    </div>

    <div class="form-group">
        <label for="phone_number">Phone number:</label>
        <input type="text" name="phone_number" id="phone_number" placeholder="phone" value="${employee.getPhoneNumber()}">
    </div>

    <div class="form-group">
        <label for="salary">Salary:</label>
        <input type="number" name="salary" id="salary" placeholder="salary" value="${employee.getSalary()}">
    </div>

    <div class="form-group">
        <label for="commission_pct">Commission:</label>
        <input type="number" name="commission_pct" id="commission_pct" placeholder="commision" value="${employee.getCommissionPct()}">
    </div>
    <div class="form-group">
        <label for="job">Job Title:</label>
        <input type="text" name="job" id="job" value="${employee.getJobId()}">
        <a class="btn button btn-danger" href="${ctx}/employee/edit/position?employeeId=${employee.getEmployeeId()}">Update</a></td>
    </div>
    <div class="form-group">
        <label for="department">Department:</label>
        <input type="text" name="department" id="department" disabled readonly value="${employee.getDepartmentId()}">
    </div>
    <br/>
    <h3>${employee.getFirstName()}'s manager: ${employee.getManagerId()}</h3>

    <input type="submit" class="btn btn-success" value="Submit">
</form>

</div>
</body>
</html>
