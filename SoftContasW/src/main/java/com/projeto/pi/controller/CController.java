package com.projeto.pi.controller;

import com.projeto.pi.data.AtivoEntity;
import com.projeto.pi.data.ContasEntity;
import com.projeto.pi.data.ContasRepository;
import com.projeto.pi.data.PLEntity;
import com.projeto.pi.data.PassivoEntity;
import com.projeto.pi.data.ResultadoEntity;
import com.projeto.pi.model.Ativo;
import com.projeto.pi.model.Contas;
import com.projeto.pi.model.ContasDao;
import com.projeto.pi.service.ContasService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

@Controller
@CrossOrigin(origins = "*")
public class CController {
    
    @Autowired
    private ContasService contasService;
    
    @Autowired
    private ContasRepository contasRepository;
    
    @GetMapping("/")
    public String mostraTelaI() {
        return "Tela";
    }
    
    @GetMapping("/ativo")
    public String mostraTelaAtivo(Model model) {
        ContasEntity conta = new AtivoEntity();
        model.addAttribute("conta", conta);
        return "Ativo";
    }
    
    @PostMapping("/adicionar-filme")
    public String adicionarFilme(@ModelAttribute ContasEntity conta) {
        contasService.criaConta(conta);
        return "redirect:/";
    }
    
    @GetMapping("/passivo")
    public String mostraTelaPassivo(Model model) {
        ContasEntity conta = new PassivoEntity();
        model.addAttribute("conta", conta);
        return "Passivo";
    }
    
    
    @GetMapping("/pl")
    public String mostraTelaPl(Model model) {
        ContasEntity conta = new PLEntity();
        model.addAttribute("conta", conta);
        return "Liquido";
    }
    
    
    @GetMapping("/registra")
    public String mostraTelaRegistra() {
        return "Registro";
    }
    
    @GetMapping("/resultado")
    public String mostraTelaResultado(Model model) {
        ContasEntity conta = new ResultadoEntity();
        model.addAttribute("conta", conta);
        return "Resultado";
    }
    
    @GetMapping("/atualizarContaForm/{id}")
    public String mostraAtualizarContaForm(@PathVariable("contaId") Integer contaId, Model model){
        ContasEntity conta = contasService.getContasId(contaId);
        model.addAttribute(conta);
        return "AtualizaConta";
    }
    
    @GetMapping("/conjunto")
    public String listarContas(Model model) {
        List<ContasEntity> listarContas = contasService.listarTodasContas();
        model.addAttribute("listarContas", listarContas);
        return "Conjunto";
    }
    
    
    
    @PostMapping("/adicionar-conta-ativo")
    public String salvarContaA(@Valid @ModelAttribute("conta") ContasEntity conta, BindingResult result, Model model){
        if(result.hasErrors()){
            
            return "Ativo";
        }
        
        if(!contasService.validarContaAtivo(conta).equals("A conta foi validada com sucesso!")){
            String mensagem = contasService.validarContaResultado(conta);
            
            model.addAttribute("mensagemValidacao", mensagem);
            return "Ativo";
        }
        
        if (conta.getId() == null){
            contasService.criaConta(conta);
            
        } 
        
        return "redirect:/registra";
    }
    
    @PostMapping("/adicionar-conta-passivo")
    public String salvarContaP(@Valid @ModelAttribute("conta") ContasEntity conta, BindingResult result, Model model){
        if(result.hasErrors()){
            return "Passivo";
        }
        
        if(!contasService.validarContaPassivo(conta).equals("A conta foi validada com sucesso!")){
            String mensagem = contasService.validarContaPassivo(conta);
            
            model.addAttribute("mensagemValidacao", mensagem);
            return "Passivo";
        }
        
        
        if (conta.getId() == null){
            
            contasService.criaConta(conta);
        } 
        
        return "redirect:/registra";
    }
    
    @PostMapping("/adicionar-conta-pl")
    public String salvarContaPl(@Valid @ModelAttribute("conta") ContasEntity conta, BindingResult result, Model model){
        if(result.hasErrors()){
            return "Liquido";
        }
        
        if(!contasService.validarContaPl(conta).equals("A conta foi validada com sucesso!")){
            String mensagem = contasService.validarContaPl(conta);
            
            model.addAttribute("mensagemValidacao", mensagem);
            return "Liquido";
        }
        
        
        if (conta.getId() == null){
            contasService.criaConta(conta);
        } 
        
        return "redirect:/registra";
    }
    
    @PostMapping("/adicionar-conta-resultado")
    public String salvarContaResultado(@Valid @ModelAttribute("conta") ContasEntity conta, BindingResult result, Model model){
        if(result.hasErrors()){
            return "Resultado";
        }
        
        if(!contasService.validarContaResultado(conta).equals("A conta foi validada com sucesso!")){
            String mensagem = contasService.validarContaResultado(conta);
            
            model.addAttribute("mensagemValidacao", mensagem);
            return "Resultado";
        }
        
        if (conta.getId() == null){
            contasService.criaConta(conta);
        } 
        
        return "redirect:/registra";
    }
    
    @RequestMapping("/valida-conta-ativo")
    public String validaAtivo(@ModelAttribute("conta") ContasEntity conta, BindingResult result, Model model){
        String mensagem = contasService.validarContaAtivo(conta);
            
            model.addAttribute("mensagemValidacao", mensagem);
            return "Ativo";
    }
    
    
    @GetMapping("/valida-balanco")
    public String validaB(Model model){
       List<ContasEntity> listarContas = contasService.listarTodasContas();
       model.addAttribute("listarContas", listarContas);
       String msg = contasService.comparaSaldoMensagem(contasService.calculaTotalD(), contasService.calculaTotalC());
       model.addAttribute("msg", msg);
       model.addAttribute("popupStyle", "display: block;");
       return "Conjunto";
    }
    
    
    
    @GetMapping("/validarConta2/{id}")
    public String validarContaForm(@PathVariable("id") Integer id, Model model) {
        ContasEntity conta = contasService.getContasId(id);
        List<ContasEntity> listarContas = contasService.listarTodasContas();
        model.addAttribute("listarContas", listarContas);
        model.addAttribute("popupStyle", "display: block;");
        String msg = null;
        
        if(conta.getTipo().equals("Ativo")){
            msg = contasService.validarContaAtivo(conta);
            model.addAttribute("msg", msg);
        }
        
        if(conta.getTipo().equals("Passivo")){
            msg = contasService.validarContaPassivo(conta);
            model.addAttribute("msg", msg);
        }
        
        if(conta.getTipo().equals("PL")){
            msg = contasService.validarContaPl(conta);
            model.addAttribute("msg", msg);
        }
        
        if(conta.getTipo().equals("Resultado")){
            msg = contasService.validarContaPl(conta);
            model.addAttribute("msg", msg);
        }
        
        
        return "Conjunto";
    }
    
    @GetMapping("/deletar-conta/{id}")
    public String deletarConta(@PathVariable("id") Integer id, Model model){    
        contasService.deletarConta(id);
        
        List<ContasEntity> listarContas = contasService.listarTodasContas();
        model.addAttribute("listarContas", listarContas);
        return "Conjunto";        
    }

    
    @PutMapping("/atualizar-contas/{id}")
    public ResponseEntity<ContasEntity> atualizarContas(@PathVariable Integer id, @RequestBody ContasEntity conta){
        var analiseAtualizado = contasService.atualizarConta(id, conta);
        return new ResponseEntity<>(analiseAtualizado, HttpStatus.OK);
    }
    
    
}
    