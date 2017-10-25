<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css">
    <title>UserCRUD Application</title>
</head>
<body>
<section>
    <h3>
        <div>Users Table</div>
    </h3>
    <hr/>
    <a href="${pageContext.request.contextPath}/users/create" class="h12">Add User</a>
    <hr/>
    <table id="users">
        <thead>
        <tr>
            <th>Name</th>
            <th>LastName</th>
            <th>Email</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <c:forEach items="${users}" var="user">
            <jsp:useBean id="user" scope="page" type="model.User"/>
            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td><a href="${pageContext.request.contextPath}/users/update/${user.id}">Update</a></td>
                <td><a href="${pageContext.request.contextPath}/users/delete/${user.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

</section>
</body>
</html>
