$(document).ready(function(){   
	$(".app-msg-errors").hide(); 
	$("#code_epr_1").change(function () {
        var val_epr_1 = $('#code_epr_1').val();
        var val_epr_2 = $('#code_epr_2').val();
        $('#code_epr_2 option').remove();
        $('#code_epr_1 option').clone().appendTo('#code_epr_2');
    	if ($('#code_epr_1').val() != "") {
    		$("#code_epr_2 option[value='"+val_epr_1+"']").remove();
    	}
        if (val_epr_1 == val_epr_2) {
        	$('#code_epr_2').val("");
        } else {
        	$('#code_epr_2').val(val_epr_2);
        }
	});
	$("#code_epr_1").trigger('change');

});
var alerte = "";
function checkfield(){
	erreur = false;
	alerte = "";
	if ($('#code_res').val() == ""){
		alerte = "Vous devez saisir le résultat au concours";
		document.formulaire.code_res.focus();
		erreur = true;
		return false;
	}
	if ( ($('#code_acad').val() == "") && ($('#code_res').val() != "02") ){
		alerte = "Vous devez saisir l'académie";
		document.formulaire.code_acad.focus();
		return false;
	}
	if ($('#code_niv').val() == ""){
		alerte = "Vous devez saisir le dernier diplôme obtenu";
		document.formulaire.code_niv.focus();
		return false;
	}
	if ($('#code_epr_1').val() == ""){
		alerte = "Vous devez saisir l'épreuve de l'UE2";
		document.formulaire.code_epr_1.focus();
		return false;
	}
	if ($('#code_epr_2').val() == ""){
		alerte = "Vous devez saisir l'épreuve de l'UE2";
		document.formulaire.code_epr_2.focus();
		return false;
	}
	if ($('#code_epr_1').val() == $('#code_epr_2').val()){
		alerte = "Vous devez saisir deux épreuves différentes";
		document.formulaire.code_epr_2.focus();
		return false;
	}

	return true;
}

function valide(){
	if (checkfield()) {
		document.formulaire.submit();
	} else {
		$(".app-msg-errors > h2").text(alerte);
		$(".app-msg-errors").show();
	}
               
}
