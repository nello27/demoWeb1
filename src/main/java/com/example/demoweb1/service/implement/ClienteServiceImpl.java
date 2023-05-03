/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoweb1.service.implement;

import com.example.demoweb1.dao.ClienteDao;
import com.example.demoweb1.model.Cliente;
import com.example.demoweb1.service.ClienteService;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macbookpro
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clientedao;

    //son 4 metodos, habrán 4 implementaciones
    @Override
    @Transactional
    public Cliente save(Cliente cliente) {

        if (cliente.getIdcliente() == null) {
            return clientedao.save(cliente);
        } else {
            Optional<Cliente> c = clientedao.findById(cliente.getIdcliente());
            if (c.isEmpty()) {
                return clientedao.save(cliente);
            } else {
                return cliente;
            }

        }
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        clientedao.deleteById(id);
    }

    @Override
    public Cliente findById(Integer id) {
        return clientedao.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> findAll() {

        return (List<Cliente>) clientedao.findAll();
    }

    @Override
    public List<Cliente> findByNombre(String nombre) {
        return (List<Cliente>) clientedao.buscarpornombre(nombre);
    }
}
