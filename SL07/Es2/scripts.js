var nome_cognome;
var sesso;
var ateneo;
var cap;
var mansione;
var descrizione;

function getView(){
	nome_cognome = document.getElementById("nome_cognome");
	sesso = document.getElementsByName("sesso");
	ateneo = document.getElementById("ateneo");
	cap = document.getElementById("cap");
	mansione = document.getElementsByName("mansione");
	descrizione = document.getElementById("descrizione");
}

function checkNomeCognome(){
	if(!containNumber(nome_cognome.value) && nome_cognome.value != "")
		nome_cognome.className = "correct";
	else
		nome_cognome.className = "error";
}

function checkCap(){
	if(cap.value.length > 5)
		cap.value = cap.value.substr(0, 5);

	if(isNumber(cap.value) && cap.value.length == 5)
		cap.className = "correct";
	else
		cap.className = "error";
}

function checkAteneo(){
	if(ateneo.options[ateneo.selectedIndex].value != "")
		ateneo.className = "correct";
	else
		ateneo.className = "error";
}

function checkCap(){
	if(cap.value.length > 5)
		cap.value = cap.value.substr(0, 5);

	if(isNumber(cap.value) && cap.value.length == 5)
		cap.className = "correct";
	else
		cap.className = "error";
}

function checkLavoratore(){
	var attr = "disabled";
	if(mansione[1].checked)
		descrizione.removeAttribute(attr);
	else
		descrizione.setAttribute(attr, true);
}

function invia(){
  var error = "";

	checkNomeCognome();
  if(nome_cognome.value.trim() == "")
    error += "Campo Nome e Cognome vuoto!\n";

	if(getSelectedRadioButton(sesso) == -1)
		error += "Campo Sesso vuoto!\n";

	checkAteneo();
	if(ateneo.options[ateneo.selectedIndex].value == "")
		error += "Campo Ateneo vuoto!\n";

	checkCap();
	if(!(isNumber(cap.value) && cap.value.length == 5))
    error += "Campo Cap non valido!\n";

	if(mansione[1].checked && descrizione.value == "")
    error += "Poichè lavori, la Descrizione del lavoro non può essere vuota!\n";

  if(error != "")
    alert(error);
  else
		alert("Dati corretti");

  return false;
}

function reset(){
  cognome.value = "";
  nome.value = "";
  matricola.value = "";
	regione.select = regione.options[0];
  email.value = "";
  telefono.value = "";
  richieste.value = "";
}

function isNumber(stringa){
  for(var i=0; i<stringa.length; i++){
    if(stringa.charAt(i) < '0' || stringa.charAt(i) > '9')
      return false;
  }
  return true;
}

function containNumber(stringa){
	var ret = false;
  for(var i=0; i<stringa.length; i++){
    if(stringa.charAt(i) >= '0' && stringa.charAt(i) <= '9')
      ret = true;
  }
  return ret;
}

function getSelectedRadioButton(elements){
	for(var i = 0; i<elements.length; i++)
		if(elements[i].checked)
			return i;
	return -1;
}
