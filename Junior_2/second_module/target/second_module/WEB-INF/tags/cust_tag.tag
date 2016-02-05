<%@ tag %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ attribute name="title" required="true" type="java.lang.String" %>
<%@ attribute name="path" required="true" type="java.lang.String" %>
<%@ attribute name="cssClass" required="true" type="java.lang.String" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<tr>
    <td>${title}:</td>
    <td><form:input path="${path}" /></td>
    <td><form:errors path="${path}" cssClass="${cssClass}" /></td><br/>
</tr>
