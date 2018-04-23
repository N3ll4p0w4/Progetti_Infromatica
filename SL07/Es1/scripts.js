var cognome;
var nome;
var matricola;
var regione;
var email;
var telefono;
var richieste;

function getView(){
	cognome = document.getElementById("cognome");
  nome = document.getElementById("nome");
	matricola = document.getElementById("matricola");
	regione = document.getElementById("regione");
	email = document.getElementById("email");
	telefono = document.getElementById("telefono");
	richieste = document.getElementById("richieste");
}

function invia(){
  var error = "";

  if(cognome.value == "")
    error += "Campo Cognome vuoto!\n";

  if(nome.value == "")
    error += "Campo Nome vuoto!\n";

	if(matricola.value == "")
    error += "Campo Matricola vuoto!\n";
	else if(!isNumber(matricola.value))
    error += "Matricola contiente lettere!\n";

  if(regione.options[regione.selectedIndex].value == "")
    error += "Campo Regione vuoto!\n";

  if(email.value == "")
    error += "Campo Email vuoto!\n";

	if(telefono.value == "")
    error += "Campo Telefono vuoto!\n";
	else if(!isNumber(telefono.value))
    error += "Telefono contiente lettere!\n";

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
