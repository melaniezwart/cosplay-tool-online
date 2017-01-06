
<!DOCTYPE html >
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <title>Product</title>
</head>
<body>
<form:form method="POST" modelAttribute="displayProduct">
    <table border="1" >
        <tr>
            <td>Name</td>
            <td>Price</td>
            <td>Quantity</td>
        </tr>
        <c:forEach items="${ctoUser}" var="p">
        <tr>
            <td><c:out value="${p.id}"/></td>
            <td><c:out value="${p.username}"/></td>
            <td><c:out value="${p.password}"/></td>
        </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>
