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
const meuForm = document.querySelector(".form-container");


function saveClick(){
    if(nameValidate(nome) && saldoValidate(saldo)){
        console.log("salvei:")
        console.log("nome: " + nome.value);
        console.log("saldo: " + saldo.value);
        console.log("natureza: " + natureza.value);
        console.log("grupo: " + grupo.value);
    }else{
        console.log('dados inválidos');
    }
    
}

function validateClick(){
    
    if(nameValidate(nome) && saldoValidate(saldo)){
        console.log("Validando:")
        console.log("nome: " + nome.value);
        console.log("saldo: " + saldo.value);
        console.log("natureza: " + natureza.value);
        console.log("grupo: " + grupo.value);
    }else{
        console.log('dados inválidos');
    }
}

function backClick(){
    console.log("Voltando...")
    
}

saveButton.addEventListener("click", saveClick);
validateButton.addEventListener("click", validateClick);
backButton.addEventListener("click", backClick);
meuForm.addEventListener("submit", (event) => { event.preventDefault(); });


function nameValidate(input){
    if(/[a-zA-Z]+/.test(input.value)){
        input.setCustomValidity("");
        return true;
    }else{
        input.setCustomValidity("Nome inválido");
        return false;
    }
}

function saldoValidate(input){
    if(/^\d+(,\d{1,2})?$/.test(input.value)){
        input.setCustomValidity("");
        return true;
    }else{
        input.setCustomValidity("Valor inválido");
        return false;
    }
}