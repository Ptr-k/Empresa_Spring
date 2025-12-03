package com.empresaSpring.Controllers;

import com.empresaSpring.Services.EmpleadoService;
import com.empresaSpring.models.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class NominasController {

    @Autowired
    private EmpleadoService empleadoService;

    // Muestra una tabla con el salario calculado para cada empleado
    @GetMapping("/nomina/salarios")
    public String listarSalarios(Model model) {
        List<Empleado> empleados = empleadoService.findAll();
        Map<String, Integer> salarios = new HashMap<>();
        for (Empleado e : empleados) {
            salarios.put(e.getDni(), calcularSueldo(e));
        }
        model.addAttribute("empleados", empleados);
        model.addAttribute("salarios", salarios);
        return "empleados/listarNominas";
    }

    // Calcula el sueldo según la categoría y los años trabajados
    private int calcularSueldo(Empleado empleado) {
        int[] SUELDO_BASE = {50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000, 230000};
        int categoriaIndex = Math.max(1, Math.min(empleado.getCategoria(), 10)) - 1;
        return SUELDO_BASE[categoriaIndex] + 5000 * empleado.getAnyos();
    }
}
