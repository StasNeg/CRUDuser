<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css">
</head>
<body>
<section>
    <jsp:useBean id="user" type="model.User" scope="request"/>
    <hr>
    <h3><c:choose>
        <c:when test="${user.isNew()}">
            Create
            <br />
        </c:when>
        <c:otherwise>
            Update
            <br />
        </c:otherwise>
    </c:choose>
    </h3>
    <hr>

    <form method="post" action="${pageContext.request.contextPath}/users/save">
        <input type="hidden" name="id" value="${user.id}">
        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value="${user.firstName}" name="firstName"></dd>
        </dl>
        <dl>
            <dt>Last Name:</dt>
            <dd><input type="text" value="${user.lastName}" size=40 name="lastName"></dd>
        </dl>
        <dl>
            <dt>Email:</dt>
            <dd><input type="text" value="${user.email}" size=40 name="email"></dd>
        </dl>
        <button type="submit" class="h12">Enter</button>
        <button onclick="window.history.back()" type="button" class="h12">Cancel</button>
    </form>
</section>

</body>
</html>