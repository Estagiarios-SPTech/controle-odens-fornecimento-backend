package com.stefanini.controle_de_ofs.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "userRoleEmployee", referencedColumnName = "id")
    private User employee;

    @ManyToOne
    @JoinColumn(name = "userRoleRT", referencedColumnName = "id")
    private User rt;

    @ManyToOne
    @JoinColumn(name = "userRoleManager", referencedColumnName = "id")
    private User manager;

    private String status;
}
