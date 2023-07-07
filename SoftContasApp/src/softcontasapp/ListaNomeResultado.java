package softcontasapp;

import java.util.ArrayList;
import java.util.List;


public class ListaNomeResultado {
    
    private static final List<String> nomeContasResultado = new ArrayList<>();
    
    public static List<String> Listar(){
    return nomeContasResultado;
    
    }
    
    public static void Adicionar(String nome){
        nomeContasResultado.add(nome);
    }
    
    public static void limpar(){
        nomeContasResultado.clear();
    
    } 
    
}
