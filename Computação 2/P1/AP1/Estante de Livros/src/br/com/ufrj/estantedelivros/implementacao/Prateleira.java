package br.com.ufrj.estantedelivros.implementacao;

import java.util.Vector;

public class Prateleira {
    private int tamanhoMaximo;
    private Vector<Livro> livros;

    // Construtor
    public Prateleira(int tamanho) {
        this.tamanhoMaximo = tamanho;
        livros = new Vector<>();
    }

    protected int espacoLivre() {
        int espacoVago = tamanhoMaximo;

        for (Livro l : livros) {
            espacoVago -= l.getEspessura();
        }
        return espacoVago;
    }

    public boolean adicionarLivro(Livro livro) {
        if (livro.getEspessura() <= espacoLivre()) {
            livros.add(livro);
            System.out.println("Livro adicionado à prateleira!");
            espacoLivre();
            return true;
        }
        System.out.println("Espaço insuficiente na prateleira!");
        return false;
    }

    public boolean removerLivro(String isbn) {
        for (Livro l : livros) {
            if ((l.getISBN()).equals(isbn)) {
                livros.remove(l);
                System.out.println("Livro removido da prateleira!");
                espacoLivre();
                return true;
            }
        }
        System.out.println("Livro não encontrado!");
        return false;
    }

    public Livro selecionarLivro(String isbn) {
        for (Livro l : livros) {
            if ((l.getISBN()).equals(isbn)) {
                System.out.println("Livro encontrado!");
                return l;
            }
        }
        System.out.println("Livro não encontrado!");
        return null;
    }

    public void imprimirLivros() {
        if (livros.size() < 1) System.out.println("Não há livros na prateleira!");
        else {
            for (Livro l : livros) {
                System.out.println(l.descricao());
            }
        }
    }
}
