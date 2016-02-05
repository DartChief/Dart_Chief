<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Contact Manager Home</title>
</head>
<body>
<div align="center">
    <h1>Contact List</h1>
    <h3><a href="<c:url value="/createUser"/>">New Contact</a></h3>
    <h3><a href="<c:url value="/createOrder"/>">New Order</a></h3>
    <h3><a href="<c:url value="/listOrders"/>">List Orders</a></h3>


    <table border="1">
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
        <th>Action</th>

        <c:forEach var="user" items="${users}" varStatus="status">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.age}</td>
                <td>
                    <a href="<c:url value="/updateUser?id=${user.id}"/>">Update</a>
                    <a href="<c:url value="/deleteUser?id=${user.id}"/>">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>