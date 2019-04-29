/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Dao.FilmeDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.JOptionPane;
import modelo.Filme;

/**
 *
 * @author Weslley Leocádio
 */
@ManagedBean
@SessionScoped
public class Cesta {

    private float valor;
    private List<Filme> cesta = new ArrayList<Filme>();
    FilmeDao filmesDao = new FilmeDao();
    Filme filme;

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public FilmeDao getFilmesDao() {
        return filmesDao;
    }

    public void setFilmesDao(FilmeDao filmesDao) {
        this.filmesDao = filmesDao;
    }

    private int quantidadeCesta=0;

    public int getQuantidadeCesta() {
        return quantidadeCesta;
    }

    public void setQuantidadeCesta(int quantidadeCesta) {
        this.quantidadeCesta = quantidadeCesta;
    }

    public List<Filme> getCesta() {
        return cesta;
    }

    public void setCesta(List<Filme> cesta) {
        this.cesta = cesta;
    }
    int q = 0;

    public void addFilme(Filme f) {
       
         System.out.println("Quantidade add antes: "+f.getQuantidade());
            quantidadeCesta++;
            q--;
            filmesDao.updateQuantidade(f.getQuantidade()-1, f.getId());
            f.setQuantidade(f.getQuantidade()-1);
            cesta.add(f);

    }

    public void removerFilme(Filme f) {

        quantidadeCesta--;
        
        filmesDao.updateQuantidade(f.getQuantidade()+1, f.getId());
        f.setQuantidade(f.getQuantidade()+1);
        cesta.remove(f);
    }

    public void limpar() {

        for (int i = 0; i < cesta.size(); i++) {

             filmesDao.updateQuantidade(cesta.get(i).getQuantidade()+1, cesta.get(i).getId());
            
        
            cesta.remove(filme);

        }
        quantidadeCesta=0;
        cesta = new ArrayList<>();
        valor = 0;
    }

    public void finalizarCompra() {

        valor = quantidadeCesta * 5;
    }

}
