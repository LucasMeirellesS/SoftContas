function registrarClick(){
    console.log("reg");
    window.location.href = 'http://localhost:8080/registra';
}

function selecionarClick(){
    console.log("select");
    window.location.href = 'http://localhost:8080/conjunto';
}




const registrar = document.getElementById("reg");
const selecionar = document.getElementById("select");


registrar.addEventListener("click", registrarClick);
selecionar.addEventListener("click", selecionarClick);
