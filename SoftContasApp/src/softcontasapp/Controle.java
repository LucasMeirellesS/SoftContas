package softcontasapp;
import java.util.Scanner;
public class Controle {
    Scanner t = new Scanner(System.in);
    
    public int intController(int numero){
        
        while(numero != 1 && numero != 2 && numero != 3 && numero != 4){
            
            System.out.println("Numero inválido, digite novamente:");
            numero = Integer.parseInt(t.nextLine());
        
        }
        return numero;
    }
    
    public String stringController(String opcao){
        
        while(!opcao.equals("S") && !opcao.equals("N")){
            
            System.out.println("Opção inválida, digite novamente:");
            opcao = t.nextLine();
            
        }
        return opcao;
    }
    
    public String naturezaController(String natureza){
        
        while(!natureza.equals("Debito") && !natureza.equals("Credito")){
            
            System.out.println("Opção inválida, digite novamente:");
            natureza = t.nextLine();
        
        }
        return natureza;
    }
    
    public String tipoController(String tipo){
        while(!tipo.equals("Despesa") && !tipo.equals("Receita")){
            System.out.println("Digite um tipo válido:");
            tipo = t.nextLine();
        }
        return tipo;
    }
    
}
