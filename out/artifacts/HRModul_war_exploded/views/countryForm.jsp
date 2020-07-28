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
    <form action="${ctx}/employee/saveCountry" method="post" class="form">

        <div class="form-group">
            <label for="id">Country ID:</label>
            <input type="text" name="country_id" id="id" placeholder="Country ID">
        </div>

        <div class="form-group">
            <label for="name">First Name:</label>
            <input type="text" name="country_name" id="name" placeholder="Country name">
        </div>


        <div class="form-group">
            <label for="region">Select region:</label>
            <select class="form-control" id="region"  name="region_name">
                <c:forEach items="${regionList}" var="region">
                    <option value='<c:out value="${region.getRegionId()}"></c:out>' > <c:out value="${region.getRegionName()}"></c:out></option>

                </c:forEach>
            </select>
        </div>

        <input type="submit" class="btn btn-success" value="Submit">
    </form>

</div>
</body>
</html>
