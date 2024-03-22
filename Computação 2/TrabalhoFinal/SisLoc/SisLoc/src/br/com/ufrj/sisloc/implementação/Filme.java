package br.com.ufrj.sisloc.implementação;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class Filme {
    private int codigo;
    private String titulo;
    private Vector<String> genero;
    private Date dataLancamento;
    private String diretor;
    private Vector<String> atores;
    private String sinopse;
    private Vector<String> produtores;
    private float precoLocacao;
    private int numeroCopias;

    // Construtor
    public Filme(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setGenero(Vector<String> genero) {
        this.genero = genero;
    }

    public Vector<String> getGenero() {
        return this.genero;
    }

    public void addGenero(String genero) {
        this.genero.add(genero);
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Date getDataLancamento() {
        return this.dataLancamento;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getDiretor() {
        return this.diretor;
    }

    public void setAtores(Vector<String> atores) {
        this.atores = atores;
    }

    public Vector<String> getAtores() {
        return this.atores;
    }

    public void addAtor(String ator) {
        this.atores.add(ator);
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getSinopse() {
        return this.sinopse;
    }

    public void setProdutores(Vector<String> produtores) {
        this.produtores = produtores;
    }

    public Vector<String> getProdutores() {
        return this.produtores;
    }

    public void addProdutor(String produtor) {
        this.produtores.add(produtor);
    }

    public void setPrecoLocacao(float precoLocacao) {
        this.precoLocacao = precoLocacao;
    }

    public float getPrecoLocacao() {
        return this.precoLocacao;
    }

    public void setNumeroCopias(int numeroCopias) {
        this.numeroCopias = numeroCopias;
    }

    public int getNumeroCopias() {
        return this.numeroCopias;
    }

    /* Método que imprime um resumo do filme, isto é, seus atributos  */
    public void imprimir() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("\nTítulo: " + this.titulo + "\nCódigo: " + this.codigo + "\nGêneros: " + this.genero +
                "\nData de lançamento: " + df.format(this.dataLancamento) + "\nAtores: " + this.atores + "\nDiretor: "
                + this.diretor + "\nProdutores: " + this.produtores + "\nSinopse: " + this.sinopse
                + "\nPreço de locação: R$ " + this.precoLocacao + "\nNúmero de cópias: " + this.numeroCopias);
    }
}
