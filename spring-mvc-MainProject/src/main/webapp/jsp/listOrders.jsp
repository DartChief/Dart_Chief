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
    <h1>Order List</h1>
    <h3><a href="<c:url value="/"/>">To Customer List</a></h3>

    <table border="1">
        <th>Id</th>
        <th>Customer</th>
        <th>Name</th>
        <th>Price</th>
        <th>Action</th>

        <c:forEach var="order" items="${orders}" varStatus="status">
            <tr>
                <td>${order.id}</td>
                <td>${map.get(order.customerId)}</td>
                <td>${order.name}</td>
                <td>${order.price}</td>
                <td>
                    <a href="<c:url value="/updateOrder?id=${order.id}"/>">Update</a>
                    <a href="<c:url value="/deleteOrder?id=${order.id}"/>">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>