package com.example.demo.Service;

import com.example.demo.Model.Perfil;
import com.example.demo.Repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PerfilService {
    private final PerfilRepository perfilRepository;

    @Autowired
    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public Perfil createPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    public List<Perfil> encontrarPerfis() {
        return perfilRepository.findAll();
    }

    public Optional<Perfil> perfilId(UUID id) {
        return perfilRepository.findById(id);
    }

    public Optional<Perfil> atualizarPerfil(UUID id, Perfil atualizarPerfil) {
        return perfilRepository.findById(id)
                .map(perfil -> {
                    perfil.setNome((atualizarPerfil.getNome() == null) ? perfil.getNome() : atualizarPerfil.getNome());
                    perfil.setIdade((atualizarPerfil.getIdade() == null) ? perfil.getIdade() : atualizarPerfil.getIdade());
                    perfil.setEndereco((atualizarPerfil.getEndereco() == null) ? perfil.getEndereco() : atualizarPerfil.getEndereco());
                    perfil.setEmail((atualizarPerfil.getEmail() == null) ? perfil.getEmail() : atualizarPerfil.getEmail());
                    perfil.setTelefone((atualizarPerfil.getTelefone() == null) ? perfil.getTelefone() : atualizarPerfil.getTelefone());
                    perfil.setExperiencias((atualizarPerfil.getExperiencias() == null) ? perfil.getExperiencias() : atualizarPerfil.getExperiencias());
                    perfil.setEducacoes((atualizarPerfil.getEducacoes() == null) ? perfil.getEducacoes() : atualizarPerfil.getEducacoes());
                    return perfilRepository.save(perfil);
                });
    }

    public Boolean deletarPerfil(UUID id) {
        try {
            perfilRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

