package com.empresaSpring.Services;

import com.empresaSpring.exception.DatosNoCorrectosException;
import com.empresaSpring.models.Empleado;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EmpleadoService {

    private final Map<String, Empleado> empleados = new ConcurrentHashMap<>();

    public EmpleadoService() {
        // Constructor vacío porque Spring lo pide
    }

    @PostConstruct
    public void init() {
        // CARGA DE DATOS DE PRUEBA. no se utiliza la base de datos
        try {
            empleados.put("12345678A", new Empleado("Ana García", "12345678A", 'F', 3, 7));
            empleados.put("87654321B", new Empleado("Luis Martínez", "87654321B", 'M', 5, 3));
            empleados.put("00000000X", new Empleado("Carlos Ruiz", "00000000X", 'M', 5, 5));
        } catch (DatosNoCorrectosException e) {
        }
    }

    // Devuelve todos los empleados
    public List<Empleado> findAll() {
        return new ArrayList<>(empleados.values());
    }

    // Busca un empleado por su DNI
    public Empleado findById(String dni) {
        return empleados.get(dni);
    }

    // Guarda o actualiza un empleado (clave = DNI)
    public Empleado save(Empleado empleado) {
        empleados.put(empleado.getDni(), empleado);
        return empleado;
    }

    // Elimina un empleado por su DNI
    public void deleteById(String dni) {
        empleados.remove(dni);
    }
}