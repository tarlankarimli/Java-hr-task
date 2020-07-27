<%--
  Created by IntelliJ IDEA.
  User: akhojayev
  Date: 23-Jul-20
  Time: 8:28 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
    <a class="btn btn-success" href="${ctx}/employee/newCountry">Add Country</a>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>Country ID</th>
            <th>Country Name</th>
            <th>Region ID</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${countryList}" var="country">
            <tr>
                <td> <c:out value="${country.getCountryId() }"/></td>
                <td> <c:out value="${country.getCountryName() }"/></td>
                <td> <c:out value="${country.getRegionId() }"/></td>

                <td>
                    <button class="btn button btn-danger">Delete</button>
                    <button class="btn button btn-warning">Udpdate</button></td>

            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
