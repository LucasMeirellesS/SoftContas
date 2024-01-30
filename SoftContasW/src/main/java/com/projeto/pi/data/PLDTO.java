package com.projeto.pi.data;


public class PLDTO {

private String nomePlanoDeContas;
    private String naturezaPlanoDeContas;
    private String grupoPl;

    public PLDTO(String nomePlanoDeContas, String naturezaPlanoDeContas, String grupoPl) {
        this.nomePlanoDeContas = nomePlanoDeContas;
        this.naturezaPlanoDeContas = naturezaPlanoDeContas;
        this.grupoPl = grupoPl;
        
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

    public String getGrupoPl() {
        return grupoPl;
    }

    public void setGrupoPl(String grupoPl) {
        this.grupoPl = grupoPl;
    }
    
    


    
}
