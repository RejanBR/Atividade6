package br.com.alurasenac.farmacia.dao;

import br.com.alurasenac.farmacia.modelo.Produto;
import com.mysql.cj.jdbc.ConnectionImpl;
import com.mysql.cj.jdbc.DatabaseMetaData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class ProdutoDao {
    public void salvar(Produto produto) {
        String sql = "INSERT INTO produtos (nome, preco) VALUES (?, ?)";

        DatabaseMetaData ConnectionFactory;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());

            stmt.executeUpdate();
            System.out.println("Produto salvo com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar produto: " + e.getMessage());

        try {
            ConnectionImpl conn;
            String sql;
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            Produto produtoNovo;
            preparedStatement.setDouble(1, produtoNovo.getPreco());
            preparedStatement.setString(2, produtoNovo.getNome());
            preparedStatement.setString(3, produtoNovo.getFabricante());

            preparedStatement.execute();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public <Set> Set<Produto> listar() {
        PreparedStatement ps;
        ResultSet resultSet;
        Set<Produto> produtos = new HashSet<>();

        String sql = "SELECT * FROM produtos";

        try {
            ConnectionImpl conn;
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                float preco = resultSet.getFloat(2);
                String nome = resultSet.getString(3);
                String fabricante = resultSet.getString(4);

                ((HashSet<?>) produtos).add(new Produto(preco, nome, fabricante));
            }
            resultSet.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produtos;
    }

    public Produto listarPorNome(String nomeConsultar) {
        String sql = "SELECT * FROM produtos WHERE nome = '" + nomeConsultar+"'";// + " and esta_ativa = true";

        PreparedStatement ps;
        ResultSet resultSet;
        Produto produto = null;
        try {
            ConnectionImpl conn;
            ps = conn.prepareStatement(sql);
            //ps.setInt(1, nome);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                float preco = resultSet.getFloat(2);
                String nome = resultSet.getString(3);
                String fabricante = resultSet.getString(4);

                produto = new Produto(preco, nome, fabricante);
            }
            resultSet.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produto;
    }

    public void alterarValor(String nome, Float valor) {
        PreparedStatement ps;
        String sql = "UPDATE produtos SET preco = ? WHERE nome = ?";

        Connection conn;
        try {
            conn.setAutoCommit(false);

            ps = conn.prepareStatement(sql);

            ps.setFloat(1, valor);
            ps.setString(2, nome);

            ps.execute();
            ps.close();
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    public void alterarFabricante(String nome, String String fabricante;
        fabricante) {
        PreparedStatement ps;
        String sql = "UPDATE produtos SET fabricante = ? WHERE nome = ?";

        Connection conn;
        try {
            conn.setAutoCommit(false);

            ps = conn.prepareStatement(sql);

            ps.setString(1, fabricante);
            ps.setString(2, nome);


            ps.execute();
            ps.close();
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    public void remove(String produto) {
        PreparedStatement ps;
        String sql = "DELETE FROM produtos WHERE nome = ?";

        Connection conn;
        try {
            conn.setAutoCommit(false);

            ps = conn.prepareStatement(sql);

            ps.setString(1, produto);


            ps.execute();
            ps.close();
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }
}

    private boolean listar() {
        return false;
    }