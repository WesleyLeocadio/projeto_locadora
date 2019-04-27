/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

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

    public Locadora() {
        filme = new Filme();
        Date date1 = new GregorianCalendar(2019, Calendar.JANUARY, 03).getTime();
        Date date2 = new GregorianCalendar(2019, Calendar.JANUARY, 23).getTime();
        Date date3 = new GregorianCalendar(2019, Calendar.MARCH, 11).getTime();

        Filme f1 = new Filme("Titanic", date1, 3, "Filme ganhador de osca", 10, 5);
        Filme f2 = new Filme("Alto da compadecida", date2, 9, "Filme ganhador de osca", 10, 4);
        Filme f3 = new Filme("Mario o esquecido", date3, 2, "Filme bom", 10, 5);
        filmes.add(f1);
        filmes.add(f2);
        filmes.add(f3);
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

}
