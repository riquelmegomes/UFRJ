package br.com.ufrj.estantedelivros.implementacao;

import java.util.Vector;

public class Estante {
    private Vector<Prateleira> prateleiras;

    // Construtor
    public Estante() {
        prateleiras = new Vector<>();
    }

    public void adicionarPrateleira(Prateleira prateleira) {
        prateleiras.add(prateleira);
        System.out.println("Prateleira adicionada à estante!");
    }

    public boolean adicionarLivro(Livro livro) {
        for(Prateleira p : prateleiras) {
            if(p.adicionarLivro(livro)){
                return true;
            }
        }
        System.out.println("Espaço insuficiente nas prateleiras!");
        return false;
    }

    public boolean removerLivro(Livro livro) {
        for(Prateleira p : prateleiras) {
            if(p.removerLivro(livro.getISBN())){
                return true;
            }
        }
        return false;
    }

    public Livro selecionarLivro(String isbn) {
        for(Prateleira p : prateleiras) {
            Livro procurador = p.selecionarLivro(isbn);
            if(procurador != null) {
                return procurador;
            }
        }
        return null;
    }

    public void imprimirLivros() {
        if(prateleiras.size() < 1) System.out.println("Não há prateleiras na estante!");
        else {
            for(Prateleira p : prateleiras) {
                p.imprimirLivros();
            }
        }
    }
}
