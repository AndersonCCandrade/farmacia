package br.com.alurasenac.modulo.produto;

import br.com.alurasenac.modulo.dao.ConnectionFactory;
import br.com.alurasenac.modulo.dao.ProdutoDAO;
import br.com.alurasenac.modulo.exception.RegraDeNegocioException;


import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Set;

public class ProdutoService {

    private ConnectionFactory connection;

    public ProdutoService() {
        this.connection = new ConnectionFactory();
    }

    public Set<Produto> listarProdutos () {

        Connection conn = connection.recuperarConexao();
        return new ProdutoDAO(conn).listar();
    }

    public void cadastraProduto(DadosDoProduto dadosDoProduto) {

        Connection conn = connection.recuperarConexao();
        new ProdutoDAO(conn).salvar(dadosDoProduto);

    }

    public void alterarValorDoProduto(Integer id, BigDecimal valor) {
        var produto = listarProdutoPorID(id);

        Connection conn = connection.recuperarConexao();
        new ProdutoDAO(conn).alterar(produto.getId(),valor);
    }

    private Produto listarProdutoPorID(Integer id){

        Connection conn = connection.recuperarConexao();
        Produto produto = new ProdutoDAO(conn).listarPorID(id);

        if (produto != null){
            return produto;
        } else {
            throw new RegraDeNegocioException("Não existe produto cadastrada com esse número!");
        }


    }

}
