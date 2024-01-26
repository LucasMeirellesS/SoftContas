package com.projeto.pi.data;

import jakarta.persistence.Entity; 

import jakarta.persistence.GeneratedValue; 

import jakarta.persistence.GenerationType; 

import jakarta.persistence.Id; 

import jakarta.persistence.Table; 

import jakarta.validation.constraints.Email; 

import jakarta.validation.constraints.NotBlank; 

import jakarta.validation.constraints.NotNull; 

import jakarta.validation.constraints.Size; 

import lombok.Data; 

import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
@Table(name="Contas_salvas")


public class ContasEntity implements  MostraAtributos{
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String tipo;
    private String nome;
    private double saldo;
    private String natureza;
    private String grupo;
    private String subgrupo;
    
    public ContasEntity(){
    }
    
    public ContasEntity(String nome, double saldo, String natureza, String grupo){
        this.nome = nome;
        this.saldo = saldo;
        this.natureza = natureza;
        this.grupo = grupo;
    }
    
    public ContasEntity(String nome, double saldo, String natureza, String grupo, String subgrupo){
        this.nome = nome;
        this.saldo = saldo;
        this.natureza = natureza;
        this.grupo = grupo;
        this.subgrupo = subgrupo;
    }
    
    
    public void setId(Integer id){
        this.id = id;
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
