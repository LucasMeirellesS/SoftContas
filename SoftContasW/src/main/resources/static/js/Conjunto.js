// Botões
const saveButton = document.getElementById("save");
const validateAccButton = document.getElementById("accValidate"); // Verifique se o ID está correto no HTML
const validateBalanceButton = document.getElementById("balanceValidate");
const backButton = document.getElementById("back");
const loadButton = document.getElementById("load");

function save() {
    console.log("save");
    window.location.href = 'http://localhost:8080/contas/adicionar-conta';
}

function validateAcc() {
    console.log("validate account");
}

function validateBal() {
    console.log("validate balance");
    window.location.href = 'http://localhost:8080/valida-balanco';
}

function back() {
    console.log("back");
    window.location.href = 'http://localhost:8080/';
}

function load() {
    console.log("load");
}

// Adicionando ouvintes de eventos
if (saveButton) {
    saveButton.addEventListener("click", save);
}

if (validateAccButton) {
    validateAccButton.addEventListener("click", validateAcc);
}

if (validateBalanceButton) {
    validateBalanceButton.addEventListener("click", validateBal);
}

if (backButton) {
    backButton.addEventListener("click", back);
}

if (loadButton) {
    loadButton.addEventListener("click", load);
}
