package com.projeto.pi.data;

public class PassivoDTO {
    private String nomePlanoDeContas;
    private String naturezaPlanoDeContas;
    private String grupoPassivo;

    public PassivoDTO(String nomePlanoDeContas, String naturezaPlanoDeContas, String grupoPassivo) {
        this.nomePlanoDeContas = nomePlanoDeContas;
        this.naturezaPlanoDeContas = naturezaPlanoDeContas;
        this.grupoPassivo = grupoPassivo;
        
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

    public String getGrupoPassivo() {
        return grupoPassivo;
    }

    public void setGrupoPassivo(String grupoPassivo) {
        this.grupoPassivo = grupoPassivo;
    }
    
}
