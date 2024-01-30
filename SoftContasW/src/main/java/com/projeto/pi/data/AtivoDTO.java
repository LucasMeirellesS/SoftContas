/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.pi.data;


public class AtivoDTO {
    
    private String nomePlanoDeContas;
    private String naturezaPlanoDeContas;
    private String grupoAtivo;
    private String subgrupoAtivo;

    public AtivoDTO(String nomePlanoDeContas, String naturezaPlanoDeContas, String grupoAtivo, String subgrupoAtivo) {
        this.nomePlanoDeContas = nomePlanoDeContas;
        this.naturezaPlanoDeContas = naturezaPlanoDeContas;
        this.grupoAtivo = grupoAtivo;
        this.subgrupoAtivo = subgrupoAtivo;
    }

    public String getNomePlanoDeContas() {
        return nomePlanoDeContas;
    }

    public void setNomePlanoDeContas(String nomePlanoDeContas) {
        this.nomePlanoDeContas = nomePlanoDeContas;
    }

    public String getNaturezaPlanoDeContas() {
        return naturezaPlanoDeContas;
    }

    public void setNaturezaPlanoDeContas(String naturezaPlanoDeContas) {
        this.naturezaPlanoDeContas = naturezaPlanoDeContas;
    }

    public String getGrupoAtivo() {
        return grupoAtivo;
    }

    public void setGrupoAtivo(String grupoAtivo) {
        this.grupoAtivo = grupoAtivo;
    }

    public String getSubgrupoAtivo() {
        return subgrupoAtivo;
    }

    public void setSubgrupoAtivo(String subgrupoAtivo) {
        this.subgrupoAtivo = subgrupoAtivo;
    }
    
    
}
