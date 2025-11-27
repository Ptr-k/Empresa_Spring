package com.empresaSpring.Controllers;

import com.empresaSpring.Services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@ComponentScan
public class EmpleadoController {
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private EmpleadoService empleadoService;

    // mapping para listar empleados
    @GetMapping
    public String listarEmpleados(Model model) {
        model.addAttribute("empleados", empleadoService.findAll());
        return "views/listarEmpleados.jsp"; // se busca views/empleados/listarEmpleados.jsp
    }
}
