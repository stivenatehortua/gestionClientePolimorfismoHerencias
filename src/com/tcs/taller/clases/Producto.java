package com.tcs.taller.clases;

public class Producto {
    private String nombre;
    private String carateristicas;
    private String idProducto;
    private String condiciones;

    private static Integer secuencia = 0;

    public Producto(String nombre, String carateristicas, String condiciones) {
        this.idProducto = (secuencia++).toString();
        this.nombre = nombre;
        this.carateristicas = carateristicas;
        this.condiciones = condiciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarateristicas() {
        return carateristicas;
    }

    public void setCarateristicas(String carateristicas) {
        this.carateristicas = carateristicas;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + getNombre() + '\'' +
                ", carateristicas='" + getCarateristicas() + '\'' +
                ", idProducto='" + getIdProducto() + '\'' +
                ", condiciones='" + getCondiciones() + '\'' +
                '}';
    }
}