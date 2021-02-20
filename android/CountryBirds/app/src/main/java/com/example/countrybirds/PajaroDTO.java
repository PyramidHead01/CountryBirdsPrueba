package com.example.countrybirds;

public class PajaroDTO {

    String nombre;
    String pais;

    public PajaroDTO(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }
}
