package com.projeto.pi.controller;

import com.projeto.pi.data.AtivoEntity;
import com.projeto.pi.data.ContasEntity;
import com.projeto.pi.data.PLEntity;
import com.projeto.pi.data.PassivoEntity;
import com.projeto.pi.data.ResultadoEntity;
import com.projeto.pi.service.ContasService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

@Controller
@CrossOrigin(origins = "*")
public class CController {
    
    @Autowired
    private ContasService contasService;
    
    
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
    
    @GetMapping("/conjunto")
    public String listarContas(Model model) {
        List<ContasEntity> listarContas = contasService.listarTodasContas();
        model.addAttribute("listarContas", listarContas);
        return "Conjunto";
    }
    
    
    
    @PostMapping("/adicionar-conta-ativo")
    public String salvarContaA(@Valid @ModelAttribute("conta") ContasEntity conta, BindingResult result){
        if(result.hasErrors()){
            return "Ativo";
        }
        if (conta.getId() == null){
            contasService.criaConta(conta);
        } 
        
        return "redirect:/registra";
    }
    
    @PostMapping("/adicionar-conta-passivo")
    public String salvarContaP(@Valid @ModelAttribute("conta") ContasEntity conta, BindingResult result){
        if(result.hasErrors()){
            return "Passivo";
        }
        if (conta.getId() == null){
            contasService.criaConta(conta);
        } 
        
        return "redirect:/registra";
    }
    
    @PostMapping("/adicionar-conta-pl")
    public String salvarContaPl(@Valid @ModelAttribute("conta") ContasEntity conta, BindingResult result){
        if(result.hasErrors()){
            return "Liquido";
        }
        if (conta.getId() == null){
            contasService.criaConta(conta);
        } 
        
        return "redirect:/registra";
    }
    
    @PostMapping("/adicionar-conta-resultado")
    public String salvarContaResultado(@Valid @ModelAttribute("conta") ContasEntity conta, BindingResult result){
        if(result.hasErrors()){
            return "Resultado";
        }
        if (conta.getId() == null){
            contasService.criaConta(conta);
        } 
        
        return "redirect:/registra";
    }
    
    
}
