<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Vendor</title>
</head>
<body>
<h1>Add Vendor</h1>
<form:form id="addVendorForm" commandName="vendor" method="POST" action="/vendors/saveNewVendor">
    <form:label path="vendorTitle">Vendor Title:</form:label>
    <form:input path="vendorTitle" id="vendorTitle" />
    <br>
    <form:label path="vendorDescription">Vendor Description:</form:label>
    <form:input path="vendorDescription" id="vendorDescription" />
    <br>
    <input type="submit">
</form:form>
</body>
</html>


