package br.com.ufrj.estantedelivros.teste;

import br.com.ufrj.estantedelivros.implementacao.Livro;

public class TestaLivro {
    public static void main(String[] args) {
        Livro meuLivro = new Livro("18082021","Programação Orientada a Objetos",
                "Anderson Uchôa", 24021, 1,
                200, 10);

        System.out.println("ISBN: " + meuLivro.getISBN());
        System.out.println("Titulo: " + meuLivro.getTitulo());
        System.out.println("Autor: " + meuLivro.getAutor());
        System.out.println("Ano de publicação: " + meuLivro.getAnoDePublicacao());
        System.out.println("Número da edição: " + meuLivro.getNumeroDaEdicao() + "ed");
        System.out.println("Número de páginas: " + meuLivro.getNumeroDePaginas());
        System.out.println("Espessura: " + meuLivro.getEspessura() + "cm");
        System.out.println("\nDescrição\n" + meuLivro.descricao());
    }
}
