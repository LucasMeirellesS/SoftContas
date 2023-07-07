package softcontasapp;

import softcontas.gui.RegistroAtivo;
import softcontas.gui.RegistroPassivo;
import softcontas.gui.RegistroPL;
import softcontas.gui.RegistroResultado;


public class CriaContas {
    Contas conta;
    DefineAtributo atributo = new DefineAtributo();
    RegistroAtivo ativo;
    RegistroPassivo passivo;
    RegistroPL pl;
    RegistroResultado resultado;
    
    public void setAtivo(RegistroAtivo ativo){
        this.ativo = ativo;
    }
    
    public void setPassivo(RegistroPassivo passivo){
        this.passivo = passivo;
    }
    
    public void setPL(RegistroPL pl){
        this.pl = pl;
    }
    
    public void setResultado(RegistroResultado resultado){
        this.resultado = resultado;
    }
    
    public Contas criaConta(int escolha){
        
        String nome;
        double saldo;
        String natureza;
        String grupo;
        String subgrupo;
        
        
        
        switch(escolha){
            case 1:
                nome = this.ativo.getNome();
                saldo = this.ativo.getSaldo();
                natureza = this.ativo.getNatureza();
                grupo = this.ativo.getGrupo();
                subgrupo = this.ativo.getSubgrupo();
                this.conta = new Ativo(nome, saldo, natureza, grupo, subgrupo);
                break;
                        
            case 2:
                nome = this.passivo.getNome();
                saldo = this.passivo.getSaldo();
                natureza = this.passivo.getNatureza();
                grupo = this.passivo.getGrupo();
                this.conta = new Passivo(nome, saldo, natureza, grupo);
                break;
            
            case 3:
                nome = this.pl.getNome();
                saldo = this.pl.getSaldo();
                natureza = this.pl.getNatureza();
                grupo = this.pl.getGrupo();
                this.conta = new PL(nome, saldo, natureza, grupo);
                break;
            
            case 4:
                nome = this.resultado.getNome();
                saldo = this.resultado.getSaldo();
                natureza = this.resultado.getNatureza();
                grupo = this.resultado.getGrupo();
                this.conta = new Resultado(nome, saldo, natureza, grupo);
                break;
        }
        
        return this.conta;
    }
    
    
}
