/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Filme;

/**
 *
 * @author Weslley Leocádio
 */
public class FilmeDao {

    private final Conexao con = new Conexao();
    private final String LISTFILME = "SELECT * FROM FILME";
    private final String INSERTFILME = "INSERT INTO FILME (TITULO,DATA_LANCAMENTO,NOTA,DESCRICAO,QUANT) VALUES(?,?,?,?,?)";
    private final String UPDATEQUANTIDADE = "UPDATE FILME SET QUANT = ? WHERE ID = ?";

    public boolean insertCliente(Filme u) {
        try {
            // CONECTA
            con.conecta();

            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTFILME);
            System.out.println("Titulo: " + u.getTitulo() + " Data: " + u.getData() + " nota: " + u.getNota() + " descricao " + u.getDescricao());
            preparaInstrucao.setString(1, u.getTitulo());
            u.setData(new java.util.Date());
            java.sql.Date dataSql = new java.sql.Date(u.getData().getTime());
            preparaInstrucao.setDate(2, dataSql);
            preparaInstrucao.setInt(3, u.getNota());
            preparaInstrucao.setString(4, u.getDescricao());
            preparaInstrucao.setInt(5, u.getQuantidade());

            // EXECUTA A INSTRUCAO
            preparaInstrucao.execute();
            System.out.println("inseriu");
            // DESCONECTA
            con.desconecta();

            return true;

        } catch (SQLException e) {
            return false;

        }

    }

    public boolean updateQuantidade(int u, int id) {
        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(UPDATEQUANTIDADE);
            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setInt(1, u);
            preparaInstrucao.setInt(2, id);

            // EXECUTA A INSTRUCAO
            preparaInstrucao.execute();
            System.out.println("atualizaou a quantidade");

            // DESCONECTA
            con.desconecta();

            return true;

        } catch (SQLException e) {
            return false;

        }

    }

    public ArrayList<Filme> listProduto() {
        ArrayList<Filme> filmes = new ArrayList<>();

        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTFILME);

            // EXECUTA A INSTRUCAO
            ResultSet rs = preparaInstrucao.executeQuery();
            //TRATA O RETORNO DA CONSULTA
            while (rs.next()) { //enquanto houver registro
                Filme u = new Filme(rs.getInt("id"), rs.getString("titulo"), rs.getDate("data_lancamento"), rs.getInt("nota"), rs.getString("descricao"), rs.getInt("quant"));
                System.out.println(u);
                filmes.add(u);
            }
            // DESCONECTA
            con.desconecta();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        ///////////////////Collections.sort(lista);/////////////////////////
        return filmes;
    }

}
