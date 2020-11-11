package com.tcs.taller.clases;

public class Personas extends Clientes {

    private String cedula;
    private String celular;

    public Personas(String nombre, String telefono, String direccion, String cedula, String celular) {
        super.setNombre(nombre);
        super.setTelefono(telefono);
        super.setDireccion(direccion);
        this.cedula = cedula;
        this.celular = celular;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Personas{" +
                "cedula='" + getCedula() + '\'' +
                ", celular='" + getCelular() + '\'' +
                '}';
    }
}