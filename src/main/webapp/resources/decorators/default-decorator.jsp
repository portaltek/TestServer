<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="css" value="${ctx}/resources/css/default" />
<c:set var="js" value="${ctx}/resources/js" />
<c:set var="img" value="${ctx}/resources/img" />
<c:set var="lib" value="${ctx}/resources/lib" />
<c:set var="today" value="<%=new java.util.Date()%>" />
<html>
<head>
<link href="${css}/jquery.mobile/1.4.5/jquery.mobile.css"
	rel="stylesheet" />
<script src="${js}/jquery/1.10.2/jquery.js"></script>
<script src="${js}/jquery.mobile/1.4.5/jquery.mobile.js"></script>
<script src="${js}/default.js"></script>
</head>
<body>
    <input id="ctx" value="${ctx}" type="hidden"/>

	<sitemesh:write property='body' />



</body>
</html>