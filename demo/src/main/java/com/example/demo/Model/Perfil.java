package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefone;


    @OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ExperienciaProfissional> experiencias;

    @OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Educacao> educacoes;
}
