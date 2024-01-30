/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.pi.data;

/**
 *
 * @author lucas
 */
public class ResultadoDTO {
    private String nomePlanoDeContas;
    private String naturezaPlanoDeContas;
    private String grupoResultado;

    public ResultadoDTO(String nomePlanoDeContas, String naturezaPlanoDeContas, String grupoResultado){
        this.nomePlanoDeContas = nomePlanoDeContas;
        this.naturezaPlanoDeContas = naturezaPlanoDeContas;
        this.grupoResultado = grupoResultado;
        
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

    public String getGrupoResultado() {
        return grupoResultado;
    }

    public void setGrupoResultado(String grupoResultado) {
        this.grupoResultado = grupoResultado;
    }
    
    

}
