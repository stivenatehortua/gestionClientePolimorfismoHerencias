package com.tcs.taller.clases;

public class Empresas extends Clientes {

    private String tipDocumento;
    private String documento;
    private String representante;

    public Empresas(String nombre, String telefono, String direccion, String tipoDoc,
                    String documento, String representante) {
        super.setNombre(nombre);
        super.setTelefono(telefono);
        super.setDireccion(direccion);
        this.tipDocumento = tipoDoc;
        this.documento = documento;
        this.representante = representante;
    }

    public String getTipDocumento() {
        return tipDocumento;
    }

    public void setTipDocumento(String tipDocumento) {
        this.tipDocumento = tipDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    @Override
    public String toString() {
        return super.toString() + "Empresas{" +
                "tipDoc='" + getTipDocumento() + '\'' +
                ", documento='" + getDocumento() + '\'' +
                ", representante='" + getRepresentante() + '\'' +
                '}';
    }
}