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
				Filme u = new Filme(rs.getInt("ID"),rs.getInt("QTDCESTA"),rs.getString("TITULO"),rs.getDate("DATA_LAN"),rs.getInt("NOTA"),rs.getString("DESCRICAO"),rs.getInt("QUANTIDADE"),rs.getFloat("PRECO"));
				
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
