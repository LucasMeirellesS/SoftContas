/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.projeto.pi.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Integer> {
    
    @Query("SELECT new com.projeto.pi.data.ResultadoDTO(pc.nome, pc.natureza, r.grupo) FROM PlanoDeContas pc JOIN Resultado r ON pc.id = r.planoDeContas.id")
    List<ResultadoDTO> resultadoDados();
    
    @Query("SELECT new com.projeto.pi.data.ResultadoDTO(pc.nome, pc.natureza, r.grupo) FROM PlanoDeContas pc JOIN Resultado r ON pc.id = r.planoDeContas.id WHERE pc.nome = :nome")
    ResultadoDTO findByNome(@Param("nome") String nome);
    
}
