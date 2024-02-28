package br.com.alurasenac.modulo.produto;

import br.com.alurasenac.modulo.dao.ConnectionFactory;
import br.com.alurasenac.modulo.dao.ProdutoDAO;


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
}
