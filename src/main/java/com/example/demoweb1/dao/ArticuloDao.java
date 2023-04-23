/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.demoweb1.dao;

import com.example.demoweb1.model.Articulo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author macbookpro
 */
@Repository
public interface ArticuloDao extends CrudRepository<Articulo, Integer> {

    //Agregar Query nativo
    @Query(value = "Select * from articulos where descripcion=?", nativeQuery = true)
    public List<Articulo> buscarPorDescripcion(String descripcion);
}
