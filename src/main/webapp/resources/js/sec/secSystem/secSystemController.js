/*
 * Valida y prepara objetos para mostrar al usuario o enviar al servicio
 */
function SecSystemController() {
	this.form = $("#secSystemForm").serialize();
	this.data = "";
	this.formDiv = $("#secSystemForm-dialog");
	this.searchform = $("#searchForm").serialize();
	this.searchformDiv = $("#searchForm-dialog");
	this.srv = new SecSystemService();
	this.counter = 0;

	this.findAll = function() {
		this.srv.findAll();
	}

	this.switchType = function(type) {
		$("h1[id^='form-title']").hide();
		$("h1#form-title-" + type).show();
		$("button[id^='form-button']").hide();
		$("button#form-button-" + type).show();
		$("button#form-button-cancel").show();
		$("div[id$='dialog-screen']").remove();
	}

	this.showInsertForm = function() {
		this.switchType("insert");
		this.setForm(this.e, "insert");
		this.formDiv.show();
		this.formDiv.draggable();
		$("input#systemId").notify("Hello Box", "success");
	}

	this.showSearchForm = function() {
		this.switchType("search");
		this.searchformDiv.show();
		this.searchformDiv.draggable();
	}

	this.showUpdateForm = function(id) {
		this.switchType("update");
		this.srv.findId(this, id);
		this.setForm(this.e, "update");
		this.formDiv.show();
		this.formDiv.draggable();
		$("input#name").notify("Hello Box", "success");
		$("input#name").notify("Hello Box", "success");
		$("input#name").notify("Hello Box\nddddd\nasdf", "success");
	}

	this.setForm = function(data, mode) {
		var disableInputs = false;
		if (mode === "insert") {
			disableInputs = false;
		}
		if (mode === "update") {
			disableInputs = false;
		}
		if (mode === "delete") {
			disableInputs = true;
		}
		if (mode === "view") {
			disableInputs = false;
		}

		// $("#secSystemForm-dialog input").attr("disabled", disableInputs);
		$("#systemId").val(data.systemId);
		$("#name").val(data.name);
		$("#description").val(data.description);
	}

	this.showDeleteForm = function(id) {
		this.switchType("delete");
		this.srv.findId(this, id);
		this.setForm(this.e, "delete");

		this.formDiv.show();
		this.formDiv.draggable();
	}

	this.insert = function() {
		this.form = $("#secSystemForm").serialize();
		this.srv.insert(this, this.form);
		this.showResult();
	}

	this.update = function() {
		this.form = $("#secSystemForm").serialize();
		this.srv.update(this, this.form);
		this.showResult();

	}

	this.remove = function() {
		this.form = $("#secSystemForm").serialize();
		this.srv.remove(this, this.form);
		this.showResult();
	}

	this.showResult = function() {
		var s ="", d = this.data, result = d.RESULT;
		if (result === "OK") {
			this.findAll();
			this.formDiv.hide();
			$.notify(d.MSG, "success");
		}
		if (result === "ERROR") {
			$.notify(d.MSG, "error");
		}
	}

	this.validate = function() {
		var form = this.srv.form;
		var msg = "";
		if (form.systemId === "") {

		}

	}
}
