package br.com.alurasenac.modulo.dao;

import br.com.alurasenac.modulo.produto.DadosDoProduto;
import br.com.alurasenac.modulo.produto.DadosDoProdutoID;
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

                DadosDoProdutoID dadosDoProdutoID = new DadosDoProdutoID(id, nome, preco, fabricante);

                produto.add(new Produto(dadosDoProdutoID));
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
        String sql = "INSERT INTO produto (nome, preco,fabricante) VALUES (?,?,?)";


        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,produto.getNome());
            preparedStatement.setBigDecimal(2,produto.getPreco());
            preparedStatement.setString(3, produto.getFabricante());
            preparedStatement.execute();

            preparedStatement.close();
            conn.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void alterar(Integer id, BigDecimal valor){
        String sql = "UPDATE produto SET preco = ? WHERE idproduto = ?";

        try {
            conn.setAutoCommit(false);

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setBigDecimal(1, valor);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();

            conn.commit();
            preparedStatement.close();
            conn.close();

        }catch (SQLException e){
            try{
                conn.rollback();
            }catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    public Produto listarPorID (Integer id){
        Produto produto = null;

        String sql = "SELECT * FROM produto WHERE idproduto = ?";

        try{
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer idproduto = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                BigDecimal preco = resultSet.getBigDecimal(3);
                String fabricante = resultSet.getString(4);

                DadosDoProdutoID dadosDoProdutoID = new DadosDoProdutoID(idproduto, nome, preco, fabricante);

                produto = new Produto(dadosDoProdutoID);
            }

            resultSet.close();
            preparedStatement.close();
            conn.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return produto;
    }

    public void excluir(Integer id) {
        String sql = "DELETE FROM produto WHERE idproduto = ?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();

            preparedStatement.close();
            conn.close();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
