package com.example.jhonfredy.foodyeah.Models;

/**
 * Created by jhonfredy on 23/05/2015.
 */
public class Comida {
    String nombre;
    String descripcion;
    String restaurantes;
    String imgurl;


    String ingredientes;
    String preparacion;
    String id;

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }


    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getRestaurantes() {
        return restaurantes;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setRestaurantes(String restaurantes) {
        this.restaurantes = restaurantes;
    }
    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

}
