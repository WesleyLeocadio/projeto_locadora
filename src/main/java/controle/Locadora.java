/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Dao.FilmeDao;
import conexao.Conexao;
import java.util.ArrayList;
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
    Conexao conexao = new Conexao();
    FilmeDao filmesDao = new FilmeDao();

    public Locadora() {
        filme = new Filme();

        filmes = filmesDao.listProduto();
    }

    public void addFilme() {
        
        filmesDao.insertCliente(filme);
        filmes=filmesDao.listProduto(); 
        filme= new Filme();

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
        filme.setTitulo("");
        filme.setData(null);
        filme.setNota(0);
        filme.setDescricao("");
        filme.setQuantidade(0);
       
    }

}
