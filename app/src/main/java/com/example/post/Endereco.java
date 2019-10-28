package com.example.post;

public class Endereco {

    private String bairro;
    private String cidade;
    private String logradouro;
    private String estado;
    private String cep;
    private Info cidade_info;
    private Info estado_info;

    public Endereco(String bairro, String cidade, String logradouro, String estado, String cep,
                    Info cidade_info, Info estado_info) {

        this.bairro = bairro;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.estado = estado;
        this.cep = cep;
        this.cidade_info = cidade_info;
        this.estado_info = estado_info;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Info getCidade_info() {
        return cidade_info;
    }

    public void setCidade_info(Info cidade_info) {
        this.cidade_info = cidade_info;
    }

    public Info getEstado_info() {
        return estado_info;
    }

    public void setEstado_info(Info estado_info) {
        this.estado_info = estado_info;
    }
}
