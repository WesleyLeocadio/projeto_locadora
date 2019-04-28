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
            private final String LISTFILME= "SELECT * FROM FILME";
    private final String INSERTCLIENTE = "INSERT INTO FILME (QTDCESTA,TITULO,DATA_LAN,NOTA,DESCRICAO,QUANTIDADE,PRECO) VALUES(0,'Velozes e furiozos','2002-02-05',5,'Ação',10,5)";

    public boolean insertCliente() {
        try {
            // CONECTA
            con.conecta();

            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTCLIENTE);

           

            // EXECUTA A INSTRUCAO
            preparaInstrucao.execute();
              
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
				Filme u = new Filme(rs.getInt("id"),rs.getInt("qtdcesta"),rs.getString("titulo"),rs.getDate("data_lan"),rs.getInt("nota"),rs.getString("descricao"),rs.getInt("quantidade"),rs.getFloat("preco"));
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
