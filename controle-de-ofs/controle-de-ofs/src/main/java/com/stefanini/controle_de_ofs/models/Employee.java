package com.stefanini.controle_de_ofs.models;

import jakarta.persistence.*;

@Entity
@Table
public class Employee {
    @Id
    @OneToOne
    @JoinColumn(name = "userRoleEmployee", referencedColumnName = "id")
    private User employee;

    @OneToMany
    @JoinColumn(name = "userRoleRT", referencedColumnName = "id")
    private User employeeRT;

    @OneToMany
    @JoinColumn(name = "userRoleManager", referencedColumnName = "id")
    private User employeeManager;

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public User getEmployeeRT() {
        return employeeRT;
    }

    public void setEmployeeRT(User employeeRT) {
        this.employeeRT = employeeRT;
    }

    public User getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(User employeeManager) {
        this.employeeManager = employeeManager;
    }
}
