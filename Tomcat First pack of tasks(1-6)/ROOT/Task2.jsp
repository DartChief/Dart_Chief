<html>
<head>
<title>Using JavaBeans in JSP</title>
</head>
<body>
Hello world!<br/>
<%
   out.println("WTF?!");
%>
<jsp:useBean id="test" class="com.itis.TestBean" />
<jsp:setProperty name="test"
property="message"
value="Hello MZFK!" />
<p>Got message....</p>
<jsp:getProperty name="test" property="message" />
</center>
</body>
</html>