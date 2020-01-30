package com.deveficiente.casadocodigo.domain;

public class CategoriaDetalheDTO {

    private String nome;

    public CategoriaDetalheDTO(Categoria categoria){
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }
}
