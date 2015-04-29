<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>New Sponsor</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1>New Car</h1>
<form:form modelAttribute="car" method="POST" action="new_car.html">
    Brand<br />
    <form:select path="brand">
        <form:options items="${brandList}" itemLabel="name" itemValue="id"/>
    </form:select>
    <br/><br/>

    <tr>
        <td>Model</td><br/>
        <td><form:errors path="model" cssClass="error" /></td><br/>
        <td><form:input path="model"/></td>
    </tr>
    <br/><br/>

    <tr>
        <td>Price</td><br/>
        <td><form:errors path="price" cssClass="error" /></td><br/>
        <td><form:input path="price"/></td>
    </tr>
    <br/><br/>

    <input type="submit" value="Submit">
</form:form>
</body>
</html>