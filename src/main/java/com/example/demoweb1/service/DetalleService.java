/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.demoweb1.service;

import com.example.demoweb1.model.Detalle;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author macbookpro
 */
public interface DetalleService {

    public Detalle save(Detalle detalle);
    public void delete(Integer id);
    public Detalle findById(Integer id);
    public List<Detalle> findAll();

}
