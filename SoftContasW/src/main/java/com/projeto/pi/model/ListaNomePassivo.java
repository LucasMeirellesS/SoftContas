/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.pi.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LUCAS MEIRELLES
 */
public class ListaNomePassivo {
    
    private static final List<String> nomeContasPassivo = new ArrayList<>();
    
    public static List<String> Listar(){
    return nomeContasPassivo;
    
    }
    
    public static void Adicionar(String nome){
        nomeContasPassivo.add(nome);
    }
    
    public static void limpar(){
        nomeContasPassivo.clear();
    
    }    
}
