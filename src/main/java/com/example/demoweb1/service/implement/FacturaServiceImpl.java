/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoweb1.service.implement;
import com.example.demoweb1.dao.FacturaDao;
import com.example.demoweb1.model.Factura;
import com.example.demoweb1.service.FacturaService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macbookpro
 */
@Service
public class FacturaServiceImpl implements FacturaService{

    @Autowired
    private FacturaDao facturadao;

    //son 4 metodos, habrán 4 implementaciones
    @Override
    @Transactional
    public Factura save(Factura factura) {
        return facturadao.save(factura);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        facturadao.deleteById(id);
    }

    @Override
    public Factura findById(Integer id) {
        return facturadao.findById(id).orElse(null);
    }

    @Override
    public List<Factura> findAll() {

        return (List<Factura>) facturadao.findAll();
    }
}
