package com.example.demo.Controller;

import com.example.demo.Model.ExperienciaProfissional;
import com.example.demo.Service.ExperienciaProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/experiencias-profissionais")
public class ExperienciaProfissionalController {

    private final ExperienciaProfissionalService experienciaProfissionalService;

    @Autowired
    public ExperienciaProfissionalController(ExperienciaProfissionalService experienciaProfissionalService) {
        this.experienciaProfissionalService = experienciaProfissionalService;
    }

    @PostMapping
    public ExperienciaProfissional criarExperienciaProfissional(@RequestBody ExperienciaProfissional experienciaProfissional) {
        return experienciaProfissionalService.createExperienciaProfissional(experienciaProfissional);
    }

    @GetMapping
    public List<ExperienciaProfissional> getAllExperienciasProfissionais() {
        return experienciaProfissionalService.getAllExperienciasProfissionais();
    }

    @GetMapping("/{id}")
    public Optional<ExperienciaProfissional> getExperienciaProfissionalById(@PathVariable UUID id) {
        return experienciaProfissionalService.getExperienciaProfissionalById(id);
    }

    @PutMapping("/{id}")
    public Optional<ExperienciaProfissional> atualizarExperienciaProfissional(@PathVariable UUID id, @RequestBody ExperienciaProfissional experienciaProfissional) {
        return experienciaProfissionalService.updateExperienciaProfissional(id, experienciaProfissional);
    }

    @DeleteMapping("/{id}")
    public void deletarExperienciaProfissional(@PathVariable UUID id) {
        experienciaProfissionalService.deletarExperienciaProfissional(id);
    }
}
