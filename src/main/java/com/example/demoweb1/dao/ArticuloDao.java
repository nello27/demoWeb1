/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.demoweb1.dao;

import com.example.demoweb1.model.Articulo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author macbookpro
 */
@Repository
public interface ArticuloDao extends CrudRepository<Articulo, Integer> {

    //Agregar Query nativo
    @Query(value = "Select * from articulos where descripcion=?", nativeQuery = true)
    public List<Articulo> buscarPorDescripcion(String descripcion);

    @Query(value = "SELECT articulos.*, detalle.*, factura.*, cliente.* FROM articulos INNER JOIN detalle ON articulos.idarticulos = detalle.articulos_idarticulos INNER JOIN factura ON detalle.factura_idfactura = factura.idfactura INNER JOIN cliente ON factura.cliente_idcliente = cliente.idcliente WHERE cliente.idcliente = :idcliente", nativeQuery = true)
    public List<Articulo> BusquedaGeneral(@Param("idcliente") Integer idcliente);
}
