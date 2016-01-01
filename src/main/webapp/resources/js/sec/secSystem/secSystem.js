var publicTable = new Table();
var tablePagination ;
$(function() {
	$("#systemId").val("asd");
	$("#name").val("asd");
	$("#description").val("asd");
	var table = $("#secSystemTable");
	var pager = $("#secSystemTable-pager");
	tablePagination = new TablePagination(table, pager);
	
	findAll();
//	publicTable.print();
//	$("#secSystemForm").hide();
	// $("h1").html("table.js");

	$("#secSystemTable-search-systemId").bind('change', function() {
		publicTable.filter("systemId", this.value);
		tablePagination.paginate(10);
	});
	
//	$( ".draggable" ).draggable();

});

/*
 * 1- Dar estilo a la paginación y agregar swipe event.
 * 2- Limitar la paginacion a 5 paginas y agregar botones siguiente, anterior, inicio y final.
 * 3- Esconder formulario de insertar y dar forma a formulario de buscar. El formulario de buscar no sirve porque no dibuja las filas.
 */
function insert() {
	var ctx = $("#ctx").val();
	var form = $("#secSystemForm").serialize();
	var url = ctx + "/mantto/secSystem/insert";
	$.ajax({
		type : "post",
		data : form,
		url : url,
		dataType : "json",
		async : false,
		success : function(response) {
			var d = JSON.parse(JSON.stringify(response));
			var result = d.RESULT;
			var s = "";
			if (result === "OK") {
				s += "RESULT: " + result;
			} else {

			}
			if (result === "ERROR") {
				s += "RESULT: " + result;
				s += "\nMSG: " + d.MSG;
			}
			findAll();
			alert(s);
			
		},
		error : function(response) {
			var data = JSON.parse(JSON.stringify(response));
			var result = data.RESULT;
			alert("error: " + result);
		}
	});
}

function findAll() {

	var ctx = $("#ctx").val();
	var form = $("#secSystemForm").serialize();
	var url = ctx + "/mantto/secSystem/findAll";
	$.ajax({
		type : "get",
		// data : form,
		url : url,
		dataType : "json",
		async : false,
		success : function(response) {
			var d = JSON.parse(JSON.stringify(response));
			var data = d.LIST;
			publicTable.set(data, "secSystemTable");
			publicTable.print();
			tablePagination.paginate(10);
		},
		error : function(response) {
			var data = JSON.parse(JSON.stringify(response));
			var result = data.RESULT;
			alert("error: " + result);
		}
	});
}

function Table(data, id) {
	this.data = data;
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
			this.rows += "<tr>";
			this.rows += "<td>" + r.systemId + "</td>";
			this.rows += "<td>" + r.name + "</td>";
			this.rows += "<td>" + r.description + "</td>";
			
//			this.rows += "<td>" + r.systemId + "</td>";
			this.rows += "<td><i class='fa fa-edit fa-lg'></i> <i class='fa fa-remove fa-lg'></i></td>";
			
			this.rows += "</tr>";
		}
		if (this.data.length == 0) {
			this.rows = this.noRows;
		}
		this.tbody.html(this.rows);
	}

	this.filter = function(columnId, value) {
		this.tbody.find("tr").remove();
		this.rows = "";
		for (var i = 0; i < this.data.length; i++) {
			var r = this.data[i];
			if (r[columnId].indexOf(value) == -1) {
				continue;
			}
			this.rows += "<tr>";
			this.rows += "<td>" + r.systemId + "</td>";
			this.rows += "<td>" + r.name + "</td>";
			this.rows += "<td>" + r.description + "</td>";
			this.rows += "<td><i class='fa fa-edit fa-lg'></i> <i class='fa fa-remove fa-lg'></i></td>";
			this.rows += "</tr>";
		}
		if (this.data.length == 0) {
			this.rows = this.noRows;
		}
//		this.tbody.html(this.rows+this.rows+this.rows
//				+this.rows+this.rows+this.rows);
		this.tbody.html(this.rows);		
	};
};

