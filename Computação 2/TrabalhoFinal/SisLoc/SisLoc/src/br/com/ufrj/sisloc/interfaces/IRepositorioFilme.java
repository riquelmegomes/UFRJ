package br.com.ufrj.sisloc.interfaces;

import br.com.ufrj.sisloc.implementação.Filme;
import java.util.Vector;

public interface IRepositorioFilme {
    void cadastrar(Filme filme);
    Filme buscar(int codigo);
    void atualizar(Filme filme);
    void deletar(int codigo);
    Vector<Filme> listar();
}
