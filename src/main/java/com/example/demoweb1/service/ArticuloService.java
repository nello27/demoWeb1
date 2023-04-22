/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.demoweb1.service;

import com.example.demoweb1.model.Articulo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author macbookpro
 */
public interface ArticuloService {

    public Articulo save(Articulo articulo);
    public void delete(Integer id);
    public Articulo findById(Integer id);
    public List<Articulo> findAll();

}