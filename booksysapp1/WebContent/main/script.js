/**
 * 
 */

function inputCheck(){
	if(document.regFrm.id.value==""){
		alert("Please enter ID");
		document.regFrm.id.focus();
		return;
	}
	if(document.regFrm.password.value==""){
		alert("Please enter password");
		document.regFrm.password.focus();
		return;
	}
	if(document.regFrm.repassword.value==""){
		alert("Please check password");
		document.regFrm.repassword.focus();
		return;
	}
	if(document.regFrm.password.value != document.regFrm.repassword.value){
		alert("Passwords do not match");
		document.regFrm.repassword.value="";
		document.regFrm.repassword.focus();
		return;
	}
	if(document.regFrm.name.value==""){
		alert("Please enter your name");
		document.regFrm.name.focus();
		return;
	}
	if(document.regFrm.phone.value==""){
		alert("Please enter your phone number");
		document.regFrm.phone.focus();
		return;
	}
	document.regFrm.submit();
}

function win_close(){
	self.close();
}