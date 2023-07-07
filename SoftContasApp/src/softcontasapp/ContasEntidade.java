package softcontasapp;
import java.util.List;
import java.util.ArrayList;
public class ContasEntidade {
    List<Contas> contas = new ArrayList<Contas>();
    private double totalAtivo = 0;
    private double totalPassivo = 0;
    private double totalPL = 0;
    private double totalReceita = 0;
    private double totalDespesa = 0;
    private double totalDebitos = 0;
    private double totalCreditos = 0;
    
    
    
    public void getContas(){
        for(Contas c : this.contas){
            c.mostraAtributos();
        }
    }
    
    public void somaSaldo(){
        for(Contas c : this.contas){
            this.somaTipo(c);
            this.somaNatureza(c);
        }
    }
    
    public void mostraTotais(){
        System.out.println("Ativos: "+this.getTotalAtivo());
        System.out.println("Passivos: "+this.getTotalPassivo());
        System.out.println("Patrimônio Líquido: "+this.getTotalPL());
        System.out.println("Receita: "+this.getTotalReceita());
        System.out.println("Despesa: "+this.getTotalDespesa());
        System.out.println("Total de Débitos: "+this.getTotalDebitos());
        System.out.println("Total de Créditos: "+this.getTotalCreditos());
    
    }
    
    public void somaTipo(Contas c){
        
        if(c.getTipo().equals("Ativo")){
                this.somaAtivo(c);
            }
            
            else if(c.getTipo().equals("Passivo")){
                this.somaPassivo(c);
            }
            
            else if (c.getTipo().equals("PL")){
                this.somaPL(c);
            }
            
            else if(c.getTipo().equals("Receita")){
                this.somaReceita(c);
            }
            
            else if(c.getTipo().equals("Despesa")){
                this.somaDespesa(c);
            }
    }
    
    
    public void somaNatureza(Contas c){
        if(c.getNatureza().equals("Debito")){
            this.totalDebitos += c.getSaldo();
        }
        
        else{
            this.totalCreditos += c.getSaldo();
        }
    }
    
    
    public void somaAtivo(Contas c){
        this.totalAtivo += c.getSaldo();
    }
    
    public void somaPassivo(Contas c){
        this.totalPassivo += c.getSaldo();
    }
    
    public void somaPL(Contas c){
        this.totalPL += c.getSaldo();
    }
    
    public void somaReceita(Contas c){
        this.totalReceita += c.getSaldo();
    }
    
    public void somaDespesa(Contas c){
        this.totalDespesa += c.getSaldo();
    }

    public double getTotalAtivo() {
        return totalAtivo;
    }

    public void setTotalAtivo(double totalAtivo) {
        this.totalAtivo = totalAtivo;
    }

    public double getTotalPassivo() {
        return totalPassivo;
    }

    public void setTotalPassivo(double totalPassivo) {
        this.totalPassivo = totalPassivo;
    }

    public double getTotalPL() {
        return totalPL;
    }

    public void setTotalPL(double totalPL) {
        this.totalPL = totalPL;
    }

    public double getTotalReceita() {
        return totalReceita;
    }

    public void setTotalReceita(double totalReceita) {
        this.totalReceita = totalReceita;
    }

    public double getTotalDespesa() {
        return totalDespesa;
    }

    public void setTotalDespesa(double totalDespesa) {
        this.totalDespesa = totalDespesa;
    }

    public double getTotalDebitos() {
        return totalDebitos;
    }

    public void setTotalDebitos(double totalDebitos) {
        this.totalDebitos = totalDebitos;
    }

    public double getTotalCreditos() {
        return totalCreditos;
    }

    public void setTotalCreditos(double totalCreditos) {
        this.totalCreditos = totalCreditos;
    }

    
    
    
    
}
