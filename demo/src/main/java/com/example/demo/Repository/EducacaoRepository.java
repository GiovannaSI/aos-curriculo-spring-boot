package com.example.demo.Repository;

import com.example.demo.Model.Educacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EducacaoRepository extends JpaRepository<Educacao, UUID> {
}
