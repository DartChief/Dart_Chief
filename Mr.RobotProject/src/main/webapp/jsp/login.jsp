<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
<center>
    <h2>Login Here</h2>
    <div style="text-align: center; padding: 30px;border: 1px solid green;width: 250px;">
        <form method="post" action="<c:url value='/login' />">

            <table>
                <tr>
                    <td colspan="2" style="color: red">${message}</td>

                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><input id="j_username" type="text" name="j_username"/>
                    </td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input id="j_password" type="password" name="j_password"/>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login" />
                    </td>
                </tr>
            </table>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
        </form>
    </div>
</center>
</body>
</html>
