package br.com.alurasenac.modulo.produto;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {

    private Integer id;
    private BigDecimal preco;
    private String nome;
    private String fabricante;

    public Produto(DadosDoProduto dadosDoProduto) {
        this.id = dadosDoProduto.id();
        this.preco = dadosDoProduto.preco();
        this.nome = dadosDoProduto.nome();
        this.fabricante = dadosDoProduto.fabricante();
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
        return "Produto{" +
                "id=" + id +
                ", preco=" + preco +
                ", nome='" + nome + '\'' +
                ", fabricante='" + fabricante + '\'' +
                '}';
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
