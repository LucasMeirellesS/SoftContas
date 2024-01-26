package com.projeto.pi.service;

import com.projeto.pi.data.ContasEntity;
import com.projeto.pi.data.ContasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; 

import org.springframework.stereotype.Service; 


@Service
public class ContasService {
    
    @Autowired
    ContasRepository contasRepository;
    
    public ContasEntity criaConta(ContasEntity conta){
        conta.setId(null);
        contasRepository.save(conta);
        return conta;
    }
    
    public List<ContasEntity> listarTodasContas(){
        return contasRepository.findAll();
        
    }
    
    
    
    
}
