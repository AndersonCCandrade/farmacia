package br.com.alurasenac.modulo.produto;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {

    private Integer id;
    private String nome;
    private BigDecimal preco;
    private String fabricante;

    public Produto(DadosDoProduto dadosDoProduto) {
        this.nome = dadosDoProduto.nome();
        this.preco = dadosDoProduto.preco();
        this.fabricante = dadosDoProduto.fabricante();
    }

    public Produto(DadosDoProdutoID dadosDoProdutoid) {
        this.id = dadosDoProdutoid.id();
        this.nome = dadosDoProdutoid.nome();
        this.preco = dadosDoProdutoid.preco();
        this.fabricante = dadosDoProdutoid.fabricante();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Produto : " +
                "ID do Produto: " + id +
                " Preço: R$ " + preco +
                " Nome: " + nome +
                " Fabricante: " + fabricante;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public String getFabricante() {
        return fabricante;
    }
}
