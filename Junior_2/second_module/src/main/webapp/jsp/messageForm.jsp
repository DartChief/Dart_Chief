<%--
  Created by IntelliJ IDEA.
  User: dednakov
  Date: 03.02.2016
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cst" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title><spring:message code="label.addHeader"/></title>
  <style>
    .error {
      color: red;
    }
  </style>
</head>
<body>
<div align="center">
  <h1><spring:message code="label.newMessage"/></h1>
  <form:form action="saveMessage" method="post" modelAttribute="message">

    <table>
      <form:hidden path="id"/>

      <spring:message code="label.title1" var="title1"/>
      <spring:message code="label.title2" var="title2"/>
      <spring:message code="label.path1" var="path1"/>
      <spring:message code="label.path2" var="path2"/>
      <spring:message code="label.cssClass" var="cssClass"/>

      <cst:cust_tag title="${title1}" path="${path1}" cssClass="${cssClass}" />
      <cst:cust_tag title="${title2}" path="${path2}" cssClass="${cssClass}" />

      <tr>
        <td colspan="2" align="center"><input type="submit" value="Save"></td>
      </tr>
    </table>

  </form:form>
  <tr>
    <button><a href="<c:url value="/messages/listOfMessages"/>"> <input type="submit" value="<spring:message code="label.listButton"/>" /> </a></button>
  </tr>
</div>
</body>
</html>