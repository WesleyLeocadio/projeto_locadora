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

    private List<Filme> cesta = new ArrayList<Filme>();
    
    FilmeDao filmesDao =  new FilmeDao();
    
    private int quantidadeCesta;

    public int getQuantidadeCesta() {
        return quantidadeCesta;
    }

    public void setQuantidadeCesta(int quantidadeCesta) {
        this.quantidadeCesta = quantidadeCesta;
    }
    
    private float total;

    public List<Filme> getCesta() {
        return cesta;
    }

    public void setCesta(List<Filme> cesta) {
        this.cesta = cesta;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    

    public void addFilme(Filme f) {
        int q;
            if (f.getQuantidade() > 1) {
                quantidadeCesta++;
                
                q=f.getQuantidade();
                q--;
                filmesDao.updateQuantidade(q, f.getId());
                cesta.add(f);
                
            }else{
            
                System.out.println(" Não tem mais filmes");
            }
        }
    
           
           
  
    

    public void removerFilme(int id) {

//        Filme f = pegarFilme(id);
//        if (f.getQtdCesta() > 1) {
//            f.incrementaEstoque();
//            f.setQtdCesta(f.getQtdCesta() - 1);
//        } else {
//            cesta.remove(f);
//            f.incrementaEstoque();
//        }

    }
    
    
    
    public void limpar(){
    
//        for (int i = 0; i <cesta.size(); i++) {
//            cesta.get(i).setQuantidade(cesta.get(i).getQtdCesta()+cesta.get(i).getQuantidade());
//            cesta.get(i).setQtdCesta(0);
//        }
//        
//        total = 0;
//        cesta =  new ArrayList<>();
    }
    
    
    
    public void finalizarCompra(){
    
//        for (int i = 0; i < cesta.size(); i++) {
//            for (int j = 0; j < cesta.get(i).getQtdCesta; j++) {
//                total+=cesta.get(i).getPreco();
//            }
//        }
    }
}
