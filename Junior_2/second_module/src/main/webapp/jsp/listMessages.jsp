<%--
  Created by IntelliJ IDEA.
  User: dednakov
  Date: 03.02.2016
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title><spring:message code="label.listHeader"/></title>
</head>
<body>
<div align="center">
  <h1> <spring:message code="label.listMessages"/> </h1>
  <h1>${success}</h1>

  <table border="1">
    <th><spring:message code="label.title1"/></th>
    <th><spring:message code="label.title2"/></th>
    <th><spring:message code="label.title3"/></th>

    <c:forEach var="message" items="${messages}" varStatus="status">
      <tr>
        <td>${message.author}</td>
        <td>${message.text}</td>
        <td>${message.date}</td>
      </tr>
    </c:forEach>
  </table>
  <tr>
    <button><a href="<c:url value="/messages/addMessage" />"> <input type="submit" value="<spring:message code="label.addButton"/>" /> </a></button>
  </tr>
</div>
</body>
</html>
