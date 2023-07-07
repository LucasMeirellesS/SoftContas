package softcontasapp;

public class ComparaValor {
    public void ComparaValor(ContasEntidade contas){
        if(contas.getTotalDebitos() != contas.getTotalCreditos()){
            
            System.out.println("Erro!");
            System.out.println("Alguma conta foi registrada com o valor incorreto, com natureza errada ou faltou, verifique a lista de contas e registre novamente.");
            
        }
        
        else{
            System.out.println("Lista de contas de acordo com o método das partidas dobradas.");
        }
    }
}
