//botoes
const saveButton = document.getElementById("save");
const validateButton = document.getElementById("validate");
const backButton = document.getElementById("back");

//inputs
const nome = document.getElementById("nome");
const saldo = document.getElementById("saldo");
const natureza = document.getElementById("natureza");
const grupo = document.getElementById("grupo");

//form
const meuForm = document.getElementById("formConta");


function saveClick(){
    console.log("salvei:")
    console.log("nome: " + nome.value);
    console.log("saldo: " + saldo.value);
    console.log("natureza: " + natureza.value);
    console.log("grupo: " + grupo.value);
}

function validateClick(){
    console.log("Validando:")
    console.log("nome: " + nome.value);
    console.log("saldo: " + saldo.value);
    console.log("natureza: " + natureza.value);
    console.log("grupo: " + grupo.value);
}

function backClick(){
    console.log("Voltando...");
    window.location.href = 'http://localhost:8080/registra';
    
}

saveButton.addEventListener("click", saveClick);
validateButton.addEventListener("click", validateClick);
backButton.addEventListener("click", backClick);



function nameValidate(input){
    if(/^[a-zA-ZÀ-ÿ\s]+/.test(input.value)){
        input.setCustomValidity("");    
        return true;
    }else{
        input.setCustomValidity("Nome inválido");
        return false;
    }
}

function saldoValidate(input){
    if(/^\d+(.\d{1,2})?$/.test(input.value)){
        input.setCustomValidity("");
        return true;
    }else{
        input.setCustomValidity("Valor inválido");
        return false;
    }
}