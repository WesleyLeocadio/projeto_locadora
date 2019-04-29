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
    private final String INSERTFILME = "INSERT INTO FILME (TITULO,DATA_LANCAMENTO,NOTA,DESCRICAO,QUANT,PRECO,QUANTCESTA) VALUES(?,?,?,?,?,?,?)";

    public boolean insertCliente(Filme u) {
        try {
            // CONECTA
            con.conecta();
           
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTFILME);
            System.out.println("Titulo: " + u.getTitulo() + " Data: " + u.getData() + " nota: " + u.getNota() + " descricao " + u.getDescricao());
            preparaInstrucao.setString(1, u.getTitulo());
            preparaInstrucao.setString(2, u.getData());
            preparaInstrucao.setInt(3, u.getNota());
            preparaInstrucao.setString(4, u.getDescricao());
            preparaInstrucao.setInt(5, u.getQuantidade());
            preparaInstrucao.setFloat(6, u.getPreco());
            preparaInstrucao.setInt(7, 0);
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
                Filme u = new Filme(rs.getInt("id"), rs.getString("titulo"), rs.getString("data_lancamento"), rs.getInt("nota"), rs.getString("descricao"), rs.getInt("quant"), rs.getFloat("preco"), rs.getInt("quantcesta"));
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
    
     
    //Tenta encontrar um filme
    public Filme encontrar(int id) {
        con.conecta();
        String query = " SELECT * FROM filme where id =?";
        try {

            PreparedStatement pst = con.getConexao().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int x = rs.getInt(1);
                if (x == id) {
                    System.out.println("FILME ENCONTRADO");
                    Filme f = new Filme();
                    f.setId(rs.getInt(1));
                    f.setTitulo(rs.getString(2));
                    f.setString(rs.getDate(3));
                    f.setNota(rs.getInt(4));
                    f.setDescricao(rs.getString(5));
                    f.setQuantidade(rs.getInt(6));

                    return f;
                }
            }
        } catch (SQLException ex) {
            System.out.println("LoginFromVendedor não deu certo");
            //Logger.getLogger(VendedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Vendedor não foi encontrado");
        con.desconecta();
        return null;
    }


}
