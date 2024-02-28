package br.com.alurasenac.modulo.dao;

import br.com.alurasenac.modulo.produto.DadosDoProduto;
import br.com.alurasenac.modulo.produto.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {

    private Connection conn;

    public ProdutoDAO(Connection connection) {
        this.conn = connection;
    }

    public void salvar (DadosDoProduto dadosDoProduto) {

        var produto = new Produto(dadosDoProduto);
        String sql = "INSERT INTO produto (idproduto, nome, preco,fabricante) VALUES (?,?,?,?)";



        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,produto.getId());
            preparedStatement.setString(2,produto.getNome());
            preparedStatement.setBigDecimal(3,produto.getPreco());
            preparedStatement.setString(4, produto.getFabricante());
            preparedStatement.execute();

            preparedStatement.close();
            conn.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
