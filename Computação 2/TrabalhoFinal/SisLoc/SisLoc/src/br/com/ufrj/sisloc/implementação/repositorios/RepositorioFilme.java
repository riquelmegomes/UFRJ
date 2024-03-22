package br.com.ufrj.sisloc.implementação.repositorios;

import br.com.ufrj.sisloc.implementação.Filme;
import br.com.ufrj.sisloc.interfaces.IRepositorioFilme;

import java.util.Vector;

public class RepositorioFilme implements IRepositorioFilme {
    private final Vector<Filme> filmes;

    // Construtor
    public RepositorioFilme() {
        filmes = new Vector<>();
    }

    @Override
    /* Método responsável por cadastrar um filme. Restrição: não são cadastrados filmes com o mesmo código, isto é o
    código é um identificador único. */
    public void cadastrar(Filme filme) {
        Filme filmeBuscado = buscar(filme.getCodigo());
        if(filmeBuscado == null) {
            filmes.add(filme);
            System.out.println("Filme cadastrado com sucesso!");
        }
        else System.out.println("Erro! Filme já cadastrado em nosso sistema.");
    }

    @Override
    /* Método responsável por procurar um filme pelo seu código. Retorna o filme solicitado ou null em caso contrário */
    public Filme buscar(int codigo) {
        for(Filme filme : filmes) {
            if(filme.getCodigo() == codigo) return filme;
        }
        return null;
    }

    @Override
    /* Método responsável por fazer a atualização do filme. Restrição: a atualização só ocorre se o filme já estiver
    cadastrado. */
    public void atualizar(Filme filme) {
        if(buscar(filme.getCodigo()) != null) {
            for(int i = 0; i < filmes.size(); i++) {
                if(filmes.get(i).getCodigo() == filme.getCodigo()) {
                    filmes.set(i, filme);
                    System.out.println("Filme atualizado com sucesso!");
                }
            }
        }
        else System.out.println("Erro! Filme não encontrado.");
    }

    @Override
    /* Método responsável por deletar um filme. Restrição: o filme só é deletado se já estiver cadastrado. */
    public void deletar(int codigo) {
        Filme filmeBuscado = buscar(codigo);
        if(filmeBuscado != null) {
            filmes.remove(filmeBuscado);
            System.out.println("Filme removido com sucesso!");
        }
        else System.out.println("Erro! Filme não cadastrado em nosso sistema.");
    }

    @Override
    /* Método responsável por retornar a lista de todos os filmes cadastrados. */
    public Vector<Filme> listar() {
        return filmes;
    }

}