
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="js" value="${ctx}/resources/js" />
<c:set var="lib" value="${ctx}/resources/lib" />

<sec:authentication var="menuList" property="principal.urlList"
	htmlEscape="false" />
<div data-role="panel" id="menu" data-display="overlay"
	class="menu-panel" data-inset="false" data-position="left">
	<ul data-role="listview" data-inset="false" data-shadow="false">
		<li data-role="listview" data-inset="false" data-icon="home"><a
			href="${ctx}/home">Home</a></li>

		<c:forEach items="${menuList}" var="m">
			<li data-role="listview" data-iconpos="right"><a
				href="${ctx}${m}" data-inset="false">${ctx}${m}</a>
		</c:forEach>
	</ul>
</div>

<div data-role="panel" id="options" data-display="overlay"
	class="options-panel" data-position="right" data-inset="false">
	<ul data-role="listview" data-inset="false" data-shadow="false">
		<li data-role="listview" data-inset="false" data-icon="user"><a
			href="">Usuario</a></li>
	</ul>
	<h2>Options</h2>
	<p>Some text in the panel..</p>

	<c:url value="/j_spring_security_logout" var="logoutUrl" />


	<!-- csrt support -->
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<a href="${ctx}/logout" class="ui-btn ui-btn-inline" data-ajax="false">Logout</a>


</div>


<div data-role="header">
	<input type="hidden" id="ctx" value="${ctx}" /> <a href="#menu"
		onmouseover="clickOnMouseOver(this);"
		class="ui-btn ui-shadow ui-corner-all ui-icon-bars ui-btn-icon-notext ">Menu</a>

	<h1>Title : WEBAPP: ${ctx}</h1>
	<a href="#options" onmouseover="clickOnMouseOver(this)"
		class="ui-btn ui-shadow ui-corner-all ui-icon-grid ui-btn-icon-notext ">Options</a>
</div>
