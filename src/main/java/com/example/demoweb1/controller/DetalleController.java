/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoweb1.controller;

import com.example.demoweb1.model.Detalle;
import com.example.demoweb1.service.DetalleService;
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
@RequestMapping("/detalle") //RequestMapping completa el endpoint
public class DetalleController {

    @Autowired
    private DetalleService detalleservice;

    //Peticiones GET
    @GetMapping(value = "/lista") //se agrega al endpoint
    public List<Detalle> consultartodos() {
        return detalleservice.findAll();
    }

    @GetMapping(value = "/lista/{id}")
    public Detalle consultarporId(@PathVariable Integer id) {
        return detalleservice.findById(id);
    }

    //Petición POST para insertar
    @PostMapping(value = "/")
    public ResponseEntity<Detalle> agregar(@RequestBody Detalle detalle) {
        Detalle det;
        det = detalleservice.save(detalle); //se guarda la factura
        return new ResponseEntity<>(det, HttpStatus.OK);
    }

    //Petición PUT para actualizar
    @PutMapping(value = "/{id}")
    public ResponseEntity<Detalle> actualizar(@RequestBody Detalle detalle) {
        //Se busca primero el cliente
        Detalle det = detalleservice.findById(detalle.getIddetalle());
        if (det != null) {
            //Encontró al detalle con el id
            det.setCantidad(detalle.getCantidad());
            detalleservice.save(det);
        } else {
            //No lo encontró
            return new ResponseEntity<>(det, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(det, HttpStatus.OK);
    }

    //Petición DELETE para borrar
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Detalle> borrar(@PathVariable Integer id) {
        //Buscamos por id
        Detalle det = detalleservice.findById(id);
        if (det != null) {
            //Existe detalle
            detalleservice.delete(id);
        } else {
            return new ResponseEntity<>(det, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(det, HttpStatus.OK);
    }
}
