package com.projeto.pi.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AtivoRepository extends JpaRepository<Ativo, Integer>{
    
    @Query("SELECT new com.projeto.pi.data.AtivoDTO(pc.nome, pc.natureza, a.grupo, a.subgrupo) FROM PlanoDeContas pc JOIN Ativo a ON pc.id = a.planoDeContas.id")
    List<AtivoDTO> ativoDados();
    
    @Query("SELECT new com.projeto.pi.data.AtivoDTO(pc.nome, pc.natureza, a.grupo, a.subgrupo) FROM PlanoDeContas pc JOIN Ativo a ON pc.id = a.planoDeContas.id WHERE pc.nome = :nome")
    AtivoDTO findByNome(@Param("nome") String nome);
    
}
