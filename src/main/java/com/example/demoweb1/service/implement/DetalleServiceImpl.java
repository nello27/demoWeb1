/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoweb1.service.implement;

import com.example.demoweb1.dao.DetalleDao;
import com.example.demoweb1.model.Detalle;
import com.example.demoweb1.service.DetalleService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macbookpro
 */
@Service
public class DetalleServiceImpl implements DetalleService{

    @Autowired
    private DetalleDao detalledao;

    //son 4 metodos, habrán 4 implementaciones
    @Override
    @Transactional
    public Detalle save(Detalle detalle) {
        return detalledao.save(detalle);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        detalledao.deleteById(id);
    }

    @Override
    public Detalle findById(Integer id) {
        return detalledao.findById(id).orElse(null);
    }

    @Override
    public List<Detalle> findAll() {

        return (List<Detalle>) detalledao.findAll();
    }
}
