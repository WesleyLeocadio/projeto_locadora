/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Weslley Leocádio
 */
public class Filme {

    private int id;
    private String titulo;
    private String data;
    private int nota;
    private String descricao;
    private int quantidade;
    

    public Filme(int id, String titulo, String data, int nota, String descricao, int quantidade) {
        this.id = id;
        this.titulo = titulo;
        this.data = data;
        this.nota = nota;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Filme(String titulo, String data, int nota, String descricao, int quantidade) {

        this.titulo = titulo;
        this.data = data;
        this.nota = nota;
        this.descricao = descricao;
        this.quantidade = quantidade;
        
    }

    public Filme() {
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void incrementaEstoque() {
        this.quantidade++;
    }

    public void diminuiEstoque() {
        this.quantidade--;
    }

    @Override
    public String toString() {
        return "Filme{" + "id=" + id + ", titulo=" + titulo + ", data=" + data + ", nota=" + nota + ", descricao=" + descricao + ", quantidade=" + quantidade + '}';
    }

    public void setString(java.sql.Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    

}
