/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoweb1.controller;

import com.example.demoweb1.model.Factura;
import com.example.demoweb1.service.FacturaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author macbookpro
 */
@RestController
@CrossOrigin("*")  //acepte todas las peticiones entrantes
@RequestMapping("/factura") //RequestMapping completa el endpoint
public class FacturaController {

    @Autowired
    private FacturaService facturaservice;

    //Peticiones GET
    @GetMapping(value = "/lista") //se agrega al endpoint
    public List<Factura> consultartodos() {
        return facturaservice.findAll();
    }

    @GetMapping(value = "/lista/{id}")
    public Factura consultarporId(@PathVariable Integer id) {
        return facturaservice.findById(id);
    }

    //Petición POST para insertar
    @PostMapping(value = "/")
    public ResponseEntity<Factura> agregar(@RequestBody Factura factura) {
        Factura fac;
        fac = facturaservice.save(factura); //se guarda la factura
        return new ResponseEntity<>(fac, HttpStatus.OK);
    }

    //Petición PUT para actualizar
    @PutMapping(value = "/{id}")
    public ResponseEntity<Factura> actualizar(@RequestBody Factura factura) {
        //Se busca primero el cliente
        Factura fac = facturaservice.findById(factura.getIdfactura());
        if (fac != null) {
            //Encontró al factura con el id
            fac.setFecha(factura.getFecha());
            facturaservice.save(fac);
        } else {
            //No lo encontró
            return new ResponseEntity<>(fac, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(fac, HttpStatus.OK);
    }
    
        
    //Petición DELETE para borrar
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Factura> borrar(@PathVariable Integer id){
        //Buscamos por id
        Factura fac = facturaservice.findById(id);
        if (fac!=null) {
            //Existe factura
            facturaservice.delete(id);
        } else {
            return new ResponseEntity<> (fac,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<> (fac,HttpStatus.OK);
    }
}
