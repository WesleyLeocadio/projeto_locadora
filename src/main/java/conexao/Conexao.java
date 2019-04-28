package conexao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
	
	private static final String DRIVER = "org.postgresql.Driver";   
	private static final String URL = "jdbc:postgresql://ec2-23-23-228-132.compute-1.amazonaws.com:5432/ddclsrcpqi1isj";   
	private static final String USERNAME = "fpqsqatodpeudh";   
	private static final String PASSWORD = "5d76e04397242d665c2f3ffbea8135ef6577af080d542f55df12d9c9ab910016"; 
		private Connection conexao;

	public void conecta() {
		try {
			Class.forName(DRIVER); //Carrega o driver (inicializa um objeto da classe org.postgresql.Driver) 
			conexao = DriverManager.getConnection(URL, USERNAME,PASSWORD); //Cria a conexao
                        System.out.println("conectou ao banco");
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e);
                        System.out.println("Nao conectou");
		}
	}
        
        //METODO QUE DESCONECTA O BANCO DE DADOS
	public void desconecta() {
		try {   
			conexao.close();//fecha a conexao
                        System.out.println("desconectou!");
		} catch (SQLException ex) {
			System.err.println(ex);
                        System.out.println("continua conectado");
		}
	}

	public Connection getConexao() {
		return conexao;
	}
        
}