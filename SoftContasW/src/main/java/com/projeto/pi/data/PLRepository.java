package com.projeto.pi.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PLRepository extends JpaRepository<PL, Integer>{
    
    @Query("SELECT new com.projeto.pi.data.PLDTO(pc.nome, pc.natureza, pl.grupo) FROM PlanoDeContas pc JOIN PL pl ON pc.id = pl.planoDeContas.id")
    List<PLDTO> plDados();
    
    @Query("SELECT new com.projeto.pi.data.PLDTO(pc.nome, pc.natureza, pl.grupo) FROM PlanoDeContas pc JOIN PL pl ON pc.id = pl.planoDeContas.id WHERE pc.nome = :nome")
    PLDTO findByNome(@Param("nome") String nome);
    
}
