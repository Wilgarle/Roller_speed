package com.roller_speed_academy.v1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")

public class UsuariosController {
    @RequestMapping("/listar")
    public String listarUsuarios() {
        return "/usuarios/listar";
    }
}
