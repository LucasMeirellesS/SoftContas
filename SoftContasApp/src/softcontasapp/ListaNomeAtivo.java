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
public class ListaNomeAtivo {
    
    private static final List<String> nomeContasAtivo = new ArrayList<>();
    
    public static List<String> Listar(){
    return nomeContasAtivo;
    
    }
    
    public static void Adicionar(String nome){
        nomeContasAtivo.add(nome);
    }
    
    public static void limpar(){
        nomeContasAtivo.clear();
    }
    
}
