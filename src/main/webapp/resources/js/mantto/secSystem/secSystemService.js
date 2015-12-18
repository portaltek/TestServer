var SecSystemService = function(ctx) {
	this.url = ctx + "/mantto/secSystem";
	this.test = function() {
		$("#test").html(this.url);
	};
	this.insert = function(entity) {
		$.ajax({
			url : this.url + "/insert", type: "POST",	
			data : {
				entity : entity
			},
			success : function(data) {
				return $.parseJSON(data);
			}
		});
	};
};
