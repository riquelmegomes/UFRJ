package br.com.ufrj.aula10.interfaces;

import br.com.ufrj.aula10.contas.ContaAbstrata;

public interface IRepositorioConta {

    void inserir(ContaAbstrata conta);
    void remover(String numero);
    ContaAbstrata procurar(String numero);
    ContaAbstrata[] listar();
    int numero();

}
