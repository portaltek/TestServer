<div data-role="header" class="app-header">
	<a href="#" style="display: none"></a>
	<h1>APP NAME</h1>
	<a href="#infoPanel" data-position="right"
		onmouseover="clickOnMouseOver(this)"
		class="ui-btn ui-shadow ui-corner-all ui-icon-info ui-btn-icon-notext">Options</a>
</div>

<div data-role="panel" id="infoPanel" data-display="overlay"
	data-position="right">
	<ul data-role="listview" data-inset="false" data-shadow="false">

		<li data-role="listview" data-inset="false" data-icon="info"><a
			href="">Info</a></li>
	</ul>

	<p>
	<p>Some text in the panel..</p>
	<a href="#pageone" data-rel="close" class="ui-btn ui-btn-inline">Close
		Panel</a>
</div>