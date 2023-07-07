package softcontasapp;
import java.util.Scanner;
public class DefineAtributo {
    Scanner t = new Scanner(System.in);
    Controle controle = new Controle();
    
    public String escolheTipo(){
        System.out.println("Digite o tipo da conta:");
        String tipo = t.nextLine();
        tipo = controle.tipoController(tipo);
        return tipo;
    }
    
    public String escolheNome(){
        System.out.println("Digite o nome da conta:");
        String nome = t.nextLine();
        return nome;
    }
    
    public double escolheSaldo(){
        System.out.println("Digite o saldo da conta:");
        double saldo = Double.parseDouble(t.nextLine());
        return saldo;
    }
    
    public String escolheNatureza(){
        System.out.println("Digite a natureza da conta:");
        String natureza = t.nextLine();
        natureza = controle.naturezaController(natureza);
        return natureza;
    }
    
    public String escolheGrupo(){
        System.out.println("Digite o grupo do qual a conta pertence:");
        String grupo = t.nextLine();
        return grupo;
    }
    
    public String escolheSubgrupo(){
        System.out.println("Digite o subgrupo do qual a conta pertence:");
        String subgrupo = t.nextLine();
        return subgrupo;
    }
    
    
}
