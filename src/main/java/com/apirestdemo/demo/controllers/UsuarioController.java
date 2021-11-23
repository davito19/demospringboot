package com.apirestdemo.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.apirestdemo.demo.models.UsuarioModel;
import com.apirestdemo.demo.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuario(){
        return usuarioService.getUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.saveUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> getUserById(@PathVariable("id") Long id) {
        return this.usuarioService.getById(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> getUserByPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.getByPrioridad(prioridad);
    }

    @GetMapping("/query1")
    public ArrayList<UsuarioModel> getUserByEmail(@RequestParam("email") String email){
        return this.usuarioService.getByEmail(email);
    }


    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.usuarioService.deleteUsuario(id);
        if(ok) return "Se eliminó el usuario con id" + id;
        return "No pudo eliminar el usuario con id" + id;
    }
}
