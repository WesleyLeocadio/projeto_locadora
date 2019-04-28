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
    private int qtdCesta;
    private static int cont = 0;
    private String titulo;
    private Date data;
    private int nota;
    private String descricao;
    private int quantidade;
    private float preco;

    public Filme(int id, int qtdCesta, String titulo, Date data, int nota, String descricao, int quantidade, float preco) {
        this.id = id;
        this.qtdCesta = qtdCesta;
        this.titulo = titulo;
        this.data = data;
        this.nota = nota;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Filme(String titulo, Date data, int nota, String descricao, int quantidade, float preco) {

        this.titulo = titulo;
        this.data = data;
        this.nota = nota;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.id = cont++;
    }

    public int getQtdCesta() {
        return qtdCesta;
    }

    public void setQtdCesta(int qtdCesta) {
        this.qtdCesta = qtdCesta;
    }

    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        Filme.cont = cont;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Filme() {
        this.id = cont++;
        this.qtdCesta = 0;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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

    public void incrementaCesta() {
        this.qtdCesta++;
    }

    public void diminuiCesta() {
        this.qtdCesta--;
    }

    @Override
    public String toString() {
        return "Filme{" + "id=" + id + ", qtdCesta=" + qtdCesta + ", titulo=" + titulo + ", data=" + data + ", nota=" + nota + ", descricao=" + descricao + ", quantidade=" + quantidade + ", preco=" + preco + '}';
    }
    
    

}
