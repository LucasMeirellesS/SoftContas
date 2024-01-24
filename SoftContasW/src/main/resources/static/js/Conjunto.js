//botoes
const saveButton = document.getElementById("save");
const validateAccButton = document.getElementById("accValidate");
const validateBalanceButton = document.getElementById("balanceValidate");
const backButton = document.getElementById("back");
const loadButton = document.getElementById("load");

function save(){
    console.log("save");
}

function validateAcc(){
    console.log("vala");
}

function validateBal(){
    console.log("vaBal");
}

function back(){
    console.log("back");
    window.location.href = 'http://localhost:8080/';
}

function load(){
    console.log("load");
}

saveButton.addEventListener("click", save);
validateAccButton.addEventListener("click",validateAcc);
validateBalanceButton.addEventListener("click",validateBal);
backButton.addEventListener("click", back);
loadButton.addEventListener("click", load);