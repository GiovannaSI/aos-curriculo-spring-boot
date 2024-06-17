package com.example.demo.Service;

import com.example.demo.Model.Educacao;
import com.example.demo.Repository.EducacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EducacaoService {

    private final EducacaoRepository educacaoRepository;

    @Autowired
    public EducacaoService(EducacaoRepository perfilRepository) {
        this.educacaoRepository = perfilRepository;
    }

    public Educacao createEducacao(Educacao educacao) {
        return educacaoRepository.save(educacao);
    }

    public List<Educacao> encontrarEducacao() {
        return educacaoRepository.findAll();
    }

    public Optional<Educacao> educacaoId(UUID id) {
        return educacaoRepository.findById(id);
    }

    public Optional<Educacao> updateEducacao(UUID id, Educacao educacaoDetails) {
        return educacaoRepository.findById(id)
                .map(educacao -> {
                    educacao.setInstituicao((educacaoDetails.getInstituicao() == null) ? educacao.getInstituicao() : educacaoDetails.getInstituicao());
                    educacao.setCurso((educacaoDetails.getCurso() == null) ? educacao.getCurso() : educacaoDetails.getCurso());
                    educacao.setPeriodoInicio((educacaoDetails.getPeriodoInicio() == null) ? educacao.getPeriodoInicio() : educacaoDetails.getPeriodoInicio());
                    educacao.setPeriodoFim((educacaoDetails.getPeriodoFim() == null) ? educacao.getPeriodoFim() : educacaoDetails.getPeriodoFim());
                    return educacaoRepository.save(educacao);
                });
    }

    public Boolean deletarEducacao(UUID id) {
        try {
            educacaoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

