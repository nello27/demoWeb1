/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoweb1.service.implement;
import com.example.demoweb1.dao.ClienteDao;
import com.example.demoweb1.model.Cliente;
import com.example.demoweb1.service.ClienteService;
import jakarta.transaction.Transactional;
import java.util.List;
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
        return clientedao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        clientedao.deleteById(id);
    }
    
    @Override
    public Cliente findById(Integer id){
        return clientedao.findById(id).orElse(null);
    }
    
    @Override
    public List<Cliente> findAll(){
        
        return (List<Cliente>) clientedao.findAll();
    }
    
        public List<Cliente> findByNombre(String nombre){
            return(List<Cliente>)clientedao.buscarpornombre(nombre);
        }
}
