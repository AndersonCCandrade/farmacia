package br.com.alurasenac.modulo.produto;

import java.math.BigDecimal;

public record DadosDoProduto(Integer id, String nome, BigDecimal preco, String fabricante) {

}
