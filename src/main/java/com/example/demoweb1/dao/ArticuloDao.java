/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.demoweb1.dao;

import com.example.demoweb1.model.Articulo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author macbookpro
 */
@Repository
public interface ArticuloDao extends CrudRepository<Articulo, Integer> {
    
}
