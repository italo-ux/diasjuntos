package com.projeto.diasjuntos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Define que essa classe é um controlador REST que responde a requisições HTTP
@RestController
@RequestMapping("/api") //define o caminho base para as requisições desse controlador
public class NumeroController {
   //injeta o serviço que controla o numero
   @Autowired
    private NumeroService numeroService;
    
    //Define o endpoint Get /api/numero que retorna
    @GetMapping("/numero")
    public int getNumero() {
        return numeroService.getNumeroAtual(); //retorna o número atual 
    }
}
