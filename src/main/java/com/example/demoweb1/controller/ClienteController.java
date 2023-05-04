/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoweb1.controller;
import com.example.demoweb1.model.Cliente;
import com.example.demoweb1.service.ClienteService;
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
@RequestMapping("/cliente") //RequestMapping completa el endpoint
public class ClienteController {
    @Autowired
    private ClienteService clienteservice;
    
    //Peticiones GET
    @GetMapping(value="/lista") //se agrega al endpoint
    public List<Cliente> consultartodos(){
        return clienteservice.findAll();
    }
    @GetMapping(value="/lista/id/{id}")
    public Cliente consultarporId(@PathVariable Integer id){
        return clienteservice.findById(id);
    }
    //GET para consultar por nombre
    @GetMapping(value="/lista/nombre/{nombre}")
    public List<Cliente> consultanombre(@PathVariable String nombre){
        return clienteservice.findByNombre(nombre);
    }
    
    //Petición POST para insertar
    @PostMapping(value="/guardar")
    public ResponseEntity<Cliente> agregar(@RequestBody Cliente cliente){
        Cliente cli;
        cli = clienteservice.save(cliente); //se guarda el cliente
        return new ResponseEntity<> (cli,HttpStatus.OK);
    }
    
    //Petición PUT para actualizar
    @PutMapping(value="/{id}")
    public ResponseEntity<Cliente> actualizar(@RequestBody Cliente cliente){
        //Se busca primero el cliente
        Cliente cli = clienteservice.findById(cliente.getIdcliente());
        if (cli!=null) {
            //Encontró al cliente con el id
            cli.setNombre(cliente.getNombre());
            cli.setCorreo(cliente.getCorreo());
            cli.setDireccion(cliente.getDireccion());
            clienteservice.save(cli);
        } else {
            //No lo encontró
            return new ResponseEntity<> (cli,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<> (cli,HttpStatus.OK);
    }
    
    //Petición DELETE para borrar
    @DeleteMapping(value="eliminar/{id}")
    public ResponseEntity<Cliente> borrar(@PathVariable Integer id){
        //Buscamos por id
        Cliente cli = clienteservice.findById(id);
        if (cli!=null) {
            //Existe el cliente
            clienteservice.delete(id);
        } else {
            return new ResponseEntity<> (cli,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<> (cli,HttpStatus.OK);
    }
    
}
