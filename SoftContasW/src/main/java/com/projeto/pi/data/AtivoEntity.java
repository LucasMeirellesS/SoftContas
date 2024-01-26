package com.projeto.pi.data;

public class AtivoEntity extends ContasEntity {
    public AtivoEntity(String nome, double saldo, String natureza, String grupo, String subgrupo){
        super(nome.toUpperCase(), saldo, natureza, grupo, subgrupo);
        this.setTipo("Ativo");
    }
    
    public AtivoEntity(){
        this.setTipo("Ativo");
    }
    
    @Override
    public void mostraAtributos(){
        
        System.out.println("--------------------");
        System.out.println("Tipo: "+this.getTipo());
        System.out.println("Nome: "+this.getNome());
        System.out.println("Saldo: "+this.getSaldo());
        System.out.println("Natureza: "+this.getNatureza());
        System.out.println("Grupo: "+this.getGrupo());
        System.out.println("Subgrupo: "+this.getSubgrupo());
        System.out.println("--------------------");
        
    }
}
