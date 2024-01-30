package com.projeto.pi.model;
public class Resultado extends Contas{
    public Resultado(String nome, double saldo, String natureza, String grupo){
        super(nome, saldo, natureza, grupo);
        this.setSubgrupo(null);
        this.setTipo("Resultado");
    }
    
    
    public Resultado(){}
    
    @Override
    public void mostraAtributos(){
        
        System.out.println("--------------------");
        System.out.println("Tipo: "+this.getTipo());
        System.out.println("Nome: "+this.getNome());
        System.out.println("Saldo: "+this.getSaldo());
        System.out.println("Natureza: "+this.getNatureza());
        System.out.println("Grupo: "+this.getGrupo());
        System.out.println("--------------------");
        
    }
}
