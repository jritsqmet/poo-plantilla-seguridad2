package com.example.Seguridad.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaController {
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/admin/gestion")
    public String admin(){
        return "administrador/admin";
    }

    @GetMapping("/user/usuarios")
    public String user(){
        return "users/users";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/privada")
    public String pagina1(){
        return "privadas/privada";
    }
}
