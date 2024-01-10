package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.dto.SerieDTO;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//entende que é um controller
@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService service;

    //usado acima do método sobre a requisição que quero obter - seria como route
    @GetMapping("")

    public List<SerieDTO> obterSeries() {
        return service.obterTodasAsSeries();
    }
    @GetMapping("/top5")
    public List<SerieDTO> obterTop05Series(){
        return service.obterTop05Series();
   }



}

