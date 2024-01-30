package com.projeto.pi.service;

import com.projeto.pi.data.AtivoRepository;
import com.projeto.pi.data.ContasEntity;
import com.projeto.pi.data.ContasRepository;
import com.projeto.pi.data.AtivoDTO;
import com.projeto.pi.data.PLDTO;
import com.projeto.pi.data.PLRepository;
import com.projeto.pi.data.PassivoDTO;
import com.projeto.pi.data.PassivoRepository;
import com.projeto.pi.data.PlanoDeContas;
import com.projeto.pi.data.PlanoDeContasRepository;
import com.projeto.pi.data.ResultadoDTO;
import com.projeto.pi.data.ResultadoRepository;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; 

import org.springframework.stereotype.Service; 


@Service
public class ContasService {
    
    
    
    @Autowired
    ContasRepository contasRepository;
    
    List<ContasEntity> listaContas;
    
    @Autowired 
    AtivoRepository ativoRepository;
    
    @Autowired
    PlanoDeContasRepository planoRepository;
    
    @Autowired
    PassivoRepository passivoRepository; 
    
    @Autowired
    PLRepository plRepository;
    
    @Autowired
    ResultadoRepository resultadoRepository;
    
    @PostConstruct
    public void init() {
        listaContas = contasRepository.findAll();
    }
    
    
    
    public ContasEntity criaConta(ContasEntity conta){
        conta.setId(null);
        
        contasRepository.save(conta);
        return conta;
    }
    
    public List<ContasEntity> listarTodasContas(){
        return contasRepository.findAll();
        
    }
    
    public ContasEntity getContasId(Integer contaId){
        
        return contasRepository.findById(contaId).orElse(null);
    }
    
    
    public String validarContaAtivo(ContasEntity conta){
        List<AtivoDTO> contasAtivo = ativoRepository.ativoDados();
        List<PlanoDeContas> planoContas = planoRepository.findAll();
        List<String> nomePlanoContas = new ArrayList();
        List<String> nomeAtivo = new ArrayList();
        List<String> naturezaAtivo = new ArrayList();
        List<String> grupoAtivo = new ArrayList();
        List<String> subgrupoAtivo = new ArrayList();
        
        
        
        for(AtivoDTO ativo: contasAtivo){
            nomeAtivo.add(ativo.getNomePlanoDeContas());
            naturezaAtivo.add(ativo.getNaturezaPlanoDeContas());
            grupoAtivo.add(ativo.getGrupoAtivo());
            subgrupoAtivo.add(ativo.getSubgrupoAtivo());
            
        }
        
        for (PlanoDeContas plano: planoContas){
            nomePlanoContas.add(plano.getNome());
        }
        
        
        
        if(nomePlanoContas.contains(conta.getNome().toUpperCase())){
            if(nomeAtivo.contains(conta.getNome().toUpperCase())){
                AtivoDTO ativo = ativoRepository.findByNome(conta.getNome());
                String comparaNatureza = ativo.getNaturezaPlanoDeContas();
                String comparaGrupo = ativo.getGrupoAtivo();
                String comparaSubgrupo = ativo.getSubgrupoAtivo();
                

                if(conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo) && conta.getSubgrupo().toLowerCase().equals(comparaSubgrupo)){
                    String resposta =  "A conta foi validada com sucesso!";
                    return resposta;
                }

                    else if(conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo) && !conta.getSubgrupo().toLowerCase().equals(comparaSubgrupo)){
                        String resposta = "O subgrupo da conta está incorreto! O correto é "+comparaSubgrupo+"!";
                        return resposta;
                    }
                    
                    else if(conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo) && conta.getSubgrupo().toLowerCase().equals(comparaSubgrupo)){
                        
                        String resposta = "Grupo da conta está incorreto! O correto é "+comparaGrupo+"!";
                        return resposta;
                    }
                    
                    else if(conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo) && !conta.getSubgrupo().toLowerCase().equals(comparaSubgrupo)){
                        String resposta = "Grupo e subgrupo da conta estão incorretos! O grupo correto é "+comparaGrupo+" e o subgrupo é "+comparaSubgrupo+"!";
                        return resposta;
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo) && !conta.getSubgrupo().toLowerCase().equals(comparaSubgrupo)){
                        String resposta = "Natureza e subgrupo da conta estão incorretos! O grupo correto é "+comparaGrupo+" e o subgrupo é "+comparaSubgrupo+"!";
                        return resposta;
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo) && conta.getSubgrupo().toLowerCase().equals(comparaSubgrupo)){
                        String resposta = "Natureza da conta está incorreta! O correto é "+comparaNatureza+"!";
                        return resposta;
                    }
           
                    else if(!conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo) && conta.getSubgrupo().toLowerCase().equals(comparaSubgrupo)){
                        String resposta = "Natureza e grupo da conta estão incorretos! O correto é "+comparaNatureza+", "+comparaGrupo+"!";
                        return resposta;
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo) && !conta.getSubgrupo().toLowerCase().equals(comparaSubgrupo)){
                        String resposta = "A natureza, o grupo, e o subgrupo da conta estão incorretos! O corretos são "+comparaNatureza+", "+comparaGrupo+", "+comparaSubgrupo+"!";
                        return resposta;
                    }
                    

                
            }
            else{
                String resposta = "Essa conta não é uma conta de ativo!";
                return resposta;
            }
        }
        
        else{
            String resposta = "A conta não está registrada no plano de contas!";
            return resposta;
        }
        return "Conta validada com sucesso!";
        
    }
    
    
    public String validarContaPassivo(ContasEntity conta){
        List<PassivoDTO> contasPassivo = passivoRepository.passivoDados();
        List<PlanoDeContas> planoContas = planoRepository.findAll();
        List<String> nomePlanoContas = new ArrayList();
        List<String> nomePassivo = new ArrayList();
        List<String> naturezaPassivo = new ArrayList();
        List<String> grupoPassivo = new ArrayList();
        
        
        
        
        for(PassivoDTO passivo: contasPassivo){
            nomePassivo.add(passivo.getNomePlanoDeContas());
            naturezaPassivo.add(passivo.getNaturezaPlanoDeContas());
            grupoPassivo.add(passivo.getGrupoPassivo());
            
        }
        
        for (PlanoDeContas plano: planoContas){
            nomePlanoContas.add(plano.getNome());
        }
        
        
        
        if(nomePlanoContas.contains(conta.getNome().toUpperCase())){
            if(nomePassivo.contains(conta.getNome().toUpperCase())){
                PassivoDTO passivo = passivoRepository.findByNome(conta.getNome());
                String comparaNatureza = passivo.getNaturezaPlanoDeContas();
                String comparaGrupo = passivo.getGrupoPassivo();
                
                

                if(conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                    String resposta =  "A conta foi validada com sucesso!";
                    return resposta;
                }

                   
                    
                    else if(conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        
                        String resposta = "Grupo da conta está incorreto! O correto é "+comparaGrupo+"!";
                        return resposta;
                    }
                    
                    else if(conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        String resposta = "Grupo e subgrupo da conta estão incorretos! O grupo correto é "+comparaGrupo+"!";
                        return resposta;
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        String resposta = "Natureza e subgrupo da conta estão incorretos! O grupo correto é "+comparaGrupo+"!";
                        return resposta;
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        String resposta = "Natureza da conta está incorreta! O correto é "+comparaNatureza+"!";
                        return resposta;
                    }
           
                    else if(!conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        String resposta = "Natureza e grupo da conta estão incorretos! O correto é "+comparaNatureza+", "+comparaGrupo+"!";
                        return resposta;
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        String resposta = "A natureza, o grupo, e o subgrupo da conta estão incorretos! O corretos são "+comparaNatureza+" e "+comparaGrupo+"!";
                        return resposta;
                    }
                    

                
            }
            else{
                String resposta = "Essa conta não é uma conta de passivo!";
                return resposta;
            }
        }
        
        else{
            String resposta = "A conta não está registrada no plano de contas!";
            return resposta;
        }
        return "Conta validada com sucesso!";
        
    }
    
    
    public String validarContaPl(ContasEntity conta){
        List<PLDTO> contasPL = plRepository.plDados();
        List<PlanoDeContas> planoContas = planoRepository.findAll();
        List<String> nomePlanoContas = new ArrayList();
        List<String> nomePL = new ArrayList();
        List<String> naturezaPL = new ArrayList();
        List<String> grupoPL = new ArrayList();
        
        
        
        for(PLDTO pl: contasPL){
            nomePL.add(pl.getNomePlanoDeContas());
            naturezaPL.add(pl.getNaturezaPlanoDeContas());
            
            
        }
        
        for (PlanoDeContas plano: planoContas){
            nomePlanoContas.add(plano.getNome());
        }
        
        
        
        if(nomePlanoContas.contains(conta.getNome().toUpperCase())){
            if(nomePL.contains(conta.getNome().toUpperCase())){
                PLDTO pl = plRepository.findByNome(conta.getNome());
                String comparaNatureza = pl.getNaturezaPlanoDeContas();
                String comparaGrupo = pl.getGrupoPl();
                
                

                if(conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                    String resposta =  "A conta foi validada com sucesso!";
                    return resposta;
                }

                   
                    
                    else if(conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        
                        String resposta = "Grupo da conta está incorreto! O correto é "+comparaGrupo+"!";
                        return resposta;
                    }
                    
                    else if(conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        String resposta = "Grupo e subgrupo da conta estão incorretos! O grupo correto é "+comparaGrupo+"!";
                        return resposta;
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        String resposta = "Natureza e subgrupo da conta estão incorretos! O grupo correto é "+comparaGrupo+"!";
                        return resposta;
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        String resposta = "Natureza da conta está incorreta! O correto é "+comparaNatureza+"!";
                        return resposta;
                    }
           
                    else if(!conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        String resposta = "Natureza e grupo da conta estão incorretos! O correto é "+comparaNatureza+", "+comparaGrupo+"!";
                        return resposta;
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        String resposta = "A natureza, o grupo, e o subgrupo da conta estão incorretos! O corretos são "+comparaNatureza+" e "+comparaGrupo+"!";
                        return resposta;
                    }
                    

                
            }
            else{
                String resposta = "Essa conta não é uma conta de patrimonio líquido!";
                return resposta;
            }
        }
        
        else{
            String resposta = "A conta não está registrada no plano de contas!";
            return resposta;
        }
        return "Conta validada com sucesso!";
        
    }
    
    
    
    public String validarContaResultado(ContasEntity conta){
        List<ResultadoDTO> contasResultado = resultadoRepository.resultadoDados();
        List<PlanoDeContas> planoContas = planoRepository.findAll();
        List<String> nomePlanoContas = new ArrayList();
        List<String> nomeResultado = new ArrayList();
        List<String> naturezaResultado = new ArrayList();
        List<String> grupoResultado = new ArrayList();
        
        
        
        for(ResultadoDTO r: contasResultado){
            nomeResultado.add(r.getNomePlanoDeContas());
            naturezaResultado.add(r.getNaturezaPlanoDeContas());
            
            
        }
        
        for (PlanoDeContas plano: planoContas){
            nomePlanoContas.add(plano.getNome());
        }
        
        
        
        if(nomePlanoContas.contains(conta.getNome().toUpperCase())){
            if(nomeResultado.contains(conta.getNome().toUpperCase())){
                ResultadoDTO resultado = resultadoRepository.findByNome(conta.getNome());
                String comparaNatureza = resultado.getNaturezaPlanoDeContas();
                String comparaGrupo = resultado.getGrupoResultado();
                
                

                if(conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                    String resposta =  "A conta foi validada com sucesso!";
                    return resposta;
                }

                   
                    
                    else if(conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        
                        String resposta = "Grupo da conta está incorreto! O correto é "+comparaGrupo+"!";
                        return resposta;
                    }
                    
                    else if(conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        String resposta = "Grupo e subgrupo da conta estão incorretos! O grupo correto é "+comparaGrupo+"!";
                        return resposta;
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        String resposta = "Natureza e subgrupo da conta estão incorretos! O grupo correto é "+comparaGrupo+"!";
                        return resposta;
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        String resposta = "Natureza da conta está incorreta! O correto é "+comparaNatureza+"!";
                        return resposta;
                    }
           
                    else if(!conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        String resposta = "Natureza e grupo da conta estão incorretos! O correto é "+comparaNatureza+", "+comparaGrupo+"!";
                        return resposta;
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        String resposta = "A natureza, o grupo, e o subgrupo da conta estão incorretos! O corretos são "+comparaNatureza+" e "+comparaGrupo+"!";
                        return resposta;
                    }
                    

                
            }
            else{
                String resposta = "Essa conta não é uma conta de resultado!";
                return resposta;
            }
        }
        
        else{
            String resposta = "A conta não está registrada no plano de contas!";
            return resposta;
        }
        return "Conta validada com sucesso!";
        
    }
    
    
    public String comparaSaldoMensagem(double valorD, double valorC){
        String mensagem = "Balanço validado com sucesso!";
        if (valorD > valorC){
            mensagem = "O valor dos débitos é maior que o valor dos créditos";
        } else if (valorD < valorC){
            mensagem = "O valor dos créditos é maior que o valor dos débitos";
        } 
        
        return mensagem;
    }
    
    public boolean comparaSaldo(double valorD, double valorC){
        if (valorD != valorC){
            return false;
        } 
        
        return true;
    }
    
    
    
    public double calculaTotalD(){
        double totalD = 0;
        List<ContasEntity> listaContas = this.listarTodasContas();
        for(ContasEntity conta: listaContas){
            if (conta.getNatureza().equals("D")){
                totalD += conta.getSaldo();
            }
        }
        return totalD;
    }
    
    public double calculaTotalC(){
        double totalC = 0;
        List<ContasEntity> listaContas = this.listarTodasContas();
        for(ContasEntity conta: listaContas){
            if (conta.getNatureza().equals("C")){
                totalC += conta.getSaldo();
            }
        }
        return totalC;
    }
    
    
    public boolean validarBalanco(){
        double totalD = this.calculaTotalD();
        double totalC = this.calculaTotalC();
        
        return this.comparaSaldo(totalD, totalC);
        
        
    }
    
    
    public void deletarConta(Integer filmeId) {
        ContasEntity conta = this.getContasId(filmeId);
        contasRepository.deleteById(conta.getId());
    
    }
    
    public ContasEntity atualizarConta(Integer contaId, ContasEntity contaRequest) {
        ContasEntity conta = getContasId(contaId);

        conta.setTipo(contaRequest.getTipo());
        conta.setNome(contaRequest.getNome());
        conta.setSaldo(contaRequest.getSaldo());
        conta.setNatureza(contaRequest.getNatureza());
        conta.setGrupo(contaRequest.getGrupo());
        conta.setSubgrupo(contaRequest.getSubgrupo());
        
        // Salvar as alterações no banco de dados
        contasRepository.save(conta);

        return conta;
    }
    
    
    
}
