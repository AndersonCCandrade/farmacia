package br.com.alurasenac.modulo.dao;

import br.com.alurasenac.modulo.produto.DadosDoProduto;
import br.com.alurasenac.modulo.produto.Produto;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ProdutoDAO {

    private Connection conn;

    public ProdutoDAO(Connection connection) {
        this.conn = connection;
    }

    public Set listar() {
        Set <Produto> produto = new HashSet<>();

        String sql = "SELECT * FROM produto";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                BigDecimal preco = resultSet.getBigDecimal(3);
                String fabricante = resultSet.getString(4);

                DadosDoProduto dadosDoProduto = new DadosDoProduto(id, nome, preco, fabricante);

                produto.add(new Produto(dadosDoProduto));
            }

            resultSet.close();
            preparedStatement.close();
            conn.close();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return produto;
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
