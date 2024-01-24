function ativoClick(){
    console.log("##ativo##");
    window.location.href = 'http://localhost:8080/ativo';
}

function passivoClick(){
    console.log("##passivo##");
    window.location.href = 'http://localhost:8080/passivo';
}

function patrimonioClick(){
    console.log("##patrimonio##");
    window.location.href = 'http://localhost:8080/pl';
}

function resultadoClick(){
    console.log("##resultadio##");
    window.location.href = 'http://localhost:8080/resultado';
}

function voltarClick(){
    console.log("##voltar##");
    window.location.href = 'http://localhost:8080/';
}

const ativo = document.getElementById("ativo");
const passivo = document.getElementById("passivo");
const patrimonio = document.getElementById("patrimonio");
const resultado = document.getElementById("resultado");
const voltar = document.getElementById("voltar");

ativo.addEventListener("click", ativoClick);
passivo.addEventListener("click", passivoClick);
patrimonio.addEventListener("click", patrimonioClick);
resultado.addEventListener("click", resultadoClick);
voltar.addEventListener("click", voltarClick);