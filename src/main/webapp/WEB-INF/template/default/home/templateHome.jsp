<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WEBAPP</title>
<tiles:insertAttribute name="home.libs" />

</head>
<body>
	<div data-role="page" id="defaultPage">
		<tiles:insertAttribute name="home.header" />
		<div role="main" class="ui-content">
			<tiles:insertAttribute name="home.body" />
		</div>
	</div>
</body>
</html>