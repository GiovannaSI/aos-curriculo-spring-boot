package com.example.demo.Controller;

import com.example.demo.Model.Educacao;
import com.example.demo.Service.EducacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/educacoes")
public class EducacaoController {

    private final EducacaoService educacaoService;

    @Autowired
    public EducacaoController(EducacaoService educacaoService) {
        this.educacaoService = educacaoService;
    }

    @PostMapping
    public Educacao criarEducacao(@RequestBody Educacao educacao) {
        return educacaoService.createEducacao(educacao);
    }

    @GetMapping
    public List<Educacao> encontrarEducacoes() {
        return educacaoService.encontrarEducacao();
    }

    @GetMapping("/{id}")
    public Optional<Educacao> encontrarEducacaoPorId(@PathVariable UUID id) {
        return educacaoService.educacaoId(id);
    }

    @PutMapping("/{id}")
    public Optional<Educacao> atualizarEducacao(@PathVariable UUID id, @RequestBody Educacao educacao) {
        return educacaoService.updateEducacao(id, educacao);
    }

    @DeleteMapping("/{id}")
    public void deletarEducacao(@PathVariable UUID id) {
        educacaoService.deletarEducacao(id);
    }
}

