package com.apirestdemo.demo.repositories;

import java.util.ArrayList;

import com.apirestdemo.demo.models.UsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
    public abstract ArrayList<UsuarioModel> findByemail(String email);
    public abstract ArrayList<UsuarioModel> findByname(String name);
}
