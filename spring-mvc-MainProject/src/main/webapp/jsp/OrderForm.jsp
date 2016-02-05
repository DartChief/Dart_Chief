<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New/Edit Contact</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<div align="center">
    <h1>New/Edit Order</h1>
    <form:form action="saveOrder" method="post" modelAttribute="order">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Customer</td>
                <td>
                    <form:select path="customerId">
                        <form:options items="${userList}" itemLabel="firstName" itemValue="id"/>
                    </form:select>
                </td>
                <td><form:errors path="customerId" cssClass="error"/></td>
                <br/>
            </tr>
            <tr>
                <td>Name:</td>
                <td><form:input path="name"/></td>
            </tr>
            <br/>
            <tr>
                <td>Price:</td>
                <td><form:input path="price"/></td>
                <td><form:errors path="price" cssClass="error"/></td>
                <br/>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
    <tr>
        <button><a href="<c:url value="/listOrders"/>">To Order List</a></button>
    </tr>
</div>
</body>
</html>