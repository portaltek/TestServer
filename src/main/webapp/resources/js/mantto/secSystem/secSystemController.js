var SecSystemController = function SecSystemController(serv) {
	this.serv = serv;
	this.findAll = function() {
		this.serv.findAll();
	};
	this.insert = function(){
		this.serv.test();
		var e = {
			systemId: "TEST",	
			name: "name",
			description: "description",
		}
		var data = this.serv.insert(e);
	}
};