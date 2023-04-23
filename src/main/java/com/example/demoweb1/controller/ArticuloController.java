/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoweb1.controller;

import com.example.demoweb1.model.Articulo;
import com.example.demoweb1.service.ArticuloService;
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
@RequestMapping("/articulo") //RequestMapping completa el endpoint
public class ArticuloController {

    @Autowired
    private ArticuloService articuloservice;

    //Peticiones GET
    @GetMapping(value = "/lista") //se agrega al endpoint
    public List<Articulo> consultartodosArticulos() {
        return articuloservice.findAll();
    }

    @GetMapping(value = "/lista/id/{id}")
    public Articulo consultarporId(@PathVariable Integer id) {
        return articuloservice.findById(id);
    }

    //GET para consultar por descripcion
    @GetMapping(value = "/lista/descripcion/{descripcion}")
    public List<Articulo> buscarPorDescripcion(@PathVariable String descripcion) {
        return articuloservice.findByDescripcion(descripcion);
    }

    //GET para consultar por descripcion
    @GetMapping(value = "/lista/descripcion/general/{idcliente}")
    public List<Articulo> BusquedaGeneral(@PathVariable Integer idcliente) {
        return (List<Articulo>) articuloservice.findByBusquedaGeneral(idcliente);
    }

    //Petición POST para insertar
    @PostMapping(value = "/")
    public ResponseEntity<Articulo> agregar(@RequestBody Articulo articulo) {
        Articulo art;
        art = articuloservice.save(articulo); //se guarda el articulo
        return new ResponseEntity<>(art, HttpStatus.OK);
    }

    //Petición PUT para actualizar
    @PutMapping(value = "/{id}")
    public ResponseEntity<Articulo> actualizar(@RequestBody Articulo articulo) {
        //Se busca primero el articulo
        Articulo art = articuloservice.findById(articulo.getIdarticulos());
        if (art != null) {
            //Encontró al articulo con el id
            art.setDescripcion(articulo.getDescripcion());
            art.setValor(articulo.getValor());
            articuloservice.save(art);
        } else {
            //No lo encontró
            return new ResponseEntity<>(art, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(art, HttpStatus.OK);
    }

    //Petición DELETE para borrar
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Articulo> borrar(@PathVariable Integer id) {
        //Buscamos por id
        Articulo cli = articuloservice.findById(id);
        if (cli != null) {
            //Existe Articulo
            articuloservice.delete(id);
        } else {
            return new ResponseEntity<>(cli, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(cli, HttpStatus.OK);
    }
}
