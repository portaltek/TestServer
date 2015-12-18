$(function() {
	
    $(function() {
        $("#username").focus();
    });
});

function validarId(e){
	if (e.id === ""){
		alert("No ID founded");
		return false;
	}
	return true;
}


function clickOnMouseOver(e){
	$(e).trigger("click");
}