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
    <form action="${ctx}/employee/${action}" method="post" class="form">
        <h2>${employee.getFirstName()} ${employee.getLastName()}</h2>
            <br/>
            <div class="form-group">
                <label for="job">Select Job:</label>
                <select class="form-control" id="job"  name="job_id">
                    <c:forEach items="${jobList}" var="job">
                        <option value='<c:out value="${job.getJobId()}"></c:out>' > <c:out value="${job.getJobTitle()}"></c:out></option>
                    </c:forEach>
                </select>
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
