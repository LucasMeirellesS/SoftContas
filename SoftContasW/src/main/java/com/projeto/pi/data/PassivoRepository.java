package com.projeto.pi.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PassivoRepository extends JpaRepository<Passivo, Integer>{
    
    @Query("SELECT new com.projeto.pi.data.PassivoDTO(pc.nome, pc.natureza, p.grupo) FROM PlanoDeContas pc JOIN Passivo p ON pc.id = p.planoDeContas.id")
    List<PassivoDTO> passivoDados();
    
    @Query("SELECT new com.projeto.pi.data.PassivoDTO(pc.nome, pc.natureza, p.grupo) FROM PlanoDeContas pc JOIN Passivo p ON pc.id = p.planoDeContas.id WHERE pc.nome = :nome")
    PassivoDTO findByNome(@Param("nome") String nome);
    
}
