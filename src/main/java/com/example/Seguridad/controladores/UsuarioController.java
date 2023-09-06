package com.example.Seguridad.controladores;

import com.example.Seguridad.entidades.Usuario;
import com.example.Seguridad.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }




    //READ
    @GetMapping("/usuarios")
    public String usuarios(Model model){
        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);

        return "usuario/usuarios";

    }

    ////// CREAR
    @GetMapping("/usuario/form")
    public String form(Model model){
        model.addAttribute("usuario", new Usuario());
        return "/usuario/form";
    }

    @PostMapping("/usuario/form")
    public String crear(Usuario usuario){
        Usuario usuario1 = new Usuario();

        usuario1.setId( usuario.getId() );
        usuario1.setUsername( usuario.getUsername() );
        usuario1.setRol( usuario.getRol() );
        usuario1.setPass( bCryptPasswordEncoder().encode(usuario.getPass()));

        usuarioRepository.save(usuario1);
        return "redirect:/usuarios";
    }

}
