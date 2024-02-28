package br.com.alurasenac.modulo.produto;

import br.com.alurasenac.modulo.dao.ConnectionFactory;
import br.com.alurasenac.modulo.dao.ProdutoDAO;


import java.sql.Connection;

public class ProdutoService {

    private ConnectionFactory connection;

    public ProdutoService() {
        this.connection = new ConnectionFactory();
    }

    public void cadastraProduto(DadosDoProduto dadosDoProduto) {

        Connection conn = connection.recuperarConexao();
        new ProdutoDAO(conn).salvar(dadosDoProduto);

    }
}
