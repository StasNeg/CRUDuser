<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <form method="post" action="${pageContext.request.contextPath}/filter">
        <dl>
            <dt>Find for email:</dt>
            <dd><input type="text" name="email" value="${email}"></dd>
        </dl>
        <dl>
            <dt>Find for name:</dt>
            <dd><input type="text" name="firstName" value="${firstName}"></dd>
        </dl>
        <dl>
            <dt>Find for last name:</dt>
            <dd><input type="text" name="lastName" value="${lastName}"></dd>
        </dl>
        <button type="submit" class="h12">Filter</button>
        <input type="button" onclick="location.href='${pageContext.request.contextPath}/'" value="Clear" class="h12"/>
    </form>
    <hr/>
    <input type="button" onclick="location.href='${pageContext.request.contextPath}/users/create'" value="Add User" class="h12"/>

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
                <td><input type="button" onclick="location.href='${pageContext.request.contextPath}/users/update/${user.id}'" value="Update User" class="h12"/></td>
                <td><input type="button" onclick="location.href='${pageContext.request.contextPath}/users/delete/${user.id}'" value="Delete User" class="h12"/></td>
            </tr>
        </c:forEach>
    </table>

</section>
</body>
</html>
