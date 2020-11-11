package com.tcs.taller.clases;

import java.util.ArrayList;
import java.util.List;

public class Clientes {

    private String nombre;
    private String telefono;
    private String direccion;
    private List<Producto> productos = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void addProductos(Producto productos){
        this.productos.add(productos);
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "nombre='" + getNombre() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", productos=" + getProductos().toString() +
                '}';
    }
}