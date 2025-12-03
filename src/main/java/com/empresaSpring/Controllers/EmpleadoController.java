package com.empresaSpring.Controllers;

import com.empresaSpring.Services.EmpleadoService;
import com.empresaSpring.models.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private EmpleadoService empleadoService;

    // Muestra la lista de empleados en una tabla
    @GetMapping
    public String listarEmpleados(Model model) {
        model.addAttribute("empleados", empleadoService.findAll());
        return "empleados/listar";
    }

    // Muestra el formulario de edición para un empleado por DNI
    @GetMapping("/editar/{dni}")
    public String mostrarFormularioEdicion(@PathVariable String dni, Model model) {
        model.addAttribute("empleado", empleadoService.findById(dni));
        return "empleados/editar";
    }

    // Procesa el formulario de edición y guarda los cambios
    @PostMapping("/editar")
    public String procesarEdicion(@ModelAttribute Empleado empleado) {
        empleadoService.save(empleado);
        return "redirect:/empleados";
    }
}