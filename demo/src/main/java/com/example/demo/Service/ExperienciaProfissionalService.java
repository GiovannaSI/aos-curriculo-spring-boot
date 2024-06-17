package com.example.demo.Service;

import com.example.demo.Model.ExperienciaProfissional;
import com.example.demo.Repository.ExperienciaProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExperienciaProfissionalService {

    private final ExperienciaProfissionalRepository experienciaProfissionalRepository;

    @Autowired
    public ExperienciaProfissionalService(ExperienciaProfissionalRepository experienciaProfissionalRepository) {
        this.experienciaProfissionalRepository = experienciaProfissionalRepository;
    }

    public ExperienciaProfissional createExperienciaProfissional(ExperienciaProfissional experienciaProfissional) {
        return experienciaProfissionalRepository.save(experienciaProfissional);
    }

    public List<ExperienciaProfissional> getAllExperienciasProfissionais() {
        return experienciaProfissionalRepository.findAll();
    }

    public Optional<ExperienciaProfissional> getExperienciaProfissionalById(UUID id) {
        return experienciaProfissionalRepository.findById(id);
    }

    public Optional<ExperienciaProfissional> updateExperienciaProfissional(UUID id, ExperienciaProfissional experienciaProfissionalDetails) {
        return experienciaProfissionalRepository.findById(id)
                .map(experienciaProfissional -> {
                    experienciaProfissional.setCargo((experienciaProfissionalDetails.getCargo() == null) ? experienciaProfissional.getCargo() : experienciaProfissionalDetails.getCargo());
                    experienciaProfissional.setEmpresa((experienciaProfissionalDetails.getEmpresa() == null) ? experienciaProfissional.getEmpresa() : experienciaProfissionalDetails.getEmpresa());
                    experienciaProfissional.setPeriodoInicio((experienciaProfissionalDetails.getPeriodoInicio() == null) ? experienciaProfissional.getPeriodoInicio() : experienciaProfissionalDetails.getPeriodoInicio());
                    experienciaProfissional.setPeriodoFim((experienciaProfissionalDetails.getPeriodoFim() == null) ? experienciaProfissional.getPeriodoFim() : experienciaProfissionalDetails.getPeriodoFim());
                    return experienciaProfissionalRepository.save(experienciaProfissional);
                });
    }

    public Boolean deletarExperienciaProfissional(UUID id) {
        try {
            experienciaProfissionalRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

