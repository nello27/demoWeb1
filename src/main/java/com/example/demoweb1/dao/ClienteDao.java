/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.demoweb1.dao;

import com.example.demoweb1.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author macbookpro
 */
@Repository
public interface ClienteDao extends CrudRepository<Cliente, Integer> {
    
    //Agregar Query nativo
    @Query(value="Select * from cliente where nombre=?",nativeQuery=true)
    public List<Cliente> buscarpornombre(String nombre);
    
}
