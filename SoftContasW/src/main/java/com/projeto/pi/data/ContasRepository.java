package com.projeto.pi.data;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

@Repository
public interface ContasRepository extends JpaRepository<ContasEntity, Integer>{

    
    
}
