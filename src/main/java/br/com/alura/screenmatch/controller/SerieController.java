package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.dto.EpisodioDTO;
import br.com.alura.screenmatch.dto.SerieDTO;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List<SerieDTO> obterTop05Series() {
        return service.obterTop05Series();
    }

    @GetMapping("/lancamentos")
    public List<SerieDTO> obterLancamentos() {
        return service.obterLancamentos();
    }

    @GetMapping("/{id}")//anotação para entender que vem da url
    public SerieDTO obterPorId(@PathVariable Long id) {
        return service.obterSeriePorId(id);
    }

    @GetMapping("/{id}/temporadas/todas")//
    public List<EpisodioDTO> obterTodasAsTemporadas(@PathVariable Long id) {
        return service.obterTodasAsTemporadas(id);
    }

    @GetMapping("/{id}/temporadas/{numero}")
    public List<EpisodioDTO> obterTemporadasPorNumero(@PathVariable Long id, @PathVariable Long numero) {
        return service.obterTemporadasPorNumero(id, numero);

    }

    @GetMapping("/categoria/{categoria}")
    public List<SerieDTO> obterSeriesPorCategoria(@PathVariable String categoria) {
        return service.obterSeriesPorCategoria(categoria);

    }

}

