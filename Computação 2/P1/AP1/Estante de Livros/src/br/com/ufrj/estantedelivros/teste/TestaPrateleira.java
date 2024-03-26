package br.com.ufrj.estantedelivros.teste;

import br.com.ufrj.estantedelivros.implementacao.*;

public class TestaPrateleira {
    public static void main(String[] args) {
        Livro livro1 = new Livro("18082021","Programação Orientada a Objetos",
                "Anderson Uchôa", 2020, 1,
                200, 10);
        Livro livro2 = new Livro("20210818","Resolvendo questões da AP1",
                "Riquelme Gomes", 2021, 2,
                100, 20);
        Livro livro3 = new Livro("12345678","Apostila Caelum POO - Java",
                "Professor X", 2019, 1,
                368, 30);

        Prateleira prateleira = new Prateleira(50);

        prateleira.adicionarLivro(livro1);
        prateleira.adicionarLivro(livro2);
        prateleira.adicionarLivro(livro3); // com a adição desse livro ultrapassaríamos o tamanho máximo de 50
        prateleira.imprimirLivros();
        prateleira.selecionarLivro("18082021");
        prateleira.removerLivro("18082021");
        prateleira.selecionarLivro("18082021");  // Esse livro já foi removido, logo não é encontrado
        prateleira.removerLivro("20210818");
        prateleira.imprimirLivros();  // A prateleira está vazia

    }
}
