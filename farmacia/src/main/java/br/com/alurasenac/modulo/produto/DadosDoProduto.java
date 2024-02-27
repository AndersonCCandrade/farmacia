package br.com.alurasenac.modulo.produto;

import java.math.BigDecimal;
public record DadosDoProduto(Integer id, BigDecimal preco, String nome, String fabricante) {

}
