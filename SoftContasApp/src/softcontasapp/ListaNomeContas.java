/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package softcontasapp;

import java.util.ArrayList;
import java.util.List;


public class ListaNomeContas {
    
    private static final List<String> nomeContas = new ArrayList<>();
    
    public static List<String> Listar(){
    return nomeContas;
    
    }
    
    public static void Adicionar(String nome){
        nomeContas.add(nome);
    }
    
    public static void limpar(){
        nomeContas.clear();
    }
    
}
