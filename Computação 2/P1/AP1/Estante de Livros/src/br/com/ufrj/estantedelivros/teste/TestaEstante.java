package br.com.ufrj.estantedelivros.teste;

import br.com.ufrj.estantedelivros.implementacao.*;

public class TestaEstante {
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
        Prateleira prateleira2 = new Prateleira(50);
        Estante estante = new Estante();

        estante.adicionarPrateleira(prateleira);
        estante.adicionarPrateleira(prateleira2);
        estante.adicionarLivro(livro1);
        estante.adicionarLivro(livro2);
        estante.adicionarLivro(livro3); // Não há espaço suficiente na prateleira1, então ele irá para a prateleira2
        estante.removerLivro(livro2);  // Removendo livro2 da prateleira1
        estante.selecionarLivro("00000000"); // Procurando livro que não existe, não é encontrado em nenhuma das
        // duas prateleiras
        estante.selecionarLivro("18082021");
        estante.selecionarLivro("12345678"); // Livro encontrado somente na segunda prateleira
        estante.imprimirLivros();

    }
}
