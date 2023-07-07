/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package softcontasapp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LUCAS MEIRELLES
 */
public class ListaContasAtivo {
    private static final List<Contas> lista = new ArrayList<>();
    
    public static List<Contas> Listar(){
        return lista;
    
    }
    
    public static void Adicionar(Contas conta){
        lista.add(conta);
    }
    
    public static void limpar(){
        lista.clear();
    }
}
