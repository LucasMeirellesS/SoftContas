package com.projeto.pi.controller;

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

    @GetMapping("/")
    public String mostraTelaI() {
        return "Tela";
    }
    
    @GetMapping("/ativo")
    public String mostraTelaAtivo() {
        return "Ativo";
    }
    
    
    @GetMapping("/passivo")
    public String mostraTelaPassivo() {
        return "Ativo";
    }
    
    
    @GetMapping("/pl")
    public String mostraTelaPl() {
        return "Liquido";
    }
    
    
    @GetMapping("/registra")
    public String mostraTelaRegistra() {
        return "Registro";
    }
    
    @GetMapping("/resultado")
    public String mostraTelaResultado() {
        return "Resultado";
    }
    
    @GetMapping("/conjunto")
    public String mostraTelaConjunto() {
        return "Conjunto";
    }
}
