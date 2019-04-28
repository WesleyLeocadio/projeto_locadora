
import Dao.FilmeDao;
import conexao.Conexao;
import java.util.List;
import modelo.Filme;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Weslley Leocádio
 */
public class testes {
    public static void main(String[] args) {
     Filme  filme= new Filme();
    Conexao conexao =  new Conexao();
          FilmeDao filmesDao =  new FilmeDao();
            List<Filme> f;
            f=filmesDao.listProduto();
            System.out.println(f.get(0));
            
    }
}
