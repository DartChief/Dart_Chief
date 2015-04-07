<html>
<head>
<title>Task 5</title>
</head>
<body>
<jsp:useBean id="userBean" class="com.itis.UserBean" />
<%! com.itis.UserBean userBean = new com.itis.UserBean(); %>
<h1>Task 5 Java cycle</h1>
<ul>
<% for(com.itis.UserBean.User user : userBean.getUserList()) {
      	    out.println(user.getFirstName());
            out.println(user.getLastName());
            out.println(user.getAge());
%><p>
  <%}%>
</ul>
</center>
</body>
</html>