/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoweb1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author macbookpro
 */
@Entity
@Table(name = "detalle")
public class Detalle {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "factura_idfactura")
    private Integer factura_idfactura;
    @Column(name = "articulos_idarticulos")
    private Integer articulos_idarticulos;
    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "factura_idfactura", insertable = false, updatable = false)
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "articulos_idarticulos", insertable = false, updatable = false)
    private Articulo articulo;


    public Integer getFactura_idfactura() {
        return factura_idfactura;
    }

    public void setFactura_idfactura(Integer factura_idfactura) {
        this.factura_idfactura = factura_idfactura;
    }

    public Integer getArticulos_idarticulos() {
        return articulos_idarticulos;
    }

    public void setArticulos_idarticulos(Integer articulos_idarticulos) {
        this.articulos_idarticulos = articulos_idarticulos;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


    public Integer getIddetalle() {
        
        return factura_idfactura;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    
    
}
