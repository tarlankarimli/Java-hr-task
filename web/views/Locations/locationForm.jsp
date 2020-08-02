
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
    <title>Add Location</title>
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
    <form action="${ctx}/saveLocation" method="post" class="form">

        <div class="form-group">
            <label for="id">Location ID:</label>
            <input type="text" name="location_id" id="id" placeholder="Location ID">
        </div>

        <div class="form-group">
            <label for="street">Stress address:</label>
            <input type="text" name="street_address" id="street" placeholder="Stress address">
        </div>
        <div class="form-group">
            <label for="postal">Postal code:</label>
            <input type="text" name="postal_code" id="postal" placeholder="Postal code">
        </div>
        <div class="form-group">
            <label for="city">City:</label>
            <input type="text" name="city" id="city" placeholder="City">
        </div>
        <div class="form-group">
            <label for="state">State Province:</label>
            <input type="text" name="state_province" id="state" placeholder="State Province">
        </div>

        <div class="form-group">
            <label for="country">Select country ID:</label>
            <select class="form-control" id="country"  name="country_id">
                <c:forEach items="${countryList}" var="country">
                    <option value='<c:out value="${country.getCountryId()}"></c:out>'> <c:out value="${country.getCountryId()}"></c:out></option>
                </c:forEach>
            </select>
        </div>

        <input type="submit" class="btn btn-success" value="Submit">
    </form>

</div>
</body>
</html>
