var secSystemTable = new SecSystemTable();
var tablePagination, ctrl;
$(function() {
	// $("input,select,textarea").jqBootstrapValidation({
	// preventSubmit : true,
	// submitError : function($form, event, errors) {
	// // Here I do nothing, but you could do something like display
	// // the error messages to the user, log, etc.
	// },
	// submitSuccess : function($form, event) {
	// // alert("OK");
	// // event.preventDefault();
	// },
	// filter : function() {
	// return $(this).is(":visible");
	// }
	// });

	// $("#systemId").val("asd");
	// $("#name").val("asd");
	// $("#description").val("asd");
	var tableSelect = $("#secSystemTable");
	var pager = $("#secSystemTable-pager");
	tablePagination = new TablePagination(tableSelect, pager);
	ctrl = new SecSystemController();
	ctrl.findAll();
	// $("h1").html("table.js");

	$("#secSystemTable-search-systemId").bind('change', function() {
		secSystemTable.filter("systemId", this.value);
		// tablePagination.paginate(10);
	});
	// $('input.phone_number').formance('format_phone_number');
	// $( ".draggable" ).draggable();

});

function SecSystemTable(data, id) {
	this.data = data;
	this.table = $("#" + id);
	this.tbody = $("#" + id + " tbody");
	this.rows = "";
	this.noRows = "<tr><td colspan='999'>NO EXISTEN REGISTROS</td></tr>";
	this.set = function(data, id) {
		this.data = data;
		this.tbody = $("#" + id + " tbody");
	};
	this.print = function() {
		this.tbody.html("");
		this.rows = "";
		for (var i = 0; i < this.data.length; i++) {
			var r = this.data[i];
			var actionIcons = this.getIcon(r.systemId, "UPDATE")
					+ this.getIcon(r.systemId, "DELETE");
			this.rows += "<tr>";
			this.rows += "<td>" + r.systemId + "</td>";
			this.rows += "<td>" + r.name + "</td>";
			this.rows += "<td>" + r.description + "</td>";
			this.rows += "<td>" + actionIcons + "</td>";
			this.rows += "</tr>";
		}
		if (this.data.length == 0) {
			this.rows = this.noRows;
		}
		this.tbody.append(this.rows);
		// this.table.table().data("table");
	}
	this.getIcon = function(id, type) {
		var onclick, icon, link;
		var atributtes = " data-transition='fade' "
				+ "data-position-to='window' data-rel='popup'";
		if (type === "UPDATE") {
			onclick = " onclick='ctrl.showUpdateForm(\"" + id + "\")' ";
			icon = "<i class='fa fa-edit fa-lg' ></i>";
			link = "<a href='#secSystemForm-dialog' " + onclick + atributtes
					+ " >" + icon + "</a>";
		}
		if (type === "DELETE") {
			onclick = " onclick='ctrl.showDeleteForm(\"" + id + "\")' ";
			icon = "<i class='fa fa-remove fa-lg'></i>";
			link = "<a href='#secSystemForm-dialog' " + onclick + atributtes
					+ " >" + icon + "</a>";
		}
		return link;
	}

	this.filter = function(columnId, value) {
		this.tbody.find("tr").remove();
		this.rows = "";
		for (var i = 0; i < this.data.length; i++) {
			var r = this.data[i];
			if (r[columnId].indexOf(value) == -1) {
				continue;
			}
			var actionIcons = this.getIcon(r.systemId, "UPDATE")
					+ this.getIcon(r.systemId, "DELETE");
			this.rows += "<tr>";
			this.rows += "<td>" + r.systemId + "</td>";
			this.rows += "<td>" + r.name + "</td>";
			this.rows += "<td>" + r.description + "</td>";
			this.rows += "<td>" + actionIcons + "</td>";
			this.rows += "</tr>";
		}
		if (this.data.length == 0) {
			this.rows = this.noRows;
		}
		// this.tbody.html(this.rows+this.rows+this.rows
		// +this.rows+this.rows+this.rows);
		this.tbody.html(this.rows);
	};
};

