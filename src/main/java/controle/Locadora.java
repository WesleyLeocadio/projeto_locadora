/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Dao.FilmeDao;
import conexao.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.Filme;

/**
 *
 * @author Weslley Leocádio
 */
@ManagedBean
@ApplicationScoped
public class Locadora {

    private Filme filme = new Filme();
    private List<Filme> filmes = new ArrayList<Filme>();
    private List<Filme> f;
    Conexao conexao =  new Conexao();
          FilmeDao filmesDao =  new FilmeDao();

    public Locadora() {
        filme = new Filme();
        
       filmes=filmesDao.listProduto();
    }

    public void addFilme() {
        if (!filmes.contains(filme)) {
          filmes.add(filme);
          filme = new Filme();
        }
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }
    
    public void getConexao() {    
        conexao.conecta();
       
    }   
    public void getDesconectar() {    
        conexao.desconecta();
       
    }   
      public void getLIST() {    
       f= filmesDao.listProduto();
          for (int i = 0; i < f.size(); i++) {
                     System.out.println(f.get(i));
   
          }
    }   
    
    

}
