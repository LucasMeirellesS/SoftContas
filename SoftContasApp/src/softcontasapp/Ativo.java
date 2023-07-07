package softcontasapp;

public class Ativo extends Contas {
    public Ativo(String nome, double saldo, String natureza, String grupo, String subgrupo){
        super(nome, saldo, natureza, grupo, subgrupo);
        this.setTipo("Ativo");
    }
    
    public Ativo(){
        
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
