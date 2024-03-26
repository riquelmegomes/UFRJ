package br.com.ufrj.estantedelivros.implementacao;

// Questão 5
public class Livro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anoDePublicacao;
    private int numeroDaEdicao;
    private int numeroDePaginas;
    private int espessura;

    // Construtor
    public Livro(String isbn, String titulo, String autor, int anoDePublicacao,
                 int numeroDaEdicao, int numeroDePaginas, int espessura) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.numeroDaEdicao = numeroDaEdicao;
        this.numeroDePaginas = numeroDePaginas;
        this.espessura = espessura;
    }

    public String getISBN() {
        return this.isbn;
    }
    public String getTitulo() {
        return this.titulo;
    }
    public String getAutor() {
        return this.autor;
    }
    public int getAnoDePublicacao() {
        return this.anoDePublicacao;
    }
    public int getNumeroDaEdicao() {
        return this.numeroDaEdicao;
    }
    public int getNumeroDePaginas() {
        return this.numeroDePaginas;
    }
    public int getEspessura() {
        return this.espessura;
    }

    public String descricao() {
        return ("ISBN: "+ isbn +" | Livro: "+ titulo + " | Autor: "+ autor +
                " | Ano: "+ anoDePublicacao + " | Edição: "+ numeroDaEdicao +
                "ed | Páginas: "+ numeroDePaginas + " | Espessura: "+ espessura + "cm.");
    }
}
