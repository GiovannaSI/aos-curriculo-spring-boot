package com.example.demo.Repository;

import com.example.demo.Model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PerfilRepository extends JpaRepository<Perfil, UUID>{
}
