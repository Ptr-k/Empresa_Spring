package com.empresaSpring.models;

import com.empresaSpring.exception.DatosNoCorrectosException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase que representa a un empleado.
 * <p>Contiene todos los constructores, getters
 * y setters correspondientes.</p>
 */
@Entity
@Table(name = "empleados")
public class Empleado {

    @Column(name = "nombre")
    public String nombre;

    @Id
    @Column(name = "dni")
    public String dni;

    @Column(name = "sexo")
    public char sexo;

    @Column(name = "categoria")
    private int categoria;

    @Column(name = "anyos")
    public int anyos;

    public Empleado() {
        super();
    }

    public Empleado(String nombre, String dni, char sexo, int categoria, int anyos) throws DatosNoCorrectosException {
        this.nombre = nombre;
        this.dni = dni;
        this.sexo = sexo;
        if (categoria < 1 || categoria > 10 || anyos < 0) {
            throw new DatosNoCorrectosException("Datos no correctos.");
        } else {
            this.categoria = categoria;
            this.anyos = anyos;
        }
    }

    public Empleado(String nombre, String dni, char sexo) {
        this.nombre = nombre;
        this.dni = dni;
        this.sexo = sexo;

        this.categoria = 1;
        this.anyos = 0;
    }

    public void setCategoria(int categoria) throws DatosNoCorrectosException {

        if (categoria <= 10 && categoria >= 1) {
            this.categoria = categoria;
        } else {
            throw new DatosNoCorrectosException("Datos no correctos.");
        }
    }

    public int getCategoria() {
        return categoria;
    }

    public int getAnyos() {
        return anyos;
    }

    public void setAnyos(int anyos) {
        this.anyos = anyos;
    }

    public void setSexo() {
        this.sexo = sexo;
    }

    public void incrAnyo() {
        anyos = +1;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void imprime() {
        System.out.println("Nombre:" + nombre + "\nDNI: " + dni + "\nSexo: " + sexo + "\nCategoria: " + categoria + "\nAños trabajados: " + anyos);
    }
}