/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoweb1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
    @JoinColumns({
        @JoinColumn(name="idfactura", referencedColumnName="factura_idfactura"),
        @JoinColumn(name="idarticulo", referencedColumnName="articulos_idarticulos")
    })
    @JsonIgnoreProperties("detalle")
    private Detalle detalle;

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

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    public Integer getIddetalle() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}