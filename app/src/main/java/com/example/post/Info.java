package com.example.post;

public class Info {

    private String area_km2;
    private int codigo_ibge;
    private String nome;


    public Info(String area_km2, int codigo_ibge, String nome) {
        this.area_km2 = area_km2;
        this.codigo_ibge = codigo_ibge;
        this.nome = nome;
    }

    public String getArea_km2() {
        return area_km2;
    }

    public void setArea_km2(String area_km2) {
        this.area_km2 = area_km2;
    }

    public int getCodigo_ibge() {
        return codigo_ibge;
    }

    public void setCodigo_ibge(int codigo_ibge) {
        this.codigo_ibge = codigo_ibge;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
