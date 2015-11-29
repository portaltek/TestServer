<html>
<head></head>
<body>
	<h1>Message : ${message}</h1>
	CONTEXT: ${ctx} ----
	<hr>
	${ctx} Dear
	<strong>${user}</strong>, Welcome to Admin Page.

	<div>
		<sec:authorize access="hasRole('APP_ADMIN')">
			<label><a href="#">Edit this page</a> | This part is visible
				only to ADMIN</label>
		</sec:authorize>
	</div>

	<br />
	<div>
		<sec:authorize access="hasRole('APP_ADMIN') and hasRole('APP_DBA')">
			<label><a href="#">Start backup</a> | This part is visible
				only to one who is both ADMIN & DBA</label>
		</sec:authorize>
	</div>
</body>
</html>