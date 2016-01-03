function SecSystemService() {
	this.ctx = $("#ctx").val();
	this.urlInsert = this.ctx + "/mantto/secSystem/insert";
	this.urlFindId = this.ctx + "/mantto/secSystem/findId";
	this.urlUpdate = this.ctx + "/mantto/secSystem/update";
	this.urlDelete = this.ctx + "/mantto/secSystem/delete";
	this.urlFindAll = this.ctx + "/mantto/secSystem/findAll";

	this.findAll = function() {
		$.ajax({
			type : "get",
			// data : form,
			url : this.urlFindAll,
			dataType : "json",
			async : false,
			success : function(response) {
				var d = JSON.parse(JSON.stringify(response));
				var data = d.LIST;

				secSystemTable.set(data, "secSystemTable");
				secSystemTable.print();
				tablePagination.paginate(10);

			},
			error : function(response) {
				var data = JSON.parse(JSON.stringify(response));
				var result = data.RESULT;
				alert("error: " + result);
			}
		});
	}

	this.findId = function(ctrl, id) {
		var d = $.ajax({
			type : "get",
			data : {
				id : id
			},
			url : this.urlFindId,
			dataType : "json",
			async : false,
			success : function(response) {
				var d = JSON.parse(JSON.stringify(response));
				ctrl.e = d.ELEMENT;
			},
			error : function(response) {
				var data = JSON.parse(JSON.stringify(response));
				var result = data.RESULT;
				alert("error: " + result);
			}
		});
	}

	this.insert = function(ctrl, form) {
		$.ajax({
			type : "post",
			data : form,
			url : this.urlInsert,
			dataType : "json",
			async : false,
			success : function(response) {
				ctrl.data = JSON.parse(JSON.stringify(response));
				
			},
			error : function(response) {
				ctrl.data = JSON.parse(JSON.stringify(response));
				var result = ctrl.data.RESULT;
				alert("error: " + result);
			}
		});
	}

	this.update = function(ctrl, e) {
		$.ajax({
			type : "post",
			data : e,
			url : this.urlUpdate,
			dataType : "json",
			async : false,
			success : function(response) {
				ctrl.data = JSON.parse(JSON.stringify(response));
			},
			error : function(response) {
				var data = JSON.parse(JSON.stringify(response));
				var result = data.RESULT;
				alert("error: " + result);
			}
		});
	}
	
	this.remove = function(ctrl, e) {
		$.ajax({
			type : "post",
			data : e,
			url : this.urlDelete,
			dataType : "json",
			async : false,
			success : function(response) {
				ctrl.data = JSON.parse(JSON.stringify(response));
			},
			error : function(response) {
				var data = JSON.parse(JSON.stringify(response));
				var result = data.RESULT;
				alert("error: " + result);
			}
		});
	}
}