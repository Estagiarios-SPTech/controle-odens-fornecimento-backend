package com.stefanini.controle_de_ofs.models;

import jakarta.persistence.*;

@Entity
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


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public User getRt() {
        return rt;
    }

    public void setRt(User rt) {
        this.rt = rt;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
