package com.empresaSpring.Services;

import com.empresaSpring.exception.DatosNoCorrectosException;
import com.empresaSpring.models.Empleado;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EmpleadoService {

    private final Map<String, Empleado> empleados = new ConcurrentHashMap<>();

    public EmpleadoService() throws DatosNoCorrectosException {
        empleados.put(String.valueOf(1L), new Empleado("Ana García", "12345678A", 'F', 3, 7));
        empleados.put(String.valueOf(2L), new Empleado("Luis Martínez", "87654321B", 'M', 5, 3));
        empleados.put(String.valueOf(3L), new Empleado("Carlos Ruiz", "00000000X", 'M', 5, 5));
    }

    public List<Empleado> findAll() {
        return new ArrayList<>(empleados.values());
    }

    public Empleado findById(Long id) {
        return empleados.get(id);
    }

    public Empleado save(Empleado empleado) {
        empleados.put(empleado.getDni(), empleado);
        return empleado;
    }

    public void deleteById(Long id) {
        empleados.remove(id);
    }
}