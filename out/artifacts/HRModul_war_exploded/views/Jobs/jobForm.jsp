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
    <title>Jobs</title>
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
    <form action="${ctx}/saveJob" method="post" class="form">

        <div class="form-group">
            <label for="job_id">Job ID:</label>
            <input type="text" name="job_id" id="job_id" placeholder="Job ID">
        </div>

        <div class="form-group">
            <label for="job_title">Job Title:</label>
            <input type="text" name="job_title" id="job_title" placeholder="Job Title">
        </div>

        <input type="submit" class="btn btn-success" value="Submit">
    </form>

</div>
</body>
</html>
