/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.demoweb1.service;

import com.example.demoweb1.model.Cliente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author macbookpro
 */
public interface ClienteService{
    
        public Cliente save(Cliente cliente);
        public void delete (Integer id);
        public Cliente findById(Integer id);
        public List<Cliente> findAll();
        public List<Cliente> findByNombre(String nombre);
}
