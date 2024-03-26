package br.com.ufrj.aula10.bancos;

import br.com.ufrj.aula10.contas.ContaAbstrata;
import br.com.ufrj.aula10.interfaces.IRepositorioConta;

import java.util.Vector;

public class VectorContas implements IRepositorioConta {
    final private Vector<ContaAbstrata> contas;

    public VectorContas() {
        contas = new Vector<>();
    }

    public void inserir(ContaAbstrata conta) {
        contas.add(conta);
        System.out.println("Conta cadastrada com sucesso!");
    }

    public void remover(String numero) {
        ContaAbstrata conta;
        conta = procurar(numero);
        if(conta != null) {
            for (ContaAbstrata c : contas) {
                if (c.numero().equals(numero)) {
                    contas.remove(c);
                    System.out.println("Conta removida com sucesso!");
                    break;
                }
            }
        }
    }

    public ContaAbstrata procurar(String numero) {
        for (ContaAbstrata c : contas) {
            if (c.numero().equals(numero)) return c;
        }
        System.out.println("Conta não encontrada");
        return null;
    }

    public ContaAbstrata[] listar() {
        int tamanhoVector = this.contas.size();
        ContaAbstrata[] lista = null;

        if (tamanhoVector > 0) {
            lista = new ContaAbstrata[tamanhoVector];
            for(int i = 0; i < tamanhoVector; i++) {
                lista[i] = this.contas.elementAt(i);
            }
        }
        return lista;
    }

    public int numero() {
        return contas.size();
    }
}
