package com.stefanini.controle_de_ofs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class OrdemFornecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    //private Integer collaborator_id;
    private String description;
    private String status;
    private LocalDate created_at;
    private LocalDate updated_at;
}
