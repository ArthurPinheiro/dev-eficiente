package com.deveficiente.casadocodigo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarrinhoDeComprasDTO {
    
    private Long id;
    private String titulo;
    private BigDecimal preco;
    private int quantidade = 1;

    @Deprecated
    public CarrinhoDeComprasDTO(){}

    public CarrinhoDeComprasDTO(Livro livro){
        id = livro.getId();
        titulo = livro.getTitulo();
        preco = livro.getPreco();
    }

	public Long getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public BigDecimal getTotal() {
    	return preco.multiply(new BigDecimal(quantidade));
	}


	@Override
	public String toString() {
		return "LivroCarrinhoDTO [titulo=" + titulo + ", preco=" + preco  +"]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CarrinhoDeComprasDTO that = (CarrinhoDeComprasDTO) o;
		return Objects.equals(titulo, that.titulo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	public void incrementa() {
    	this.quantidade++;
	}

	public void atualizaQuantidade(int novaQuantidade) {
    	this.quantidade = novaQuantidade;
    }
}