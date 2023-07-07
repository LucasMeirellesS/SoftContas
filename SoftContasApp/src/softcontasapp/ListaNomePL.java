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
public class ListaNomePL {
    
    private static final List<String> nomeContasPL = new ArrayList<>();
    
    public static List<String> Listar(){
    return nomeContasPL;
    
    }
    
    public static void Adicionar(String nome){
        nomeContasPL.add(nome);
    }
    
    public static void limpar(){
        nomeContasPL.clear();
    
    } 
    
    
}
