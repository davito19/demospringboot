package com.apirestdemo.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.apirestdemo.demo.models.UsuarioModel;
import com.apirestdemo.demo.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> getUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel saveUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> getById(Long id){
        return usuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModel> getByPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public ArrayList<UsuarioModel> getByEmail(String email){
        return usuarioRepository.findByemail(email);
    }

    public boolean deleteUsuario(Long id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
