<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Task 6</title>
</head>
<body>
<jsp:useBean id="userBean" class="com.itis.UserBean" />
<%! com.itis.UserBean userBean = new com.itis.UserBean(); %>
<%! com.itis.UserBean.User user = new com.itis.UserBean.User(); %>
<h1>Task 6 Taglib cycle</h1>
<ul>
<c:forEach var="user" items="${userBean.getUserList()}">
   <c:out value="${user.getFirstName()}"/>
   <c:out value="${user.getLastName()}"/>
   <c:out value="${user.getAge()}"/><p>
</c:forEach>
</ul>
</center>
</body>
</html>