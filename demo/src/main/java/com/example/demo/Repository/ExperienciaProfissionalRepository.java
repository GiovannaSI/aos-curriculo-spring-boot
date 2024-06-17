package com.example.demo.Repository;

import com.example.demo.Model.ExperienciaProfissional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExperienciaProfissionalRepository extends JpaRepository<ExperienciaProfissional, UUID> {
}
