package com.example.demo.Controller;

import com.example.demo.Model.Perfil;
import com.example.demo.Model.ExperienciaProfissional;
import com.example.demo.Model.Educacao;
import com.example.demo.Service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/perfis")
public class PerfilController {
    private final PerfilService perfilService;

    @Autowired
    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @PostMapping
    public Perfil criarPerfil(@RequestBody Perfil perfil) {
        for (ExperienciaProfissional experiencia : perfil.getExperiencias()) {
            experiencia.setPerfil(perfil);
        }
        for (Educacao educacao : perfil.getEducacoes()) {
            educacao.setPerfil(perfil);
        }
        return perfilService.createPerfil(perfil);
    }

    @GetMapping
    public List<Perfil> getPerfis() {
        return perfilService.encontrarPerfis();
    }

    @GetMapping("/{id}")
    public Optional<Perfil> getPerfil(@PathVariable UUID id) {
        return perfilService.perfilId(id);
    }

    @PutMapping("/{id}")
    public Optional<Perfil> atualizarPerfil(@PathVariable UUID id, @RequestBody Perfil perfil) {
        return perfilService.atualizarPerfil(id, perfil);
    }

    @DeleteMapping("/{id}")
    public boolean deletarPerfil(@PathVariable UUID id) {
        return perfilService.deletarPerfil(id);
    }
}

