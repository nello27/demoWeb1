/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoweb1.service.implement;

import com.example.demoweb1.dao.ArticuloDao;
import com.example.demoweb1.model.Articulo;
import com.example.demoweb1.service.ArticuloService;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macbookpro
 */
@Service
public class ArticuloServiceImpl implements ArticuloService{

    @Autowired
    private ArticuloDao articulodao;

    //son 4 metodos, habrán 4 implementaciones
    @Override
    @Transactional
    public Articulo save(Articulo articulo) {
        return articulodao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        articulodao.deleteById(id);
    }

    @Override
    public Articulo findById(Integer id) {
        return articulodao.findById(id).orElse(null);
    }

    @Override
    public List<Articulo> findAll() {

        return (List<Articulo>) articulodao.findAll();
    }

    @Override
    public List<Articulo> findByDescripcion(String descripcion) {
        
        return(List<Articulo>)articulodao.buscarPorDescripcion(descripcion);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
