/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;

import Produtos.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilherme
 */
public class ProdutoDAO {

    private Produto prod = new Produto();
    private ConexaoBD conexao;

    public ProdutoDAO() {
        this.conexao = new ConexaoBD();
    }

    public Produto getProduto(String ean) throws SQLException {
        String sql = "select filprd.id as referencia, codbarra, shortname as shortname, "
                + "prod.venda as valor_venda from filprd, "
                + "(select filprdcod.id, filprdcod.idprd, codbarra, filtpp.venda from "
                + "filprdcod, (select id, idprd, venda from filtpp where idtab = 28) AS  "
                + "filtpp where filprdcod.id = filtpp.idprd and codbarra = '"+ ean +"') "
                + "as prod where filprd.id = idprd";
        PreparedStatement stmt = conexao.getConexao().
                prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            // criando o objeto Contato
            prod.setFerencia(rs.getString("referencia"));
            prod.setEan(rs.getString("codbarra"));
            prod.setDescricao(rs.getString("shortname"));
            prod.setPreco(rs.getString("valor_venda"));

        }

        rs.close();
        stmt.close();
        conexao.desconectar();
        return prod;
    }

}
