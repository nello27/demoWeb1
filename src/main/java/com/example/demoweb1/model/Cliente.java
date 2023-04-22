package com.example.demoweb1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author macbookpro
 */
/*@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idcliente")
    private Integer idcliente;
    @Column(name="nombre")
    private String nombre;
    @Column(name="direccion")
    private String direccion;
    @Column(name="correo")
    private String correo;*/
    
@Entity
@Table(name="cliente")
public class Cliente {
    //Atributos
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idcliente")
    private Integer idcliente;
    @Column(name="nombre")
    private String nombre;
    @Column(name="direccion")
    private String direccion;
    @Column(name="correo")
    private String correo;
    
    //Relación con facturas
    @OneToMany(mappedBy="cliente")
    @JsonIgnoreProperties("cliente")
    private List<Factura> facturas;

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoelectronico() {
        return correo;
    }

    public void setCorreoelectronico(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
    
}
