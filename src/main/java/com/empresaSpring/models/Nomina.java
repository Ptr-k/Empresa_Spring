package com.empresaSpring.models;

import jakarta.persistence.*;

@Entity
@Table(name = "nominas")
public class Nomina {
    private static  final int SUELDO_BASE[] = {50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000, 230000};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sueldo")
    public int sueldo(Empleado empleado) {
        int sueldo;
        sueldo = SUELDO_BASE[empleado.getCategoria() - 1] + 5000*empleado.anyos;
        return sueldo;
    }

    @OneToOne
    @JoinColumn(name = "empleado", nullable = false, foreignKey = @ForeignKey(name = "fk_empleado_nomina"))
    private Empleado Empleado;
}