/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.pi.data;

/**
 *
 * @author lucas
 */
public class ResultadoEntity extends ContasEntity{
    public ResultadoEntity(String nome, double saldo, String natureza, String grupo){
        super(nome, saldo, natureza, grupo);
        this.setSubgrupo(null);
        this.setTipo("Resultado");
    }
    
    
    public ResultadoEntity(){
        this.setTipo("Resultado");
    }
    
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
