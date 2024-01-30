package com.projeto.pi.model;

import com.projeto.pi.data.MostraAtributos;

public class Contas implements MostraAtributos{
   
    private String tipo;
    private String nome;
    private double saldo;
    private String natureza;
    private String grupo;
    private String subgrupo;
    
    public Contas(){
    }
    
    public Contas(String nome, double saldo, String natureza, String grupo){
        this.nome = nome;
        this.saldo = saldo;
        this.natureza = natureza;
        this.grupo = grupo;
    }
    
    public Contas(String nome, double saldo, String natureza, String grupo, String subgrupo){
        this.nome = nome;
        this.saldo = saldo;
        this.natureza = natureza;
        this.grupo = grupo;
        this.subgrupo = subgrupo;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(String subgrupo) {
        this.subgrupo = subgrupo;
    }
    
    @Override
    public void mostraAtributos(){}
    
}
