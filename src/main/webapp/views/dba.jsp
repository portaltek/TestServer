<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page session="true"%>
<html>
<body>
    <h1>Title : ${title}</h1>
    <h1>Message : ${message}</h1>

    <c:url value="/j_spring_security_logout" var="logoutUrl" />

        <!-- csrt support -->
    <form action="${logoutUrl}" method="post" id="logoutForm">
        <input type="hidden" 
            name="${_csrf.parameterName}"
            value="${_csrf.token}" />
    </form>
    



    <hr><hr>
    Dear <strong>${user}</strong>, Welcome to Admin Page.
    <a href="<c:url value="/logout" />">Logout</a>
    <div>
        <sec:authorize access="hasRole('ADMIN')">
            <label><a href="#">Edit this page</a> | This part is visible only to ADMIN</label>
        </sec:authorize>
    </div>
 
    <br/>
    <div>
        <sec:authorize access="hasRole('ADMIN') and hasRole('DBA')">
            <label><a href="#">Start backup</a> | This part is visible only to one who is both ADMIN & DBA</label>
        </sec:authorize>
    </div>    
</body>
</html>