function validar(){
	let nome = frmContato.name.value
	let fone = frmContato.fone.value
	let email = frmContato.email.value
	
	if(nome === ""){
		alert("preencha o campo nome")
		frmContato.nome.focus()
		return false;
	}else if(fone === ""){
		alert("preencha o campo fone")
		frmContato.nome.focus()
		return false;
	}else{
		document.forms["frmContato"].submit()
	}
}