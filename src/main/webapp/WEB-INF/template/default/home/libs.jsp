<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="css" value="${ctx}/resources/css/default" />
<c:set var="js" value="${ctx}/resources/js" />
<c:set var="img" value="${ctx}/resources/img" />
<c:set var="lib" value="${ctx}/resources/lib" />

<link href="${lib}/jqm/1.4.5/jquery.mobile.css" rel="stylesheet" />
<link href="${lib}/fa/css/font-awesome.min.css" rel="stylesheet" />
<link href="${css}/buttons.css" rel="stylesheet" />
<link href="${css}/div.css" rel="stylesheet" />
<link href="${css}/icons.css" rel="stylesheet" />
<link href="${css}/default.css" rel="stylesheet" />

<script src="${lib}/jq/1.10.2/jquery.js"></script>
<script src="${lib}/jqm/1.4.5/jquery.mobile.js"></script>
<script src="${lib}/angular/angular.js"></script>
<script src="${js}/default.js"></script>