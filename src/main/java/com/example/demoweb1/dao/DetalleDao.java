/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.demoweb1.dao;

import com.example.demoweb1.model.Detalle;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author macbookpro
 */
public interface DetalleDao extends CrudRepository<Detalle, Integer> {
    
}
