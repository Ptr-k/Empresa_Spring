package com.empresaSpring.models;

import jakarta.persistence.*;

@Entity
@Table(name = "nominas")
public class Nomina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sueldo")
    private int sueldo;

    @OneToOne
    @JoinColumn(name = "dni_empleado", referencedColumnName = "dni")
    private Empleado empleado;

    public Nomina() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}