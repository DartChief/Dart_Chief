<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<body>

<h1>New Car</h1>

<form:form modelAttribute="car" method="POST" action="new_car.html">
    Brand<br />

    <form:select path="brand">

        <form:options items="${brandList}" itemLabel="name" itemValue="id"/>

    </form:select>

    <br/><br/>

    Model<br />

    <form:input path="model"/><br/><br/>

    Price<br />

    <form:input path="price"/><br/><br/>

    <input type="submit" value="Submit">

</form:form>

</body>

</html>
